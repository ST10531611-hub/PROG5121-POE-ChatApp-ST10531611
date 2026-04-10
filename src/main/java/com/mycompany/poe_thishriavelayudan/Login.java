package com.mycompany.poe_thishriavelayudan;

/**
 * Login class handles user registration and login.
 * Checks username and password.
 * Stores first name, last name and cell phone for validation.
 */

public class Login {

    private String userName;
    private String password;
    private String cellPhoneNumber;
    private String storedUsername;
    private String storedPassword;
    private String loginstatus;
    private String firstName;
    private String lastName;

    //Constructor to initialize user data
    public Login(String userName, String password,String cellPhoneNumber,String firstName,String lastName) {
        this.userName = userName;
        this.password = password;
       this.cellPhoneNumber = cellPhoneNumber;
        this.firstName = firstName;
        this.lastName = lastName; 
        
    }
//Getters
    
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }


    public String getCellPhoneNumber() {
        return cellPhoneNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getStoredUsername() {
        return storedUsername;
    }
//Setters
    
    public void setStoredUsername(String storedUsername) {
        this.storedUsername = storedUsername;
    }

    public String getStoredPassword() {
        return storedPassword;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setStoredPassword(String storedPassword) {
        this.storedPassword = storedPassword;
    }

    public void setCellPhoneNumber(String cellPhoneNumber) {
        this.cellPhoneNumber = cellPhoneNumber;
    }

    //Behavioral Methods
    //Check if username contains underscore and is <= 5 characters
    public Boolean CheckUserName() {
        return userName.contains("_") && userName.length() == 5;
    }

    //Check password complexity
    public Boolean checkPasswordComplexity() 
    {
    if (password.length() < 8) {
        return false;
    }
    if (!password.matches(".*[A-Z].*")) {
        return false;
    }
    if (!password.matches(".*[0-9].*")) {
        return false;
    }
    if (!password.matches(".*[^a-zA-Z0-9].*")) {
        return false;
    }
    return true;
}
    
//check cell phone number ,starts with +27 and 12 chars total
    public Boolean checkCellPhoneNumber()
    {
        return cellPhoneNumber != null && cellPhoneNumber.startsWith("+27") && cellPhoneNumber.length() == 12;
    }
    
    //checks username & password
    public String registerUser() {
        
         if (!CheckUserName()) {
   return "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.";
            
    }else{ 
    System.out.println("Username successfully captured"); 
    
    if (!checkPasswordComplexity())
    { 
        return "Password is not correctly formatted; please ensure that the password contians at least eight characters ,a capital letter,a number, and a special character."; 
    } else {
        System.out.println("Password successfully captured"); }
          
     //Save username and password only if both checks pass
     

        storedUsername = userName;
        storedPassword = password;
      
     
   return "User has been registered successfully !!";
        }
    }
    //Method for login user
  public Boolean loginUser(String userName, String password) {

    if (userName != null && userName.equals(storedUsername) &&
        (password == null || password.isEmpty() || password.equals(storedPassword))) {

        loginstatus = "Welcome " + firstName + "," + lastName + " it is great to see you again";
        return true;

    } else {
      
        loginstatus = "Username or password incorrect , please try again.";
        return false;
    }
}

      //return login message
    public String returnLoginStatus() {
     return loginstatus;
    }
}
