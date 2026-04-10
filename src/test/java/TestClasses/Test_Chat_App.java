
package TestClasses;


import com.mycompany.poe_thishriavelayudan.Login;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class Test_Chat_App {
 
@Test
 public void testUsernameCorrect() {

    Login user = new Login("kyl_1", "", "", "Kyle", "Moodley");

    user.setStoredUsername("kyl_1"); // simulate registered user
  user.setStoredPassword("");
  
    user.loginUser("kyl_1", ""); // empty password

    String actual = user.returnLoginStatus();
    String expected = "Welcome Kyle,Moodley it is great to see you again";

    assertEquals(expected, actual);

    }

    @Test
    public void testUsernameIncorrect() {
        Login user = new Login("kyle!!!!!!!", "", "", "Kyle", "Moodley");

        String actual = user.registerUser(); 
        String expected = "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.";
        assertEquals(expected, actual);
    }

    @Test
    public void testPasswordCorrect() {// this one wrong
        Login user = new Login("kyl_1", "Ch&&sec@ke99!", "", "Kyle", "Moodley");
         user.setStoredUsername("");
         
        String actual = user.registerUser();
        String expected = "Password successfully captured";
        assertEquals(expected, actual);
    }

    @Test
    public void testPasswordIncorrect() {//this one wrong
        Login user = new Login("kyl_1", "password", "", "Kyle", "Moodley");
        user.setStoredUsername("kyl_1");

        String actual = user.registerUser();
        String expected = "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        assertEquals(expected, actual);
    }

  
private String cellPhoneMessage(Login user) {
    if (user.checkCellPhoneNumber()) {
        return "Cell number successfully captured.";
    } else {
        return "Cell number is incorrectly formatted or does not contain an international code; please correct the number and try again.";
    }
}

@Test
public void testCellNumberCorrect() {
    Login user = new Login("", "", "+27838968976", "", "");
    String actual = cellPhoneMessage(user);
    String expected = "Cell number successfully captured.";
    assertEquals(expected, actual);
}

@Test
public void testCellNumberIncorrect() {
    Login user = new Login("", "", "08966553", "", "");
    String actual = cellPhoneMessage(user);
    String expected = "Cell number is incorrectly formatted or does not contain an international code; please correct the number and try again.";
    assertEquals(expected, actual);
}

    
  @Test
public void testLoginSuccessful() {
    Login user = new Login("kyl_1", "Ch&&sec@k1", "", "Kyle", "Moodley");

    user.setStoredUsername("kyl_1");
    user.setStoredPassword("Ch&&sec@k1");

    user.loginUser("kyl_1", "Ch&&sec@k1");

    String actual = user.returnLoginStatus();
    String expected = "Welcome Kyle,Moodley it is great to see you again";

    assertEquals(expected, actual);
}

    @Test
    public void testLoginFailed() {
        Login user = new Login("kyl_1", "Ch&&sec@ke99!", "", "Kyle", "Moodley");
        user.setStoredUsername("kyl_1");
        user.setStoredPassword("Ch&&sec@ke99!");

        user.loginUser("kyl_1", "password");
        String actual = user.returnLoginStatus();
        String expected = "Username or password incorrect , please try again.";
        assertEquals(expected, actual);
    }
    @Test
    public void testPasswordBooleanCorrect() {
        Login user = new Login("kyl_1", "Ch&&sec@ke99!", "", "", "");
        user.setStoredUsername("kyl_1");

        assertTrue(user.checkPasswordComplexity()); // returns True
    }

    @Test
    public void testPasswordBooleanIncorrect() {
        Login user = new Login("kyl_1", "password", "", "", "");
        user.setStoredUsername("kyl_1");

        assertFalse(user.checkPasswordComplexity()); 
    }


    @Test
    public void testUsernameBoolean() {
        Login userCorrect = new Login("kyl_1", "", "", "", "");
        Login userIncorrect = new Login("kyle!!!!!!!", "", "", "", "");

        assertTrue(userCorrect.CheckUserName());  // True for correctly formatted
        assertFalse(userIncorrect.CheckUserName()); // False for incorrectly formatted
    }

}


