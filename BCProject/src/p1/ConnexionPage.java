package p1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;



public class ConnexionPage extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;

	private final static String FRAME_TEXT = "Connexion Page";

    static String username;
    static String password;
    static String id;
    
    JLabel label,label1,label2;
    JButton Login_button, b1a, b2a, b3a, Signin_button;
    JDialog dialog;
    JTextField textField ,textField1 ,textField2;
    BufferedImage image;
    JPasswordField passwordField;
    static JFrame frame;
    
    ConnexionPage() throws Exception{
        loadImages();
		
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	ConnexionPage p = new ConnexionPage(image);
            	frame = new JFrame(FRAME_TEXT);
            	frame.add(p);
            	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            	frame.pack();
            	frame.setSize(1550,830);	     	        	        
     	        frame.setVisible(true);
            }
        });
    }
    
    ConnexionPage(BufferedImage image) {
     	super(new GridBagLayout());
     	
    	final String LABEL_TEXT = "Username: ";
		final String LABEL_TEXT1 = "Password: ";
		final String LABEL_TEXT2 = "ID: ";
	    final String button_login = "Login";
	    final String Button_Signin = "Sign in";
	    final String LABEL_TEXT3 = "";
	
		
    	
	    
		label = new JLabel(LABEL_TEXT);
		label1 = new JLabel(LABEL_TEXT1);
		label2 = new JLabel(LABEL_TEXT2);
		textField = new JTextField(LABEL_TEXT3);
		passwordField = new JPasswordField(LABEL_TEXT3);
		textField2 = new JTextField(LABEL_TEXT3);
		Login_button = new JButton(button_login);
		Signin_button = new JButton(Button_Signin);

	
		
		
	     
		Login_button.addActionListener(this);
		Signin_button.addActionListener(this);
		
   

        this.image = image;

        JPanel pane1 = new JPanel(new FlowLayout());
        pane1.setOpaque(false);
        pane1.setBorder(new EmptyBorder(110,0,0,0));

        JPanel pane = new JPanel(new GridLayout(0,1,30,30));
        pane.setOpaque(false);
        pane1.add(pane, BorderLayout.CENTER);
        pane.add(label);
        label.setForeground(Color.WHITE);
		pane.add(textField);
		textField.setFont(new Font("Serif",  Font.PLAIN, 20));
		label.setFont(new Font("Serif", Font.BOLD, 20));
		
		pane.add(label1);
		label1.setForeground(Color.WHITE);
		pane.add(passwordField);
		passwordField.setFont(new Font("Serif", Font.PLAIN, 20));
		label1.setFont(new Font("Serif", Font.BOLD, 20));
		
		pane.add(label2);
		label2.setForeground(Color.WHITE);
		pane.add(textField2);
		textField2.setFont(new Font("Serif", Font.PLAIN, 20));
		label2.setFont(new Font("Serif", Font.BOLD, 20));
		
		JPanel pane_login = new JPanel(new FlowLayout());
		pane_login.setOpaque(false);
		pane1.add(pane_login, BorderLayout.PAGE_END);

		Login_button.setFont(new Font("Serif", Font.PLAIN, 20));
		Signin_button.setFont(new Font("Serif", Font.PLAIN, 20));

		pane_login.add(Login_button);
		pane_login.add(Signin_button);




     
        pane.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
		pane.setLayout(new GridLayout(0,2));
		pane1.setBorder(BorderFactory.createEmptyBorder(0,30,0,30));
		pane1.setLayout(new GridLayout(0,1));

		add(pane1);
			
	    }
    
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
    }
    
    
    public static void main(String[] args) throws Exception {
        ConnexionPage t = new  ConnexionPage();
        t.setVisible(true);
		
    }
    
    private void loadImages() {
		try {
			image = ImageIO.read(new File("src\\package1\\Ethereum.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==Login_button) {
			username = textField.getText();
			password = String.valueOf(passwordField.getPassword());
			id = textField2.getText();
			
			
			int count_num = 0, count_letter = 0, count_spe = 0;
			
			int count = 0;
			
			int count_id_num = 0;
			for(int i = 0; i < id.length(); i++) {
				
				 if(id.charAt(i) >= '0' && id.charAt(i) <= '9' )
					 count_id_num++;
			}
			if(username.length() >= 6 && username.length() <= 8) {
				
				for(int i = 0; i < username.length(); i++) {
					
					 if(username.charAt(i) >= '0' && username.charAt(i) <= '9' )
						 count++;
					 
				}
				if(count > 2) {

					dialog = new JDialog();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				    dialog.setModal(true);
				    dialog.pack();
				    dialog.setSize(400,100);
					dialog.setTitle("Error with the username");
					
					JLabel l1 = new JLabel("Your username is wrong, you need a maximum of 2 digits");

					
					b1a = new JButton("OK");
					b1a.setBackground(Color.GRAY);
					
					dialog.add(l1,BorderLayout.CENTER);
					dialog.add(b1a,BorderLayout.SOUTH);
					b1a.addActionListener(this);
					dialog.setVisible(true);
					
				}
				else {
					if(password.length() >=8 && password.length() <= 10) {
						for(int i = 0; i < password.length(); i++) {
							
							 if(password.charAt(i) >= '0' && password.charAt(i) <= '9' )
								 count_num++;
							 
							 if((password.charAt(i) >= 'a' && password.charAt(i) <= 'z') || (password.charAt(i) >= 'A' && password.charAt(i) <= 'Z'))
								 count_letter++;
							 if((password.charAt(i) >= '!' && password.charAt(i) <= '/') || (password.charAt(i) >= ':' && password.charAt(i) <= '@')
									 || (password.charAt(i) >= '[' && password.charAt(i) <= '`') || (password.charAt(i) >= '{' && password.charAt(i) <= '~'))
								 count_spe++;
						}
						if(count_num < 1 || count_letter < 1 || count_spe < 1 ) {
		
							dialog = new JDialog();
							dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
						    dialog.setModal(true);
						    dialog.pack();
						    dialog.setSize(400,100);
							dialog.setTitle("Error with the password");
							
							JLabel l1 = new JLabel("Your password is wrong, you need at least one number, one letter and one special character");

							b2a = new JButton("OK");
							b2a.setBackground(Color.GRAY);
							
							dialog.add(l1,BorderLayout.CENTER);
							dialog.add(b2a,BorderLayout.SOUTH);
							b2a.addActionListener(this);
							dialog.setVisible(true);
							
						}
						else {
							 if(id.length() != 9 || count_id_num != 9) {
									dialog = new JDialog();
									dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
								    dialog.setModal(true);
								    dialog.pack();
								    dialog.setSize(400,100);
									dialog.setTitle("Error with the ID");
									
									JLabel l1 = new JLabel("You need 9 digits in your ID");
					
									
									b3a = new JButton("OK");
									b3a.setBackground(Color.GRAY);
									
									dialog.add(l1,BorderLayout.CENTER);
									dialog.add(b3a,BorderLayout.SOUTH);
									b3a.addActionListener(this);
									dialog.setVisible(true);
								}
							 else {
								//frame.setVisible(false);
									
									try {
										NFTPage p1 = new NFTPage();
										p1.setVisible(true);
									} catch (Exception e1) {
										e1.printStackTrace();
									}   
							 }
						}
					}
					
					else  {
						
						dialog = new JDialog();
						dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					    dialog.setModal(true);
					    dialog.pack();
					    dialog.setSize(400,100);
						dialog.setTitle("Error with the username");
						
						JLabel l1 = new JLabel("You need between 8 to 10 characters in your password");

						
						b2a = new JButton("OK");
						b2a.setBackground(Color.GRAY);
						
						dialog.add(l1,BorderLayout.CENTER);
						dialog.add(b2a,BorderLayout.SOUTH);
						b2a.addActionListener(this);
						dialog.setVisible(true);
					}
					
				}
			}
			else  {
				
				dialog = new JDialog();
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			    dialog.setModal(true);
			    dialog.pack();
			    dialog.setSize(400,100);
				dialog.setTitle("Error with the username");
				
				JLabel l1 = new JLabel("You need between 6 to 8 characters in your username");

				
				b1a = new JButton("OK");
				b1a.setBackground(Color.GRAY);
				
				dialog.add(l1,BorderLayout.CENTER);
				dialog.add(b1a,BorderLayout.SOUTH);
				b1a.addActionListener(this);
				dialog.setVisible(true);
			}
			
			
			
			
	}
		if(e.getSource()==Signin_button) {
			//frame.setVisible(false);
			
			try {
				Signin_Page p1 = new Signin_Page(this);
				p1.setVisible(true);
			} catch (Exception e1) {
				e1.printStackTrace();
			}   
		}
		if(e.getSource()==b1a ) {
			dialog.dispose();
		}	
		if (e.getSource()== b2a) {
			dialog.dispose();
		}
		if (e.getSource()== b3a) {
			dialog.dispose();
		}
		
		
	}
	 public void redirectToConnexionPage() {
	        frame.setVisible(true); // Show the ConnexionPage
	    }
		
	}
	























