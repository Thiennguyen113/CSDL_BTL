
package GUI.SaleGroup.SellerGUI.Component;

import BUS.BusAccessor.LoaiSanPhamBUS;
import DAL.DataAcessObject.LoaiSanPhamDAO;
import DTO.LoaiSanPham;
import GUI.SaleGroup.SellerGUI.BasicHandle.ComboBoxLoaiSPAction;
import GUI.SaleGroup.SellerGUI.BasicHandle.ComboboxLoaiSanPhamRender;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class MyLoaiSPComboBox extends JComboBox<LoaiSanPham>{
    private final LoaiSanPhamBUS loaispBUS = new LoaiSanPhamBUS();

    public MyLoaiSPComboBox() {
        this.setRenderer(new ComboboxLoaiSanPhamRender());
        // getLoaiSPFromDatabase(); // Uncomment if you want to auto load on creation
    }

    @Override
    public LoaiSanPham getSelectedItem(){
        return ((LoaiSanPham) super.getSelectedItem());
    }

    public int getSelectedMaLoai(){
        LoaiSanPham selected = this.getSelectedItem();
        return (selected != null) ? selected.getMaLoai() : -1;
    }

    public void getLoaiSPFromDatabase(){
        List<LoaiSanPham> list = loaispBUS.getAll();
        if(list != null) {
            for (LoaiSanPham loaisp : list){
                this.addItem(loaisp);
            }
        }
    }

    public void getLoaiSPexAll(){
        List<LoaiSanPham> list = loaispBUS.getAll();
        if(list != null) {
            for (LoaiSanPham loai : list){
                if(!"Tất cả".equals(loai.getTenLoai()))
                    this.addItem(loai);
            }
        }
    }

    public void setSelectedLoai(int maLoai){
        for (int i = 0; i < this.getItemCount(); i++){
            LoaiSanPham loai = this.getItemAt(i);
            if (loai != null && loai.getMaLoai() == maLoai){
                this.setSelectedIndex(i);
                break;
            }
        }
    }
}