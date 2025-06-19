import BUS.BusAccessor.CTHoaDonBUS;
import BUS.BusAccessor.GiamGiaSPBUS;
import BUS.BusAccessor.HoaDonBUS;
import BUS.BusAccessor.KhachHangBUS;
import BUS.BusAccessor.NhanVienBUS;
import BUS.BusAccessor.SanPhamBUS;
import BUS.BusAccessor.VoucherBUS;
import DAL.DataAcessObject.GiamGiaSPDAO;
import DTO.ChiTietHoaDon;
import DTO.ChucVu;
import DTO.GiamGiaSP;
import DTO.HoaDon;
import DTO.KhachHang;
import DTO.NhanVien;
import DTO.SanPham;
import DTO.Voucher;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CodeTaoHoaDonMau {
    public static void main(String[] args){
        HoaDonBUS hdBus = new HoaDonBUS();
        CTHoaDonBUS cthdBus = new CTHoaDonBUS();
        SanPhamBUS spbus = new SanPhamBUS();
        KhachHangBUS khBus = new KhachHangBUS();
        NhanVienBUS nvBus = new NhanVienBUS();
        VoucherBUS voucherBus = new VoucherBUS();
        GiamGiaSPDAO giamGiaSP = new GiamGiaSPDAO();

        List<KhachHang> listKH = khBus.getAll();
        List<NhanVien> listNV = nvBus.getAll();
        List<Voucher> listVoucher = voucherBus.getAll();

        // Kiểm tra dữ liệu đầu vào
        if (listKH.isEmpty()) {
            System.err.println("Danh sách khách hàng rỗng. Vui lòng thêm khách hàng trước!");
            return;
        }
        if (listNV.isEmpty()) {
            System.err.println("Danh sách nhân viên rỗng. Vui lòng thêm nhân viên trước!");
            return;
        }
        if (listVoucher.isEmpty()) {
            System.err.println("Danh sách voucher rỗng. Vui lòng thêm voucher trước!");
            return;
        }

        // Tạo 50 hóa đơn mẫu
        for (int i =0;i<50;i++){
            int soChiTietHoaDon = random(2, 16);
            Long tongTien = 0L;
            List<SanPham> listSP = spbus.getAll();
            if (listSP.size() < soChiTietHoaDon) {
                System.err.println("Số lượng sản phẩm không đủ cho hóa đơn thứ " + (i+1));
                continue;
            }
            List<ChiTietHoaDon> listCTHD = new ArrayList<>();
            for (int j=0;j<soChiTietHoaDon;j++){
                int randomSL =  random(1,10);
                int indexSP = random(0, listSP.size()-1);
                SanPham sp = listSP.get(indexSP);
                listSP.remove(indexSP);
                GiamGiaSP giamGia = giamGiaSP.selectByMaSP(sp.getMaSP());
                Long giaTien = sp.getGiaTien();
                if (giamGia != null){
                    giaTien = giaTien - (giaTien * giamGia.getPtGiam() / 100);
                }
                ChiTietHoaDon cthd = new ChiTietHoaDon(sp.getMaSP(), 0, randomSL, giaTien);
                tongTien += giaTien * randomSL;
                listCTHD.add(cthd);
            }
            boolean isHasVoucher = random(1, 2) == 2;
            Voucher voucher = null;
            Long tienGiam = 0L;
            if (isHasVoucher && !listVoucher.isEmpty()){
                int voucherIndex = random(0, listVoucher.size()-1);
                voucher = listVoucher.get(voucherIndex);
                if (tongTien >= voucher.getGiaTriToiThieu()){
                    tienGiam = voucher.getPtGiam() * tongTien / 100;
                    if (tienGiam > voucher.getKmToiDa())
                        tienGiam = voucher.getKmToiDa();
                }
            }
            // Chọn nhân viên bán hàng hợp lệ
            NhanVien nv = null;
            List<NhanVien> nvBanHang = new ArrayList<>();
            for (NhanVien n : listNV) {
                if (n.getMaChucVu() == ChucVu.NHANVIENBANHANG) {
                    nvBanHang.add(n);
                }
            }
            if (nvBanHang.isEmpty()) {
                System.err.println("Không có nhân viên bán hàng!");
                return;
            }
            nv = nvBanHang.get(random(0, nvBanHang.size()-1));
            int maKH = listKH.get(random(0,listKH.size()-1)).getMaKH();

            // Sinh giá trị timestamp ngẫu nhiên trong khoảng
            long minTimestamp = 1650000000000L;
            long maxTimestamp = 1653708571665L;
            long value = nextLongInRange(minTimestamp, maxTimestamp);

            HoaDon hd = new HoaDon(0, new Timestamp(value), "Tien mat", tongTien, tienGiam, maKH, nv.getMaNV(), voucher == null ? 1 : voucher.getSoVoucher(), false);
            hdBus.add(hd);
            int maHD = hdBus.getNewest().getMaHD();
            thayDoiMaHoaDon(listCTHD, maHD);
            for (ChiTietHoaDon ct : listCTHD){
                cthdBus.add(ct);
            }
        }
    }

    public static void thayDoiMaHoaDon(List<ChiTietHoaDon> list, int maHD){
        for (ChiTietHoaDon i : list){
            i.setMaHD(maHD);
        }
    }

    public static int random(int min, int max){
        return (int) ((Math.random()) * ((max - min) + 1) + min);
    }

    // Hàm sinh số long ngẫu nhiên trong khoảng [min, max], tương thích cả Java 8+
    public static long nextLongInRange(long min, long max) {
        Random rand = new Random();
        long bound = max - min + 1;
        long result = min + (Math.abs(rand.nextLong()) % bound);
        return result;
    }
}