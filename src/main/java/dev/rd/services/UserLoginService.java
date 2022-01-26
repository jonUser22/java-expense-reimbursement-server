package dev.rd.services;
import dev.rd.daos.LogInDaoImpl;
import dev.rd.models.UserLogin;






public class UserLoginService {
	LogInDaoImpl log = new LogInDaoImpl();
	
	public UserLogin findUserByUsernameAndPassword(String username, String password) {
		
		UserLogin user = log.logInVerify(username, password);
		       

		if(user!=null) {
			if(user.getUsername()!=null && user.getUsername().equals(username)) {
				if(user.getPassword()!=null && user.getPassword().equals(password)) {
					return user;
				}
			}
		}
	      return null;
	
}
	
	// finds the user by the token id 
	public UserLogin findUserById(int id) {
		
		UserLogin user = log.getemployeeNumberById(id);
		if (user != null && user.getEmployeeNumber()==id) {
			
			return user;		
		}
		return null;
		
	}
	 
	
	
	
}