package dev.rd.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;



public class Manager extends Employee {

	private int manager_Id;
	private String type;
	private String first_name;
	private String last_name;
	private String email;
	private String log_in;
	private String password;
	private List<Employee>employees;
	
	
	public Manager() {
		super();
	}

	public Manager(int manager_Id, String type, String first_name, String last_name, String email, String log_in, String password,
			List<Employee> employees) {
		super(manager_Id, type, first_name, last_name, email, log_in, password );
		this.employees = employees;
	}



	//gets & sets
	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "Manager [manager_Id=" + manager_Id + ", type=" + type + ", first_name=" + first_name + ", last_name="
				+ last_name + ", email=" + email + ", log_in=" + log_in + ", password=" + password + ", employees="
				+ employees + "]";
	}
	
	


}
