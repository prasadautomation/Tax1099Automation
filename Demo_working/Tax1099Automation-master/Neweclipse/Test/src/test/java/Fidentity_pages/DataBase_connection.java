package Fidentity_pages;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

@Test
public class DataBase_connection {
	 public Statement stmt;

	public void dbconnection() throws ClassNotFoundException, SQLException {
	
	Class.forName("com.mysql.jdbc.Driver");
	 // Class.forName("com.mysql.cj.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://35.153.40.38:3306", "stageuser","stage(password)" );
 stmt = con.createStatement();
 
	
	}
	
}

