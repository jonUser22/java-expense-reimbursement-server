package dev.rd.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.fasterxml.jackson.databind.ObjectMapper;
import dev.rd.models.Reimbursement;
import dev.rd.services.ReimbursementRequestService;


public class ReimbursmentRequestServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private ReimbursementRequestService rRs = new ReimbursementRequestService();
	
	//doGet
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException {
		    System.out.println("Get request to ReimbursementRequest Servlet");	
	}

	//doPost
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
		   throws IOException, ServletException {
    	
		ObjectMapper objectMaper = new ObjectMapper();
			

		Reimbursement reimbursReq = objectMaper.readValue(request.getReader().readLine(), Reimbursement.class);
		Reimbursement employee = rRs.submitReimbursemenRequest(reimbursReq.getEmployee_Id(), reimbursReq.getDiscription(), reimbursReq.getAmount());
				
		
		
		if (employee!=null) {
			try(PrintWriter pw = response.getWriter()){		
				pw.write(objectMaper.writeValueAsString(employee));		
			}
			
		}else {
			response.sendError(401);
		}
			
		
			
		

}
	
	
	
	
	
	
	

}
