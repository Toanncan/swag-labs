package pageObjects;

import org.openqa.selenium.WebDriver;

import common.CommonPage;
import pageUI.CartPageUI;
import pageUI.ProductPageUI;

public class CartPageObject extends CommonPage {
private WebDriver driver;
	public CartPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getTitleProduct() {
		waitForElementVisible(driver, CartPageUI.PRODUCT_TITLE);
		return getWebElementText(driver, CartPageUI.PRODUCT_TITLE);
	}
	
	public String getDecriptionProduct() {
		waitForElementVisible(driver, CartPageUI.PRODUCT_DESCRIPTION);
		return getWebElementText(driver, CartPageUI.PRODUCT_DESCRIPTION);
	}
	
	public String getPriceProduct() {
		waitForElementVisible(driver, CartPageUI.PRODUCT_PRICE);
		return getWebElementText(driver, CartPageUI.PRODUCT_PRICE);
	}
	
public void clickToCheckoutButton() {
	waitForElementClickable(driver, CartPageUI.CHECKOUT_BUTTON);
	clickToElement(driver, CartPageUI.CHECKOUT_BUTTON);
}
}
