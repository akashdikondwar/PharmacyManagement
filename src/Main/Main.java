package Main;

import entities.Customer;

public class Main {
	
	public static String user;
	
	public static void main(String[] args) throws Exception //here also added exception
	{
		Customer cust=new Customer();

		cust.fetchCustomer();
		
		
	}

}
