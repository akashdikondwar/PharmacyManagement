package DBImple;

import java.sql.ResultSet;
import java.sql.SQLException;

import Main.Connections;
import entities.Customer;

public class CustomerDBImpl 
{
	Connections con=new Connections();
//	Customer cust=new Customer();
	
	public boolean checkIfCustomerExist(Customer customer,long phone) throws SQLException
	{
		ResultSet set=con.st.executeQuery("select * from customer where phone="+phone);
		if (set.next())
		{
			customer.setName(set.getString("name"));
			customer.setPhone(set.getLong("phone"));
			customer.setAddress(set.getString("address"));
			customer.setCustomerID(set.getInt("customerid"));
			return true;
		}
		return false;
	}
	
	public void addNewCustomerDetails(Customer customer) throws SQLException
	{
		con.st.executeUpdate("insert into customer (name,phone,address) values ('"+customer.getName()+"',"+customer.getPhone()+",'"+customer.getAddress()+"')");
	}
}
