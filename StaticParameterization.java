package week6.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class StaticParameterization {

	public ChromeDriver driver;
	@Parameters({"url","username","password"})
		@BeforeMethod
		public void preConditions(String url,String username,String password)
		{
			ChromeOptions option=new ChromeOptions();
			option.addArguments("guest");
			driver = new ChromeDriver(option);
			driver.manage().window().maximize();
			driver.get(url);
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
				driver.findElement(By.id("username")).sendKeys(username);
				driver.findElement(By.id("password")).sendKeys(password);
				driver.findElement(By.id("Login")).click();
}
		
	    @AfterMethod
		public void postConditions() {
			driver.close();

	}

}
