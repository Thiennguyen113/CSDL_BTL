
package GUI.SaleGroup.SellerGUI.BasicHandle;

import DTO.ChiTietHoaDon;
import DTO.SanPham;
import GUI.SaleGroup.SellerGUI.Component.OrderItem;
import GUI.SaleGroup.SellerGUI.Component.OrderPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class RemoveOrderItemAction implements ActionListener{
//    private SanPham sp;
    private OrderPanel orderpanel;
    private OrderItem orderItem;

    
     public RemoveOrderItemAction(OrderItem orderItem, OrderPanel orderpanel) {
        this.orderItem = orderItem;
        this.orderpanel = orderpanel;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {

        orderpanel.removeOrderItem(orderItem);
        //đếm số lượng sản phẩm trong panel order
        orderpanel.checkButtonThanhToan();

    }
    
}
