package com.qa.concepts;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HabdleWindowPopup {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver","D:/AutomationJars/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		driver.get("http://popuptest.com/goodpopups.html");
		
		driver.findElement(By.xpath("//*[text()='Good PopUp #3']")).click();
		
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it = handles.iterator();
		
		String parentWindow = it.next();
		System.out.println("parentWindow: "+parentWindow);
		
		String child1 = it.next();
		System.out.println("child1: "+child1);
		
		driver.switchTo().window(child1);
		System.out.println("child title: "+driver.getCurrentUrl());
		
		driver.close();
		
		driver.switchTo().window(parentWindow);
		System.out.println("Parent Title: "+driver.getTitle());
	}
}
