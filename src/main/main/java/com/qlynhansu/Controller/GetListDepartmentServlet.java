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
 * Servlet implementation class GetListDepartmentServlet
 */
@WebServlet ({"/departmentlist"})
public class GetListDepartmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final DepartmentBO Instace = DepartmentBO.getInstance();
    /**
     * Default constructor. 
     */
    public GetListDepartmentServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		ArrayList<Department> dpList = Instace.getListDepartment();
		request.setAttribute("dpList", dpList);
		request.getRequestDispatcher("/WEB-INF/VIEW/departmentlist.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		
	}

}
