package PharmacyManagementSystem;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public abstract class Employee {
	
	private int ID;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private String password;
	private double salary;
	private LocalDate dateOfBirth;
	private int workHours;
	private LocalTime startTime;
	private LocalTime endTime;
	protected Option[] options;
	private DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-dd-MM");
	private DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm"); 
	
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getPass() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getDateOfBirth() {
		return dateFormatter.format(dateOfBirth);
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = LocalDate.parse(dateOfBirth, dateFormatter);
	}
	public int getWorkHours() {
		return workHours;
	}
	public void setWorkHours(int workHours) {
		this.workHours = workHours;
	}
	public String getStartTime() {
		return timeFormatter.format(startTime);
	}
	public void setStartTime(String startTime) {
		this.startTime = LocalTime.parse(startTime,timeFormatter);
	}
	public String getEndTime() {
		return timeFormatter.format(endTime);
	}
	public void setEndTime(String endTime) {
		this.endTime = LocalTime.parse(endTime, timeFormatter);
	}
	public Option[] getOptions() {
		return options;
	}
	public void setOptions(Option[] options) {
		this.options = options;
	}
	public String getDateFormat() {
		return "yyyy-dd-MM";
	}
	public String getTimeFormat() {
		return "HH:mm";
	}
	
	abstract String getJob();
	
	public void showOptions(Database database, Scanner s) {
		for(int i=0;i<options.length;i++) {
			System.out.println((i+1)+". "+options[i].getOption());
		}
		int i=s.nextInt();
		options[i-1].oper(database, s, this);
		showOptions(database,s);
	}
	public void print() {
		System.out.println("ID:\t\t"+getID());
		System.out.println("Name:\t\t"+getFirstName()+" "+getLastName());
		System.out.println("Email:\t\t"+getEmail());
		System.out.println("Phone Number:\t"+getPhoneNumber());
		System.out.println("Salary:\t\t"+getSalary());
		System.out.println("Date of Birth:\t"+getDateOfBirth());
		System.out.println("Work Hours:\t"+getWorkHours());
		System.out.println("Start Time:\t"+getStartTime());
		System.out.println("End Time:ad\t"+getEndTime());
		System.out.println("Job:\t"+getJob());
		System.out.println("--------------------------------------");
	}
}
