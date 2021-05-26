package seleniumproj;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {

	WebDriver driver = new FirefoxDriver();
	
	@BeforeMethod
	public void startChromeDriver() {
		String url = "https://www.comm100.com";
		System.setProperty("webdriver.chrome.driver", "D:\\selenium\\chromedriver.exe");
		driver.manage().window().maximize();
		driver.get(url);
	}

	@Test  
	public void LoginSuccessTestCase() throws InterruptedException {

		WebElement p = driver.findElement(By.partialLinkText("Sign In"));
		p.click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.findElement(By.id("txtEmail")).sendKeys("sumantab4u2@gmail.com");
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.findElement(By.id("txtPassword")).sendKeys("Abcd@123");
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.findElement(By.id("lblLogin")).click();
		Thread.sleep(1000);
		String actualUrl = "successURL";
		String expectedUrl = driver.getCurrentUrl();
		Assert.assertEquals(expectedUrl, actualUrl);
	}

	@Test  
	public void LoginfailureTestCase() throws InterruptedException {

		WebElement p = driver.findElement(By.partialLinkText("Sign In"));
		p.click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.findElement(By.id("txtEmail")).sendKeys("sumantab4u2@gmail.com");
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.findElement(By.id("txtPassword")).sendKeys("Abcd@123");
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.findElement(By.id("lblLogin")).click();
		Thread.sleep(1000);
		String actualUrl = "successURL";
		String expectedUrl = driver.getCurrentUrl();
		Assert.assertEquals(expectedUrl, actualUrl);
		Assert.fail("Login Failure");
	}

	@AfterMethod
	public void cleaupBrowser() {
		System.out.print("\nBrowser close");
		driver.close();
	}

}