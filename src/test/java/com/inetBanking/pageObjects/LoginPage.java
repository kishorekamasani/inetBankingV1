package com.inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver){
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(name="uid")
	//@CacheLookup
	WebElement txtUserName;
	
	//driver.findelEment(By.xpath(name="uid"));
	
	@FindBy(name="password")
	//@CacheLookup
	WebElement txtPsw;
	
	@FindBy(name="btnLogin")
	//@CacheLookup
	WebElement btnSubmit;
	
	@FindBy(xpath="/html[1]/body[1]/div[3]/div[1]/ul[1]/li[15]/a[1]")
	//@CacheLookup
	WebElement lnkLogout;
	
	@FindBy(xpath="//span/div/span[text()='Accept All']")
	WebElement acptCookies;
	
	public void setUserName(String uname) {
		txtUserName.sendKeys(uname);
	}
	
	public void setPsw(String Psw) {
		txtPsw.sendKeys(Psw);
	}

	public void clickSubmit() {
		System.out.println("before");
		btnSubmit.click();
		System.out.println("After");
	}
	public void clickLogout() {
		lnkLogout.click();
	}
	public void clickCookies() {
		acptCookies.click();
	}
}
