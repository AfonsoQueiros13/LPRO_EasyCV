package graphical_interface;

import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import logic.template;
import logic.user;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JList;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
@SuppressWarnings("all")
/**
 * Date: Jan 03-2019
 * This is a class that creates the "ListAllUsersPage" layout and actions
 * @author nunonogueira, joaoneves, josemiguel, afonsoqueiros
 * @version 1.0
 */
public class ListAllUsersPage {
	/**
	 * Initialize values
	 */
	static String username;
	JFrame frame;
	public JLabel lblNewLabel;
	public ArrayList<String> allUsers = new ArrayList<String>();
	
	/**
	 * Constructor of the ListAllUsersPage class
	 * @param utilizador
	 * @throws IOException
	 */
	public ListAllUsersPage(user utilizador, template template_obj) throws IOException {
		listalluser_swing(utilizador,template_obj);
	}

	/**
	 * Initialize the contents of the frame.
	 * Creates layout and actions of the ListAllUsersPage class
	 * @throws IOException 
	 */
	public void listalluser_swing(user utilizador,template template_obj) throws IOException {
		frame = new JFrame();
		frame.setBounds(100, 100, 909, 523);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		allUsers = user.listallusers(utilizador);
		StringBuilder sb = new StringBuilder();
		for (String i : allUsers) {
		    sb.append(i == null ? "" : i.toString());
		    sb.append("<br>");
		}
		DefaultListModel model = new DefaultListModel();
		JList list = new JList(model);
		list.setBounds(450, 41, 255, 432);
		JScrollPane scrollPane = new JScrollPane(list);
		scrollPane.setBounds(458, 42, 258, 431);
		frame.getContentPane().add(scrollPane);
		model.addElement("<html>"+ sb.toString()+"</html>");
		
		JButton return_button = new JButton("");
		return_button.setBounds(20, 11, 113, 33);
		
		return_button.addActionListener(
				
		/**
		 * Creates action to show frame JFrame
		 */
		new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					frame.dispose();
					MainPage mainpage;
					try {
						mainpage = new MainPage(utilizador,template_obj);
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
		return_button.setIcon(null);
		return_button.setBackground(null);
		return_button.addMouseListener(
		/**
		 * Changes mouse arrow
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
		frame.getContentPane().setLayout(null);
		return_button.setBorder(null);
		frame.getContentPane().add(return_button);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setFont(new Font("Microsoft YaHei UI", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(450, 44, 159, 341);
		frame.getContentPane().add(lblNewLabel_1);
		
		lblNewLabel = new JLabel();
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("Calisto MT", Font.PLAIN, 26));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setIcon(new ImageIcon("Swing/light_gray.png"));
		lblNewLabel.setBounds(450, 42, 307, 417);
		frame.getContentPane().add(lblNewLabel);

	
			JLabel listpage = new JLabel("");
			listpage.setHorizontalAlignment(SwingConstants.LEFT);
			listpage.setBounds(0, -75, 907, 641);
			listpage.setIcon(new ImageIcon("Swing/listalluserspage.JPG"));
			frame.getContentPane().add(listpage);
		
	}
}	
