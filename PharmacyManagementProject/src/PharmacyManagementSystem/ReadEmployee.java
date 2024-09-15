package PharmacyManagementSystem;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ReadEmployee implements Option{

	@Override
	public void oper(Database database, Scanner s, Employee e) {
		System.out.println("Enter Employee ID (int): (-1 to show all employees)");
		int ID = s.nextInt();
		while(ID<0) {
			System.out.println("Enter Employee ID (int): (-1 to show all employees)");
			ID = s.nextInt();
		}
		String select ="SELECT `ID`, `FirstName`, `LastName`, `Email`, `PhoneNumber`,"
				+ " `Salary`, `DateOFBirth`, `WorkHours`, `StartTime`, `EndTime`,"
				+ " `Job` FROM `employees` WHERE 'ID'=+ID+";
		try {
			ResultSet rs = database.getStatement().executeQuery(select);
			if(rs.next()) {
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
				emp.setID(ID);
				emp.setFirstName(rs.getString("FirstName"));
				emp.setLastName(rs.getString("LastName"));
				emp.setEmail(rs.getString("Email"));
				emp.setPhoneNumber(rs.getString("PhoneNumber"));
				emp.setSalary(rs.getDouble("Salary"));
				emp.setDateOfBirth(rs.getString("DateOFBirth"));
				emp.setWorkHours(rs.getInt("WorkHours"));
				emp.setStartTime(rs.getString("StartTime"));
				emp.setEndTime(rs.getString("EndTime"));
			}else {
				System.out.println("Employee doesn't exist");
			}
		}catch(SQLException ex){
			ex.printStackTrace();
		}
	}

	@Override
	public String getOption() {
		return "View Employee";
	}

}
