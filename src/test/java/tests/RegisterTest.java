package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import pages.LoginPage;

public class RegisterTest {
	
	WebDriver driver = null;
	
	@BeforeTest
	public void setUpTest() {
		
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\varsh\\eclipse-workspace\\SopranoProject\\drivers\\FirefoxDriver\\geckodriver.exe");
		driver = new FirefoxDriver();
	}
	
	@Test
	public void registeration() {
		
		//Open URL home page
		driver.get("http://automationpractice.com/index.php");
		
		driver.manage().window().maximize();
		LoginPage.SignIn(driver);
		
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		LoginPage.CreateAcc(driver);
		
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		LoginPage.Register(driver);
}
	@AfterTest
	public void TearDownTest() {
		
		try {
	    	   driver.findElement(By.className("icon-list-ol"));
	    	   System.out.println("Test Passed!");
	    	}
	    catch (NoSuchElementException e) 
	    	{
	    		System.out.println("Test Failed!");
	    	}
		driver.close();
		driver.quit();
	}
}
