package com.qed42.qa.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.List;
import org.openqa.selenium.WebElement;

public class HomePage {
	public WebDriver driver;
	
	public By logo = By.cssSelector("#logo");
	//constructor
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	//Logo displayed
	public boolean isLogoDisplayed() {
		return driver.findElement(logo).isDisplayed();
	}
	//Page Title
	public String getPageTitle() {
		return driver.getTitle();
	}

	//Mega menu 
	public By topMenuItems = By.cssSelector("ul.nav.navbar-nav > li > a");
	
	public List<WebElement> getTopMenuItems(){
		return driver.findElements(topMenuItems);
	}
	public String getFirstTopMenuText() {
		return getTopMenuItems().get(0).getText().trim();
	}
}
