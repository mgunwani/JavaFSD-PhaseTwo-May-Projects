package com.bhawnagunwani.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.bhawnagunwani.models.Department;

public class DepartmentDAO {
	
	private String jdbcURL;
	private String jdbcUsername;
	private String jdbcPassword;
	private Connection jdbcConnection;
	
	public DepartmentDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
		this.jdbcURL = jdbcURL;
		this.jdbcUsername = jdbcUsername;
		this.jdbcPassword = jdbcPassword;
	}
	
	void connect() throws SQLException {
		if(jdbcConnection == null || jdbcConnection.isClosed()) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (Exception ex) {
				System.out.println(ex.getMessage());
			}
			jdbcConnection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		}
	}


	public List<Department> getAllDepartments() {
		
		List<Department> departmentList = new ArrayList<Department>();
		try {
			connect();
			PreparedStatement statement = jdbcConnection.prepareStatement("SELECT * FROM departments");
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				Department department = new Department();
				department.setDeptId(rs.getInt(1));
				department.setDeptName(rs.getString(2));
				department.setDeptLocation(rs.getString(3));
				departmentList.add(department);
			}
			jdbcConnection.close();
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		
		return departmentList;
	}
	
	
	public void insertDepartment(Department dept) {
		try {
			connect();
			PreparedStatement statement = jdbcConnection.prepareStatement
					("INSERT INTO departments(deptname, deptlocation) values(?, ?)");
			statement.setString(1, dept.getDeptName());
			statement.setString(2, dept.getDeptLocation());
			int rows = statement.executeUpdate();
			if(rows > 1) {
				System.out.println("Department Inserted Successfully.");
			} else {
				System.out.println("There is some error while inserting department.");
			}
			jdbcConnection.close();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

}
