package com.qed42.qa.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
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


	}

