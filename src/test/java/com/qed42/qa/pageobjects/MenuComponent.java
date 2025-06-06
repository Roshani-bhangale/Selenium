package com.qed42.qa.pageobjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class MenuComponent {
	public WebDriver driver;

	public By menuItems = By.cssSelector("ul.nav.navbar-nav > li > a");

	public MenuComponent(WebDriver driver) {
		this.driver = driver;

	}

	public List<String> getMenuTexts() {
		List<WebElement> items = driver.findElements(menuItems);
		List<String> texts = new ArrayList<>();
		for (WebElement item : items) {
			texts.add(item.getText().trim());
		}
		return texts;
	}

	// Mega menu
	public By topMenuItems = By.cssSelector("ul.nav.navbar-nav > li > a");

	public List<WebElement> getTopMenuItems() {
		return driver.findElements(topMenuItems);
	}

	// return first top menu
	public String getFirstTopMenuText() {
		return getTopMenuItems().get(0).getText().trim();
	}

}
