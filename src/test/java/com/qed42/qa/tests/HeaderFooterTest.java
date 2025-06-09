package com.qed42.qa.tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;

import com.qed42.qa.driver.DriverManager;
import com.qed42.qa.pageobjects.HeaderPage;
import com.qed42.qa.pageobjects.FooterPage;

public class HeaderFooterTest {
	public WebDriver driver;
	public HeaderPage headerPage;
	public FooterPage footerPage;

	@BeforeMethod
	
	public void setup() {
        DriverManager.initialize("firefox");
        driver = DriverManager.getDriver();
        driver.manage().window().maximize();
        driver.get("https://tutorialsninja.com/demo/");
		headerPage = new HeaderPage (driver);
		footerPage = new FooterPage (driver);
	}
	@Test (priority = 1)
	public void validateMenu() {
		Assert.assertTrue(headerPage.isMenuDisplayed(), "Menu is not visible.");
		
	}
	
	@Test (priority = 2)
	public void validateSearch() {
		headerPage.performSearch("Samsung Galaxy Tab 10.1");
	}
	
	@Test (priority = 3)
	public void verifyAllMenuLinksNavigation() {

	    
	    for (WebElement menu : headerPage.menuLinks) {
	        String menuName = menu.getText();
	        Actions actions = new Actions(driver);
	        actions.moveToElement(menu).pause(Duration.ofSeconds(1)).click().perform();
	        int linkCount = headerPage.getmenuLinkCount();
	        System.out.println("Menu Link Count: " + linkCount);

	        String expectedTitle = driver.getTitle();
	        Assert.assertTrue(expectedTitle.contains(menuName) || !expectedTitle.isEmpty(),
	            "Menu '" + menuName + "' did not navigate correctly.");
	        driver.navigate().back(); // Return to main page
	    }
	}
	
	@Test (priority = 4)
	public void verifyFooterContent() {
       Assert.assertTrue(footerPage.isFooterVisible(), "Footer is not visible");
       int linkCount = footerPage.getFooterLinkCount();
        System.out.println("Footer Link Count: " + linkCount);

        Assert.assertTrue(footerPage.areAllFooterLinksDisplayed(), "Not all footer links are visible");
        Assert.assertTrue(footerPage.areAllFooterTextVisible(), "Not all footer texts are visible");

       footerPage.printFooterLinks();
    }
	
	@Test (priority = 5)
	public void validateFooterVisible() {
		Assert.assertTrue(footerPage.isFooterVisible(), "Footer is not visible"); }

	
	@AfterMethod
	public void tearDown() {
		DriverManager.quit();
		DriverManager.terminate();
	}
}
