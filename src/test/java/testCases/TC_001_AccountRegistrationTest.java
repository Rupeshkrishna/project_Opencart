package testCases;



import org.openqa.selenium.By;

import org.testng.annotations.Test;

import testBase.BaseClass;

public class TC_001_AccountRegistrationTest  extends BaseClass{

	@Test(groups = {"Regression","Master"})
public	void test_account_registration() throws InterruptedException {
     
	
		logger.info("******** Starting the Registration process ***************");
			driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
			driver.findElement(By.xpath("//a[normalize-space()='Register']")).click();
			
			driver.findElement(By.name("firstname")).sendKeys("abc");
			driver.findElement(By.name("lastname")).sendKeys("xyz");
			driver.findElement(By.name("email")).sendKeys("abcxyzz@gmail.com");
			driver.findElement(By.name("password")).sendKeys("test@1234");
			
			logger.info("Click action on the agree check box");
			
			driver.findElement(By.xpath("//input[@name='agree']")).click();
	
				 logger.info("Click action on the agree continue box");
				 
				 driver.findElement(By.xpath("//button[normalize-space()='Continue']")).click();
			
			Thread.sleep(3000);
		driver.close();
	}
}
		

			
			
	
		
//		logger.info("Providing the Customer Data");
//		regpage.setFirstName(randomeString().toUpperCase());
//		
//		regpage.setLastName(randomeString().toUpperCase());
//		
//		regpage.setEmail(randomeString()+"@gmail.com");// randomly generated the email
//		
//		//regpage.setTelephone(randomNumber());
//		
//		String password=randomAlphaNumeric();
//		regpage.setPassword(password);
//	   //regpage.setConfirmPassword(password);
//		
//		regpage.setPrivacyPolicy();
//		
//		regpage.clickContinue();
//		logger.info("Clicked on continue");
//		}
//	}
//

		
//		String confmsg=regpage.getConfirmationMsg();
//		
//		            int actualValue = Continue();           // ... get the actual value
//				    int expectedValue = // ... the value you expect
//				    Assert.assertEquals(actualValue, expectedValue, "Value does not match");
//				}
//		catch(Exception e)
//		{
//		
//			Assert.fail();
//		}
      //	logger.info("******* Finished the TC_001_AccountRegistrationTest *********** ");
//	}
//}
	

