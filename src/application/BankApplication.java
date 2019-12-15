package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
 
public class BankApplication  extends Application {
    static int numOfAccountsMadeHere = 2;
  
    @Override
    public void start(Stage primaryStage) {
        try {
        	
        	//Stage window;
        	Scene loginScene;
        	
        	// Create a customer bank account
        	BankAccount acc1 = new BankAccount( new Customer("gioldfish", "Smash", "customer", "9800", "silver", "1381") );
        	BankAccount acc2 = new BankAccount( new Customer("gemmbear", "rawr", "customer", "80000", "platnium", "1816") );
        	
        	for(Customer acc: BankAccount.customerBankAccountList) {
        		System.out.println(acc.toString() );
        	}
        	
            // Read file fxml and draw interface for Login Scene.
            Parent root1 = FXMLLoader.load(getClass()
                    .getResource("LoginScene.fxml"));
            
            loginScene = new Scene(root1);
            primaryStage.setTitle("Bank Application");
            primaryStage.setScene(loginScene);         
            
            primaryStage.show();
         
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}