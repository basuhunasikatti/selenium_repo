package com.qa.concepts;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.JavascriptExecutor;	


public class JavaScriptConcepts {

	public static void main(String[] args) throws IOException {
		
		System.setProperty("webdriver.chrome.driver","D:/AutomationJars/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		driver.get("https://www.spicejet.com/");
		WebElement login = driver.findElement(By.xpath("//*[contains(text(),'Login / Signup')]"));
		
		//Highlight an element
		flash(login,driver);
		
		//Draw border to an element
		drawBorder(login,driver);
		
		//File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//FileUtils.copyFile(srcFile,new File("C:/Users/Basavaraj/git/selenium_repo/SeleniumSessions/test-output/Screenshots/test1.png"));
				
		//generateAlertMessage("There is an issue with Login/SignUp button",driver);
		
		WebElement mediaCenter = driver.findElement(By.xpath("//*[text()='Media Center']"));
		
		//Scroll to specific element
		//scrollToSpecificElementByJS(mediaCenter,driver);
		
		clickOnElementByJS(login,driver);
		
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		
		refreshBrowserByJS(driver);
		
		//Get Title by JS
		String title = getTitleByJS(driver);
		System.out.println("**************************************************************");
		System.out.println("Title: "+title);
		System.out.println("**************************************************************");
		
		//Get entire page text by JS
		String pageText = getPageInnerTextByJS(driver);
		System.out.println("Page Text: "+pageText);
		System.out.println("**************************************************************");
		
		//Scroll Page down
		//scrollPageDownByJS(driver);
		
		driver.close();
	}
	
	public static void flash(WebElement element,WebDriver driver){
		
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		String color = element.getCssValue("backgroundColor");
		for(int i=0;i<100;i++){
			changeColour("rgb(0,200,0)",element,driver);
			changeColour("#E6E6FA",element,driver);
		}
	}
	
	public static void changeColour(String colour,WebElement element,WebDriver driver){
		
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].style.backgroundColor='"+colour+"'",element);
	}
	
	public static void drawBorder(WebElement element,WebDriver driver){
		
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].style.border='3px solid blue'",element);
	}
	
	public static void generateAlertMessage(String message,WebDriver driver){
		
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("alert('"+message+"')");
	}
	
	public static void clickOnElementByJS(WebElement element,WebDriver driver){
		
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].click();",element);
	}
	
	public static void refreshBrowserByJS(WebDriver driver){
		
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("history.go(0)");
	}
	public static String getTitleByJS(WebDriver driver){
		
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String title = js.executeScript("return document.title;").toString();
		return title;
	}
	public static String getPageInnerTextByJS(WebDriver driver){
		
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String pageText = js.executeScript("return document.documentElement.innerText;").toString();
		return pageText;
	}
	
	public static void scrollPageDownByJS(WebDriver driver){
		
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("windows.scrollTo(0,document.body.scrollHeight)");
	}
	
	public static void scrollToSpecificElementByJS(WebElement element, WebDriver driver){
		
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].scrollIntoView(true)",element);
	}
}
