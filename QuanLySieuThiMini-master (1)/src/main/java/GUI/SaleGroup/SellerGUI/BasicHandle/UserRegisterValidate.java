
package GUI.SaleGroup.SellerGUI.BasicHandle;

import DAL.DataAcessObject.KhachHangDAO;

public class UserRegisterValidate {
    private final KhachHangDAO khachHangDao;
    private EmailExampleTest emailExampleTest;

    public UserRegisterValidate() {
        this.khachHangDao = new KhachHangDAO();
        emailExampleTest = new EmailExampleTest();
    }
    
    public boolean checkEmail( String email ){
      return emailExampleTest.checkEmail(email);
    }
    
    public boolean checkSex(String sex){
      return "Nam".equals(sex);
    }
    
    public boolean checkName(String name){
        return name.length() < 3;
    }
    
    public boolean checkNumber(String number){
        return number.length() <= 9 || number.length()>10;
    }
    

}

