package commonUtility;

import org.openqa.selenium.WebElement;

import baseClass.BaseClass;

public class UtilityClass extends BaseClass{

	public static int wait=10000;
	public static void EnterText(WebElement wb, String data)
	{
		wb.clear();
		wb.sendKeys(data);
	}
	public static void click(WebElement wb)
	{
		wb.click();
	}
	public static String getText(WebElement wb)
	{
		return wb.getText();
	}
}
