package dev.rd.services;

import dev.rd.daos.ReimbursementDaoImpl;
import dev.rd.models.Reimbursement;

public class managerApproveDenyService {
	
	
	
   ReimbursementDaoImpl rDeo = new ReimbursementDaoImpl();
	
	public Reimbursement submitApproveDenyRequest(int request_num, String status) {
		
		
		Reimbursement rb = rDeo.submitManagerApproveDenyRequest(request_num, status);
		
	      return rb;
		
	}

}
