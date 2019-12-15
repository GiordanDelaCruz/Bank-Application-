package application.customerAccountLevel;

import application.BankAccount;

public class PlatinumLevel implements LevelState{

	/****************************************************************/
	/* 					Instance variables							*/
	/****************************************************************/
	BankAccount bankAccount;
	double newBalance = 0.00;
	double onlinePurchaseFee = 0.00;
	

	/****************************************************************/
	/* 						  Constructor		     				*/
	/****************************************************************/
	
	/**
	 * This constructor will set a reference to the current BankAccount object to our instance variable bankAccount
	 * 
	 * @param newBankAccount			reference to the particular BankAccount object
	 */
	public PlatinumLevel(BankAccount newBankAccount) {
		bankAccount = newBankAccount;
	}
	
	/****************************************************************/
	/* 					    	Methods								*/
	/****************************************************************/
	
	/**
	 * This method will perform a online purchase for a platinum level bank account
	 * 
	 * @param priceOfItem
	 * 
	 * @return customer's new bank account balance
	 */
	@Override
	public double onlinePurchase(double priceOfItem) {
		
		if(bankAccount.getBankAccountBalance() - (priceOfItem + onlinePurchaseFee) >= 0) {
			newBalance = bankAccount.getBankAccountBalance() - (priceOfItem + onlinePurchaseFee) ;
			System.out.println("Purchase of $" + priceOfItem + " was made, with a fee of $" + onlinePurchaseFee);
			System.out.println("Your new balance is  $" + newBalance );
		}else {
			newBalance = bankAccount.getBankAccountBalance();
			System.out.println("Unable to complete purchase");
		}
		
		return newBalance;
	}

}// End of Class
