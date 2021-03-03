package pages;
import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class LoginPage {
	
	private static WebElement signIn = null;
	private static WebElement loginEmail = null;
	private static WebElement createAccBtn = null;
	
	//HomePage SignIn
	public static void SignIn(WebDriver driver) {
		
		signIn = driver.findElement(By.className("login"));
		signIn.click();
		
	}
	
	//Create Account by unique email
	public static void CreateAcc(WebDriver driver) {
		
		//generating unique emails
		String randnum = ""+(int)(Math.random()*Integer.SIZE);
		String email = "richard.sands"+randnum +"@yahoo.com";
		
		loginEmail = driver.findElement(By.id("email_create"));		    
		loginEmail.sendKeys(email);
		
		createAccBtn = driver.findElement(By.xpath("//*[@class='btn btn-default button button-medium exclusive']"));
		createAccBtn.click();
	}
	
	//Filling the form and registering
	public static void Register(WebDriver driver) {
		
		driver.findElement(By.id("id_gender2")).click();
	    
	    driver.findElement(By.id("customer_firstname")).sendKeys("Richard");
	    driver.findElement(By.id("customer_lastname")).sendKeys("Sands");
	    driver.findElement(By.id("passwd")).sendKeys("Richard1234");
	      
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollBy(0,700)");
	    
	    Select dropdownDay = new Select(driver.findElement(By.id("days")));
	    dropdownDay.selectByValue("5");
	    
	    Select dropdownMonth = new Select(driver.findElement(By.id("months")));
		dropdownMonth.selectByValue("5");
		
		Select dropdownYear = new Select(driver.findElement(By.id("years")));
		dropdownYear.selectByValue("1990");
		
	        
	    driver.findElement(By.id("company")).sendKeys("Soprano");
	    driver.findElement(By.id("address1")).sendKeys("Level 15, 132 Arthur St");
	    
	    driver.findElement(By.id("city")).sendKeys("New York");
	    
	    Select dropdownstate = new Select(driver.findElement(By.id("id_state")));
		dropdownstate.selectByVisibleText("New York");
	   
		driver.findElement(By.id("postcode")).sendKeys("10001");
	    driver.findElement(By.id("phone_mobile")).sendKeys("45789534");
	    
	    //Click Register
	    driver.findElement(By.id("submitAccount")).click();
	}
}
