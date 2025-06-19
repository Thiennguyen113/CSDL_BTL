
package GUI.SaleGroup.SellerGUI.Component;

import BUS.BusAccessor.SanPhamBUS;
import DAL.DataAcessObject.SanPhamDAO;
import DTO.SanPham;
import GUI.SaleGroup.SellerGUI.BasicHandle.HandleClickAddEvent;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

public class MenuPanel extends ScrollPanel{
    private final SanPhamDAO spDAO = new SanPhamDAO();
    private final SanPhamBUS spbus = new SanPhamBUS();
    private List<SanPham> listData;
    private final OrderPanel orderpanel;

    public MenuPanel(int width, int height, OrderPanel orderPanel){
        super(width, height);
        this.orderpanel = orderPanel;
        listData = new ArrayList<>();
    }

    public void addToPanel(SanPham sp) {
        MenuItem item = new MenuItem(sp);
        item.getButtonAdd().addActionListener(new HandleClickAddEvent(sp, orderpanel));
        this.panel.add(item);
        this.panel.revalidate();
        this.panel.repaint();
        this.panel.setPreferredSize(new Dimension((int)this.panel.getPreferredSize().getWidth(),calculateHeight()));
    }

    public void addToPanel(List<SanPham> list) {
        this.removeAll();
        // Check for null to avoid NullPointerException
        if(list != null) {
            this.listData = list;
            for (SanPham sp : list){
                addToPanel(sp);
            }
        } else {
            this.listData = new ArrayList<>();
        }
    }

    public void removeAll(){
        this.panel.removeAll();
        this.panel.revalidate();
        this.panel.repaint();
        this.panel.setPreferredSize(new Dimension((int)this.panel.getPreferredSize().getWidth(),calculateHeight()));
    }

    public List<SanPham> getListData() {
        return this.listData;
    }

    public void showProducts() {
        List<SanPham> list = spbus.getAll();
        if (list == null) list = new ArrayList<>();
        this.addToPanel(list);
    }
}