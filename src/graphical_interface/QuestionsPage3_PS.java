package graphical_interface;

import java.awt.Color;
import java.awt.Cursor;
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

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import logic.form;
import logic.template;
import logic.user;
import javax.swing.JRadioButton;
import javax.swing.text.View;
@SuppressWarnings("all")
/**
 * Date: Jan 03-2019
 * This is a class that creates the "QuestionsPage3_PS" layout and actions
 * @author nunonogueira, joaoneves, josemiguel, afonsoqueiros
 * @version 1.0
 */

public class QuestionsPage3_PS {
	
	/**
	 * Initialize values
	 */
	JFrame frame;
	public JRadioButton PL_1;
	public JRadioButton PL_2;
	public JRadioButton PL_3;
	public JRadioButton PL_4;
	public JRadioButton PL_5;
	public JRadioButton SL_1;
	public JRadioButton SL_2;
	public JRadioButton SL_3;
	public JRadioButton SL_4;
	public JRadioButton SL_5;
	public JRadioButton DS_1;
	public JRadioButton DS_2;
	public JRadioButton DS_3;
	public JRadioButton DS_4;
	public JRadioButton DS_5;
	public JRadioButton CS_1;
	public JRadioButton CS_2;
	public JRadioButton CS_3;
	public JRadioButton CS_4;
	public JRadioButton CS_5;
	public JRadioButton MS_1;
	public JRadioButton MS_2;
	public JRadioButton MS_3;
	public JRadioButton MS_4;
	public JRadioButton MS_5;
	private JLabel lblNewLabel;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;

	
	/**
	 * Constructor of the QuestionsPage3_PS class
	 * @param utilizador
	 * @throws IOException
	 */
	public QuestionsPage3_PS(user utilizador,form formulario,template template_obj) throws IOException
	{
		questionspage3_swing(utilizador,formulario,template_obj);
	}
	
