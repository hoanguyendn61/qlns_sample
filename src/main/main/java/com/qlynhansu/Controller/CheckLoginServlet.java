package com.qlynhansu.Controller;

import java.io.IOException;

import com.qlynhansu.Model.BO.CheckLoginBO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class CheckLoginServlet
 */
@WebServlet (urlPatterns = {"/index.jsp","/login"})
public class CheckLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * Default constructor. 
     */
    public CheckLoginServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String destination = null;
		String guest = request.getParameter("guest");
		if(guest != null){
			destination = "/WEB-INF/VIEW/Guest/homeGuest.jsp";
			HttpSession session = request.getSession();
			session.setAttribute("guest", guest);
		} else {
			destination = "/WEB-INF/VIEW/index.jsp";
		}
		request.getRequestDispatcher(destination).forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String destination = null;
		
		if(CheckLoginBO.getInstance().isUserValid(username, password)) {
			HttpSession session = request.getSession(false);
			if(session!=null) {
				session.invalidate();
			}
			destination = "/WEB-INF/VIEW/Admin/homeAdmin.jsp";
			request.getRequestDispatcher(destination).forward(request, response);
		}
		else {
			destination = "/WEB-INF/VIEW/index.jsp";
			request.getRequestDispatcher(destination).forward(request, response);
		}
	}

}
