package dev.rd.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.rd.models.UserLogin;
import dev.rd.services.UserLoginService;


public class LoginServlet extends HttpServlet {		

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserLoginService userLogInService = new UserLoginService();
	
	//doGet
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException {
		    System.out.println("Get request to login Servlet");	
	}
		
	
	
	//doPost
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
		   throws IOException, ServletException {
    	
		ObjectMapper objectMaper = new ObjectMapper();
		UserLogin credentials = objectMaper.readValue(request.getReader().readLine(), UserLogin.class);
		UserLogin user = userLogInService.findUserByUsernameAndPassword(credentials.getUsername(), credentials.getPassword());
		
		
		
		if(user != null ) {
			String token = user.getEmployeeNumber() + ":" + user.getTypeEmployee();
			try(PrintWriter pw = response.getWriter()){
				pw.write(token);
			}
		}else {
			response.sendError(401);
		}
			
		}
			
		

}
	
	

	
	
	