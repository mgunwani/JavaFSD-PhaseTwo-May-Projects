package com.bhawnagunwani;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DemoOneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DemoOneServlet() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		ServletConfig config = getServletConfig();
		out.println("<h3>Accessing Parameters of ServletConfig in DemoOneServlet: </h3>");
		out.println("Message : " + config.getInitParameter("Message"));
		out.println("<br /><br />");
		out.println("Command : " + config.getInitParameter("Command"));
		
		ServletContext context = getServletContext();
		out.println("<h3>Accessing Parameters of ServletContext in DemoOneServlet: </h3>");
		out.println("Driver : " + context.getInitParameter("Driver"));
		out.println("<br /><br />");
		out.println("URL : " + context.getInitParameter("URL"));
		
		
		
	}
}
