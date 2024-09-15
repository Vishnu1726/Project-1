package PharmacyManagementSystem;

import java.sql.SQLException;
import java.util.Scanner;

public class CreateEmployee implements Option{

	@Override
	public void oper(Database database, Scanner s, Employee e) {
		System.out.println("Enter First Name: ");
		String firstName = s.next();
		System.out.println("Enter Last Name: ");
		String lastName = s.next();
		System.out.println("Enter Email: ");
		String email = s.next();
		System.out.println("Enter Phone Number");
		String phoneNumber = s.next();
		System.out.println("Enter Password : ");
		String password = s.next();
		System.out.println("Enter Salary(double): ");
		double salary = s.nextDouble();
		System.out.println("Enter Date of Birth (yyyy-dd-MM): ");
		String dateOfBirth  = s.next();
		System.out.println("Enter Work Hours (int): ");
		int workHours = s.nextInt();
		System.out.println("Enter Start Time (HH:mm): ");
		String startTime = s.next();
		System.out.println("Enter End Time (HH:mm): ");
		String endTime = s.next();
		System.out.println("Enter the Job:\n1. Manager\n2. Pharmacist\n3. Cashier ");
		String job=s.next();
		
		String insert = "INSERT INTO `Employees`( `FirstName`, `LastName`, `Email`,"
				+"`PhoneNumber`, `Pass`, `Salary`, `DateOFBirth`, `WorkHours`,"
				+"`StartTime`, `EndTime`, `Job`) VALUES ('"+firstName+"','"+lastName+
				"','"+email+"','"+phoneNumber+"','"+password+"','"+salary+"','"+
				dateOfBirth+"','"+workHours+"','"+startTime+"','"+endTime+"','"+job+"');";
		try {
		database.getStatement().execute(insert);
		System.out.println("Employee Added Successfully");
	}catch(SQLException e1){
		e1.printStackTrace();
	} 
	}
	
	@Override
	public String getOption() {
		return "Add new Employee";
	}

}
