package page.classes;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class LoginPageClass {
	WebDriver driver;
	
	GeneralUtilities gl=new GeneralUtilities();
	
	public LoginPageClass(WebDriver driver)
		{
		this.driver=driver;
		PageFactory.initElements(driver,this);
		}

	@FindBy(name = "username")
	WebElement userName;

	@FindBy(name = "password")
	WebElement password;
	
	@FindBy(id="remember")
	WebElement rememberCheckBox;
	
	@FindBy(xpath = "//button[text()='Sign In']")
	WebElement loginButton;

	@FindBy(xpath = "//a[contains(text(),'Admin')]")
	WebElement AdminText;

	@FindBy(xpath = "//*[@class='alert alert-danger alert-dismissible']")         
	WebElement invalidUsername;
	

	public void login(String uname,String pswd)
		{
		gl.typeElement(userName,uname);
		gl.typeElement(password, pswd);
		gl.clickElement(loginButton);
		}
	
	public String getTextOfAdminText()
		{
		return gl.getTextofElement(AdminText);
		}

	public String getTextOfAlert()
		{
		return gl.getTextofElement(invalidUsername);
		}
	public boolean rememberCheckBoxIsSelected()
		{
		return gl.isSelectedMethod(rememberCheckBox);
		}
}
