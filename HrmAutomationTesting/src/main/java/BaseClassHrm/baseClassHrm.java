package BaseClassHrm;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import GenericUtility.ExcelUtilityHrm;
import GenericUtility.WebDriverUtilityHrm;
import GenericUtility.propertyUtilityHrm;
import ObjectRepositoryHrm.loginpage;

public class baseClassHrm {
	public static WebDriver sdriver = null;//for listiners
	propertyUtilityHrm pu= new propertyUtilityHrm();
	ExcelUtilityHrm eu = new ExcelUtilityHrm();
	WebDriverUtilityHrm wu = new WebDriverUtilityHrm();
	public WebDriver driver=null;//to initialize the driver
	
	@BeforeSuite(groups= {"smokeTest","regressionTest"})
	public void configBS() {
		
		Reporter.log("DB connectivity started");
		
	}
	@BeforeTest(groups= {"smokeTest","regressionTest"})
	public void ConfigBT() {
		Reporter.log("pre-condition for test");
		
	}
	@BeforeClass(groups= {"smokeTest","regressionTest"})
	public void configBC() throws IOException{
		String brow = pu.propUtil("Browser");
		String url = pu.propUtil("URL");
		System.out.println(brow);
		if(brow.equalsIgnoreCase("Browser")) {
			driver=new ChromeDriver();
		}else if (brow.equalsIgnoreCase("Browser")) {
			driver=new EdgeDriver();
		}else if (brow.equalsIgnoreCase("Browser")) {
			driver=new FirefoxDriver();
		}else {
			driver = new ChromeDriver();
		}
	
		driver.get(url);
		wu.maximizeWin(driver);
		Reporter.log("browser launch and enter url sucessfully");
		
		
	}
	@BeforeMethod(groups= {"smokeTest","regressionTest"})
	public void configBM() throws IOException{
		loginpage lp = new loginpage(driver);
		String un = pu.propUtil("Username");
		String pw = pu.propUtil("Password");
		
		
		boolean text = lp.getTextLogin().isDisplayed();
		System.out.println(text);
		System.out.println(un);
		System.out.println(pw);
		lp.LoginHrm(un, pw);
		
		Reporter.log("login as user sucessfully");
		
	  }
	@AfterMethod(groups= {"smokeTest","regressionTest"})
	public void configAM() throws IOException{
	
		Reporter.log("logout as user sucessfully");
		
	  }
	
	@AfterClass(groups= {"smokeTest","regressionTest"})
	public void configAC() {
		driver.quit();
		
	}
	
	@AfterTest(groups= {"smokeTest","regressionTest"})
	public void ConfigAT() {
		Reporter.log("post-condition for test");
		
	}
	@AfterSuite(groups= {"smokeTest","regressionTest"})
	public void configAS() {
		
		Reporter.log("DB connectivity closed");
		
	}
	
	
	}


