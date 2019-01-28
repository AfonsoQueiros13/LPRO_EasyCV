package graphical_interface;

import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import logic.form;
import logic.template;
import logic.user;

import javax.mail.MessagingException;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
@SuppressWarnings("all")
/**
 * Date: Jan 03-2019
 * This is a class that creates the "CVReadyPage" layout and actions
 * @author nunonogueira, joaoneves, josemiguel, afonsoqueiros
 * @version 1.0
 */
public class CVReadyPage {

	public JFrame frame;

	/**
	 * Constructor of the CVReadyPage class
	 * @param cv
	 */
	public CVReadyPage(File cv,user utilizador,form formulario, template template_obj) {
		cvready_swing(cv,utilizador,formulario,template_obj);
	}

	/**
	 * Creates the layout and events of CVReadyPage
	 * @param cv
	 */
	private void cvready_swing(File cv,user utilizador,form formulario,template template_obj) {
		
		frame = new JFrame();
		frame.setSize(1080,720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton preview = new JButton("");
		
		preview.addActionListener(
		/**
		 * Creates action to preview JButton
		 *
		 */
		new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Desktop.getDesktop().open(cv);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		preview.setBounds(586, 151, 250, 41);
		ImageIcon PR = new ImageIcon("Swing/FILL_MU_EASYCV_Ready_0001_Preview.png");
		Image imgPR = PR.getImage();
		Image resizeImgPR = imgPR.getScaledInstance(preview.getWidth(), preview.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon imagePR = new ImageIcon(resizeImgPR);
		preview.setIcon(imagePR);
		preview.setOpaque(false);
		preview.setContentAreaFilled(false);
		preview.setBorderPainted(false);
		frame.getContentPane().add(preview);
		
		preview.addMouseListener(
		/**
		 * Changes mouse arrow
		 *
		 */
		new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				preview.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				preview.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
		
		
		JButton share = new JButton("");
		share.addActionListener(
		/**
		 * Creates action to share JButton
		 *
		 */
		new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(utilizador.offline==1){
					try {
						utilizador.setSocket();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				InsereDataWindow insere_email;
				try {
					insere_email = new InsereDataWindow(50,utilizador, formulario,template_obj,cv,"Put your destiny e-mail here.",formulario.email);
					insere_email.frame.setVisible(true);
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} // 5 e para inserir email
		}
		});
		
		share.setBounds(586, 270, 250, 41);
		ImageIcon SV = new ImageIcon("Swing/FILL_MU_EASYCV_Ready_0002_Save.png");
		Image imgSV = SV.getImage();
		Image resizeImgSV = imgSV.getScaledInstance(share.getWidth(), share.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon imageSV = new ImageIcon(resizeImgSV);
		share.setIcon(imageSV);
		share.setOpaque(false);
		share.setContentAreaFilled(false);
		share.setBorderPainted(false);
		frame.getContentPane().add(share);
		
		share.addMouseListener(
		/**
		 * Changes mouse arrow
		 *
		 */
		new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				share.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				share.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
		
		
		
		JButton save = new JButton("");
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			      
			   
			}
		});
		save.setBounds(586, 209, 250, 41);
		ImageIcon Sh = new ImageIcon("Swing/FILL_MU_EASYCV_Ready_0003_Share.png");
		Image imgSH = Sh.getImage();
		Image resizeImgSH = imgSH.getScaledInstance(save.getWidth(), save.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon imageSH = new ImageIcon(resizeImgSH);
		save.setIcon(imageSH);
		save.setOpaque(false);
		save.setContentAreaFilled(false);
		save.setBorderPainted(false);
		frame.getContentPane().add(save);
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainPage main;
				try {
					main = new MainPage(utilizador,template_obj);
					Component info = null;
					JOptionPane.showMessageDialog(info,"Your CV´s information is saved. Next time when you are creating your CV, information wil show up");
					main.frame.setVisible(true);
					frame.dispose();
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		save.addMouseListener(
		/**
		 * Changes mouse arrow
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
		
		
		JButton gotomainpage = new JButton("");
		gotomainpage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainPage main;
				try {
					main = new MainPage(utilizador,template_obj);
					main.frame.setVisible(true);
					template.deletelogs(utilizador,formulario,template_obj,1);
					frame.dispose();
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		gotomainpage.setBounds(586, 331, 250, 102);
		ImageIcon MP = new ImageIcon("Swing/FILL_MU_EASYCV_Ready_0004_Main-page.png");
		Image imgMP = MP.getImage();
		Image resizeImgMP = imgMP.getScaledInstance(gotomainpage.getWidth(), gotomainpage.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon imageMP = new ImageIcon(resizeImgMP);
		gotomainpage.setIcon(imageMP);
		gotomainpage.setOpaque(false);
		gotomainpage.setContentAreaFilled(false);
		gotomainpage.setBorderPainted(false);
		frame.getContentPane().add(gotomainpage);
		
		gotomainpage.addMouseListener(
		/**
		 * Changes mouse arrow
		 *
		 */
		new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				gotomainpage.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				gotomainpage.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
		
		
		JButton return_button = new JButton("");
		return_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					QuestionsPage1_PI questions1= new QuestionsPage1_PI(utilizador, formulario,template_obj);
					frame.dispose();
					questions1.frame.setVisible(true);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
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
		
		return_button.addMouseListener(	
		/**
		 * changes mouse array
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
		
		
		JButton download = new JButton("");
		download.addActionListener(
		/**
		 * Creates action to download JButton
		 *
		 */
		new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				template.saveCV(cv);
			}
		});
		download.setBounds(586, 570, 250, 41);
		ImageIcon DW = new ImageIcon("Swing/FILL_MU_EASYCV_Ready_0006_Donwload.png");
		Image imgDW = DW.getImage();
		Image resizeImgDW = imgDW.getScaledInstance(download.getWidth(), download.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon imageDW = new ImageIcon(resizeImgDW);
		download.setIcon(imageDW);
		download.setOpaque(false);
		download.setContentAreaFilled(false);
		download.setBorderPainted(false);
		frame.getContentPane().add(download);
		
		download.addMouseListener(
		/**
		 * @author nunonogueira
		 * Changes mouse arrow
		 */
		new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				download.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				download.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});

		
		JLabel CVready = new JLabel("");
		CVready.setBounds(229, 151, 278, 460);
		CVready.setBorder(BorderFactory.createLineBorder(Color.white,3)); ;
		frame.getContentPane().add(CVready);
		
		
		JLabel Ready = new JLabel("");
		Ready.setBounds(248, 48, 573, 64);
		ImageIcon RD = new ImageIcon("Swing/FILL_MU_EASYCV_Ready_0005_UIII.png");
		Image imgRD = RD.getImage();
		Image resizeImgRD = imgRD.getScaledInstance(Ready.getWidth(), Ready.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon imageRD = new ImageIcon(resizeImgRD);
		Ready.setIcon(imageRD);
		frame.getContentPane().add(Ready);
		
		
		JLabel settingslabel = new JLabel("");
		settingslabel.setBounds(0, -20, 1080, 718);
		ImageIcon RPage = new ImageIcon("Swing/FILL_MU_EASYCV_PI_0015_#2e3131.png");
		Image imgRPage = RPage.getImage();
		Image resizeImgRP = imgRPage.getScaledInstance(settingslabel.getWidth(), settingslabel.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon imageRP = new ImageIcon(resizeImgRP);
		settingslabel.setIcon(imageRP);
		settingslabel.setPreferredSize(new Dimension(1080, 720));
		frame.getContentPane().add(settingslabel);
	}

}
