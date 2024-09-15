package PharmacyManagementSystem;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadAllEmployees implements Option {

	@Override
	public void oper(Database database, Scanner s, Employee e) {
		String select ="SELECT `ID`, `FirstName`, `LastName`, `Email`, `PhoneNumber`,"
				+ " `Salary`, `DateOFBirth`, `WorkHours`, `StartTime`, `EndTime`,"
				+ " `Job` FROM `Employees`";
		ArrayList<Employee> employees= new ArrayList<>();
		try {
		
	ResultSet rs = database.getStatement().executeQuery(select);
	while(rs.next()) {
		Employee emp;
		int job = rs.getInt("Job");
		switch(job) {
		case 1 :
			emp= new Manager();
			break;
		case 2:
			emp= new Cashier();
			break;
		case 3:
			emp=new Pharmacist();
		default:
			emp = new Employee() {
				@Override
				String getJob() {
					return null;
				}
			};
			break;
			}
		emp.setID(rs.getInt("ID"));
		emp.setFirstName(rs.getString("FirstName"));
		emp.setLastName(rs.getString("LastName"));
		emp.setEmail(rs.getString("Email"));
		emp.setPhoneNumber(rs.getString("PhoneNumber"));
		emp.setSalary(rs.getDouble("Salary"));
		emp.setDateOfBirth(rs.getString("DateOFBirth"));
		emp.setWorkHours(rs.getInt("WorkHours"));
		emp.setStartTime(rs.getString("StartTime"));
		emp.setEndTime(rs.getString("EndTime"));
		employees.add(emp);
		}
	}catch(SQLException e1) {
		e1.printStackTrace();
	}
		for (Employee emp : employees) {
			emp.print();
		}
	}
	@Override
	public String getOption() {
		return "View All Employees";
	}

}
