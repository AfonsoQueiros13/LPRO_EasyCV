package graphical_interface;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Font;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.text.DefaultEditorKit;

import logic.form;
import logic.template;
import logic.user;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
@SuppressWarnings("all")
/**
 * Date: Jan 03-2019
 * This is a class that creates the "InsereDataWindow" layout and actions
 * @author nunonogueira, joaoneves, josemiguel, afonsoqueiros
 * @version 1.0
 */
public class InsereDataWindow {

	/**
	 * Initialize values 
	 */
	public JFrame frame;
	public JTextField textField;
	JCheckBox driverlicence_A=null;
	JCheckBox driverlicence_A_1=null;
	JCheckBox driverlicence_A_2=null;
	JCheckBox driverlicence_B=null;
	JCheckBox driverlicence_B_1=null;
	
	/**
	 * Constructor of the InserDataWindow class
	 * @param field
	 * @throws IOException 
	 */
	public InsereDataWindow(int field,user utilizador, form formulario,template template_obj,File cv,String string,String info) throws IOException {
		smallwindow_swing(field,utilizador, formulario,template_obj,cv,string,info);
	}

	/**
	 * Creates layout and actions of InsereDataWindow class
	 * @param field
	 * @throws IOException 
	 */
	private void smallwindow_swing(int field,user utilizador, form formulario, template template_obj,File cv,String string,String info) throws IOException {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setBackground(Color.decode("#2e3131"));
		frame.setBounds(100, 100, 587, 300);
		frame.getContentPane().setLayout(null);

		if(field==100)
			user.offline=1;
		if(field!=7) {
		textField = new JTextField();
		JPopupMenu popup = new JPopupMenu();
	    JMenuItem item = new JMenuItem(new DefaultEditorKit.CutAction());
	    item.setText("Cut");
	    popup.add(item);
	    item = new JMenuItem(new DefaultEditorKit.CopyAction());
	    item.setText("Copy");
	    popup.add(item);
	    item = new JMenuItem(new DefaultEditorKit.PasteAction());
	    item.setText("Paste");
	    popup.add(item);
	    textField.setComponentPopupMenu(popup);
		textField.setBounds(10, 115, 551, 42);
		textField.setFont(new Font("OCR A Extended", Font.PLAIN, 18));
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setCaretColor(Color.decode("#2e3131"));
		textField.setBackground(Color.decode("#2e3131"));
		textField.setForeground(Color.WHITE);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		textField.setText(info);
		textField.setBorder(null);
		}
		if(field==7) {
			form.licence_driver="";
			form.filldrivercheckboxes(utilizador,formulario);
			driverlicence_A = new JCheckBox("A");
			if(form.a.equals("1")) {
				driverlicence_A.setSelected(true);
			}
			driverlicence_A.setBounds(50, 115, 50, 50);
			driverlicence_A.setBackground(Color.decode("#2E3131"));
			driverlicence_A.setForeground(Color.WHITE);
			driverlicence_A.setOpaque(true);
			frame.getContentPane().add(driverlicence_A);
			
			driverlicence_A_1 = new JCheckBox("A1");
			if(form.a1.equals("1")) {
				driverlicence_A_1.setSelected(true);
			}
			driverlicence_A_1.setBackground(Color.decode("#2E3131"));
			driverlicence_A_1.setForeground(Color.WHITE);
			driverlicence_A_1.setOpaque(true);
			driverlicence_A_1.setBounds(150, 115, 50, 50);
			frame.getContentPane().add(driverlicence_A_1);
			
			driverlicence_A_2 = new JCheckBox("A2");
			if(form.a2.equals("1")) {
				driverlicence_A_2.setSelected(true);
			}
			driverlicence_A_2.setBackground(Color.decode("#2E3131"));
			driverlicence_A_2.setForeground(Color.WHITE);
			driverlicence_A_2.setOpaque(true);
			driverlicence_A_2.setBounds(250, 115, 50, 50);
			frame.getContentPane().add(driverlicence_A_2);
			
			driverlicence_B = new JCheckBox("B");
			if(form.b.equals("1")) {
				driverlicence_B.setSelected(true);
			}
			driverlicence_B.setBackground(Color.decode("#2E3131"));
			driverlicence_B.setForeground(Color.WHITE);
			driverlicence_B.setOpaque(true);
			driverlicence_B.setBounds(350, 115, 50, 50);
			frame.getContentPane().add(driverlicence_B);
			
			driverlicence_B_1 = new JCheckBox("B1");
			if(form.b1.equals("1")) {
				driverlicence_B_1.setSelected(true);
			}
			driverlicence_B_1.setBackground(Color.decode("#2E3131"));
			driverlicence_B_1.setForeground(Color.WHITE);
			driverlicence_B_1.setOpaque(true);
			driverlicence_B_1.setBounds(450, 115, 50, 50);
			frame.getContentPane().add(driverlicence_B_1);
			
			
		}
		
		JButton save = new JButton("");
		if(field!=50)
			save.setIcon(new ImageIcon("Swing/save.png"));
		else
			save.setIcon(new ImageIcon("Swing/sendemail.jpg"));
		save.setOpaque(false);
		save.setContentAreaFilled(false);
		save.setBorderPainted(false);
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
		save.addActionListener(
		/**
		 * Creates action 
		 *
		 */
		new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					try {
						
						 if(field==7) {
							if(driverlicence_A.isSelected()) {
								form.a="1";
								form.senddata_licence(utilizador,formulario,null,"A");	
							}
							if(driverlicence_A_1.isSelected()) {
								form.senddata_licence(utilizador,formulario,null,"A1");	
								form.a1="1";
							}
							if(driverlicence_A_2.isSelected()) {
								form.senddata_licence(utilizador,formulario,null,"A2");	
								form.a2="1";
							}
							if(driverlicence_B.isSelected()) {
								form.senddata_licence(utilizador,formulario,null,"B");
								form.b="1";
							}
							if(driverlicence_B_1.isSelected()) {
								form.senddata_licence(utilizador,formulario,null,"B1");	
								form.b1="1";
							}
							
							try {
								form.senddata_licence(utilizador,formulario,null,"f");
								System.out.println(form.licence_driver);
								form.fields_fill(form.licence_driver,field,1,utilizador, formulario);
								form.createlog_driver(utilizador, formulario);
								frame.dispose();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
						else if(field==100) {
							user.username=textField.getText();

							if(user.username.equals(""))
							{
								user.username="temporary_user";
							}
							MainPage main = new MainPage(utilizador, template_obj);
							main.frame.setVisible(true);
							frame.dispose();

						}
						else if(field==50) {
							save.setIcon(new ImageIcon("Swing/sendemail.jpg"));
							template_obj.email_to= textField.getText();	
							if(template_obj.email_to.contains("@")) {
								template.send_email=true;
								template.send_email(formulario, cv);
								Component info = null;
								JOptionPane.showMessageDialog(info,"E-mail has been sent successfully!!Check your e-mail account(sender : easycv.portugal@gmail.com ).");
								frame.dispose();
							}
							else {
								Component info = null;
								JOptionPane.showMessageDialog(info,"E-mail is invalid!!");
								}
						}
						
						else {
							if(field==6) {
								if(!textField.getText().contains("@")) {
									System.out.println(formulario.email);
									Component info = null;
									JOptionPane.showMessageDialog(info,"E-mail is invalid!!");
								}
								else {
									form.fields_fill(textField.getText(),field,1,utilizador, formulario);
									frame.dispose();
								}
							}
							if(field==8) {
								if((textField.getText().length()!=9)) {
									System.out.println(formulario.email);
									Component info = null;
									JOptionPane.showMessageDialog(info,"Phone Number don´t have 9 digits!!");
								}
								else {
									form.fields_fill(textField.getText(),field,1,utilizador, formulario);
									frame.dispose();
								}
							}
								else {
									form.fields_fill(textField.getText(),field,1,utilizador, formulario);
									frame.dispose();
								}	
						}


					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (AddressException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (MessagingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
		});
		save.setBounds(180, 174, 214, 42);
		frame.getContentPane().add(save);
		
		JLabel lblInsereInformationHere = new JLabel(string);
		lblInsereInformationHere.setBackground(Color.WHITE);
		lblInsereInformationHere.setForeground(Color.LIGHT_GRAY);
		lblInsereInformationHere.setHorizontalAlignment(SwingConstants.CENTER);
		lblInsereInformationHere.setFont(new Font("OCR A Extended", Font.PLAIN, 30));
		lblInsereInformationHere.setBounds(43, 39, 479, 51);
		frame.getContentPane().add(lblInsereInformationHere);
	}
}
