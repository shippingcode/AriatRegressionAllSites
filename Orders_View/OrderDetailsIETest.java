package com.ariat.Tests.Orders_View;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.ariat.Enums.EUCountries;
import com.ariat.Enums.Environments;
import com.ariat.Pages.Header.SignInPage;
import com.ariat.Pages.HomePagesCountries.HomePage;
import com.ariat.Pages.HomePagesCountries.HomePageIE;
import com.ariat.Pages.HomePagesCountries.HomePageUK;
import com.ariat.Pages.Main.MyOrdersPage;
import com.ariat.Pages.Main.OrderDetailsPage;
import com.ariat.Tests.Base.BaseTest;
import com.ariat.Utils.CredentialsUtils;
import com.ariat.Utils.KillChrome;
import com.ariat.Utils.SetSelenium;

/**
 * Test Order details from different type of navigation and checks values from
 * order
 * 
 * @author aila.bogasieru@ariat.com
 *
 */

public class OrderDetailsIETest extends BaseTest {

	private Environments environment;
	private HomePage homePage;
	private HomePageUK homePageUK;
	private HomePageIE homePageIE;
	private SignInPage signInPage;
	private OrderDetailsPage orderDetailsPage;
	private com.ariat.Pages.Main.MyAccountPage myAccountPage;
	private MyOrdersPage myOrdersPage;
	private EUCountries euCountry;

	@BeforeTest
	public void setSeleniumUP() {
		SetSelenium setPath = new SetSelenium();
		setPath.setSelenium();
	}

	@Test(priority = 0)
	public void ordersChecksViewAllOrdersTest() {
		logger.info("Starting order details checks - View all orders test");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
		homePageIE = (HomePageIE) homePage.chooseEULocation(euCountry.IE, euCountry.IE.getCurrencyISO());
		signInPage = homePageIE.returnSignInPage();
		signInPage.setLoginDetails(CredentialsUtils.getProperty("email"), "EnglishUK", CredentialsUtils.getProperty("password"));
		myAccountPage = signInPage.returnMyAccountPage();
		myAccountPage.returnMyOrdersPageViewAllMiddleNav();
		orderDetailsPage = myAccountPage.returnOrderDetailsMyOrdersPageMiddleNav();
		orderDetailsPage.returnMyOrdersBackFromOrderDetailsPage();
		logger.info("Finishing order details checks - View all orders test...");
	}

	@Test(priority = 1)
	public void orderChecksMyAccountMiddleNavTest() {
		logger.info("Starting order details checks - My account view test");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
		homePageIE = (HomePageIE) homePage.chooseEULocation(euCountry.IE, euCountry.IE.getCurrencyISO());
		signInPage = homePageIE.returnSignInPage();
		signInPage.setLoginDetails(CredentialsUtils.getProperty("email"), "EnglishUK", CredentialsUtils.getProperty("password"));
		myAccountPage = signInPage.returnMyAccountPage();
		orderDetailsPage = myAccountPage.returnOrderDetailsMyAccountPageMiddleNav();
		orderDetailsPage.returnMyOrdersBackFromOrderDetailsPage();
		logger.info("Finishing order details checks - My account view test...");
	}

	@Test(priority = 2)
	public void orderChecksMyAccountTopNavTest() {
		logger.info("Starting orders check information orders test");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
		homePageIE = (HomePageIE) homePage.chooseEULocation(euCountry.IE, euCountry.IE.getCurrencyISO());
		signInPage = homePageIE.returnSignInPage();
		signInPage.setLoginDetails(CredentialsUtils.getProperty("email"), "EnglishUK", CredentialsUtils.getProperty("password"));
		myAccountPage = signInPage.returnMyAccountPage();
		myOrdersPage = myAccountPage.returnMyOrdersPageTopNav();
		logger.info("Finishing orders check information orders test.");
	}
	@AfterMethod
	public void tearDown() {
		homePage.quit();
		homePageUK.quit();
		homePageIE.quit();
		signInPage.quit();
		myAccountPage.quit();
		myOrdersPage.quit();
		KillChrome kill = new KillChrome();
		kill.killChrome();
	}
}
