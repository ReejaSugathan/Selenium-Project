package execute.page.classes;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import page.classes.HomePageClass;
import page.classes.LoginPageClass;
import page.classes.ManageExpensePageClass;
import retry.analyzer.RetryAnalyzer;


public class ManageExpensePageTestClass extends BaseClass{
	
	LoginPageClass lp;
	HomePageClass hp;
	ManageExpensePageClass mep;
	
	@Test (priority = 1,retryAnalyzer = RetryAnalyzer.class, groups = {"group1"})
	public void verifyManageExpencePageIsDisplayedOrNot() {
		
		lp = new LoginPageClass(driver);
		hp = new HomePageClass(driver);
		mep = new ManageExpensePageClass(driver);
		
		lp.login("admin", "admin");
		hp.clickOnManageExpense();
		hp.clickOnManageExpense1();
		
		String actual=mep.getTextOfListExpenseText();
		String expected = "List Expense";
		Assert.assertEquals(actual, expected);
	}
  @Test (priority = 2,retryAnalyzer = RetryAnalyzer.class, groups = {"create"})
  public void verifyToCreateNewManageExpense() throws AWTException, IOException{
	  
	  	lp = new LoginPageClass(driver);
		hp = new HomePageClass(driver);
		mep = new ManageExpensePageClass(driver);
		
		lp.login("admin", "admin");
		hp.clickOnManageExpense();
		hp.clickOnManageExpense1();
		
		mep.clickOnNewCategory();
		mep.selectTheValueOfUserDropdown(1);
		
		mep.selectTheValueOfOrderId(5);
		mep.selectTheValueOfPurchaseIdDropdown(5);
		mep.typeElementOnDateTextBox("25/06/2023");
		mep.selectTheValueOfExpenseType(2);
		
		mep.typeElementOnAmountTextBox(mep.readinteger(5, 1));
		//mep.typeElementOnAmountTextBox("400");
		//mep.chooseFileUploading(System.getProperty("user.dir")+"\\src\\test\\resources\\project.png");
		mep.chooseFileUploadingRobotClass();
		
		mep.clickOnSaveButton();
		String actual=mep.getTextOfSuccessfullyMessage();
		String expected = "�\n"
				+ "Alert!\n"
				+ "Expense Record Created Successfully";
		Assert.assertEquals(actual, expected);
  }
  @Test (priority = 3,retryAnalyzer = RetryAnalyzer.class, groups = {"search"})
  public void verifyToSearchCreatedManageExpense(){
	  
	  	lp = new LoginPageClass(driver);
		hp = new HomePageClass(driver);
		mep = new ManageExpensePageClass(driver);
		
		lp.login("admin", "admin");
		hp.clickOnManageExpense();
		hp.clickOnManageExpense1();
		
		mep.clickOnSearchCategory();
		mep.selectTheValueOfSearchUserDropdown(1);
		mep.selectTheValueOfSearchExpenseType(2);
		
		mep.clickOnSearchButton1();
		String actual=mep.getTextOfSearchElementOnTable();
		String expected = "Purchase--11 (Admin -AD)";
		Assert.assertEquals(actual, expected);
  }
}
