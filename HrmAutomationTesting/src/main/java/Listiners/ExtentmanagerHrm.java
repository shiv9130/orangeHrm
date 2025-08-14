package Listiners;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.devtools.v134.systeminfo.SystemInfo;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import BaseClassHrm.baseClassHrm;
import GenericUtility.JavaUtilityHrm;
import GenericUtility.WebDriverUtilityHrm;
import io.opentelemetry.context.Context;

public class ExtentmanagerHrm implements ITestListener {
     public ExtentSparkReporter sparkReporter;
     public ExtentReports report;
     public ExtentTest test;
     String ReportName;
     JavaUtilityHrm ju = new JavaUtilityHrm();
     WebDriverUtilityHrm wu = new WebDriverUtilityHrm();
	
     @Override
 	public void onStart(ITestContext context) {
    	 String currentdate = ju.getCurrentDateTime();
    	 ReportName = "Test_Report" +currentdate+".html";
    	 sparkReporter.config().setDocumentTitle("HrmAutomation");
    	 sparkReporter.config().setReportName("HrmTesting");
    	 sparkReporter.config().setTheme(Theme.DARK);
    	 
    	 report= new ExtentReports();
    	 report.attachReporter(sparkReporter);
    	 report.setSystemInfo("username", System.getProperty("username"));
    	 
    	 String brow = context.getCurrentXmlTest().getParameter("browser");
    	 report.setSystemInfo("browser", brow);
    	 
    	 String osys = context.getCurrentXmlTest().getParameter("os");
    	 report.setSystemInfo("os", osys);
    	 
    	 List<String> group = context.getCurrentXmlTest().getIncludedGroups();
    	 if(!group.isEmpty()) {
    		 report.setSystemInfo("group", group.toString());
    	 }
 	}

     
	@Override
	public void onTestStart(ITestResult result) {
		//create test
		 test = report.createTest(result.getTestClass().getTestName());//first get class test and then name of class
	     test.assignCategory(result.getMethod().getGroups());
	     test.log(Status.PASS, result.getName()+"test sucessfully passed");
	}
	@Override
	public void onTestFailure(ITestResult result) {
		String currentdate = ju.getCurrentDateTime();
		test=report.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.FAIL,result.getName()+ "test failed");
		test.log(Status.INFO, result.getThrowable().getMessage());
		
		TakesScreenshot sc = (TakesScreenshot) baseClassHrm.sdriver;
		File src = sc.getScreenshotAs(OutputType.FILE);
		File file = new File("./ScreenShot\\"+result.getName()+currentdate+".png");
		try {
			FileHandler.copy(src, file);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test=report.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.SKIP, result.getName()+"test skipped");
		test.log(Status.INFO, result.getThrowable().getMessage());
	
	}

	
	@Override
	public void onFinish(ITestContext context) {
		report.flush();
		
	}

}
