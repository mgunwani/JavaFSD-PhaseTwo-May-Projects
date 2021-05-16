package jdbc_crud_operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class EmployeeDetailById {
	
	public static void main(String[] args) {
	
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/trainingdb", "root", "password@123456");
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("Select * from Employee where EmpId = " + 103);
			// ResultSet rs = statement.executeQuery("Select * from Employee where EmpName = 'Sarah';");
			if(rs.next()) {
				System.out.println(rs.getInt(1) + " : " + rs.getString(2) + " : " + rs.getFloat(3));
			} else {
				System.out.println("There is no record exist with this id.");
			}
		
			connection.close();
			
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		
	}
	

}
