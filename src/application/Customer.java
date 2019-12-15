package application;

public class Customer extends User {
	/**
	 * OVERVIEW: This class creates Customer objects where each instance variable defined for a 
	 * 			 Customer can be accessed through setters & getters. These objects will then be 
	 * 			 stored in a ArrayList in the BankAccount Class.
	 * 
	 * 			 This class mutable as their are setters and getters which allow a pathway to an 
	 * 			 objects instance variables. 
	 */
	
	
	/****************************************************************/
	/* 					Instance variables							*/
	/****************************************************************/
	private String balance, level, id;
	
	/****************************************************************/
	/* 						  Constructor		     				*/
	/****************************************************************/
	
	/**
	 * This constructor sets the customer's username, password, role, balance, and level
	 * 
	 * @param username						username for the customer
	 * @param password						password for the customer
	 * @param role							role for the customer	
	 * @param balance						balance for the customer
	 * @param level							level for the customer 
	 * 
	 * Requires: username, password, role, balance, level is not null due to other method relying on actual String values
	 */
	public Customer(String username, String password, String role, String balance, String level, String id) {
		super(username, password, role);
		this.balance = balance;
		this.level = level;
		this.id = id;
	}
	
	
	/****************************************************************/
	/* 					    	Methods								*/
	/****************************************************************/
	
	/**
	 * Getter for the id
	 * 
	 * @return id 
	 */
	public String getId() {
		return id;
	}

	/**
	 * Setter for the id
	 *
	 * @param  id of the customer account
	 * 
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Getter for the balance
	 * 
	 * @return balance as a double
	 */
	public double getBalance() {
		return Double.parseDouble(balance);
	}
	
	/**
	 * Setter for the balance
	 *
	 * @param  balance of the customer account
	 * 
	 * Requires: balance is not null due to other method relying on actual String values
	 */
	public void setBalance(String balance) {
		this.balance = balance;
	}
	
	/**
	 * Getter for the balance
	 * 
	 * @return level of the customer account
	 */
	public String getLevel() {
		return level;
	}

	/**
	 * Setter for the level
	 *
	 * @param  level of the customer account
	 * 
	 * Requires: level is not null due to other method relying on actual String values
	 */
	public void setLevel(String level) {
		this.level = level;
	}
	
	public BankAccount makeBankAccount() {
		
		for(Customer acc: BankAccount.customerBankAccountList) {
			
			System.out.println("People in the account");
			System.out.println(acc.toString());
			if( this.getId() == acc.getId()) {
				return new BankAccount(this);
			}
		}
		return null;
	}
	
	/**
	 * The Abstraction Function
	 * All the information about a customer to be printed out
	 * E.g username, password, role, balance, and level
	 * 
	 * This method returns the customer's username, password, role, balance, level, and id
	 * 
	 * @return A string of the customer's information
	 */
	@Override
	public String toString() {
		String str1; 
		
		str1 = "Username: " + this.getUsername() + "\nPassword: " + this.getPassword() + "\nRole: "+ this.getRole() + "\nBalance: " + this.getBalance() + "\nLevel: " + this.getLevel() + "\nid: " + this.getId();
		return str1;
	}
	
	/**
	 * The Rep Invariant
	 * We want to check if the the Customer constructor received correct parameters. That is, no null's should be passed
	 * 
	 * @return a boolean which tells us if the Rep Invariant is true or false
	 */
	Boolean repOK() {
		Boolean check = false;
		
		if(super.getUsername() == null || super.getPassword() == null || super.getRole() == null || this.balance == null || this.level == null || this.id == null) {
			check = false;
		}else {
			check = true;
		}
		
		return check;
	}
	
}// End of Class
