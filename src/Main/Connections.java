package Main;
import java.sql.*;

public class Connections
{
	public Statement st;
	public Connection conn;
	
	public Connections()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); //load driver
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmadb","root","Akash@123");	//create connection
			st = conn.createStatement(); //create statement object
		}
		catch (Exception e) {
			System.out.println("Connection not Established!!..");//exception is required when compiler doesn't know when the error can occur.
		}
	}
}
