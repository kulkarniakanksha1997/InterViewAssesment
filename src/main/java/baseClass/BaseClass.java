package baseClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.hc.core5.util.Timeout;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import commonUtility.UtilityClass;

public class BaseClass {
	
	public static WebDriver driver;
	public static Properties prop;
	public BaseClass(){
		
		try {
			prop=new Properties();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		File file;
		file = new File(System.getProperty("user.dir")+"//configuration//config.properties");
		
			try {
				FileInputStream fis=new FileInputStream(file);
				try {
					prop.load(fis);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
		
	
	public static void setup()
	{
		String browsername=prop.getProperty("browser");
		if(browsername.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
			System.out.println("correct");
			
		}
		else
		{
			System.out.println("error");
		}
		driver.get(prop.getProperty("url"));
		driver.manage().deleteAllCookies();
		
		driver.manage().window().maximize();	
		driver.manage().timeouts().implicitlyWait(UtilityClass.wait, TimeUnit.SECONDS);
		
	}

}
