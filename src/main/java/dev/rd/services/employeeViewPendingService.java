package dev.rd.services;

import dev.rd.daos.ReimbursementDaoImpl;
import dev.rd.models.Reimbursement;

public class employeeViewPendingService {
	
	
	private ReimbursementDaoImpl rDI = new ReimbursementDaoImpl();
	
	
	
	public Reimbursement employeeViewPending(int id) {
		
		Reimbursement rb = rDI.employeeViewPendingRequest(id);
		
			      return rb;
	}
	

		
	
		
	
	
	

}
