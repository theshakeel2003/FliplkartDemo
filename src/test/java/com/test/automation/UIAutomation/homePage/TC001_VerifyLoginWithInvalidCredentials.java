package com.test.automation.UIAutomation.homePage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC001_VerifyLoginWithInvalidCredentials {
	WebDriver driver;
	
	@BeforeTest
	public void setUp() {
	    
		System.setProperty("webdriver.chrome.driver", "C:/Users/sshaikh/Desktop/Personal-Data/Selenium-lib/chromedriver.exe");
        driver=new ChromeDriver();
		
		
	}
	@Test
	public void VerifyLoginWithInvalidCredentials() {
		
		driver.get("https://www.flipkart.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//button[starts-with(@class, '_2AkmmA')][text()='✕']")).click();
        driver.findElement(By.name("q")).click();
        driver.findElement(By.name("q")).clear();
        driver.findElement(By.xpath("//input[@name='q']")).sendKeys("iphone 6 in mobile");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        new Select(driver.findElement(By.xpath("//div[@id='container']/div/div/div/div[2]/div/div/div/div/div/section[2]/div[4]/div/select"))).selectByVisibleText("₹30000");
     	        
        WebElement assured = driver.findElement(By.xpath("//*[@id='container']/div/div[1]/div/div[2]/div[1]/div[1]/div/div[1]/div/section[3]/div[1]/label/div[2]/div/img"));
        Actions action = new Actions(driver);
        action.moveToElement(assured).build().perform();
        assured.click();
        
       JavascriptExecutor js = (JavascriptExecutor) driver;
       js.executeScript("window.scrollBy(0,500)");
       driver.findElement(By.xpath("//*[@id='container']/div/div[1]/div/div[2]/div[1]/div[1]/div/div[1]/div/section[5]/div[2]/div[1]/div[2]/div/div/label/div[2]")).click();
	   
       String product_before_xpath="//*[@id='container']/div/div[1]/div/div[2]/div/div[2]/div[";
       String product_after_xpath="]/div/div/div/a/div[2]/div[1]/div[1]";
       
       String price_before_xapth="//*[@id='container']/div/div[1]/div/div[2]/div/div[2]/div[";
       String price_after_xpath="]/div/div/div/a/div[2]/div[2]/div[1]/div/div";
      	 
       String before_link_url_xpath="//*[@id='container']/div/div[1]/div/div[2]/div/div[2]/div[";
    	String after_link_url_xpath="]/div/div/div/a";
       
       for(int i=2;i<=25;i++)
       	       {
    	   
    	   			String product_descr=driver.findElement(By.xpath(product_before_xpath+i+product_after_xpath)).getText();
    	   			System.out.println("Product-Description :"+product_descr);
    	   			String product_link=driver.findElement(By.xpath(before_link_url_xpath+i+after_link_url_xpath)).getAttribute("href");
    	   			System.out.println("Product-Link :"+product_link);
    	      
    	//       String product_price=driver.findElement(By.xpath(price_before_xapth+i+price_after_xpath)).getText();
    	    
    	//         System.out.println("Product-Description and Price :"+product_descr +" "+product_price);
       	    	   
       	  
       	  	   
       	   	 }
		
	}
	
	@AfterClass
	public void endTest() {
		
		driver.quit();
	}

}
