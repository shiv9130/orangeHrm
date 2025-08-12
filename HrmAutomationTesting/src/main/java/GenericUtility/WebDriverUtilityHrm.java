package GenericUtility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtilityHrm {
	
	WebDriver driver;
	WebElement ele;
	int index;
	
	public void implicitlyWaitLoadPage(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	public void explicitWaitLoadPage(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	public void maximizeWin(WebDriver driver) {
		driver.manage().window().maximize();
	}
	
	public void frameIndex(WebDriver driver) {
		driver.switchTo().frame(index);
	}
	
	public void frameEle(WebDriver driver) {
			driver.switchTo().frame(ele);
	}
	
	public void alertAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
		
	}
	
	public void alertDismiss(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	
	public void dropDown(WebDriver driver,String Value) {
		Select sel = new Select(ele);
		sel.selectByIndex(index);
		sel.selectByValue(Value);
	}
	
	public void mouseAction(WebDriver driver) {
		Actions act = new Actions(driver);
		act.moveToElement(ele);
		act.scrollToElement(ele);
		act.click();
		act.doubleClick();
	}
	
	public void screenShot(WebDriver driver) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File file = new File("./\\ScreenShot"+Math.random()+".png");
		try {
			FileHandler.copy(src, file);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

}
