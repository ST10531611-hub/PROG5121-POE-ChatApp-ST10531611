package com.mycompany.poe_thishriavelayudan;

public class Login {

    private String userName;
    private String password;
    private String cellPhoneNumber;
    private String storedUsername;
    private String storedPassword;
    private String loginstatus;

    //Constructor
    public Login(String userName, String password) {
        this.userName = userName;
        this.password = password;
        
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

    public void setStoredUsername(String storedUsername) {
        this.storedUsername = storedUsername;
    }

    public String getStoredPassword() {
        return storedPassword;
    }

    public void setStoredPassword(String storedPassword) {
        this.storedPassword = storedPassword;
    }

    public void setCellPhoneNumber(String cellPhoneNumber) {
        this.cellPhoneNumber = cellPhoneNumber;
    }

    //Behavioral Methods
    public Boolean CheckUserName() {
        return userName.contains("_") && userName.length() <= 5;
    }

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
    

    public Boolean checkCellPhoneNumber()
    {
        return cellPhoneNumber.startsWith("+")&& cellPhoneNumber.length()!=12;
    }
    
    public String registerUser() {
        if (!CheckUserName()) {
            return "Username is not formatted properly";
        }
        if (!checkPasswordComplexity()){
            return "Password does not meet complexity requirements";
        }
        if (cellPhoneNumber==null || !cellPhoneNumber.matches("\\+27\\d{9}"))
            return "Cellphone Number not formatted properly !";
        
        storedPassword=password;
        storedUsername=userName;
        return "User registered successfully!";
    }

    public Boolean loginUser(String userName, String password) {
                
     if (userName.equals(storedUsername) && password.equals(storedPassword)) {
                     System.out.println("=========================================");
                     loginstatus="Successfully logged in !!! \n WELCOME " + userName;
                     return true;
    }else{
         System.out.println("=========================================");
      loginstatus="Failed to login !!, Try again";
                  
        return false;
         }
    }

    public String returnLoginStatus() {
     return loginstatus;
    }
}
