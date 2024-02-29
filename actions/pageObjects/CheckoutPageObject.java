package pageObjects;

import org.openqa.selenium.WebDriver;

import common.CommonPage;
import pageUI.CheckoutPageUI;

public class CheckoutPageObject extends CommonPage {
private WebDriver driver;
	
	public CheckoutPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public void inputToFirstNameTextbox(String firstName) {
		waitForElementVisible(driver, CheckoutPageUI.FIRST_NAME_TEXTBOX);
		sendkeyToElement(driver, CheckoutPageUI.FIRST_NAME_TEXTBOX, firstName);
	}
	
	public void inputToLastNameTextbox(String lastName) {
		waitForElementVisible(driver, CheckoutPageUI.LAST_NAME_TEXTBOX);
		sendkeyToElement(driver, CheckoutPageUI.LAST_NAME_TEXTBOX, lastName);
	}
	
	public void inputToZipPostalCodeTextbox(String zipPostalCode) {
		waitForElementVisible(driver, CheckoutPageUI.ZIP_POSTAL_CODE_TEXTBOX);
		sendkeyToElement(driver, CheckoutPageUI.ZIP_POSTAL_CODE_TEXTBOX, zipPostalCode);
	}
	
	public String getErrorMessage() {
		waitForElementVisible(driver, CheckoutPageUI.ERROR_MESSAGE);
		return getWebElementText(driver, CheckoutPageUI.ERROR_MESSAGE);
	}
	
	public void clickToContinueButton() {
		waitForElementClickable(driver, CheckoutPageUI.CONTINUE_BUTTON);
		clickToElement(driver, CheckoutPageUI.CONTINUE_BUTTON);
	}
	
	public void clickToFinishButton() {
		waitForElementClickable(driver, CheckoutPageUI.FINISH_BUTTON);
		clickToElement(driver, CheckoutPageUI.FINISH_BUTTON);
	}
	
	public String getTotalPrice() {
		waitForElementVisible(driver, CheckoutPageUI.TOTAL_PRICE);
		return getWebElementText(driver, CheckoutPageUI.TOTAL_PRICE);
	}
	
	public String getProductName() {
		waitForElementVisible(driver, CheckoutPageUI.PRODUCT_NAME);
		return getWebElementText(driver, CheckoutPageUI.PRODUCT_NAME);
	}
	
	public String getProductDecription() {
		waitForElementVisible(driver, CheckoutPageUI.PRODUCT_DECRIPTION);
		return getWebElementText(driver, CheckoutPageUI.PRODUCT_DECRIPTION);
	}

	public String getProductPrice() {
		waitForElementVisible(driver, CheckoutPageUI.PRODUCT_PRICE);
		return getWebElementText(driver, CheckoutPageUI.PRODUCT_PRICE);
	} 
	
	public String getCheckoutComplete() {
		waitForElementVisible(driver, CheckoutPageUI.CHECKOUT_COMPLETE);
		return getWebElementText(driver, CheckoutPageUI.CHECKOUT_COMPLETE);
	}
}
