package transactions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class TransactionManagementExampleOne {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/trainingdb", "root", "password@123456");
			Statement statement = connection.createStatement();
			connection.setAutoCommit(false);
			
			
			statement.executeUpdate("insert into Employee values(116, 'Amit', 15000);");
			statement.executeUpdate("insert into Employee values(116, 'Sumit', 15000);");
			
			System.out.print("Do you want to commit?");
			String ans = scan.nextLine();
			if(ans.equals("yes")) {
				connection.commit();
				System.out.println("Committed.. :)");
			} else {
				// connection.rollback();
				System.out.println("Rollback.. :)");
			}
			
			connection.commit();
			
			connection.close();
			
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

}
