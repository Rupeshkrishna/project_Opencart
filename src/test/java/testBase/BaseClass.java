package testBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseClass {

	/* Static- Reason i have used static we have two driver variables 1 in testBAse other in ExtentReptmngr
	to avoid it i made it into static */

	public static WebDriver driver;
	
	public Logger logger; // for logging
	
	public ResourceBundle rb;
	
	
	@BeforeClass(groups = {"Regression","Snaity","Master"})
	@Parameters("browser")
	public void setup(@Optional("defaultBrowser")String browser)
	{
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
		driver.get("https://demo.opencart.com/index.php");
		driver.get("https://demo.opencart.com/index.php?route=account/login&language=en-gb");
		driver.manage().window().maximize();
		
		rb=ResourceBundle.getBundle("config"); // Load config.properties file
		
		logger=LogManager.getLogger(this.getClass());  //logging
			
		
		
//		//ChromeOptions options=new ChromeOptions();
//		//options.setExperimentalOption("excludeSwitches",new String[] {"enable-automation"});
//		
//		if(browser.equals("chrome"))
//		{
//		driver=new ChromeDriver();
//		}
//		else if(browser.equals("edge"))
//		{
//			driver=new EdgeDriver();
//		}
//		else
//		{
//			driver=new FirefoxDriver();
//		}
//		
	}
	
	@AfterClass(groups = {"Regression","Snaity","Master"})
	public void tearDown()
	{
		driver.quit();
		//Assert.assertEquals(driver, true);
	}
	

	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";

		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (Exception e) {
			e.getMessage();
		}
		return destination;

	}
	
}
