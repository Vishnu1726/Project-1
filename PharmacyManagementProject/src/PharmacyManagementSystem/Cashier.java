package PharmacyManagementSystem;

public class Cashier extends Employee {
	
	public Cashier() {
		super();
		this.options= new Option[] {	
		};
	}
	@Override
	String getJob() {
		return "Cashier";
	}
	
}