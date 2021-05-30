package com.bhawnagunwani.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bhawnagunwani.dao.DepartmentDAO;
import com.bhawnagunwani.models.Department;

@WebServlet(name = "DepartmentServlet", value = {"/DepartmentServlet", "/newDepartment", 
		"/insertDepartment",  "/listDepartment", "/deleteDepartment"})
public class DepartmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	DepartmentDAO departmentDAO;

	public DepartmentServlet() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public void init() {
		String jdbcURL = getServletContext().getInitParameter("jdbcURL");
		String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
		String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
		departmentDAO = new DepartmentDAO(jdbcURL, jdbcUsername, jdbcPassword);
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String action = request.getServletPath();
		System.out.println(action);
		
		try {
			switch(action) {
			
			case "/newDepartment":
				newDepartmentForm(request,response);
				break;
				
			case "/insertDepartment":
				insertDepartment(request, response);
				break;
				
			case "/listDepartment":
				listDepartments(request, response);
				break;
				
			case "/deleteDepartment":
				deleteDepartment(request, response);
				break;
			
			default:
				listDepartments(request, response);
				break;
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}


	private void deleteDepartment(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
	
		System.out.println("Hi");
		PrintWriter out = response.getWriter();
		out.println("Deleting department here..");
		
	}

	private void insertDepartment(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Department department = new Department();
		department.setDeptName(request.getParameter("deptName"));
		department.setDeptLocation(request.getParameter("deptLocation"));
		departmentDAO.insertDepartment(department);
		response.sendRedirect("listDepartment");
	}

	private void newDepartmentForm(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("newDepartmentForm.jsp");
		dispatcher.forward(request, response);
	}

	private void listDepartments(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Department> departmentList = departmentDAO.getAllDepartments();
		request.setAttribute("departments", departmentList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("departments.jsp");
		dispatcher.forward(request, response);

	}

}
