package application;

public class Manager extends User{
	
	/****************************************************************/
	/* 					Instance variables							*/
	/****************************************************************/
	private static Manager theOnlyManager = new Manager("admin", "admin", "manager");
	
	
	/****************************************************************/
	/* 						  Constructor		     				*/
	/****************************************************************/
	
	/**
	 * This constructor sets the managers's username, password, & role
	 * 
	 * @param username
	 * @param password
	 * @param role
	 */
	private Manager(String username, String password, String role) {
		super(username, password, role);
	}
	
	/****************************************************************/
	/* 					    	Methods								*/
	/****************************************************************/
	
	/**
	 * This method returns the only Manager object
	 * 
	 * @return theOnlyManager
	 */
	public static Manager getManager(){
		return theOnlyManager;
	}
	
}
