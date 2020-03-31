package com.ariat.Tests.Checkout.CreateOrder.GuestCreditCard;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.ariat.Enums.EUCountries;
import com.ariat.Enums.Environments;
import com.ariat.Enums.ListOfCreditCards;
import com.ariat.Enums.SelectCountry;
import com.ariat.Pages.HomePagesCountries.HomePage;
import com.ariat.Pages.HomePagesCountries.HomePageUK;
import com.ariat.Pages.HomePagesCountries.HomePageUS;
import com.ariat.Pages.Main.CheckoutPage;
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

public class CheckoutCreateOrderGuestCreditCardUSTest extends BaseTest {

	private Environments environment;
	private EUCountries euCountry;
	private HomePage homePage;
	private HomePageUK homePageUK;
	private HomePageUS homePageUS;
	private MyBagPage myBagPage;
	private BagsProductPage bagsProductPage;
	private CheckoutPage checkoutPage;
	private CheckoutProcessPage checkoutProcessPage;
	private PaymentMethodsCheckoutPage paymentMethodsCheckoutPage;


	public static final String CARD_NAME = GenerateRandomDataUtils.generateRandomString(5);
	public static final String FIRST_NAME = GenerateRandomDataUtils.generateRandomString(5);
	public static final String LAST_NAME = GenerateRandomDataUtils.generateRandomString(7);
	public static final String ADDRESS = "W. Adams St.";
	public static final String CITY = "Phoenix";
	public static final String STATE = "Arizona";
	public static final String ZIP_CODE = "85007";
	public static final String MOBILE = "(602) 364-2722";
	public static final String PASSWORD = GenerateRandomDataUtils.generateRandomString(10);
	private ListOfCreditCards typeCard;
	private SelectCountry optionCountry;

	@BeforeTest
	public void setSeleniumUP() {
		SetSelenium setPath = new SetSelenium();
		setPath.setSelenium();
	}

	@Test(priority = 0)
	public void checkoutCreateNewOrderNotBeingLoggedMasterCard() {
		logger.info("Starting checkout -> create new order without being logged credit card Master Card test...");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
		homePageUS = (HomePageUS) homePage.chooseEULocation(euCountry.USA, euCountry.USA.getCurrencyISO());
		bagsProductPage = homePageUS.returnBagsProductPage();
		myBagPage = bagsProductPage.returnMyBagPage();
		checkoutPage = myBagPage.returnCheckoutPage();
		checkoutProcessPage = checkoutPage.returnCheckoutProcessPage();
		checkoutProcessPage.setInfoAccountSecureCheckoutUS(FIRST_NAME, LAST_NAME, ADDRESS, CITY, ZIP_CODE, MOBILE, CredentialsUtils.getProperty("email"));
		paymentMethodsCheckoutPage= checkoutProcessPage.returnPaymentMethodsCheckoutPage();
		paymentMethodsCheckoutPage.useAddressAsItIs();
		paymentMethodsCheckoutPage.setPaymentDetailsSecureCheckoutUS(CARD_NAME, typeCard.MASTER_CARD.getNumber(), typeCard.MASTER_CARD.getCvs());
		paymentMethodsCheckoutPage.reviewOrderUS();
		paymentMethodsCheckoutPage.placeOrderUS();
		logger.info("Finishing checkout -> create new order without being logged credit card Master Card test.");
	} 
	
	
	@Test(priority = 1)
	public void checkoutCreateNewOrderNotBeingLoggedVisa() {
		logger.info("Starting checkout -> create new order without being logged credit card Visa test...");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
		homePageUS = (HomePageUS) homePage.chooseEULocation(euCountry.USA, euCountry.USA.getCurrencyISO());
		bagsProductPage = homePageUS.returnBagsProductPage();
		myBagPage = bagsProductPage.returnMyBagPage();
		checkoutPage = myBagPage.returnCheckoutPage();
		checkoutProcessPage = checkoutPage.returnCheckoutProcessPage();
		checkoutProcessPage.setInfoAccountSecureCheckoutUS(FIRST_NAME, LAST_NAME, ADDRESS, CITY, ZIP_CODE, MOBILE, CredentialsUtils.getProperty("email"));
		paymentMethodsCheckoutPage= checkoutProcessPage.returnPaymentMethodsCheckoutPage();
		paymentMethodsCheckoutPage.useAddressAsItIs();
		paymentMethodsCheckoutPage.setPaymentDetailsSecureCheckoutUS(CARD_NAME, typeCard.VISA.getNumber(), typeCard.VISA.getCvs());
		paymentMethodsCheckoutPage.reviewOrderUS();
		paymentMethodsCheckoutPage.placeOrderUS();
		logger.info("Finishing checkout -> create new order without being logged credit card Visa test.");
	}
	
	@Test(priority = 2)
	public void checkoutCreateNewOrderNotBeingLoggedAmericanExpress() {
		logger.info("Starting checkout -> create new order without being logged credit card American Express test...");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
		homePageUS = (HomePageUS) homePage.chooseEULocation(euCountry.USA, euCountry.USA.getCurrencyISO());
		bagsProductPage = homePageUS.returnBagsProductPage();
		myBagPage = bagsProductPage.returnMyBagPage();
		checkoutPage = myBagPage.returnCheckoutPage();
		checkoutProcessPage = checkoutPage.returnCheckoutProcessPage();
		checkoutProcessPage.setInfoAccountSecureCheckoutUS(FIRST_NAME, LAST_NAME, ADDRESS, CITY, ZIP_CODE, MOBILE, CredentialsUtils.getProperty("email"));
		paymentMethodsCheckoutPage= checkoutProcessPage.returnPaymentMethodsCheckoutPage();
		paymentMethodsCheckoutPage.useAddressAsItIs();
		paymentMethodsCheckoutPage.setPaymentDetailsSecureCheckoutUS(CARD_NAME, typeCard.AMERICAN_EXPRESS.getNumber(), typeCard.AMERICAN_EXPRESS.getCvs());
		paymentMethodsCheckoutPage.reviewOrderUS();
		paymentMethodsCheckoutPage.placeOrderUS();
		logger.info("Finishing checkout -> create new order without being logged credit card American Express test.");
	} 
	
@AfterTest
	public void clearBrowserSession() {
		homePage.quit();
		homePageUK.quit();
		homePageUS.quit();
		myBagPage.quit();
		checkoutProcessPage.quit();
		checkoutPage.quit();
    	bagsProductPage.quit();
    	KillChrome kill = new KillChrome();
		kill.killChrome();
	}
}
