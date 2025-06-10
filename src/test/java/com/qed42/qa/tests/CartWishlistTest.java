package com.qed42.qa.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qed42.qa.pageobjects.CategoryPage;

public class CartWishlistTest extends BaseTest {
	
    @Test
    public void verifyAddToCartFunctionality() {
        driver.get("https://tutorialsninja.com/demo/index.php?route=product/category&path=24");
        CategoryPage category = new CategoryPage(driver);

        category.addFirstProductToCart();
        category.openCartDropdown();

        Assert.assertTrue(category.isProductInCart(), "Product not found in cart.");
    }

    @Test
    public void verifyAddToWishlistFunctionality() {
        driver.get("https://tutorialsninja.com/demo/index.php?route=product/category&path=24");
        CategoryPage category = new CategoryPage(driver);

        category.addFirstProductToWishlist();
        Assert.assertTrue(category.successMessage.getText().contains("Success"), "Wishlist message not displayed.");
    }

}
