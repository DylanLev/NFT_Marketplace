package package1;

import java.awt.*;
import java.awt.geom.*;
import java.awt.image.*;
import javax.swing.*;

public class ImageUtils {
    public static ImageIcon addBadge(ImageIcon icon, int badgeCount) {
        Image image = icon.getImage();
        BufferedImage bufferedImage = new BufferedImage(
            icon.getIconWidth(), icon.getIconHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = bufferedImage.createGraphics();
        g2d.drawImage(image, 0, 0, null);

        int badgeSize = 18; // Size of the badge
        int badgeMargin = 4; // Margin from the top-right corner of the image

        // Draw the badge circle
        int x = icon.getIconWidth() - badgeSize - badgeMargin;
        int y = badgeMargin;
        g2d.setPaint(Color.RED); // Badge color
        g2d.fill(new Ellipse2D.Double(x, y, badgeSize, badgeSize));

        // Draw the badge count
        g2d.setFont(g2d.getFont().deriveFont(Font.BOLD, 12));
        g2d.setPaint(Color.WHITE); // Text color
        FontMetrics fm = g2d.getFontMetrics();
        String countString = String.valueOf(badgeCount);
        int stringWidth = fm.stringWidth(countString);
        int stringHeight = fm.getAscent();
        int stringX = x + (badgeSize - stringWidth) / 2;
        int stringY = y + (badgeSize - stringHeight) / 2 + fm.getAscent();
        g2d.drawString(countString, stringX, stringY);

        g2d.dispose();

        return new ImageIcon(bufferedImage);
    }
}
