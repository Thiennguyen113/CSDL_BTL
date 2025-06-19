package GUI.ManageGroup.Handle.NhanVienHandle;

import GUI.SaleGroup.SellerGUI.BasicHandle.EmailExampleTest;
import DTO.NhanVien;

public class NhanVienValidate {
    private final NhanVien nhanvienValidate;
    private final EmailExampleTest emailExampleTest;

    public NhanVienValidate(){
        nhanvienValidate = new NhanVien();
        emailExampleTest = new EmailExampleTest();
    }

    public boolean validateAll(String tenNhanVien,String soDienThoai, String cmnd, String diachi, String email){
        return checkTenNhanVien(tenNhanVien)
                && checkSoDienThoai(soDienThoai)
                && checkCmnd(cmnd)
                && checkDiaChi(diachi)
                && checkEmail(email);
    }

    private boolean checkTenNhanVien(String tenNhanVien){
        if(tenNhanVien.trim().length() < 2) return false;
        this.nhanvienValidate.setTenNV(tenNhanVien);
        return true;
    }

    private boolean checkSoDienThoai(String soDienThoai){
        // 10 số, bắt đầu bằng 0, chỉ số
        if(soDienThoai.length() != 10) return false;
        if(!soDienThoai.matches("0\\d{9}")) return false;
        this.nhanvienValidate.setSoDienThoai(soDienThoai);
        return true;
    }

    private boolean checkCmnd(String cmnd){
        // 9 hoặc 12 số, chỉ số
        if(cmnd.length() != 9 && cmnd.length() != 12) return false;
        if(!cmnd.matches("\\d+")) return false;
        this.nhanvienValidate.setCmnd(cmnd);
        return true;
    }

    private boolean checkEmail(String email){
        return emailExampleTest.checkEmail(email);
    }

    private boolean checkDiaChi(String diachi){
        if(diachi.trim().length() < 2) return false;
        this.nhanvienValidate.setDiaChi(diachi);
        return true;
    }
}