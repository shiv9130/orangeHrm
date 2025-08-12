package ObjectRepositoryHrm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class loginpage extends basePage {

	public loginpage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath = "//h5[text()='Login']")
	private WebElement textLogin;
	
	@FindBy(name = "username")
	private WebElement txtUsername;
	
	@FindBy(name = "password")
	private WebElement txtPassword;
	
	@FindBy(xpath = "//button[text()=' Login ']")
	private WebElement btnLogin;

	public WebElement getTextLogin() {
		return textLogin;
	}

	public WebElement getTxtUsername() {
		return txtUsername;
	}

	public WebElement getTxtPassword() {
		return txtPassword;
	}

	public WebElement getBtnLogin() {
		return btnLogin;
	}
	
	//business logic class
	
	public void LoginHrm(String username, String password) {
		
		txtUsername.sendKeys(username);
		txtPassword.sendKeys(password);
		btnLogin.click();
	}
	
}
