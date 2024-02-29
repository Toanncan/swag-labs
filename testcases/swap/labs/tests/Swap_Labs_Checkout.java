package swap.labs.tests;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.CartPageObject;
import pageObjects.CheckoutPageObject;
import pageObjects.LoginPageObject;
import pageObjects.ProductPageObject;

public class Swap_Labs_Checkout {
	WebDriver driver;
	private LoginPageObject loginPage;
	private ProductPageObject productPage;
	private CartPageObject cartPage;
	private CheckoutPageObject checkoutPage;
	String projectPath = System.getProperty("user.dir");

	private String urlPage = "https://www.saucedemo.com/";
	private String userName = "standard_user";
	private String password = "secret_sauce";
	private String firstName = "standard";
	private String lastName = "user";
	private String zipPostalCode = "55000";

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");

		driver = new FirefoxDriver();
		loginPage = new LoginPageObject(driver);
		productPage = new ProductPageObject(driver);
		cartPage = new CartPageObject(driver);
		checkoutPage = new CheckoutPageObject(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void Checkout_01_Dont_Input_Information_And_Click_Continue_Button() {
		System.out.println("Checkout_01 -- Step 01 : Open URL");
		loginPage.openPageUrl(driver, urlPage);

		System.out.println("Checkout_01 -- Step 02 : input data valid at LoginPage");
		loginPage.inputToUsernameTextbox(userName);
		loginPage.inputToPasswordTextbox(password);

		System.out.println("Checkout_01 -- Step 03 :Click LoginButton  at LoginPage");
		loginPage.clickToLoginButton();

		System.out.println("Checkout_01 -- Step 04 :Add product to Cart and Move to CartPage");
		productPage.clickToAddToCartButton();
		productPage.clickToCartIcon();

		System.out.println("Checkout_01 -- Step 05 :Verify information product at CartPage");
		assertEquals(cartPage.getTitleProduct(), "Sauce Labs Backpack");
		assertEquals(cartPage.getDecriptionProduct(),"carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.");
		assertEquals(cartPage.getPriceProduct(), "$29.99");

		System.out.println("Checkout_01 -- Step 06 :Click Checkout Button at CartPage");
		cartPage.clickToCheckoutButton();

		System.out.println("Checkout_01 -- Step 07 :Click Continue Button at CheckoutPage");
		checkoutPage.clickToContinueButton();

		System.out.println("Checkout_01 -- Step 08 :Verify error message");
		assertEquals(checkoutPage.getErrorMessage(), "Error: First Name is required");
	}

	@Test
	public void Checkout_02_Checkout_Successfully() {
		System.out.println("Checkout_02 -- Step 01 : Open URL");
		loginPage.openPageUrl(driver, urlPage);

		System.out.println("Checkout_02 -- Step 02 : input data valid at LoginPage");
		loginPage.inputToUsernameTextbox(userName);
		loginPage.inputToPasswordTextbox(password);

		System.out.println("Checkout_02 -- Step 03 :Click LoginButton  at LoginPage");
		loginPage.clickToLoginButton();

		System.out.println("Checkout_02 -- Step 04 :Move to CartPage");
		productPage.clickToCartIcon();

		System.out.println("Checkout_02 -- Step 05 :Click Checkout Button at CartPage");
		cartPage.clickToCheckoutButton();

		System.out.println("Checkout_02 -- Step 06 :Input information at CheckoutPage");
		checkoutPage.inputToFirstNameTextbox(firstName);
		checkoutPage.inputToLastNameTextbox(lastName);
		checkoutPage.inputToZipPostalCodeTextbox(zipPostalCode);

		System.out.println("Checkout_02 -- Step 07 :Click Continue Button at CheckoutPage ");
		checkoutPage.clickToContinueButton();

		System.out.println("Checkout_02 -- Step 08 :Verify information product and total price ");
		assertEquals(checkoutPage.getProductName(), "Sauce Labs Backpack");
		assertEquals(checkoutPage.getProductDecription(),"carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.");
		assertEquals(checkoutPage.getProductPrice(), "$29.99");
		assertEquals(checkoutPage.getTotalPrice(), "Total: $32.39");

		System.out.println("Checkout_02 -- Step 09 :Click finish button");
		checkoutPage.clickToFinishButton();

		System.out.println("Checkout_02 -- Step 10 : Verify checkout complete");
		assertEquals(checkoutPage.getCheckoutComplete(), "Thank you for your order!");
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
