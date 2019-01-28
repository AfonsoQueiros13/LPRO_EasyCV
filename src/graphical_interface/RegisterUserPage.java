
package graphical_interface;
import logic.template;
import logic.user;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.net.UnknownHostException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Date: Jan 03-2019
 * This is a class that creates the "RegisterUserPage" layout and actions
 * @author nunonogueira, joaoneves, josemiguel, afonsoqueiros
 * @version 1.0
 */

public class RegisterUserPage { 
	
	/**
	 * Initialize  values
	 */
	String username;
	String password;
	public JFrame frame;
	public JTextField emailfield;
	public JButton register;
	public JPasswordField passwordField;
	public JPasswordField passwordField_confirm;

	
	/**
	 * Constructor of the RegisterUserPage class
	 * @param utilizador
	 * @throws UnknownHostException
	 * @throws IOException
	 */
	public RegisterUserPage(user utilizador,template template_obj) throws UnknownHostException, IOException {
		
		register_swing(utilizador,template_obj); 
	}

	/**
	 * Initialize the contents of the frame.
	 * @param uri
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
	public static boolean openWebpage(URI uri) {
	    Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
	    if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
	        try {
	            desktop.browse(uri);
	            return true;
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	    return false;
	}
	
	/**
	 * Creates layout and actions of the RegisterUserPage class
	 * @param utilizador
	 * @throws UnknownHostException
	 * @throws IOException
	 */
	public void register_swing(user utilizador,template template_obj) throws UnknownHostException, IOException {
		
		frame = new JFrame();
		frame.setSize(1080, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		emailfield = new JTextField();
		emailfield = new JTextField("E-mail");
		emailfield.setFont(new Font("OCR A Extended", Font.PLAIN, 16));
		emailfield.setHorizontalAlignment(SwingConstants.CENTER);
		emailfield.setCaretColor(Color.LIGHT_GRAY);
		
		emailfield.addMouseListener(
		/**
		 * Creates action that deletes any text from emailfield
		 *
		 */
		new MouseAdapter(){
	       public void mouseClicked(MouseEvent e){
	    	   emailfield.setText("");
           }
       });
		
		emailfield.setBorder(null);
		emailfield.setBackground(Color.LIGHT_GRAY);
		emailfield.setBounds(330, 327, 445, 38);
		frame.getContentPane().add(emailfield);
		emailfield.setColumns(10);
		
		JRadioButton agreewithtermsbutton = new JRadioButton("");
		agreewithtermsbutton.setBackground(Color.decode("#2e3131"));
		agreewithtermsbutton.setBounds(317, 443, 21, 20);
		frame.getContentPane().add(agreewithtermsbutton);
		
		passwordField = new JPasswordField("Password");
		passwordField.setBorder(null);
		passwordField.setBackground(Color.LIGHT_GRAY);
		passwordField.setBounds(330, 387, 201, 38);
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		
		passwordField.addMouseListener(
		/**
		 * Creates action that deletes any text from passwordField
		 *
		 */
		new MouseAdapter(){
	       public void mouseClicked(MouseEvent e){
	    	   passwordField.setText("");
           }
       });
		frame.getContentPane().add(passwordField);
		
		passwordField_confirm = new JPasswordField("Password");
		passwordField_confirm.setBorder(null);
		passwordField_confirm.setBackground(Color.LIGHT_GRAY);
		passwordField_confirm.setBounds(573, 387, 202, 38);
		passwordField_confirm.setHorizontalAlignment(SwingConstants.CENTER);
		
		passwordField_confirm.addMouseListener(
		/**
		 * Creates action that deletes any text from passwordField_confirm
		 *
		 */
		new MouseAdapter(){
	       public void mouseClicked(MouseEvent e){
	    	   passwordField_confirm.setText("");
           }
       });
		frame.getContentPane().add(passwordField_confirm);
		
		//botao do registo
		JButton register = new JButton("");
		register.setBounds(560, 479, 232, 43);
		ImageIcon REG1 = new ImageIcon("Swing/FILL_MU_EASYCV_Register_0006_UI.png");
		Image imgREG = REG1.getImage();
		Image resizeImgREG = imgREG.getScaledInstance(register.getWidth(), register.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon imageREG = new ImageIcon(resizeImgREG);
		register.setIcon(imageREG);
		register.setOpaque(false);
		register.setContentAreaFilled(false);
		register.setBorderPainted(false);
		
		register.addMouseListener(
		/**
		 * Changes mouse arrow
		 *
		 */
		new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				register.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				register.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
		
		register.addActionListener(
		/**
		 * Creates action to confirm input data 
		 *
		 */
		new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				
				username= emailfield.getText();
				if(passwordField.getText().equals(passwordField_confirm.getText())) {
					  password=passwordField.getText();
					  boolean isTermsSelected = agreewithtermsbutton.isSelected();
						if (isTermsSelected) {
							  try {
									user.register_user(utilizador,username,password,template_obj);
						
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								  frame.dispose();
						}
						else {
							Component frame_erro = null;
							JOptionPane.showMessageDialog(frame_erro,"Accept Terms of Condition, in order to get registed!");
						}
				}
				
				 else {
					  Component frame_erro_password = null;
					  JOptionPane.showMessageDialog(frame_erro_password,"Please check out password confirmation. This 2 passwords doesn't match!");
				  }
				
			}	
});
		
		frame.getContentPane().add(register);
		
		
		JButton btnTermsAndCondictions = new JButton("");
		
		btnTermsAndCondictions.addActionListener(
		/**
		 * Creates action to redirect user to terms and conditions webpage 
		 *
		 */
		new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
				    Desktop.getDesktop().browse(new URL("https://drive.google.com/open?id=1TNJaVRdEfkvVKQMfVssMktRgxEbSEWfd").toURI());
				} catch (Exception e) {}

			}
		});
		btnTermsAndCondictions.addMouseListener(
		/**
		 * Chnages mouse arrow
		 *
		 */
		new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnTermsAndCondictions.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnTermsAndCondictions.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
		
		
		btnTermsAndCondictions.setBounds(347, 448, 329, 13);
		ImageIcon TAC1 = new ImageIcon("Swing/FILL_MU_EASYCV_Register_0002_I-agree-with-terms-and-conditions.png");
		Image imgTAC = TAC1.getImage();
		Image resizeImgTAC = imgTAC.getScaledInstance(btnTermsAndCondictions.getWidth(), btnTermsAndCondictions.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon imageTAC = new ImageIcon(resizeImgTAC);
		//login.setIcon(new ImageIcon("/Users/nunonogueira/Desktop/EasyCV-2/Swing/FILL_MU_EASYCV_Login_0003_Login.png"));
		btnTermsAndCondictions.setIcon(imageTAC);
		btnTermsAndCondictions.setOpaque(false);
		btnTermsAndCondictions.setContentAreaFilled(false);
		btnTermsAndCondictions.setBorderPainted(false);
		frame.getContentPane().add(btnTermsAndCondictions);
		
		
		JLabel MAIL = new JLabel("");
		MAIL.setBounds(313, 324, 479, 42);
		ImageIcon MAIL1 = new ImageIcon("Swing/FILL_MU_EASYCV_LOGIN2_0004_Rounded-Rectangle-1.png");
		Image imgMAIL = MAIL1.getImage();
		Image resizeImgMAIL = imgMAIL.getScaledInstance(MAIL.getWidth(), MAIL.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon imageMAIL = new ImageIcon(resizeImgMAIL);
		MAIL.setIcon(imageMAIL);
		frame.getContentPane().add(MAIL);
		
		
		JLabel PASS = new JLabel("");
		PASS.setBounds(313, 384, 232, 42);
		ImageIcon PASS1 = new ImageIcon("Swing/FILL_MU_EASYCV_LOGIN2_0003_e87e04.png");
		Image imgPASS = PASS1.getImage();
		Image resizeImgPASS = imgPASS.getScaledInstance(PASS.getWidth(), PASS.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon imagePASS = new ImageIcon(resizeImgPASS);
		PASS.setIcon(imagePASS);
		frame.getContentPane().add(PASS);
		
		
		JLabel PASS2 = new JLabel("");
		PASS2.setBounds(560, 384, 232, 42);
		ImageIcon PASS3 = new ImageIcon("Swing/FILL_MU_EASYCV_LOGIN2_0003_e87e04.png");
		Image imgPASS2 = PASS3.getImage();
		Image resizeImgPASS2 = imgPASS2.getScaledInstance(PASS2.getWidth(), PASS2.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon imagePASS2 = new ImageIcon(resizeImgPASS2);
		PASS2.setIcon(imagePASS2);
		frame.getContentPane().add(PASS2);
		
		
		JLabel EASYCV = new JLabel("");
		EASYCV.setBounds(253, 107, 587, 168);
		ImageIcon ECV = new ImageIcon("Swing/FILL_MU_EASYCV_Login_0000_EasyCV.png");
		Image imgECV = ECV.getImage();
		Image resizeImgECV = imgECV.getScaledInstance(EASYCV.getWidth(), EASYCV.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon imageECV = new ImageIcon(resizeImgECV);
		EASYCV.setIcon(imageECV);
		frame.getContentPane().add(EASYCV);
		
		
		JLabel registerpage = new JLabel("");
		registerpage.setBounds(0, -20, 1080, 740);
		ImageIcon RPage = new ImageIcon("Swing/FILL_MU_EASYCV_PI_0015_#2e3131.png");
		Image imgRPage = RPage.getImage();
		Image resizeImgRP = imgRPage.getScaledInstance(registerpage.getWidth(), registerpage.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon imageRP = new ImageIcon(resizeImgRP);
		registerpage.setIcon(imageRP);
		//registerpage.setBounds(0, 0, 1080, 720);
		registerpage.setPreferredSize(new Dimension(1080, 720));
		frame.getContentPane().add(registerpage);
		
	}
}
