
package GUI.SaleGroup.SellerGUI.BasicHandle;

import BUS.BusAccessor.SanPhamBUS;
import DTO.LoaiSanPham;
import DTO.SanPham;
import GUI.SaleGroup.SellerGUI.Component.MenuPanel;
import GUI.SaleGroup.SellerGUI.Component.MyLoaiSPComboBox;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class ComboBoxLoaiSPAction implements ActionListener{
    private MenuPanel menu;
    private JTextField searchField;
    private MyLoaiSPComboBox bx;
    private final SanPhamBUS spBus = new SanPhamBUS();

    public ComboBoxLoaiSPAction(MyLoaiSPComboBox bx, MenuPanel menu, JTextField searchField) {
        this.menu = menu;
        this.bx = bx;
        this.searchField = searchField;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
//        System.out.println("Click value: "+ bx.getSelectedMaLoai());
        int maLoaiHienTai = bx.getSelectedMaLoai();
        List<SanPham> list = spBus.getProductByTypeAndName(maLoaiHienTai, searchField.getText());
        menu.addToPanel(list);
    }
    
}
