package com.qa.concepts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseMovementConcepts {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver","D:/AutomationJars/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		driver.get("https://www.spicejet.com/");
		Actions action = new Actions(driver);
		WebElement ele = driver.findElement(By.xpath("//*[text()='Add-Ons']"));
		action.moveToElement(ele).build().perform();
		driver.findElement(By.xpath("//*[contains(text(),'Friends and Family')]")).click();
		
	}

}
