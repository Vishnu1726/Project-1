package PharmacyManagementSystem;

public class Manager extends Employee{

	public Manager() {
		super();
		this.options= new Option[] {
				new CreateEmployee(),
				new ReadAllEmployees(),
				new ReadEmployee(),
				new UpdateEmployee(),
				new DeleteEmployee(),
				new ChangePassword()
				
		};
	}
	@Override
	String getJob() {
		return "Manager";
	}
}
