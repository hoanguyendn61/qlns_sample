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
 * Servlet implementation class InsertEmployeeServlet
 */
@WebServlet ({"/insertEmp"})
public class InsertEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final EmployeeBO EmpInstance = EmployeeBO.getInstance();
	private static final DepartmentBO DeptInstance = DepartmentBO.getInstance();
    /**
     * Default constructor. 
     */
    public InsertEmployeeServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("doGet");
		ArrayList<Department> deptList = DeptInstance.getListDepartment();
		request.setAttribute("deptList", deptList);
		request.getRequestDispatcher("/WEB-INF/VIEW/Admin/employeeForm.jsp").forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		System.out.println("doPost");
		String idnv = request.getParameter("idnv");
		String name = request.getParameter("name");
		String idpb = request.getParameter("idpb");
		String address = request.getParameter("address");
		Employee emp = new Employee(idnv, name.trim(), idpb, address);
		if(EmpInstance.insertEmployee(emp)>0) {
			response.sendRedirect(request.getContextPath() + "/employeelist");
		} else {
			response.sendRedirect(request.getContextPath() + "/insertEmp?alert=1");
		}
	}

}
