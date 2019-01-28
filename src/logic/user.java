/*                EASYCV v1.0           AUTORES: AFONSO QUEIR�S, JO�O NEVES, JOS� MIGUEL, NUNO NOGUEIRA
------------------------------------------------------------------------------------------------------------------*/
      /************************************************CLASSE USER***************************************************/

package logic;
import java.awt.Component;
import java.awt.Image;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import graphical_interface.LoginPage;
import graphical_interface.MainPage;
@SuppressWarnings("all")
/**
 * Date: Jan 03-2019
 * This is a class that creates the "user" events 
 * @author nunonogueira, joaoneves, josemiguel, afonsoqueiros
 * @version 1.0
 */

public class user {
	
	/**
	 * Initialize values
	 */
	public static boolean changecredentials=false;
	public static int offline=0;
	public static String username;
	public static String password;
	public static String fullname="";
	public static String birthdate="";
	public static String address="";
	public String licenca_A= "";
	public String licenca_A1= "";
	public String licenca_A2= "";
	public String licenca_B= "";
	public String licenca_B1= "";
	public static String licencas= "";
	public static String licencas1= "";
	public static String db_result;
	public static String operation_user;
	final static  String host = "localhost";
	final static int portNumber = 25;
	public static BufferedReader br;
	public static PrintWriter out;
	public static  Socket socket;
	public static  int photo=0;
	public static int login=0;
	public static int registed=0;
	public static  int imagem=0;
	public static int profile_show=0;
	public static String driver_a= "-";
	public static String driver_a1="-";
	public static String driver_a2= "-";
	public static String driver_b= "-";
	public static String driver_b1= "-";
	
	public static File selectedFile ;
	public static JLabel label_photo ;
	
	public static JTextField textfullname;
	public static JTextField textbirthdate;
	public static JTextField textaddress;
	
	/**
	 * Constructor of the user class
	 */
	public user() {
	}
	
	/**
	 * Creates socket
	 * @throws UnknownHostException
	 * @throws IOException
	 */
	public void setSocket() throws UnknownHostException, IOException {	
		socket = new Socket(host, portNumber);
		System.out.println("Creating socket to '" + host + "' on port " + portNumber);
		br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	    out = new PrintWriter(socket.getOutputStream(), true);		
	}
	
	/**
	 * 
	 * @param utilizador
	 * @param username
	 * @param password
	 * @throws UnknownHostException
	 * @throws IOException
	 */
	public static void register_user(user utilizador , String username, String password,template template_obj) throws UnknownHostException, IOException {
		user.username=username;
		user.password=password;
		user.operation_user="0"; //quando se trata de um REGISTO, o sistema envia 0 para a dB, para que ele entenda que se trata desse processo
		user.out.println(operation_user);
		user.out.println(user.username);
		user.out.println(user.password);
		user.db_result= br.readLine(); //LENDO A RESPOSTA DO SV E DA DB POR CONSEQU�NCIA
		if(user.db_result.equals("1")) { //HOUVE SUCESSO
				
				LoginPage login;
				try {
					login = new LoginPage(utilizador,template_obj);
					login.frame.setVisible(true);
					user.registed=1;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}		
                                  }
		if(user.db_result.equals("0"))
		{
			Component frame_erro = null;
			JOptionPane.showMessageDialog(frame_erro,"Utilizador already exists! Use another e-mail.");
			
		}
		
	}
	
