package graphical_interface;
import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import logic.template;
import logic.user;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.awt.Font;
@SuppressWarnings("all")
/**
 * Date: Jan 03-2019
 * This is a class that creates the "ProfilePage" layout and actions
 * @author nunonogueira, joaoneves, josemiguel, afonsoqueiros
 * @version 1.0
 */

public class ProfilePage {
	
	/**
	 * Initialize values
	 */
	static String nome_utilizador;
	public JFrame frame;

	/**
	 * Constructor of the ProfilePage class
	 * Create the application.
	 * @param utilizador 
	 * @throws IOException 
	 */
	public ProfilePage(user utilizador, template template_obj) throws IOException {
	    profile_swing(utilizador, template_obj);
		
	}

	/**
	 * Initialize the contents of the frame.
	 * @param utilizador
	 * @throws IOException 
	 */
	public void profile_swing(user utilizador, template template_obj) throws IOException {
		frame = new JFrame();
		frame.setSize(1080,720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		user.profile_show=1;
		//verificação de log para a checkbox
		File log= new File("logs/log_user_"+user.username+".txt");
		if(log.exists())
			user.filldrivercheckboxes(utilizador);
		
		
		user.textfullname = new JTextField("");
		user.textfullname.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		user.textfullname.setBackground(new Color(232, 126, 4));
		user.textfullname.setForeground(new Color(0, 0, 0));
		user.textfullname.setBounds(663, 205, 277, 30);
		user.textfullname.setBorder(null);
		frame.getContentPane().add(user.textfullname);
		user.textfullname.setColumns(10);
		
		user.textbirthdate = new JTextField("");
		user.textbirthdate.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		user.textbirthdate.setForeground(Color.BLACK);
		user.textbirthdate.setBorder(null);
		user.textbirthdate.setBackground(new Color(232, 126, 4));;
		user.textbirthdate.setColumns(10);
		user.textbirthdate.setBounds(677, 291, 277, 30);
		frame.getContentPane().add(user.textbirthdate);
		
		user.textaddress = new JTextField("");
		user.textaddress.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		user.textaddress.setForeground(Color.BLACK);
		user.textaddress.setColumns(10);
		user.textaddress.setBorder(null);
		user.textaddress.setBackground(new Color(232, 126, 4));;
		user.textaddress.setBounds(634, 375, 320, 30);
		frame.getContentPane().add(user.textaddress);
		
		JCheckBox A_licence = new JCheckBox("A");
		if(utilizador.driver_a.equals("1"))
		A_licence.setSelected(true);
		A_licence.setBackground(Color.decode("#E87E04"));
		A_licence.setOpaque(true);
		A_licence.setBounds(776, 465, 33, 23);
		frame.getContentPane().add(A_licence);
		
		JCheckBox A1_licence = new JCheckBox("A1");
		if(utilizador.driver_a1.equals("1"))
			A1_licence.setSelected(true);
		A1_licence.setBounds(811, 465, 43, 23);
		A1_licence.setBackground(Color.decode("#E87E04"));
		A1_licence.setOpaque(true);
		frame.getContentPane().add(A1_licence);
		
		JCheckBox A2_licence = new JCheckBox("A2");
		if(utilizador.driver_a2.equals("1"))
			A2_licence.setSelected(true);
		A2_licence.setBounds(856, 465, 43, 23);
		A2_licence.setBackground(Color.decode("#E87E04"));
		A2_licence.setOpaque(true);
		frame.getContentPane().add(A2_licence);
		
		JCheckBox B_licence = new JCheckBox("B");
		if(utilizador.driver_b.equals("1"))
			B_licence.setSelected(true);
		B_licence.setBounds(901, 465, 33, 23);
		B_licence.setBackground(Color.decode("#E87E04"));
		B_licence.setOpaque(true);
		frame.getContentPane().add(B_licence);
		
		JCheckBox B1_licence = new JCheckBox("B1");
		if(utilizador.driver_b1.equals("1"))
			B1_licence.setSelected(true);
		B1_licence.setBounds(940, 465, 43, 23);
		B1_licence.setBackground(Color.decode("#E87E04"));
		B1_licence.setOpaque(true);

		frame.getContentPane().add(B1_licence);
		
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
		 * Creates action to show main.frame, setting it visible.
		 */
		new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					frame.dispose();
					MainPage mainpage = new MainPage(utilizador,template_obj);
					mainpage.frame.setVisible(true);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
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
		 

		user.label_photo = new JLabel("");
		user.label_photo.setBackground(Color.GRAY);
		user.label_photo.setBounds(155, 227, 230,230);
		frame.getContentPane().add(user.label_photo);
		frame.getContentPane().add(user.label_photo);
		
		
		JButton changephoto = new JButton("");
		changephoto.addMouseListener(
		/**
		 * Changes mouse arrow
		 */
		new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				changephoto.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				changephoto.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
		changephoto.setBounds(155, 484, 225, 62);
		ImageIcon CF = new ImageIcon("Swing/FILL_MU_EASYCV_PROFILE_0001_ChangePhoto.png");
		Image imgCF = CF.getImage();
		Image resizeImgCF = imgCF.getScaledInstance(changephoto.getWidth(), changephoto.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon imageCF = new ImageIcon(resizeImgCF);
		changephoto.setIcon(imageCF);
		changephoto.setOpaque(false);
		changephoto.setContentAreaFilled(false);
		changephoto.setBorderPainted(false);
		frame.getContentPane().add(changephoto);
		
		changephoto.addActionListener(
		/**
		 * Creates action to change photo
		 */
		new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					
			    final JFileChooser fc  = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF Images", "jpg", "gif");
				fc.setFileFilter(filter);
				int returnVal = fc.showOpenDialog(null);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					user.selectedFile= fc.getSelectedFile();
					try {
						user.save_image(user.selectedFile);
						user.fill_label_image();

					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}			
			}                                                                                       
		});
		
		
		
		
		JButton submeter = new JButton("");
		submeter.setBounds(794, 596, 218, 41);
		//RESIZE RESOLUTION
		ImageIcon RB1 = new ImageIcon("Swing/FILL_MU_EASYCV_PROFILE_0008_Group-1.png");
		Image imgRB = RB1.getImage();
		Image resizeImgRB = imgRB.getScaledInstance(submeter.getWidth(), submeter.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon imageRB = new ImageIcon(resizeImgRB);
		submeter.setIcon(imageRB);
		submeter.setOpaque(false);
		submeter.setContentAreaFilled(false);
		submeter.setBorderPainted(false);
		frame.getContentPane().add(submeter);
		
		submeter.addMouseListener(
		/**
		 * Change mouse arrow
		 */
		new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				submeter.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				submeter.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
		
		submeter.addActionListener(
		/**
		 * Creates action to submit data 
		 *
		 */
		new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
			    utilizador.licencas= ""; //limpar dados das licencas a cada submissao
			    utilizador.licencas1= "";//limpar dados das licencas a cada subsmissao
				user.fullname= user.textfullname.getText();
				user.birthdate=user.textbirthdate.getText();
				user.address= user.textaddress.getText();
				try {
					user.submit_data(utilizador);
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				} 
				if (A_licence.isSelected()) {
					 utilizador.driver_a="1";
					 utilizador.licenca_A= "A";
					 try {
						user.senddata_licence(utilizador,utilizador.licenca_A);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					}
				if (A1_licence.isSelected()) {
					
						 utilizador.driver_a1="1";
						 System.out.println("aaa  " +utilizador.driver_a1);
						 utilizador.licenca_A1= "A1";
						 try {
							user.senddata_licence(utilizador,utilizador.licenca_A1);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}					 
						}
				if (A2_licence.isSelected()) {
						 utilizador.driver_a2="1";
						 utilizador.licenca_A2= "A2";
						 try {
							user.senddata_licence(utilizador,utilizador.licenca_A2);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}					 
						}
				if (B_licence.isSelected()) {
						utilizador.driver_b="1";
						 utilizador.licenca_B= "B";
						 try {
							user.senddata_licence(utilizador,utilizador.licenca_B);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}					
						}
				if (B1_licence.isSelected()) {
						 utilizador.driver_b1="1";
						 utilizador.licenca_B1= "B1";
						 try {
							user.senddata_licence(utilizador,utilizador.licenca_B1);	
						     }
						 catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}	
				}
				try {
					user.senddata_licence(utilizador,"f"); //acaba aqui a transmissao das cartas de conducao
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				try {
					frame.dispose();
					MainPage main= new MainPage(utilizador,template_obj);
					user.createlog_driver(utilizador);
					main.frame.setVisible(true);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}	
	});
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("Swing/FILL_MU_EASYCV_PI_0015_#2e3131.png"));
		lblNewLabel.setBounds(74, 141, 400, 343);
		frame.getContentPane().add(lblNewLabel);
		
		
		JLabel GUI = new JLabel("");
		GUI.setBounds(145, 48, 867, 458);
		ImageIcon GUI1 = new ImageIcon("Swing/FILL_MU_EASYCV_PROFILE_0002_UI.png");
		Image imgGUI = GUI1.getImage();
		Image resizeImgGUI = imgGUI.getScaledInstance(GUI.getWidth(), GUI.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon imageGUI = new ImageIcon(resizeImgGUI);
		GUI.setIcon(imageGUI);
		frame.getContentPane().add(GUI);
		
		
		JLabel profilepage = new JLabel("");
		profilepage.setBounds(0, -20, 1080, 740);
		ImageIcon RPage = new ImageIcon("Swing/FILL_MU_EASYCV_PI_0015_#2e3131.png");
		Image imgRPage = RPage.getImage();
		Image resizeImgRP = imgRPage.getScaledInstance(profilepage.getWidth(), profilepage.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon imageRP = new ImageIcon(resizeImgRP);
		profilepage.setIcon(imageRP);
		//registerpage.setBounds(0, 0, 1080, 720);
		profilepage.setPreferredSize(new Dimension(1080, 720));
		frame.getContentPane().add(profilepage);
		File image= new File("img_users/"+user.username+".jpg"); //mostrar imagem
		if(image.exists())
		user.fill_label_image();
	
		
		
		
		
	}
}
