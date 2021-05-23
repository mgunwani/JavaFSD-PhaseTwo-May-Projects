package com.bhawnagunwani.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;

import com.bhawnagunwani.models.Department;

public class DepartmentDAO {
	
	public List<Department> getAllDepartments() {
		
		List<Department> departmentList = new ArrayList<Department>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection
					("jdbc:mysql://localhost:3306/trainingdb", "root", "password@123456");
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM departments");
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				Department department = new Department();
				department.setDeptId(rs.getInt(1));
				department.setDeptName(rs.getString(2));
				department.setDeptLocation(rs.getString(3));
				departmentList.add(department);
			}
			connection.close();
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		
		return departmentList;
	}

}