	public static void  login_user(user utilizador, String username, String password,template template_obj) throws IOException {
		user.operation_user="1"; //quando se trata de um LOGIN, o sistema envia 1 para a dB, para que ele entenda que se trata desse processo
		out.println(operation_user); 
		out.println(username);  
		out.println(password); 
		user.db_result=br.readLine();
		if(user.db_result.equals("1")) //significa que houve sucesso no login do user
		{
			
			System.out.println("houve sucesso");
			login=1;
			MainPage mainpage;
			try {
				user.username = username;
				mainpage = new MainPage(utilizador,template_obj);
				mainpage.frame.setVisible(true);
					
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		if(db_result.equals("0"))
	{
		Component frame_erro = null;
		JOptionPane.showMessageDialog(frame_erro,"This user doesn't exists! Please register or make login with another user");
	}
} 
	
	public static void submit_data(user utilizador) throws IOException { //metodo que submete o perfil do user
		user.operation_user = "3";
		user.out.println(user.operation_user);
		System.out.println("op user"+ user.operation_user);
		user.out.println(user.fullname);
		user.out.println(user.birthdate);
		user.out.println(utilizador.address);
		
	}
	
	public static void senddata_licence(user utilizador,String licences) throws IOException {
		if(!licences.equals("f")) {
			utilizador.licencas+=licences;
			utilizador.licencas+=",";
		}
		if(licences.equals("f"))
		{
			utilizador.licencas1= tirar_virgula(utilizador.licencas);
		out.println(utilizador.licencas1);
		}
	}
	
	public static void fillprofiledata() throws IOException {
		System.out.println("user: "+ user.username);
		user.out.println("9");
				
			fullname= br.readLine();
			System.out.println(fullname);
			textfullname.setText(fullname);
			birthdate= br.readLine();
			System.out.println(birthdate);
			textbirthdate.setText(birthdate);
			address=br.readLine();
			textaddress.setText(address);
			profile_show=1;
	}
	public static void changecredentials(user utilizador,int state) {
		out.println(state); 
		if(state==2) { //apenas quer-se mudar a pass
			out.println(user.password);
		}
		if(state==4) { //apenas quer-se mudar o username
			out.println(user.username);
		}
        if(state==5) { //quer-se mudar ambos
        	System.out.println("user= "+ user.username);
        	out.println(user.username);
        	System.out.println("pass= "+ user.password);
        	out.println(user.password);
        	user.changecredentials=true;
		}
		
	}
	
	public static ArrayList<String> listallusers(user utilizador) throws IOException {
		out.println("6"); //o sv vai saber que se trata de uma listagem de todos os users
		ArrayList<String> listaUsers = new ArrayList<String>();
		String username=br.readLine();
		while (!username.equals("0")) {
			listaUsers.add(username);
			listaUsers.add("\n");
			username=br.readLine();

		}
		//System.out.println(listaUsers.get(0));
		return listaUsers;
		
	}
	
	public static String tirar_virgula(String str) {
	    if (str != null && str.length() > 0 && str.charAt(str.length() - 1) == ',') {
	        str = str.substring(0, str.length() - 1);
	    }
	    return str;
	}
	
	public static void request_photo(user utilizador) throws IOException {
		out.println("11");		
		out.println("10");
	 	String read= br.readLine();
	 	System.out.println("lol: "+ read);
		if(read.equals("1")) {
	   System.out.println("entrou no request, ou seja, ha ficheiro para enviar do user");
	   
	   InputStream inputStream = socket.getInputStream();
       byte[] sizeAr = new byte[4];
       inputStream.read(sizeAr);
       int size = ByteBuffer.wrap(sizeAr).asIntBuffer().get();

       byte[] imageAr = new byte[size];
       inputStream.read(imageAr);
       File img = new File("img_users/"+user.username+".jpg");
       if(img.exists()) 
    	   	img.delete();
		img.createNewFile();
       DataOutputStream os = new DataOutputStream(new FileOutputStream(img));
       BufferedImage image = ImageIO.read(new ByteArrayInputStream(imageAr));
       
      // System.out.println("Received " + image.getHeight() + "x" + image.getWidth() + ": " + System.currentTimeMillis());
       ImageIO.write(image, "jpg",os);
       String path= "img_users/"+user.username+".jpg";
	   user.label_photo.setIcon(new ImageIcon(path));
		}
		else {
		System.out.println("Nao se enviou a imagem porque nao existe"); 
		}
		   System.out.println("Fim do request");
	}

	public static void save_image(File file) throws IOException {
		try {
			BufferedImage image = ImageIO.read(file);
			 ImageIO.write(image, "jpg", new File("img_users/"+user.username+".jpg"));
		} catch(IOException e) {
		 System.out.println("Write error for " + file.getPath() +
		                               ": " + e.getMessage());
		  }
	}
	public static void fill_label_image() throws IOException {
		Image image_user= ImageIO.read(new File("img_users/"+user.username+".jpg"));
		Image dimg = image_user.getScaledInstance(user.label_photo.getWidth(), user.label_photo.getHeight(),
		        Image.SCALE_SMOOTH);
		user.label_photo.setIcon(new ImageIcon(dimg));
	}

	public static void createlog_driver(user utilizador) throws FileNotFoundException {
		System.out.println("entreou no loguser");
		PrintWriter log_user = new PrintWriter("logs/log_user_"+user.username+".txt");
		log_user.println(user.driver_a);
		log_user.println(user.driver_a1);
		log_user.println(user.driver_a2);
		log_user.println(user.driver_b);
		log_user.println(user.driver_b1);
		log_user.close();
		
		
	}
	public static void filldrivercheckboxes(user utilizador) throws IOException {
		File log = new File("logs/log_user_"+user.username+".txt");
		BufferedReader br = new BufferedReader(new FileReader(log)); 
		user.driver_a= br.readLine();
		System.out.println(user.driver_a);
		user.driver_a1= br.readLine();
		user.driver_a2= br.readLine();
		user.driver_b= br.readLine();
		user.driver_b1= br.readLine();

		
	}
}