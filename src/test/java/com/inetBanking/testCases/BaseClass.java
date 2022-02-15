package com.inetBanking.testCases;




import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
/*import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;*/
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetBanking.utilities.ReadConfig;




public class BaseClass {
	
	/*public String baseURL="https://demo.guru99.com/v4/";
	public String userName="mngr381639";
	public String password="edaqysU";
	public String userPath=System.getProperty("user.dir");*/
	
	ReadConfig conf=new ReadConfig();
	public String baseURL=conf.getURL();
	public String userName=conf.getUserName();
	public String password=conf.getPassword();
	public String chromePath=conf.getChromePath();
	public String firefoxpath=conf.getFireFoxPath();
	public String iepath=conf.getIePath();
	

	public Logger logger;
	public static WebDriver driver;
	
	@Parameters({"browser"})
	@BeforeClass
	public void setup(String br) throws InterruptedException
	{
		logger=Logger.getLogger("eBanking");
		PropertyConfigurator.configure("Log4j.properties");
		
		
		if(br.equals("chrome"))
		{
		//System.setProperty("webdriver.chrome.driver", userPath+"//Driver//chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", chromePath);
		driver =new ChromeDriver();
		}
		
		if(br.equals("firefox"))
		{
		//System.setProperty("webdriver.chrome.driver", userPath+"//Driver//chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", firefoxpath);
		driver =new FirefoxDriver();
		}
		if(br.equals("ie"))
		{
		//System.setProperty("webdriver.chrome.driver", userPath+"//Driver//chromedriver.exe");
		System.setProperty("webdriver.ie.driver", iepath);
		driver =new InternetExplorerDriver();
		}
		
		driver.get(baseURL);
		//acceptCookies();
		
	}

	public void acceptCookies() {
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		By accept=	By.xpath("//span/div/span[text()='Accept All']");
		System.out.println("before click");
		//WebElement el = wait.until(presenceOfElementLocated(accept));
		WebElement el =driver.findElement(accept);
		el.click();
		
		System.out.println("after click");
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	public void captureScreen(WebDriver driver,String testName) throws IOException {
		System.out.println("in side capture block");
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/ScreenShots/"+testName+".png");
		FileUtils.copyFile(source,target);
		System.out.println("Screen shot taken");
	}
}
