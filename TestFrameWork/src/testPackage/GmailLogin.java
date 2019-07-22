package testPackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import testCore.TestCore;

public class GmailLogin extends TestCore{

	//System.setProperty("webdriver.gecko.driver", "D:\\Nitesh\\Selenium Software\\geckodriver-v0.21.0-win64\\geckodriver.exe");
		@Test(priority=0)
		public void Login() throws InterruptedException  
		{	
			driver.findElement(By.id(Object.getProperty("userid"))).clear();
		
			driver.findElement(By.id(Object.getProperty("userid"))).sendKeys("test@gmail.com");
		
			driver.findElement(By.xpath(Object.getProperty("NextBtn"))).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath(Object.getProperty("Password"))).clear();
			driver.findElement(By.xpath(Object.getProperty("Password"))).sendKeys(Object.getProperty("ttttt"));
		
			Thread.sleep(3000);
			driver.findElement(By.xpath(Object.getProperty("loginBtn"))).click();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
	}

