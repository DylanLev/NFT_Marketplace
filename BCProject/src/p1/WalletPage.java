package p1;
//WalletPage.java
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WalletPage extends JFrame {
 public WalletPage() {
     setTitle("Wallet");
     setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
     setLayout(new BorderLayout());

     JPanel centerPanel = new JPanel(new GridBagLayout());
     centerPanel.setBackground(Color.WHITE);

     String[] moneyOptions = {
             "Metamask",
             "Coinbase Wallet",
             "WalletConnect",
             "Ledger",
             "Phantom",
             "BitKeep"
             
     };

     Dimension buttonSize = new Dimension(200, 50);

     GridBagConstraints gbc = new GridBagConstraints();
     gbc.gridx = 0;
     gbc.gridy = 1;
     gbc.insets = new Insets(10, 0, 10, 0); // Add spacing around buttons

     for (String moneyOption : moneyOptions) {
         JButton button = new JButton(moneyOption);
         button.setPreferredSize(buttonSize);

         button.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 String selectedOption = ((JButton) e.getSource()).getText();
                 JOptionPane.showMessageDialog(WalletPage.this, selectedOption + " selected");
             }
         });

         centerPanel.add(button, gbc);
         gbc.gridy++;
     }

     JLabel titleLabel = new JLabel("Connect your wallet:");
     titleLabel.setFont(titleLabel.getFont().deriveFont(Font.BOLD, 18));
     titleLabel.setHorizontalAlignment(SwingConstants.CENTER); // Center the title text

     add(titleLabel, BorderLayout.NORTH);
     add(centerPanel, BorderLayout.CENTER);

     pack();
     setLocationRelativeTo(null); // Center the frame on the screen
 }
}
