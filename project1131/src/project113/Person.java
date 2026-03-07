package project113;

public abstract class Person {
	
	
	
	protected String name;
	protected int id;
	protected int phone;
	
	 

	public Person(String name, int id, int phone) {
	
		this.name = name;
		this.id = id;
		this.phone = phone;
	}

	
	public Person(Person p) {
		
		name =p.name;
		id = p.id;
		phone = p.phone;
	}
	
	
public abstract void displayInfo() ;
	
	
	

	public String getName() {return name;}


	public void setName(String name) {this.name = name;}


	public int getId() {return id;}


	public void setId(int id) {this.id = id;}


	public int getPhone() {return phone;}


	public void setPhone(int phone) {this.phone = phone;}


	
}
