package com.qed42.qa.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public WebDriver driver;
	
	public By logo = By.cssSelector("#logo");
	//constructor
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	//Logo displayed
	public boolean isLogoDisplayed() {
		return driver.findElement(logo).isDisplayed();
	}
	//Page Title
	public String getPageTitle() {
		return driver.getTitle();
	}

}
