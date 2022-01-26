package dev.rd.services;

import dev.rd.daos.ReimbursementDaoImpl;
import dev.rd.models.Reimbursement;

public class employeeViewResolvedRequestService {
	
	
	
private ReimbursementDaoImpl rDI = new ReimbursementDaoImpl();
	
	
	
	public Reimbursement employeeViewResolved(int id) {
		
		Reimbursement rb = rDI.employeeViewResolvedRequest(id);
		
			      return rb;
	}
	
	
	
	
	

}
