package com.qa.automation.Core;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverFactory {
	
	private static final Logger logger = LogManager.getLogger(WebDriverFactory.class);
	
	private static WebDriver driver = null;
	 static WebDriverWait wait;
	
	
	
	public static WebDriver setUpBrowser(String browser) //return type should be WebDriver so that this (String browser) connect to WebDriver driver;
	{
		
		switch(browser.toLowerCase()) 
		{
		case"chrome":
	
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\LENOVO\\eclipse-workspace\\Selenium\\chromedriver.exe");
			ChromeOptions opt = new ChromeOptions();
			opt.setBinary("C:\\Users\\LENOVO\\eclipse-workspace\\chrome-win64\\chrome-win64\\chrome.exe");
			driver = new ChromeDriver(opt);
		    break;
		case"firefox":
		
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		    break;
		case"opera":
		
			WebDriverManager.operadriver().setup();
			driver = new OperaDriver();
		    break;
		case"edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
			
		default:
			logger.fatal("No such browser is implemented.Browser name sent: " + browser);
			break;
		
		}
		
		driver.manage().window().maximize();
		logger.info("Browser get maximized");
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 wait =  new WebDriverWait(driver,15);
		 return driver;  //this statement very important this make the connection between browser and driver.
	} 
	       
	 public static String getBrowserName(){ //this method is only used when we invoked the browser through command line
	        String browserDefault = "chrome"; //Set by default
	        String browserSentFromCmd = System.getProperty("browser");//this System.getProperty() method support through dependency for this we have to create plug in which already save in pom.xml

	        if (browserSentFromCmd==null)
	        {
	            return browserDefault;
	        }
	        else
	        {
	            return browserSentFromCmd;
	        }
	    }
	
	public  static void quitDriver()
	{
		driver.quit();
		logger.info("Browser got closed");
	}
	
	public  static void setURL(String url)
	{
		driver.get(url);
		logger.info("navigate to the url");
	}
	
	

	
}
