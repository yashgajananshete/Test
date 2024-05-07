package Test;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLDB {
 
	public static void main(String[] args) throws ClassNotFoundException, SQLException  {
	
		//Step 1: Loading & Registering the Driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//Step 2: Establishing the Connection
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/MyAxis", "root", "root");
		
		//Step 3: Creating & Executing Query
		String selectQuery  = "select * from employees";
		Statement stmt = conn.createStatement();
		
		//Step 4: Processing the Result
		ResultSet rs = stmt.executeQuery(selectQuery);
//		System.out.println("ID \t Name \t Email \t\t Mobile ");
		
		
		while(rs.next()) {
			System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getLong(4));
		}
		
		//Step 5: Closing all Resources
		rs.close();
		stmt.close();
		conn.close();
	}
}
 
