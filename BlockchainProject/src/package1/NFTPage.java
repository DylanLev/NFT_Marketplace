package package1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class NFTPage extends JFrame implements ActionListener {

    private ImageButton searchButton, cartButton, walletButton, accountButton;
    private JLabel pageTitleLabel;

    private PlaceholderTextField searchField;

    private List<NFTImageButton> nftButtons;
    private List<NFTImageButton> boughtButtons;

    public NFTPage() {
        setTitle("NFT_MarketPlace");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        nftButtons = new ArrayList<>();
        boughtButtons = new ArrayList<>();

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
        accountButton = new ImageButton("src/package1/account.png");
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

        JPanel nftPanelWrapper = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel nftPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));

        // Add NFT buttons dynamically
        addNFTButton("Aquarelle", "Floor: 0.5 ETH", "src/package1/nftImage/aquarelle.jpg", nftPanel);
        addNFTButton("Balloons", "Floor: 1.0 ETH", "src/package1/nftImage/balloons.jpg", nftPanel);
        addNFTButton("Cigarrette", "Floor: 0.2 ETH", "src/package1/nftImage/cigarette.jpg", nftPanel);
        addNFTButton("Clouds", "Floor: 0.3 ETH", "src/package1/nftImage/clouds.jpg", nftPanel);
        addNFTButton("Coin", "Floor: 0.5 ETH", "src/package1/nftImage/coin.jpg", nftPanel);
        addNFTButton("Colors", "Floor: 0.05 ETH", "src/package1/nftImage/colors.jpg", nftPanel);
        addNFTButton("Cross", "Floor: 0.02 ETH", "src/package1/nftImage/cross.jpg", nftPanel);
        addNFTButton("Cryptoart", "Floor: 0.09 ETH", "src/package1/nftImage/cryptoart.jpg", nftPanel);
        addNFTButton("Cubes", "Floor: 0.04 ETH", "src/package1/nftImage/cubes.jpg", nftPanel);
        addNFTButton("Deer", "Floor: 0.5 ETH", "src/package1/nftImage/deer.jpg", nftPanel);
        addNFTButton("Fish", "Floor: 0.25 ETH", "src/package1/nftImage/fish.jpg", nftPanel);
        addNFTButton("Lasers", "Floor: 0.65 ETH", "src/package1/nftImage/lasers.jpg", nftPanel);
        addNFTButton("Light", "Floor: 0.58 ETH", "src/package1/nftImage/light.jpg", nftPanel);
        addNFTButton("Love", "Floor: 0.69 ETH", "src/package1/nftImage/love.jpg", nftPanel);
        addNFTButton("Man", "Floor: 0.47 ETH", "src/package1/nftImage/man.jpg", nftPanel);
        addNFTButton("Metaverse", "Floor: 0.02 ETH", "src/package1/nftImage/metaverse.jpg", nftPanel);
        addNFTButton("Mix", "Floor: 0.01 ETH", "src/package1/nftImage/mix.jpg", nftPanel);
        addNFTButton("Monkey", "Floor: 0.03 ETH", "src/package1/nftImage/monkey.jpg", nftPanel);
        addNFTButton("Mountains", "Floor: 0.04 ETH", "src/package1/nftImage/mountains.jpg", nftPanel);
        addNFTButton("Painting", "Floor: 0.71 ETH", "src/package1/nftImage/painting.jpg", nftPanel);
        addNFTButton("Purple", "Floor: 0.32 ETH", "src/package1/nftImage/purple.jpg", nftPanel);
        addNFTButton("Qrcode", "Floor: 0.91 ETH", "src/package1/nftImage/qrcode.jpg", nftPanel);
        addNFTButton("Red", "Floor: 0.14 ETH", "src/package1/nftImage/red.jpg", nftPanel);
        addNFTButton("Redmoon", "Floor: 0.05 ETH", "src/package1/nftImage/redmoon.jpg", nftPanel);
        addNFTButton("Statue", "Floor: 0.05 ETH", "src/package1/nftImage/statue.jpg", nftPanel);
        // Add more buttons as needed...

        nftPanelWrapper.add(nftPanel);

        JScrollPane scrollPane = new JScrollPane(nftPanelWrapper);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);

        // Navigation buttons
        JButton prevButton = new JButton("<");
        JButton nextButton = new JButton(">");

        prevButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int scrollAmount = scrollPane.getViewport().getViewRect().width;
                JScrollBar horizontalScrollBar = scrollPane.getHorizontalScrollBar();
                int currentPosition = horizontalScrollBar.getValue();
                horizontalScrollBar.setValue(currentPosition - scrollAmount);
            }
        });

        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int scrollAmount = scrollPane.getViewport().getViewRect().width;
                JScrollBar horizontalScrollBar = scrollPane.getHorizontalScrollBar();
                int currentPosition = horizontalScrollBar.getValue();
                horizontalScrollBar.setValue(currentPosition + scrollAmount);
            }
        });

        JPanel buttonPanel = new JPanel(new BorderLayout());
        buttonPanel.add(prevButton, BorderLayout.WEST);
        buttonPanel.add(nextButton, BorderLayout.EAST);

        JPanel p1 = new JPanel(new BorderLayout());

        p1.add(buttonPanel, BorderLayout.NORTH);
        p1.add(scrollPane, BorderLayout.CENTER);

        add(p1, BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null); // Center the frame on the screen
        setSize(1550, 830);
    }

    private void addNFTButton(String name, String price, String imagePath, JPanel panel) {
        ImageIcon imageIcon = new ImageIcon(imagePath);
        Image image = imageIcon.getImage().getScaledInstance(450, 450, Image.SCALE_SMOOTH);
        ImageIcon scaledImageIcon = new ImageIcon(image);
        NFTImageButton nftButton = new NFTImageButton(name, price, scaledImageIcon);
        nftButton.setPreferredSize(new Dimension(500, 500));
        nftButton.addActionListener(this);
        nftButton.setBuyListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NFTImageButton clickedButton = (NFTImageButton) e.getSource();
                if (!boughtButtons.contains(clickedButton)) {
                    // Move the bought button to the "boughtButtons" list
                    nftButtons.remove(clickedButton);
                    boughtButtons.add(clickedButton);

                    // Remove the image from the button
                    clickedButton.removeImage();

                    // Refresh the layout
                    revalidate();
                    repaint();
                }
            }
        });
        nftButtons.add(nftButton);
        panel.add(nftButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == walletButton) {
            JOptionPane.showMessageDialog(this, "Wallet button clicked!");
        } else if (e.getSource() == accountButton) {
            JOptionPane.showMessageDialog(this, "Account button clicked!");
        } else if (e.getSource() == cartButton) {
            CartPage cartPage = new CartPage();
            cartPage.setVisible(true);
        }
        if (e.getSource() instanceof NFTImageButton) {
            NFTImageButton nftButton = (NFTImageButton) e.getSource();
            if (!boughtButtons.contains(nftButton)) {
                NFTDetailPage detailPage = new NFTDetailPage(nftButton.getName(), nftButton.getPrice());
                detailPage.setBuyListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        nftButtons.remove(nftButton);
                        boughtButtons.add(nftButton);
                        nftButton.removeImage();
                        revalidate();
                        repaint();
                    }
                });
                detailPage.setVisible(true);
            }
        }
    }

    private void performSearch() {
        String searchQuery = searchField.getText().toLowerCase();

        for (NFTImageButton nftButton : nftButtons) {
            String name = nftButton.getName().toLowerCase();
            if (name.contains(searchQuery)) {
                nftButton.setVisible(true);
            } else {
                nftButton.setVisible(false);
            }
        }

        revalidate();
        repaint();
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            NFTPage nftPage = new NFTPage();
            nftPage.setVisible(true);
        });
    }
}
