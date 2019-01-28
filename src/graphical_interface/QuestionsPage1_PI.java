package graphical_interface;

import javax.swing.*;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.io.*;
import java.awt.*;

import logic.form;
import logic.template;
import logic.user;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
@SuppressWarnings("all")
/**
 * Date: Jan 03-2019
 * This is a class that creates the "QuestionsPage1_PI" layout and actions
 * @author nunonogueira, joaoneves, josemiguel, afonsoqueiros
 * @version 1.0
 */
public class QuestionsPage1_PI
{
	/**
	 * Initialize values 
	 */
	form formulario= new form();
	JFrame frame;
	
	/**
	 * Constructor of the QuestionsPage1_PI class
	 * @param utilizador
	 * @throws IOException
	 */
	public QuestionsPage1_PI(user utilizador,form formulario,template template_obj)  throws IOException{
		questionspage1_swing(utilizador,formulario,template_obj);
	}
	/**
	 * Creates layout and actions of the QuestionsPage1_PI class
	 * @param utilizador
	 * @throws IOException
	 */
	public  void questionspage1_swing (user utilizador, form formulario, template template_obj) throws IOException 
	{  
				frame = new JFrame ("EasyCV");
				frame.setSize(1080, 720);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.getContentPane().setLayout(null);
				
				formulario.labelbd = new JLabel(formulario.birth_date);
				formulario.labelbd.setHorizontalAlignment(SwingConstants.CENTER);
			    formulario.labelbd.setFont(new Font("OCR A Extended", Font.PLAIN, 11));
				formulario.labelbd.setBounds(295, 308, 239, 14);
				frame.getContentPane().add(formulario.labelbd);
				 
				formulario.labelnationality = new JLabel(formulario.birth_place);
				formulario.labelnationality.setFont(new Font("OCR A Extended", Font.PLAIN, 11));
				formulario.labelnationality.setHorizontalAlignment(SwingConstants.CENTER);
				formulario.labelnationality.setBounds(545, 308, 239, 14);
				frame.getContentPane().add(formulario.labelnationality);
				
			    formulario.labelfn = new JLabel(formulario.fullname);
			    formulario.labelfn.setHorizontalAlignment(SwingConstants.CENTER);
			    formulario.labelfn.setFont(new Font("OCR A Extended", Font.PLAIN, 11));
			    formulario.labelfn.setBounds(46, 308, 244, 14);
				frame.getContentPane().add(formulario.labelfn);
				
				formulario.labelpc = new JLabel(formulario.postal_code);
				formulario.labelpc.setHorizontalAlignment(SwingConstants.CENTER);
			    formulario.labelpc.setFont(new Font("OCR A Extended", Font.PLAIN, 11));
			    formulario.labelpc.setBounds(46, 448, 244, 14);
				frame.getContentPane().add(formulario.labelpc);
				
				formulario.labeladdress = new JLabel(formulario.address);
				formulario.labeladdress.setFont(new Font("OCR A Extended", Font.PLAIN, 11));
				formulario.labeladdress.setHorizontalAlignment(SwingConstants.CENTER);
				formulario.labeladdress.setBounds(795, 308, 239, 14);
				frame.getContentPane().add(formulario.labeladdress);
				
				formulario.labelemail = new JLabel(formulario.email);
				formulario.labelemail.setFont(new Font("OCR A Extended", Font.PLAIN, 11));
				formulario.labelemail.setHorizontalAlignment(SwingConstants.CENTER);
				formulario.labelemail.setBounds(295, 448, 244, 14);
				frame.getContentPane().add(formulario.labelemail);
				
				formulario.labellicence = new JLabel(formulario.licence_driver);
				formulario.labellicence.setFont(new Font("OCR A Extended", Font.PLAIN, 11));
				formulario.labellicence.setHorizontalAlignment(SwingConstants.CENTER);
				formulario.labellicence.setBounds(545, 450, 244, 14);
				frame.getContentPane().add(formulario.labellicence);
				
				formulario.labelpn = new JLabel(formulario.phone_contact);
				formulario.labelpn.setFont(new Font("OCR A Extended", Font.PLAIN, 11));
				formulario.labelpn.setHorizontalAlignment(SwingConstants.CENTER);
				formulario.labelpn.setBounds(795, 448, 244, 14);
				frame.getContentPane().add(formulario.labelpn);
				
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
				 * Creates an action to show main.frame, setting it visible.
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
				
				JButton BD = new JButton("");
				BD.addMouseListener(
				/**
				 * Changes mouse arrow
				 *
				 */
				new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent arg0) {
						BD.setCursor(new Cursor(Cursor.HAND_CURSOR));
					}
					@Override
					public void mouseExited(MouseEvent e) {
						BD.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
					}
				});
				
				BD.addActionListener(
				/**
				 * Creates action to show window.frame, setting it visible. In this case, the 2.
				 */
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						InsereDataWindow window;
						try {
							window = new InsereDataWindow(2,utilizador,formulario,template_obj,null,"Put your Birth Date here.",formulario.birth_date);
							window.frame.setVisible(true);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
				BD.setBounds(295, 203, 244, 131);
				BD.setBackground(Color.DARK_GRAY);
				//RESIZE RESOLUTION
				ImageIcon BD1 = new ImageIcon("Swing/FILL_MU_EASYCV_PI_0006_Birth-Date.png");
				Image imgBD = BD1.getImage();
				Image resizeImgBD = imgBD.getScaledInstance(BD.getWidth(), BD.getHeight(), Image.SCALE_SMOOTH);
				ImageIcon imageBD = new ImageIcon(resizeImgBD);
				BD.setIcon(imageBD);
				BD.setOpaque(false);
				BD.setContentAreaFilled(false);
				BD.setBorderPainted(false);
				frame.getContentPane().add(BD);
				
				
				JButton YF = new JButton("");
				YF.addMouseListener(
				/**
				 * Changes mouse arrow
				 */
				new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent arg0) {
						YF.setCursor(new Cursor(Cursor.HAND_CURSOR));
					}
					@Override
					public void mouseExited(MouseEvent e) {
						YF.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
					}
				});
				
				YF.addActionListener(
				/**
				 * Creates action to show window.frame, setting it visible. In this case, the 3.
				 *
				 */
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						InsereDataWindow window;
						try {
							window = new InsereDataWindow(3,utilizador,formulario,template_obj,null,"Where are you from?",formulario.birth_place);
							window.frame.setVisible(true);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
				YF.setBounds(546, 203, 244, 131);
				YF.setBackground(Color.DARK_GRAY);
				//RESIZE RESOLUTION
				ImageIcon YF1 = new ImageIcon("Swing/FILL_MU_EASYCV_PI_0005_YouFrom.png");
				Image imgYF = YF1.getImage();
				Image resizeImgYF = imgYF.getScaledInstance(YF.getWidth(), YF.getHeight(), Image.SCALE_SMOOTH);
				ImageIcon imageYF = new ImageIcon(resizeImgYF);
				YF.setIcon(imageYF);
				YF.setOpaque(false);
				YF.setContentAreaFilled(false);
				YF.setBorderPainted(false);
				frame.getContentPane().add(YF);
				
				
				JButton AD = new JButton("");
				AD.addMouseListener(
				/**
				 * Change mouse arrow
				 */
				new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent arg0) {
						AD.setCursor(new Cursor(Cursor.HAND_CURSOR));
					}
					@Override
					public void mouseExited(MouseEvent e) {
						AD.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
					}
				});
				
				AD.addActionListener(
				/**
				 * Creates an action to show window.frame, setting it visible. In this case, the 4.
				 *
				 */
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						InsereDataWindow window;
						try {
							window = new InsereDataWindow(4,utilizador,formulario,template_obj,null,"Put your house's address here.",formulario.address);
							window.frame.setVisible(true);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
				AD.setBounds(795, 203, 244, 131);
				AD.setBackground(Color.DARK_GRAY);
				//RESIZE RESOLUTION
				ImageIcon AD1 = new ImageIcon("Swing/FILL_MU_EASYCV_PI_0004_Address.png");
				Image imgAD = AD1.getImage();
				Image resizeImgAD = imgAD.getScaledInstance(AD.getWidth(), AD.getHeight(), Image.SCALE_SMOOTH);
				ImageIcon imageAD = new ImageIcon(resizeImgAD);
				AD.setIcon(imageAD);
				AD.setOpaque(false);
				AD.setContentAreaFilled(false);
				AD.setBorderPainted(false);
				frame.getContentPane().add(AD);
				
				
				JButton PC = new JButton("");
				PC.addMouseListener(
				/**
				 * Change mouse arrow
				 *
				 */
				new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent arg0) {
						PC.setCursor(new Cursor(Cursor.HAND_CURSOR));
					}
					@Override
					public void mouseExited(MouseEvent e) {
						PC.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
					}
				});
				
				PC.addActionListener(
				/**
				 * Creates an action to show window.frame, setting it visible. In this case, the 5.
				 *
				 */
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						InsereDataWindow window;
						try {
							window = new InsereDataWindow(5,utilizador,formulario,template_obj,null, "Put your Postal Code here.",formulario.postal_code);
							window.frame.setVisible(true);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
				PC.setBounds(46, 346, 244, 131);
				PC.setBackground(Color.DARK_GRAY);
				//RESIZE RESOLUTION
				ImageIcon PC1 = new ImageIcon("Swing/FILL_MU_EASYCV_PI_0003_PostalCode.png");
				Image imgPC = PC1.getImage();
				Image resizeImgPC = imgPC.getScaledInstance(PC.getWidth(), PC.getHeight(), Image.SCALE_SMOOTH);
				ImageIcon imagePC = new ImageIcon(resizeImgPC);
				PC.setIcon(imagePC);
				PC.setOpaque(false);
				PC.setContentAreaFilled(false);
				PC.setBorderPainted(false);
				frame.getContentPane().add(PC);
				
				
				JButton EM = new JButton("");
				EM.addMouseListener(
				/**
				 * Changes mouse arrow
				 *
				 */
				new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent arg0) {
						EM.setCursor(new Cursor(Cursor.HAND_CURSOR));
					}
					@Override
					public void mouseExited(MouseEvent e) {
						EM.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
					}
				});
				EM.addActionListener(
				/**
				 * Creates an action to show window.frame, setting it visible. In this case, the 6.
				 *
				 */
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						InsereDataWindow window;
						try {
							window = new InsereDataWindow(6,utilizador,formulario,template_obj,null,"Put your E-mail here.",formulario.email);
							window.frame.setVisible(true);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
				EM.setBounds(295, 346, 244, 131);
				EM.setBackground(Color.DARK_GRAY);
				//RESIZE RESOLUTION
				ImageIcon EM1 = new ImageIcon("Swing/FILL_MU_EASYCV_PI_0002_email.png");
				Image imgEM = EM1.getImage();
				Image resizeImgEM = imgEM.getScaledInstance(EM.getWidth(), EM.getHeight(), Image.SCALE_SMOOTH);
				ImageIcon imageEM = new ImageIcon(resizeImgEM);
				EM.setIcon(imageEM);
				EM.setOpaque(false);
				EM.setContentAreaFilled(false);
				EM.setBorderPainted(false);
				frame.getContentPane().add(EM);
				
				
				JButton DL = new JButton("");
				DL.addMouseListener(
				/**
				 * Change mouse arrow 
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
				
				DL.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						InsereDataWindow window;
						try {
							form.createlog_driver(utilizador, formulario);
							window = new InsereDataWindow(7,utilizador,formulario,template_obj,null,"Put your Driver Licence here.",null);
							window.frame.setVisible(true);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} //mudar este
						
						
					}
				});
				DL.setBounds(546, 346, 244, 131);
				DL.setBackground(Color.DARK_GRAY);
				//RESIZE RESOLUTION
				ImageIcon DL1 = new ImageIcon("Swing/FILL_MU_EASYCV_PI_0001_DriveLicense.png");
				Image imgDL = DL1.getImage();
				Image resizeImgDL = imgDL.getScaledInstance(DL.getWidth(), DL.getHeight(), Image.SCALE_SMOOTH);
				ImageIcon imageDL = new ImageIcon(resizeImgDL);
				DL.setIcon(imageDL);
				DL.setOpaque(false);
				DL.setContentAreaFilled(false);
				DL.setBorderPainted(false);
				frame.getContentPane().add(DL);
				
	
				JButton PN = new JButton("");
				PN.addMouseListener(
				/**
				 * Changes mouse arrow
				 *
				 */
				new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent arg0) {
						PN.setCursor(new Cursor(Cursor.HAND_CURSOR));
					}
					@Override
					public void mouseExited(MouseEvent e) {
						PN.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
					}
				});
				
				PN.addActionListener(
				/**
				 * Creates an action to show window.frame, setting it visible. In this case, the 7.
				 *
				 */
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						InsereDataWindow window;
						try {
							window = new InsereDataWindow(8,utilizador,formulario,template_obj,null,"Put your Phone Number here.",formulario.phone_contact);
							window.frame.setVisible(true);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
				PN.setBounds(795, 346, 244, 131);
				PN.setBackground(Color.DARK_GRAY);
				//RESIZE RESOLUTION
				ImageIcon PN1 = new ImageIcon("Swing/FILL_MU_EASYCV_PI_0000_PhoneNumber.png");
				Image imgPN = PN1.getImage();
				Image resizeImgPN = imgPN.getScaledInstance(PN.getWidth(), PN.getHeight(), Image.SCALE_SMOOTH);
				ImageIcon imagePN = new ImageIcon(resizeImgPN);
				PN.setIcon(imagePN);
				PN.setOpaque(false);
				PN.setContentAreaFilled(false);
				PN.setBorderPainted(false);
				frame.getContentPane().add(PN);
				
				
				JButton PI = new JButton("");
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
				ImageIcon PI1 = new ImageIcon("Swing/FILL_MU_EASYCV_PI_0012_PersonalInfo.png");
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
				 * Creates an action to show questions2.frame, setting it visible. 
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
				 * Changes mouse arrow
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
				 * Changes mouse arrow
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
				 * Creates an action to show questions3.frame, setting it visible.
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
				SL.addActionListener(
				/**
				 * Creates an action to show questions4.frame, setting it visible.
				 *
				 */
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						QuestionsPage2_SL questions4;
						try {
							questions4 = new QuestionsPage2_SL(utilizador, formulario,template_obj);
							frame.dispose();
							questions4.frame.setVisible(true);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
				SL.addMouseListener(
				/**
				 * Change mouse arrow
				 *
				 */
				new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent arg0) {
						SL.setCursor(new Cursor(Cursor.HAND_CURSOR));
					}
					@Override
					public void mouseExited(MouseEvent e) {
						SL.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
					}
				});
				SL.setBounds(375, 607, 214, 47);
				SL.setBackground(Color.DARK_GRAY);
				//RESIZE RESOLUTION
				ImageIcon SL1 = new ImageIcon("Swing/FILL_MU_EASYCV_PI_0009_Social-links.png");
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

				JButton WD = new JButton("");
				WD.addMouseListener(
				/**
				 * Change mouse arrow
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
							File log= new File("logs/log_template_"+user.username+".txt");
							form.send_log_server(utilizador, formulario, template_obj, log);
							File cv= template.createCV(formulario);
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
				ImageIcon cabe = new ImageIcon("Swing/FILL_MU_EASYCV_PI_0014_UI.png");
				Image imgcabe = cabe.getImage();
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
				
				JButton FN = new JButton("");
				FN.addActionListener(
				/**
				 * Creates an action to show window.frame, setting it visible. In this case, the 1.
				 *
				 */
				new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					InsereDataWindow window;
					try {
						window = new InsereDataWindow(1,utilizador,formulario,template_obj,null,"Put your First Name here.",formulario.fullname);
						window.frame.setVisible(true);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
					});
				FN.addMouseListener(
				/**
				 * Change mouse arrow
				 */
				new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent arg0) {
						FN.setCursor(new Cursor(Cursor.HAND_CURSOR));
					}
					@Override
					public void mouseExited(MouseEvent e) {
						FN.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
					}
				});
				FN.setBounds(46, 203, 244, 131);
				FN.setBackground(Color.DARK_GRAY);
				//RESIZE RESOLUTION
				ImageIcon FullName = new ImageIcon("Swing/FILL_MU_EASYCV_PI_0007_Full-Name.png");
				Image img = FullName.getImage();
				Image resizeImg = img.getScaledInstance(FN.getWidth(), FN.getHeight(), Image.SCALE_SMOOTH);
				ImageIcon image = new ImageIcon(resizeImg);
				FN.setIcon(image);
				FN.setOpaque(false);
				FN.setContentAreaFilled(false);
				FN.setBorderPainted(false);
				frame.getContentPane().add(FN);
				
				
				JLabel BK = new JLabel("");
				BK.setHorizontalAlignment(SwingConstants.TRAILING);
				BK.setBounds(-6, 0, 1080, 720);
				ImageIcon BK1 = new ImageIcon("Swing/FILL_MU_EASYCV_PI_0015_#2e3131.jpg");
				
				//////////////////////////
				JLabel label_description = new JLabel("");
				label_description.setBounds(18, 32, 865, 71);
				Image resizeImgbk = imgcabe.getScaledInstance(label_description.getWidth(), label_description.getHeight(), Image.SCALE_SMOOTH);
				ImageIcon imagebk = new ImageIcon(resizeImgbk);
				label_description.setIcon(imagebk);
				frame.getContentPane().add(label_description);
				BK.setIcon(new ImageIcon("Swing/FILL_MU_EASYCV_PI_0015_#2e3131.png"));
				frame.getContentPane().add(BK);
				form.filllabels(1, utilizador, formulario); 
				
	}		
}

