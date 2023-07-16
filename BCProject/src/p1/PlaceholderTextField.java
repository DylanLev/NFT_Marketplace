package p1;

import javax.swing.JTextField;
import javax.swing.*;
import java.awt.*;

public class PlaceholderTextField extends JTextField {

    private String placeholder;

    public PlaceholderTextField(String placeholder) {
        this.placeholder = placeholder;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Display the placeholder text if the text field is empty and does not have focus
        if (getText().isEmpty() && !hasFocus()) {
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setColor(Color.GRAY);
            g2d.setFont(getFont().deriveFont(Font.ITALIC));
            int x = getInsets().left;
            int y = (getHeight() - g2d.getFontMetrics().getHeight()) / 2 + g2d.getFontMetrics().getAscent();
            g2d.drawString(placeholder, x, y);
            g2d.dispose();
        }
    }
}
