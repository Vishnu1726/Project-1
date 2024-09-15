package PharmacyManagementSystem;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Medicine {
	
	private int ID;
	private String name;
	private String type;
	private int qty;
	private LocalDate manufacturedDate;
	private LocalDate expiryDate;
	private String company;
	private DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-dd-MM");
	
	public String getDateFormat() {
		return "yyyy-dd-MM" ;
	}
	public void setDateFormat (DateTimeFormatter dateFormatter) {
		this.dateFormatter = dateFormatter;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public String getManufacturedDate() {
		return "yyyy-dd-MM";
	}
	public void setManufacturedDate(String manufacturedDate) {
		this.manufacturedDate = LocalDate.parse(manufacturedDate, dateFormatter);
	}
	public String getExpiryDate() {
		return "yyyy-dd-MM";
	}
	public void setExpiryDate(String expiryDate) {
		this.expiryDate = LocalDate.parse(expiryDate, dateFormatter);
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	private double cost;

}
