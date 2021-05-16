package jdbc_crud_operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class EmployeeDeleteById {
	
	public static void main(String[] args) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/trainingdb", "root", "password@123456");
			Statement statement = connection.createStatement();
			int rows = statement.executeUpdate("DELETE FROM Employee where EmpID = 107");
			if(rows > 0) {
				System.out.println(rows + " record(s) deleted successfully.");
			} else {
				System.out.println("There is no record exists with this id..");
			}
			connection.close();
			
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		
	}

}
