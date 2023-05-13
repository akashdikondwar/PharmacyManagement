package entities;
import java.sql.SQLException;
import java.util.Scanner;
import DBImple.LoginDBImpl;
import Main.Main;

public class Login 
{
	private String userID;
	private String password;
	
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) 
	{
		this.userID = userID;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	Scanner sc=new Scanner(System.in);
	LoginDBImpl dbimpl=new LoginDBImpl();

	public void addNewLogin() throws SQLException
	{
		String newUserId;
		
		System.out.println("enter new userID");
		newUserId=sc.next();
		if(dbimpl.checkUsername(newUserId))
		{
			System.out.println("username already exist!!");
			return;
		}
		
		setUserID(newUserId);
		System.out.println("enter new password");
		setPassword(sc.next());
		dbimpl.addNewLoginDetails(getUserID(),getPassword());
	    System.out.println("new login details added successfully!!");

	
	}
	
	
	
	public void checkLoginCredentials() throws SQLException
	{
		
		String user = null;
		String pass = null;
		System.out.println("enter your userID");
		user=sc.next();
		System.out.println("enter your Password");
		pass=sc.next();
		
		if (dbimpl.checkUsername(user))
		{
			if(dbimpl.checkPassword(user, pass))
			{
				Main.user=user;//setting logged in user
				System.out.println(user+" login successful");
			}
			
			else 
			{
				System.out.println("incorrect credentials");
			}
		}
		else
		{
			System.out.println("user not in the system");
		}
	}
	
	public void changePassword() throws SQLException
	{
		String user=Main.user;
		String pass;
		System.out.println("enter your old password");
		pass=sc.next();
		
		if(dbimpl.checkPassword(user, pass))
		{
			System.out.println("enter new password:");
			pass=sc.next();
			dbimpl.updatePassword(user, pass);
			
		}
		
		else 
		{
			System.out.println("wrong credentials!!");
		}
	}
	
}
