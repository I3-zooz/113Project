package project113;

public class Doctor extends Staff {
	
	private String specialty ;
	
	
public Doctor(String name, int id, int phone, double salary, int staffid,String specialty) {
		super(name, id, phone, salary, staffid);
		this.specialty=specialty;

	}

@Override
public double calculateAmount() {
	return super.calculateAmount()+5000;
}

@Override
public boolean processPayment() {
	return super.processPayment();
}

@Override
public void displayInfo() {
	super.displayInfo();
	System.out.println("Specialty: " + specialty);	
}


}
