package application;

import java.io.IOException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CustomerController {

	/****************************************************************/
	/* 					Instance variables							*/
	/****************************************************************/
	   double newBalance;
	   double priceOfItem1 = 80.00;
	   double priceOfItem2 = 40.00;
	   static ArrayList<BankAccount> bankAccountList = new ArrayList<BankAccount>();
	
	   @FXML private Button depositButton;
	   @FXML private Button withdrawButton;
	   @FXML private Button getBalanceButton;
	   @FXML private Button onlinePurchaseButton1;
	   @FXML private Button onlinePurchaseButton2;
	   @FXML private Button logoutButton;	 
	   
	   @FXML private TextField depositTextField;
	   @FXML private TextField withdrawTextField;
       @FXML private Text getBalanceLabel;
//     @FXML private Text accountLevelTextDisplay;
//     @FXML private Text accountLevelText;
//	   @FXML private ImageView imageView1;
//	   @FXML private ImageView imageView2;
	   
	/****************************************************************/
	/* 					    	Methods								*/
	/****************************************************************/
		  
	   
	   /**
	    * This method returns to the login scene when called
	    * 
	    * @param event
	    */
	   public void logout(ActionEvent event) {
	
		try {
			// Read file fxml and draw interface for Manager Scene.
	           Parent root2;
	           root2 = FXMLLoader.load(getClass()
			           .getResource("/application/LoginScene.fxml"));
	           
	           Scene loginScene = new Scene(root2);
	           
	           // Retrieve Stage information 
	           Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
	           
	           window.setScene(loginScene);
	           window.show();
	           	           
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}       
	   }// End of logout()
	   
	   /**
	    * This method purchases the current item if certain conditions such as balance and price of the item
	    * are in accordance to the specification.
	    * 
	    * Price of item: $80.00
	    * 
	    * @param event 
	    */
	   public void onlinePurchase1(ActionEvent event) {

		   // Loop through all the customers found within the customerBankAccountList
		   for(Customer customerAcc: BankAccount.customerBankAccountList) {
			  
			   // Get the correct bankaccount of the current customer using the application
			   if(customerAcc.getId() == LoginController.currentCustomer.getId() ) {
				  
				   // Loop through all the bank account of the customers found within the bankAccountList
				   for(BankAccount bankAcc: bankAccountList) {
					   
					   if( bankAcc.getCustomer().getId() == LoginController.currentCustomer.getId() ) {
						   System.out.println("The current balance is " + bankAcc.getCustomer().getBalance());
						   newBalance = bankAcc.onlinePurchase(80.00);
						   bankAcc.getCustomer().setBalance(String.valueOf(newBalance));
						   getBalanceLabel.setText( String.valueOf( bankAcc.getCustomer().getBalance() ) );
//						   accountLevelText.setText( String.valueOf( bankAcc.getCustomer().getLevel() ) );
					   }		   
				   }   
			   }   
		   }
		   
	   }// End of onlinePurchase1
	   
	   
	   /**
	    * This method purchases the current item if certain conditions such as balance and price of the item
	    * are in accordance to the specification.
	    * 
	    * Price of item: $40.00
	    * 
	    * @param event 
	    */
	   public void onlinePurhcase2(ActionEvent event) {
			
		// Loop through all the customers found within the customerBankAccountList
		   for(Customer customerAcc: BankAccount.customerBankAccountList) {
			   
			   // Get the correct bankaccount of the current customer using the application
			   if(customerAcc.getId() == LoginController.currentCustomer.getId() ) {
				   
				   // Loop through all the bank account of the customers found within the bankAccountList
				   for(BankAccount bankAcc: bankAccountList) {
					   
					   if( bankAcc.getCustomer().getId() == LoginController.currentCustomer.getId() ) {
						   System.out.println("The current balance is " + bankAcc.getCustomer().getBalance());
						   newBalance = bankAcc.onlinePurchase(40.00);
						   bankAcc.getCustomer().setBalance(String.valueOf(newBalance));
						   getBalanceLabel.setText( String.valueOf( bankAcc.getCustomer().getBalance() ) );
//						   accountLevelText.setText( String.valueOf( bankAcc.getCustomer().getLevel() ) );

					   }		   
				   }   
			   }   
		   }
			   
		   }// End of logout()
	   
	   
	    /**
	     * This method adds a bank account to the bankAccountList found inside this class.
	     * That is, the bankAccountList found within the CustomerController class
	     * 
	     * @param bankAccount
	     */
		public static void addBankAccountList(BankAccount bankAccount) 
		{
		bankAccountList.add(bankAccount);
		}
		
		/**
		 * This method deposits money in the account
		 * 
		 * @param event
		 */
		public void deposit(ActionEvent event) {
			
			try {
				double amount = Double.parseDouble(depositTextField.getText());
				
				// Loop through all the customers found within the customerBankAccountList
				   for(Customer customerAcc: BankAccount.customerBankAccountList) {
					   
					   // Get the correct bankaccount of the current customer using the application
					   if(customerAcc.getId() == LoginController.currentCustomer.getId() ) {
						   
						   // Loop through all the bank account of the customers found within the bankAccountList
						   for(BankAccount bankAcc: bankAccountList) {
							   
							   if( bankAcc.getCustomer().getId() == LoginController.currentCustomer.getId() ) {
								   if(amount > 0.0) {
									   System.out.println("The current balance is " + bankAcc.getCustomer().getBalance());
									   bankAcc.getCustomer().setBalance(  String.valueOf(bankAcc.getCustomer().getBalance() + amount ) );
									   getBalanceLabel.setText( String.valueOf( bankAcc.getCustomer().getBalance() ) );
//									   accountLevelText.setText( String.valueOf( bankAcc.getCustomer().getLevel() ) );
									   
								   }else {
							    	   AlertBox.display("Invalid Deposit", "Unable to deposit the specified value. Please ensure you have entered a valid amount.");

								   }

							   }
							   	   
						   }   
					   }   
				   }

			}catch(Exception e) {
		    	   AlertBox.display("Invalid Deposit", "Unable to deposit the specified value. Please ensure you have entered a valid amount.");

			}
				   
		}// End of deposit()
		
		
		/**
		 * This method withdraws money in the account
		 * 
		 * @param event
		 */
		public void withdraw(ActionEvent event) {
			
			try {
				double amount = Double.parseDouble(withdrawTextField.getText());
				
				// Loop through all the customers found within the customerBankAccountList
				   for(Customer customerAcc: BankAccount.customerBankAccountList) {
					   
					   // Get the correct bankaccount of the current customer using the application
					   if(customerAcc.getId() == LoginController.currentCustomer.getId() ) 
					   { 
						   // Loop through all the bank account of the customers found within the bankAccountList
						   for(BankAccount bankAcc: bankAccountList) {
							   
							   if( bankAcc.getCustomer().getId() == LoginController.currentCustomer.getId()) 
							   {	
								   // Check if the amount to withdraw is within the range of the customer bank account balance 
								   // and if the amount is a correct input (E.g NO NEGATIVE WITHRAWL )
								   if(amount <= bankAcc.getCustomer().getBalance() && amount > 0.0) {
									   
									   System.out.println("The current balance is " + bankAcc.getCustomer().getBalance());
									   bankAcc.getCustomer().setBalance(  String.valueOf(bankAcc.getCustomer().getBalance() - amount ) );
									   getBalanceLabel.setText( String.valueOf( bankAcc.getCustomer().getBalance() ) );
									   System.out.println("The current balance is " + bankAcc.getCustomer().getBalance());
//									   accountLevelText.setText( String.valueOf( bankAcc.getCustomer().getLevel() ) );
									   
								   } else {
							    	   AlertBox.display("Invalid Withdrawl", "Unable to withdraw the specified value. Please ensure you have sufficient funds.");

								   }				   
							   }  
						   }   
					   }   
				   }
				   
			}catch(Exception e) {
				System.out.println("Null has been entered, please try again");
				AlertBox.display("Invalid Withdrawl", "Unable to withdraw the specified value. Please ensure you have sufficient funds.");
			}
			
	   
		}
		
		/**
		 * This method gets the money in the account
		 * 
		 * @param event
		 */
		public void getBalance(ActionEvent event) {
			// Loop through all the customers found within the customerBankAccountList
			   for(Customer customerAcc: BankAccount.customerBankAccountList) {
				   
				   // Get the correct bankaccount of the current customer using the application
				   if(customerAcc.getId() == LoginController.currentCustomer.getId() ) {
					   
					   // Loop through all the bank account of the customers found within the bankAccountList
					   for(BankAccount bankAcc: bankAccountList) {
						   
						   if( bankAcc.getCustomer().getId() == LoginController.currentCustomer.getId() ) {
							   System.out.println("The current balance is " + bankAcc.getCustomer().getBalance());
							   getBalanceLabel.setText( String.valueOf( bankAcc.getCustomer().getBalance() ) );
						   }		   
					   }   
				   }   
		}
	   
		}
		
		
}// End of Class
