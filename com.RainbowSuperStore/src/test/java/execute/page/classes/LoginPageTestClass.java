package execute.page.classes;

import org.testng.Assert;
import org.testng.annotations.Test;

import page.classes.LoginPageClass;
import retry.analyzer.RetryAnalyzer;

public class LoginPageTestClass extends BaseClass {

	LoginPageClass lp;

	@Test(priority = 1, dataProviderClass = DataProviderLogin.class, dataProvider = "SuccessfulLoginDp", retryAnalyzer = RetryAnalyzer.class)
	public void verifySuccessfulLogin(String username, String pswd) {
		lp = new LoginPageClass(driver);
		lp.login(username, pswd);
		String actual = lp.getTextOfAdminText();
		String expected = "Admin";
		Assert.assertEquals(actual, expected);
	}

	@Test(priority = 2, dataProviderClass = DataProviderLogin.class, dataProvider = "UnsuccessfulLoginDp", retryAnalyzer = RetryAnalyzer.class)
	public void verifyUnSuccessfulLogin(String username, String pswd) {
		lp = new LoginPageClass(driver);
		lp.login(username, pswd);
		String actual = lp.getTextOfAlert();
		String expected = "×\n" + "Alert!\n" + "Invalid Username/Password";
		Assert.assertEquals(actual, expected);
	}

	@Test(priority = 3, retryAnalyzer = RetryAnalyzer.class)
	public void verifyRemenberMeCheckboxIsSelectedOrNotByDefault() {
		lp = new LoginPageClass(driver);
		boolean actual = lp.rememberCheckBoxIsSelected();
		Assert.assertFalse(actual);
	}
}
