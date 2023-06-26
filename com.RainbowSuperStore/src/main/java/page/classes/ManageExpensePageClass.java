package page.classes;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.FileUploadRobotClass;
import utilities.GeneralUtilities;

public class ManageExpensePageClass {

	WebDriver driver;

	GeneralUtilities gl = new GeneralUtilities();

	FileUploadRobotClass fu=new FileUploadRobotClass();
	
	public ManageExpensePageClass(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h1[text()='List Expense']")
	WebElement listExpense;

	@FindBy(xpath = "//a[text()=' New']")
	WebElement newCategory;

	@FindBy(xpath = "//a[text()=' Search']")
	WebElement searchCategory;

	@FindBy(xpath = "//button[@name='Search']")
	WebElement searchButton;

	@FindBy(xpath = "//*[@class='btn btn-danger']")
	WebElement saveButton;
	
	@FindBy(id="user_id")
	WebElement userDropdown;
	
	@FindBy(id="ex_date")
	WebElement date;
	
	@FindBy(id="order_id")
	WebElement orderIdDropdown;
	
	@FindBy(id="purchase_id")
	WebElement purchaseIdDropdown;
	
	@FindBy(name="ex_type")
	WebElement expenseType;
	
	@FindBy(id="amount")
	WebElement amount;
	
	@FindBy(name="userfile")
	WebElement chooseFile;
	
	@FindBy(id="um")
	WebElement searchUserDropdown;
	
	@FindBy(name="ty")
	WebElement searchExpenseType;
	
	@FindBy(xpath = "//*[@class='alert alert-success alert-dismissible']")         
	WebElement SuccessfullyMessage;
	
	@FindBy(xpath = "//button[@name='Search']")
	WebElement searchButton1;
	
	@FindBy(xpath = "//td[text()='Purchase--11 (Admin -AD)']")
	WebElement  searchElementOnTable;
	
	public String getTextOfListExpenseText() {
		return gl.getTextofElement(listExpense);
	}

	public void clickOnNewCategory() {
		gl.clickElement(newCategory);
	}

	public void clickOnSearchCategory() {
		gl.clickElement(searchCategory);
	}

	public void clickOnSearchButton() {
		gl.clickElement(searchButton);
	}
	
	public void clickOnSaveButton()
	{
	gl.clickElementJS(saveButton, driver);
	}
	public void clickOnSearchButton1()
	{
	gl.clickElementJS(searchButton1, driver);
	}
	
	public void selectTheValueOfUserDropdown(int value)
	{
	gl.selectByIndex(userDropdown, value);
	}
	
	public void selectTheValueOfSearchUserDropdown(int value)
	{
	gl.selectByIndex(searchUserDropdown, value);
	}
	
	public void typeElementOnDateTextBox(String exdate)
	{
	gl.clearElement(date);
	gl.typeElement(date,exdate);
	}
	
	public void selectTheValueOfExpenseType(int value)
	{
	gl.selectByIndex(expenseType, value);
	}
	public void selectTheValueOfOrderId(int value)
	{
	gl.selectByIndex(orderIdDropdown, value);
	}
	public void selectTheValueOfSearchExpenseType(int value)
	{
	gl.selectByIndex(searchExpenseType, value);
	}
	public void selectTheValueOfPurchaseIdDropdown(int value)
	{
	gl.selectByIndex(purchaseIdDropdown, value);
	}
	public void typeElementOnAmountTextBox(String value)
	{
	gl.typeElement(amount,value);
	}
	public void chooseFileUploading(String file)
	{
	gl.typeElement(chooseFile, file);
	}
	public void chooseFileUploadingRobotClass() throws AWTException
	{
		gl.clickElementJS(chooseFile, driver);
		fu.FileUpload();
	}
	public String getTextOfSuccessfullyMessage()
	{
	return gl.getTextofElement(SuccessfullyMessage);
	}
	public String getTextOfSearchElementOnTable()
	{
	return gl.getTextofElement(searchElementOnTable);
	}
	
	
}
