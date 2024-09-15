package PharmacyManagementSystem;

import java.sql.SQLException;
import java.util.Scanner;

public class ChangePassword implements Option {

	@Override
	public String getOption() {
		return "Change Password";
	}

	@Override
	public void oper(Database database, Scanner s, Employee e) {
		System.out.println("Enter your Old password");
		String oldPassword=s.next();
		if(!e.getPass().equals(oldPassword)) {
			System.out.println("Incorrect password");
			return;
		}else {
			String pass,confirmPassword;
			do {
				System.out.println("Enter new Password: ");
				pass=s.next();
				System.out.println("Confirm Password: ");
				confirmPassword=s.next();
			}while(!pass.equals(confirmPassword));
			String update="UPDATE 'employees' SET 'Password'='"+pass+
					"' WHERE 'ID'= "+e.getID()+";";
			try {
				database.getStatement().executeQuery(update);
			}catch(SQLException e1) {
				e1.printStackTrace();
			}
		}
		
	}

}
