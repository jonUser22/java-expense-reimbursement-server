package dev.rd.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



import dev.rd.models.Reimbursement;
import dev.rd.models.UserLogin;
import dev.rd.util.ConnectionUtil;

public class ReimbursementDaoImpl implements ReimbursementDao {
	
	

	@Override
	public Reimbursement submitReimbursemenRequest(int employeeNumber, String discription , double amount) {
		
		
		Reimbursement rb = new Reimbursement();
		 
         String str = "PENDING";
         int num = requestNumberCheck();
         
         
         System.out.println(num +""+ employeeNumber);
         
		//SQL SELECT statement
		String reimbursementUrl = "INSERT INTO REIMBURSEMENT \r\n"
				+ "VALUES (? , ? , ?, ?, ?)";
		
		String requestURL ="SELECT  *\r\n"
				+ "FROM REIMBURSEMENT \r\n"
				+ "WHERE  REQUEST_NUMBER = ?";
		
		
	
		try { Connection connection = ConnectionUtil.getConnection();
			 try (PreparedStatement reimbursementPStatement = connection.prepareStatement(reimbursementUrl);
					 PreparedStatement reqestCheckPStatement = connection.prepareStatement(requestURL)){

	
				 reimbursementPStatement.setInt(1, num);
				 reimbursementPStatement.setInt(2, employeeNumber);
				 reimbursementPStatement.setString(3, discription);
				 reimbursementPStatement.setDouble(4, amount);
				 reimbursementPStatement.setString(5, str);
				 reimbursementPStatement.executeQuery();
				 
				 
				 reqestCheckPStatement.setInt(1, num);
				 ResultSet rs = reqestCheckPStatement.executeQuery();
				 
					while (rs.next()) {
						
						rb.setRequest_num(rs.getInt("REQUEST_NUMBER"));
						rb.setEmployee_Id(rs.getInt("EMPLOYEE_NUMBER"));
						rb.setDiscription(rs.getString("DESCRIPTION"));
						rb.setAmount(rs.getDouble("AMOUNT_REQUESTED"));
						rb.setStatus(rs.getString("STATUS"));
				
				 
					}
				 
				 
				 

			 }	 
				 
          		} catch (SQLException e) {
    				e.printStackTrace();
    			}
			 
			 return rb;     
	            
	}
	
	//Get the next REQUEST_NUMBER in the database 
	public int requestNumberCheck() {
		
		int requestNumber = 0; 
		String requestNumberUrl = "SELECT MAX(REQUEST_NUMBER)\r\n"
				+ "FROM REIMBURSEMENT ";
		
		try { Connection connection = ConnectionUtil.getConnection();
		 try (PreparedStatement requestNumberPStatement = connection.prepareStatement(requestNumberUrl)){
			
			ResultSet rs = requestNumberPStatement.executeQuery();
	         while (rs.next()) {
	        	 requestNumber = rs.getInt(1);
	        	 requestNumber = requestNumber + 1;
	         }
			  rs.close();

         } 
		    
		 } catch (SQLException e) {
			 e.printStackTrace();
		 }
	        return requestNumber;
	}

	
	
