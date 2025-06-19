
package GUI.SaleGroup.SellerGUI.BasicHandle;

import BUS.SaleServices.PayActionBus;
import GUI.SaleGroup.SellerGUI.Component.OrderPanel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class DiscountTextFieldListener implements DocumentListener{
    private PayActionBus pay = new PayActionBus();
    private OrderPanel orderPanel;

    public DiscountTextFieldListener(OrderPanel orderPanel) {
        this.orderPanel = orderPanel;
    }
    

    @Override
    public void insertUpdate(DocumentEvent e) {
        orderPanel.calculatePayment();
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        orderPanel.calculatePayment();  
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        orderPanel.calculatePayment();
    }
    
}
