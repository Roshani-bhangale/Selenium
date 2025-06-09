package com.qed42.qa.tests;

import org.testng.annotations.Test;
import org.testng.Assert;
import com.qed42.qa.pageobjects.FeaturedProductPage;

public class FeaturedProductTests extends BaseTest {

	@Test
	public void verifyFeaturedProductSection() {
		driver.get("https://tutorialsninja.com/demo/");
		FeaturedProductPage featured = new FeaturedProductPage(driver); 
		
		Assert.assertTrue(featured.isFeatureProductSectionVisisble(), "Featured Product section is not visible");
		
		featured.printAllFeaturedProductDetails();
		
		boolean applecinemaDetailsCorrect = featured.isProductDetailsDisplayedCorrectly("Apple Cinema 30", "The 30-inch Apple Cinema", "$110.00");
		Assert.assertTrue(applecinemaDetailsCorrect, "MacBook product details are incorrect.");
	}

}