	@Override
	public Reimbursement submitManagerApproveDenyRequest(int request_num, String status) {
	
		
		Reimbursement rb = new Reimbursement();
		
               
		//SQL SELECT statement
		String statusUpdatetUrl = "UPDATE REIMBURSEMENT\r\n"
				+ "SET STATUS =  ?\r\n"
				+ "WHERE REQUEST_NUMBER = ?";
		

	
		try { Connection connection = ConnectionUtil.getConnection();
			 try (PreparedStatement statusUpdatePStatement = connection.prepareStatement(statusUpdatetUrl)){

	
				 statusUpdatePStatement.setString(1, status);
				 statusUpdatePStatement.setInt(2, request_num);
				 ResultSet rs = statusUpdatePStatement.executeQuery();
				 
					/*while (rs.next()) {
						
						rb.setRequest_num(rs.getInt("REQUEST_NUMBER"));
						rb.setStatus(rs.getString("STATUS"));
				
				 
					}*/

			 }	 
				 
          		} catch (SQLException e) {
    				e.printStackTrace();
    			}
			 
			 return rb;     

	}


	
	
public Reimbursement managerViewAllPendingRequest(int id) {
		
	
	    Reimbursement rB = new Reimbursement();
	    
		//SQL SELECT statement
		String allPendingStatusUrl = "SELECT  *\r\n"
				+ "FROM REIMBURSEMENT \r\n"
				+ "WHERE  STATUS = 'PENDING'";

		try {Connection connection = ConnectionUtil.getConnection();
			try (PreparedStatement allPendingStatusPStatement = connection.prepareStatement(allPendingStatusUrl)){
				
				
				ResultSet rs = allPendingStatusPStatement.executeQuery();
				while (rs.next()) {	
					rB.setRequest_num(rs.getInt("REQUEST_NUMBER"));
					rB.setEmployee_Id(rs.getInt("EMPLOYEE_NUMBER"));
					rB.setDiscription(rs.getString("DESCRIPTION"));
					rB.setAmount(rs.getDouble("AMOUNT_REQUESTED"));
					rB.setStatus(rs.getString("STATUS"));
					
					 
					};
					
				

					
			}	
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		   
				return rB;
			
				       
}

@Override
public Reimbursement employeeViewPendingRequest(int id) {
	
	
	  Reimbursement rB = new Reimbursement();
	    
			//SQL SELECT statement
			String pendingReqUrl = "SELECT  *\r\n"
					+ "FROM REIMBURSEMENT\r\n"
					+ "WHERE (EMPLOYEE_NUMBER = ?)\r\n"
					+ "AND  STATUS = 'PENDING'";

			try {Connection connection = ConnectionUtil.getConnection();
				try (PreparedStatement pendingReqPStatement = connection.prepareStatement(pendingReqUrl)){
					
					pendingReqPStatement.setInt(1,id);
					ResultSet rs = pendingReqPStatement.executeQuery();
					while (rs.next()) {	
						rB.setRequest_num(rs.getInt("REQUEST_NUMBER"));
						rB.setEmployee_Id(rs.getInt("EMPLOYEE_NUMBER"));
						rB.setDiscription(rs.getString("DESCRIPTION"));
						rB.setAmount(rs.getDouble("AMOUNT_REQUESTED"));
						rB.setStatus(rs.getString("STATUS"));
		
						  	  
						};
				}	
				} catch (SQLException e) {
					e.printStackTrace();
				}
			    
			  
					return rB;
					
}








@Override
public Reimbursement employeeViewResolvedRequest(int id) {
	
	
	
	  Reimbursement rB = new Reimbursement();
	    
			//SQL SELECT statement
			String allResolvedRequestsUrl = "SELECT  *\r\n"
					+ "FROM REIMBURSEMENT\r\n"
					+ "WHERE (EMPLOYEE_NUMBER = ?)\r\n"
					+ "AND  STATUS != 'PENDING'";

			try {Connection connection = ConnectionUtil.getConnection();
				try (PreparedStatement allResolvedRequestPStatement = connection.prepareStatement(allResolvedRequestsUrl)){
					
					allResolvedRequestPStatement.setInt(1,id);
					ResultSet rs = allResolvedRequestPStatement.executeQuery();
					while (rs.next()) {	
						rB.setRequest_num(rs.getInt("REQUEST_NUMBER"));
						rB.setEmployee_Id(rs.getInt("EMPLOYEE_NUMBER"));
						rB.setDiscription(rs.getString("DESCRIPTION"));
						rB.setAmount(rs.getDouble("AMOUNT_REQUESTED"));
						rB.setStatus(rs.getString("STATUS"));
						
						
						
					
						  	  
						};
				}	
				} catch (SQLException e) {
					e.printStackTrace();
				}
			
	
		

			return rB;
			
}

}















