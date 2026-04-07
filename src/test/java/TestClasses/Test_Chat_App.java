
package TestClasses;


import com.mycompany.poe_thishriavelayudan.Login;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class Test_Chat_App {
   
  @Test
public void Username()
{
    Login CLogin = new Login("","");
    String expected = "successful login";
    CLogin.loginUser("","");
    String Actual = CLogin.returnLoginStatus();
    assertEquals(expected,Actual);

}  
   
 @Test
public void Loginame()
{
    Login CLogin = new Login("","");
    String expected = "Successful login";
    CLogin.loginUser("","");
    String Actual = CLogin.returnLoginStatus();
    assertEquals(expected,Actual);

}  
    
}
