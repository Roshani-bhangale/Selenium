package com.qed42.qa.tests;

import org.openqa.selenium.WebDriver;
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
	@Test
	public void validateMenu() {
		Assert.assertTrue(headerPage.isMenuDisplayed(), "Menu is not visible.");
		
	}
	
	@Test
	public void validateSearch() {
		headerPage.performSearch("Samsung Galaxy Tab 10.1");
	}
	
	@Test
	public void verifyFooterContent() {
        Assert.assertTrue(footerPage.isFooterVisible(), "Footer is not visible");
        int linkCount = footerPage.getFooterLinkCount();
        System.out.println("Footer Link Count: " + linkCount);

        Assert.assertTrue(footerPage.areAllFooterLinksDisplayed(), "Not all footer links are visible");
        Assert.assertTrue(footerPage.areAllFooterTextVisible(), "Not all footer texts are visible");

        footerPage.printFooterLinks();
    }
	
	@Test
	public void validateFooterVisible() {
		Assert.assertTrue(footerPage.isFooterVisible(), "Footer is not visible"); }
	
	@Test
	public void verifyFooterLinksAreDisplayed() {
		int linkCount = footerPage.getFooterLinkCount();
		System.out.println("Footer link Count: " + linkCount);
		footerPage.printFooterLinks();
		Assert.assertTrue(linkCount > 0, "No footer links found.");
		Assert.assertTrue(footerPage.areAllFooterLinksDisplayed(), "Some footer links are not visible.");
	}
	
	@AfterMethod
	public void tearDown() {
		DriverManager.quit();
		DriverManager.terminate();
	}
}
