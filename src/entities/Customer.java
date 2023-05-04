package entities;
import java.sql.SQLException;
import java.util.Scanner;

import DBImple.CustomerDBImpl;


public class Customer 
{
	private int customerID;
	private String name;
	private long phone;
	private String address;
	CustomerDBImpl customerdb=new CustomerDBImpl();
	
	Scanner sc=new Scanner(System.in);
	
	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	public boolean checkIfCustomerExist() throws SQLException
	{
		System.out.println("enter phone no.");
		long phone=sc.nextLong();
		if(customerdb.checkIfCustomerExist(this ,phone))//this keyword article read. this keyword ke jagah pe current object hai is class ka.
		{
			System.out.println(" customer found \n name:"+this.getName()+"\n address:"+this.getAddress());
			return true;
		}
		else
		{
			System.out.println("phone no. doesn't exist. so add new customer details");
			return false;
		}
	}
	
	
	public void fetchCustomer() throws SQLException
	{
		if(!checkIfCustomerExist())
		{
			System.out.println("enter new customer name:");
			this.setName(sc.next());
			System.out.println("enter new customer phoneNo.:");
			this.setPhone(sc.nextLong());
			System.out.println("enter new customer address:");
			this.setAddress(sc.next());
			
			customerdb.addNewCustomerDetails(this);
		}
	}
	
}
