package execute.page.classes;

import org.testng.Assert;
import org.testng.annotations.Test;

import page.classes.HomePageClass;
import page.classes.LoginPageClass;

public class HomePageTestClass extends BaseClass {
	
	LoginPageClass lp;
	HomePageClass hp;

	@Test

	public void verifyAllTilesAreDisplyedOrNotInHomePage() {
		
		lp = new LoginPageClass(driver);
		hp = new HomePageClass(driver);
		
		lp.login("admin", "admin");
		
		boolean actual=hp.isAllTilesDisplayed();
		Assert.assertTrue(actual);
	}

}
