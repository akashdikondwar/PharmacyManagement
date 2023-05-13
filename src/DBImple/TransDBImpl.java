package DBImple;
import Main.Connections;


public class TransDBImpl 
{
	Connections con=new Connections();
	
	public void newTransaction()
	{
		con.st.executeUpdate("insert into transaction (Customerid, medid,qty) values
	}
}
