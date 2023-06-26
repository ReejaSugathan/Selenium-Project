package page.classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class ManageProductPageClass {
	
	WebDriver driver;
	
	GeneralUtilities gl=new GeneralUtilities();
	
	public ManageProductPageClass(WebDriver driver)
		{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		}
	
	@FindBy(xpath="//a[text()=' Search']")
	WebElement  searchCategory;
	
	@FindBy(xpath="//input[@name='cd']")
	WebElement  productCodeTextBox;
	
	@FindBy(xpath="//button[text()='Search']")
	WebElement  searchButton;
	
	@FindBy(xpath="//button[text()='P1185']")
	WebElement  searchProduct;
	
	public void clickOnSearchCategory()
		{
		gl.clickElement(searchCategory);
		}
	public void clickOnSearchButton()
		{
		gl.clickElement(searchButton);
		}
	public void typeProductCodeOnTextBox(String title)
		{
		gl.typeElement(productCodeTextBox,title);
		}
	public String getTextOfSearchProduct()
		{
		return gl.getTextofElement(searchProduct);
		}
}
