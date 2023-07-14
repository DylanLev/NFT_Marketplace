package package1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class NFTPage extends JFrame implements ActionListener {

        private ImageButton searchButton,cartButton, walletButton, accountButton;
        private JLabel pageTitleLabel;

        private JLabel searchIcon;
        private PlaceholderTextField searchField;


        public NFTPage() {
            setTitle("NFT_MarketPlace");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLayout(new BorderLayout());

            
            // ToolBar
            JToolBar toolBar = new JToolBar();
            toolBar.setFloatable(false);

            // Logo
            ImageIcon logoIcon = new ImageIcon("src/package1/logo.jpg");
            Image logoImage = logoIcon.getImage();
            Image resizedLogoImage = logoImage.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
            ImageIcon resizedLogoIcon = new ImageIcon(resizedLogoImage);
            JLabel logoLabel = new JLabel(resizedLogoIcon);
            toolBar.add(logoLabel);
            
            setIconImage(logoIcon.getImage());
            
            pageTitleLabel = new JLabel("NFT_MarketPlace");
            pageTitleLabel.setFont(pageTitleLabel.getFont().deriveFont(Font.BOLD, 18));
            toolBar.add(pageTitleLabel);

            // Search Field
            JPanel searchPanel = new JPanel(new BorderLayout());
            searchPanel.setBackground(Color.WHITE);

            ImageIcon icon = new ImageIcon("src/package1/search.png");
            Image image = icon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(image);

            searchField = new PlaceholderTextField("  Search an NFT");
            searchField.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 5));
            searchField.setFont(searchField.getFont().deriveFont(Font.PLAIN));
            searchField.setForeground(Color.GRAY);

            
            searchField.addActionListener(this);
            searchField.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                        performSearch();
                    }
                }
            });

            searchButton = new ImageButton(scaledIcon);

            searchButton.addActionListener(this);

            searchPanel.add(searchField, BorderLayout.CENTER);
            searchPanel.add(searchButton, BorderLayout.WEST);

            toolBar.add(searchPanel);

            walletButton = new ImageButton("src/package1/wallet.png");
            accountButton =  new ImageButton("src/package1/account.png");
            cartButton = new ImageButton("src/package1/cart.png");
            
            Font buttonFont = new Font("Arial", Font.BOLD, 16);
            walletButton.setFont(buttonFont);
            accountButton.setFont(buttonFont);
            cartButton.setFont(buttonFont);
            
            Dimension buttonSize = new Dimension(150, 50);
            walletButton.setPreferredSize(buttonSize);
            accountButton.setPreferredSize(buttonSize);
            cartButton.setPreferredSize(buttonSize);
            
            walletButton.addActionListener(this);
            accountButton.addActionListener(this);
            cartButton.addActionListener(this);

            toolBar.add(walletButton);
            toolBar.add(accountButton);
            toolBar.add(cartButton);

            add(toolBar, BorderLayout.NORTH);

            // NFT Panel
            JPanel nftPanel = new JPanel();
            nftPanel.setLayout(new GridLayout(2, 3, 10, 10));

            // NFT 1
            JPanel nft1Panel = createNFTPanel("NFT 1", "0.5 Ethereum");
            nftPanel.add(nft1Panel);

            // NFT 2
            JPanel nft2Panel = createNFTPanel("NFT 2", "1 Ethereum");
            nftPanel.add(nft2Panel);

            // NFT 3
            JPanel nft3Panel = createNFTPanel("NFT 3", "2 Ethereum");
            nftPanel.add(nft3Panel);

            // NFT 4
            JPanel nft4Panel = createNFTPanel("NFT 4", "0.8 Ethereum");
            nftPanel.add(nft4Panel);

            // NFT 5
            JPanel nft5Panel = createNFTPanel("NFT 5", "1.5 Ethereum");
            nftPanel.add(nft5Panel);

            // NFT 6
            JPanel nft6Panel = createNFTPanel("NFT 6", "0.2 Ethereum");
            nftPanel.add(nft6Panel);

            add(nftPanel, BorderLayout.CENTER);
            

            pack();
            setLocationRelativeTo(null); // Center the frame on the screen
            setSize(1550,830);

        }
    private JPanel createNFTPanel(String name, String price) {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBorder(BorderFactory.createEtchedBorder());

        JLabel nameLabel = new JLabel(name);
        nameLabel.setHorizontalAlignment(JLabel.CENTER);
        panel.add(nameLabel, BorderLayout.CENTER);

        JLabel priceLabel = new JLabel(price);
        priceLabel.setHorizontalAlignment(JLabel.CENTER);
        panel.add(priceLabel, BorderLayout.SOUTH);

        panel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NFTDetailPage detailPage = new NFTDetailPage(name, price);
                detailPage.setVisible(true);
            }
        });

        return panel;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
         if (e.getSource() == walletButton) {
            // Redirect to another page when the wallet button is clicked
            // You can replace the code below with the desired page redirection logic
            JOptionPane.showMessageDialog(this, "Wallet button clicked!");
        } else if (e.getSource() == accountButton) {
            // Redirect to another page when the account button is clicked
            // You can replace the code below with the desired page redirection logic
            JOptionPane.showMessageDialog(this, "Account button clicked!");
        } else if (e.getSource() == cartButton) {
            // Redirect to another page when the cart button is clicked
            // You can replace the code below with the desired page redirection logic
            JOptionPane.showMessageDialog(this, "Cart button clicked!");
        }
    }
    private void performSearch() {
        String searchQuery = searchField.getText();
        // Perform the search action with the search query
        JOptionPane.showMessageDialog(this, "Performing search: " + searchQuery);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            NFTPage nftPage = new NFTPage();
            nftPage.setVisible(true);
        });
    }
}
