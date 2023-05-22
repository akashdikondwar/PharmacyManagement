package entities;
import java.sql.SQLException;
import java.util.Scanner;
import DBImple.StockDBImpl;
import Main.Connections;

public class Stock 
{
	private int id;
	private String name;
	private String category;
	private int qty;
	private int expiry;
	private int price;
	Scanner sc=new Scanner(System.in);
	
StockDBImpl stockDB=new StockDBImpl();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public int getExpiry() {
		return expiry;
	}
	public void setExpiry(int expiry) {
		this.expiry = expiry;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
	
	
	public void addNewStock() throws SQLException
	{
		System.out.println("enter the name of med you want to add\n ");
		this.setName(sc.next());
		System.out.println("enter category");
		this.setCategory(sc.next());
		System.out.println("enter qty");
		this.setQty(sc.nextInt());
		System.out.println("enter expiry");
		this.setExpiry(sc.nextInt());
		System.out.println("enter price");
		this.setPrice(sc.nextInt());
		
		stockDB.addNewStock(this);
	}
	
	//	it returns amount of one medicine and checks qty available in stock or not
	public int sellStock(int id, int qty) throws SQLException
	{
		return stockDB.sellStock(id, qty);
	}
	
	//	gives list of medicines starting from given name 
	public void similarMeds(String medName) throws SQLException
	{
		stockDB.similarMeds(medName);
	}
	
	//	deducts medicine qty from stock
	public void updateStock(int medID, int qty) throws SQLException
	{
		stockDB.updateStock(medID, qty);
	}
		
}
	
