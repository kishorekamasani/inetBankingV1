package com.inetBanking.testCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;
import com.inetBanking.utilities.XLUtils;

public class Tc_LoginDDT_002 extends BaseClass {

	
	@Test(dataProvider="LoginData")
	public void loginDDT(String user,String pwd) {
		LoginPage lp= new LoginPage(driver);
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//lp.clickCookies();
		lp.setUserName(user);
		lp.setPsw(pwd);
		lp.clickSubmit();
		
		if(isAlertPresent()==true) {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("Login failed");
		}else {
			Assert.assertTrue(true);
			lp.clickLogout();
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		}
		
	}
	
	public boolean isAlertPresent() {
		try {
		driver.switchTo().alert();
		return true;
	}catch(NoAlertPresentException e) {
		return false;
	}
	}
	
	@DataProvider(name="LoginData")
	String[][] getData() throws IOException{
		String path=System.getProperties().getProperty("user.dir")+"/src/test/java/com/inetBanking/testData/DataSheet.xlsx";
		
		int rowNum=XLUtils.getRowCount(path,"Sheet1");
		int colNum=XLUtils.getCellCount(path,"Sheet1",1);
		
		String logindata[][]= new String [rowNum][colNum];
		
		for(int i=1;i<=rowNum;i++) {
			for(int j=0;j<colNum;j++) {
				logindata[i-1][j]=XLUtils.getCellData(path,"Sheet1",i,j);
			}
		}
		return logindata;
	}
}
