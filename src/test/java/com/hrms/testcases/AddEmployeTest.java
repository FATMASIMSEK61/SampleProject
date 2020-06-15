package com.hrms.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hrms.utils.CommonMethods;
import com.hrms.utils.ConfigsReader;

public class AddEmployeTest extends CommonMethods{
	
	

	@BeforeMethod
	public void OpenBrowserAndNavigate() {
		setUp();
	}
   @AfterMethod
   public void quitBrowser() {
	   tearDown();
   }
   
   @Test
   public void AddEmployeePage() throws InterruptedException {
	   login.login(ConfigsReader.getProperty("username"), ConfigsReader.getProperty("password"));
	   dashboard.navigateToAddEmployee();
	   wait(7);
   }
}
