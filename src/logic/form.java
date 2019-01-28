package logic;

import java.io.BufferedReader;
import java.util.*;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import graphical_interface.QuestionsPage3_PS;
@SuppressWarnings("all")
/**
 * Date: Jan 03-2019
 * This is a class that creates the "form" events 
 * @author nunonogueira, joaoneves, josemiguel, afonsoqueiros
 * @version 1.0
 */

public class form {
	
	/**
	 * Initialize values
	 */
	public  String fullname= "-";
	public  String birth_place= "-";
	public  String birth_date= "-";
	public  String address= "-";
	public  String postal_code= "-";
	public  String email= "-";
	public  static  String licence_driver="-";
	public  String phone_contact= "-";
	public  String twitter= "-";
	public  String website= "-";
	public  String facebook= "-";
	public  String instagram= "-";
	public  String linkedin= "-";
	public  String skype= "-";
	public  String discord= "-";
	public  String youtube= "-";
	public  String studied= "-";
	public  String studied_beggin= "-";
	public  String studied_end= "-";
	public  String worked= "-";
	public  String worked_beggin= "-";
	public  String worked_end= "-";
	public  int i=0;
	public  int nolog=0;
	//labels do QuestionsPage
	public  JLabel labelbd= new JLabel();
	public  JLabel labelfn= new JLabel();	
	public  JLabel labelpc= new JLabel();
	public  JLabel labelnationality= new JLabel();
	public  JLabel labeladdress= new JLabel();
	public  JLabel labelemail= new JLabel();
	public  JLabel labellicence= new JLabel();
	public  JLabel labelpn= new JLabel();
	public  JLabel labelwebsite= new JLabel();
	public  JLabel labelfb= new JLabel();
	public  JLabel labelinsta= new JLabel();
	public  JLabel labeltwitter= new JLabel();
	public  JLabel labellinkedin= new JLabel();
	public  JLabel labelskype= new JLabel();
	public  JLabel labeldiscord= new JLabel();
	public  JLabel labelyoutube= new JLabel();
	public  JTextField studied_on= new JTextField();
	public  JTextField study_init= new JTextField();
	public  JTextField study_end= new JTextField();
	public  JTextField work_on= new JTextField();
	public  JTextField work_init= new JTextField();
	public  JTextField work_end= new JTextField();
	public JRadioButton PL_1= new JRadioButton() ;
	public JRadioButton PL_2= new JRadioButton();
	public JRadioButton PL_3= new JRadioButton();
	public JRadioButton PL_4= new JRadioButton();
	public JRadioButton PL_5= new JRadioButton();
	public JRadioButton SL_1= new JRadioButton();
	public JRadioButton SL_2= new JRadioButton();
	public JRadioButton SL_3= new JRadioButton();
	public JRadioButton SL_4= new JRadioButton();
	public JRadioButton SL_5= new JRadioButton();
	public JRadioButton DS_1= new JRadioButton();
	public JRadioButton DS_2= new JRadioButton();
	public JRadioButton DS_3= new JRadioButton();
	public JRadioButton DS_4= new JRadioButton();
	public JRadioButton DS_5= new JRadioButton();
	public JRadioButton CS_1= new JRadioButton();
	public JRadioButton CS_2= new JRadioButton();
	public JRadioButton CS_3= new JRadioButton();
	public JRadioButton CS_4= new JRadioButton();
	public JRadioButton CS_5= new JRadioButton();
	public JRadioButton MS_1= new JRadioButton();
	public JRadioButton MS_2= new JRadioButton();
	public JRadioButton MS_3= new JRadioButton();
	public JRadioButton MS_4= new JRadioButton();
	public JRadioButton MS_5= new JRadioButton();
	
	public static String pl="-";
	public static String sl="-";
	public static String cs="-";
	public static String ds="-";
	public static String ms="-";
	
	public static String a="-";
	public static String a1="-";
	public static String a2="-";
	public static String b="-";
	public static String b1="-";
	
	
	/**
	 * Constructor of the form class
	 */
	public form() {
		// TODO Auto-generated constructor stub
	}

