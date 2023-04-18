import java.sql.*;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) 
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db1","root","Akash@123");
			Statement st=con.createStatement();

			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
