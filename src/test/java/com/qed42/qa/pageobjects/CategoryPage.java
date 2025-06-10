package com.qed42.qa.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class CategoryPage extends HomePage {
	
	public CategoryPage (WebDriver driver) {
	super(driver);
	}
	
	@FindBy(id = "input-sort")
	public WebElement sortDropDown;
	
	@FindBy(css = "#content .product-layout")
	public List<WebElement> productItems;
	
	@FindBy(css = ".btn-group .btn-list")
	public WebElement listViewButton;
	
	 @FindBy(css = ".btn-group .btn-grid")
	    public WebElement gridViewButton;
	 
	 @FindBy(css = ".product-layout")
	    public List<WebElement> productList;

	    @FindBy(css = ".product-layout:first-child button[onclick*='cart.add']")
	    public WebElement firstProductAddToCartButton;

	    @FindBy(css = ".product-layout:first-child button[onclick*='wishlist.add']")
	    public WebElement firstProductAddToWishlistButton;

	    @FindBy(css = "#cart button")
	    public WebElement cartButton;

	    @FindBy(css = "#cart .dropdown-menu")
	    public WebElement cartDropdown;

	    @FindBy(css = "#cart .dropdown-menu .text-left a")
	    public WebElement cartProductLink;

	    @FindBy(css = ".alert-success")
	    public WebElement successMessage;


	    public void selectSortOption(String visibleText) {
	        Select sortSelect = new Select(sortDropDown);
	        sortSelect.selectByVisibleText(visibleText);
	    }

	    public String getSelectedSortOption() {
	        Select sortSelect = new Select(sortDropDown);
	        return sortSelect.getFirstSelectedOption().getText();
	    }	    
	    public void clickListView() {
	        listViewButton.click();
	    }

	    public void clickGridView() {
	        gridViewButton.click();
	    }

	    public boolean isProductDisplayed() {
	        return !productItems.isEmpty();
	    }

	    public boolean isListViewActive() {
	        return productItems.stream().allMatch(e -> e.getAttribute("class").contains("product-list"));
	    }

	    public boolean isGridViewActive() {
	        return productItems.stream().allMatch(e -> e.getAttribute("class").contains("product-grid"));
	    }
	    
	    public void addFirstProductToCart() {
	        wait.until(ExpectedConditions.elementToBeClickable(firstProductAddToCartButton)).click();
	        wait.until(ExpectedConditions.visibilityOf(successMessage));
	    }

	    public void openCartDropdown() {
	        wait.until(ExpectedConditions.elementToBeClickable(cartButton)).click();
	        wait.until(ExpectedConditions.visibilityOf(cartDropdown));
	    }

	    public boolean isProductInCart() {
	        return cartProductLink.isDisplayed();
	    }

	    public void addFirstProductToWishlist() {
	        wait.until(ExpectedConditions.elementToBeClickable(firstProductAddToWishlistButton)).click();
	        wait.until(ExpectedConditions.visibilityOf(successMessage));
	    }


	}

