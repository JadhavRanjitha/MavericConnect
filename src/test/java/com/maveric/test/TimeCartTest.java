package com.maveric.test;

import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import com.maveric.initialization.LauchActivities;
import com.maveric.pageobjects.MavericLoginPage;

import jdk.internal.org.objectweb.asm.commons.TryCatchBlockSorter;
import jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode;

public class TimeCartTest extends LauchActivities {
	

	
	public void timeCartFillTest()
	{
		System.out.println("timecart test ");
		
		MavericLoginPage login = new MavericLoginPage(driver,wait);
		
		int links = login.getNoOfLinks();
		System.out.println(links);
		
		login.clickOnLogin();
		
		String pageSource = driver.getPageSource();
		
		Assert.assertTrue("Assertion on save of time cart details", pageSource.contains(""));
		
		
	}
	
	
	
	

}

