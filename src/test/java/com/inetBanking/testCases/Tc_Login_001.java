package com.inetBanking.testCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;

//import junit.framework.Assert;

public class Tc_Login_001 extends BaseClass{
	
	//private static Logger logger=	LogManager.getLogger(Tc_Login_001.class.getName());
	@Test
	public void loginTest() throws InterruptedException, IOException {
		//driver.get("https://www.google.com/");
		//driver.get(baseURL);
		
		//logger.info("URL is Opened");
		//System.out.println(driver.getCurrentUrl());
		
		
		//there are two ways we can use log4j(using Log4j.Properties) //commented one is another way(using Log4j2.xml)
		
		LoginPage lp=new LoginPage(driver);
		 Thread.sleep(4000);
		lp.setUserName(userName);
		logger.info("user name entered");
		lp.setPsw(password);
		logger.info("password entered");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		lp.clickSubmit();
		
		
		
		System.out.println(driver.getTitle());
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePageq"))
		{
			//Assert.assertTrue(true);
			logger.info("Loggin test passed");
		}
		else
		{
			System.out.println("before calling capture screen method");
			captureScreen(driver,"loginTest");
			System.out.println("After calling capture screen method");
			//Assert.assertTrue(false);
			logger.info("Loggin test failed");
			System.out.println(driver.getTitle());
		}
	}

}
