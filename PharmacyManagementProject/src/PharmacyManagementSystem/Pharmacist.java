package PharmacyManagementSystem;

public class Pharmacist extends Employee {
	
	public Pharmacist() {
		super();
		this.options= new Option[] {
				
		};
	
	
	}

	@Override
	String getJob() {
		return "Pharmacist";
	}

}
