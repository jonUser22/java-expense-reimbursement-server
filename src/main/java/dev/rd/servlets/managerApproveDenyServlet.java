package dev.rd.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import dev.rd.models.Reimbursement;
import dev.rd.services.managerApproveDenyService;



public class managerApproveDenyServlet  extends HttpServlet {
	
	

		private static final long serialVersionUID = 1L;
		
	    private managerApproveDenyService mADS = new managerApproveDenyService();
		
		//doGet
		protected void doGet(HttpServletRequest request, HttpServletResponse response) 
				throws IOException, ServletException {
			    System.out.println("Get request to managerApproveDeny Servlet");	
		}

		//doPost
	    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			   throws IOException, ServletException {
	    	
			ObjectMapper objectMaper = new ObjectMapper();
				
			Reimbursement approveDeny = objectMaper.readValue(request.getReader().readLine(), Reimbursement.class);
			Reimbursement requested = mADS.submitApproveDenyRequest(approveDeny.getRequest_num(), approveDeny.getStatus());
					
			
			
			if (requested!=null) {
				try(PrintWriter pw = response.getWriter()){		
					pw.write(objectMaper.writeValueAsString(requested));		
				}
				
			}else {
				response.sendError(401);
			}
				
			
				

}
}
