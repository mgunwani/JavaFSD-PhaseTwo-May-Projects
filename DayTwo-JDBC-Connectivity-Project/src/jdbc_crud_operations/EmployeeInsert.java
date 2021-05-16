package jdbc_crud_operations;

/*
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
*/

import java.sql.*;

public class EmployeeInsert {
	
	public static void main(String[] args) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/trainingdb", "root", "password@123456");
			Statement statement = connection.createStatement();
			int rows = statement.executeUpdate("insert into Employee values(107, 'Kartik', 15000);");
			if(rows > 0) {
				System.out.println(rows + " record(s) inserted successfully.");
			}
			connection.close();
			
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		
	}

}
