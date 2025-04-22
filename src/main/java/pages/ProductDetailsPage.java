package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends PageBase
{
	public ProductDetailsPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css="strong.current-item")
	public WebElement productNamebreadCrumb; 

	@FindBy(css="button.button-2.email-a-friend-button")
	WebElement emailFriendBtn ; 

	@FindBy(css="span.price-value-4")
	public WebElement productPricelbl ;

	@FindBy(css="button.button-2.add-to-wishlist-button")
	WebElement addToWishlistBtn ; 

	@FindBy(linkText="Add your review")
	WebElement addReviewLink; 

	@FindBy(css="button.button-2.add-to-compare-list-button")
	WebElement addToCompareBtn ; 
	
	@FindBy(css="button.button-1.add-to-cart-button")
	WebElement addToCartBtn ; 

	@FindBy(linkText="shopping cart")
	WebElement openCartBtn ; 
	
	public void openSendEmail() 
	{
		clickButton(emailFriendBtn);
	}

	public void openAddReviewPage() 
	{
		clickButton(addReviewLink);
	}

	public void AddProductToWishlist() 
	{
		clickButton(addToWishlistBtn);
	}

	public void AddProductToCompare() 
	{
		clickButton(addToCompareBtn);
	}

	public void AddToCart() 
	{
		clickButton(addToCartBtn);
	}
	
	public void OpenCart()
	{
		clickButton(openCartBtn);
	}

}
