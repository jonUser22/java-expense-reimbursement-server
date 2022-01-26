package dev.rd.services;

import dev.rd.daos.ReimbursementDaoImpl;
import dev.rd.models.Reimbursement;


public class managerViewAllPendingRequestService {
	
	
	private ReimbursementDaoImpl rRs = new ReimbursementDaoImpl();
	
	// finds the user by the token id 
		public Reimbursement managerViewAllPendingRequest(int id) {
			
			Reimbursement allPending = rRs.managerViewAllPendingRequest(id);
			
			if (allPending != null) {
				
				return allPending;		
			}
			return null;
	
	
	
		}

}
