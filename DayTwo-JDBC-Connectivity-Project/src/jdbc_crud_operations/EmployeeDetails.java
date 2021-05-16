package jdbc_crud_operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class EmployeeDetails {
	
	public static void main(String[] args) {
		
		try {
			/* 1. Register the Driver Class */
			Class.forName("com.mysql.cj.jdbc.Driver");
			/* 2. Create Connection by ConnectionString */
			Connection connection = 
					DriverManager.getConnection("jdbc:mysql://localhost:3306/trainingdb", "root", "password@123456");
			/* 3. Create the Statement Object */
			Statement statement = connection.createStatement();
			/* 4. Execute Query */
			ResultSet rs = statement.executeQuery("SELECT * FROM Employee");
			while(rs.next()) {
				// System.out.println(rs.getInt("EmpId") + " : " + rs.getString("EmpName") + " : " + rs.getFloat("Salary"));
				System.out.println(rs.getInt(1) + " : " + rs.getString(2) + " : " + rs.getFloat(3));
			}
			/* 5. Close Connection */
			connection.close();
			
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		
	}

}
