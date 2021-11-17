package com.qlynhansu.Controller;

import java.io.IOException;
import java.util.ArrayList;

import com.qlynhansu.Model.BEAN.Employee;
import com.qlynhansu.Model.BO.EmployeeBO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RemoveEmployeeServlet
 */
@WebServlet ({"/rmEmp"})
public class RemoveEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final EmployeeBO Instance = EmployeeBO.getInstance();
    /**
     * Default constructor. 
     */
    public RemoveEmployeeServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String idnv = request.getParameter("idnv");
		if(idnv!=null) {
			if(Instance.removeEmployee(idnv) > 0) {
				response.sendRedirect(request.getContextPath() + "/rmEmp");
			}
		} else {
			ArrayList<Employee> empList = Instance.getListEmployee();
			request.setAttribute("empList", empList);
			String destination = null;
			String multiple = request.getParameter("multiple");
			if(multiple!=null) {
				destination = "/WEB-INF/VIEW/Admin/removeAllEmployee.jsp";
			} else {
				destination = "/WEB-INF/VIEW/Admin/removeEmployee.jsp";
			}
			request.getRequestDispatcher(destination).forward(request, response);
		}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String[] idnvs = request.getParameterValues("IDNVs");
		if(idnvs!=null) {
			// DELETE FROM nhanvien WHERE IDNV IN ('NV01','NV02','NV03');
			String ids = String.join("','", idnvs);
			if(Instance.removeMultipleEmployees(ids) > 0) {
				response.sendRedirect(request.getContextPath()+"/rmEmp?multiple=1");
			}
		} else {
			
		}
	}

}
