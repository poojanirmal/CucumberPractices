package com.qa.automation.stepdefs;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.automation.Core.WebDriverFactory;
import com.qa.automation.PageObjectModel.LandingPage;
import com.qa.automation.PageObjectModel.ProductPage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class stepdef {
	
	//private static final Logger logger = LogManager.getLogger(stepdef.class);
	
	WebDriver driver;
	Scenario scn;
	LandingPage landingPage;
	ProductPage productPage;
	
	
	
	@Before
	public void setUp(Scenario scn) 
	{
		this.scn = scn;
		//driver = WebDriverFactory.setUpBrowser("chrome"); this line perfectly fine but just because of hard code ("chrome") we have to used another.by using this line we invoke another browser 
		String browserName = WebDriverFactory.getBrowserName();//this method set the default browser as chrome.
		driver = WebDriverFactory.setUpBrowser(browserName);//this method make the connection between chrome browser and webdriver driver.(by using this line we can not invoke another browser)
		scn.log("Browser got opened");
		landingPage = new LandingPage(driver,scn);
		productPage = new ProductPage(driver);
    }

	@After(order=1)
	public void cleanUp()
	{
		WebDriverFactory.quitDriver(); 
	   scn.log("Browser got closed");
	   
	}
	
	@After(order=2) //this will execute first,higher the order execute the first.
	public void takeScreenshot(Scenario scn)
	{
		if(scn.isFailed())
		{
			TakesScreenshot scrnshot = (TakesScreenshot)driver;
			byte[] data = scrnshot.getScreenshotAs(OutputType.BYTES);
			scn.attach(data, "image/png", "Failed step name: " + scn.getName());
		}
		else
		{
			scn.log("Test case is passed,no screenshot captured");
		}
	}
	
	
	@Given("User navigate to the home page by using url {string}")
	public void user_navigate_to_the_home_page_by_using_url(String url) 
	{
	    WebDriverFactory.setURL(url);
	    scn.log("navigate to the url ->" + url);
	    
	}
	
	@When("USer search for the {string}")
	public void u_ser_search_for_the(String productSearch) 
	{
		landingPage.prodSearch(productSearch);
	  
	}
	
	@Then("User validate the next page")
	public void user_validate_the_next_page() 
	{
	   productPage.validateProdPage();
	  
	  
	}

	@When("User mouse over the desktop_bar")
	public void user_mouse_over_the_desktop_bar(List<String> desktopBar) {
	
		landingPage.desktopBarList(desktopBar);
	}


}
