
package graphical_interface;
import javax.swing.JFrame;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import logic.form;
import logic.template;
import logic.user;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
@SuppressWarnings("all")
/**
 * Date: Jan 03-2019
 * This is a class that creates the "MainPage" layout and actions. 
 * @author nunonogueira, joaoneves, josemiguel, afonsoqueiros
 * @version 1.0
 */

public class MainPage extends JFrame {

	/**
	 * Initialize values
	 */
	private static final long serialVersionUID = 1L;
	 String nome_utilizador;
	public JFrame frame;

	/**
	 * Constructor of the MainPage class
	 * @param utilizador
	 * @throws IOException
	 */
	public MainPage(user utilizador,template template_obj) throws IOException {
		nome_utilizador=user.username;
		mainpage_swing(utilizador, template_obj);
	}
	
	/**
	 * Creates layout and actions of MainPage class
	 * @param utilizador
	 * @throws IOException 
	 */

	public void mainpage_swing(user utilizador, template template_obj) throws IOException {
		
		/**
		 * Initialize values
		 */
		frame = new JFrame();
		frame.setSize(1080,720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblHello = new JLabel("Hello, ");
		lblHello.setFont(new Font("Lucida Sans", Font.PLAIN, 15));
		lblHello.setForeground(Color.WHITE);
		lblHello.setBounds(45, 612, 46, 14);
		frame.getContentPane().add(lblHello);
		
		JLabel name_user = new JLabel("");
		name_user.setIcon(null);
		name_user.setForeground(Color.white);
		name_user.setBounds(90, 612, 174, 14);
		name_user.setText(nome_utilizador);
		frame.getContentPane().add(name_user);

		
		JButton createcv = new JButton("");
		createcv.setBounds(555, 326, 269, 100);
		ImageIcon CV  = new ImageIcon("Swing/FILL_MU_EASYCV_MAIN_0004_Create.png");
		Image imgCV = CV.getImage();
		Image resizeImgCV = imgCV.getScaledInstance(createcv.getWidth(), createcv.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon imageCV = new ImageIcon(resizeImgCV);
		createcv.setIcon(imageCV);
		createcv.setOpaque(false);
		createcv.setContentAreaFilled(false);
		createcv.setBorderPainted(false);
		frame.getContentPane().add(createcv);
		
		createcv.addActionListener(
		/**
		 * Creates action to show temppage.frame, setting it visible.
		 */
		new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				File photo= new File("img_users/"+user.username+".jpg");
				if (!photo.exists()){
					Component info = null;
					JOptionPane.showMessageDialog(info,"Before you create CV, you have to pic a photo to fill in your document!");
					  final JFileChooser fc  = new JFileChooser();
						FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF Images", "jpg", "gif");
						fc.setFileFilter(filter);
						int returnVal = fc.showOpenDialog(null);
						if (returnVal == JFileChooser.APPROVE_OPTION) {
							user.selectedFile= fc.getSelectedFile();
							try {
								user.save_image(user.selectedFile);
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}		
				}
				frame.dispose();
				form formulario= new form();
				template template_obj= new template();
				ChooseTemplatePage temppage;
				temppage= new ChooseTemplatePage(utilizador,formulario,template_obj);
				temppage.frame.setVisible(true);
				File log= new File("logs/log_template_"+user.username+".txt");
				if (!log.exists()) {
					try {
						System.out.println("n eciste");
						form.createlog(utilizador, formulario,1);
				}catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
				}	
			}	
		});
		createcv.addMouseListener(
		/**
		 * Changes mouse arrow
		 *
		 */
		new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				createcv.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				createcv.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
		
		
		JButton checkprofile = new JButton("");
		checkprofile.setBounds(270, 326, 269, 100);
		ImageIcon CP  = new ImageIcon("Swing/FILL_MU_EASYCV_MAIN_0005_Check.png");
		Image imgCP = CP.getImage();
		Image resizeImgCP = imgCP.getScaledInstance(checkprofile.getWidth(), checkprofile.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon imageCP = new ImageIcon(resizeImgCP);
		checkprofile.setIcon(imageCP);
		checkprofile.setOpaque(false);
		checkprofile.setContentAreaFilled(false);
		checkprofile.setBorderPainted(false);
		frame.getContentPane().add(checkprofile);
		
		checkprofile.addActionListener(
		/**
		 * Creates action to show profile.frame, setting it visible.
		 *
		 */
		new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(user.username.equals("temporary_user")) {
					Component info = null;
					JOptionPane.showMessageDialog(info,"As a temporary user, you can´t acess this page.");
					
				}
				else
				{
				frame.dispose();
				ProfilePage profile;
				try {
					profile = new ProfilePage(utilizador,template_obj);
					profile.frame.setVisible(true);
					user.request_photo(utilizador);
					user.fillprofiledata();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				 
			}
			}
		});
		checkprofile.addMouseListener(
		/**
		 * Changes mouse arrow
		 *
		 */
		new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				checkprofile.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				checkprofile.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
		
		
		
		JButton previouswork = new JButton("");
		previouswork.setBounds(270, 438, 269, 100);
		ImageIcon PW  = new ImageIcon("Swing/FILL_MU_EASYCV_MAIN_0002_Work.png");
		Image imgPW = PW.getImage();
		Image resizeImgPW = imgPW.getScaledInstance(previouswork.getWidth(), previouswork.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon imagePW = new ImageIcon(resizeImgPW);
		previouswork.setIcon(imagePW);
		previouswork.setOpaque(false);
		previouswork.setContentAreaFilled(false);
		previouswork.setBorderPainted(false);
		frame.getContentPane().add(previouswork);
		
		
		previouswork.addActionListener(
		/**
		 * Creates action to show prev_work.frame, setting it visible.
		 *
		 */
		new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				SavedWorkPage prev_work= new SavedWorkPage(utilizador,nome_utilizador,template_obj);
				prev_work.frame.setVisible(true);

			}
		});
		previouswork.addMouseListener(
		/**
		 * Changes mouse arrow
		 *
		 */
		new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				previouswork.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) { 
				previouswork.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
	
		JButton settings = new JButton("");
		settings.setBounds(555, 438, 269, 100);
		ImageIcon st  = new ImageIcon("Swing/FILL_MU_EASYCV_MAIN_0003_Steeings.png");
		Image imgST = st.getImage();
		Image resizeImgST = imgST.getScaledInstance(settings.getWidth(), settings.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon imageST = new ImageIcon(resizeImgST);
		settings.setIcon(imageST);
		settings.setOpaque(false);
		settings.setContentAreaFilled(false);
		settings.setBorderPainted(false);
		frame.getContentPane().add(settings);
		
		settings.addActionListener(
		/**
		 * Creates action to show setting.frame, setting it visible.
		 *
		 */
		new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(user.username.equals("temporary_user")) {
					Component info = null;
					JOptionPane.showMessageDialog(info,"As a temporary user, you can´t acess this page.");
					
				}
				else {
				frame.dispose();
				SettingsPage settings= new SettingsPage(utilizador,nome_utilizador,template_obj);
				settings.frame.setVisible(true);
				}
			}
		});
		
		settings.addMouseListener(
		/**
		 * Changes mouse arrow
		 *
		 */
		new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				settings.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				settings.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
		
	
		JButton btnLogout = new JButton("");
		btnLogout.setBounds(508, 612, 75, 16);
		ImageIcon LO  = new ImageIcon("Swing/FILL_MU_EASYCV_MAIN_0001_Log-out.png");
		Image imgLO = LO.getImage();
		Image resizeImgLO = imgLO.getScaledInstance(btnLogout.getWidth(), btnLogout.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon imageLO = new ImageIcon(resizeImgLO);
		btnLogout.setIcon(imageLO);
		btnLogout.setOpaque(false);
		btnLogout.setContentAreaFilled(false);
		btnLogout.setBorderPainted(false);
		frame.getContentPane().add(btnLogout);
		
		btnLogout.addMouseListener(
		/**
		 * Changes mouse arrow
		 */
		new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnLogout.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnLogout.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
		
		btnLogout.addActionListener(
		/**
		 * Creates action to show login.frame, setting it visible.
		 *
		 */
		new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if(user.offline==0)
					utilizador.socket.close();
					frame.dispose();
					LoginPage login= new LoginPage(utilizador, template_obj);
					login.frame.setVisible(true);				
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} 
		});
	
		
		//BOTAO DO LIST ALL USERS S� APARECE PARA O ADMIN
		
		if (nome_utilizador.equals("admin")) {
		JButton btnNewButton = new JButton("List All Users");
		
		btnNewButton.addActionListener(
		/**
		 * Creates action to show listusers.frame, setting it visible only to admin.
		 *
		 */
		new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					frame.setVisible(false);
					frame.dispose();
					ListAllUsersPage listusers;
					try {
						listusers = new ListAllUsersPage(utilizador,template_obj);
						listusers.frame.setVisible(true);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
			}
		});
		btnNewButton.setIcon(new ImageIcon("Swing/listall.png"));
		btnNewButton.setOpaque(false);
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBounds(20, 24, 230, 42);
		frame.getContentPane().add(btnNewButton);
		}
		
		
		JLabel EASYCV = new JLabel("");
		EASYCV.setBounds(253, 107, 587, 168);
		ImageIcon ECV = new ImageIcon("Swing/FILL_MU_EASYCV_Login_0000_EasyCV.png");
		Image imgECV = ECV.getImage();
		Image resizeImgECV = imgECV.getScaledInstance(EASYCV.getWidth(), EASYCV.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon imageECV = new ImageIcon(resizeImgECV);
		EASYCV.setIcon(imageECV);
		frame.getContentPane().add(EASYCV);
		
		
		JLabel MainPage = new JLabel("");
		MainPage.setBounds(0, -20, 1080, 720);
		ImageIcon BK = new ImageIcon("Swing/FILL_MU_EASYCV_PI_0015_#2e3131.png");
		Image imgBK = BK.getImage();
		Image resizeImgbk = imgBK.getScaledInstance(MainPage.getWidth(), MainPage.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon imagebk = new ImageIcon(resizeImgbk);
		MainPage.setIcon(imagebk);
		MainPage.setPreferredSize(new Dimension(1080, 720));
		frame.getContentPane().add(MainPage);
	
	
	}

}
