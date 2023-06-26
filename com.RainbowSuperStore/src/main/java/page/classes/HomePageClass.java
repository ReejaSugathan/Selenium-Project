package page.classes;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class HomePageClass {

	WebDriver driver;
	
	GeneralUtilities gl=new GeneralUtilities();
	
	public HomePageClass(WebDriver driver)
		{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		}
	
	@FindBy(xpath = "//*[@class='fas fa-arrow-circle-right']")
	List<WebElement> allTiles;
	
	@FindBy(xpath = "//p[contains(text(),'Manage Orders')]")
	WebElement manageOrders;

	@FindBy(xpath = "(//p[contains(text(),'Manage Expense')])[1]")
	WebElement manageExpense;
	
	@FindBy(xpath = "//p[contains(text(),'Expense Category')]")
	WebElement manageExpenseCatogory;
	
	@FindBy(xpath = "(//p[contains(text(),'Manage Expense')])[2]")
	WebElement manageExpense1;
	
	@FindBy(xpath = "//p[contains(text(),'Manage Product')]")
	WebElement manageProduct;
	
	
	public boolean isAllTilesDisplayed() {
		
		for(WebElement ele:allTiles){
			gl.isDisplayedMethod(ele);
	    	}
		return true;
		}
	
	public void clickOnManageExpense(){
		gl.clickElement(manageExpense);
		}
	public void clickOnManageExpense1(){
		gl.clickElement(manageExpense1);
		}
	
	public void clickOnManageExpenseCatogory(){
		gl.clickElement(manageExpenseCatogory);
		}
	public void clickOnManageProduct(){
		gl.clickElement(manageProduct);
		}

}