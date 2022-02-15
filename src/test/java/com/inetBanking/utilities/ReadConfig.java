package com.inetBanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;




public class ReadConfig {
	
	Properties pro;
	
	public  ReadConfig() {
		
		File src=new File("./Configuration/config.properties");
		try {
		FileInputStream fis=new FileInputStream(src);
		pro=new Properties();
		pro.load(fis);
		
	}catch(Exception e) {
		System.out.println("Exception is "+e.getMessage());
	}

}
	public String getURL() {
		String url=pro.getProperty("baseURL");
		return url;
	}
	public String getUserName() {
		String userName=pro.getProperty("userName");
		return userName;
	}
	public String getPassword() {
		String psw=pro.getProperty("password");
		return psw;
	}
	public String getChromePath() {
		String chromePath=pro.getProperty("chromePath");
		return chromePath;
	}
	public String getIePath() {
		String iePath=pro.getProperty("iePath");
		return iePath;
	}
	public String getFireFoxPath() {
		String fireFoxPath=pro.getProperty("firefoxPath");
		return fireFoxPath;
	}
	
	
	
}
	
