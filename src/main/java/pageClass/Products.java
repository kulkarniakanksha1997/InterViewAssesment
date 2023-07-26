package pageClass;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseClass.BaseClass;
import commonUtility.UtilityClass;

public class Products extends BaseClass {
	@FindBy (xpath="//span[@class='title']") WebElement product;
	@FindBy(id="react-burger-menu-btn") WebElement menu;
	@FindBy(id="logout_sidebar_link") WebElement logout;
	
	public Products()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String TextProduct()
	{
		return UtilityClass.getText(product);
	}
	public void Logout()
	{
		UtilityClass.click(menu);
		UtilityClass.click(logout);
		
	}
}
