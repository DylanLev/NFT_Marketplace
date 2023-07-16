package p1;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class NFTDetailPage extends JFrame implements ActionListener {

    private JLabel nameLabel;
    private JLabel priceLabel;
    private JButton addToCartButton;
    private JButton buyNowButton;
    private ArrayList<Product> cartItems;
    private ActionListener buyListener;
    
    public NFTDetailPage(String name, String price) {
        setTitle("NFT Detail");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(400, 200));

        cartItems = new ArrayList<>();
        
        nameLabel = new JLabel(name);
        priceLabel = new JLabel(price);

        addToCartButton = new JButton("Add to Cart");
        buyNowButton = new JButton("Buy Now");

        addToCartButton.addActionListener(this);
        buyNowButton.addActionListener(this);

        JPanel detailsPanel = new JPanel();
        detailsPanel.setLayout(new GridLayout(2, 2, 10, 10));
        detailsPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        detailsPanel.add(new JLabel("Name:"));
        detailsPanel.add(nameLabel);
        detailsPanel.add(new JLabel("Price:"));
        detailsPanel.add(priceLabel);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(addToCartButton);
        buttonPanel.add(buyNowButton);

        add(detailsPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        
        pack();
        setLocationRelativeTo(null); // Center the frame on the screen
    }
	public void setBuyListener(ActionListener listener) {
	            this.buyListener = listener;
	        }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addToCartButton) {
            // Perform the "Add to Cart" action
            cartItems.add(new Product(nameLabel.getText(), priceLabel.getX()));

            // Update the cart icon to display the number of items in the cart
            int cartItemCount = CartButton.getCartItemCount(); // Get the current number of items in the cart
            // Update the cart button text to display the cart item count
            CartButton.setCartItemCount(cartItemCount);

            JOptionPane.showMessageDialog(this, "Item added to cart!");
        } else if (e.getSource() == buyNowButton&& buyListener != null) {
            buyListener.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "buy"));
            
            JOptionPane.showMessageDialog(this, "Buy Now button clicked!");
        }
    }

  

}

