package com.qa.concepts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class HTMLUnitDriverConcept {

	public static void main(String[] args) {
		
		//HTMLUnit Driver
		//We have to HTMLUnitDriver jar file
		
		//Advantages
		//1.Testing is happening behind the scene, no browser is launched
		//2.Very fast - execution of test cases - performance of the script
		//3. Not suitable for Action class - user actions like mouse movement ,drag and drop
		//4.GhostDriver - HeadlessDriver
			//HTMLUnit Driver - Java
			//PhantomIS - JavaScript
		
		System.setProperty("webdriver.chrome.driver","D:/AutomationJars/chromedriver.exe");
		//WebDriver driver = new ChromeDriver();
		WebDriver driver = new HtmlUnitDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		driver.get("https://www.google.com/");
		
		String title = driver.getTitle();
		System.out.println("Title: "+title);
	}

}