	public static void createlog_driver(user utilizador,form formulario) throws FileNotFoundException {
		System.out.println("entreou no loguser");
		PrintWriter log_user_driver = new PrintWriter("logs/log_driverlicence_user_"+user.username+".txt");
		log_user_driver.println(form.a);
		log_user_driver.println(form.a1);
		log_user_driver.println(form.a2);
		log_user_driver.println(form.b);
		log_user_driver.println(form.b1);
		log_user_driver.close();
		
		
	}
	public static void filldrivercheckboxes(user utilizador,form formulario) throws IOException {
		File log = new File("logs/log_driverlicence_user_"+utilizador.username+".txt");
		BufferedReader br = new BufferedReader(new FileReader(log)); 
		form.a= br.readLine();
		form.a1= br.readLine();
		form.a2= br.readLine();
		form.b= br.readLine();
		form.b1= br.readLine();

		
	}

	public static String tirar_virgula(String str) {
	    if (str != null && str.length() > 0 && str.charAt(str.length() - 1) == ',') {
	        str = str.substring(0, str.length() - 1);
	    }
	    return str;
	}
	
	public static void senddata_licence(user utilizador,form formulario,template temp,String licences) throws IOException {
		if(!licences.equals("f")) {
			form.licence_driver+=licences;
			form.licence_driver+=",";
		}
		if(licences.equals("f"))
		{
			form.licence_driver= form.tirar_virgula(form.licence_driver);
		}
	}
	
	public static void send_log_server(user utilizador, form formulario, template template_obj, File log) throws IOException {
		if(user.offline==0)
		{
		user.out.println("13");// enviar log
		int i=0;
		FileReader fd = new FileReader(log);
			  BufferedReader br = new BufferedReader(fd); 
			  String st; 
			  while (i<26) {
				  i++;
				  st= br.readLine();
				  user.out.println(st);
			  }
		br.close();
		fd.close();
		}
	}
	
