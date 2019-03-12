package com.maveric.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MavericPortalPage {
	
	 By qmsLoc=By.xpath("//div[text()='Invalid password']");
	 WebDriver  driver;
	 WebDriverWait wait;
	
	public MavericPortalPage(WebDriver driver,WebDriverWait wait) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
		this.wait=wait;
		System.out.println(this.driver);
	}
	public  String waitForQMSDisplay()
	
	
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(qmsLoc));
		return driver.getTitle();
	}
	
	

}
