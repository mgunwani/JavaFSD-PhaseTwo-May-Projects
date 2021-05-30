package com.bhawnagunwani.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		if(username.equals("bhawna") && password.equals("gunwani")) {
			// Default getSession parameter is true,
			// Thus, it creates new session object
			HttpSession session = request.getSession();	
			session.setAttribute("uname", username);
			response.sendRedirect("dashboard.jsp");
			
		} else {
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.include(request, response);
			out.println("<h3 style='color:red'>Invalid Credentials. Please Try Again.</h3>");
			
			
		}
	
	}

}
