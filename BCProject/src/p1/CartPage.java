package p1;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class CartPage extends JFrame {
	
    private List<Product> cartItems;
    private JPanel cartPanel;
    private JLabel totalPriceLabel;

    public CartPage() {
        cartItems = new ArrayList<>();

        setTitle("Cart");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        cartPanel = new JPanel();
        cartPanel.setLayout(new BoxLayout(cartPanel, BoxLayout.Y_AXIS));

        JScrollPane scrollPane = new JScrollPane(cartPanel);
        add(scrollPane, BorderLayout.CENTER);

        JPanel totalPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        totalPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel totalLabel = new JLabel("Total:");
        totalPanel.add(totalLabel);

        totalPriceLabel = new JLabel("$0");
        totalPanel.add(totalPriceLabel);

        add(totalPanel, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null); // Center the frame on the screen
    }

    public void addItemToCart(Product product) {
        cartItems.add(product);
        JLabel productLabel = new JLabel(product.getName() + " - " + product.getPrice());
        cartPanel.add(productLabel);
        revalidate(); // Refresh the cart panel
        updateTotalPrice();
    }

    private void updateTotalPrice() {
        double totalPrice = 0;
        for (Product product : cartItems) {
            totalPrice += product.getPrice();
        }
        totalPriceLabel.setText(String.format("$%.2f", totalPrice));
    }
}
