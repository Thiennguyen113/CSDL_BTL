
package GUI.ManageGroup.ManageItem.FrameAdd.ComponentFrameAdd;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class GiamGiaSanPhamAddBackground extends javax.swing.JPanel {

    public GiamGiaSanPhamAddBackground() {
        initComponents();
    }
     protected void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D) g.create();
        Color xanhlam = getBackground();
       g2d.setRenderingHint(java.awt.RenderingHints.KEY_ANTIALIASING, java.awt.RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(xanhlam);
        g2d.fillRoundRect(0, 0, getWidth(), getHeight()/3, 0, 0);
        g2d.setColor(Color.WHITE);
        g2d.fillRoundRect(0, getHeight()/3, getWidth(), getHeight()-getHeight()/3, 0, 0);

        g2d.dispose();
        super.paintComponent(g);
        
   
        setOpaque(false);
    
    }

   
    @SuppressWarnings("unchecked")
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
