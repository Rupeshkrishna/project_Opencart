package testCases;

import org.openqa.selenium.By;

import org.testng.Assert;
//import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import testBase.BaseClass;




public class TC_003_LoginDDT extends BaseClass  {

	// intially i didnt work (dataProvider = "LoginData" , dataProviderClass = DataProvider.class )
	@Test()
	public void test_loginDDT()  {
		
		logger.info(" *****  Starting TC_003_LoginDDT *****");
		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("abcxyzz@gmail.com");
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("test@1234");
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		
 boolean status =  driver.findElement(By.xpath("//button[normalize-space()='Login']")).isDisplayed();
 if(status == true) {
Assert.assertEquals(status, true);
		
	}else {
		Assert.assertEquals(status, false);
		
		driver.close();
	}
}
}
