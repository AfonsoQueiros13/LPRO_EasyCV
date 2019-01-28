package graphical_interface;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import logic.form;
import logic.template;
import logic.user;
@SuppressWarnings("all")
/**
 * Date: Jan 03-2019
 * This is a class that creates the "QuestionsPage4_SL" layout and actions
 * @author nunonogueira, joaoneves, josemiguel, afonsoqueiros
 * @version 1.0
 */

public class QuestionsPage2_SL {
	
	/*
	 * Initializes JFrame
	 */
	JFrame frame;
	
	
	/**
	 * Constructor of the QuestionsPage4_SL class
	 * @param utilizador
	 * @throws IOException
	 */
	public QuestionsPage2_SL(user utilizador,form formulario,template template_obj) throws IOException {
		questionspage4_swing(utilizador,formulario,template_obj);
	}
	 
			/**
			 * Creates layout and actions of the QuestionsPage4_SL class
			 * @param utilizador
			 * @throws IOException
			 */
			public void questionspage4_swing(user utilizador,form formulario,template template_obj) throws IOException {
 
				/**
				 * Initialize values
				 */
				frame = new JFrame ("EasyCV");
				frame.setSize(1080, 720);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.getContentPane().setLayout(null);

				formulario.labelwebsite = new JLabel(formulario.website);
				formulario.labelwebsite.setHorizontalAlignment(SwingConstants.CENTER);
				formulario.labelwebsite.setFont(new Font("OCR A Extended", Font.PLAIN, 11));
				formulario.labelwebsite.setBounds(46, 301, 244, 14);
				frame.getContentPane().add(formulario.labelwebsite);
				
				formulario.labelfb = new JLabel(formulario.facebook);
				formulario.labelfb.setHorizontalAlignment(SwingConstants.CENTER);
			    formulario.labelfb.setFont(new Font("OCR A Extended", Font.PLAIN, 11));
				formulario.labelfb.setBounds(295, 301, 244, 14);
				frame.getContentPane().add(formulario.labelfb);
				
				formulario.labelinsta = new JLabel(formulario.instagram);
				formulario.labelinsta.setHorizontalAlignment(SwingConstants.CENTER);
			    formulario.labelinsta.setFont(new Font("OCR A Extended", Font.PLAIN, 11));
				formulario.labelinsta.setBounds(546, 301, 244, 14);
				frame.getContentPane().add(formulario.labelinsta);
				
				formulario.labeltwitter = new JLabel(formulario.twitter);
				formulario.labeltwitter.setHorizontalAlignment(SwingConstants.CENTER);
			    formulario.labeltwitter.setFont(new Font("OCR A Extended", Font.PLAIN, 11));
				formulario.labeltwitter.setBounds(795, 301, 244, 14);
				frame.getContentPane().add(formulario.labeltwitter);
				
				formulario.labellinkedin = new JLabel(formulario.linkedin);
				formulario.labellinkedin.setHorizontalAlignment(SwingConstants.CENTER);
				formulario.labellinkedin.setFont(new Font("OCR A Extended", Font.PLAIN, 11));
				formulario.labellinkedin.setBounds(46, 448, 244, 14);
				frame.getContentPane().add(formulario.labellinkedin);
				
				formulario.labelskype = new JLabel(formulario.skype);
				formulario.labelskype.setHorizontalAlignment(SwingConstants.CENTER);
				formulario.labelskype.setFont(new Font("OCR A Extended", Font.PLAIN, 11));
				formulario.labelskype.setBounds(295, 448, 244, 14);
				frame.getContentPane().add(formulario.labelskype);
				
				formulario.labeldiscord = new JLabel(formulario.discord);
				formulario.labeldiscord.setHorizontalAlignment(SwingConstants.CENTER);
				formulario.labeldiscord.setFont(new Font("OCR A Extended", Font.PLAIN, 11));
				formulario.labeldiscord.setBounds(546, 448, 244, 14);
				frame.getContentPane().add(formulario.labeldiscord);
				
				formulario.labelyoutube = new JLabel(formulario.youtube);
				formulario.labelyoutube.setHorizontalAlignment(SwingConstants.CENTER);
				formulario.labelyoutube.setFont(new Font("OCR A Extended", Font.PLAIN, 11));
				formulario.labelyoutube.setBounds(795, 448, 244, 14);
				frame.getContentPane().add(formulario.labelyoutube);
				
				
				JButton WB = new JButton("");
				WB.addMouseListener(
				/**
				 * Changes mouse arrow
				 *
				 */
				new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent arg0) {
						WB.setCursor(new Cursor(Cursor.HAND_CURSOR));
					}
					@Override
					public void mouseExited(MouseEvent e) {
						WB.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
					}
				});
				WB.addActionListener(
				/**
				 * Creates an action that shows window.frame, setting it visible. In this case, the 8.
				 *
				 */
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						InsereDataWindow window;
						try {
							window = new InsereDataWindow(9,utilizador,formulario,template_obj,null,"Put your WebSite/Blog link here.",formulario.website);
							window.frame.setVisible(true);

						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
				WB.setBounds(46, 203, 244, 131);
				WB.setBackground(Color.DARK_GRAY);
				//RESIZE RESOLUTION
				ImageIcon FullName = new ImageIcon("Swing/FILL_MU_EASYCV_SL_0007_WEB.png");
				Image img = FullName.getImage();
				Image resizeImg = img.getScaledInstance(WB.getWidth(), WB.getHeight(), Image.SCALE_SMOOTH);
				ImageIcon image = new ImageIcon(resizeImg);
				WB.setIcon(image);
				WB.setOpaque(false);
				WB.setContentAreaFilled(false);
				WB.setBorderPainted(false);
				frame.getContentPane().add(WB);  
 

				JButton FB = new JButton("");
				FB.addMouseListener(
				/**
				 * Changes mouse arrow
				 *
				 */
				new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent arg0) {
						FB.setCursor(new Cursor(Cursor.HAND_CURSOR));
					}
					@Override
					public void mouseExited(MouseEvent e) {
						FB.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
					}
				});
				FB.addActionListener(
				/**
				 * Creates an action that shows window.frame, setting it visible. In this case, the 9.
				 *
				 */
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						InsereDataWindow window;
						try {
							window = new InsereDataWindow(10,utilizador,formulario,template_obj,null,"Put your Facebook here.",formulario.facebook);
							window.frame.setVisible(true);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					}
				});
				FB.setBounds(295, 203, 244, 131);
				FB.setBackground(Color.DARK_GRAY);
				//RESIZE RESOLUTION
				ImageIcon BD1 = new ImageIcon("Swing/FILL_MU_EASYCV_SL_0006_Facebook.png");
				Image imgBD = BD1.getImage();
				Image resizeImgFB = imgBD.getScaledInstance(FB.getWidth(), FB.getHeight(), Image.SCALE_SMOOTH);
				ImageIcon imageFB = new ImageIcon(resizeImgFB);
				FB.setIcon(imageFB);
				FB.setOpaque(false);
				FB.setContentAreaFilled(false);
				FB.setBorderPainted(false);
				frame.getContentPane().add(FB);


				JButton IG = new JButton("");
				IG.addActionListener(
				/**
				 * Creates an action that shows window.frame, setting it visible. In this case, the 10.
				 *
				 */
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						InsereDataWindow window;
						try {
							window = new InsereDataWindow(11,utilizador,formulario,template_obj,null,"Put your Instagram account here. ",formulario.instagram);
							window.frame.setVisible(true);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
				IG.addMouseListener(
				/**
				 * Changes mouse arrow
				 *
				 */
				new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent arg0) {
						IG.setCursor(new Cursor(Cursor.HAND_CURSOR));
					}
					@Override
					public void mouseExited(MouseEvent e) {
						IG.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
					}
				});
				
				IG.setBounds(546, 203, 244, 131);
				IG.setBackground(Color.DARK_GRAY);
				//RESIZE RESOLUTION
				ImageIcon YF1 = new ImageIcon("Swing/FILL_MU_EASYCV_SL_0005_Instagram.png");
				Image imgIG = YF1.getImage();
				Image resizeImgIG = imgIG.getScaledInstance(IG.getWidth(), IG.getHeight(), Image.SCALE_SMOOTH);
				ImageIcon imageIG = new ImageIcon(resizeImgIG);
				IG.setIcon(imageIG);
				IG.setOpaque(false);
				IG.setContentAreaFilled(false);
				IG.setBorderPainted(false);
				frame.getContentPane().add(IG);


				JButton TW = new JButton("");
				TW.addActionListener(
				/**
				 * Creates an action that shows window.frame, setting it visible. In this case, the 11.
				 *
				 */
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						InsereDataWindow window;
						try {
							window = new InsereDataWindow(12,utilizador,formulario,template_obj,null,"Put your Twitter account here.",formulario.twitter);
							window.frame.setVisible(true);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
				TW.addMouseListener(
				/**
				 * Changes mouse arrow
				 *
				 */
				new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent arg0) {
						TW.setCursor(new Cursor(Cursor.HAND_CURSOR));
					}
					@Override
					public void mouseExited(MouseEvent e) {
						TW.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
					}
				});
				TW.setBounds(795, 203, 244, 131);
				TW.setBackground(Color.DARK_GRAY);
				//RESIZE RESOLUTION
				ImageIcon TW1 = new ImageIcon("Swing/FILL_MU_EASYCV_SL_0004_Twitter.png");
				Image imgTW = TW1.getImage();
				Image resizeImgTW = imgTW.getScaledInstance(TW.getWidth(), TW.getHeight(), Image.SCALE_SMOOTH);
				ImageIcon imageTW = new ImageIcon(resizeImgTW);
				TW.setIcon(imageTW);
				TW.setOpaque(false);
				TW.setContentAreaFilled(false);
				TW.setBorderPainted(false);
				frame.getContentPane().add(TW);


				JButton LI = new JButton("");
				LI.addActionListener(
				/**
				 * Creates an action that shows window.frame, setting it visible. In this case, the 12.
				 *
				 */
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						InsereDataWindow window;
						try {
							window = new InsereDataWindow(13,utilizador,formulario,template_obj,null,"Put your Linkedin account here.",formulario.linkedin);
							window.frame.setVisible(true);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
				
				LI.addMouseListener(
				/**
				 * Changes mouse arrow
				 *
				 */
				new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent arg0) {
						LI.setCursor(new Cursor(Cursor.HAND_CURSOR));
					}
					@Override
					public void mouseExited(MouseEvent e) {
						LI.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
					}
				});
				LI.setBounds(46, 346, 244, 131);
				LI.setBackground(Color.DARK_GRAY);
				//RESIZE RESOLUTION
				ImageIcon LI1 = new ImageIcon("Swing/FILL_MU_EASYCV_SL_0002_Skype.png");
				Image imgLI = LI1.getImage();
				Image resizeImgPC = imgLI.getScaledInstance(LI.getWidth(), LI.getHeight(), Image.SCALE_SMOOTH);
				ImageIcon imagePC = new ImageIcon(resizeImgPC);
				LI.setIcon(imagePC);
				LI.setOpaque(false);
				LI.setContentAreaFilled(false);
				LI.setBorderPainted(false);
				frame.getContentPane().add(LI);


				JButton SK = new JButton("");
				SK.addActionListener(
				/**
				 * Creates an action that shows window.frame, setting it visible. In this case, the 13.
				 *
				 */
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						InsereDataWindow window;
						try {
							window = new InsereDataWindow(14,utilizador,formulario,template_obj,null,"Put your Skype username here.",formulario.skype);
							window.frame.setVisible(true);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
				SK.addMouseListener(
				/**
				 * Changes mouse arrow
				 *
				 */
				new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent arg0) {
						SK.setCursor(new Cursor(Cursor.HAND_CURSOR));
					}
					@Override
					public void mouseExited(MouseEvent e) {
						SK.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
					}
				});
				SK.setBounds(295, 346, 244, 131);
				SK.setBackground(Color.DARK_GRAY);
				//RESIZE RESOLUTION
				ImageIcon SK1 = new ImageIcon("Swing/FILL_MU_EASYCV_SL_0003_Linkedin.png");
				Image imgSK = SK1.getImage();
				Image resizeImgSK = imgSK.getScaledInstance(SK.getWidth(), SK.getHeight(), Image.SCALE_SMOOTH);
				ImageIcon imageSK = new ImageIcon(resizeImgSK);
				SK.setIcon(imageSK);
				SK.setOpaque(false);
				SK.setContentAreaFilled(false);
				SK.setBorderPainted(false);
				frame.getContentPane().add(SK);


				JButton DL = new JButton("");
				DL.addActionListener(
				/**
				 * Creates an action that shows window.frame, setting it visible. In this case, the 14.
				 *
				 */
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						InsereDataWindow window;
						try {
							window = new InsereDataWindow(15,utilizador,formulario,template_obj,null,"Put your Discord link here.",formulario.discord);
							window.frame.setVisible(true);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
				
				DL.addMouseListener(
				/**
				 * Changes mouse arrow
				 *
				 */
				new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent arg0) {
						DL.setCursor(new Cursor(Cursor.HAND_CURSOR));
					}
					@Override
					public void mouseExited(MouseEvent e) {
						DL.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
					}
				});
				
				DL.setBounds(546, 346, 244, 131);
				DL.setBackground(Color.DARK_GRAY);
				//RESIZE RESOLUTION
				ImageIcon DL1 = new ImageIcon("Swing/FILL_MU_EASYCV_SL_0001_Discor.png");
				Image imgDL = DL1.getImage();
				Image resizeImgDL = imgDL.getScaledInstance(DL.getWidth(), DL.getHeight(), Image.SCALE_SMOOTH);
				ImageIcon imageDL = new ImageIcon(resizeImgDL);
				DL.setIcon(imageDL);
				DL.setOpaque(false);
				DL.setContentAreaFilled(false);
				DL.setBorderPainted(false);
				frame.getContentPane().add(DL);


				JButton YT = new JButton("");
				YT.addActionListener(
				/**
				 * Creates an action that shows window.frame, setting it visible. In this case, the 15.
				 *
				 */
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						InsereDataWindow window;
						try {
							window = new InsereDataWindow(16,utilizador,formulario,template_obj,null,"Put your YouTube cannal here.",formulario.youtube);
							window.frame.setVisible(true);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
				YT.addMouseListener(
				/**
				 * Change mouse arrow
				 *
				 */
				new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent arg0) {
						YT.setCursor(new Cursor(Cursor.HAND_CURSOR));
					}
					@Override
					public void mouseExited(MouseEvent e) {
						YT.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
					}
				});
				YT.setBounds(795, 346, 244, 131);
				YT.setBackground(Color.DARK_GRAY);
				//RESIZE RESOLUTION
				ImageIcon YT1 = new ImageIcon("Swing/FILL_MU_EASYCV_SL_0000_Youtube.png");
				Image imgPN = YT1.getImage();
				Image resizeImgYT = imgPN.getScaledInstance(YT.getWidth(), YT.getHeight(), Image.SCALE_SMOOTH);
				ImageIcon imageYT = new ImageIcon(resizeImgYT);
				YT.setIcon(imageYT);
				YT.setOpaque(false);
				YT.setContentAreaFilled(false);
				YT.setBorderPainted(false);
				frame.getContentPane().add(YT);


				////////// menu  //////////
				JButton PI = new JButton("");
				PI.addActionListener(
				/**
				 * Creates an action that shows questions1.frame, setting it visible. 
				 *
				 */
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						QuestionsPage1_PI questions1;
						try {
							questions1 = new QuestionsPage1_PI(utilizador, formulario,template_obj);
							frame.dispose();
							questions1.frame.setVisible(true);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					}
				});
				PI.addMouseListener(
				/**
				 * Change mouse arrow
				 *
				 */
				new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent arg0) {
						PI.setCursor(new Cursor(Cursor.HAND_CURSOR));
					}
					@Override
					public void mouseExited(MouseEvent e) {
						PI.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
					}
				});
				PI.setBounds(46, 548, 226, 47);
				PI.setBackground(Color.DARK_GRAY);
				//RESIZE RESOLUTION
				ImageIcon PI1 = new ImageIcon("Swing/FILL_MU_EASYCV_WE_0005_PERSONALINFO.png");
				Image imgPI = PI1.getImage();
				Image resizeImgPI = imgPI.getScaledInstance(PI.getWidth(), PI.getHeight(), Image.SCALE_SMOOTH);
				ImageIcon imagePI = new ImageIcon(resizeImgPI);
				PI.setIcon(imagePI);
				PI.setOpaque(false);
				PI.setContentAreaFilled(false);
				PI.setBorderPainted(false);
				frame.getContentPane().add(PI);


				JButton WE = new JButton("");
				WE.addActionListener(
				/**
				 * Creates an action that shows questions2.frame, setting it visible.
				 *
				 */
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						QuestionsPage4_WE questions2;
						try {
							questions2 = new QuestionsPage4_WE(utilizador, formulario,template_obj);
							frame.dispose();
							questions2.frame.setVisible(true);
						
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
				WE.addMouseListener(
				/**
				 * Change mouse arrow
				 *
				 */
				new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent arg0) {
						WE.setCursor(new Cursor(Cursor.HAND_CURSOR));
					}
					@Override
					public void mouseExited(MouseEvent e) {
						WE.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
					}
				});
				WE.setBounds(46, 607, 305, 47);
				WE.setBackground(Color.DARK_GRAY);
				//RESIZE RESOLUTION
				ImageIcon WE1 = new ImageIcon("Swing/FILL_MU_EASYCV_PI_0010_WS-exop.png");
				Image imgWE = WE1.getImage();
				Image resizeImgWE = imgWE.getScaledInstance(WE.getWidth(), WE.getHeight(), Image.SCALE_SMOOTH);
				ImageIcon imageWE = new ImageIcon(resizeImgWE);
				WE.setIcon(imageWE);
				WE.setOpaque(false);
				WE.setContentAreaFilled(false);
				WE.setBorderPainted(false);
				frame.getContentPane().add(WE);


				JButton PS = new JButton("");
				PS.addMouseListener(
				/**
				 * Change mouse arrow
				 *
				 */
				new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent arg0) {
						PS.setCursor(new Cursor(Cursor.HAND_CURSOR));
					}
					@Override
					public void mouseExited(MouseEvent e) {
						PS.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
					}
				});
				
				PS.addActionListener(
				/**
				 * Creates an action that shows questions3.frame, setting it visible.
				 *
				 */
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						QuestionsPage3_PS questions3;
						try {
							questions3 = new QuestionsPage3_PS(utilizador, formulario,template_obj);
							frame.dispose();
							questions3.frame.setVisible(true);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					}
				});
				PS.setBounds(295, 548, 237, 47);
				PS.setBackground(Color.DARK_GRAY);
				//RESIZE RESOLUTION
				ImageIcon PS1 = new ImageIcon("Swing/FILL_MU_EASYCV_PI_0011_PersonaklSkills.png");
				Image imgPS = PS1.getImage();
				Image resizeImgPS = imgPS.getScaledInstance(PS.getWidth(), PS.getHeight(), Image.SCALE_SMOOTH);
				ImageIcon imagePS = new ImageIcon(resizeImgPS);
				PS.setIcon(imagePS);
				PS.setOpaque(false);
				PS.setContentAreaFilled(false);
				PS.setBorderPainted(false);
				frame.getContentPane().add(PS);


				JButton SL = new JButton("");
				SL.setBounds(375, 607, 214, 47);
				SL.setBackground(Color.DARK_GRAY);
				//RESIZE RESOLUTION
				ImageIcon SL1 = new ImageIcon("Swing/FILL_MU_EASYCV_SL_0008_SL.png");
				Image imgSL = SL1.getImage();
				Image resizeImgSL = imgSL.getScaledInstance(SL.getWidth(), SL.getHeight(), Image.SCALE_SMOOTH);
				ImageIcon imageSL = new ImageIcon(resizeImgSL);
				SL.setIcon(imageSL);
				SL.setOpaque(false);
				SL.setContentAreaFilled(false);
				SL.setBorderPainted(false);
				frame.getContentPane().add(SL);


				JButton QM = new JButton("");
				QM.setBounds(545, 548, 44, 47);
				QM.setBackground(Color.DARK_GRAY);
				//RESIZE RESOLUTION
				ImageIcon QM1 = new ImageIcon("Swing/FILL_MU_EASYCV_PI_0008__.png");
				Image imgQM = QM1.getImage();
				Image resizeImgQM = imgQM.getScaledInstance(QM.getWidth(), QM.getHeight(), Image.SCALE_SMOOTH);
				ImageIcon imageQM = new ImageIcon(resizeImgQM);
				QM.setIcon(imageQM);
				QM.setOpaque(false);
				QM.setContentAreaFilled(false);
				QM.setBorderPainted(false);
				frame.getContentPane().add(QM);
				
				JButton save = new JButton("");
				save.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						try {
							form.createlog(utilizador, formulario,2);
						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
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
				save.setOpaque(false);
				save.setBounds(896, 111, 143, 39);
				ImageIcon Sh = new ImageIcon("Swing/FILL_MU_EASYCV_Ready_0003_Share.png");
				Image imgSH = Sh.getImage();
				Image resizeImgSH = imgSH.getScaledInstance(save.getWidth(), save.getHeight(), Image.SCALE_SMOOTH);
				ImageIcon imageSH = new ImageIcon(resizeImgSH);
				save.setIcon(imageSH);
				save.setContentAreaFilled(false);
				save.setBorderPainted(false);
				save.setVisible(true);
				frame.getContentPane().add(save);
				frame.setVisible(true);
				
				JButton WD = new JButton("");
				WD.addMouseListener(
				/**
				 * Changes mouse arrow
				 *
				 */
				new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent arg0) {
						WD.setCursor(new Cursor(Cursor.HAND_CURSOR));
					}
					@Override
					public void mouseExited(MouseEvent e) {
						WD.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
					}
				});
				WD.addActionListener(
						/**	 	
						 * Creates an action to show cvready.frame, setting it visible.
						 *
						 */
						new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
								try {
									template template_obj= new template();
									File cv= template_obj.createCV(formulario);
									frame.dispose();
									CVReadyPage cvready= new CVReadyPage(cv,utilizador,formulario,template_obj);
									cvready.frame.setVisible(true);
								} catch (InvalidFormatException | IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
						});
				WD.setBounds(795, 548, 244, 106);
				WD.setBackground(Color.DARK_GRAY);
				//RESIZE RESOLUTION
				ImageIcon WD1 = new ImageIcon("Swing/FILL_MU_EASYCV_PI_0013_worksdone.png");
				Image imgWD = WD1.getImage();
				Image resizeImgWD = imgWD.getScaledInstance(WD.getWidth(), WD.getHeight(), Image.SCALE_SMOOTH);
				ImageIcon imageWD = new ImageIcon(resizeImgWD);
				WD.setIcon(imageWD);
				WD.setOpaque(false);
				WD.setContentAreaFilled(false);
				WD.setBorderPainted(false);
				frame.getContentPane().add(WD);


				JButton Return = new JButton("");
				Return.addMouseListener(
				/**
				 * Changes mouse arrow
				 *
				 */
				new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent arg0) {
						Return.setCursor(new Cursor(Cursor.HAND_CURSOR));
					}
					@Override
					public void mouseExited(MouseEvent e) {
						Return.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
					}
				});
				Return.addActionListener(
				/**
				 * Creates an action that shows main.frame, setting it visible.
				 *
				 */
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						frame.dispose();
						MainPage main;
						try {
							main = new MainPage(utilizador,template_obj);
							main.frame.setVisible(true);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					}
				});
				Return.setBounds(18, 32, 175, 47);
				Return.setBackground(Color.DARK_GRAY);
				//RESIZE RESOLUTION
				ImageIcon RE1 = new ImageIcon("Swing/FILL_MU_EASYCV_WE_0003_RETURN.png");
				Image imgRE = RE1.getImage();
				Image resizeImgRE = imgRE.getScaledInstance(Return.getWidth(), Return.getHeight(), Image.SCALE_SMOOTH);
				ImageIcon imageRE = new ImageIcon(resizeImgRE);
				Return.setIcon(imageRE);
				Return.setOpaque(false);
				Return.setContentAreaFilled(false);
				Return.setBorderPainted(false);
				frame.getContentPane().add(Return);

				//////////////////////////
				JLabel labeldescription = new JLabel("");
				labeldescription.setBounds(18, 32, 865, 71);
				ImageIcon cabe = new ImageIcon("Swing/FILL_MU_EASYCV_PI_0014_UI.png");
				Image imgcabe = cabe.getImage();
				Image resizeImgbk = imgcabe.getScaledInstance(labeldescription.getWidth(), labeldescription.getHeight(), Image.SCALE_SMOOTH);
				ImageIcon imagebk = new ImageIcon(resizeImgbk);
				labeldescription.setIcon(imagebk);
				frame.getContentPane().add(labeldescription);
				frame.setVisible(true);

				
				
				JLabel BK = new JLabel("");
				BK.setBounds(10, -12, 1080, 720);
				ImageIcon BK1 = new ImageIcon("Swing/FILL_MU_EASYCV_PI_0015_#2e3131.jpg");
				BK.setIcon(new ImageIcon("Swing/FILL_MU_EASYCV_PI_0015_#2e3131.png"));
				frame.getContentPane().add(BK);
				
				formulario.filllabels(2, utilizador, formulario);				



			}	
}