	/**
	 * Verifies data
	 * @param field_content
	 * @param field
	 * @param SwingPage
	 * @throws IOException
	 */
	public static  void fields_fill(String field_content, int field,int SwingPage,user utilizador, form formulario) throws IOException {
		

		switch (field) {
		case 1:
			formulario.fullname=field_content;
			System.out.println("fullname: "+formulario.fullname);
			formulario.labelfn.setText(formulario.fullname);
			break;
		case 2: 
			formulario.birth_date=field_content;
			formulario.labelbd.setText(formulario.birth_date);
			break;	
		case 3:  
			formulario.birth_place=field_content;
			formulario.labelnationality.setText(formulario.birth_place);
			break;
		case 4: 
			formulario.address=field_content;
			formulario.labeladdress.setText(formulario.address);
			break;
		case 5: 
			formulario.postal_code=field_content;
			formulario.labelpc.setText(formulario.postal_code);
			break;
		
		case 6:  
			formulario.email=field_content;
			formulario.labelemail.setText(formulario.email);
			break;
			
		case 7:  
			formulario.licence_driver=field_content;
			formulario.labellicence.setText(formulario.licence_driver);
			break;
			
		case 8: 
			formulario.phone_contact=field_content;
			formulario.labelpn.setText(formulario.phone_contact);	
			break;
		case 9: 
			formulario.website=field_content;
			System.out.println("website: "+formulario.website);
			formulario.labelwebsite.setText(formulario.website);	
			break;
		case 10: 
			formulario.facebook=field_content;
			formulario.labelfb.setText(formulario.facebook);	
			break;
		case 11: 
			formulario.instagram=field_content;
			formulario.labelinsta.setText(formulario.instagram);	
			break;
		case 12: 
			formulario.twitter=field_content;
			formulario.labeltwitter.setText(formulario.twitter);	
			break;
		case 13: 
			formulario.linkedin=field_content;
			formulario.labellinkedin.setText(formulario.linkedin);
			break;
		case 14: 
			formulario.skype=field_content;
			formulario.labelskype.setText(formulario.skype);
			break;
		case 15: 
			formulario.discord=field_content;
			formulario.labeldiscord.setText(formulario.discord);	
			break;
		case 16: 
			formulario.youtube=field_content;
			formulario.labelyoutube.setText(formulario.youtube);	
			break;
		case 17: 
			formulario.studied=field_content;
			System.out.println("field content------------= "+ field_content);
			formulario.studied_on.setText(formulario.studied);
			break;
		case 18:
			formulario.studied_beggin=field_content;
			formulario.study_init.setText(formulario.studied_beggin);
			break;
		case 19: 
			formulario.studied_end=field_content;
			System.out.println("studied end:"+ formulario.studied_end);
			formulario.study_end.setText(formulario.studied_end);
			break;
		case 25: 
			formulario.worked=field_content;
			formulario.work_on.setText(formulario.worked);
			break;
		case 26:
			formulario.worked_beggin=field_content;
			formulario.work_init.setText(formulario.worked_beggin);
			break;
		case 27: 
			formulario.worked_end=field_content;
			formulario.work_end.setText(formulario.worked_end);
			break;
		default:
			break;
			
				
		
	}	
}
	/**
	 * Creates log 
	 * @param SwingPage
	 * @throws IOException
	 */
	public static void filllabels(int SwingPage,user utilizador, form formulario) throws IOException {
		File f = new File("logs/log_template_"+user.username +".txt");
		if(f.exists() && !f.isDirectory()) { 
			int i=0;
			  BufferedReader br = new BufferedReader(new FileReader(f)); 
			  String st; 
			  if(SwingPage==1) {
			  while (i<8) {
				  i++;
				  st= br.readLine();
			      fields_fill(st,i,SwingPage,utilizador, formulario);
			      System.out.println(i);
			  }
			}
			  if(SwingPage==2) {
				  i=8;
				  for(int j=0;j<8;j++)
					  st = br.readLine();
				  while (i<16) {
					  i++;
					  st = br.readLine();
				      fields_fill(st,i,SwingPage,utilizador, formulario);
				      System.out.println(i);
				  }
				}
			  if(SwingPage==4) {
				  i=21;
				  for(int j=0;j<21;j++)
					  st = br.readLine();
				  while (i<27) {
					  i++;
					  st = br.readLine();
				      fields_fill(st,i,SwingPage,utilizador, formulario);
				      System.out.println(i);
				  }
				}
		} 
		else
		{
			System.out.println("Nao existe log, ira ser criado apartir de agora");
		}
	}
	public void refresh_db_log() {
		
		
	}
	
	/** 
	 * Clean all fields and values
	 */
	public static void fields_clean(form formulario) {
/*		
		
		formulario.twitter= "-";
		formulario.website= "-";
		formulario.facebook= "-";
		formulario.instagram= "-";
		formulario.linkedin= "-";
		formulario.skype= "-";
		formulario.discord= "-";
		formulario.youtube= "-";
*/
		
		formulario.labelwebsite.setText("-");			
		formulario.labelfb.setText("-");			
		formulario.labelinsta.setText("-");			
		formulario.labeltwitter.setText("-");			
		formulario.labellinkedin.setText("-");
		formulario.labelskype.setText("-");
		formulario.labeldiscord.setText("-");	
		formulario.labelyoutube.setText("-");	
		formulario.work_on.setText("-");
		formulario.work_init.setText("-");
		formulario.work_end.setText("-");
		formulario.studied_on.setText("-");
		formulario.study_init.setText("-");
		formulario.study_end.setText("-");
		
	}
	
