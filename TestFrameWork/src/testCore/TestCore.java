package testCore;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeSuite;

import testUtilities.ScreenShot;
import testUtilities.Xls_Reader;

public class TestCore {

	public static Properties Object = new Properties();
	public static Properties Config = new Properties();
	public static Xls_Reader Excel = null;
	public static ScreenShot ss = null;
	public static WebDriver driver;
	
	@BeforeSuite
	public void Init() throws IOException
	{
		FileInputStream LoadFile=new FileInputStream("C:\\Users\\Deepak\\eclipse-workspace\\TestFrameWork\\src\\testProperties\\Config.properties");
		Config.load(LoadFile);
		FileInputStream ObjectLoad=new FileInputStream("C:\\Users\\Deepak\\eclipse-workspace\\TestFrameWork\\src\\testProperties\\Object.properties");
		Object.load(ObjectLoad);
		if(Config.getProperty("browser").equals("CH"))
		{
			System.setProperty("webdriver.chrome.driver","D:\\Nitesh\\Selenium Software\\chromedriver\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		
		if(Config.getProperty("browser").equals("IE"))
		{
			System.setProperty("webdriver.ie.driver","D:\\Nitesh\\Selenium Software\\IEDriverServer.exe");
			driver=new InternetExplorerDriver();
		}
		
		if(Config.getProperty("browser").equals("FF"))
		{
			System.setProperty("webdriver.gecko.driver", "D:\\Nitesh\\Selenium Software\\geckodriver-v0.21.0-win64\\geckodriver.exe");
			driver= new FirefoxDriver();
		}
		driver.get(Config.getProperty("url"));
		driver.manage().window().maximize();
	}
}
