package dev.rd.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import dev.rd.models.UserLogin;
import dev.rd.util.ConnectionUtil;

public class LogInDaoImpl implements LogInDao {

/*	
	@Override
	public UserLogin userLogInVerification(String userLogIn, String passsword) {
		
		UserLogin user = new UserLogin();

		//SQL SELECT statement
		String logUrl = "SELECT LOGIN_ID \r\n"
				+ "FROM EMPLOYEE \r\n"
				+ "WHERE LOGIN_ID =  ?";
		
		String passUrl = "SELECT  PASSWORD\r\n"
				+ "FROM EMPLOYEE\r\n"
				+ "WHERE  PASSWORD = ?";
		
		try {Connection connection = ConnectionUtil.getConnection();
			try (PreparedStatement logInPStatement = connection.prepareStatement(logUrl);
					PreparedStatement passWordPStatement = connection.prepareStatement(passUrl)){
				
				logInPStatement.setString(1, userLogIn);
				ResultSet rs = logInPStatement.executeQuery();
				while (rs.next()) {
					user.setUsername(rs.getString("LOGIN_ID"));		
				}
				
				passWordPStatement.setString(1, passUrl);
				ResultSet rs2 = passWordPStatement.executeQuery();
				while (rs2.next()) {
				
					user.setPassword(rs2.getString("PASSWORD"));

					}
				

			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		return user;
	
	}
*/

	UserLogin user = new UserLogin();
	
	@Override
	public UserLogin logInVerify(String logIn, String password) {
		
		//SQL SELECT statement
		String logUrl = "SELECT LOGIN_ID \r\n"
				+ "FROM EMPLOYEE \r\n"
				+ "WHERE LOGIN_ID = ?";
		
		try {Connection connection = ConnectionUtil.getConnection();
			try (PreparedStatement logInPStatement = connection.prepareStatement(logUrl)){
				
				logInPStatement.setString(1, logIn);
				ResultSet rs = logInPStatement.executeQuery();
				while (rs.next()) {
					user.setUsername(rs.getString("LOGIN_ID"));
					}
					user.setPassword(passWordVerify(password));		
					user.setTypeEmployee(getJob_Title(password));
					user.setEmployeeNumber(employeeNumber(password));
					
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
			

	public String passWordVerify(String passWord) {		
		String str = null;
		//SQL SELECT statement
		String passUrl = "SELECT  PASSWORD\r\n"
				+ "FROM EMPLOYEE\r\n"
				+ "WHERE  PASSWORD = ?";

		try {Connection connection = ConnectionUtil.getConnection();
			try (PreparedStatement passWordPStatement = connection.prepareStatement(passUrl)){
				
				passWordPStatement.setString(1, passWord);
				ResultSet rs = passWordPStatement.executeQuery();
				while (rs.next()) {	
					  str = rs.getString("PASSWORD");	
					};
			}	
			} catch (SQLException e) {
				e.printStackTrace();
			}
				return str;
			
				       
}
	
	public String getJob_Title(String password) {		
		String str = null;
		//SQL SELECT statement
		String jobTitleUrl = "SELECT  JOB_TITLE\r\n"
				+ "FROM EMPLOYEE\r\n"
				+ "WHERE  PASSWORD = ?";

		try {Connection connection = ConnectionUtil.getConnection();
			try (PreparedStatement jobTitlePStatement = connection.prepareStatement(jobTitleUrl)){
				
				jobTitlePStatement.setString(1, password);
				ResultSet rs = jobTitlePStatement.executeQuery();
				while (rs.next()) {	
					  str = rs.getString("JOB_TITLE");	
					};
			}	
			} catch (SQLException e) {
				e.printStackTrace();
			}
				return str;
			
				       
}
	
	public int employeeNumber(String password) {		
		int num = 0;
		//SQL SELECT statement
		String empNumUrl = "SELECT  EMPLOYEE_NUMBER\r\n"
				+ "FROM EMPLOYEE\r\n"
				+ "WHERE  PASSWORD = ?";

		try {Connection connection = ConnectionUtil.getConnection();
			try (PreparedStatement employeeNumPStatement = connection.prepareStatement(empNumUrl)){
				
				employeeNumPStatement.setString(1, password);
				ResultSet rs = employeeNumPStatement.executeQuery();
				while (rs.next()) {	
					  num = rs.getInt("EMPLOYEE_NUMBER");	  
					};
			}	
			} catch (SQLException e) {
				e.printStackTrace();
			}
				return num;
			
				       
}
	
	public UserLogin getemployeeNumberById(int id) {		
		
		//SQL SELECT statement
		String empNumByIdUrl = "SELECT  *\r\n"
				+ "FROM EMPLOYEE\r\n"
				+ "WHERE  EMPLOYEE_NUMBER = ?";

		try {Connection connection = ConnectionUtil.getConnection();
			try (PreparedStatement employeeNumByIdPStatement = connection.prepareStatement(empNumByIdUrl)){
				
				employeeNumByIdPStatement.setInt(1,id);
				ResultSet rs = employeeNumByIdPStatement.executeQuery();
				while (rs.next()) {	
					user.setEmployeeNumber(rs.getInt("EMPLOYEE_NUMBER"));
					user.setTypeEmployee(rs.getString("JOB_TITLE"));
					user.setFirstName(rs.getString("FIRST_NAME"));
					user.setLastName(rs.getString("LAST_NAME"));
					user.setEmail(rs.getString("EMAIL"));
					user.setUsername(rs.getString("LOGIN_ID"));
					user.setPassword(rs.getString("PASSWORD"));
					  	  
					};
			}	
			} catch (SQLException e) {
				e.printStackTrace();
			}
				return user;
			
				       
}

}
