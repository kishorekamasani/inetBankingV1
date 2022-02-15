package com.inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManagerPage {
	
	WebDriver ldriver;
	
	public ManagerPage(WebDriver rdriver) {
		
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
		
	}
	
	//@FindBy(xpath="/html[1]/body[1]/div[3]/div[1]/ul[1]/li[2]/a[1]")
	//@FindBy(linkText="New Customer")
	@FindBy(xpath="/html[1]/body[1]/div[3]/div[1]/ul[1]/li[2]/a[1]")
	WebElement lnkNewCust;
	
	@FindBy(xpath="//input[@name='name']")
	WebElement txtCustName;
	
	@FindBy(xpath="//input[@value='m']")
	WebElement rdbtnGender;
	
	@FindBy(xpath="//input[@id='dob']")
	WebElement dob;
	
	@FindBy(css="textarea[name='addr']")
	WebElement txtAddress;
	
	@FindBy(css="input[name='city']")
	WebElement txtCity;
	
	@FindBy(xpath="//input[@name='city']")
	WebElement txtState;
	
	@FindBy(xpath="//input[@name='pinno']")
	WebElement txtPin;
	
	@FindBy(xpath="(//input[@name='telephoneno'])[1]")
	WebElement txtMobNum;
	
	@FindBy(css="input[name='emailid']")
	WebElement txtEmail;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement txtPsw;
	
	@FindBy(xpath="//input[@name='sub']")
	WebElement btnformSubmit;
	
	public void newCustLink() {
		System.out.println("BEforeClick");
		lnkNewCust.click();
		System.out.println("AfterClick");
	}
	public void custName(String name) {
		txtCustName.sendKeys(name);
	}

	public void custGender() {
		rdbtnGender.click();
	}
	public void custDob(String dd,String mm,String yyyy) {
		dob.sendKeys(dd);
		dob.sendKeys(mm);
		dob.sendKeys(yyyy);
	}
	public void custAddress(String address) {
		txtAddress.sendKeys(address);
	}
	public void custCity(String city) {
		txtCity.sendKeys(city);
	}
	public void CustState(String state) {
		txtState.sendKeys(state);
	}
	public void custPin(String pin) {
		txtPin.sendKeys(pin);
	}
	public void custMobNum(String number) {
		txtMobNum.sendKeys(number);
	}
	public void custEmail(String email) {
		txtEmail.sendKeys(email);
	}
	public void custpsw(String pwd) {
		txtPsw.sendKeys(pwd);
	}
	public void submit() {
		btnformSubmit.click();
	}
}
