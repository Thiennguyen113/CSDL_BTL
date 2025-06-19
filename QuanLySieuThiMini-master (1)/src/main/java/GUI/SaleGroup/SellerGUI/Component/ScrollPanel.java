package GUI.SaleGroup.SellerGUI.Component;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 * ScrollPanel - Custom JScrollPane wrapping a JPanel with FlowLayout.
 * Designed for displaying a dynamic grid/list of components.
 */
public class ScrollPanel extends JScrollPane {
    protected final JPanel panel;
    protected int width;
    protected int height;
    protected int hGap = 10;
    protected int wGap = 10;

    public ScrollPanel(int width, int height) {
        panel = new JPanel();
        this.setViewportView(panel);
        this.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        this.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        this.setBorder(BorderFactory.createEmptyBorder());
        this.setViewportBorder(BorderFactory.createEmptyBorder());
        this.width = width;
        this.height = height;
        this.getVerticalScrollBar().setUnitIncrement(6);
        panel.setPreferredSize(new Dimension(this.width, this.height));
        this.setBounds(0, 0, width, height);
        panel.setLayout(new FlowLayout(FlowLayout.LEFT, wGap, hGap));
        panel.setBackground(Color.decode("#E9F0F3"));
    }

    public Dimension getChildComponentSize() {
        if (panel.getComponentCount() == 0)
            return new Dimension(0, 0);
        return panel.getComponent(0).getPreferredSize();
    }

    protected int calculateHeight() {
        if (panel.getComponentCount() == 0 || getChildComponentSize().getWidth() == 0 || getChildComponentSize().getHeight() == 0)
            return 0;
        int maxInCol = (int) (panel.getPreferredSize().getWidth() / getChildComponentSize().getWidth());
        int maxInRow = roundToNextInt(panel.getComponentCount() * 1.0 / maxInCol);
        maxInRow = maxInRow == 0 ? 1 : maxInRow;
        int height = (int) (maxInRow * (getChildComponentSize().getHeight() + (hGap + 1)));
        return height;
    }

    protected int roundToNextInt(double num) {
        if (num % 1 == 0) {
            return (int) num;
        }
        return (int) num + 1;
    }

    public int gethGap() {
        return hGap;
    }

    public void sethGap(int hGap) {
        this.hGap = hGap;
        panel.setLayout(new FlowLayout(FlowLayout.LEFT, wGap, hGap));
    }

    public int getwGap() {
        return wGap;
    }

    public void setwGap(int wGap) {
        this.wGap = wGap;
        panel.setLayout(new FlowLayout(FlowLayout.LEFT, wGap, hGap));
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
        panel.setPreferredSize(new Dimension(this.width, this.height));
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
        panel.setPreferredSize(new Dimension(this.width, this.height));
    }

    public JPanel getPanel() {
        return panel;
    }
}