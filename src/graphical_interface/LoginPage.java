package graphical_interface;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.UnknownHostException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import logic.template;
import logic.user;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Image;
import java.awt.Dimension;
@SuppressWarnings("all")
/**
 * Date: Jan 03-2019
 * This is a class that creates the "LoginPage" layout and actions
 * @author nunonogueira, joaoneves, josemiguel, afonsoqueiros
 * @version 1.0
 */
public class LoginPage extends JFrame {
	
	/**
	 * Initialize values
	 */
	private static final long serialVersionUID = 1L;
	public JFrame frame;
	public JTextField txtEmail;
	public JPasswordField passwordField;
	
	/**
	 * Shows layout setting it visible 
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage window = new LoginPage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Constructor of the LoginPage class
	 * @param utilizador
	 * @throws IOException
	 */
	public LoginPage(user utilizador,template template_obj)  throws IOException{
		login_swing(utilizador,template_obj);
	}
	
	/** 
	 * Constructor of the LoginPage class
	 * @throws IOException
	 */
	public LoginPage()  throws IOException{	
			initialize_socket();
	}

	/**
	 * Runs login_swing
	 * @throws UnknownHostException
	 * @throws IOException
	 */
	 public void initialize_socket() throws UnknownHostException, IOException {
		 user utilizador= new user();
		 login_swing(utilizador,null);
	 
	 }
	 
