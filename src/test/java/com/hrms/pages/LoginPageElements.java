package com.hrms.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.testbase.BaseClass;
import com.hrms.utils.CommonMethods;
import com.hrms.utils.ConfigsReader;
public class LoginPageElements extends CommonMethods{
	// Not using PageFactory, You have to extend CommonMethods or BaseClass
		// public WebElement username2=driver.findElement(By.id("txtUsername"));
	
	// Using PageFactory and @FindBy Annotation
  @FindBy (id="txtUsername")
  public WebElement username;
  @FindBy(name="txtPassword")
  public WebElement password;
  @FindBy(css="input#btnLogin")
  public WebElement loginBtn;
  @FindBy(xpath="//div[@id='divLogo']/img")
  public WebElement logo;
  @FindBy(id="spanMessage")
	public WebElement errorMsg;
	
	@FindBy(id="welcome")
	public WebElement logoutBtn;
	
	@FindBy(linkText="Logout")
	public WebElement logout;
	
 public LoginPageElements() {
	 PageFactory.initElements(BaseClass.driver, this);
 }
//if we would be keeping elements as private
	//then we will need to create public getters and setters
	//so we can access page elements from test classes
 public void login() {
	    sendText(username,ConfigsReader.getProperty("username"));
	   sendText(password,ConfigsReader.getProperty("password"));
	   click(loginBtn);
		}
	
	public void login(String uid, String pwd) {
		sendText(username, uid);
		sendText(password, pwd);
		click(loginBtn);
	}
}
