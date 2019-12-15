package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.FileChooser.ExtensionFilter;

public class ManagerController {
	
	/****************************************************************/
	/* 					Instance variables							*/
	/****************************************************************/
	   Boolean userCheck = false;
	   Boolean passCheck = false;
	   Boolean roleCheck = false;
	   
	 // ArrayList which will contain all the customer account files 
	   ArrayList<String> containedFiles = new ArrayList<String>();
	   
	   @FXML private Button addCustomerButton;
	   @FXML private Button deleteCustomerButton;	    
	   @FXML private Button openAccountButton;	 
	   @FXML private Button logoutButton;	 
	   @FXML private ListView listview;
	   
	   
	/****************************************************************/
	/* 					    	Methods								*/
	/****************************************************************/
		  
	   
	   /**
	    * When user clicks on openAccountButton, this method will be called.
	    * This method will open up notepad.
	    * 
	    * @param event
	    */
	   public void openAccount(ActionEvent event) {
		   
		   Runtime rs = Runtime.getRuntime();

		    try {
		      rs.exec("notepad");
		    }
		    catch (IOException e) {
		      System.out.println(e);
		    }
	   }// End of openAccount
	   
	   
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
	    * When user clicks on addCustomerButton, this method will be called.
	    * This method will add a customer to the arraylist and listview
	    * 
	    * @param event
	    */
	   public void addCustomer(ActionEvent event) {
		  
			   // These fields will store the username's, password, and balance
			   String username = null, password = null, role = null, balance = null, level = null, id = null;
			   
			   // This will reference one line at a time
		       String line = null;
			   
			   Boolean usernameCheck = false;
			   Boolean passwordCheck = false;
			   Boolean roleCheck = false;
			   Boolean balanceCheck = false;
			   Boolean levelCheck = false;
			   Boolean idCheck = false;
			   
			  
			   // Create a initial directory and add filter for the listview to only accept *.txt files
			   FileChooser fc = new FileChooser();
			   fc.setInitialDirectory(new File ("C:\\Users\\Giord\\eclipse-workspace\\Java\\coe528\\finalProject\\Customers") );
			   fc.getExtensionFilters().addAll( 
					   new ExtensionFilter("Text Document", "*.txt") );
			   List<File> selectedFiles = fc.showOpenMultipleDialog(null);
			   
			   
			   // Adding the file names to the listview
			   if( selectedFiles != null) 
			   {
				   for(int i = 0; i  < selectedFiles.size(); i++) 
				   {		
					   
			        try {
			            // FileReader reads text files in the default encoding.
			            FileReader fileReader = 
			                new FileReader(selectedFiles.get(i));
	
			            // Always wrap FileReader in BufferedReader.
			            BufferedReader bufferedReader = 
			                new BufferedReader(fileReader);
	
				            while( (line = bufferedReader.readLine() ) != null) 
				            {
				            		// Get the username
					            	if( line.equals("username:") ) 
					            	{
					            		username = ( line = bufferedReader.readLine() );   		
				            			usernameCheck = true;		            			
					            	}
					            	
					            	// Get the password
					            	if( line.equals("password:") ) 
					            	{
					            		password = ( line = bufferedReader.readLine() );   		
				            			passwordCheck = true;
					            	}
					            	
					            	// Get the role
					            	if( line.equals("role:") ) 
					            	{
					            		role = ( line = bufferedReader.readLine() );   		
				            			roleCheck = true;
					            	}
					            	
					            	// Get the balance
					            	if( line.equals("balance:") ) 
					            	{
					            		balance = ( line = bufferedReader.readLine() );   		
				            			balanceCheck = true;
					            	}
					            	
					            	// Get the level
					            	if( line.equals("level:") ) 
					            	{
					            		level = ( line = bufferedReader.readLine() );   		
				            			levelCheck = true;
					            	}
					            	
					            	// Get the id
					            	if( line.equals("id:") ) 
					            	{
					            		id = ( line = bufferedReader.readLine() );   		
				            			idCheck = true;
					            	}
					            	
					            	// If all information for a customer account is given, create the account
					            	if(usernameCheck && passwordCheck && roleCheck && balanceCheck && levelCheck && idCheck && Double.parseDouble(balance) >= 100.00) 
					            	{
					            		BankAccount acc1 = new BankAccount( new Customer(username, password, role, balance, level, id) );
					            		listview.getItems().add(selectedFiles.get(i).getName());
					            		System.out.println("Customer account added!");
					            		System.out.println("Username: " + username);
					            		System.out.println("Password: " + password);
					            		System.out.println("Role: " + role);
					            		System.out.println("Balance: " + balance);
					            		System.out.println("Level: " + level);
					            		
					            		for(Customer test: BankAccount.customerBankAccountList) {
					            			System.out.println(test.getUsername() + " is in the customer bank account list.");
					            		}
					            	}
					            	
					            	// If balance is < 100, don't create the account
					            	if (usernameCheck && passwordCheck && roleCheck && balanceCheck && levelCheck && idCheck && Double.parseDouble(balance) < 100.00){
					            		AlertBox.display("Invalid Account", "Unable to create an account as a minimum balance of $100 is required.");
					            	}
					            	
				            }//End of while
			            
			            }catch(Exception e) {
							   System.out.println("Exception occured");
						}// End of catch  
			
				   }// End of For loop
				   
				}else
				{
					System.out.println("Selected file not valid");   
				}
				   
	   }// End of addCustomer
	   
	   
	   /**
	    * When user clicks on deleteCustomerButton, this method will be called.
	    * This method will delete a customer from the arraylist and listview
	    * 
	    * @param event
	    */
	   public void deleteCustomer(ActionEvent event) {
		   
		
			 final int selectedIdx = listview.getSelectionModel().getSelectedIndex();
			 
	            if (selectedIdx != -1) {
	                String itemToRemove = (String) listview.getSelectionModel().getSelectedItem();

	                final int newSelectedIdx =
	                        (selectedIdx == listview.getItems().size() - 1)
	                                ? selectedIdx - 1
	                                : selectedIdx;

	                listview.getItems().remove(selectedIdx);
	                listview.getSelectionModel().select(newSelectedIdx);
	                BankAccount.customerBankAccountList.remove(selectedIdx + BankApplication.numOfAccountsMadeHere);
	                
	                for(Customer c: BankAccount.customerBankAccountList) {
	                	System.out.println("After deleting, " + c.getUsername() + " is still in the list");
	                }
	                //removes the customer account for the listview
	                System.out.println("selectIdx: " + selectedIdx);
	                System.out.println("item: " + itemToRemove);
	                
	            }// End of if statement
	   }// End of deleteCustomer()
	   
	  

}// End of Class
