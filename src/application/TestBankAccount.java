package application;

public class TestBankAccount {

	public static void main(String[] args) {
		
		// Creating customers & a manager
		User customer1 = new Customer("roxx138", "pikapika123", "customer", "18000.0", "gold", "1234");
		User customer2 = new Customer("gexery97", "oneForAll138", "customer", "49.0", "silver", "3421");
		User customer3 = new Customer("giorn", "Giuts123!", "customer", "20000.0", "platinum", "3421");
		User customer4 = new Customer("pika", "poop", "customer", "500", "silver", "3345");

		// Creating bank accounts
		BankAccount bankAccount1 = new BankAccount( (Customer) customer1);
		BankAccount bankAccount2 = new BankAccount( (Customer) customer2);
		BankAccount bankAccount3 = new BankAccount( (Customer) customer3);
		BankAccount bankAccount4 = new BankAccount( (Customer) customer4);
		
		// Creating the only Manager instance
		User theOnlyManager = Manager.getManager();
	
		// Printout the customerBankAccountList
		for(Customer customer: BankAccount.customerBankAccountList) {
			System.out.println(customer.getUsername() + " is in the customerBankAccountList and has a balance of $" + customer.getBalance());
		}

		// Seeing if the customers were created
		System.out.println("\nFor customer1:");
		System.out.println("Class: " + customer1.getClass() );
		System.out.println("Username: " + customer1.getUsername() );
		System.out.println("Password: " + customer1.getPassword() );
		System.out.println("Role: " + customer1.getRole() );
		System.out.println("Balance: " + ((Customer) customer1).getBalance() );
		System.out.println("Account level: " + ((Customer) customer1).getLevel() );
		
//		System.out.println("\nFor customer3:");
//		System.out.println("Class: " + customer3.getClass() );
//		System.out.println("Username: " + customer3.getUsername() );
//		System.out.println("Password: " + customer3.getPassword() );
//		System.out.println("Role: " + customer3.getRole() );
//		System.out.println("Balance: " + ((Customer) customer3).getBalance() );
//		System.out.println("Account level: " + ((Customer) customer3).getLevel() );
//		
		// Seeing if the bank Accounts were created
		System.out.println("\nBank account balance for " + bankAccount1.getCustomer().getUsername() + " is $" + bankAccount1.getBankAccountBalance());
		System.out.println("Trying to make an online purchase,");
		System.out.println("The new balance after buying the $59.00 item is $" + bankAccount1.onlinePurchase(59.00) );
		
		System.out.println("\nBank account balance for " + bankAccount2.getCustomer().getUsername() + " is $" + bankAccount1.getBankAccountBalance());
		System.out.println("Trying to make an online purchase,");
		System.out.println("The new balance after buying the $59.00 item is $" + bankAccount2.onlinePurchase(59.00) );
		
		System.out.println("\nBank account balance for " + bankAccount3.getCustomer().getUsername() + " is $" + bankAccount1.getBankAccountBalance());
		System.out.println("Trying to make an online purchase,");
		System.out.println("The new balance after buying the $59.00 item is $" + bankAccount3.onlinePurchase(59.00) );
		
		System.out.println("\nBank account balance for " + bankAccount4.getCustomer().getUsername() + " is $" + bankAccount4.getBankAccountBalance());
		System.out.println("Trying to make an online purchase,");
		System.out.println("The new balance after buying the $50.00 item is $" + bankAccount4.onlinePurchase(50.00) );
		
		// Manager
		System.out.println("\nFor the only manager");
		System.out.println("Username: " + Manager.getManager().getUsername() );
		System.out.println("Password: " + theOnlyManager.getPassword() );
		System.out.println("Role: " + theOnlyManager.getRole() );
	
		String test = "admin";
		if( test.equals(Manager.getManager().getUsername() ) ){
			System.out.println("VALID USERNAME");			
		}
		
		
	
	}

}
