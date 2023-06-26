package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
public class GeneralUtilities {

	public void clickElement(WebElement element)
		{
		element.click();
		}

	public void clearElement(WebElement element)
		{
		element.clear();
		}

	public void typeElement(WebElement element, String text)
		{
		element.sendKeys(text);
		}

	public String getTextofElement(WebElement element)
		{
		return element.getText();
		}

	public String getCurrenturl(WebDriver driver)
		{
		return driver.getCurrentUrl();
		}

	public boolean isDisplayedMethod(WebElement element)
		{
		return element.isDisplayed();
		}
	public boolean isSelectedMethod(WebElement element)
		{
		return element.isSelected();
		}

	public void clickElementJS(WebElement element, WebDriver driver)
		{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
		}

	public void scrollToAnElement(WebElement element, WebDriver driver)
		{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
		}

	public void selectByIndex(WebElement element, int index)
		{
		Select sel = new Select(element);
		sel.selectByIndex(index);
		}

	public void selectByVisibleText(WebElement element, String value)
		{
		Select select = new Select(element);
		select.selectByValue(value);
		}

	public void addThreadSleep() throws InterruptedException
		{
		Thread.sleep(2000);
		}

	public void alertAccept(WebDriver driver)
		{
		driver.switchTo().alert().accept();
		}
	public String alertGetText(WebDriver driver)
		{
		return driver.switchTo().alert().getText();
		}


}
