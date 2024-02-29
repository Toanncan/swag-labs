package swap.labs.tests;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.LoginPageObject;
import pageObjects.ProductPageObject;

public class Swap_Labs_Login {
	WebDriver driver;
	private LoginPageObject loginPage;
	private ProductPageObject productPage;
	String projectPath = System.getProperty("user.dir");

	private String urlPage = "https://www.saucedemo.com/";
	private String userName = "standard_user";
	private String password = "secret_sauce";

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");

		driver = new FirefoxDriver();
		loginPage = new LoginPageObject(driver);
		productPage = new ProductPageObject(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void Login_01_Dont_Input_Data_And_Click_Login_Button() {
		System.out.println("Login_01 -- Step 01 : Open URL");
		loginPage.openPageUrl(driver, urlPage);

		System.out.println("Login_01 -- Step 02 : Click LoginButton");
		loginPage.clickToLoginButton();

		System.out.println("Login_01 -- Step 03 : Verify error mesage");
		assertEquals(loginPage.getErrorMessage(), "Epic sadface: Username is required");

	}

	@Test
	public void Login_02_Login_Successfully() {
		System.out.println("Login_02 -- Step 01 : Open URL");
		loginPage.openPageUrl(driver, urlPage);

		System.out.println("Login_02 -- Step 02 : Input data into UserName textbox and Password textbox");
		loginPage.inputToUsernameTextbox(userName);
		loginPage.inputToPasswordTextbox(password);

		System.out.println("Login_02 -- Step 03 : Click LoginButton");
		loginPage.clickToLoginButton();

		System.out.println("Login_02 -- Step 04 :Verify LoginSuccessfully and move to ProductPage");
		assertEquals(productPage.getPoductTitle(), "Products");
		assertEquals(productPage.getTotalProductOnPage(), 6);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
