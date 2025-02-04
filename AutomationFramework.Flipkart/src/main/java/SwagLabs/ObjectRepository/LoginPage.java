package SwagLabs.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage { //rule 1
	
	//rule 2
	@FindBy(id = "user-name")
	private WebElement usernameEdt;
	
	@FindBy(name = "password")
	private WebElement passwordEdt;
	
	@FindBy(id = "login-button")
	private WebElement loginBtn;
	
	//rule 3 
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this );
	}
	
    //rule 4
	public WebElement getUsernameEdt() {
		return getUsernameEdt();
	}
	
	public WebElement getPasswordEdt() {
		return getPasswordEdt();
	}
	
	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	// Business Library - Generic method
	
	/**
	 * This method will perform login operation
	 * @param USERNAME
	 * @param PASSWORD
	 * 
	 */
	public void loginToApp(String USERNAME , String PASSWORD)
	{
		usernameEdt.sendKeys(USERNAME);
		passwordEdt.sendKeys(PASSWORD);
		loginBtn.click();
	}
}
