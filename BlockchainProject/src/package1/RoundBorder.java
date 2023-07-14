package package1;

import javax.swing.*;
import javax.swing.border.AbstractBorder;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class RoundBorder extends AbstractBorder {

    private int arc;
    private Color borderColor;

    public RoundBorder(int arc, Color borderColor) {
        this.arc = arc;
        this.borderColor = borderColor;
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        Graphics2D g2 = (Graphics2D) g.create();

        // Set rendering hints for smooth drawing
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Draw a rounded rectangle border with black stroke
        g2.setColor(borderColor);
        g2.setStroke(new BasicStroke(2)); // Set the stroke width
        g2.draw(new RoundRectangle2D.Double(x, y, width - 1, height - 1, arc, arc));

        g2.dispose();
    }
}

