package execute.page.classes;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import page.classes.HomePageClass;
import page.classes.LoginPageClass;
import retry.analyzer.RetryAnalyzer;
import page.classes.ExpenseCatogoryPageClass;

public class ExpenseCatogoryPageTestClass extends BaseClass {

	LoginPageClass lp;
	HomePageClass hp;
	ExpenseCatogoryPageClass mecp;
	
	@Test (priority = 1,retryAnalyzer = RetryAnalyzer.class, groups = {"group1"})
	public void verifyManageExpenceCatogoryPageIsDisplayedOrNot() {
		
		lp = new LoginPageClass(driver);
		hp = new HomePageClass(driver);
		mecp = new ExpenseCatogoryPageClass(driver);
		
		lp.login("admin", "admin");
		hp.clickOnManageExpense();
		hp.clickOnManageExpenseCatogory();
		
		String actual=mecp.getTextOfExpenseCategoryText();
		String expected = "Expense Category";
		Assert.assertEquals(actual, expected);
	}
	
	@Test (priority = 2,retryAnalyzer = RetryAnalyzer.class, groups = {"create"})
	public void verifyToCreateNewExpense() throws IOException {
		
		lp = new LoginPageClass(driver);
		hp = new HomePageClass(driver);
		mecp = new ExpenseCatogoryPageClass(driver);
		
		lp.login("admin", "admin");
		hp.clickOnManageExpense();
		hp.clickOnManageExpenseCatogory();
		mecp.clickOnNewCategory();
		
		//mecp.typeElementOnTextBox("Dry-Fruits");
		mecp.typeElementOnTextBox(mecp.readExpence(7, 1));
		mecp.clickOnSaveButton();
		
		String actual=mecp.getTextOfSuccessfullyMessage();
		String expected = "×\n"
				+ "Alert!\n"
				+ "Expense Category Created Successfully";
		Assert.assertEquals(actual, expected);
	}
	
	@Test (priority = 3,retryAnalyzer = RetryAnalyzer.class, groups = {"search"})
	public void verifyToSearchCreatedExpense() throws IOException {
		
		lp = new LoginPageClass(driver);
		hp = new HomePageClass(driver);
		mecp = new ExpenseCatogoryPageClass(driver);
		
		lp.login("admin", "admin");
		hp.clickOnManageExpense();
		hp.clickOnManageExpenseCatogory();
		mecp.clickOnSearchCategory();
		
		//mecp.typeElementOnSearchTextBox("Dry-Fruits");
		mecp.typeElementOnSearchTextBox(mecp.readExpence(7, 1));
		mecp.clickOnSearchButton();
		
		String actual=mecp.getTextOfSearchElementOnTable();
		String expected = "Dry-Fruits-Apple";
		Assert.assertEquals(actual, expected);
	}
	
	@Test (priority = 4,retryAnalyzer = RetryAnalyzer.class,groups = {"delete"})
	public void verifyToDeleteCreatedExpense() throws IOException {
		
		lp = new LoginPageClass(driver);
		hp = new HomePageClass(driver);
		mecp = new ExpenseCatogoryPageClass(driver);
		
		lp.login("admin", "admin");
		hp.clickOnManageExpense();
		hp.clickOnManageExpenseCatogory();
		mecp.clickOnSearchCategory();
		
		//mecp.typeElementOnSearchTextBox("Dry-Fruits");
		mecp.typeElementOnSearchTextBox(mecp.readExpence(7, 1));
		mecp.clickOnSearchButton();
		
		mecp.clickOnDelete();
		
		String actual=mecp.getTextOfDeleteMessage();
		String expected = "×\n"
				+ "Alert!\n"
				+ "Expense Category Deleted Successfully";
		Assert.assertEquals(actual, expected);
	}

}
