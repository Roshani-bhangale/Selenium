package com.qed42.qa.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	public WebDriver driver;
	
	public By logo = By.cssSelector("#logo");

	private WebDriverWait wait;
	//constructor
	public HomePage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
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
	
	// Hero Banner Image
    @FindBy(css = "#slideshow0 img")
    public WebElement heroBannerImage;
    
    // (left/right)
    @FindBy(css = ".swiper-button-prev")
    public WebElement leftArrow;
    
    @FindBy(css = ".swiper-button-next")
    public WebElement rightArrow;
    
 // Method to check if image is displayed and not broken
    public boolean isHeroImageLoaded() {
    	WebElement heroImage = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#slideshow0 img")));
        wait.until(ExpectedConditions.visibilityOf(heroBannerImage));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        
        // Check if image is complete and naturalWidth > 0
        return (Boolean) js.executeScript(
            "let img = arguments[0]; return img.complete && typeof img.naturalWidth != 'undefined' && img.naturalWidth > 0;", 
            heroBannerImage
        );
    }
    
    // Carousel arrow click and visual validation
    public boolean clickCarouselArrow(WebElement arrow) {
        String beforeSrc = heroBannerImage.getAttribute("src");
        arrow.click();
        wait.until(ExpectedConditions.not(ExpectedConditions.attributeToBe(heroBannerImage, "src", beforeSrc)));

        String afterSrc = heroBannerImage.getAttribute("src");
        return !beforeSrc.equals(afterSrc); // ensure the image changed
    }

}
