package com.qlynhansu.Controller;
import com.qlynhansu.Model.BEAN.*;
import com.qlynhansu.Model.BO.*;
import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet ({"/searchforemp"})
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final EmployeeBO Instance = EmployeeBO.getInstance();
    /**
     * Default constructor. 
     */
    public SearchServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.getRequestDispatcher("/WEB-INF/VIEW/searchforemp.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		String field = request.getParameter("field");
		String search = request.getParameter("search");
		ArrayList<Employee> empSearch = Instance.searchforEmployee(field, search);
		if(!empSearch.isEmpty()) {
			request.setAttribute("empSearch", empSearch);
		}
		request.getRequestDispatcher("/WEB-INF/VIEW/searchforemp.jsp").forward(request, response);
	}

}
