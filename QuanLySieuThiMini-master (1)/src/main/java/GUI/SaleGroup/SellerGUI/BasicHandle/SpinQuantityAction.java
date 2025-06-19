
package GUI.SaleGroup.SellerGUI.BasicHandle;

import GUI.SaleGroup.SellerGUI.Component.OrderItem;
import GUI.SaleGroup.SellerGUI.Component.OrderPanel;
import javax.swing.event.DocumentEvent;

public class SpinQuantityAction implements javax.swing.event.DocumentListener{
    private OrderItem orderItem;
    private OrderPanel orderPanel;
    
    public SpinQuantityAction(){
        
    }
    
    public SpinQuantityAction(OrderItem orderItem, OrderPanel orderPanel){
        this.orderItem = orderItem;
        this.orderPanel = orderPanel;
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        orderItem.showUpdateTotalPrice();
        orderPanel.calculatePayment();
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        orderItem.showUpdateTotalPrice();
        orderPanel.calculatePayment();
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        orderItem.showUpdateTotalPrice();
        orderPanel.calculatePayment();
    }


}
