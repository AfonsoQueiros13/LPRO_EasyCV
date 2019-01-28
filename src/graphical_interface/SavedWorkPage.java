package graphical_interface;

import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JLabel;

import logic.template;
import logic.user;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


/**
 * Date: Jan 03-2019
 * This is a class that creates the "SavedWorkPage" layout and actions
 * @author nunonogueira, joaoneves, josemiguel, afonsoqueiros
 * @version 1.0
 */

public class SavedWorkPage {
	
	/**
	 * Initialize values
	 */
	static String username;
	public JFrame frame;

	
	/**
	 * Constructor of the SavedWorkPage class
	 * @param utilizador
	 * @param username
	 */
	public SavedWorkPage(user utilizador,String username,template template_obj) {
		SavedWorkPage.username=username;
		savedworkpage_swing(utilizador,template_obj);
	}



	/**
	 * Creates layout and actions of the SavedWorkPage class
	 * @param utilizador
	 */
	public void savedworkpage_swing(user utilizador,template template_obj) {
		frame = new JFrame();
		frame.setBounds(100, 100, 896, 512);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton return_button = new JButton("");
		return_button.addActionListener(
		/**
		 * Creates action to show main.frame, setting it visible.
		 *
		 */
		new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					frame.dispose();
					MainPage mainpage = new MainPage(utilizador,template_obj);
					mainpage.frame.setVisible(true);
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		
		return_button.setOpaque(false);
		return_button.setContentAreaFilled(false);
		return_button.setBorderPainted(false);
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
		return_button.setIcon(null);
		return_button.setBorder(null);
		return_button.setBounds(10, 22, 128, 23);
		frame.getContentPane().add(return_button);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("Swing/SavedWork.JPG"));
		lblNewLabel.setBounds(0, -56, 880, 592);
		frame.getContentPane().add(lblNewLabel);
	}

}
