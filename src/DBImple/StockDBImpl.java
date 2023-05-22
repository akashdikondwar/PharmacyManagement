package DBImple;
import java.sql.*;
import entities.Cart;

import Main.Connections;
import entities.Stock;


public class StockDBImpl 
{
	
	public void addNewStock(Stock stock) throws SQLException
	{
		Connections con=new Connections();

		con.st.executeUpdate("insert into stock (name,category,qty,expiry,price)values("+stock.getName()+","+stock.getCategory()+","+stock.getQty()
		+","+stock.getExpiry()+","+stock.getPrice()+")"	);
			
	}
	
	//	 same as updateStock method of stock class
	public void updateStock(int id, int qty) throws SQLException
	{
		Connections con=new Connections();
		con.st.executeUpdate("update stock set Available_qty=Available_qty-"+qty+" where id="+id);
	}
	
	//	same as sellStock method in stock class
	public int sellStock(int id,int qty) throws SQLException
	{
		Connections con=new Connections();

		int x=0;
		ResultSet set=con.st.executeQuery("select * from stock where id="+ id);
		System.out.println("hello world");
		if (set.next()) {
			if(set.getInt("available_qty") >= qty)
			{
				x = set.getInt("price")*qty;			
			}
			else
			{
				System.out.println("not sufficient qty");
				return 0;
			}			
		}
		return x;
	}
		
	//	same as similarMeds method of Stock class
	public void similarMeds(String med) throws SQLException
	{
		Connections con=new Connections();

		ResultSet set=con.st.executeQuery("select * from stock where medicine_Name like '"+med+"%'");
		while(set.next())
		{
			System.out.println(set.getInt("id")+". "+set.getString("medicine_name")+"\n");
		}
		con.st.close();
	}
}

