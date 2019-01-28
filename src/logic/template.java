package logic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
@SuppressWarnings("all")
public class template {
	public static  String email_to="-";
	static String path= null;
	public static boolean send_email=false;
	
	public static File createCV(form formulario) throws InvalidFormatException, IOException, org.apache.poi.openxml4j.exceptions.InvalidFormatException {
		XWPFDocument doc = null;
		File source= null;
		File dest = null;
		if(formulario.i==1) {
			 source = new File("templates/template1.docx");
             dest = new File("templates/template1_toedit.docx");
            Files.copy(source.toPath(), dest.toPath());
            doc = new XWPFDocument(OPCPackage.open("templates/template1_toedit.docx"));
		}
		if(formulario.i==2) {
			 source = new File("templates/template2.docx");
			 dest = new File("templates/template2_toedit.docx");
			Files.copy(source.toPath(), dest.toPath());
			doc = new XWPFDocument(OPCPackage.open("templates/template2_toedit.docx"));
		}
		if(formulario.i==3) {
			 source = new File("templates/template3.docx");
			 dest = new File("templates/template3_toedit.docx");
			Files.copy(source.toPath(), dest.toPath());
			doc = new XWPFDocument(OPCPackage.open("templates/template3_toedit.docx"));
		}
		

		XWPFParagraph par = doc.createParagraph();
		XWPFRun run = par.createRun();
		for (XWPFParagraph p : doc.getParagraphs()) { 
		    List<XWPFRun> runs = p.getRuns();
		    if (runs != null) {
		        for (XWPFRun r : runs) { 
		            String text = r.getText(0);

		            if (text != null) {
		          		
		            	//condi��es para campos a substituir
		            	if (text.contains("name")){
		            	text = text.replace("name", formulario.fullname);
		                }
		            	
		            	if (text.contains("birth")){
			            	text = text.replace("birth", formulario.birth_date);
			            }
		            	if (text.contains("location")){
			            	text = text.replace("location", formulario.birth_place);
			            }
		            	if (text.contains("address")){
			            	text = text.replace("address", formulario.address);
			            }
		            	if (text.contains("postal")){
			            	text = text.replace("postal", formulario.postal_code);
			            }
		            	if (text.contains("phone")){
			            	text = text.replace("phone", formulario.phone_contact);
			            }
		            	if (text.contains("email")){
			            	text = text.replace("email", formulario.email);
			            }
		            	if (text.contains("driver")){
			            	text = text.replace("driver", form.licence_driver);
			            }
		            	if (text.contains("website")){
		            	text = text.replace("website", formulario.website);
		                }
		            	if (text.contains("facebook")){
			            	text = text.replace("facebook", formulario.facebook);
			            }
		            	if (text.contains("instagram")){
			            	text = text.replace("instagram", formulario.instagram);
			            }
		            	if (text.contains("twitter")){
			            	text = text.replace("twitter", formulario.twitter);
			            }
		            	if (text.contains("skype")){
			            	text = text.replace("skype", formulario.skype);
			            }
		            	if (text.contains("linkedin")){
			            	text = text.replace("linkedin", formulario.linkedin);
			            }
		            	if (text.contains("discord")){
			            	text = text.replace("discord", formulario.discord);
			            }
		            	if (text.contains("youtube")){
			            	text = text.replace("youtube", formulario.youtube);
			            }
		            	
		            	if (text.contains("primary")){
			            	text = text.replace("primary", formulario.pl);
			            }
		            	if (text.contains("secondary")){
			            	text = text.replace("secondary", formulario.sl);
			            }
		            	if (text.contains("comunication")){
			            	text = text.replace("comunication", formulario.cs);
			            }
		            	if (text.contains("digital")){
			            	text = text.replace("digital", formulario.ds);
			            }
		            	if (text.contains("management")){
			            	text = text.replace("management", formulario.ms);
			            }
		            	if (text.contains("study")){
			            	text = text.replace("study", formulario.studied+ " Since "+formulario.studied_beggin + " to "+ formulario.studied_end);
			            }
		            	if (text.contains("work")){
			            	text = text.replace("work",formulario.worked+ " Since "+formulario.worked_beggin + " to "+ formulario.worked_end);
			            }
		            	if (text.contains("image")){
		            		r.addPicture(new FileInputStream("img_users/"+user.username+".jpg"), XWPFDocument.PICTURE_TYPE_JPEG, "img_users/"+user.username+".jpg", Units.toEMU(100), Units.toEMU(100));
		            		text = text.replace("image", "");
		            	}
		            	r.setText(text, 0);
		            	
		            }
		        }
		    }
		}
		for (XWPFTable tbl : doc.getTables()) {
		   for (XWPFTableRow row : tbl.getRows()) {
		      for (XWPFTableCell cell : row.getTableCells()) {
		         for (XWPFParagraph p : cell.getParagraphs()) {
		            for (XWPFRun r : p.getRuns()) {
		              String text = r.getText(0);
		              if (text != null) {
		            	    //condi��es para campos a substituir
		            	  		if (text.contains("name")){
				            	text = text.replace("name", formulario.fullname);
				                }
				            	if (text.contains("birth")){
					            	text = text.replace("birth", formulario.birth_date);
					            }
				            	if (text.contains("location")){
					            	text = text.replace("location", formulario.birth_place);
					            }
				            	if (text.contains("address")){
					            	text = text.replace("address", formulario.address);
					            }
				            	if (text.contains("postal")){
					            	text = text.replace("postal", formulario.postal_code);
					            }
				            	if (text.contains("phone")){
					            	text = text.replace("phone", formulario.phone_contact);
					            }
				            	if (text.contains("email")){
					            	text = text.replace("email", formulario.email);
					            }
				            	if (text.contains("driver")){
					            	text = text.replace("driver", form.licence_driver);
					            }
				            	if (text.contains("website")){
					            	text = text.replace("website", formulario.website);
					                }
					            	if (text.contains("facebook")){
						            	text = text.replace("facebook", formulario.facebook);
						            }
					            	if (text.contains("instagram")){
						            	text = text.replace("instagram", formulario.instagram);
						            }
					            	if (text.contains("twitter")){
						            	text = text.replace("twitter", formulario.twitter);
						            }
					            	if (text.contains("skype")){
						            	text = text.replace("skype", formulario.skype);
						            }
					            	if (text.contains("linkedin")){
						            	text = text.replace("linkedin", formulario.linkedin);
						            }
					            	if (text.contains("discord")){
						            	text = text.replace("discord", formulario.discord);
						            }
					            	if (text.contains("youtube")){
						            	text = text.replace("youtube", formulario.youtube);
						            }
				            	if (text.contains("primary")){
					            	text = text.replace("primary", formulario.pl);
					            }
				            	if (text.contains("secondary")){
					            	text = text.replace("secondary", formulario.sl);
					            }
				            	if (text.contains("comunication")){
					            	text = text.replace("comunication", formulario.cs);
					            }
				            	if (text.contains("digital")){
					            	text = text.replace("digital", formulario.ds);
					            }
				            	if (text.contains("management")){
					            	text = text.replace("management", formulario.ms);
					            }
				            	if (text.contains("study")){
					            	text = text.replace("study", formulario.studied+ " Since "+formulario.studied_beggin + " to "+ formulario.studied_end);
					            }
				            	if (text.contains("work")){
					            	text = text.replace("work",formulario.worked+ " Since "+formulario.worked_beggin + " to "+ formulario.worked_end);
					            }
				            	if (text.contains("image")){
				            		r.addPicture(new FileInputStream("img_users/"+user.username+".jpg"), XWPFDocument.PICTURE_TYPE_JPEG, "img_users/"+user.username+".jpg", Units.toEMU(100), Units.toEMU(100));
				            		text = text.replace("image", "");
				            	}
	            	  			
				            	r.setText(text, 0);
		              }
		            }
		         }
		      }
		   }
		}
		if(formulario.i==1) {
			path="cvs_users/CV_Template1"+user.username+".docx";
		    doc.write(new FileOutputStream(path));
		    doc.close();
		    dest.delete();
		}
		if(formulario.i==2) {
			path="cvs_users/CV_Template2"+user.username+".docx";
		    doc.write(new FileOutputStream(path));	
		    doc.close();
		    dest.delete();
		}
		if(formulario.i==3) {
			path="cvs_users/CV_Template3"+user.username+".docx";
			doc.write(new FileOutputStream(path));	
			doc.close();
			dest.delete();

		}
		File CV= new File(path);
		System.out.println("document created");
		return CV;

	}
	
