package DBImple;
import Main.Connections;
import java.sql.*;

public class LoginDBImpl 
{
	Connections con=new Connections();

	public boolean checkUsername(String userID) throws SQLException
	{
		ResultSet set= con.st.executeQuery("select * from login where username='"+userID+"'");
		if(set.next())
			return true;

		else
			return false;
	}
	
	public boolean checkPassword(String userID, String pass) throws SQLException
	{
		ResultSet set=con.st.executeQuery("select * from login where username='"+userID+"' and password='"+pass+"'");
		
		if(set.next())
		{
			return true;
		}
		
		else
		{
			return false;
		}
	}
	
	public void addNewLoginDetails(String userID, String password) throws SQLException
	{
	    con.st.executeUpdate("insert into login (username,password) values(" +"'"+userID+"'"+  ","+"'"+password+"'"+")");
	}
	
	public void updatePassword(String user, String pass) throws SQLException
	{
		con.st.executeUpdate("update login set password='"+pass+"' where username='"+user+"'" );
	}
}
