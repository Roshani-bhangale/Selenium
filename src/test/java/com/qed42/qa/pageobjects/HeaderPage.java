package com.qed42.qa.pageobjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HeaderPage extends HomePage {
	private WebDriverWait wait;

//	private WebElement menu;
	public HeaderPage(WebDriver driver) {
		super(driver);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		this.menu = wait.until(
//			ExpectedConditions.visibilityOfElementLocated(By.cssSelector("nav .menu"))
//		);
	}
	
	@FindBy(id = "menu")
	public WebElement menu;
	
	@FindBy(css = "ul.nav.navbar-nav > li.dropdown")
	public List<WebElement> menuLinks;

	Actions actions = new Actions(driver);
	
	@FindBy(id = "search")
	public WebElement searchBox;
	
	@FindBy(css = "#search input[name='search']")
	public WebElement searchInput;

	@FindBy(css = "#search button")
	public WebElement searchButton;
	
	
	public boolean isMenuDisplayed() {
		return menu.isDisplayed();
	}
	
	public void hoverOnAllMenus() {
	    for (WebElement menu : menuLinks) {
	        wait.until(ExpectedConditions.visibilityOf(menu));
	        actions.moveToElement(menu).pause(Duration.ofSeconds(1)).perform();
	        System.out.println("Hovered on: " + menu.getText());
	    }
	}
	
	public void printFooterLinks() {
		for (WebElement link : menuLinks) {
			System.out.println("Text" + link.getText() + "|Href:" + link.getAttribute("href"));
		}
	}
	
	public void performSearch(String keyword) {
	    wait.until(ExpectedConditions.visibilityOf(searchInput));
	    searchInput.clear();
	    searchInput.sendKeys(keyword);
	    wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();
	}

	public int getmenuLinkCount() {
		// TODO Auto-generated method stub
		return menuLinks.size();
	}
	

}
