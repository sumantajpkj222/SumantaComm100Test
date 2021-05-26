package seleniumproj;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
public class TestNG {
	@Test(invocationCount = 100)
	public  void test() {
		System.setProperty("webdriver.chrome.driver", "D:\\selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://www.google.com");
		driver.manage().window().maximize();
		WebElement element = driver.findElement(By.name("q"));
		element.sendKeys("Shoes");
		element.submit();
		System.out.println("Page Title is " + driver.getTitle());
        Assert.assertEquals("Google", driver.getTitle());
		driver.close();
	}
}
