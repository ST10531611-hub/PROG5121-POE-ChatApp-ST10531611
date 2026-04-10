

package com.mycompany.poe_thishriavelayudan;
import java.util.Scanner;
public class POE_ThishriaVelayudan {

    public static void main(String[] args) {
      Scanner input=new Scanner(System.in);
      
      System.out.println("==================================================");
      System.out.println("=============== Welcome to Chat App ===============");
      System.out.println("==================================================");
        
       //Enter username
      System.out.print("Enter a username: ");
        String userName = input.nextLine();
       
        //Enter password
        System.out.print("Enter a password: ");
        String password = input.nextLine();
        
        //Enter cellphone Number        
          System.out.print("Enter your cellphone number (e.g. +27635189485): ");
          String cellPhoneNumber = input.nextLine();
         
         //Enter first name
        System.out.print("Enter your first name: ");
        String firstName = input.nextLine();
         
        //Enter last name
        System.out.print("Enter your last name: ");
        String lastName = input.nextLine();

        //Created a login object
         Login login = new Login(userName, password,cellPhoneNumber,firstName,lastName);
         
           login.setCellPhoneNumber(cellPhoneNumber);
        
       // Registration 
           
      String registrationResult;

        do {
            registrationResult = login.registerUser();
            System.out.println(registrationResult);

            if (!registrationResult.equals("User has been registered successfully !!")) {

                System.out.println("\nTry again:\n");

                System.out.print("Enter a username: ");
                login.setUserName(input.nextLine());

                System.out.print("Enter a password: ");
                login.setPassword(input.nextLine());
            }

        } while (!registrationResult.equals("User has been registered successfully !!"));
      
      //Checks cellphone number
      if (!login.checkCellPhoneNumber()) {
            System.out.println("Cell phone number incorrectly formatted or does not contain international code.");
       }else{
           System.out.println("Cell phone number successfully added");
       }
      
      System.out.println(registrationResult);

       
    // Only allow login if registration was successful
      if (registrationResult.equals("User has been registered successfully !!")) {
          //login process
           boolean loginResult = false;
   
           while (!loginResult) {

          System.out.println("==============================================================");
            System.out.print("Enter username to login: ");
            String loginUserName = input.nextLine();

            System.out.print("Enter password to login: ");
            String loginPassword = input.nextLine();

            //Show if login is successful or failed
     loginResult=login.loginUser(loginUserName, loginPassword);
     
          System.out.println("\n=============================================================");    
           System.out.println(login.returnLoginStatus());
           
           System.out.println("===============================================================");
           }
      }
          input.close();
    }
}

    

