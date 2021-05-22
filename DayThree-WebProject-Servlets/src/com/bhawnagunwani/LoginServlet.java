package com.bhawnagunwani;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		RequestDispatcher rd = null;
		
		if(username.equals("admin") && password.equals("123456")) {
			/* out.println("<h4>LoggedIn Successfully.</h4>"); */
			rd = request.getRequestDispatcher("WelcomeServlet");
			rd.forward(request, response);
		} else {
			/* out.println("<h4>Invalid Credentials.</h4>"); */
			rd = request.getRequestDispatcher("login.jsp");
			rd.include(request, response);
			out.println("<h4 style='color:red;font-weight:bold'>Invalid Credentials. Please Try Again..!!</h4>");
		}
		
	}

}
