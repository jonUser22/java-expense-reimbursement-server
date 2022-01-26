package dev.rd.models;




public class Reimbursement {

	private int request_num;
	private int employee_Id;
	private String discription;
	private double amount;
	private String status; 
	
	
	public Reimbursement() {
		super();
	}
	
	public Reimbursement(int request_num, int employee_Id, String discription, double amount, String status) {
		super();
		this.request_num = request_num;
		this.employee_Id = employee_Id;
		this.discription = discription;
		this.amount = amount;
		this.status = status;
	}

	public int getRequest_num() {
		return request_num;
	}

	public void setRequest_num(int request_num) {
		this.request_num = request_num;
	}

	public int getEmployee_Id() {
		return employee_Id;
	}

	public void setEmployee_Id(int employee_Id) {
		this.employee_Id = employee_Id;
	}

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((discription == null) ? 0 : discription.hashCode());
		result = prime * result + employee_Id;
		result = prime * result + request_num;
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		Reimbursement other = (Reimbursement) obj;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (discription == null) {
			if (other.discription != null)
				return false;
		} else if (!discription.equals(other.discription))
			return false;
		if (employee_Id != other.employee_Id)
			return false;
		if (request_num != other.request_num)
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Reimbursement [request_num=" + request_num + ", employee_Id=" + employee_Id + ", discription="
				+ discription + ", amount=" + amount + ", status=" + status + "]";
	}

	
	
	


	


	
	
	

}
