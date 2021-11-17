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
 * Servlet implementation class EmpByDpmServlet
 */
@WebServlet ({"/empbydeptlist"})
public class EmpByDeptServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final EmployeeBO Instance = EmployeeBO.getInstance();
    /**
     * Default constructor. 
     */
    public EmpByDeptServlet() {
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String idpb = request.getParameter("idpb");
		ArrayList<Employee> empList = Instance.getListEmployee(idpb);
		request.setAttribute("empList", empList);
		request.getRequestDispatcher("/WEB-INF/VIEW/empbydept.jsp").forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
