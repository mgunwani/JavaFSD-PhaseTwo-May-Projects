package jdbc_crud_operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class EmployeeUpdateById {
	
	public static void main(String[] args) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/trainingdb", "root", "password@123456");
			Statement statement = connection.createStatement();
			// int rows = statement.executeUpdate("UPDATE Employee SET Salary = 60000 WHERE EmpID = 107");
			int rows = statement.executeUpdate("UPDATE Employee SET Salary = 60000 WHERE EmpID > 105");
			if(rows > 0) {
				System.out.println(rows + " record(s) updated successfully.");
			}
			connection.close();
			
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		
	}

}