	/**
	 * Send email to user with the CV to download
	 * @throws AddressException
	 * @throws MessagingException
	 * @throws IOException
	 */
	public static void send_email(form formulario,File cv) throws AddressException, MessagingException, IOException {
		 System.out.println("send email");
		Properties props = new Properties();
	        props.put("mail.smtp.host", "true");
	        props.put("mail.smtp.starttls.enable", "true");
	        props.put("mail.smtp.host", "smtp.gmail.com");
	        props.put("mail.smtp.port", "587");
	        props.put("mail.smtp.auth", "true");
	        props.put("mail.debug", "true");
	        //Establishing a session with required user details
	        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
	            @Override
	            protected PasswordAuthentication getPasswordAuthentication() {
	                return new PasswordAuthentication("easycv.portugal", "easycv2018");
	            }
	        });
	        try {
	            //Creating a Message object to set the email content
	            MimeMessage msg = new MimeMessage(session);
	            //Storing the comma seperated values to email addresses
	            /*Parsing the String with defualt delimiter as a comma by marking the boolean as true and storing the email
	            addresses in an array of InternetAddress objects*/
	            InternetAddress[] address = InternetAddress.parse(template.email_to, true);
	            //Setting the recepients from the address variable
	            msg.setRecipients(Message.RecipientType.TO, address);
	            msg.setSubject("CV created!" );
	            msg.setSentDate(new Date());
	            msg.setHeader("XPriority", "1");
	            MimeBodyPart textBodyPart = new MimeBodyPart();
	            textBodyPart.setText("Hi, "+user.username+". Your CV is ready and it can be downloaded here! Best regards,EasyCV");
	            MimeBodyPart messageBodyPart = new MimeBodyPart();
	            Multipart multipart = new MimeMultipart();
	            String fileName = "CV_"+user.username+".docx";
	            DataSource source = new FileDataSource(cv.getAbsolutePath());
	            messageBodyPart.setDataHandler(new DataHandler(source));
	            messageBodyPart.setFileName(fileName);
	            multipart.addBodyPart(textBodyPart); 
	            multipart.addBodyPart(messageBodyPart);
	            msg.setContent(multipart);
	            Transport.send(msg);
	            System.out.println("Mail has been sent successfully");
	        } catch (MessagingException mex) {
	            System.out.println("Unable to send an email" + mex);
	           
	        }
	      
	    }
	
	/**
	 * Saves CV
	 * @param cv
	 */
	public static void saveCV(File cv) {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setCurrentDirectory(new java.io.File(cv.getAbsolutePath()));
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		fileChooser.setDialogTitle("Specify the directory to save your CV");    
	    //
	    // disable the "All files" option.
	    //
		fileChooser.setAcceptAllFileFilterUsed(false);
	    //    
	    if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) { 
		  String path_destiny= fileChooser.getSelectedFile().getAbsolutePath()+"\\"+cv.getName();
	      File cv_saved = new File(path_destiny);
	    	if(!cv_saved.exists())
				try {
					cv_saved.createNewFile();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	    	
	      System.out.println(cv.toPath());
	      try {
	    	  Files.copy(cv.toPath(),cv_saved.toPath(),StandardCopyOption.REPLACE_EXISTING);
	    	  JOptionPane.showMessageDialog(null, "Well done! Your CV has been saved on:  " + path_destiny);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   }
	}
	public static void deletelogs(user utilizador, form formulario, template template_obj,int index) {
		File PS = new File("logs/log_PS_"+user.username+".txt");
		if(index==1) {
		if(PS.exists())
			PS.delete();
		}
		File DL = new File("logs/log_driverlicence_user_"+user.username+".txt");
		if(index==1) {
		if(DL.exists())
			DL.delete();
		}
		File log = new File("logs/log_template_"+user.username+".txt");
		System.out.println("um");
		if(log.exists()) {
			System.out.println("dois");
			log.delete();
		}
		if(user.offline==0)
		user.out.println("15");
	}
}
