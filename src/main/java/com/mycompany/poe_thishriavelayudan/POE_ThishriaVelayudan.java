

package com.mycompany.poe_thishriavelayudan;
import java.util.Scanner;
public class POE_ThishriaVelayudan {

    public static void main(String[] args) {
      Scanner input=new Scanner(System.in);
      
      System.out.print("Enter a username: ");
        String userName = input.nextLine();

        System.out.print("Enter a password: ");
        String password = input.nextLine();
        
          Login login = new Login(userName, password);

        String registrationResult=login.registerUser();
      System.out.println(registrationResult);

      if (registrationResult.equals("User registered successfully!")) {
            System.out.print("Enter username to login: ");
            String loginUserName = input.nextLine();

            System.out.print("Enter password to login: ");
            String loginPassword = input.nextLine();

     boolean loginResult=login.loginUser(loginUserName, loginPassword);
           System.out.println(login.returnLoginStatus());

            if (loginResult)
            {
                System.out.println("Welcome, " + login.getUserName() + "!");
            } else {
                System.out.println("Login failed. Please check your credentials.");
            }
           }

          input.close();
    }
}

    

