package dev.rd.services;


import dev.rd.daos.ReimbursementDaoImpl;
import dev.rd.models.Reimbursement;


public class ReimbursementRequestService {
	
	
	ReimbursementDaoImpl rDeo = new ReimbursementDaoImpl();
	
	public Reimbursement submitReimbursemenRequest(int employeeNum, String discription, double amount) {
		
		
		Reimbursement rb = rDeo.submitReimbursemenRequest(employeeNum, discription, amount);
		
	      return rb;
		
	}
	
	
	

}
