
package GUI.SaleGroup.LoginGui.Component;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Button extends JButton{
   
public Button(){
    
       Color xanhDam =  Color.decode("#A9F0A8");
        setFont(new Font("Calibri", Font.PLAIN, 14));
        setBackground(xanhDam);
        setForeground(Color.BLACK);
        this.setUI(new ButtonUI());
    }

}