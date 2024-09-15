package PharmacyManagementSystem;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
	
	public static void main(String[]args) {
		Scanner s = new Scanner(System.in);
		Database database = new Database();
		System.out.println("Welcome To Pharmacy Management");
		System.out.println("Enter Your Email: ");
		String email= s.next();
		System.out.println("Enter Your Password: ");
		String password = s.next();
		String select ="SELECT * FROM employees WHERE Email='"+email+
		"'AND Pass = '"+password+"';";//String select = "SELECT * FROM employees WHERE Email='" + email +
		//"' AND Password = '" + password + "';";
		
		
		try {
		ResultSet rs = database.getStatement().executeQuery(select);
		if(rs.next()) {
			Employee e;
			int job = rs.getInt("Job");
			switch(job) {
			case 1 :
				e= new Manager();
				break;
			case 2:
				e= new Pharmacist();
				break;
			case 3:
				e=new Cashier();
				default:
				e = new Employee() {
					@Override
					String getJob() {
						return null;
					}	
				};
				break;
				}
			e.setID(rs.getInt("ID"));
			e.setFirstName(rs.getString("FirstName"));
			e.setLastName(rs.getString("LastName"));
			e.setEmail(rs.getString("Email"));
			e.setPhoneNumber(rs.getString("PhoneNumber"));
			e.setPassword(rs.getString("Pass"));
			e.setSalary(rs.getDouble("Salary"));
			e.setDateOfBirth(rs.getString("DateOFBirth"));
			e.setWorkHours(rs.getInt("WorkHours"));
			e.setStartTime(rs.getString("StartTime"));
			e.setEndTime(rs.getString("EndTime"));
			e.showOptions(database, s);
			}
		else {
			System.out.println("Incorrect email or password");		
			}
		
		}catch(SQLException e) {
			e.printStackTrace();
		}
		}
		}
