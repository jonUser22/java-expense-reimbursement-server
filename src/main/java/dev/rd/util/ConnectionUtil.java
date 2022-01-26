package dev.rd.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	
private static Connection connection;
	
	
	public static Connection getConnection() throws SQLException {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); //registering Oracle Driver
		}
		catch(ClassNotFoundException ex) {
			ex.printStackTrace();
			System.exit(1);
		}
		
		//jdbc:oracle:thin:@//dbpj22.cheexas1ejlw.us-east-2.rds.amazonaws.com:1521/ORCL

		String url = System.getenv("URL"); 
		String username = System.getenv("USERNAME");
		String password = System.getenv("PASSWORD");
		if(connection == null || connection.isClosed()) {
			connection = DriverManager.getConnection(url, username, password);
		}
		return connection;
	}


}

