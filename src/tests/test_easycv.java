package tests;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Random;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Test;

import graphical_interface.CVReadyPage;
import graphical_interface.ChooseTemplatePage;
import graphical_interface.InsereDataWindow;
import graphical_interface.ListAllUsersPage;
import graphical_interface.LoginPage;
import graphical_interface.ProfilePage;
import graphical_interface.QuestionsPage1_PI;
import graphical_interface.SettingsPage;
import logic.form;
import logic.template;
import logic.user;
@SuppressWarnings("all")
public class test_easycv {
	Random rand = new Random();
	int n = rand.nextInt(1000000) + 1;
	
	@Test //1
	public void test_regist_valid() throws UnknownHostException, IOException {
		template template_obj= new template();
		user utilizador= new user();
		LoginPage login= new LoginPage(utilizador,template_obj);
		utilizador.setSocket();
		user.username= "junit"+n+"@gmail.com";
		user.password= "junitpassword";
		user.register_user(utilizador,user.username,user.password,template_obj);
		assertEquals(1,user.registed);
	}
	
	@Test //2
	public void test_regist_invalid() throws UnknownHostException, IOException {
		user utilizador= new user();
		template template_obj= new template();
		LoginPage login= new LoginPage(utilizador,template_obj);
		utilizador.setSocket();
		user.username= "a";
		user.password= "1";
		user.register_user(utilizador,user.username,user.password, template_obj);
		assertEquals(0,user.registed);
	}
	
	@Test //3
	public void test_login_valid() throws UnknownHostException, IOException {
		user utilizador= new user();
		template template_obj= new template();
		LoginPage login= new LoginPage(utilizador, template_obj);
		utilizador.setSocket();
		user.username= "user";
		user.password= "1";
		user.login_user(utilizador,user.username,user.password, template_obj);
		assertEquals(1,user.login);
	}

	
	@Test//4
	public void test_login_invalid() throws UnknownHostException, IOException {
		user utilizador= new user();
		template template_obj= new template();
		LoginPage login= new LoginPage(utilizador, template_obj);
		utilizador.setSocket();
		user.username= "imnotanuser";
		user.password= "imnotapass";
		user.login_user(utilizador,user.username,user.password, template_obj);
		assertEquals(0,user.login);
	}
	
	@Test //5
	public void test_logout() throws UnknownHostException, IOException {
		user utilizador= new user();
		template template_obj= new template();
		LoginPage login= new LoginPage();
		utilizador.setSocket();
		user.username= "user";
		user.password= "1";
		user.login_user(utilizador,user.username,user.password, template_obj);
		assertEquals(1,user.login);
		login= new LoginPage();
		assertEquals(0,user.login);
	}
	
	@Test //6
	public void test_listallusers() throws UnknownHostException, IOException {
		user utilizador= new user();
		template template_obj= new template();
		LoginPage login= new LoginPage();
		utilizador.setSocket();
		user.username= "admin";
		user.password= "admin";
		user.login_user(utilizador,user.username,user.password, template_obj);
		ListAllUsersPage listusers= new ListAllUsersPage(utilizador, template_obj);
		listusers.allUsers = user.listallusers(utilizador);
		assertNotEquals(0,listusers.allUsers.size());
		
	}
	
	@Test //7
	public void test_externalcomms_valid() throws UnknownHostException, IOException {
		user utilizador= new user();
		LoginPage login= new LoginPage();
		utilizador.setSocket();
		assertEquals(true,user.socket.isConnected());
		
	}
	
	@Test //8
	public void test_exportcv_valid() throws UnknownHostException, IOException, InvalidFormatException {
		user utilizador= new user();
		form formulario= new form();
		template template_obj= new template();
		LoginPage login= new LoginPage();
		utilizador.setSocket();
		user.username= "a";
		user.password= "1";
		ChooseTemplatePage choosetemp= new ChooseTemplatePage(utilizador, formulario, template_obj);
		QuestionsPage1_PI questions= new QuestionsPage1_PI(utilizador, formulario, template_obj);
		template_obj.createCV(formulario);
		File file = new File("templates/CV_Template1"+user.username+".docx");
		assertEquals(true,file.exists());
		
	}
	
	@Test //9
	public void test_acessprofile_valid() throws UnknownHostException, IOException, InvalidFormatException {
		user utilizador= new user();
		template template_obj= new template();
		LoginPage login= new LoginPage();
		utilizador.setSocket();
		user.username= "v";
		user.password= "1";
		user.login_user(utilizador,user.username,user.password, template_obj);
		ProfilePage profile= new ProfilePage(utilizador, template_obj);
		assertEquals(1,user.profile_show);
	}
	
	@Test //10
	public void test_offline_mode() throws UnknownHostException, IOException {
		template template_obj= new template();
		user utilizador= new user();
		LoginPage login= new LoginPage(utilizador,template_obj);
		InsereDataWindow data;
		data = new InsereDataWindow(100, utilizador, null, template_obj,null,"Put your username here.",null);
		data.frame.setVisible(true);
		login.frame.dispose();
		assertEquals(1,user.offline);
	}

	@Test //11
	public void test_edit_credentials() throws UnknownHostException, IOException {
		template template_obj= new template();
		user utilizador= new user();
		LoginPage login= new LoginPage(utilizador,template_obj);
		utilizador.setSocket();
		login.frame.setVisible(true);
		user.username= "v";
		user.password= "1";
		user.login_user(utilizador,user.username,user.password, template_obj);
		login.frame.dispose();
		SettingsPage settings= new SettingsPage(utilizador, null, template_obj);
		settings.frame.setVisible(true);
		user.username= "a1";
		user.changecredentials(utilizador,5);
		assertEquals(user.changecredentials,true);
	}
	
	@Test //12
	public void test_savedwork_valid() throws UnknownHostException, IOException, InvalidFormatException {
		template template_obj= new template();
		form formulario= new form();
		user utilizador= new user();
		LoginPage login= new LoginPage(utilizador,template_obj);
		utilizador.setSocket();
		login.frame.setVisible(true);
		user.username= "v";
		user.password= "1";
		user.login_user(utilizador,user.username,user.password, template_obj);
		login.frame.dispose();
		ChooseTemplatePage choosetemp= new ChooseTemplatePage(utilizador, formulario, template_obj);
		QuestionsPage1_PI questions= new QuestionsPage1_PI(utilizador, formulario, template_obj);
		template_obj.createCV(formulario);
		CVReadyPage cvready=  new CVReadyPage(null, utilizador, formulario, template_obj);
		cvready.frame.setVisible(true);
		File file = new File("logs/log_template_"+user.username+".txt");
		assertEquals(true,file.exists());
	}
	
	
}
