package dev.rd.daos;


import dev.rd.models.Reimbursement;

public interface ReimbursementDao {
	
	
	public Reimbursement submitReimbursemenRequest(int employeeNumber, String discription , double amount );
	public Reimbursement submitManagerApproveDenyRequest(int request_num, String status);
	public Reimbursement managerViewAllPendingRequest(int id);
	
	public Reimbursement employeeViewPendingRequest(int id);
	public Reimbursement employeeViewResolvedRequest(int id);
	
	

}
