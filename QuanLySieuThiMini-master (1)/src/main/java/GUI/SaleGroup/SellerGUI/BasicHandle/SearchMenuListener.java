
package GUI.SaleGroup.SellerGUI.BasicHandle;

import BUS.BusAccessor.SanPhamBUS;
import DTO.SanPham;
import GUI.SaleGroup.SellerGUI.Component.MenuPanel;
import GUI.SaleGroup.SellerGUI.Component.MyLoaiSPComboBox;
import java.util.List;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class SearchMenuListener implements DocumentListener{
    private MenuPanel menu;
    private MyLoaiSPComboBox bx;
    private JTextField searchField;
    private final SanPhamBUS spBus = new SanPhamBUS();

    public SearchMenuListener(MenuPanel menu, MyLoaiSPComboBox bx, JTextField searchField) {
        this.menu = menu;
        this.bx = bx;
        this.searchField = searchField;
    }
    
    @Override
    public void insertUpdate(DocumentEvent e) {
        changeOnText();
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        changeOnText();
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        changeOnText();
    }
    
    public void changeOnText(){
        int maLoaiHienTai = bx.getSelectedMaLoai();
        List<SanPham> list = spBus.getProductByTypeAndName(maLoaiHienTai, searchField.getText());
        menu.addToPanel(list);
    }
    
}