	public static void field_clean_PI(form formulario) {		
		formulario.labelfn.setText("-");		
		formulario.labelbd.setText("-");		
		formulario.labelnationality.setText("-");		
		formulario.labeladdress.setText("-");		
		formulario.labelpc.setText("-");		
		formulario.labelemail.setText("-");		
		formulario.labelpn.setText("-");		
	}
	public static void createlog_PS(user utilizador,form formulario) throws FileNotFoundException {
		System.out.println("entreou no loguser");
		PrintWriter log_user = new PrintWriter("logs/log_PS_"+user.username+".txt");
		log_user.println(form.pl);
		log_user.println(form.sl);
		log_user.println(form.cs);
		log_user.println(form.ds);
		log_user.println(form.ms);
		log_user.close();
		
		
	}
	
	public static void fillradiobuttons(user utilizador, form formulario) throws IOException {
		File log = new File("logs/log_PS_"+user.username+".txt");
		BufferedReader br = new BufferedReader(new FileReader(log)); 
		form.pl= br.readLine();
		form.sl= br.readLine();
		form.cs= br.readLine();
		form.ds= br.readLine();
		form.ms= br.readLine();
	}
	
	
	
	/**
	 * Prints out all fields to a log
	 * @throws IOException 
	 */
	public static void createlog(user utilizador,form formulario,int i) throws IOException
	{
		PrintWriter output = new PrintWriter("logs/log_template_"+user.username+".txt");
		if(i==1) {
			if(user.offline==0) {
			user.out.println("14");
			String existe_log_no_server= user.br.readLine();
			if(existe_log_no_server.equals("1")) {
	    	String st= new String();
	    	for(int j=0;j<26;j++) {
	    		st=user.br.readLine();
	    		output.println(st);
	  	
	    	}
	    	output.close();
			}
			if(!existe_log_no_server.equals("1")) {
				output.println("-");
				output.println("-");
				output.println("-");
				output.println("-");
				output.println("-");
				output.println("-");		
				output.println("-"); 
				output.println("-");
				output.println("-");
				output.println("-");
				output.println("-");
				output.println("-");
				output.println("-");
				output.println("-");
				output.println("-");
				output.println("-");
				output.println("-");
				output.println("-");
				output.println("-");
				output.println("-");
				output.println("-");
				output.println("-");
				output.println("-");
				output.println("-");
				output.println("-");
				output.println("-");
				output.println("-");
				output.close();
			
			}
		}
			if(user.offline==1) {
				output.println("-");
				output.println("-");
				output.println("-");
				output.println("-");
				output.println("-");
				output.println("-");		
				output.println("-"); 
				output.println("-");
				output.println("-");
				output.println("-");
				output.println("-");
				output.println("-");
				output.println("-");
				output.println("-");
				output.println("-");
				output.println("-");
				output.println("-");
				output.println("-");
				output.println("-");
				output.println("-");
				output.println("-");
				output.println("-");
				output.println("-");
				output.println("-");
				output.println("-");
				output.println("-");
				output.println("-");
				output.close();	
			
		}
		}
		if(i==2) {
		output.println(formulario.fullname);
		output.println(formulario.birth_date);
		output.println(formulario.birth_place);
		output.println(formulario.address);
		output.println(formulario.postal_code);
		output.println(formulario.email);		
		output.println(form.licence_driver); 
		output.println(formulario.phone_contact);
		output.println(formulario.website);
		output.println(formulario.facebook);
		output.println(formulario.instagram);
		output.println(formulario.twitter);
		output.println(formulario.linkedin);
		output.println(formulario.skype);
		output.println(formulario.discord);
		output.println(formulario.youtube);
		output.println(formulario.pl);
		output.println(formulario.sl);
		output.println(formulario.cs);
		output.println(formulario.ds);
		output.println(formulario.ms);
		output.println(formulario.studied);
		output.println(formulario.studied_beggin);
		output.println(formulario.studied_end);
		output.println(formulario.worked);
		output.println(formulario.worked_beggin);
		output.println(formulario.worked_end);
		output.close();
		}
	
	/**
	 * 
	 * @return
	 * @throws InvalidFormatException
	 * @throws IOException
	 * @throws org.apache.poi.openxml4j.exceptions.InvalidFormatException
	 */
	}
}