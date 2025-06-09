package com.qed42.qa.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;

public class FeaturedProductPage extends HomePage {

	public FeaturedProductPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(css = "#content .product-layout")
	public List<WebElement> featuredProducts;
	
	@FindBy(css = "#content .product-layout .caption h4 a")
	public List<WebElement> productTitles;
	
	@FindBy(css = "#content .product-layout .caption p")
	public List<WebElement> productDescriptions;
	
	@FindBy(css = "#content .product-layout .caption .price")
	public List<WebElement> productPrices;
	
	public boolean isFeatureProductSectionVisisble() {
		return !featuredProducts.isEmpty();
	}
	
	public void printAllFeaturedProductDetails() {
		for(int i = 0; i<featuredProducts.size(); i++) {
			System.out.println("---- Product: " + (i+1) + " ---- ");
			System.out.println("Title: " + productTitles.get(i).getText());
			System.out.println("Description: " + productDescriptions.get(i).getText());
			System.out.println("Price: " + productPrices.get(i).getText());
		}
	}
	public boolean isProductDetailsDisplayedCorrectly(String expectedTitle, String expectedDescription, String expectedPrice) {
		for (int i = 0; i < productTitles.size(); i++) {
			if(productTitles.get(i).getText().equalsIgnoreCase(expectedTitle)) {
				String desc = productDescriptions.get(i).getText();
				String price = productPrices.get(i).getText();
				return desc.contains(expectedDescription) && price.contains(expectedPrice);
				
			}
		}
		return false;
	}

}
