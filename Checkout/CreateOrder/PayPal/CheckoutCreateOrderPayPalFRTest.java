package com.ariat.Tests.Checkout.CreateOrder.PayPal;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.ariat.Enums.EUCountries;
import com.ariat.Enums.Environments;
import com.ariat.Enums.SelectCountry;
import com.ariat.Pages.Categories.WomenCategories.WomenCategoryPage;
import com.ariat.Pages.Categories.WomenCategories.WomenAccessories.WomenAccessoriesSubcategories.WomenAccessoriesGlovesPage;
import com.ariat.Pages.Categories.WomenCategories.WomenSubcategories.WomenAccessoriesPage;
import com.ariat.Pages.HomePagesCountries.HomePage;
import com.ariat.Pages.HomePagesCountries.HomePageUK;
import com.ariat.Pages.HomePagesCountries.HomePageFR;
import com.ariat.Pages.Main.CheckoutPage;
import com.ariat.Pages.Main.CheckoutProcessCompletePage;
import com.ariat.Pages.Main.CheckoutProcessPage;
import com.ariat.Pages.Main.MyBagPage;
import com.ariat.Pages.Main.PaymentMethodsCheckoutPage;
import com.ariat.Pages.Products.GlovesProductPage;
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

public class CheckoutCreateOrderPayPalFRTest extends BaseTest {

	private Environments environment;
	private EUCountries euCountry;
	private HomePage homePage;
	private HomePageUK homePageUK;
	private HomePageFR homePageFR;
	private WomenCategoryPage womenCategoryPage;
	private MyBagPage myBagPage;
	private WomenAccessoriesPage womenAccessoriesPage;
	private WomenAccessoriesGlovesPage womenAccessoriesGlovesPage;
	private GlovesProductPage glovesProductPage;
	private CheckoutPage checkoutPage;
	private CheckoutProcessPage checkoutProcessPage;
	private CheckoutProcessCompletePage checkoutProcessCompletePage;
	private com.ariat.Pages.Main.MyAccountPage myAccountPage;
	private PaymentMethodsCheckoutPage paymentMethodsCheckoutPage;
	    
   
    public static final String FIRST_NAME = GenerateRandomDataUtils.generateRandomString(5);
	public static final String LAST_NAME = GenerateRandomDataUtils.generateRandomString(7);
	public static final String ADDRESS = GenerateRandomDataUtils.generateRandomString(5);
	public static final String ADDRESS1 = GenerateRandomDataUtils.generateRandomString(5);
	public static final String CITY = "Paris";
	public static final String COUNTRY = "France";
	public static final String ZIP_CODE = GenerateRandomDataUtils.generateRandomNumber(5);
	public static final String MOBILE = GenerateRandomDataUtils.generateRandomNumber(7);
	private SelectCountry optionCountry;

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
		homePageFR = (HomePageFR) homePage.chooseEULocation(euCountry.FR, euCountry.FR.getCurrencyISO());
		womenCategoryPage = homePageFR.returnWomenCategoryPage();
		womenAccessoriesPage = womenCategoryPage.returnWomenAccessoriesCategoryLeftNavPageFR();
		womenAccessoriesGlovesPage = womenAccessoriesPage.returnWomenAccessoriesGlovesCategoryleftNavPageFR();
		glovesProductPage = womenAccessoriesGlovesPage.returnGlovesProductPagePage();
		glovesProductPage.selectAttributeSize("7");
		myBagPage = glovesProductPage.returnMyBagPage();
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
		homePageFR = (HomePageFR) homePage.chooseEULocation(euCountry.FR, euCountry.FR.getCurrencyISO());
		womenCategoryPage = homePageFR.returnWomenCategoryPage();
		womenAccessoriesPage = womenCategoryPage.returnWomenAccessoriesCategoryLeftNavPageFR();
		womenAccessoriesGlovesPage = womenAccessoriesPage.returnWomenAccessoriesGlovesCategoryleftNavPageFR();
		glovesProductPage = womenAccessoriesGlovesPage.returnGlovesProductPagePage();
		glovesProductPage.selectAttributeSize("7");
		myBagPage = glovesProductPage.returnMyBagPage();
		checkoutPage = myBagPage.returnCheckoutPage();
		checkoutProcessPage = checkoutPage.returnCheckoutProcessPage();
		checkoutProcessPage.setInfoAccountSecureCheckout(FIRST_NAME, LAST_NAME, ADDRESS, CITY, ZIP_CODE, MOBILE, CredentialsUtils.getProperty("email"), optionCountry.FRANCE);
		paymentMethodsCheckoutPage= checkoutProcessPage.returnPaymentMethodsCheckoutPage();
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
		homePageFR.quit();
		womenCategoryPage.quit();
		womenAccessoriesPage.quit();
		womenAccessoriesGlovesPage.quit();
		myBagPage.quit();
		myAccountPage.quit();
		glovesProductPage.quit();
		checkoutProcessPage.quit();
		checkoutPage.quit();
		checkoutProcessCompletePage.quit();
		paymentMethodsCheckoutPage.quit();
		KillChrome kill = new KillChrome();
		kill.killChrome();
	}
}
