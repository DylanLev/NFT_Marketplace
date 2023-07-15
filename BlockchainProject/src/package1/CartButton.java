package package1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CartButton extends JButton {

    private static int cartItemCount = 0;

    public CartButton() {
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cartItemCount++;
                repaint();
            }
        });
    }

    public static void setCartItemCount(int count) {
        cartItemCount = count;
    }

    public static int getCartItemCount() {
        return cartItemCount;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw the cart item count as text on top of the button's icon
        if (cartItemCount > 0) {
            Graphics2D g2d = (Graphics2D) g.create();
            Font font = new Font("Arial", Font.BOLD, 12);
            FontMetrics metrics = g2d.getFontMetrics(font);
            int textWidth = metrics.stringWidth(String.valueOf(cartItemCount));
            int x = getWidth() - textWidth - 8;
            int y = metrics.getHeight() + 4;

            g2d.setColor(Color.WHITE);
            g2d.setFont(font);
            g2d.drawString(String.valueOf(cartItemCount), x, y);

            g2d.dispose();
        }
    }
}
