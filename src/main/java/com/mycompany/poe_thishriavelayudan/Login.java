package com.mycompany.poe_thishriavelayudan;

/**
 * Login class handles user registration and login.
 * Checks username and password.
 * Stores first name, last name and cell phone for validation.
 */

public class Login
{

    private String userName;
    private String password;
    private String cellPhoneNumber;
    private String Status;
    private String LoginStatus;
    private String firstName;
    private String lastName;

    //Constructor to initialize user data
    public Login(String userName, String password, String cellPhoneNumber, String firstName, String lastName)
    {
        this.userName = userName;
        this.password = password;
        this.cellPhoneNumber = cellPhoneNumber;
        this.firstName = firstName;
        this.lastName = lastName; 
  
    }
    
//Getters
    
    public String getFirstName()
    {
        return firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public String getCellPhoneNumber()
    {
        return cellPhoneNumber;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getPassword()
    {
        return password;
    }

    public String getStatus()
    {
        return Status;
    }
    
//Setters
    
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public void setCellPhoneNumber(String cellPhoneNumber)
    {
        this.cellPhoneNumber = cellPhoneNumber;
    }

    //Behavioral Methods
    //Check if username contains underscore and is <= 5 characters
    public Boolean CheckUserName()
    {
        if (userName.contains("_") && userName.length() <= 5)
        {
            Status = "Username successfully captured.";
            return true;
        }
        else
        {
            Status = "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.";
            return false;
        }
    }

    //Check password complexity
    public Boolean checkPasswordComplexity() 
    {
        if ((password.length() < 8) || (!password.matches(".*[A-Z].*"))||(!password.matches(".*[0-9].*"))||(!password.matches(".*[^a-zA-Z0-9].*"))) 
        {
            Status="Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
            return false;
        }
        else 
        {
            Status="Password successfully captured.";
            return true;
        }
    }
    
    
// Regex used to validate South African number format (+27 followed by 9 digits)
    public Boolean checkCellPhoneNumber()
    {
        if (cellPhoneNumber != null && cellPhoneNumber.matches("^\\+27\\d{9}"))
        {
            Status="Cell number successfully captured.";
            return true;
        }
        else
        {
            Status="Cell number is incorrectly formatted or does not contain an international code; please correct the number and try again."; 
            return false;
        }
    }
    
    //checks username & password
    public String registerUser() 
    {
        if (CheckUserName() && (checkPasswordComplexity()))
        { 
            Status = "Welcome "+ firstName+ ","+ lastName+" it is great to see you.";
        }
    
        return Status;
     }
    
    //Method for login user
    public Boolean loginUser(String lUserName, String lPassword) 
    {
        if (lUserName != null && lUserName.equals(userName) &&
            (lPassword == null ||lPassword.isEmpty()|| lPassword.equals(password)))
        {
            LoginStatus = "Welcome " + firstName + "," + lastName + " it is great to see you again";
            return true;
        } 
        else
        {
            LoginStatus = "Username or password incorrect , please try again.";
            return false;
        }
    }

      //return login message
    public String LoginStatus() 
    {
        return LoginStatus;
    }
}
