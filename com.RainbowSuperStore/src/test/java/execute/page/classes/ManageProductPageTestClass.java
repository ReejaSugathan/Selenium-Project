package execute.page.classes;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.classes.HomePageClass;
import page.classes.LoginPageClass;
import page.classes.ManageProductPageClass;
import retry.analyzer.RetryAnalyzer;

public class ManageProductPageTestClass extends BaseClass {
	
	LoginPageClass lp;
	HomePageClass hp;
	ManageProductPageClass mpp;

	@Test (retryAnalyzer = RetryAnalyzer.class, groups = {"search"})
	public void verifyToSearchCreatedExpense() {
		
		lp = new LoginPageClass(driver);
		hp = new HomePageClass(driver);
		mpp= new ManageProductPageClass(driver);
		
		lp.login("admin", "admin");
		hp.clickOnManageProduct();
		mpp.clickOnSearchCategory();
		
		mpp.typeProductCodeOnTextBox("1185");
		mpp.clickOnSearchButton();
		
		String actual=mpp.getTextOfSearchProduct();
		String expected = "P1185";
		Assert.assertEquals(actual, expected);
	}
}
