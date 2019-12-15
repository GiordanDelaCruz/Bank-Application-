package application;

import application.customerAccountLevel.*;
import javafx.scene.control.ListView;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import application.User;
import application.Customer;
import application.AlertBox;

import java.awt.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class BankAccount {
	
	/****************************************************************/
	/* 					Instance variables							*/
	/****************************************************************/
	LevelState levelState, silverState, goldState, platinumState;
	
	// ArrayList which will store all the information about a customers account and information
	static ArrayList<Customer> customerBankAccountList = new ArrayList<Customer>();
	
	Customer customer;
	
	
	/****************************************************************/
	/* 						  Constructor		     				*/
	/****************************************************************/
	
	/**
	 * This constructor will add a customer to the customerBankAccountList
	 * 
	 * @param customer
	 * @requires customer is not null
	 */
	public BankAccount(Customer customer) {
		this.customer = customer;
		customerBankAccountList.add(customer);
		
		CustomerController.addBankAccountList(this);
		
		silverState = new SilverLevel(this);
		goldState = new GoldLevel(this);
		platinumState = new PlatinumLevel(this);
		
		levelState = silverState;
		
	}
	
	
	/****************************************************************/
	/* 					    	Methods								*/
	/****************************************************************/
	
	/**
	 * This method adds a specified customer object from the customerBankAccountList
	 * 
	 * @param customer
	 * @requires customer is not null
	 * @modifies customerBankAccountList
	 */
	public static void addBankAccount(Customer customer) {
		customerBankAccountList.add(customer);	
		customer.makeBankAccount();
	}
	
	/**
	 * This method removes a specified customer object from the customerBankAccountList
	 * 
	 * @param customer
	 * @requires customer is not null
	 * @modifies customerBankAccountList
	 */
	public static void removeBankAccount(Customer customer) {
		customerBankAccountList.remove(customer);	
	}
	
	/**
	 * This method checks if this specific customer is found within our customerBankAccountList
	 * 
	 * @param customer
	 * @return a boolean whether the customer's bank account exist
	 */
	public boolean checkIfCustomerAccountExist(BankAccount bankAccount) {
		boolean check = false;
		
		for(int i = 0; i < customerBankAccountList.size() - 1; i++) {
			
			if( customerBankAccountList.contains(customer) ) {
				check = true;
			}
		}// End of For Loop
		
		return check;
	}
	
	
	/**
	 *  This methods get's the customer for this specified bank account object
	 *  
	 *  @return User
	 */
	public Customer getCustomer() {
		return this.customer;
	}
	
	/**
	 * This method returns a customer's account balance if their account exists within the customerBankAccountList, 
	 * else return a balance of 0.0
	 * 
	 * @param customer
	 * @return returns customer's balance
	 */
	public double getBankAccountBalance() {
		
		double balance = 0.0;
		
				if( customerBankAccountList.contains(this.getCustomer() ) ) 
				{	
					balance = this.getCustomer().getBalance();
				}
				
			return balance;
		}
	
	/**
	 * This method will update the levelState based on newLevelState
	 * 
	 * @param newLevelState							
	 * @requires newLevelState is not null
	 * @modifies levelState
	 */
	public void setLevelState(LevelState newLevelState) {
		levelState = newLevelState;
	}
	
	/**
	 * This method will return the levelState of a current BankAccount object
	 * 
	 * @return
	 */
	public LevelState getLevelState() {
		return levelState;
	}
	
	/**
	 * This method will perform a online purchase if the (customerAccountBalance > 0) & (customerAccountBalance >= priceOfItem), 
	 * and if the priceOfItem >= $50.00, else perform no purchase. The customer's account balance will be returned.
	 * 
	 * @param priceOfItem
	 * 
	 * @return the customer's account balance
	 */
	public double onlinePurchase(double priceOfItem) {
		
		/**
		 * If the customer's bank account balance is greater than or equal to 0.0, greater than or equal to the price of the item, 
		 * and the price of the item must be greater than or equal to 50.00, perform the purchase, 
		 * else return the customer's balance. In other words, 
		 *
	     * If customer.getBalance() >= 0.0 && customer.getBalance() >= 0.0 && priceOfItem >= 50.00 then purchase the item
		 * else return customer.getBalance() 
		 */
		if(this.getBankAccountBalance() >= 0.0 && this.getBankAccountBalance() >= priceOfItem && priceOfItem >= 50.00) {
			
			// Silver level account
			if(this.getBankAccountBalance() < 10000 )
			{ 
				this.setLevelState(silverState);
				
			}// Gold Level Account	 
			else if(this.getBankAccountBalance() >= 10000 && this.getBankAccountBalance() < 20000)
			{
				this.setLevelState(goldState);
				
			}// Platinum Level Account
			else {
				 this.setLevelState(platinumState);
			}
			
			return levelState.onlinePurchase(priceOfItem);
			
		}else {
			AlertBox.display("Unsuccessful Purchase", "Unable to complete purchase. Please make sure the item you are trying to purchase is above $50.00 and that your funds and fee for account level are suficient to complete the purchase.");
			return this.getBankAccountBalance();
		}	
	}
	

}// End of Class
