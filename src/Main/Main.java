package Main;
import java.sql.*;
import java.util.Scanner;

import entities.CheckLogin;
import entities.Login;

public class Main {
	
	 public static String user;
	
	public static void main(String[] args) throws Exception //here also added exception
	{
		switch() 
		{

		case 1:
			
		}
		Login log=new Login();
		
		log.checkLoginCredentials();
		log.changePassword();
		log.addNewLogin();
		
		
		
	}

}
