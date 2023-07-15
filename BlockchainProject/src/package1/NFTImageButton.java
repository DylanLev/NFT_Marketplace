package package1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NFTImageButton extends JButton {
    private String name;
    private String price;
    private JLabel nameLabel;
    private JLabel priceLabel;
    private ActionListener buyListener;

    public NFTImageButton(String name, String price, ImageIcon icon) {
        super(icon);
        this.name = name;
        this.price = price;
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder());

        JPanel textPanel = new JPanel(new BorderLayout());
        textPanel.setOpaque(false);

        nameLabel = new JLabel(name);
        nameLabel.setForeground(Color.BLACK);
        textPanel.add(nameLabel, BorderLayout.NORTH);

        priceLabel = new JLabel(price);
        priceLabel.setForeground(Color.BLACK);
        textPanel.add(priceLabel, BorderLayout.SOUTH);

        add(textPanel, BorderLayout.SOUTH);
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public void setBuyListener(ActionListener listener) {
        this.buyListener = listener;
    }

    public void removeImage() {
        setIcon(null);
    }

    public void buyNFT() {
        if (buyListener != null) {
            buyListener.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "buy"));
        }
    }
}
