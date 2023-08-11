package testCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import testBase.BaseClass;


public class TC_002_LoginChecking  extends BaseClass {

	@Test(groups = {"Sanity","Master"})
	public	void test_account_registration() throws InterruptedException { 
	
			
	driver.get("https://demo.opencart.com/index.php?route=account/login&language=en-gb");
	driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
	driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("abcxyzz@gmail.com");
	driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("test@1234");
	driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
	
	Thread.sleep(3000);
	
	driver.findElement(By.xpath("//a[@class='list-group-item'][normalize-space()='Logout']"));
	
	boolean heading = driver.findElement(By.linkText("My Account")).isDisplayed();

//	Assert.assertEquals(heading, true);
//	Thread.sleep(3000);
	driver.close();
		
		}
	}


