# bank-account-application-
This Bank Account Application utilizes JavaFX to create a simple, yet elegant user interface (UI). This application followed specific 
requirements from a final project rubric. 

The requirements were:

    - There is a variety of 2 users who utilize this application; Customer and Manager. 
      There can be 0 or more customers who use the application, and there is only one manager.
    - A customer has a username, password, and role = customer, bank account and level. 
      The information about the customers is stored in separate files (one file per customer). 
    - The manager has username: admin, password:admin, and role = manager
    - There are 3 levels for a customer's bank account (Silver, Gold, & Platnium ), which is 
      determined through the amount of money in a particular bank account. 
      E.g       
           Silver   Ɛ [0, 10 000)
           Gold     Ɛ [10 000, 20 000)
           Platinum Ɛ [20 000, +inf) 
  
    - To purchase an online item, the price of the item must be greater than or equal to $50.00 dollars. 
      Additionally, there is a particular online purchase fee, which is determined through the level 
      of a customer's account. 
      E.g       
           __________|____Online Purchase Fee_____
           Silver    |     $20.00
           Gold      |     $10.00
           Platinum  |     $00.00    
           
      - Only the manager has the authority to to add or delete a customer's back account. When the 
        manager adds a customer, they must create the account of the customer along with a intitial 
        balance of $100.00 dollars in the account. 
      
