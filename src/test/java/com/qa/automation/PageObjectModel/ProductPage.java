package com.qa.automation.PageObjectModel;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.automation.Core.JavaScriptUtil;

import io.cucumber.java.Scenario;

public class ProductPage {
	
	private static final Logger logger = LogManager.getLogger(ProductPage.class);
	
	 private WebDriver driver;
	 Scenario scn;
	 JavaScriptUtil javaScriptUtil = new JavaScriptUtil(driver);
	
	 //Parameterized the constructor
		public ProductPage(WebDriver driver)
		{
			this.driver = driver;
			
		}
	
	//WebElements
	private By nextPageText = By.xpath("//span[text()='Mobile']");
	private By discountRange = By.xpath("//span[text()='Discount Range']");
	
	//Method Related StepDefs
	public void validateProdPage()
	{
		 WebElement nextPageTextEle =  driver.findElement(nextPageText);
		 
		  String expectedText = "Mobile";
		  String actualText = nextPageTextEle.getText();
		  
		  Assert.assertEquals(expectedText, actualText);
		  
		  //for scroll down we need to used this to line here but before the particular Web Element
//		  JavascriptExecutor js = ((JavascriptExecutor)driver);
//			 js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		  
		  WebElement discountRangeEle =  driver.findElement(discountRange);
		  String actualedText = "DISCOUNT RANGE";
			 Assert.assertEquals( actualedText, discountRangeEle.getText());
			 
			 //for scrolling upto particular Web Element
//			 JavascriptExecutor js = ((JavascriptExecutor)driver);
//			 js.executeScript("arguments[0].scrollIntoView(true);",discountRangeEle);
			 
			 javaScriptUtil.scrollIntoView(discountRangeEle, driver);
			 
		  
		  logger.info("validate the next page");
	}
	
	
	

}
