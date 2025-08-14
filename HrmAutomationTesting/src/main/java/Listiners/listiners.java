package Listiners;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import GenericUtility.WebDriverUtilityHrm;
import baseClassUtility.BaseClass;

public class listiners implements ITestListener {
	
	public static WebDriver driver;
	WebDriverUtilityHrm wu= new WebDriverUtilityHrm();
	@Override
	public void onTestSuccess(ITestResult result) {
		Reporter.log("test sucessfull");
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		String method = result.getMethod().getMethodName();
		
		TakesScreenshot ts= (TakesScreenshot) BaseClass.sDriver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File tgt = new File(".\\errorShot\\"+result.getName()+Math.random()+".png");
		try {
			FileHandler.copy(src, tgt);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
	}

	
}
