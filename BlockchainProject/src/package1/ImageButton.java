package package1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class ImageButton extends JButton {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int IMAGE_WIDTH = 24;
    private static final int IMAGE_HEIGHT = 24;

    public ImageButton(String imagePath) {
        ImageIcon icon = new ImageIcon(imagePath);
        Image image = icon.getImage();
        Image scaledImage = image.getScaledInstance(IMAGE_WIDTH, IMAGE_HEIGHT, Image.SCALE_SMOOTH);
        setIcon(new ImageIcon(scaledImage));
        setBorderPainted(false);
        setContentAreaFilled(false);
        setFocusPainted(false);
        setOpaque(false);
    }
    public ImageButton(ImageIcon icon) {
        Image image = icon.getImage();
        Image scaledImage = image.getScaledInstance(IMAGE_WIDTH, IMAGE_HEIGHT, Image.SCALE_SMOOTH);
        setIcon(new ImageIcon(scaledImage));
        setBorderPainted(false);
        setContentAreaFilled(false);
        setFocusPainted(false);
        setOpaque(false);
    }
}

