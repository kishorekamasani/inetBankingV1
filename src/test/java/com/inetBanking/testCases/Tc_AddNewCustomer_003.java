package com.inetBanking.testCases;

import com.inetBanking.pageObjects.LoginPage;
import com.inetBanking.pageObjects.ManagerPage;
import org.apache.commons.lang3.*;
import org.testng.annotations.Test;

public class Tc_AddNewCustomer_003 extends BaseClass {
	
	@Test
	public void addNewCustomer() throws InterruptedException {
		
	LoginPage lp=new LoginPage(driver);
	lp.setUserName(userName);
	lp.setPsw(password);
	Thread.sleep(3000);
	lp.clickSubmit();
	
	Thread.sleep(5000);
	
	ManagerPage mp=new ManagerPage(driver);
	Thread.sleep(5000);
	mp.newCustLink();
	Thread.sleep(5000);
	mp.custName(userName);
	mp.custGender();
	mp.custDob("23", "08", "1983");
	mp.custAddress("Bach Strasse");
	mp.custCity("Bad Homburg");
	mp.CustState("Hessen");
	mp.custPin("1234");
	mp.custMobNum("1234567890");
	String email= randomString()+"@gmail.com";
	mp.custEmail(email);
	mp.custpsw("abcd123");
	mp.submit();
	}

	public String randomString() {
		String random=RandomStringUtils.randomAlphabetic(8);
		return random;
	}
}
