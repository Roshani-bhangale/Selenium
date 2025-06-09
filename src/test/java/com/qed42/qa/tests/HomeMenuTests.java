package com.qed42.qa.tests;

import com.qed42.qa.tests.BaseTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.lang.System.Logger;
import java.lang.reflect.Array;
import java.time.Duration;
import java.util.List;
import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.qed42.qa.pageobjects.HomePage;
import com.qed42.qa.pageobjects.MenuComponent;
import com.qed42.qa.reportmanager.Report;

public class HomeMenuTests extends BaseTest {

	private WebDriverWait wait;

	@Test(priority = 1)
	public void verifyHomePageLogoAndTitle() {
		HomePage homePage = new HomePage(driver);
		Assert.assertTrue(homePage.isLogoDisplayed(), "Logo is not displayed.");
		Assert.assertTrue(homePage.getPageTitle().contains("Your Store"), "Page title mismatch.");

	}

	@Test(priority = 2)
	public void verifyMegaMenuItems() {
		MenuComponent menu = new MenuComponent(driver);
		List<String> expectedMenuItems = Arrays.asList("Desktops", "Laptops & Notebooks", "Components", "Tablets",
				"Software", "Phones & PDAs", "Cameras", "MP3 Players");

		List<String> actualMenuItems = menu.getMenuTexts();

		for (String expectedItem : expectedMenuItems) {
			Assert.assertTrue(actualMenuItems.contains(expectedItem), "Menu item missing: " + expectedItem);
		}
	}

	@Test(priority = 3)
	// first mega menu link Desktop
	public void firstMegaMenuIsDesktop() {
		MenuComponent menu = new MenuComponent(driver);
		String firstMenu = menu.getFirstTopMenuText();
		Assert.assertEquals(firstMenu, "Desktops", "First Menu item is not Desktops");
		Report.log(Status.PASS, "Verified the first mega menu is Desktops.");
//		ExtentReport.pass("Verified the first mega menu is Desktops.");
//		Logger.info("First Menu Item Text is: " + firstMenu);

	}

	@Test
	public void verifyHeroBannerIsVisible() {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement heroImage = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#slideshow0 img")));
		wait.until(ExpectedConditions.visibilityOf(heroImage));

		Assert.assertTrue(heroImage.isDisplayed(), "Hero banner image is not visible.");
	}

	@Test
	public void verifyHeroBannerAndCarousel() {
		HomePage home = new HomePage(driver);

		// Step 1: Verify hero image is not broken
		Assert.assertTrue(home.isHeroImageLoaded(), "Hero banner image is broken or not visible.");

		// Step 2: Verify carousel right arrow works
		Assert.assertTrue(home.clickCarouselArrow(home.rightArrow), "Carousel right arrow is not working.");

		// Step 3: Verify carousel left arrow works
		Assert.assertTrue(home.clickCarouselArrow(home.leftArrow), "Carousel left arrow is not working.");
	}
}
