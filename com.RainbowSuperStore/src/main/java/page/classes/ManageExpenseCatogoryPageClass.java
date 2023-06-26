package page.classes;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;
public class ManageExpenseCatogoryPageClass {
	
	WebDriver driver;
	
	GeneralUtilities gl=new GeneralUtilities();
	
	public ManageExpenseCatogoryPageClass(WebDriver driver)
		{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		}
	
	
	@FindBy(xpath="//h1[text()='Expense Category']")
	WebElement expenseCategory;
	
	@FindBy(xpath="//a[text()=' New']")
	WebElement  newCategory;
	
	@FindBy(xpath="//a[text()=' Search']")
	WebElement  searchCategory;
	
	@FindBy(xpath="//button[@name='Search']")
	WebElement  searchButton;
	
	@FindBy(id="name")
	WebElement  titleTextBox;
	
	@FindBy(name="Create")
	WebElement saveButton;
	
	@FindBy(xpath = "//*[@class='alert alert-success alert-dismissible']")         
	WebElement createdSuccessfullyMessage;
	
	@FindBy(xpath = "//*[@class='alert alert-success alert-dismissible']")         
	WebElement deleteMessage;
	
	@FindBy(id="un")
	WebElement  searchTitleTextBox;
	
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[1]")
	WebElement  searchElementOnTable;
	
	@FindBy(xpath = "//*[@class='btn btn-sm btn btn-danger btncss']")
	WebElement  deleteElement;
	
	public String getTextOfExpenseCategoryText()
		{
		return gl.getTextofElement(expenseCategory);
		}
	
	public void clickOnNewCategory()
		{
		gl.clickElement(newCategory);
		}
	
	public void clickOnSearchCategory()
		{
		gl.clickElement(searchCategory);
		}
	public void clickOnSearchButton()
		{
		gl.clickElement(searchButton);
		}
	
	public void typeElementOnTextBox(String title)
		{
		gl.typeElement(titleTextBox,title);
		}
	
	public void clickOnSaveButton()
		{
		gl.clickElement(saveButton);
		}
	
	public String getTextOfSuccessfullyMessage()
		{
		return gl.getTextofElement(createdSuccessfullyMessage);
		}
	public String getTextOfDeleteMessage()
		{
		return gl.getTextofElement(deleteMessage);
		}
	
	public void typeElementOnSearchTextBox(String title)
		{
		gl.typeElement(searchTitleTextBox,title);
		}
	
	public String getTextOfSearchElementOnTable()
		{
		return gl.getTextofElement(searchElementOnTable);
		}
	public void clickOnDelete()
		{
		gl.clickElement(deleteElement);
		gl.alertAccept(driver);
		}
}
