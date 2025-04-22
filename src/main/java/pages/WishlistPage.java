package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WishlistPage extends PageBase
{
	public WishlistPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(css = "td.product")
    public WebElement productCell;
    
    @FindBy(css = "h1")
    public WebElement wishlistHeader;
   
    @FindBy(css = "td.remove-from-cart")
    private WebElement removefromCartCheck;
   
    @FindBy(css = "div.no-data")
    public WebElement EmptyCartLbl;
   
    public void removeProductFromWishlist() {
        clickButton(removefromCartCheck);
    }
}
