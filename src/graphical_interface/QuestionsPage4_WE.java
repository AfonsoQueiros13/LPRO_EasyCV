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
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import logic.form;
import logic.template;
import logic.user;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
@SuppressWarnings("all")
/**
 * Date: Jan 03-2019
 * This is a class that creates the "QuestionsPage2_WE" layout and actions
 * @author nunonogueira, joaoneves, josemiguel, afonsoqueiros
 * @version 1.0
 */
public class QuestionsPage4_WE {
	JFrame frame;
	
	/**
	 * Constructor of the QuestionsPage2_WE class
	 * @param utilizador
	 * @throws IOException
	 */
	 public QuestionsPage4_WE(user utilizador,form formulario,template template_obj) throws IOException
	 {
		 questionspage2_swing(utilizador,formulario,template_obj);
	 }
	 
	 /**
	  * Creates layout and actions of the QuestionsPage2_WE class
	  * @param utilizador
	  * @throws IOException
	  */
	 public void questionspage2_swing(user utilizador, form formulario ,template template_obj) throws IOException {
				
				frame = new JFrame ("EasyCV");
				frame.setSize(1080, 720);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.getContentPane().setLayout(null);
				
				
				JButton PI = new JButton("");
				PI.addMouseListener(
				/**
				 * Changes mouse arrow
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
				
				PI.addActionListener(
				/**
				 * Creates action to show questions1.frame, setting it visible.
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
				WE.setBounds(46, 607, 305, 47);
				WE.setBackground(Color.DARK_GRAY);
				//RESIZE RESOLUTION
				ImageIcon WE1 = new ImageIcon("Swing/FILL_MU_EASYCV_WE_0004_WE.png");
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
				 * Chnages mouse arrow
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
				 * Creates action to show questions3.frame, setting it visible.
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
				PS.setBounds(285, 548, 237, 47);
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
				SL.addActionListener(/**
				 * Creates action to show questions4.frame, setting it visible.
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
				SL.addMouseListener(/**
				 * Changes mouse arrow
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
				SL.setBounds(364, 607, 214, 47);
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
				QM.setBounds(534, 548, 44, 47);
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
				 * Changes mouse arrow
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
				 * Creates action to show main.frame, setting it visible.
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
				
				
				JButton AddButton = new JButton("");
				AddButton.setBounds(46, 317, 305, 71);
				AddButton.setBackground(Color.DARK_GRAY);
				//RESIZE RESOLUTION
				ImageIcon ad1 = new ImageIcon("Swing/FILL_MU_EASYCV_WE_0000_BOLA.png");
				Image imgAD = ad1.getImage();
				Image resizeImgAD = imgAD.getScaledInstance(AddButton.getWidth(), AddButton.getHeight(), Image.SCALE_SMOOTH);
				ImageIcon imageAD = new ImageIcon(resizeImgAD);
				AddButton.setIcon(imageAD);
				AddButton.setOpaque(false);
				AddButton.setContentAreaFilled(false);
				AddButton.setBorderPainted(false);
				frame.getContentPane().add(AddButton);
				
				
				JLabel Study = new JLabel("");
				Study.setBounds(46, 166, 507, 128);
				ImageIcon STD1 = new ImageIcon("Swing/FILL_MU_EASYCV_WE_0002_STUDY.png");
				Image STD = STD1.getImage();
				Image resizeImgSTD = STD.getScaledInstance(Study.getWidth(), Study.getHeight(), Image.SCALE_SMOOTH);
				ImageIcon imageSTD = new ImageIcon(resizeImgSTD);
				Study.setIcon(imageSTD);

				frame.getContentPane().add(Study);
				frame.setVisible(true);
				
				formulario.studied_on = new JTextField("Place here your Study Place");
				formulario.studied_on.setFont(new Font("OCR A Extended", Font.PLAIN, 14));
				formulario.studied_on.setHorizontalAlignment(SwingConstants.LEFT);
				formulario.studied_on.setCaretColor(Color.LIGHT_GRAY);
				formulario.studied_on.addMouseListener(new MouseAdapter(){
			       public void mouseClicked(MouseEvent e){
			    	   formulario.studied_on.setText("");
		           }
		       });
				formulario.studied_on.setBorder(null);
				formulario.studied_on.setBackground(Color.LIGHT_GRAY);
				formulario.studied_on.setBounds(182, 210, 361, 20);
				frame.getContentPane().add(formulario.studied_on);
				formulario.studied_on.setColumns(10);
				
				formulario.study_init = new JTextField("Init");
				formulario.study_init.setFont(new Font("OCR A Extended", Font.PLAIN, 12));
				formulario.study_init.setHorizontalAlignment(SwingConstants.LEFT);
				formulario.study_init.setCaretColor(Color.LIGHT_GRAY);
				formulario.study_init.addMouseListener(new MouseAdapter(){
			       public void mouseClicked(MouseEvent e){
			    	   formulario.study_init.setText("");
		           }
		       });
				formulario.study_init.setBorder(null);
				formulario.study_init.setBackground(Color.LIGHT_GRAY);
				formulario.study_init.setBounds(137, 250, 100, 20);
				frame.getContentPane().add(formulario.study_init);
				formulario.study_init.setColumns(10);
				
				 formulario.study_end = new JTextField("End");
				 formulario.study_end.setFont(new Font("OCR A Extended", Font.PLAIN, 12));
				 formulario.study_end.setHorizontalAlignment(SwingConstants.LEFT);
				 formulario.study_end.setCaretColor(Color.LIGHT_GRAY);
				 formulario.study_end.addMouseListener(new MouseAdapter(){
			       public void mouseClicked(MouseEvent e){
			    	   formulario.study_end.setText("");
		           }
		       });
				 formulario.study_end.setBorder(null);
				 formulario.study_end.setBackground(Color.LIGHT_GRAY);
				 formulario.study_end.setColumns(10);
				 formulario.study_end.setBounds(297, 250, 100, 20);
				 frame.getContentPane().add(formulario.study_end);
				
				JLabel Work = new JLabel("");
				Work.setBounds(566, 166, 473, 128);
				ImageIcon WK1 = new ImageIcon("Swing/FILL_MU_EASYCV_WE_0003_Group-1.png");
				Image WK = WK1.getImage();
				Image resizeImgWK = WK.getScaledInstance(Work.getWidth(), Work.getHeight(), Image.SCALE_SMOOTH);
				ImageIcon imageWK = new ImageIcon(resizeImgWK);
				Work.setIcon(imageWK);
				frame.getContentPane().add(Work);
				frame.setVisible(true);
				
				formulario.work_on = new JTextField("Place Here your Work Place");
				formulario.work_on.setFont(new Font("OCR A Extended", Font.PLAIN, 14));
				formulario.work_on.setHorizontalAlignment(SwingConstants.CENTER);
				formulario.work_on.setCaretColor(Color.LIGHT_GRAY);
				formulario.work_on.addMouseListener(new MouseAdapter(){
			       public void mouseClicked(MouseEvent e){
			    	   formulario.work_on.setText("");
		           }
		       });
				formulario.work_on.setBorder(null);
				formulario.work_on.setBackground(Color.LIGHT_GRAY);
				formulario.work_on.setColumns(10);
				formulario.work_on.setBounds(676, 210, 327, 20);
				frame.getContentPane().add(formulario.work_on);
				
				formulario.work_init = new JTextField("Init");
				formulario.work_init.setFont(new Font("OCR A Extended", Font.PLAIN, 12));
				formulario.work_init.setHorizontalAlignment(SwingConstants.LEFT);
				formulario.work_init.setCaretColor(Color.LIGHT_GRAY);
				formulario.work_init.addMouseListener(new MouseAdapter(){
			       public void mouseClicked(MouseEvent e){
			    	   formulario.work_init.setText("");
		           }
		       });
				formulario.work_init.setBorder(null);
				formulario.work_init.setBackground(Color.LIGHT_GRAY);
				formulario.work_init.setColumns(10);
				formulario.work_init.setBounds(650, 250, 77, 20);
				frame.getContentPane().add(formulario.work_init);
				
				formulario.work_end = new JTextField("End");
				formulario.work_end.setFont(new Font("OCR A Extended", Font.PLAIN, 12));
				formulario.work_end.setHorizontalAlignment(SwingConstants.LEFT);
				formulario.work_end.setCaretColor(Color.LIGHT_GRAY);
				formulario.work_end.addMouseListener(new MouseAdapter(){
			       public void mouseClicked(MouseEvent e){
			    	   formulario.work_end.setText("");
		           }
		       });
				formulario.work_end.setBorder(null);
				formulario.work_end.setBackground(Color.LIGHT_GRAY);
				formulario.work_end.setColumns(10);
				formulario.work_end.setBounds(795, 250, 77, 20);
				frame.getContentPane().add(formulario.work_end);
				
				JButton save = new JButton("");
				save.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						formulario.studied= formulario.studied_on.getText();
						System.out.println(formulario.studied);
						formulario.studied_beggin= formulario.study_init.getText();
						System.out.println(formulario.studied_beggin);
						formulario.studied_end= formulario.study_end.getText();
						formulario.worked= formulario.work_on.getText();
						formulario.worked_beggin= formulario.work_init.getText();
						formulario.worked_end= formulario.work_end.getText();
						try {
							form.createlog(utilizador, formulario,2 );
							form.filllabels(4, utilizador, formulario);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} 
					      
					   
					}
				});
				save.setBounds(789, 490, 250, 47);
				ImageIcon Sh = new ImageIcon("Swing/FILL_MU_EASYCV_Ready_0003_Share.png");
				Image imgSH = Sh.getImage();
				Image resizeImgSH = imgSH.getScaledInstance(save.getWidth(), save.getHeight(), Image.SCALE_SMOOTH);
				ImageIcon imageSH = new ImageIcon(resizeImgSH);
				save.setIcon(imageSH);
				save.setOpaque(false);
				save.setContentAreaFilled(false);
				save.setBorderPainted(false);
				frame.getContentPane().add(save);
				
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
				
				//////////////////////////
				JLabel lblNewLabel_1 = new JLabel("");
				lblNewLabel_1.setBounds(18, 32, 865, 71);
				ImageIcon cabe = new ImageIcon("Swing/FILL_MU_EASYCV_PI_0014_UI.png");
				Image imgcabe = cabe.getImage();
				Image resizeImgbk = imgcabe.getScaledInstance(lblNewLabel_1.getWidth(), lblNewLabel_1.getHeight(), Image.SCALE_SMOOTH);
				ImageIcon imagebk = new ImageIcon(resizeImgbk);
				lblNewLabel_1.setIcon(imagebk);
				frame.getContentPane().add(lblNewLabel_1);
				frame.setVisible(true);
				
				JLabel BK = new JLabel("");
				BK.setBounds(-32, 0, 1096, 720);
				ImageIcon BK1 = new ImageIcon("Swing/FILL_MU_EASYCV_PI_0015_#2e3131.jpg");
				BK.setIcon(new ImageIcon("Swing/FILL_MU_EASYCV_PI_0015_#2e3131.png"));
				frame.getContentPane().add(BK);
				form.filllabels(4, utilizador, formulario);
				
	}
}
