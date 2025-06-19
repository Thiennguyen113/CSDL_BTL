/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS.Excel;
import DAL.DataAcessObject.ChiTietHoaDonDAO;
import  DAL.DataAcessObject.HoaDonDAO;
import DAL.DataAcessObject.NhanVienDAO;
import DAL.DataAcessObject.SanPhamDAO;
import com.itextpdf.text.Font;

import DTO.ChiTietHoaDon;
import DTO.HoaDon;
import DTO.NhanVien;
import DTO.SanPham;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author tiend
 */

public class PdfTest {
    private static ChiTietHoaDonDAO cthoaDonDAO = new ChiTietHoaDonDAO();
    private static HoaDonDAO hoaDonDAO = new HoaDonDAO();
    private static NhanVienDAO nhanVienDAO = new NhanVienDAO();
    private static SanPhamDAO sanPhamDAO = new SanPhamDAO();

    public static void convertToPDF(int maHoaDon) throws DocumentException{

        File f= new File("src\\main\\java\\DAL\\Exel\\hoadon-pdf");
        String path="";
        path= f.getAbsoluteFile().getPath();

        HoaDon hoadon = hoaDonDAO.select(maHoaDon);
        if (hoadon == null){
            return;
        }
        NhanVien nv = nhanVienDAO.select(hoadon.getMaNV());
        if (nv == null){
            return;
        }
        List<ChiTietHoaDon> listChiTiet = cthoaDonDAO.selectAllById1(maHoaDon);
        
        //Khoi tao ghi file
        Document doc = new Document();
        try {
            PdfWriter.getInstance(doc, new FileOutputStream(path + "\\hoadon" + maHoaDon + ".pdf"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PdfTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        doc.open();
        String para = String.format("%-100s%-12s\n\n%-85s%-12s\n\n\n", "MÃ HÓA DON:" + String.valueOf(hoadon.getMaHD()), "MA NHAN VIEN:" + String.valueOf(nv.getMaNV()), "NGAY HOA DON:" + String.valueOf(hoadon.getNgayHD()), "TENNV:" + nv.getTenNV());
        PdfPTable tb1 = new PdfPTable(4);
        Paragraph paragraph1 = new Paragraph(para);
        tb1.addCell("STT");
        tb1.addCell("TENSP");
        tb1.addCell("SOLUONG");
        tb1.addCell("GIATIEN");
        int intstt = 0;// so thu tu trong 
        for (ChiTietHoaDon cthd : listChiTiet) {
            String stt = String.valueOf(++intstt);
            SanPham sp = sanPhamDAO.select(cthd.getMaSP());
            String tensp = String.valueOf(cthd.getMaSP()) + "." + sp.getTenSP();
            String soluong = String.valueOf(cthd.getSoLuong());
            String giatien = String.valueOf(cthd.getGiaTien());
            tb1.addCell(stt);
            tb1.addCell(tensp);
            tb1.addCell(soluong);
            tb1.addCell(giatien);
        }
        String para2 = String.format("\n\n%-100s%-12s", "Xin cam on quy khach", "Tong tien:" + hoadon.getTongTien());
        Paragraph paragraph2 = new Paragraph(para2);
        doc.add(paragraph1);
        doc.add(tb1);
        doc.add(paragraph2);
        doc.close();
//        }
        
    }
    
    public static void main(String[] args) throws FileNotFoundException, DocumentException, IOException {
        convertToPDF(1);

    }
}