	 /**
	  * Creates layout and actions of LoginPage class
	  * @param utilizador
	  * @throws UnknownHostException
	  * @throws IOException
	  */
	public void login_swing(user utilizador,template template_obj) throws UnknownHostException, IOException {		
		// FRAME PRINCIPAL
		
		/**
		 * Initialize values
		 */
		user.login=0;
		frame = new JFrame();
		frame.setSize(1080, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		txtEmail = new JTextField("E-mail");
		txtEmail.setFont(new Font("OCR A Extended", Font.PLAIN, 18));
		txtEmail.setHorizontalAlignment(SwingConstants.CENTER);
		txtEmail.setCaretColor(Color.LIGHT_GRAY);
		txtEmail.addMouseListener(new MouseAdapter(){
	       public void mouseClicked(MouseEvent e){
              txtEmail.setText("");
           }
       });
		txtEmail.setBorder(null);
		txtEmail.setBackground(Color.LIGHT_GRAY);
		txtEmail.setBounds(324, 331, 449, 26);
		frame.getContentPane().add(txtEmail);
		txtEmail.setColumns(10);
	
		
		passwordField = new JPasswordField("Password");
		passwordField.setFont(new Font("OCR A Extended", Font.PLAIN, 16));
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField.setCaretColor(Color.LIGHT_GRAY);
		passwordField.addMouseListener(new MouseAdapter(){
	       public void mouseClicked(MouseEvent e){
	    	   passwordField.setText("");
           }
       });
		passwordField.setBorder(null);
		passwordField.setBackground(Color.LIGHT_GRAY);
		passwordField.setBounds(324, 389, 212, 33);
		frame.getContentPane().add(passwordField);
		
		
		JButton register_button = new JButton("");
		register_button.setLocation(324, 448);
		register_button.setSize(449, 20);
		
		//RESIZE RESOLUTION
		ImageIcon RB1 = new ImageIcon("Swing/FILL_MU_EASYCV_Login_0004_dontown.png");
		Image imgRB = RB1.getImage();
		Image resizeImgRB = imgRB.getScaledInstance(register_button.getWidth(), register_button.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon imageRB = new ImageIcon(resizeImgRB);
		register_button.setIcon(imageRB);
		register_button.setOpaque(false);
		register_button.setContentAreaFilled(false);
		register_button.setBorderPainted(false);
				
		register_button.addActionListener(
		/**
		 * Creates action to show frame JFrame 
		 */
		new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose(); //p�gina desaparece
				RegisterUserPage register;
				try {
					utilizador.setSocket();
					register = new RegisterUserPage(utilizador,template_obj);
					register.frame.setVisible(true);
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
				
			}
		});
		    register_button.addMouseListener(
		    /**
		     * Changes mouse arrow
		     *
		     */
		    new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				register_button.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				register_button.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
		    
		frame.getContentPane().add(register_button);
		
		JButton login = new JButton("");
		login.addActionListener(
		/**
		 * Creates action get user data
		 *
		 */
		new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{		    
				//RECOLHA DOS DADOS DO UTILIZADOR
				String username = txtEmail.getText();
				String password= passwordField.getText();
		
		 try {
			utilizador.setSocket();
			user.login_user(utilizador,username, password,template_obj);	
			if(user.db_result.equals("1")) { // fecha a janela do login e abrir� a mainpage
				frame.dispose();
			}
			 }
						 
		 catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
						       }			
			}
});
		login.addMouseListener(
		/**
		 * Changes mouse arrow
		 *
		 */
		new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				login.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				login.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
		
		login.setBounds(560, 384, 232, 42);
		ImageIcon LOG1 = new ImageIcon("Swing/FILL_MU_EASYCV_Login_0003_Login.png");
		Image imgLOG = LOG1.getImage();
		Image resizeImgLOG = imgLOG.getScaledInstance(login.getWidth(), login.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon imageLOG = new ImageIcon(resizeImgLOG);
		login.setIcon(imageLOG);
		login.setOpaque(false);
		login.setContentAreaFilled(false);
		login.setBorderPainted(false);
		frame.getContentPane().add(login);
		
		
		JButton offline = new JButton("");
		offline.addMouseListener(
				    /**
				     * Changes mouse arrow
				     *
				     */
				    new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent arg0) {
						offline.setCursor(new Cursor(Cursor.HAND_CURSOR));
					}
					@Override
					public void mouseExited(MouseEvent e) {
						offline.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
					}
				});
		ImageIcon off1 = new ImageIcon("Swing/FILL_MU_EASYCV_MAIN_0001_OFFLINE-TEXT.png");
		offline.setBounds(429, 605, 232, 42);
		Image imgoff = off1.getImage();
		Image resizeImgoff = imgoff.getScaledInstance(offline.getWidth(), offline.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon imageoff1 = new ImageIcon(resizeImgoff);
		offline.setIcon(imageoff1);
		offline.setOpaque(false);
		offline.setContentAreaFilled(false);
		offline.setBorderPainted(false);
		offline.addActionListener(
				/**
				 * Creates action get user data
				 *
				 */
				new ActionListener() {
					public void actionPerformed(ActionEvent arg0) 
					{		
						Component info = null;
						JOptionPane.showMessageDialog(info,"Do you have an account on our system? Yes - type your username. No - Leave that field empty, to create a temporary user.");
						InsereDataWindow data;
						try {
							data = new InsereDataWindow(100, utilizador, null, template_obj,null,"Put your username here.",null);
							data.frame.setVisible(true);
							frame.dispose();
														
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						
					}
		});
	
		frame.getContentPane().add(offline);
		
		JLabel EASYCV = new JLabel("");
		EASYCV.setBounds(253, 107, 587, 168);
		ImageIcon ECV = new ImageIcon("Swing/FILL_MU_EASYCV_Login_0000_EasyCV.png");
		Image imgECV = ECV.getImage();
		Image resizeImgECV = imgECV.getScaledInstance(EASYCV.getWidth(), EASYCV.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon imageECV = new ImageIcon(resizeImgECV);
		EASYCV.setIcon(imageECV);
		frame.getContentPane().add(EASYCV);
		
		
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
		
		
		JLabel loginpage = new JLabel("");
		loginpage.setBounds(0, 0, 1080, 720);
		//loginpage.setIcon(new ImageIcon("Swing/Login_MU_EASYCV"));
		ImageIcon BK = new ImageIcon("Swing/FILL_MU_EASYCV_PI_0015_#2e3131.png");
		Image imgBK = BK.getImage();
		Image resizeImgbk = imgBK.getScaledInstance(loginpage.getWidth(), loginpage.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon imagebk = new ImageIcon(resizeImgbk);
		loginpage.setIcon(imagebk);
		loginpage.setPreferredSize(new Dimension(1080, 720));
		frame.getContentPane().add(loginpage);
		
		
	}
}
