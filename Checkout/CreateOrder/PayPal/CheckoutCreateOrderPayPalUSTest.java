package com.ariat.Tests.Checkout.CreateOrder.PayPal;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.ariat.Enums.EUCountries;
import com.ariat.Enums.Environments;
import com.ariat.Pages.HomePagesCountries.HomePage;
import com.ariat.Pages.HomePagesCountries.HomePageUK;
import com.ariat.Pages.HomePagesCountries.HomePageUS;
import com.ariat.Pages.Main.CheckoutPage;
import com.ariat.Pages.Main.CheckoutProcessCompletePage;
import com.ariat.Pages.Main.CheckoutProcessPage;
import com.ariat.Pages.Main.MyBagPage;
import com.ariat.Pages.Main.PaymentMethodsCheckoutPage;
import com.ariat.Pages.Products.BagsProductPage;
import com.ariat.Tests.Base.BaseTest;
import com.ariat.Utils.CredentialsUtils;
import com.ariat.Utils.GenerateRandomDataUtils;
import com.ariat.Utils.KillChrome;
import com.ariat.Utils.SetSelenium;

/**
 * Checkout -> Create new order
 * 
 * @author aila.bogasieru@ariat.com
 *
 */

public class CheckoutCreateOrderPayPalUSTest extends BaseTest {

	private Environments environment;
	private EUCountries euCountry;
	private HomePage homePage;
	private HomePageUK homePageUK;
	private HomePageUS homePageUS;
	private MyBagPage myBagPage;
	private BagsProductPage bagsProductPage;
	private CheckoutPage checkoutPage;
	private CheckoutProcessPage checkoutProcessPage;
	private CheckoutProcessCompletePage checkoutProcessCompletePage;
	private com.ariat.Pages.Main.MyAccountPage myAccountPage;
	private PaymentMethodsCheckoutPage paymentMethodsCheckoutPage;

	public static final String FIRST_NAME = GenerateRandomDataUtils.generateRandomString(5);
	public static final String LAST_NAME = GenerateRandomDataUtils.generateRandomString(7);
	public static final String ADDRESS1 = GenerateRandomDataUtils.generateRandomString(5);
	public static final String ADDRESS = "W. Adams St.";
	public static final String CITY = "Phoenix";
	public static final String STATE = "Arizona";
	public static final String ZIP_CODE = "85007";
	public static final String MOBILE = "(602) 364-2722";

	@BeforeTest
	public void setSeleniumUP() {
		SetSelenium setPath = new SetSelenium();
		setPath.setSelenium();
	}
	
	@Test(priority = 0)
	public void checkoutCreateNewOrderPayPal() {
		logger.info(
				"Starting checkout -> create new order without being logged using paypal as payment method test...");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
		homePageUS = (HomePageUS) homePage.chooseEULocation(euCountry.USA, euCountry.USA.getCurrencyISO());
		bagsProductPage = homePageUS.returnBagsProductPage();
		myBagPage = bagsProductPage.returnMyBagPage();
		checkoutPage = myBagPage.returnCheckoutPage();
		checkoutProcessPage = checkoutPage.returnCheckoutProcessPayPalPage();
		/*checkoutProcessPage.enterEmailPayPal("aila.bogasieru@gmail.com");
		checkoutProcessPage.nextBtnPayPal();
		checkoutProcessPage.enterPasswordPayPal("Ariat123!");
		checkoutProcessPage.clickLoginPayPal();
		checkoutProcessPage.clickConfirmPayPal();*/
		checkoutProcessPage.setDetailsPayPal(CredentialsUtils.getProperty("emailPayPal"), CredentialsUtils.getProperty("passwordPayPal"));
		checkoutProcessCompletePage = checkoutProcessPage.returnCheckoutProcessCompletePage();
		logger.info("Finishing checkout -> create new order without being logged using paypal as payment method test.");
	} 
	
	@Test(priority = 1)
    public void checkoutCreateNewOrderPayPalFromShipping() {
	   logger.info("Starting checkout -> create new order without being logged credit card PayPal test...");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
		homePageUS = (HomePageUS) homePage.chooseEULocation(euCountry.USA, euCountry.USA.getCurrencyISO());
		bagsProductPage = homePageUS.returnBagsProductPage();
		myBagPage = bagsProductPage.returnMyBagPage();
		checkoutPage = myBagPage.returnCheckoutPage();
		checkoutProcessPage = checkoutPage.returnCheckoutProcessPage();
		checkoutProcessPage.setInfoAccountSecureCheckoutUS(FIRST_NAME, LAST_NAME, ADDRESS, CITY, ZIP_CODE, MOBILE, CredentialsUtils.getProperty("email"));
		paymentMethodsCheckoutPage.pressPaymentMethods("PayPal");
		paymentMethodsCheckoutPage.clickPayPalDirect();
		paymentMethodsCheckoutPage.enterAccountDetailsPayPal(CredentialsUtils.getProperty("emailPayPal"), CredentialsUtils.getProperty("passwordPayPal"));
		paymentMethodsCheckoutPage.clickLoginPayPal();
		paymentMethodsCheckoutPage.clickConfirmPayPal();
		checkoutProcessCompletePage = checkoutProcessPage.returnCheckoutProcessCompletePage();
		logger.info("Finishing checkout -> create new order without being logged PayPal test.");
	}

  	@AfterTest
	public void tearDown() {
		homePage.quit();
		homePageUK.quit();
		homePageUS.quit();
		myBagPage.quit();
		checkoutProcessPage.quit();
		checkoutPage.quit();
		checkoutProcessCompletePage.quit();
		bagsProductPage.quit();
		myAccountPage.quit();
		paymentMethodsCheckoutPage.quit();
		KillChrome kill = new KillChrome();
		kill.killChrome();
	}
}
