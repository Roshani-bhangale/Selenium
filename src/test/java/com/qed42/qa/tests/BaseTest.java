package com.qed42.qa.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.qed42.qa.driver.DriverManager;

@Listeners(com.qed42.qa.utilities.TestListener.class)

public class BaseTest {
	
	protected WebDriver driver;

	@BeforeMethod
	public void setUp() {
        
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://tutorialsninja.com/demo/");
	}
	
	/**
	 * quit() method is called after every test. It closes the browser
	 * 
	 */
	@AfterMethod
	public void quit() {
		DriverManager.quit();
	
	}
	
	/**
	 * terminate() method is called after every class. It removes the ThreadLocal driver.
	 */
	@AfterClass
	public void tearDown() {
		DriverManager.terminate();
	}
}
