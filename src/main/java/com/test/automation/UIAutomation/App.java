package com.test.automation.UIAutomation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        System.setProperty("webdriver.gecko.driver", "C:/Users/sshaikh/Desktop/Personal-Data/Selenium-lib/geckodriver.exe");
        WebDriver dirver=new FirefoxDriver();
        
    }
}
