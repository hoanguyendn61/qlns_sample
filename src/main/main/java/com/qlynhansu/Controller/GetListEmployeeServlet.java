package com.qlynhansu.Controller;

import java.io.IOException;
import java.util.ArrayList;

import com.qlynhansu.Model.BEAN.*;
import com.qlynhansu.Model.BO.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class GetListEmployeeServlet
 */
@WebServlet ({"/employeelist"})
public class GetListEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final EmployeeBO EmpInstance = EmployeeBO.getInstance();
	private static final DepartmentBO DeptInstance = DepartmentBO.getInstance();
    /**
     * Default constructor. 
     */
    public GetListEmployeeServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		ArrayList<Employee> empList = EmpInstance.getListEmployee();
		ArrayList<Department> deptList = DeptInstance.getListDepartment();
		request.setAttribute("empList", empList);
		request.setAttribute("deptList", deptList);
		HttpSession session = request.getSession(false);
		String guest = (String)session.getAttribute("guest");
		request.setAttribute("guest", guest);
		request.getRequestDispatcher("/WEB-INF/VIEW/employeelist.jsp").forward(request, response);;
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
	}
}
