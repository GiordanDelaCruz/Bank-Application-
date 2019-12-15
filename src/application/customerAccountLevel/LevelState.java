package application.customerAccountLevel;

import application.BankAccount;

public interface LevelState {

	// Method for concrete classes to implement
	public double onlinePurchase(double priceOfItem);
	
	
}
