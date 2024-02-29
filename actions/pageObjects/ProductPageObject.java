package pageObjects;

import org.openqa.selenium.WebDriver;

import common.CommonPage;
import pageUI.ProductPageUI;

public class ProductPageObject extends CommonPage {
	private WebDriver driver;

	public ProductPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToAddToCartButton() {
		waitForElementClickable(driver, ProductPageUI.ADD_TO_CART_BUTTON);
		clickToElement(driver, ProductPageUI.ADD_TO_CART_BUTTON);
	}

	public void clickToCartIcon() {
		waitForElementClickable(driver, ProductPageUI.CART_ICON);
		clickToElement(driver, ProductPageUI.CART_ICON);
	}

	public String getPoductTitle() {
		waitForElementVisible(driver, ProductPageUI.TITLE);
		return getWebElementText(driver, ProductPageUI.TITLE);
	}

	public int getTotalProductOnPage() {
		return getWebElementSize(driver, ProductPageUI.PRODUCT);
	}

}
