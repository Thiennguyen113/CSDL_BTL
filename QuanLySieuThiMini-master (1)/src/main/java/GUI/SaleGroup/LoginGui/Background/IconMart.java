
package GUI.SaleGroup.LoginGui.Background;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;

public class IconMart extends javax.swing.JPanel {
    static Image image;
    public IconMart() {
        initComponents();
    }
     protected void paintComponent(Graphics g){ 
        Graphics2D g2d = (Graphics2D) g.create();
        image = new ImageIcon( ".\\src\\main\\java\\GUI\\SaleGroup\\LoginGui\\Image\\miniMart_resize.png").getImage();
        g2d.drawImage(image, 0, 0,  this);     
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

}
