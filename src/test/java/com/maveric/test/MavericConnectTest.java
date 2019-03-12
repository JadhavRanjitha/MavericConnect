package com.maveric.test;

import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import org.testng.annotations.Test;

import com.maveric.initialization.LauchActivities;
import com.maveric.pageobjects.CorporatePointOfContact;
import com.maveric.pageobjects.MavericLoginPage;
import com.maveric.pageobjects.MavericPortalPage;

import com.maveric.utilities.PropertiesHandler;

public class MavericConnectTest extends LauchActivities {
	

	
	@Test(priority=1,groups="high")
	public void positiveCredentialCheck() throws IOException
	{
	
	
		String url=prop.getProperty("url");
	String userName=prop.getProperty("username");
	String password=prop.getProperty("password");
	String expectedTitle=prop.getProperty("expectedtitle");
	
	driver.get(url);
	MavericLoginPage login = new MavericLoginPage(driver,wait);
	
	int links = login.getNoOfLinks();
	System.out.println(links);
	
	
	login.sendUserName(userName);
	login.sendPassword(password);
	login.clickOnLogin();
	
	MavericPortalPage portal = new MavericPortalPage(driver,wait);
	
	String actualTitle= portal.waitForQMSDisplay();
	Assert.assertEquals(actualTitle, expectedTitle, "for possitive scenario");
	
	
	
}

}


