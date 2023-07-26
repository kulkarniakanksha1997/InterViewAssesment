package testclass;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.*;

import baseClass.BaseClass;
import commonUtility.XLFFile;
import pageClass.PageClass;
import pageClass.Products;

public class TestClass extends BaseClass {
	
	 PageClass page;
	 Products prod;
	@BeforeClass
	public void setup1()
	{
		setup();
		page=new PageClass();
		prod=new Products();
		
	}
	@Test(dataProvider ="newdata")
	public void Login(String user, String password) throws InterruptedException
	{
		System.out.println("UserName : "+user);
		page.Enteremail(user);
		System.out.println("Password : "+password);
		page.EnterPassword(password);
		page.LoginClick();
		try{
		Assert.assertEquals(prod.TextProduct(), "Products");
		prod.Logout();
		}
		catch(Exception e)
		{
			System.out.println("warning");
			
			driver.navigate().refresh();
			
		}
	}
	
	
	 @DataProvider(name="newdata")
		public String[][] getData() throws IOException
		 {
			 String path=System.getProperty("user.dir")+"/TestData/testData.xlsx";
			 System.out.println(path);
			 String sheetName="Sheet1";
			 System.out.println(sheetName);
			 int rownum=XLFFile.getRow(path, sheetName);
			 int colcount=XLFFile.getCellCount(path, sheetName, 1);
			 
			 String logindata[][]=new String[rownum][colcount];
			 for(int i=1;i<=rownum; i++)
			 {
				// System.out.println("hello");
				 for(int j=0; j<colcount; j++)
				 {
					 
					 logindata[i-1][j]=XLFFile.getCellData(path, sheetName, i, j);
						
				 }
			 }
			 return logindata;
			 
		 }

	@AfterClass
	public void teardown()
	{
		driver.quit();
	}
}
