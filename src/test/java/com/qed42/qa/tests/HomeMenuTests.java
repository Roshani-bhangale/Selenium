package com.qed42.qa.tests;

import com.qed42.qa.tests.BaseTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import java.lang.reflect.Array;
import java.util.List;
import java.util.Arrays;
import org.testng.Assert;
import com.qed42.qa.pageobjects.HomePage;
import com.qed42.qa.pageobjects.MenuComponent;


public class HomeMenuTests extends BaseTest {
	
	@Test(priority = 1)
	public void verifyHomePageLogoAndTitle() {
		HomePage homePage = new HomePage(driver);
		Assert.assertTrue(homePage.isLogoDisplayed(), "Logo is not displayed.");
		Assert.assertTrue(homePage.getPageTitle().contains("Your Store"), "Page title mismatch.");
		
	}
	@Test(priority = 2)
	public void verifyMegaMenuItems() {
		MenuComponent menu = new MenuComponent(driver);
		List<String> expectedMenuItems = Arrays.asList(
				"Desktops",
				"Laptops & Notebooks",
				"Components",
				"Tablets",
				"Software",
				"Phones & PDAs",
				"Cameras",
				"MP3 Players"
				);
		
		List<String> actualMenuItems = menu.getMenuTexts();
		
		for (String expectedItem : expectedMenuItems) {
			Assert.assertTrue(actualMenuItems.contains(expectedItem),
					"Menu item missing: " +expectedItem);
		}
	}

}
