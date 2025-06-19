
package GUI.SaleGroup.SellerGUI.BasicHandle;

import DTO.LoaiSanPham;
import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;

public class ComboboxLoaiSanPhamRender extends DefaultListCellRenderer{

    public ComboboxLoaiSanPhamRender() {
    }
    
    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        if (value instanceof LoaiSanPham loaiSanPham) {
            value = loaiSanPham.getTenLoai();
            list.setToolTipText(loaiSanPham.getMoTa());
        }
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        return this;
    }
    
    
}
