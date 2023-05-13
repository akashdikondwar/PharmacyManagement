package DBImple;
import java.sql.*;

import Main.Connections;
import entities.Stock;


public class StockDBImpl 
{
	Connections con=new Connections();
	
	public void addNewStock(Stock stock) throws SQLException
	{
		con.st.executeUpdate("insert into stock (name,category,qty,expiry,price)values("+stock.getName()+","+stock.getCategory()+","+stock.getQty()
+","+stock.getExpiry()+","+stock.getPrice()+")"	);
		
		ResultSet set=con.st.executeQuery("select * from stock order by name,expiry");
	}
	
	public void sellStock(String med, int qty) throws SQLException
	{
		con.st.executeUpdate("update stock set quantity=quantity-"+qty+"where medicine_name="+med);
	}
}

