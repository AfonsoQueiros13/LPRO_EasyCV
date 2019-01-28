package graphical_interface;

import javax.swing.*;
import java.io.*;
import java.awt.*;
import logic.form;
import logic.template;
import logic.user;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;

/**
 * Date: Jan 03-2019
 * This is a class that creates the "ChooseTemplatePage" layout and actions
 * @author nunonogueira, joaoneves, josemiguel, afonsoqueiros
 * @version 1.0
 */
public class ChooseTemplatePage {
	
	/**
	 * Initialize values
	 */
	int set = 0;
	JFrame frame;
	
	/**
	 * Constructor of the ChooseTemplatePage class
	 * @param utilizador
	 */
	public ChooseTemplatePage(user utilizador, form formulario,template template_obj) {
		choosetemp_swing(utilizador,formulario,template_obj);
	}

	/**
	 * Contains the layout and the events from the class
	 * @param utilizador
	 */
	private void choosetemp_swing(user utilizador,form formulario, template template_obj) {
		
		frame = new JFrame();
		frame.setSize(1080,720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel template1 = new JLabel("");
		template1.setBounds(270, 178, 175, 274);
		template1.setBorder(BorderFactory.createLineBorder(Color.gray,3)); ;

		frame.getContentPane().add(template1);
		
		JLabel template2 = new JLabel("");
		template2.setBounds(457, 178, 185, 274);
		template2.setBorder(new LineBorder(Color.RED, 5)); ;
		frame.getContentPane().add(template2);
		
		JLabel template3 = new JLabel("");
		template3.setBounds(654, 178, 185, 274);
		frame.getContentPane().add(template3);
		template3.setBorder(BorderFactory.createLineBorder(Color.gray,3)); ;
		
		
		JButton return_button = new JButton("");
		return_button.setBounds(25, 44, 141, 41);
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
		 * Creates action to return_button JButton
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
		return_button.addMouseListener(
		/**
		 * Chnages mouse arrow
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
		
		
		JButton choose = new JButton("");
		choose.addActionListener(
		/**
		 * Creates action to choose JButton
		 *
		 */
		new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				try {
					frame.dispose();
					QuestionsPage1_PI questions;
					questions = new QuestionsPage1_PI(utilizador,formulario,template_obj);
					questions.frame.setVisible(true);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				
			}

		});
		choose.setBounds(414, 599, 269, 50);
		ImageIcon CHO  = new ImageIcon("Swing/FILL_MU_EASYCV_Template_0003_choose.png");
		Image imgCHO = CHO.getImage();
		Image resizeImgCHO = imgCHO.getScaledInstance(choose.getWidth(), choose.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon imageCHO = new ImageIcon(resizeImgCHO);
		choose.setIcon(imageCHO);
		choose.setOpaque(false);
		choose.setContentAreaFilled(false);
		choose.setBorderPainted(false);
		frame.getContentPane().add(choose);
		
		choose.addMouseListener(
		/**
		 * Changes mouse arrow
		 *
		 */
		new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				choose.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				choose.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
		
			template1.setIcon(new ImageIcon("Swing/template1.PNG"));
			template2.setIcon(new ImageIcon("Swing/template2.JPG"));
			template3.setIcon(new ImageIcon("Swing/template3.JPG"));
		    formulario.i++;
		
		
		JButton right = new JButton("");
		right.setBounds(913, 269, 65, 105);
		ImageIcon RIGHT  = new ImageIcon("Swing/FILL_MU_EASYCV_Template_0000_direita.png");
		Image imgRIGHT = RIGHT.getImage();
		Image resizeImgRIGHT = imgRIGHT.getScaledInstance(right.getWidth(), right.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon imageRIGHT = new ImageIcon(resizeImgRIGHT);
		right.setIcon(imageRIGHT);
		right.setOpaque(false);
		right.setContentAreaFilled(false);
		right.setBorderPainted(false);
		frame.getContentPane().add(right);
		
		
		right.addActionListener(
		/**
		 * Creates action to change between template by clicking in the right JButton
		 *
		 */
		new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {		
				formulario.i=formulario.i-1;
				if(formulario.i==-1){
					formulario.i=2;
					
				}
				switch (formulario.i) { 
				case 0:
					template1.setIcon(new ImageIcon("Swing/template2.JPG"));
					template2.setIcon(new ImageIcon("Swing/template3.JPG"));
					template3.setIcon(new ImageIcon("Swing/template1.PNG"));
					formulario.i=3;
					break;
				case 1:
					template1.setIcon(new ImageIcon("Swing/template1.PNG"));
					template2.setIcon(new ImageIcon("Swing/template2.JPG"));
					template3.setIcon(new ImageIcon("Swing/template3.JPG"));
					break;
				case 2:
					template1.setIcon(new ImageIcon("Swing/template3.JPG"));
					template2.setIcon(new ImageIcon("Swing/template1.PNG"));
					template3.setIcon(new ImageIcon("Swing/template2.JPG"));
					break;
				case 3:
					template1.setIcon(new ImageIcon("Swing/template2.JPG"));
					template2.setIcon(new ImageIcon("Swing/template3.JPG"));
					template3.setIcon(new ImageIcon("Swing/template1.PNG"));
					break;
				}
				
				
				
			}

		});
		right.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				right.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				right.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
		
		JButton left = new JButton("");
		left.setBounds(128, 281, 65, 105);
		ImageIcon LEFT  = new ImageIcon("Swing/FILL_MU_EASYCV_Template_0001_esquerda.png");
		Image imgLEFT = LEFT.getImage();
		Image resizeImgLEFT = imgLEFT.getScaledInstance(left.getWidth(), left.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon imageLEFT = new ImageIcon(resizeImgLEFT);
		left.setIcon(imageLEFT);
		left.setOpaque(false);
		left.setContentAreaFilled(false);
		left.setBorderPainted(false);
		frame.getContentPane().add(left);
		
		left.addActionListener(
				/**
				 * Creates action to change between template by clicking in the left JButton
				 *
				 */
		new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				formulario.i=formulario.i+1;
				if(formulario.i==4)
					formulario.i=1;
						
				switch (formulario.i) {
				case 1: 
					template1.setIcon(new ImageIcon("Swing/template1.PNG"));
					template2.setIcon(new ImageIcon("Swing/template2.JPG"));
					template3.setIcon(new ImageIcon("Swing/template3.JPG"));
					break;
				case 2:
					template1.setIcon(new ImageIcon("Swing/template3.JPG"));
					template2.setIcon(new ImageIcon("Swing/template1.PNG"));
					template3.setIcon(new ImageIcon("Swing/template2.JPG"));
					break;
				case 3:
					template1.setIcon(new ImageIcon("Swing/template2.JPG"));
					template2.setIcon(new ImageIcon("Swing/template3.JPG"));
					template3.setIcon(new ImageIcon("Swing/template1.PNG"));
					break;
				}
			}
		});
		left.addMouseListener(
		/**
		 * Changes mouse arrow 
		 *
		 */
		new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				left.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				left.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
		
		JLabel choosetemp = new JLabel("");
		choosetemp.setIcon(new ImageIcon("Swing/FILL_MU_EASYCV_PI_0015_#2e3131.png"));
		choosetemp.setBounds(0, -23, 1080, 721);
		frame.getContentPane().add(choosetemp);
		
		
	}
}
