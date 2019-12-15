package application;

public class User {

	/****************************************************************/
	/* 					Instance variables							*/
	/****************************************************************/
	private String username, password, role;
	
	
	/****************************************************************/
	/* 						  Constructor		     				*/
	/****************************************************************/
	
	/**
	 * This constructor sets the user's username, password, and role
	 * 
	 * @param username
	 * @param password
	 * @param role
	 * 
	 * @requires username, password, role are not null
	 */
	public User(String username, String password, String role) {
		this.username = username;
		this.password = password;
		this.role = role;	
	}

	/****************************************************************/
	/* 					    	Methods								*/
	/****************************************************************/
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	

}
