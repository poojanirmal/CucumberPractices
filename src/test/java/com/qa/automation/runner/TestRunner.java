package com.qa.automation.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(

            features="classpath:features",//to tell cucumber where is your feature file
            glue="com.qa.automation.stepdefs",//to tell cucumber where is your step def code
            tags="@ProdSearch",//to tell which tagged feature file to execute
            plugin = {"pretty",//to generate report
            		"html:target/html/htmlreport.html",
            		"json:target/json/file.json",
            		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
            		"timeline:test-output-thread/"
                     },
            monochrome=true,
            publish=true,
            dryRun=false)//to tell whether to test run(true) or actual run(false)
            


public class TestRunner {
	
	//class will be empty
	//nothing goes here
	//so do not get confused

	
}






















