package com.inetBanking.utilities;

import org.testng.TestListenerAdapter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting2 extends TestListenerAdapter {

     static ExtentTest logger;
     static ExtentReports extent;
     static ExtentHtmlReporter reporter;
    @BeforeClass
    public void startreport() {

        extent = new ExtentReports();       
        extent.attachReporter(getHtmlReporter());
        extent.setSystemInfo("Host Name", "SoftwareTestingMaterial");
        extent.setSystemInfo("Environment", "Automation Testing");
        extent.setSystemInfo("User Name", "Rajkumar SM");               
    }
     public ExtentHtmlReporter getHtmlReporter()
    {
        reporter= new ExtentHtmlReporter(System.getProperty("user.dir") +"\\test-output/STMExtentReport.html");
       reporter.loadXMLConfig(System.getProperty("user.dir") + "\\extent-config.xml");
        //reporter.config().setChartVisibilityOnOpen(true);
        reporter.config().setDocumentTitle("QA Automation Report");
        reporter.config().setReportName("Regression Testing");
        reporter.config().setTheme(Theme.STANDARD);
        return reporter;
    }
     @Test
    public void passTest(){
         logger= extent.createTest("Pass Test", "Login");
    //test steps.
     }
     @Test
    public void failTest(){
    logger = extent.createTest("failTest", "Login");
     //test steps.
     }

     //other steps

     @AfterTest
    public void endReport(){
    extent.flush();
       }
}  