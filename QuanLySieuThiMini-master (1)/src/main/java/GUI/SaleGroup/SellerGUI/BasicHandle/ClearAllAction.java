
package GUI.SaleGroup.SellerGUI.BasicHandle;

import GUI.SaleGroup.SellerGUI.Component.OrderPanel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ClearAllAction extends MouseAdapter{
    private OrderPanel orderPanel;
    
    public ClearAllAction(OrderPanel orderPanel){
        this.orderPanel = orderPanel;
    }
    
    @Override
    public void mousePressed(MouseEvent e) {
        orderPanel.removeAllOrderItem();
        orderPanel.getBnThanhToan().setEnabled(false);
    }
    
}
