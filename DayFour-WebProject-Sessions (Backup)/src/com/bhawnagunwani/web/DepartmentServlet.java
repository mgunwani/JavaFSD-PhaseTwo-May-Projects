package com.bhawnagunwani.web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bhawnagunwani.dao.DepartmentDAO;
import com.bhawnagunwani.models.Department;

public class DepartmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	DepartmentDAO departmentDAO = new DepartmentDAO();

	public DepartmentServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			listEmployees(request, response);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	private void listEmployees(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Department> departmentList = departmentDAO.getAllDepartments();
		request.setAttribute("departments", departmentList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("departments.jsp");
		dispatcher.forward(request, response);

	}

}
