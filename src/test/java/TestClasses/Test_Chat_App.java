
package TestClasses;


import com.mycompany.poe_thishriavelayudan.Login;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class Test_Chat_App {
 
@Test
public void testUsernameFormatCorrect()
{
    Login user = new Login("kyl_1", "", "", "Kyle", "Moodley");
    
    user.registerUser();

    String actual = user.getStatus();
    String expected = "Welcome Kyle,Moodley it is great to see you.";

    assertEquals(expected, actual);
}

@Test
public void testUsernameFormatIncorrect()
{
    Login user = new Login("kyle!!!!!!!", "", "", "Kyle", "Moodley");

    user.registerUser();

    String actual = user.getStatus();
    String expected = "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.";

    assertEquals(expected, actual, actual);
}

@Test
public void testPasswordComplexityCorrect()
{ // this one correct
    Login user = new Login("kyl_1", "Ch&&sec@ke99!", "", "Kyle", "Moodley");
    
    user.checkPasswordComplexity();
        
    String actual = user.getStatus();
    String expected = "Password successfully captured.";
    
    assertEquals(expected, actual);
}

@Test
public void testPasswordComplexityIncorrect() 
{//this one wrong
    Login user = new Login("kyl_1", "password", "", "Kyle", "Moodley");
    
    user.checkPasswordComplexity();
        
    String actual = user.getStatus();    
    String expected = "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";

    assertEquals(expected, actual);
}

@Test
public void testCellNumberCorrect()
{
    Login user = new Login("", "", "+27838968976", "", "");

    user.checkCellPhoneNumber();
    
    String actual = user.getStatus();
    String expected = "Cell number successfully captured.";

    assertEquals(expected, actual);
}

@Test
public void testCellNumberIncorrect()
{
    Login user = new Login("", "", "08966553", "", "");

    user.checkCellPhoneNumber();

    String actual = user.getStatus();
    String expected = "Cell number is incorrectly formatted or does not contain an international code; please correct the number and try again.";

    assertEquals(expected, actual);
}
   
@Test
public void testLoginSuccessful()
{
    Login user = new Login("kyl_1", "Ch&&sec@k1", "", "Kyle", "Moodley");
    
    user.registerUser();

    assertTrue(user.loginUser("kyl_1", "Ch&&sec@k1") == true);
}

@Test
public void testLoginFailed()
{
    Login user = new Login("kyl_1", "Ch&&sec@ke99!", "", "Kyle", "Moodley");
    
    user.registerUser();

    assertTrue(user.loginUser("kyl_1", "password") == false);
}

@Test
public void testUsernameFormatTrue()
{
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
{
    Login user = new Login("kyl_1", "Ch&&sec@ke99!", "", "Kyle", "Moodley");
    
    assertTrue(user.checkPasswordComplexity() == true);        
}

@Test
public void testPasswordcomplexityFalse()
{
    Login user = new Login("kyl_1", "password", "", "Kyle", "Moodley");
    
    assertTrue(user.checkPasswordComplexity() == false);        
}

@Test
public void testCellPhoneNumberFormatTrue()
{
    Login user = new Login("kyl_1", "Ch&&sec@ke99!", "+27838968976", "Kyle", "Moodley");
    
    assertTrue(user.checkCellPhoneNumber() == true);        
}

@Test
public void testCellPhoneNumberFormatFalse()
{
    Login user = new Login("kyl_1", "Ch&&sec@ke99!", "08966553", "Kyle", "Moodley");
    
    assertTrue(user.checkCellPhoneNumber() == false);        
}


}


