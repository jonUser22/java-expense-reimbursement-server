package dev.rd.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import dev.rd.models.Reimbursement;
import dev.rd.services.employeeViewPendingService;


public class employeeViewPendingServlet extends HttpServlet{

	/**
	 * 
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private employeeViewPendingService  eVPS = new employeeViewPendingService();
	
	private ObjectMapper objMapper = new ObjectMapper();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
		throws IOException, ServletException {
		
        String idStr  = request.getParameter("id");
		
		/* [ ^ ]   Finds a match as the beginning of a string as in: ^Hello
           [ $ ]   Finds a match at the end of the string as in: World$
           [\d ]   Find a digit    
        */
		
		if(idStr != null && idStr.matches("^\\d+$")) {
			int idNum = Integer. parseInt(idStr);
			Reimbursement user = eVPS.employeeViewPending(idNum);
			
	
			if (user!=null) {
				try(PrintWriter pw = response.getWriter()){		
					pw.write(objMapper.writeValueAsString(user));		
				}
		
			}else
				response.sendError(404);
			}else 
			{
			    //400 bad request
			    response.sendError(400);
			}
			
	
	
	
	}
	
	}


