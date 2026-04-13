
package TestClasses;


import com.mycompany.poe_thishriavelayudan.Login;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class Test_Chat_App {
 
@Test
public void testUsernameFormatCorrect()
{  // Created a Login object with a valid username format
    Login user = new Login("kyl_1", "Ch&&sec@ke99!", "", "Kyle", "Moodley");
    
    user.registerUser();

    String actual = user.getStatus();
    
    // Expected welcome message if username is valid
    String expected = "Welcome Kyle,Moodley it is great to see you.";
   // Assert that the actual output matches expected
    assertEquals(expected, actual);
}

@Test
public void testUsernameFormatIncorrect()
{ //Created a Login object with an invalid username format
    Login user = new Login("kyle!!!!!!!", "", "", "Kyle", "Moodley");

    user.registerUser();

    String actual = user.getStatus();
    // Expected error message for invalid username
    String expected = "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.";
     // Assert that the actual output matches expected
    assertEquals(expected, actual, actual);
}

@Test
public void testPasswordComplexityCorrect()
{   // Created a Login object with a correct password
    Login user = new Login("kyl_1", "Ch&&sec@ke99!", "", "Kyle", "Moodley");
    
    user.checkPasswordComplexity();
        
    String actual = user.getStatus();
     // Expected success message
    String expected = "Password successfully captured.";
    
    assertEquals(expected, actual);
}

@Test
public void testPasswordComplexityIncorrect() 
{   // Created a Login object with a incorrect password
    Login user = new Login("kyl_1", "password", "", "Kyle", "Moodley");
    
    user.checkPasswordComplexity();
        
    String actual = user.getStatus();   
     // Expected error message
    String expected = "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";

    assertEquals(expected, actual);
}

@Test
public void testCellNumberCorrect()
{   // Valid South African cellphone number format (+27 and 12 digits)
    Login user = new Login("", "", "+27838968976", "", "");

    user.checkCellPhoneNumber();
    
    String actual = user.getStatus();
    String expected = "Cell number successfully captured.";

    assertEquals(expected, actual);
}

@Test
public void testCellNumberIncorrect()
{   // Invalid cellphone number format
    Login user = new Login("", "", "08966553", "", "");

    user.checkCellPhoneNumber();

    String actual = user.getStatus();
    String expected = "Cell number is incorrectly formatted or does not contain an international code; please correct the number and try again.";

    assertEquals(expected, actual);
}
   
@Test
public void testLoginSuccessful()
{   // Correct username and password
    Login user = new Login("kyl_1", "Ch&&sec@ke99!", "", "Kyle", "Moodley");
    
    user.registerUser();
    // Assert login succeeds
    assertTrue(user.loginUser("kyl_1", "Ch&&sec@ke99!") == true);
}

@Test
public void testLoginFailed()
{   // Wrong password attempt
    Login user = new Login("kyl_1", "Ch&&sec@ke99!", "", "Kyle", "Moodley");
    
    user.registerUser();
    // Assert login fails
    assertTrue(user.loginUser("kyl_1", "password") == false);
}

@Test
public void testUsernameFormatTrue()
{    // Username missing underscore
    Login user = new Login("kyl_1", "", "", "Kyle", "Moodley");
     
    assertTrue(user.CheckUserName() == true);
}

@Test
public void testUsernameFormatFalse()
{     
    Login user = new Login("kyl1", "", "", "Kyle", "Moodley");
    
    assertTrue(user.CheckUserName() == false);
}

@Test
public void testPasswordComplexityTrue()
{     // Strong password passes complexity check
    Login user = new Login("kyl_1", "Ch&&sec@ke99!", "", "Kyle", "Moodley");
    
    assertTrue(user.checkPasswordComplexity() == true);        
}

@Test
public void testPasswordcomplexityFalse()
{   //Weak password does not pass complexity check
    Login user = new Login("kyl_1", "password", "", "Kyle", "Moodley");
    
    assertTrue(user.checkPasswordComplexity() == false);        
}

@Test
public void testCellPhoneNumberFormatTrue()
{   // Valid cell number format
    Login user = new Login("kyl_1", "Ch&&sec@ke99!", "+27838968976", "Kyle", "Moodley");
    
    assertTrue(user.checkCellPhoneNumber() == true);        
}

@Test
public void testCellPhoneNumberFormatFalse()
{    // Invalid cell number format
    Login user = new Login("kyl_1", "Ch&&sec@ke99!", "08966553", "Kyle", "Moodley");
    
    assertTrue(user.checkCellPhoneNumber() == false);        
}


}


