package utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class FileUploadRobotClass {

	public void FileUpload() throws AWTException
	{
		// creating object of Robot class
		Robot rb = new Robot();
		
		// Store the File path to the StringSelection class
		StringSelection filePath = new StringSelection(System.getProperty("user.dir")+"\\src\\test\\resources\\project.png");
         //System.getProperty("user-dir")+"\src\test\resources\ARYN-LOV.jpg"
		// Copy above path to clipboard
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filePath, null);

		// press Contol+V for pasting
		rb.keyPress(KeyEvent.VK_CONTROL);
		//Thread.sleep(4000);
		rb.delay(250);
		rb.keyPress(KeyEvent.VK_V);
		// release Contol+V for pasting
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.delay(250);
		rb.keyRelease(KeyEvent.VK_V);

		// for pressing and releasing Enter
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.delay(250);
		rb.keyRelease(KeyEvent.VK_ENTER);

		System.out.println("file uploaded..");
		
		
	}

}
