package execute.page.classes;
import org.testng.annotations.DataProvider;

public class DataProviderLogin {
	 
	  @DataProvider(name = "UnsuccessfulLoginDp")
	  public Object[][] dp1() {
	    return new Object[][] {
	      new Object[] { "admin", "1234" },
	      new Object[] { "welcome", "admin" },
	      new Object[] { "amin", "123" },
	    };
	  }
	  
	  @DataProvider(name = "SuccessfulLoginDp")
	  public Object[][] dp2() {
	    return new Object[][] {
	      new Object[] { "admin", "admin" },
	      
	    };
	  }

	}