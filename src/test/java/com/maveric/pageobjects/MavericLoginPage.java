package com.maveric.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MavericLoginPage {
	
	@FindBy(id="LoginForm_username")
	private WebElement userNameEle;  // encapsulation --> protecting webelement
	 
	@FindBy(name="LoginForm[password]")
	 WebElement passwordEle;
	
	@FindBy(xpath="//input[@type='submit']")
	 WebElement loginEle;

	
	@FindBy(how=How.ID,using="LoginForm_password_em_")
	WebElement errorTextEle;
	
	@FindBy(tagName="a")
	List<WebElement> linksEle;
	
	 
	 WebDriver  driver;
	 WebDriverWait wait;
	
	public MavericLoginPage(WebDriver driver,WebDriverWait wait) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
		this.wait=wait;
		System.out.println(this.driver);
		
		PageFactory.initElements(driver, this);
		// MavericLoginPage.init(driver, this);
	}
	
	
/*	public static void init(WebDriver driver,MavericLoginPage login)
	{
		System.out.println(login.driver);
		System.out.println(login.userNameEle);
		System.out.println(login.passwordEle);
		System.out.println(login);
	}*/
	
	public  void sendUserName(String userName)
	{
	
	
	userNameEle.sendKeys(userName);

}
	public  void sendPassword(String password)
	{
	
	passwordEle.sendKeys(password);
}
	
	public  void clickOnLogin()
	{
		
		loginEle.click();
	}
	
	public int getNoOfLinks()
	{
		//List<WebElement> linksEle =driver.findElements(By.tagName("a"));
		int noOfLinks=linksEle.size();
		
		return noOfLinks;  // fetches all the list of links available on the page
	}

}

