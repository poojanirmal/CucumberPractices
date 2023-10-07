package com.qa.automation.PageObjectModel;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import io.cucumber.java.Scenario;



public class LandingPage {
	
	private static final Logger logger = LogManager.getLogger(LandingPage.class);
	
	 private WebDriver driver;
	Scenario scn;
	
	 //Parameterized the constructor
	public LandingPage(WebDriver driver,Scenario scn)
	{
		this.driver = driver;
		this.scn = scn;
		
	}
	
	//WebElement
	private By searchBox = By.xpath("//input[@placeholder='Search for products, brands and more']");
	private By actualDeskTopBar = By.xpath("//div[@class='desktop-navLinks']//a[@data-type='navElements']");
	
	
	//Methods Related StepDefs
	
	public void prodSearch(String productSearch)
	{
		WebElement searchBoxEle = driver.findElement(searchBox);
		  searchBoxEle.sendKeys(productSearch + Keys.ENTER);
		  scn.log("search for the mobile");
		  logger.info("search the product");
	}

	public void desktopBarList(List<String> desktopBar)
	{
        List<String> expectedDeskTopBar = desktopBar;
		
		List<WebElement> actualDeskTopBarEle = driver.findElements(actualDeskTopBar);
		
		for(int i = 0; i<expectedDeskTopBar.size(); i++)
		{
			System.out.println(expectedDeskTopBar.get(i));
		}
		 scn.log("list of header section on desktop bar");
		logger.info("mouse over the header section");
	}
}
