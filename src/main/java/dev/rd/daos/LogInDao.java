package dev.rd.daos;


import dev.rd.models.UserLogin;

public interface LogInDao {


	public UserLogin logInVerify(String logIn, String password);
	public UserLogin getemployeeNumberById(int id);
	
	
	//going to check the string userId and password
	//are correct or exist will return a boolean
	//public UserLogin userLogInVerification(String userLogIn, String password );

	

	
	

}

