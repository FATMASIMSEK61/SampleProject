package com.hrms.utils;

import java.io.File;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.UnexpectedTagNameException;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.hrms.testbase.PageInitializer;

public class CommonMethods extends PageInitializer {
	
	/**
	 * command+o ile hangi metodlar var onlari listeler
	 * method that clears and sends keys
	 * @param element
	 * @param text
	 */
	public static void sendText(WebElement element, String text) {
		element.clear();
		element.sendKeys(text);
	}
	
	/**
	 * method checks if radio/checkbox is enabled and clicks it
	 * @param radioOrCheckbox
	 * @param value
	 */
	public static void clickRadioOrCheckbox(List<WebElement>radioOrCheckbox,String value) {
		
		String actuelValue;
		for(WebElement el:radioOrCheckbox) {
			actuelValue=el.getAttribute("value").trim();
			if(el.isEnabled()&& actuelValue.equals(value)) {
				el.click();
				break;
			}
		}
	}
	/**
	 * method that check s if text is there and then select it
	 * @param element
	 * @param textToSelect
	 */
	public static void selectDdValue(WebElement element,String textToSelect ) {
		
		try {
		Select select=new Select(element);
		
		List<WebElement>options=select.getOptions();
		
		for(WebElement el:options) {
			
			if(el.getText().equals(textToSelect)) {
				select.selectByVisibleText(textToSelect);
				break;
				
			}
		}
		
		}catch(UnexpectedTagNameException e) {
			e.printStackTrace();
			
		}
	}
	/**
	 * method that selects value by index
	 * @param element
	 * @param index
	 */
	public static void selectDdValue(WebElement element,int index) {
		try {
			Select select=new Select(element);
			int size=select.getOptions().size();
			if(size>index) {
				select.selectByIndex(index);
			}
		}catch(UnexpectedTagNameException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * methods that accept alerts and catches exception is not alert not present
	 */
	public static void acceptAlert() {
		
		try {
			Alert alert=driver.switchTo().alert();
			alert.accept();
		}catch(NoAlertPresentException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * methods that dismiss alerts and catches exception is not alert not present
	 */
	public static void dismissAlert() {
		try {
			Alert alert=driver.switchTo().alert();
			alert.dismiss();
		}catch(NoAlertPresentException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * methods that gets text of  alerts and catches exception if alert not present
	 * @return
	 */
public static String getAlertText() {
	
	String alertText=null;
	
	try {
		Alert alert =driver.switchTo().alert();
		alertText=alert.getText();
		
	}catch(NoAlertPresentException e) {
		e.printStackTrace();
	}
return alertText;
}

/**
 *  methods that sends text to  alert and catches exception if alert not present
 * @param text
 */
public static void sendAlertText(String text) {
	
	try {
		Alert alert =driver.switchTo().alert();
		alert.sendKeys(text);
		
	}catch(NoAlertPresentException e) {
		e.printStackTrace();
	}
}

public static void switchToFrame(String nameOrId) {
	
	try {
		driver.switchTo().frame(nameOrId);

		
	}catch(NoSuchFrameException e) {
		e.printStackTrace();
	}
}

public static void switchToFrame(WebElement element) {
	
	try {
		driver.switchTo().frame(element);

		
	}catch(NoSuchFrameException e) {
		e.printStackTrace();
	}
}

public static void switchToFrame(int index) {
	
	try {
		driver.switchTo().frame(index);

		
	}catch(NoSuchFrameException e) {
		e.printStackTrace();
	}
}

/**
 * method switches focus to child window
 */
public static void switchToChildWindow() {
	String mainWindow=driver.getWindowHandle();
	Set<String>windows=driver.getWindowHandles();
	for(String window:windows) {
		if(!window.equals(mainWindow)) {
			driver.switchTo().window(window);
			break;
			
		}
	}
	
	
}
public static WebDriverWait getWaitObject() {
	
	WebDriverWait wait=new WebDriverWait(driver, Constants.EXPLICIT_WAIT_TIME);
	return wait;
}
public static void waitForClickability(WebElement element){
	getWaitObject().until(ExpectedConditions.elementToBeClickable(element));
}

public static WebElement waitForVisibility(WebElement element) {
	return getWaitObject().until(ExpectedConditions.visibilityOf(element));
}
public static void click(WebElement element) {
	waitForClickability(element);
	element.click();
}
public static JavascriptExecutor getJSObject() {
	JavascriptExecutor js=(JavascriptExecutor) driver;
	
	return js;
}

public static void waitAndClick(WebElement element){
	waitForClickability(element);
	element.click();

}
 public static void scrollToElement(WebElement element) {
	getJSObject().executeScript("arguments[0].scrollIntoView(true);",element);
	
}
 /**
  * Method that will scroll the page down based on the passed pixel parameters
  * @param pixel
 * @return 
  */
 public static void scrollDown(int pixel) {
	 getJSObject().executeScript("window.scrollBy(0,"+pixel+")");
	
}
/**
 * Method that will scroll the page up based on the passed pixel parameters
 * @param pixel
 * @return 
 */
 public static void scrollUp(int pixel) {
	 getJSObject().executeScript("window.scrollBy(0,-"+pixel+")");
}
 /**
  * This method will take a screenshot
  * @param filename
  */
 public static void takeScreenshot(String filename) {
	 TakesScreenshot ts=(TakesScreenshot)driver;///downcasting
		//create picture in a form of bytes --> we need it to attach it to our scenario
	 File file=ts.getScreenshotAs(OutputType.FILE);
	 
	 try {
	 FileUtils.copyFile(file, new File ("screenshot/"+filename+".png"));
 }catch(Exception ex) {
	 System.out.println("Cannot take screenshot");
 }
 }
 
 public static void wait(int second) {
	 try {
		 Thread.sleep(second*1000);
	 }catch(InterruptedException e) {
		 e.printStackTrace();
		 
	 }
 }
}
