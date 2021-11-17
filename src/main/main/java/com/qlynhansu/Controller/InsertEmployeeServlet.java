package com.qlynhansu.Controller;

import java.io.IOException;

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
	private static final EmployeeBO Instance = EmployeeBO.getInstance();
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
		if(Instance.insertEmployee(emp)>0) {
			response.sendRedirect(request.getContextPath() + "/employeelist");
		} else {
			response.sendRedirect(request.getContextPath() + "/employeelist?alert=1");
		}
	}

}
