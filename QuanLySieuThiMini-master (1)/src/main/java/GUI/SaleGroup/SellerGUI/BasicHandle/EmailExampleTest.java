
package GUI.SaleGroup.SellerGUI.BasicHandle;

import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class EmailExampleTest {
    
    private static EmailExample emailExample;

    public boolean checkEmail(String email) {
        emailExample = new EmailExample();
        return emailExample.validate(email);
    }
    
}
