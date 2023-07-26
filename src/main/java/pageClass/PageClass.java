package pageClass;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import commonUtility.UtilityClass;
import commonUtility.XLFFile;

public class PageClass extends BaseClass {
	 
	@FindBy(id="user-name") WebElement email;
	@FindBy(id="password") WebElement password;
	@FindBy(id="login-button")WebElement login;
	@FindBy(xpath="//h3[@data-test='error']") WebElement warning;
	public static String logoText;
	public PageClass()

	{
		super();
		PageFactory.initElements(driver, this);
		
	}
	
	public void Enteremail(String User)
	{
		UtilityClass.EnterText(email, User);
		
	}
	public void EnterPassword( String Password)
	{
		UtilityClass.EnterText(password, Password);
		
	}
	public void LoginClick()
	{
		UtilityClass.click(login);
	}
	public String getWarning()
	{
		return UtilityClass.getText(warning);
		
	}
		
}
