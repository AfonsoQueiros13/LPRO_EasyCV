package graphical_interface;

import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import logic.template;
import logic.user;
import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
@SuppressWarnings("all")
/**
 * Date: Jan 03-2019
 * This is a class that creates the "SettingsPage" layout and actions
 * @author nunonogueira, joaoneves, josemiguel, afonsoqueiros
 * @version 1.0
 */

public class SettingsPage {
	
	/**
	 * Initialize values
	 */
	static String username;
	public JFrame frame;
	public JTextField emailfield;
	public JPasswordField passwordField;
    static String username_old;
    static String password_old;
    
    
	/**
	 * Constructor of the SettingsPage class
	 * @param utilizador
	 * @param username
	 */
	public SettingsPage(user utilizador,String username,template template_obj) {
		SettingsPage.username= username;
		settings_swing(utilizador,template_obj);
	}

	
	/**
	 * Creates layout and actions of the SettingsPage class
	 * @param utilizador
	 */
	public void settings_swing(user utilizador,template template_obj) {
		
		/**
		 * Initialize values
		 */
		frame = new JFrame();
		frame.setSize(1080, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		emailfield = new JTextField(user.username);
		emailfield.setFont(new Font("OCR A Extended", Font.PLAIN, 18));
		emailfield.setHorizontalAlignment(SwingConstants.CENTER);
		emailfield.setCaretColor(Color.decode("#2E3131"));
		emailfield.setBorder(null);
		emailfield.setBackground(Color.decode("#2E3131"));
		emailfield.setForeground(Color.WHITE);
		emailfield.setBounds(616, 102, 375, 30);
		emailfield.setColumns(10);
		 frame.getContentPane().add(emailfield);
		 
		 
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("OCR A Extended", Font.PLAIN, 18));
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField.setCaretColor(Color.decode("#2E3131"));
		passwordField.setBorder(null);
		passwordField.setBackground(Color.decode("#2E3131"));
		passwordField.setForeground(Color.WHITE);
		passwordField.setBounds(616, 172, 375, 30);
	    frame.getContentPane().add(passwordField);
		
		JCheckBox checkBox = new JCheckBox("");
		checkBox.setBackground(Color.GREEN);
		checkBox.setBounds(629, 249, 21, 23);
		frame.getContentPane().add(checkBox);
		
		JCheckBox checkBox_1 = new JCheckBox("");
		checkBox_1.setBackground(Color.GREEN);
		checkBox_1.setBounds(629, 318, 21, 23);
		frame.getContentPane().add(checkBox_1);
		
		JCheckBox checkBox_2 = new JCheckBox("");
		checkBox_2.setBackground(Color.GREEN);
		checkBox_2.setBounds(629, 386, 21, 23);
		frame.getContentPane().add(checkBox_2);
		
		JCheckBox checkBox_3 = new JCheckBox("");
		checkBox_3.setBackground(Color.GREEN);
		checkBox_3.setBounds(629, 456, 21, 23);
		frame.getContentPane().add(checkBox_3);
		
		JCheckBox checkBox_4 = new JCheckBox("");
		checkBox_4.setBackground(Color.GREEN);
		checkBox_4.setBounds(629, 526, 21, 23);
		frame.getContentPane().add(checkBox_4);
		
		JCheckBox checkBox_5 = new JCheckBox("");
		checkBox_5.setBackground(Color.GREEN);
		checkBox_5.setBounds(629, 595, 21, 23);
		frame.getContentPane().add(checkBox_5);
		
		JButton return_button = new JButton("");
		return_button.setBounds(25, 48, 141, 41);
		ImageIcon RE = new ImageIcon("Swing/FILL_MU_EASYCV_PROFILE_0000_Return.png");
		Image imgRE = RE.getImage();
		Image resizeImgRE = imgRE.getScaledInstance(return_button.getWidth(), return_button.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon imageRE = new ImageIcon(resizeImgRE);
		return_button.setIcon(imageRE);
		return_button.setOpaque(false);
		return_button.setContentAreaFilled(false);
		return_button.setBorderPainted(false);
		frame.getContentPane().add(return_button);
		
		
		return_button.addActionListener(
		/**
		 * Creates action to show mainpage.frame, setting it visible.
		 *
		 */
		new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					frame.dispose();
					MainPage mainpage = new MainPage(utilizador,template_obj);
					mainpage.frame.setVisible(true);
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		return_button.addMouseListener(
		/**
		 * Changes mouse arrow
		 *
		 */
		new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				return_button.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				return_button.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});

		
		JButton changeemail = new JButton("");
		changeemail.setBounds(210, 102, 170, 30);
		ImageIcon CE1 = new ImageIcon("Swing/FILL_MU_EASYCV_Settings_0004_Email.png");
		Image imgCE = CE1.getImage();
		Image resizeImgCE = imgCE.getScaledInstance(changeemail.getWidth(), changeemail.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon imageCE = new ImageIcon(resizeImgCE);
		changeemail.setIcon(imageCE);
		changeemail.setContentAreaFilled(false);
		changeemail.setBorderPainted(false);
		frame.getContentPane().add(changeemail);
		
		

		
		JButton changepass = new JButton("");
		changepass.setBounds(210, 172, 170, 30);
		ImageIcon CP1 = new ImageIcon("Swing/FILL_MU_EASYCV_Settings_0003_Pass.png");
		Image imgCP = CP1.getImage();
		Image resizeImgCP = imgCP.getScaledInstance(changepass.getWidth(), changepass.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon imageCP = new ImageIcon(resizeImgCP);
		changepass.setIcon(imageCP);
		changepass.setContentAreaFilled(false);
		changepass.setBorderPainted(false);
		frame.getContentPane().add(changepass);
		
	

		
		JButton save = new JButton("");
		save.setBounds(733, 602, 248, 51);
		//RESIZE RESOLUTION
		ImageIcon SV1 = new ImageIcon("Swing/FILL_MU_EASYCV_Settings_0000_Save.png");
		Image imgSV = SV1.getImage();
		Image resizeImgSV = imgSV.getScaledInstance(save.getWidth(), save.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon imageSV = new ImageIcon(resizeImgSV);
		save.setIcon(imageSV);
		save.setOpaque(false);
		save.setContentAreaFilled(false);
		save.setBorderPainted(false);
		frame.getContentPane().add(save);
		
		
		save.addActionListener(
		/**
		 * Creates action that verifies input data by clicking on save JButton
		 *
		 */
		new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				username_old=user.username;
				password_old= user.password;
				user.username= emailfield.getText();
				user.password= passwordField.getText();
				
				if(user.username.equals("") && !user.password.equals(""))
				{
					user.changecredentials(utilizador,2);
			        user.username= username_old;
				}
				
				if(!user.username.equals("") && user.password.equals(""))
				{
					user.changecredentials(utilizador,4);
					user.password=password_old;
					
				}
				
				if(!user.username.equals("") && !user.password.equals(""))
				{
					user.changecredentials(utilizador,5);
						
				}
				
			frame.dispose();
			try {
				MainPage mainpage= new MainPage(utilizador,template_obj);
				mainpage.frame.setVisible(true);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
			}
		});
		save.addMouseListener(
		/**
		 * Changes mouse arrow
		 *
		 */
		new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				save.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				save.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
		
		JLabel UI = new JLabel("");
		UI.setBounds(220, 225, 431, 441);
		ImageIcon UI1 = new ImageIcon("Swing/FILL_MU_EASYCV_Settings_0002_UI.png");
		Image imgUI = UI1.getImage();
		Image resizeImgUI = imgUI.getScaledInstance(UI.getWidth(), UI.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon imageUI = new ImageIcon(resizeImgUI);
		UI.setIcon(imageUI);
		//settingslabel.setPreferredSize(new Dimension(1080, 720));
		frame.getContentPane().add(UI);
		
		JLabel settingslabel = new JLabel("");
		settingslabel.setBounds(0, -20, 1080, 740);
		ImageIcon RPage = new ImageIcon("Swing/FILL_MU_EASYCV_PI_0015_#2e3131.png");
		Image imgRPage = RPage.getImage();
		Image resizeImgRP = imgRPage.getScaledInstance(settingslabel.getWidth(), settingslabel.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon imageRP = new ImageIcon(resizeImgRP);
		settingslabel.setIcon(imageRP);
		settingslabel.setPreferredSize(new Dimension(1080, 720));
		frame.getContentPane().add(settingslabel);
	}
}
