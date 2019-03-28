package com.qa.sessions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleSearch {
	
	public static void main(String args[]) throws InterruptedException{
		
		System.setProperty("webdriver.chrome.driver","D:/AutomationJars/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		driver.get("https://www.google.com/");
		
		//Thread.sleep(3000);
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("q")));
		
		driver.findElement(By.name("q")).sendKeys("Testing");
		
		//It will give all children of li tag
		List<WebElement> list = driver.findElements(By.xpath("//ul[@role='listbox']//li/descendant::span"));
		
		System.out.println("Total no.of suggestions: "+list.size());
		
		for(int i=0;i<list.size();i++){
			String name = list.get(i).getText();
			System.out.println("List of all Names: "+name);
			
			if(name.contains("Testing types")){
				list.get(i).click();
				break;
			}
		}
	}
}
