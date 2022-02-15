package com.inetBanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
//import com.aventstack.extentreports.reporter.configuration.ChartLocation; 
import com.aventstack.extentreports.reporter.configuration.Theme;

//import junit.framework.Assert;

public class Reporting extends TestListenerAdapter {

	public  ExtentHtmlReporter htmlReporter;
	public  ExtentReports extent;
	public ExtentTest logger;
	
	/*
	 * public static ExtentReports getInstance() { try { if (extent == null)
	 * getHtmlreporter(); System.out.println("null block"); } catch (Exception e) {
	 * // TODO Auto-generated catch block e.printStackTrace(); } return extent; }
	 */
	
	@BeforeTest (alwaysRun=true)	
	private  ExtentReporter getHtmlreporter() {
		String timeStamp = new SimpleDateFormat("yyyy.mm.dd.hh.ss").format(new Date());
		String repName = "TestReport" + timeStamp + ".html";
		
		//htmlReporter = new ExtentHtmlReporter("C:\\Users\\Kisho\\TestProject\\inetBankingV1"+ "\\OUT\\repName.html");
		//htmlReporter.loadXMLConfig("C:\\Users\\Kisho\\TestProject\\inetBankingV1" + "\\extent-config.xml");
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "\\OUT\\"+repName);
		htmlReporter.loadXMLConfig(System.getProperty("user.dir") + "\\extent-config.xml");

	//	String str = System.getProperty("user.dir") + "/test-output/" + repName;

		htmlReporter.config().setDocumentTitle("InetBanking Test Project");
		htmlReporter.config().setReportName("Functional Test Report");
		// htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.DARK);

		//System.out.println("success reporting --->" + str);
System.out.println("html report");
		return htmlReporter;
	}

	@BeforeTest 
	public void onStart(ITestContext testContext) {

		extent = new ExtentReports();
System.out.println("before attach");
		extent.attachReporter(getHtmlreporter());
		System.out.println("After attach");
		extent.setSystemInfo("Host Name", "Local Host");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("user", "kishore");

	}

	

	@Test
	public void onTestSuccess(ITestResult tr) {
		System.out.println("jkdfkjfhkjdfkjadsf******");
		//logger=((Object) extent).StartTest("myTest");
		//logger = extent.createTest("Initial Demo"); // Assert.assertTrue(false);
		logger = extent.createTest(tr.getName());
		logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
		logger.log(Status.INFO, "Test Started");
		System.out.println("on success block");
		//extent.flush();
	}

	@Test
	public void onTestFailure(ITestResult tr) {
		logger = extent.createTest(tr.getName());
		logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
		System.out.println("on failure block");
		String ScreenShotPath = System.getProperty("user.dir") + "\\Screenshots\\" + tr.getName() + ".png";

		File f = new File(ScreenShotPath);

		if (f.exists()) {
			try {
				logger.fail("Screenshot is below:" + logger.addScreenCaptureFromPath(ScreenShotPath));
System.out.println("file exist");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	//public void onTestSkipped(ITestResult tr) {
		
//	}

	//@AfterTest
	public void onFinish(ITestContext testContext) {
		System.out.println("flushed successfully");
		extent.flush(); // extent.close();
		System.out.println("After flushed successfully");
	}
}

/*
 * import java.io.File;
 * 
 * import org.testng.Assert; import org.testng.ITestResult; import
 * org.testng.SkipException; import org.testng.TestListenerAdapter; import
 * org.testng.annotations.AfterMethod; import org.testng.annotations.AfterTest;
 * import org.testng.annotations.BeforeTest; import org.testng.annotations.Test;
 * 
 * import com.relevantcodes.extentreports.ExtentReports; import
 * com.relevantcodes.extentreports.ExtentTest; import
 * com.relevantcodes.extentreports.LogStatus;
 * 
 * public class Reporting extends TestListenerAdapter{ ExtentReports extent;
 * ExtentTest logger;
 * 
 * 
 * @BeforeTest public void startReport(){ //ExtentReports(String
 * filePath,Boolean replaceExisting) //filepath - path of the file, in .htm or
 * .html format - path where your report needs to generate. //replaceExisting -
 * Setting to overwrite (TRUE) the existing file or append to it //True
 * (default): the file will be replaced with brand new markup, and all existing
 * data will be lost. Use this option to create a brand new report //False:
 * existing data will remain, new tests will be appended to the existing report.
 * If the the supplied path does not exist, a new file will be created. extent =
 * new ExtentReports (System.getProperty("user.dir")
 * +"/output/STMExtentReport.html", true);
 * //extent.addSystemInfo("Environment","Environment Name")
 * System.out.println(System.getProperty("user.dir")
 * +"/output/STMExtentReport.html"); extent .addSystemInfo("Host Name",
 * "SoftwareTestingMaterial") .addSystemInfo("Environment",
 * "Automation Testing") .addSystemInfo("User Name", "Rajkumar SM"); //loading
 * the external xml file (i.e., extent-config.xml) which was placed under the
 * base directory //You could find the xml file below. Create xml file in your
 * project and copy past the code mentioned below extent.loadConfig(new
 * File(System.getProperty("user.dir")+"/Extent-Config.xml")); //
 * htmlReporter.loadXMLConfig(System.getProperty("user.dir")+
 * "/Extent-Config.xml");
 * 
 * }
 * 
 * @Test public void passTest(){ //extent.startTest("TestCaseName",
 * "Description") //TestCaseName – Name of the test //Description – Description
 * of the test //Starting test logger = extent.startTest("passTest");
 * Assert.assertTrue(true); //To generate the log when the test case is passed
 * logger.log(LogStatus.PASS, "Test Case Passed is passTest"); }
 * 
 * @Test public void failTest(){ logger = extent.startTest("failTest");
 * Assert.assertTrue(false); logger.log(LogStatus.PASS,
 * "Test Case (failTest) Status is passed"); }
 * 
 * @Test public void skipTest(){ logger = extent.startTest("skipTest"); throw
 * new SkipException("Skipping - This is not ready for testing "); }
 * 
 * @AfterMethod public void getResult(ITestResult result){ if(result.getStatus()
 * == ITestResult.FAILURE){ logger.log(LogStatus.FAIL,
 * "Test Case Failed is "+result.getName()); logger.log(LogStatus.FAIL,
 * "Test Case Failed is "+result.getThrowable()); }else if(result.getStatus() ==
 * ITestResult.SKIP){ logger.log(LogStatus.SKIP,
 * "Test Case Skipped is "+result.getName()); } // ending test //endTest(logger)
 * : It ends the current test and prepares to create HTML report
 * extent.endTest(logger); }
 * 
 * @AfterTest public void endReport(){ // writing everything to document
 * //flush() - to write or update test information to your report.
 * extent.flush(); //Call close() at the very end of your session to clear all
 * resources. //If any of your test ended abruptly causing any side-affects (not
 * all logs sent to ExtentReports, information missing), this method will ensure
 * that the test is still appended to the report with a warning message. //You
 * should call close() only once, at the very end (in @AfterSuite for example)
 * as it closes the underlying stream. //Once this method is called, calling any
 * Extent method will throw an error. //close() - To close all the operation
 * extent.close(); } }
 */