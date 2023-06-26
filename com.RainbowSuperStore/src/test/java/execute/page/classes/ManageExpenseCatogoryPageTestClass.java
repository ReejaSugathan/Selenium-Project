package execute.page.classes;


import org.testng.Assert;
import org.testng.annotations.Test;

import page.classes.HomePageClass;
import page.classes.LoginPageClass;
import page.classes.ManageExpenseCatogoryPageClass;

public class ManageExpenseCatogoryPageTestClass extends BaseClass {

	LoginPageClass lp;
	HomePageClass hp;
	ManageExpenseCatogoryPageClass mecp;
	
	@Test (priority = 1)
	public void verifyManageExpenceCatogoryPageIsDisplayedOrNot() {
		
		lp = new LoginPageClass(driver);
		hp = new HomePageClass(driver);
		mecp = new ManageExpenseCatogoryPageClass(driver);
		
		lp.login("admin", "admin");
		hp.clickOnManageExpense();
		hp.clickOnManageExpenseCatogory();
		
		String actual=mecp.getTextOfExpenseCategoryText();
		String expected = "Expense Category";
		Assert.assertEquals(actual, expected);
	}
	
	@Test (priority = 2)
	public void verifyToCreateNewExpense() {
		
		lp = new LoginPageClass(driver);
		hp = new HomePageClass(driver);
		mecp = new ManageExpenseCatogoryPageClass(driver);
		
		lp.login("admin", "admin");
		hp.clickOnManageExpense();
		hp.clickOnManageExpenseCatogory();
		mecp.clickOnNewCategory();
		
		mecp.typeElementOnTextBox("Dry-Fruits");
		mecp.clickOnSaveButton();
		
		String actual=mecp.getTextOfSuccessfullyMessage();
		String expected = "×\n"
				+ "Alert!\n"
				+ "Expense Category Created Successfully";
		Assert.assertEquals(actual, expected);
	}
	
	@Test (priority = 3)
	public void verifyToSearchCreatedExpense() {
		
		lp = new LoginPageClass(driver);
		hp = new HomePageClass(driver);
		mecp = new ManageExpenseCatogoryPageClass(driver);
		
		lp.login("admin", "admin");
		hp.clickOnManageExpense();
		hp.clickOnManageExpenseCatogory();
		mecp.clickOnSearchCategory();
		
		mecp.typeElementOnSearchTextBox("Dry-Fruits");
		mecp.clickOnSearchButton();
		
		String actual=mecp.getTextOfSearchElementOnTable();
		String expected = "Dry-Fruits";
		Assert.assertEquals(actual, expected);
	}
	
	@Test (priority = 4)
	public void verifyToDeleteCreatedExpense() {
		
		lp = new LoginPageClass(driver);
		hp = new HomePageClass(driver);
		mecp = new ManageExpenseCatogoryPageClass(driver);
		
		lp.login("admin", "admin");
		hp.clickOnManageExpense();
		hp.clickOnManageExpenseCatogory();
		mecp.clickOnSearchCategory();
		
		mecp.typeElementOnSearchTextBox("Dry-Fruits");
		mecp.clickOnSearchButton();
		
		mecp.clickOnDelete();
		
		String actual=mecp.getTextOfDeleteMessage();
		String expected = "×\n"
				+ "Alert!\n"
				+ "Expense Category Deleted Successfully";
		Assert.assertEquals(actual, expected);
	}

}
