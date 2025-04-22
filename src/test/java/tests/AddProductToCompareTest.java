package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ComparePage;
import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class AddProductToCompareTest extends TestBase
{
    String firstProductName = "Apple MacBook Pro";
    String secondProductName = "Asus Laptop"; 

	// 1- Search for product number 1
	// 2- Search for product number 2 
	// 3- Add to compare 
	// 4- Clear list

	ProductDetailsPage detailsObject ; 
	HomePage homeObject ; 
	ComparePage compareObject ; 
	SearchPage searchObject ; 

	@Test(priority = 1)
	public void UserCanCompareProducts() throws InterruptedException {
		searchObject = new SearchPage(driver);
		detailsObject = new ProductDetailsPage(driver);
		compareObject = new ComparePage(driver);

		searchObject.ProductSearchUsingAutoSuggest("MacB");
		Assert.assertTrue(detailsObject.productNamebreadCrumb.getText().contains(firstProductName));
		detailsObject.AddProductToCompare();

		searchObject.ProductSearchUsingAutoSuggest("Asus");
		Assert.assertTrue(detailsObject.productNamebreadCrumb.getText().contains(secondProductName));
		detailsObject.AddProductToCompare();
		Thread.sleep(1000);

		driver.navigate().to("https://localhost:59579" + "/compareproducts");
		Assert.assertTrue(compareObject.firstProductName.getText().equals("Asus Laptop"));
		Assert.assertTrue(compareObject.secodProductName.getText().equals("Apple MacBook Pro"));
		compareObject.CompareProducts();	
	}

	@Test(priority=2)
	public void UserCanClearCompareList() {
		compareObject.clearCompareList();
		Assert.assertTrue(compareObject.noDataLbl.getText().contains("You have no items to compare."));
	}
}
