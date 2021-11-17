package com.qlynhansu.Controller;

import java.io.IOException;

import com.qlynhansu.Model.BEAN.Employee;
import com.qlynhansu.Model.BO.EmployeeBO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateEmployeeServlet
 */
@WebServlet ({"/updateEmp"})
public class UpdateEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final EmployeeBO Instance = EmployeeBO.getInstance();
    /**
     * Default constructor. 
     */
    public UpdateEmployeeServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String idnv = request.getParameter("idnv");
		Employee emp = Instance.getEmpByID(idnv);
		request.setAttribute("emp", emp);
		request.getRequestDispatcher("/employeelist").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String idnv = request.getParameter("idnv");
		String name = request.getParameter("name");
		String idpb = request.getParameter("idpb");
		String address = request.getParameter("address");
		Employee emp = new Employee(idnv, name.trim(), idpb, address);
		if(Instance.updateEmployee(emp)>0) {
			response.sendRedirect(request.getContextPath() + "/employeelist");
		}
	}
}
