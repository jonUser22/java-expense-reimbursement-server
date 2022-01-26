package dev.rd.models;

public class UserLogin {
	
	private int employeeNumber;
	private String typeEmployee;
	private String firstName;
	private String lastName;
	private String email;
	private String username;
	private String password;
	
	

	public UserLogin() {
		super();
	}



	public UserLogin(int employeeNumber, String typeEmployee, String firstName, String lastName, String email,
			String username, String password) {
		super();
		this.employeeNumber = employeeNumber;
		this.typeEmployee = typeEmployee;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.username = username;
		this.password = password;
	}



	public int getEmployeeNumber() {
		return employeeNumber;
	}



	public void setEmployeeNumber(int employeeNumber) {
		this.employeeNumber = employeeNumber;
	}



	public String getTypeEmployee() {
		return typeEmployee;
	}



	public void setTypeEmployee(String typeEmployee) {
		this.typeEmployee = typeEmployee;
	}



	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + employeeNumber;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((typeEmployee == null) ? 0 : typeEmployee.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserLogin other = (UserLogin) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (employeeNumber != other.employeeNumber)
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (typeEmployee == null) {
			if (other.typeEmployee != null)
				return false;
		} else if (!typeEmployee.equals(other.typeEmployee))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "UserLogin [employeeNumber=" + employeeNumber + ", typeEmployee=" + typeEmployee + ", firstName="
				+ firstName + ", lastName=" + lastName + ", email=" + email + ", username=" + username + ", password="
				+ password + "]";
	}
	
	
	
	
	


}