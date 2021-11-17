package com.qlynhansu.Controller;

import java.io.IOException;
import java.util.ArrayList;

import com.qlynhansu.Model.BEAN.Department;
import com.qlynhansu.Model.BEAN.Employee;
import com.qlynhansu.Model.BO.*;

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
	private static final EmployeeBO EmpInstance = EmployeeBO.getInstance();
	private static final DepartmentBO DeptInstance = DepartmentBO.getInstance();
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
		String destination = null;
		if(idnv!=null) {
			Employee emp = EmpInstance.getEmpByID(idnv);
			request.setAttribute("emp", emp);
			ArrayList<Department> deptList = DeptInstance.getListDepartment();
			request.setAttribute("deptList", deptList);
			destination = "/WEB-INF/VIEW/Admin/employeeForm.jsp";
		} else {
			ArrayList<Employee> empList = EmpInstance.getListEmployee();
			request.setAttribute("empList", empList);
			destination = "/WEB-INF/VIEW/Admin/updateEmployee.jsp";
		}
		request.getRequestDispatcher(destination).forward(request, response);
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
		if(EmpInstance.updateEmployee(emp)>0) {
			response.sendRedirect(request.getContextPath() + "/updateEmp");
		}
	}
}
