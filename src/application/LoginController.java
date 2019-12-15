package application;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


import application.Manager;

public class LoginController implements Initializable{
	
	/****************************************************************/
	/* 					Instance variables							*/
	/****************************************************************/
		Boolean managerCheck = false;	
		Boolean customerCheck = false;	
		Boolean userCheck = false;
		Boolean passCheck = false;
		Boolean roleCheck = false;
		static Customer currentCustomer;
		
		@FXML private Button loginButton;
		@FXML private TextField usernameTextField;
		@FXML private TextField passwordTextField;
		@FXML private TextField roleTextField;
	   
	   
	   @Override
	   public void initialize(URL location, ResourceBundle resources) {
	 
	       // TODO (don't really need to do anything here).
	      
	   }
	 
	   /**
	    * When user click on loginButton this method will be called.
	    * 
	    * @param event				
	    * @throws IOException
	    */
	   public void login(ActionEvent event) throws IOException {
		   
	       System.out.println("Button Clicked!");
	       
	       
	       // If user is a manager
	       if( testIfManager() ) 
	       {
	    	   // Read file fxml and draw interface for Manager Scene.
	            Parent root2 = FXMLLoader.load(getClass()
	                    .getResource("/application/ManagerScene.fxml"));
	            
	            Scene managerScene1 = new Scene(root2);
	            
	            // Retrieve Stage information 
	            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
	            
	            window.setScene(managerScene1);
	            window.show();
	    	   
	    	   
	       }// If user is a customer
	       else if( testIfCustomer() )
	       {
	    	   // Read file fxml and draw interface for Manager Scene.
	            Parent root3 = FXMLLoader.load(getClass()
	                    .getResource("/application/CustomerScene.fxml"));
	            
	            Scene customerScene1 = new Scene(root3);
	            
	            // Retrieve Stage information 
	            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
	            
	            window.setScene(customerScene1);
	            window.show();
	         
	       }// If user entered the wrong information for a account
	       else {
	    	   AlertBox.display("Invalid Account", "You have entered invalid information for a account. Please try again.");
	       }
	      
	       
	   }// End of login() method
	  
	   /**
	    * This methods checks if a user entered the information for a manager account 
	    * 
	    * @return a boolean whether or not the user using the bank application is manager
	    */
	   public boolean testIfManager() 
	   {
	       if( usernameTextField.getText().equals( Manager.getManager().getUsername() ) && 
	    		   passwordTextField.getText().equals(Manager.getManager().getPassword() ) && 
	    		   roleTextField.getText().equals(Manager.getManager().getRole() ) ) 
	       {
		    managerCheck = true;
	       }
		   return managerCheck;  
	   }
	   
	   /**
	    * This methods checks if a user entered the information for a manager account 
	    * 
	    * @return a boolean whether or not the user using the bank application is manager
	    */
	   public boolean testIfCustomer() 
	   { 
		   
		   for(Customer acc: BankAccount.customerBankAccountList)
		   {
			   if( usernameTextField.getText().equals( acc.getUsername() ) && 
		    		   passwordTextField.getText().equals( acc.getPassword() ) && 
		    		   roleTextField.getText().equals( acc.getRole() ) )
		       {		
				currentCustomer = acc;
			    customerCheck = true;	
			    System.out.println(currentCustomer.toString());
		       }
		   }	      
		   return customerCheck;		            	
	   }
	   
	}// End of Class

