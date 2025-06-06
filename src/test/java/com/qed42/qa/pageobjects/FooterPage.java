package com.qed42.qa.pageobjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FooterPage extends HomePage {
	private static final By AllFooterLink = By.cssSelector("footer");

	private WebDriverWait wait;

	public FooterPage(WebDriver driver) {
		super(driver);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	public void AllFooterLink() {
		WebElement link = driver.findElement(AllFooterLink);

		// Scroll to the element
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", link);

		// Add a small wait to ensure it's visible
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Now click the link
		link.click();
	}

	@FindBy(css = "footer")
	public WebElement footerSection;

	@FindBy(css = "footer ul li a")
	public List<WebElement> footerLinks;

	@FindBy(css = "footer p, footer span, footer div")
	public List<WebElement> footerTextElements;

	public boolean isFooterVisible() {
		return footerSection.isDisplayed();
	}

	public int getFooterLinkCount() {
		return footerLinks.size();
	}

	public boolean areAllFooterLinksDisplayed() {
		for (WebElement link : footerLinks) {
			if(!link.isDisplayed()) {
				return false;
			}
		}
		return true;
	}
	
	 public boolean areAllFooterTextVisible() {
	        for (WebElement text : footerTextElements) {
	            if (!text.isDisplayed()) return false;
	        }
	        return true;
	    }

	public void printFooterLinks() {
		for (WebElement link : footerLinks) {
			System.out.println("Text" + link.getText() + "|Href:" + link.getAttribute("href"));
		}
	}
}
