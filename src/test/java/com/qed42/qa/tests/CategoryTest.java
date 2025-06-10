package com.qed42.qa.tests;

import org.testng.annotations.Test;

import org.testng.Assert;
import com.qed42.qa.pageobjects.CategoryPage;

public class CategoryTest extends BaseTest{
	
	   @Test
	    public void verifySortingFunctionality() {
	        driver.get("https://tutorialsninja.com/demo/index.php?route=product/category&path=24");
	        CategoryPage category = new CategoryPage(driver);

	        category.selectSortOption("Name (A - Z)");
	        Assert.assertEquals(category.getSelectedSortOption(), "Name (A - Z)", "Sort option did not select correctly.");
	        Assert.assertTrue(category.isProductDisplayed(), "No products displayed after sorting.");
	    }

	    @Test
	    public void verifyListAndGridViewToggle() {
	        driver.get("https://tutorialsninja.com/demo/index.php?route=product/category&path=24");
	        CategoryPage category = new CategoryPage(driver);

	        // Test List View
	        category.clickListView();
	        Assert.assertTrue(category.isProductDisplayed(), "No products found in List view.");
	        // Cannot fully verify layout without deeper DOM structure, use visual checks or class names
	        System.out.println("List View clicked.");

	        // Test Grid View
	        category.clickGridView();
	        Assert.assertTrue(category.isProductDisplayed(), "No products found in Grid view.");
	        System.out.println("Grid View clicked.");
	    }

}
