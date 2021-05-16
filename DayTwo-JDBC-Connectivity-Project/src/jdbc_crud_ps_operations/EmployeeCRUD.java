package jdbc_crud_ps_operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Scanner;


class EmployeeOperation {
	
	Connection connection = null;
	PreparedStatement statement = null;
	
	private Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/trainingdb", "root", "password@123456");
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return connection;
	}
	
	public void insertEmployee() {
		try {
			connection = getConnection();
			statement = connection.prepareStatement("insert into Employee values(?, ?, ?);");
			statement.setInt(1, 108);
			statement.setString(2, "Bhawna");
			statement.setFloat(3, 12345.78F);
			int rows = statement.executeUpdate();
			if(rows > 0)
				System.out.println(rows + " record(s) inserted successfully.");
			connection.close();
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	public void getAllEmployees() {
		try {
			connection = getConnection();
			statement = connection.prepareStatement("SELECT * FROM Employee");
			ResultSet rs = statement.executeQuery();
			ResultSetMetaData rsMetaData = rs.getMetaData();
			int columnCount = rsMetaData.getColumnCount();
			for (int i = 1; i <= columnCount; i++) {
				System.out.print(rsMetaData.getColumnName(i) + ":");
			}
			System.out.println();
			
			while(rs.next())
				System.out.println(rs.getInt(1) + ":" + rs.getString(2) + ":" + rs.getFloat(3));
			connection.close();
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	public void getEmployeeById(int employeeid) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/trainingdb", "root", "password@123456");
			statement = connection.prepareStatement("SELECT * FROM Employee where EmpID = ?");
			statement.setInt(1, employeeid);
			ResultSet rs = statement.executeQuery();
			if(rs.next())
				System.out.println(rs.getInt(1) + ":" + rs.getString(2) + ":" + rs.getFloat(3));
			else
				System.out.println("There is no record with such Id.");
			connection.close();
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	public void updateEmployeeById(int empid) {
		// TODO Auto-generated method stub
		
	}

	public void deleteEmployeeById(int empid) {
		// TODO Auto-generated method stub
		
	}
	
}

public class EmployeeCRUD {
	
	public static void main(String[] args) {
		
		EmployeeOperation empOperation = new EmployeeOperation();
		Scanner scan = new Scanner(System.in);
		System.out.println("1: Get All Employees");
		System.out.println("2: Get Employee By Id");
		System.out.println("3: Insert New Employee");
		System.out.println("4: Update Existing Employee");
		System.out.println("5: Delete Existing Employee");
		System.out.print("Enter Your Choice : ");
		int choice = scan.nextInt();
		switch(choice) {
		case 1: 
			empOperation.getAllEmployees();
			break;
			
		case 2:
			System.out.print("Enter Employee Id to fetch details : ");
			int empid = scan.nextInt();
			empOperation.getEmployeeById(empid);
			break;
			
		case 3:
			empOperation.insertEmployee();
			break;
			
		case 4:
			empOperation.updateEmployeeById(101);
			break;
			
		case 5:
			empOperation.deleteEmployeeById(101);
			break;
			
		default:
			System.out.println("Invalid Choice");
			break;
		
		}
		
		
		
		
	}

}
