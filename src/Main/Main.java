package Main;

import java.util.ArrayList;
import java.util.Scanner;
import DBImple.*;
import entities.*;
public class Main 

{
	
	public static String user;
	
	public static void main(String[] args) throws Exception //here also added exception
	{
		Login Log=new Login();
		Scanner sc=new Scanner(System.in);

		if (Log.checkLoginCredentials())
		{
			if(Log.getWork()==0)// 0 MEANS BILLER
			{
				int cont = 0;

				System.out.println("Hi "+user+"!\n you have only BILLING rights!! ");
				do {
						System.out.println("press 1 for new transaction..");
						int mode = sc.nextInt();
						if (mode==1) {}
						else if (mode==0)
							break;
						else
							continue;
						Customer cust=new Customer();
						cust.fetchCustomer();
						System.out.println("\n*****TRANSACTION STARTED*****\n");
						Stock stock1=new Stock();
						int num;
						String name;
						ArrayList<Cart> arr=new ArrayList<Cart>();
						do
						{
							
							System.out.println("enter name of medicine or starting from..");
							name=sc.next();
							Cart cart=new Cart();
							System.out.println("enter medID from follwing list..");
							stock1.similarMeds(name);
							int MedID=sc.nextInt();
							cart.medID=MedID;
							System.out.println("enter quantity also");
							int qty=sc.nextInt();
							cart.qty=qty;

							int amount=stock1.sellStock(MedID, qty);
							System.out.println("Amount: "+amount);
							cart.price=amount;
							System.out.println("do you want to add more? if yes, enter 1");
							arr.add(cart);
							num=sc.nextInt();						
						}while(num==1);
						
						int total=0;
						for (int i=0; i<arr.size(); i++)
						{
							total=total+arr.get(i).price;
							System.out.println(arr.get(i).medID+"-->"+arr.get(i).qty+"-->"+arr.get(i).price);
							stock1.updateStock(arr.get(i).medID, arr.get(i).qty);
						}
						System.out.println("total billing amount="+total);
				}while(cont==1);
			}
			else
			{
				System.out.println("You are admin!");
			}

		
		
		}

	}
}

/* one feature told by dada that if other biller is also selling same medicine and qty decreases while first biller 
 * is making bill, there might be error because qty might be decreased while making bill, that time the qty shouldn't decrease.
 * so we have to implement new method such that we will lock that much qty from the system and keep it locked until final step. 
 * if some error occurs, we will unlock those medicines
*/