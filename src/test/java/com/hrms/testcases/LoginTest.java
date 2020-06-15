package com.hrms.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.hrms.utils.CommonMethods;
import com.hrms.utils.ConfigsReader;

public class LoginTest  extends CommonMethods{
	//BaseClassa ekledigimiz icin burda kullanmaya gerek kalmadi
/*	@BeforeMethod
	public void OpenBrowserAndNavigate() {
		setUp();
		initialize();
	}
	
   @AfterMethod
   public void quitBrowser() {
	   tearDown();
   }
  */ 
   @Test(groups="smoke")
   public void validAdminLogin() {
	   //initialize yaptigimiz icin asagida commentladigimiz line lari kullanmiyoruz
	    //LoginPageElements login =new LoginPageElements();
	   CommonMethods.sendText(login.username, ConfigsReader.getProperty("username"));
	   CommonMethods.sendText(login.password, ConfigsReader.getProperty("password"));
        login.loginBtn.click();
       
   String expectedUser="Welcome Admin";
   String actualUser=dashboard.welcome.getText();
   Assert.assertEquals(expectedUser, actualUser, "Admin is not Logged in");
   Assert.assertTrue(actualUser.contains((ConfigsReader.getProperty("username"))));
   
   }
   
   @Test(groups="regression")
   public void invalidPasswordLogin() {
	   
	   //LoginPageElements login1 =new LoginPageElements();
	   CommonMethods.sendText(login.username, ConfigsReader.getProperty("username"));
	   CommonMethods.sendText(login.password, "uiuigui");
       login.loginBtn.click();
	   
   String expected="Invalid credentials";
   Assert.assertEquals(login.errorMsg.getText(), expected, "Error messege text is not matched");
   }
   
   
   @Test(groups="regression")
   public void emptyUsernameLogin() {
	  // LoginPageElements login1 =new LoginPageElements();
	   CommonMethods.sendText(login.password, ConfigsReader.getProperty("username"));
       login.loginBtn.click();
	   
   String expected="Usename cannot be empty";
   Assert.assertEquals(login.errorMsg.getText(), expected, "Error messege text is not matched");
   
	   
   }
    
   

}
