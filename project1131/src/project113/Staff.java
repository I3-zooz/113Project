package project113;

public class Staff extends Person implements FinancialOperations{

	protected double salary;
	protected int staffId;
	
	
	
	
	
	public Staff(String name, int id, int phone, double salary, int staffid) {
		super(name, id, phone);
		this.salary = salary;
		this.staffId = staffid;
	}



	public Staff(Staff s) {
		super(s);
		this.salary = s.salary;
		this.staffId = s.staffId;
	}

	
	

	@Override
	public double calculateAmount() {
		return salary;
	}

	@Override
	public boolean processPayment() {
		System.out.println("Payment of " + calculateAmount() + " processed for Staff: " + getName());
		return true;
	}

	@Override
	public void displayInfo() {
		System.out.println("Staff ID: " + staffId + " | Name: " + getName() + " | Phone: " + getPhone() +" | Salary: " + salary);
		
	}

	
	
	
}
