package com.bhawnagunwani;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public FirstServlet() {
        super();
    }

    /*
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		String name = request.getParameter("username");
		PrintWriter out = response.getWriter();
		out.println("Service Method Invoked...");
		out.println("Hello " + name + "!!");
	}
	*/
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("username");
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("<h4>Get Method Invoked..</h4>");
		out.println("<h5>Hello " + name + "!!</h5>");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("username");
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("<h4>Post Method Invoked..</h4>");
		out.println("<h5>Hello " + name + "!!</h5>");
	}

}