	/**
	 * Creates layout and actions of the QuestionsPage3_PS class
	 * @param utilizador
	 * @throws IOException
	 */
	public void questionspage3_swing(user utilizador, form formulario, template template_obj) throws IOException
	{
				frame = new JFrame ("EasyCV");
				frame.setSize(1080, 720);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
				File log= new File("logs/log_PS_"+user.username+".txt");
				if(log.exists())
					form.fillradiobuttons(utilizador,formulario);
				
				JButton PI = new JButton("");
				PI.setBounds(46, 548, 226, 47);
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
				PI.addMouseListener(
				/**
				 * Change arrow mouse
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
				PI.setBackground(Color.DARK_GRAY);
				//RESIZE RESOLUTION
				ImageIcon PI1 = new ImageIcon("Swing/FILL_MU_EASYCV_WE_0005_PERSONALINFO.png");
				Image imgPI = PI1.getImage();
				Image resizeImgPI = imgPI.getScaledInstance(PI.getWidth(), PI.getHeight(), Image.SCALE_SMOOTH);
				ImageIcon imagePI = new ImageIcon(resizeImgPI);
				frame.getContentPane().setLayout(null);
				PI.setIcon(imagePI);
				PI.setOpaque(false);
				PI.setContentAreaFilled(false);
				PI.setBorderPainted(false);
				frame.getContentPane().add(PI);
				
				
				JButton WE = new JButton("");
				WE.setBounds(46, 607, 305, 47);
				WE.addActionListener(
				/**
				 * Creates action to show questions2.frame, setting it visible.
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
				PS.setBounds(285, 548, 237, 47);
				PS.setBackground(Color.DARK_GRAY);
				//RESIZE RESOLUTION
				ImageIcon PS1 = new ImageIcon("Swing/FILL_MU_EASYCV_PS_0001_ps.png");
				Image imgPS = PS1.getImage();
				Image resizeImgPS = imgPS.getScaledInstance(PS.getWidth(), PS.getHeight(), Image.SCALE_SMOOTH);
				ImageIcon imagePS = new ImageIcon(resizeImgPS);
				PS.setIcon(imagePS);
				PS.setOpaque(false);
				PS.setContentAreaFilled(false);
				PS.setBorderPainted(false);
				frame.getContentPane().add(PS);
				
				
				JButton SL = new JButton("");
				SL.setBounds(364, 607, 214, 47);
				SL.addActionListener(
				/**
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
				WD.setBounds(795, 548, 244, 106);
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
				Return.setBounds(18, 32, 175, 47);
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
							e1.printStackTrace();
						}
						
					}
				});
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
							
				PL_1 = new JRadioButton("");
				if(form.pl.equals("1"))
					PL_1.setSelected(true);
				PL_1.addActionListener(
				/**
				 * Creates an action that removes selection from other unselected buttons
				 *
				 */
				new ActionListener() {
			        @Override
			        public void actionPerformed(ActionEvent e) {
					PL_2.setSelected(false);
					PL_3.setSelected(false);
					PL_4.setSelected(false);
					PL_5.setSelected(false);
					formulario.pl="1";
					//System.out.println("ola");
			        }
			    });

				
				//PL_1.setVisibility(View.GONE);
				PL_1.setBounds(704, 165, 21, 23);
				PL_1.setOpaque(false);
				PL_1.setContentAreaFilled(false);
				PL_1.setBorderPainted(false);
				PL_1.setOpaque(false);
				PL_1.setContentAreaFilled(false);
				PL_1.setBorderPainted(false);
				frame.getContentPane().add(PL_1);
				
				
				
				PL_2 = new JRadioButton("New radio button");
				if(form.pl.equals("2"))
					PL_2.setSelected(true);
				PL_2.addActionListener(
						/**
						 * Creates an action that removes selection from other unselected buttons
						 *
						 */
				new ActionListener() {
			        @Override
			        public void actionPerformed(ActionEvent e) {
					PL_1.setSelected(false);
					PL_3.setSelected(false);
					PL_4.setSelected(false);
					PL_5.setSelected(false);	
					formulario.pl="2";
				}
			    });
				//PL_2.setVisible(false);
				PL_2.setBounds(745, 165, 21, 23);
				PL_2.setOpaque(false);
				PL_2.setContentAreaFilled(false);
				PL_2.setBorderPainted(false);
				PL_2.setOpaque(false);
				PL_2.setContentAreaFilled(false);
				PL_2.setBorderPainted(false);
				frame.getContentPane().add(PL_2);
				
				PL_3 = new JRadioButton("");
				if(form.pl.equals("3"))
					PL_3.setSelected(true);
				PL_3.addActionListener(
						/**
						 * Creates an action that removes selection from other unselected buttons
						 *
						 */
						new ActionListener() {
			        @Override
			        public void actionPerformed(ActionEvent e) {
					PL_2.setSelected(false);
					PL_1.setSelected(false);
					PL_4.setSelected(false);
					PL_5.setSelected(false);
					formulario.pl="3";
					
				}
			        });
			        
				PL_3.setBounds(786, 165, 21, 23);
				PL_3.setOpaque(false);
				PL_3.setContentAreaFilled(false);
				PL_3.setBorderPainted(false);
				PL_3.setOpaque(false);
				PL_3.setContentAreaFilled(false);
				PL_3.setBorderPainted(false);
				frame.getContentPane().add(PL_3);
				
				PL_4 = new JRadioButton("");
				if(form.pl.equals("4"))
					PL_4.setSelected(true);
				PL_4.addActionListener(
						/**
						 * Creates an action that removes selection from other unselected buttons
						 *
						 */
				new ActionListener() {
			        @Override
			        public void actionPerformed(ActionEvent e) {
					PL_2.setSelected(false);
					PL_1.setSelected(false);
					PL_3.setSelected(false);
					PL_5.setSelected(false);
					formulario.pl="4";
					
				}
			        });
				PL_4.setBounds(828, 165, 21, 23);
				PL_4.setOpaque(false);
				PL_4.setContentAreaFilled(false);
				PL_4.setBorderPainted(false);
				PL_4.setOpaque(false);
				PL_4.setContentAreaFilled(false);
				PL_4.setBorderPainted(false);
				frame.getContentPane().add(PL_4);
				
				PL_5 = new JRadioButton("");
				if(form.pl.equals("5"))
					PL_5.setSelected(true);
				PL_5.addActionListener(/**
						 * Creates an action that removes selection from other unselected buttons
						 *
						 */
				new ActionListener() {
			        @Override
			        public void actionPerformed(ActionEvent e) {
					PL_2.setSelected(false);
					PL_1.setSelected(false);
					PL_4.setSelected(false);
					PL_3.setSelected(false);
					formulario.pl="5";
					
				}
			        });
				PL_5.setBounds(872, 165, 21, 23);
				PL_5.setOpaque(false);
				PL_5.setContentAreaFilled(false);
				PL_5.setBorderPainted(false);
				PL_5.setOpaque(false);
				PL_5.setContentAreaFilled(false);
				PL_5.setBorderPainted(false);
				frame.getContentPane().add(PL_5);
				
				SL_1 = new JRadioButton("");
				if(form.sl.equals("1"))
					SL_1.setSelected(true);
				SL_1.addActionListener(
						/**
						 * Creates an action that removes selection from other unselected buttons
						 *
						 */
				new ActionListener() {
			        @Override
			        public void actionPerformed(ActionEvent e) {
					SL_2.setSelected(false);
					SL_3.setSelected(false);
					SL_4.setSelected(false);
					SL_5.setSelected(false);
					formulario.sl="1";
					
				}
			        });
				SL_1.setBounds(704, 240, 21, 23);
				SL_1.setOpaque(false);
				SL_1.setContentAreaFilled(false);
				SL_1.setBorderPainted(false);
				SL_1.setOpaque(false);
				SL_1.setContentAreaFilled(false);
				SL_1.setBorderPainted(false);
				frame.getContentPane().add(SL_1);
				
				SL_2 = new JRadioButton("");
				if(form.sl.equals("2"))
					SL_2.setSelected(true);
				SL_2.addActionListener(/**
						 * Creates an action that removes selection from other unselected buttons
						 *
						 */
				new ActionListener() {
			        @Override
			        public void actionPerformed(ActionEvent e) {
					SL_1.setSelected(false);
					SL_3.setSelected(false);
					SL_4.setSelected(false);
					SL_5.setSelected(false);
					formulario.sl="2";
					
				}
			        });
				SL_2.setBounds(745, 240, 21, 23);
				SL_2.setOpaque(false);
				SL_2.setContentAreaFilled(false);
				SL_2.setBorderPainted(false);
				SL_2.setOpaque(false);
				SL_2.setContentAreaFilled(false);
				SL_2.setBorderPainted(false);
				frame.getContentPane().add(SL_2);
				
				SL_3 = new JRadioButton("");
				if(form.sl.equals("3"))
					SL_3.setSelected(true);
				SL_3.addActionListener(/**
						 * Creates an action that removes selection from other unselected buttons
						 *
						 */
				new ActionListener() {
			        @Override
			        public void actionPerformed(ActionEvent e) {
					SL_2.setSelected(false);
					SL_1.setSelected(false);
					SL_4.setSelected(false);
					SL_5.setSelected(false);
					formulario.sl="3";
					
				}
			        });
				SL_3.setBounds(788, 240, 28, 23);
				SL_3.setOpaque(false);
				SL_3.setContentAreaFilled(false);
				SL_3.setBorderPainted(false);
				SL_3.setOpaque(false);
				SL_3.setContentAreaFilled(false);
				SL_3.setBorderPainted(false);
				frame.getContentPane().add(SL_3);
				
				SL_4 = new JRadioButton("");
				if(form.sl.equals("4"))
					SL_4.setSelected(true);
				SL_4.addActionListener(/**
						 * Creates an action that removes selection from other unselected buttons
						 *
						 */
				new ActionListener() {
			        @Override
			        public void actionPerformed(ActionEvent e) {
					SL_2.setSelected(false);
					SL_3.setSelected(false);
					SL_1.setSelected(false);
					SL_5.setSelected(false);
					formulario.sl="4";
					
				}
			        });
				SL_4.setBounds(828, 240, 21, 23);
				SL_4.setOpaque(false);
				SL_4.setContentAreaFilled(false);
				SL_4.setBorderPainted(false);
				SL_4.setOpaque(false);
				SL_4.setContentAreaFilled(false);
				SL_4.setBorderPainted(false);
				frame.getContentPane().add(SL_4);
				
				SL_5 = new JRadioButton("");
				if(form.sl.equals("5"))
					SL_5.setSelected(true);
				SL_5.addActionListener(/**
						 * Creates an action that removes selection from other unselected buttons
						 *
						 */
				new ActionListener() {
			        @Override
			        public void actionPerformed(ActionEvent e) {
					SL_2.setSelected(false);
					SL_3.setSelected(false);
					SL_4.setSelected(false);
					SL_1.setSelected(false);
					formulario.sl="5";
					
				}
			        });
				SL_5.setBounds(872, 240, 21, 23);
				SL_5.setOpaque(false);
				SL_5.setContentAreaFilled(false);
				SL_5.setBorderPainted(false);
				SL_5.setOpaque(false);
				SL_5.setContentAreaFilled(false);
				SL_5.setBorderPainted(false);
				frame.getContentPane().add(SL_5);
				
				CS_1 = new JRadioButton("");
				if(form.cs.equals("1"))
					CS_1.setSelected(true);
				CS_1.addActionListener(/**
						 * Creates an action that removes selection from other unselected buttons
						 *
						 */
				new ActionListener() {
			        @Override
			        public void actionPerformed(ActionEvent e) {
			        CS_2.setSelected(false);
			        CS_3.setSelected(false);
			        CS_4.setSelected(false);
			        CS_5.setSelected(false);
			        formulario.cs="1";
					
				}
			        });
				CS_1.setBounds(704, 315, 21, 23);
				CS_1.setOpaque(false);
				CS_1.setContentAreaFilled(false);
				CS_1.setBorderPainted(false);
				CS_1.setOpaque(false);
				CS_1.setContentAreaFilled(false);
				CS_1.setBorderPainted(false);
				frame.getContentPane().add(CS_1);
				
				CS_2 = new JRadioButton("");
				if(form.cs.equals("2"))
					CS_2.setSelected(true);
				CS_2.addActionListener(/**
						 * Creates an action that removes selection from other unselected buttons
						 *
						 */
				new ActionListener() {
			        @Override
			        public void actionPerformed(ActionEvent e) {
			        CS_1.setSelected(false);
			        CS_3.setSelected(false);
			        CS_4.setSelected(false);
			        CS_5.setSelected(false);
			        formulario.cs="2";
					
				}
			        });
				CS_2.setBounds(745, 315, 21, 23);
				CS_2.setOpaque(false);
				CS_2.setContentAreaFilled(false);
				CS_2.setBorderPainted(false);
				CS_2.setOpaque(false);
				CS_2.setContentAreaFilled(false);
				CS_2.setBorderPainted(false);
				frame.getContentPane().add(CS_2);
				
				CS_3 = new JRadioButton("");
				if(form.cs.equals("3"))
					CS_3.setSelected(true);
				CS_3.addActionListener(/**
						 * Creates an action that removes selection from other unselected buttons
						 *
						 */
				new ActionListener() {
			        @Override
			        public void actionPerformed(ActionEvent e) {
			        CS_2.setSelected(false);
			        CS_1.setSelected(false);
			        CS_4.setSelected(false);
			        CS_5.setSelected(false);
			        formulario.cs="3";
					
				}
			        });
				CS_3.setBounds(786, 315, 30, 23);
				CS_3.setOpaque(false);
				CS_3.setContentAreaFilled(false);
				CS_3.setBorderPainted(false);
				CS_3.setOpaque(false);
				CS_3.setContentAreaFilled(false);
				CS_3.setBorderPainted(false);
				frame.getContentPane().add(CS_3);
				
				CS_4 = new JRadioButton("");
				if(form.cs.equals("4"))
					CS_4.setSelected(true);
				CS_4.addActionListener(/**
						 * Creates an action that removes selection from other unselected buttons
						 *
						 */
				new ActionListener() {
			        @Override
			        public void actionPerformed(ActionEvent e) {
			        CS_2.setSelected(false);
			        CS_3.setSelected(false);
			        CS_1.setSelected(false);
			        CS_5.setSelected(false);
			        formulario.cs="4";
					
				}
			        });
				CS_4.setBounds(828, 315, 28, 23);
				CS_4.setOpaque(false);
				CS_4.setContentAreaFilled(false);
				CS_4.setBorderPainted(false);
				CS_4.setOpaque(false);
				CS_4.setContentAreaFilled(false);
				CS_4.setBorderPainted(false);
				frame.getContentPane().add(CS_4);
				
				CS_5 = new JRadioButton("");
				if(form.cs.equals("5"))
					CS_5.setSelected(true);
				CS_5.addActionListener(/**
						 * Creates an action that removes selection from other unselected buttons
						 *
						 */
				new ActionListener() {
			        @Override
			        public void actionPerformed(ActionEvent e) {
			        CS_2.setSelected(false);
			        CS_3.setSelected(false);
			        CS_4.setSelected(false);
			        CS_1.setSelected(false);
			        formulario.cs="5";
					
				}
			        });
				CS_5.setBounds(872, 315, 21, 23);
				CS_5.setOpaque(false);
				CS_5.setContentAreaFilled(false);
				CS_5.setBorderPainted(false);
				CS_5.setOpaque(false);
				CS_5.setContentAreaFilled(false);
				CS_5.setBorderPainted(false);
				frame.getContentPane().add(CS_5);
				
				DS_1 = new JRadioButton("");
				if(form.ds.equals("1"))
					DS_1.setSelected(true);
				DS_1.addActionListener(/**
						 * Creates an action that removes selection from other unselected buttons
						 *
						 */
				new ActionListener() {
			        @Override
			        public void actionPerformed(ActionEvent e) {
			        DS_2.setSelected(false);
			        DS_3.setSelected(false);
			        DS_4.setSelected(false);
			        DS_5.setSelected(false);
			        formulario.ds="1";
					
				}
			        });
				DS_1.setBounds(704, 392, 21, 23);
				DS_1.setOpaque(false);
				DS_1.setContentAreaFilled(false);
				DS_1.setBorderPainted(false);
				DS_1.setOpaque(false);
				DS_1.setContentAreaFilled(false);
				DS_1.setBorderPainted(false);
				frame.getContentPane().add(DS_1);
				
				DS_2 = new JRadioButton("");
				if(form.ds.equals("2"))
					DS_2.setSelected(true);
				DS_2.addActionListener(/**
						 * Creates an action that removes selection from other unselected buttons
						 *
						 */
				new ActionListener() {
			        @Override
			        public void actionPerformed(ActionEvent e) {
			        DS_1.setSelected(false);
			        DS_3.setSelected(false);
			        DS_4.setSelected(false);
			        DS_5.setSelected(false);
			        formulario.ds="2";
					
				}
			        });
				DS_2.setBounds(745, 392, 21, 23);
				DS_2.setOpaque(false);
				DS_2.setContentAreaFilled(false);
				DS_2.setBorderPainted(false);
				DS_2.setOpaque(false);
				DS_2.setContentAreaFilled(false);
				DS_2.setBorderPainted(false);
				frame.getContentPane().add(DS_2);
				
				DS_3 = new JRadioButton("");
				if(form.ds.equals("3"))
					DS_3.setSelected(true);
				DS_3.addActionListener(/**
						 * Creates an action that removes selection from other unselected buttons
						 *
						 */
				new ActionListener() {
			        @Override
			        public void actionPerformed(ActionEvent e) {
			        DS_2.setSelected(false);
			        DS_1.setSelected(false);
			        DS_4.setSelected(false);
			        DS_5.setSelected(false);
			        formulario.ds="3";
					
				}
			        });
				DS_3.setBounds(786, 392, 21, 23);
				DS_3.setOpaque(false);
				DS_3.setContentAreaFilled(false);
				DS_3.setBorderPainted(false);
				DS_3.setOpaque(false);
				DS_3.setContentAreaFilled(false);
				DS_3.setBorderPainted(false);
				frame.getContentPane().add(DS_3);
				
				DS_4 = new JRadioButton("");
				if(form.ds.equals("4"))
					DS_4.setSelected(true);
				DS_4.addActionListener(/**
						 * Creates an action that removes selection from other unselected buttons
						 *
						 */
				new ActionListener() {
			        @Override
			        public void actionPerformed(ActionEvent e) {
			        DS_2.setSelected(false);
			        DS_3.setSelected(false);
			        DS_1.setSelected(false);
			        DS_5.setSelected(false);
			        formulario.ds="4";
					
				}
			        });
				DS_4.setBounds(828, 392, 21, 23);
				DS_4.setOpaque(false);
				DS_4.setContentAreaFilled(false);
				DS_4.setBorderPainted(false);
				DS_4.setOpaque(false);
				DS_4.setContentAreaFilled(false);
				DS_4.setBorderPainted(false);
				frame.getContentPane().add(DS_4);
				
				DS_5 = new JRadioButton("");
				if(form.ds.equals("5"))
					DS_5.setSelected(true);
				DS_5.addActionListener(/**
						 * Creates an action that removes selection from other unselected buttons
						 *
						 */
				new ActionListener() {
			        @Override
			        public void actionPerformed(ActionEvent e) {
			        DS_2.setSelected(false);
			        DS_3.setSelected(false);
			        DS_4.setSelected(false);
			        DS_1.setSelected(false);
			        formulario.ds="5";
					
				}
			        });
				DS_5.setBounds(872, 392, 21, 23);
				DS_5.setOpaque(false);
				DS_5.setContentAreaFilled(false);
				DS_5.setBorderPainted(false);
				DS_5.setOpaque(false);
				DS_5.setContentAreaFilled(false);
				DS_5.setBorderPainted(false);
				frame.getContentPane().add(DS_5);
				
				MS_1 = new JRadioButton("");
				if(form.ms.equals("1"))
					MS_1.setSelected(true);
				MS_1.addActionListener(/**
						 * Creates an action that removes selection from other unselected buttons
						 *
						 */
				new ActionListener() {
			        @Override
			        public void actionPerformed(ActionEvent e) {
			        MS_2.setSelected(false);
			        MS_3.setSelected(false);
			        MS_4.setSelected(false);
			        MS_5.setSelected(false);
			        formulario.ms="1";
					
				}
			        });
				
				MS_1.setBounds(704, 462, 21, 23);
				MS_1.setOpaque(false);
				MS_1.setContentAreaFilled(false);
				MS_1.setBorderPainted(false);
				MS_1.setOpaque(false);
				MS_1.setContentAreaFilled(false);
				MS_1.setBorderPainted(false);
				frame.getContentPane().add(MS_1);
				
				MS_2 = new JRadioButton("");
				if(form.ms.equals("2"))
					MS_2.setSelected(true);
				MS_2.addActionListener(/**
						 * Creates an action that removes selection from other unselected buttons
						 *
						 */
				new ActionListener() {
			        @Override
			        public void actionPerformed(ActionEvent e) {
			        MS_1.setSelected(false);
			        MS_3.setSelected(false);
			        MS_4.setSelected(false);
			        MS_5.setSelected(false);
			        formulario.ms="2";
					
				}
			        });
				MS_2.setBounds(745, 462, 21, 23);
				MS_2.setOpaque(false);
				MS_2.setContentAreaFilled(false);
				MS_2.setBorderPainted(false);
				MS_2.setOpaque(false);
				MS_2.setContentAreaFilled(false);
				MS_2.setBorderPainted(false);
				frame.getContentPane().add(MS_2);
				
				MS_3 = new JRadioButton("");
				if(form.ms.equals("3"))
					MS_3.setSelected(true);
				MS_3.addActionListener(/**
						 * Creates an action that removes selection from other unselected buttons
						 *
						 */
				new ActionListener() {
			        @Override
			        public void actionPerformed(ActionEvent e) {
			        MS_2.setSelected(false);
			        MS_1.setSelected(false);
			        MS_4.setSelected(false);
			        MS_5.setSelected(false);
			        formulario.ms="3";
					
				}
			        });
				MS_3.setBounds(786, 462, 21, 23);
				MS_3.setOpaque(false);
				MS_3.setContentAreaFilled(false);
				MS_3.setBorderPainted(false);
				MS_3.setOpaque(false);
				MS_3.setContentAreaFilled(false);
				MS_3.setBorderPainted(false);
				frame.getContentPane().add(MS_3);
				
			    MS_4 = new JRadioButton("");
			    if(form.ms.equals("4"))
					MS_4.setSelected(true);
				MS_4.addActionListener(/**
						 * Creates an action that removes selection from other unselected buttons
						 *
						 */
				new ActionListener() {
			        @Override
			        public void actionPerformed(ActionEvent e) {
			        MS_2.setSelected(false);
			        MS_3.setSelected(false);
			        MS_1.setSelected(false);
			        MS_5.setSelected(false);
			        formulario.ms="4";
					
				}
			        });
				MS_4.setBounds(828, 462, 21, 23);
				MS_4.setOpaque(false);
				MS_4.setContentAreaFilled(false);
				MS_4.setBorderPainted(false);
				MS_4.setOpaque(false);
				MS_4.setContentAreaFilled(false);
				MS_4.setBorderPainted(false);
				frame.getContentPane().add(MS_4);
				
				MS_5 = new JRadioButton("");
				if(form.ms.equals("5"))
					MS_5.setSelected(true);
				MS_5.addActionListener(/**
						 * Creates an action that removes selection from other unselected buttons
						 *
						 */
				new ActionListener() {
			        @Override
			        public void actionPerformed(ActionEvent e) {
			        MS_2.setSelected(false);
			        MS_3.setSelected(false);
			        MS_4.setSelected(false);
			        MS_1.setSelected(false);
			        formulario.ms="5";
					
				}
			        });
				MS_5.setBounds(872, 462, 21, 23);
				MS_5.setOpaque(false);
				MS_5.setContentAreaFilled(false);
				MS_5.setBorderPainted(false);
				MS_5.setOpaque(false);
				MS_5.setContentAreaFilled(false);
				MS_5.setBorderPainted(false);
				frame.getContentPane().add(MS_5);
				
				JLabel Lista = new JLabel("");
				Lista.setBounds(46, 130, 993, 372);
				
				JLabel lblNewLabel_1 = new JLabel("");
				lblNewLabel_1.setBounds(18, 32, 865, 71);
				ImageIcon LS1 = new ImageIcon("Swing/FILL_MU_EASYCV_PS_0000_TUDO.png");
				Image LS = LS1.getImage();
				Image resizeImgLS = LS.getScaledInstance(Lista.getWidth(), Lista.getHeight(), Image.SCALE_SMOOTH);
				ImageIcon imageLS = new ImageIcon(resizeImgLS);
				frame.setVisible(true);
				ImageIcon cabe = new ImageIcon("Swing/FILL_MU_EASYCV_PI_0014_UI.png");
				Image imgcabe = cabe.getImage();
				Image resizeImgbk = imgcabe.getScaledInstance(lblNewLabel_1.getWidth(), lblNewLabel_1.getHeight(), Image.SCALE_SMOOTH);
				ImageIcon imagebk = new ImageIcon(resizeImgbk);
				frame.setVisible(true);
				ImageIcon BK1 = new ImageIcon("Swing/FILL_MU_EASYCV_PI_0015_#2e3131.jpg");
				
				JButton save = new JButton("");
				save.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						try {
							form.createlog_PS(utilizador,formulario);
							form.createlog(utilizador, formulario,2);
							form.fillradiobuttons(utilizador, formulario);

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
				save.setBounds(896, 48, 143, 37);
				ImageIcon Sh = new ImageIcon("Swing/FILL_MU_EASYCV_Ready_0003_Share.png");
				Image imgSH = Sh.getImage();
				Image resizeImgSH = imgSH.getScaledInstance(save.getWidth(), save.getHeight(), Image.SCALE_SMOOTH);
				ImageIcon imageSH = new ImageIcon(resizeImgSH);
				save.setIcon(imageSH);
				save.setOpaque(false);
				save.setContentAreaFilled(false);
				save.setBorderPainted(false);
				frame.getContentPane().add(save);
				
				label_1 = new JLabel("New label");
				label_1.setIcon(new ImageIcon("Swing/labelgray.png"));
				label_1.setBounds(638, 315, 275, 32);
				frame.getContentPane().add(label_1);
				lblNewLabel_1.setIcon(imagebk);
				frame.getContentPane().add(lblNewLabel_1);
				
				lblNewLabel = new JLabel("New label");
				lblNewLabel.setIcon(new ImageIcon("Swing/labelgray.png"));
				lblNewLabel.setBounds(638, 156, 275, 32);
				frame.getContentPane().add(lblNewLabel);
				
				label_3 = new JLabel("New label");
				label_3.setIcon(new ImageIcon("Swing/labelgray.png"));
				label_3.setForeground(Color.LIGHT_GRAY);
				label_3.setBounds(638, 466, 275, 32);
				frame.getContentPane().add(label_3);
				
				label_2 = new JLabel("New label");
				label_2.setIcon(new ImageIcon("Swing/labelgray.png"));
				label_2.setBackground(Color.LIGHT_GRAY);
				label_2.setBounds(638, 383, 275, 32);
				frame.getContentPane().add(label_2);
				
				label = new JLabel("New label");
				label.setIcon(new ImageIcon("Swing/labelgray.png"));
				label.setBackground(Color.LIGHT_GRAY);
				label.setBounds(638, 231, 275, 32);
				frame.getContentPane().add(label);
				Lista.setIcon(imageLS);
				frame.getContentPane().add(Lista);

				JLabel BK = new JLabel("");
				BK.setBounds(0, 0, 1080, 720);
				BK.setIcon(new ImageIcon("Swing/FILL_MU_EASYCV_PI_0015_#2e3131.png"));
				frame.getContentPane().add(BK);
				form.fillradiobuttons(utilizador, formulario);			
						
	}
}
