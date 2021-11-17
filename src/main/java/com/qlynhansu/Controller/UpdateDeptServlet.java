package com.qlynhansu.Controller;

import java.io.IOException;
import java.util.ArrayList;

import com.qlynhansu.Model.BEAN.Department;
import com.qlynhansu.Model.BO.DepartmentBO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateDeptServlet
 */
@WebServlet ({"/updateDept"})
public class UpdateDeptServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final DepartmentBO Instance = DepartmentBO.getInstance();
    /**
     * Default constructor. 
     */
    public UpdateDeptServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String idpb = request.getParameter("idpb");
		Department dept = Instance.getDeptByID(idpb);
		String destination = null;
		if(idpb!=null) {
			request.setAttribute("dept", dept);
			destination = "/WEB-INF/VIEW/Admin/departmentForm.jsp";
		} else {
			ArrayList<Department> dpList = Instance.getListDepartment();
			request.setAttribute("dpList", dpList);
			destination = "/WEB-INF/VIEW/Admin/updateDepartment.jsp"; 
			
		}
		request.getRequestDispatcher(destination).forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		String idpb = request.getParameter("IDPB");
		String tenpb = request.getParameter("Tenpb");
		String mota = request.getParameter("Mota");
		Department dept = new Department(idpb, tenpb, mota);
		if(Instance.updateDept(dept) > 0) {
			response.sendRedirect(request.getContextPath() + "/updateDept");
		}
	}

}
