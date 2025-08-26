package week6.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class BasicParametrization extends StaticParameterization
{
	@Test
	public void Annotation()throws InterruptedException {
	driver.findElement(By.xpath("//button[@class='slds-button slds-context-bar__button slds-icon-waffle_container slds-show']")).click();
	Thread.sleep(5000);
	driver.findElement(By.xpath("(//button[@class='slds-button'])[2]")).click();
	Thread.sleep(5000);
	driver.findElement(By.xpath("//lightning-input[@class='searchBar slds-form-element']"))
	.sendKeys("Legal Entities", Keys.ENTER);
	Thread.sleep(5000);
	driver.findElement(By.xpath("//mark[text()='Legal Entities']")).click();
	Thread.sleep(5000);
	driver.findElement(By.xpath("//li[@class='slds-button slds-button--neutral slds-button_neutral']")).click();
	Thread.sleep(5000);
	driver.findElement(By.xpath("(//input[@class='slds-input'])[3]")).sendKeys("TestLeaf");
	Thread.sleep(3000);
	driver.findElement(By.xpath("(//textarea[@class='slds-textarea'])[2]")).sendKeys("Salesforces");
	Thread.sleep(5000);
	// Now select the 'Active' option
	WebElement statusDropdown = driver.findElement(By.xpath("//button[@aria-label='Status']"));
	((JavascriptExecutor) driver).executeScript("arguments[0].click();", statusDropdown);

	// Click the "Active" option
	WebElement activeOption = driver.findElement(By.xpath("//span[text()='Active']"));
	((JavascriptExecutor) driver).executeScript("arguments[0].click();", activeOption);

	//System.out.println("✅ 'Active' selected successfully");
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	WebElement saveBtn = driver.findElement(By.xpath("//button[@name='SaveEdit']"));
	((JavascriptExecutor) driver).executeScript("arguments[0].click();", saveBtn);

	// Verify alert message for Name field
	WebElement alertMsg = driver.findElement(
	    By.xpath("//div[@class='slds-form-element__help' and text()='Complete this field.']"));

	if (alertMsg.isDisplayed()) {
	    System.out.println("✅ Verified: Alert message 'Complete this field.' is displayed for Name");
	} else {
	    System.out.println("❌ Alert message not displayed for Name");
	}
	}
}
	


