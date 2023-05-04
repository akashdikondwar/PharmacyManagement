package entities;
import java.sql.*;
import java.util.Scanner;
import Main.Connections;


public class CheckLogin
{
	private String id;
	private String password;
	
	public void Checker() throws SQLException//not used try catch and first i made this as constructor but in below else block constructor cant be called recursively
	{
		Connections con=new Connections();
		System.out.println("enter your login id");
		Scanner scan=new Scanner(System.in);
		
		id=scan.next();
		System.out.println("enter your password");
		password=scan.next();
		
		ResultSet set=con.st.executeQuery("select * from login where username="+ id +"and password="+ password);
		
		if (set.next())
		{
			System.out.println("login successful !!!");
		}
		else 
		{
			System.out.println("login error... please enter correct login details");
			Checker();// 
		}
	}
}
