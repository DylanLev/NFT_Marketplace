package package1;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.*;

public class Signin_Page extends JFrame implements ActionListener {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JTextField usernameField;
    private JPasswordField passwordField;
    private JTextField idField;
    private JButton submitButton;
    private ConnexionPage connexionPage; // Reference to the ConnexionPage instance


    public Signin_Page(ConnexionPage connexionPage) {
        this.connexionPage = connexionPage; // Assign the ConnexionPage instance

        setTitle("Sign In Page");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(400, 200));

        JPanel formPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel usernameLabel = new JLabel("Username:");
        usernameField = new JTextField(20);
        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField(20);
        JLabel idLabel = new JLabel("ID:");
        idField = new JTextField(20);

        formPanel.add(usernameLabel);
        formPanel.add(usernameField);
        formPanel.add(passwordLabel);
        formPanel.add(passwordField);
        formPanel.add(idLabel);
        formPanel.add(idField);

        submitButton = new JButton("Submit");
        submitButton.addActionListener(this);

        add(formPanel, BorderLayout.CENTER);
        add(submitButton, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null); // Center the frame on the screen
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
        	
        	        String username = usernameField.getText();
        	        String password = new String(passwordField.getPassword());
        	        String id = idField.getText();

        	        int count_num = 0, count_letter = 0, count_spe = 0;
        	        int count = 0;
        	        int count_id_num = 0;

        	        for (int i = 0; i < id.length(); i++) {
        	            if (id.charAt(i) >= '0' && id.charAt(i) <= '9') {
        	                count_id_num++;
        	            }
        	        }

        	        if (username.length() >= 6 && username.length() <= 8) {
        	            for (int i = 0; i < username.length(); i++) {
        	                if (username.charAt(i) >= '0' && username.charAt(i) <= '9') {
        	                    count++;
        	                }
        	            }
        	            if (count > 2) {
        	                showErrorMessage("Error with the username", "Your username is wrong, you need a maximum of 2 digits");
        	            } else {
        	                if (password.length() >= 8 && password.length() <= 10) {
        	                    for (int i = 0; i < password.length(); i++) {
        	                        if (password.charAt(i) >= '0' && password.charAt(i) <= '9') {
        	                            count_num++;
        	                        }
        	                        if ((password.charAt(i) >= 'a' && password.charAt(i) <= 'z')
        	                                || (password.charAt(i) >= 'A' && password.charAt(i) <= 'Z')) {
        	                            count_letter++;
        	                        }
        	                        if ((password.charAt(i) >= '!' && password.charAt(i) <= '/')
        	                                || (password.charAt(i) >= ':' && password.charAt(i) <= '@')
        	                                || (password.charAt(i) >= '[' && password.charAt(i) <= '`')
        	                                || (password.charAt(i) >= '{' && password.charAt(i) <= '~')) {
        	                            count_spe++;
        	                        }
        	                    }
        	                    if (count_num < 1 || count_letter < 1 || count_spe < 1) {
        	                        showErrorMessage("Error with the password",
        	                                "Your password is wrong, you need at least one number, one letter, and one special character");
        	                    } else {
        	                        if (id.length() != 9 || count_id_num != 9) {
        	                            showErrorMessage("Error with the ID", "You need 9 digits in your ID");
        	                        } else {
        	                            // Write the account information to a CSV file
        	                            try {
        	                                BufferedWriter writer = new BufferedWriter(new FileWriter("src\\Excel\\Data.csv", true));
        	                                writer.write(username + "," + password + "," + id);
        	                                writer.newLine();
        	                                writer.close();

        	                                JOptionPane.showMessageDialog(this, "Account created successfully!");

        	                                dispose(); // Close the sign-in page

        	                                // Redirect to the ConnexionPage
        	                                connexionPage.setVisible(true);
        	                            } catch (IOException ex) {
        	                                ex.printStackTrace();
        	                                showErrorMessage("Error", "Error creating account. Please try again.");
        	                            }
        	                        }
        	                    }
        	                } else {
        	                    showErrorMessage("Error with the password",
        	                            "You need between 8 to 10 characters in your password");
        	                }
        	            }
        	        } else {
        	            showErrorMessage("Error with the username",
        	                    "You need between 6 to 8 characters in your username");
        	        }
        	    }
        	}

        	private void showErrorMessage(String title, String message) {
        	    JDialog dialog = new JDialog();
        	    dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        	    dialog.setModal(true);
        	    dialog.setSize(400, 100);
        	    dialog.setTitle(title);

        	    JLabel l1 = new JLabel(message);
        	    JButton okButton = new JButton("OK");
        	    okButton.setBackground(Color.GRAY);

        	    dialog.add(l1, BorderLayout.CENTER);
        	    dialog.add(okButton, BorderLayout.SOUTH);
        	    okButton.addActionListener(new ActionListener() {
        	        public void actionPerformed(ActionEvent e) {
        	            dialog.dispose();
        	        }
        	    });

        	    dialog.setVisible(true);
        	

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Signin_Page signinPage = new Signin_Page(null);
            signinPage.setVisible(true);
        });
    }
}
