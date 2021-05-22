package com.bhawnagunwani.filters;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ValidationFilter implements Filter {

    public ValidationFilter() {
        // TODO Auto-generated constructor stub
    }


	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}
 
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		System.out.println("Hello from Filter...");
		
		String pan = request.getParameter("pan");
		if(pan == null || !pan.matches("[A-Z]{5}[0-9]{4}[A-Z]{1}")) {
			PrintWriter out = response.getWriter();
			response.setContentType("text/html");
			request.getRequestDispatcher("Registration.jsp").include(request, response);
			out.println("<h4 style='color:red'>Invalid PAN Number..</h4>");
		} else {
			request.setAttribute("pan", pan);
			chain.doFilter(request, response);
		}
		
		System.out.println("Bye from Filter..");
	}
	
	public void destroy() {
		// TODO Auto-generated method stub
	}



}
