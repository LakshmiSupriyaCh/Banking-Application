//Banking Application code
import java.util.*;
import java.io.*;
public class bankingApp
{

	public static void main(String[ ] args) throws IOException 
	{
	    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	    
	System.out.println(" Enter your NAME: ");
	String name= br.readLine();
	System.out.println(" Enter your Customer_ID: ");
	String userid= br.readLine();
	
	
		
		BankAccount bankAccount = new BankAccount(name,userid);
		bankAccount.showMenu();
	}
}

class BankAccount
	{
	private int balance;
	private int previousTransaction;
	private String customerName;
	private String customerId;

  BankAccount(String cname, String cid)
	{
		this.customerName = cname;
		this.customerId = cid;
	}

	public void deposit(int amount){
		if (amount != 0)
		{
			this.balance += amount;
			this.previousTransaction = amount;
		}
	}

	public void withDraw(int amount){
		if(amount > this.balance)
		{
			System.out.println("Insufficient balance, to withdraw the required " + amount +" amount");
		    
	}
		else if (amount > 0)
		{
			this.balance -= amount;
			this.previousTransaction = -amount;
			System.out.println("Your account balance has been updated successfully");
		}
		else 
			System.out.println("Invalid amount entered for withdrawal");
	}

	public void previoustransactionmeth(){
		if(this.previousTransaction > 0)
		{
			System.out.println("Credited :  Rs." + this.previousTransaction);
		}
		else if (this.previousTransaction < 0){
			System.out.println("Debited :  Rs." +Math.abs(previousTransaction));
		}
		else{
			System.out.println("No Transactions occured");
		}
	}

	public void showMenu(){
		char option = '\0';
		Scanner scanner = new Scanner(System.in);

		System.out.println("Welcome " + this.customerName);
		System.out.println("Customer_ID: " + this.customerId);
		System.out.println("\n");
		
		do {
		System.out.println("Choose your option from the below list:");
		//System.out.println("\n");
		System.out.println("A.Check Balance");
		System.out.println("B.Deposit");
		System.out.println("C.WithDraw");
		System.out.println("D.Previous Transaction");
		System.out.println("E. Exit");
		
			System.out.println("Enter an option:");
			option = scanner.next().charAt(0);
			System.out.println("------------------------------------------------------------------");

			switch (option){
				case 'A':
				case 'a':
					System.out.println("Available Balance = " + this.balance);
					System.out.println("------------------------------------------------------------------");
					break;
				case 'B':
				case 'b' :
					System.out.println("Enter an amount to deposit: ");
					int amount = scanner.nextInt();
					this.deposit(amount);
					System.out.println("Your account balance has been updated successfully!");
					System.out.println("------------------------------------------------------------------");
					System.out.println("\n");
					break;
				case 'C':
				case 'c':
					int amount2;
					try {
						   System.out.println("Enter an amount to withdraw: ");
						   amount2 = scanner.nextInt();
					}
				    catch (InputMismatchException e)
					{
			               System.out.print("Invalid number! ");
			               System.out.println("\n");
			               continue;
					}
				    this.withDraw(amount2);
					System.out.println("\n");
					break;
				case 'D':
				case 'd':
					this.previoustransactionmeth();
					break;
				case 'E':
				case 'e':
					System.out.println("***************************");
					System.out.println("Logging Out!");
					break;
					
				default:
					System.out.println("Invalid Option! Please check and enter again!");
					break;
			}
		} while (option != 'E' && option != 'e');

		System.out.println("Thank you for using our services!");
	}
}