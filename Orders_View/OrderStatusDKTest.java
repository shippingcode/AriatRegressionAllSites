package com.ariat.Tests.Orders_View;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.ariat.Enums.EUCountries;
import com.ariat.Enums.Environments;
import com.ariat.Pages.Header.SignInPage;
import com.ariat.Pages.HomePagesCountries.HomePage;
import com.ariat.Pages.HomePagesCountries.HomePageDK;
import com.ariat.Pages.HomePagesCountries.HomePageUK;
import com.ariat.Pages.Main.MyOrdersPage;
import com.ariat.Tests.Base.BaseTest;
import com.ariat.Utils.CredentialsUtils;
import com.ariat.Utils.KillChrome;
import com.ariat.Utils.SetSelenium;

/**
 * Test order status from different type of navigation
 * 
 * @author aila.bogasieru@ariat.com
 *
 */

public class OrderStatusDKTest extends BaseTest {

	private Environments environment;
	private EUCountries euCountry;
	private HomePage homePage;
	private HomePageUK homePageUK;
	private HomePageDK homePageDK;
	private SignInPage signInPage;
	private com.ariat.Pages.Main.MyAccountPage myAccountPage;
	private MyOrdersPage myOrdersPage;

	@BeforeTest
	public void setSeleniumUP() {
		SetSelenium setPath = new SetSelenium();
		setPath.setSelenium();
	}

	@Test
	public void orderStatusTest() {
		logger.info("Starting  order status test");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
		homePageDK = (HomePageDK) homePage.chooseEULocation(euCountry.DK, euCountry.DK.getCurrencyISO());
		signInPage = homePageDK.returnSignInPage();
		signInPage.setLoginDetails(CredentialsUtils.getProperty("email"), "EnglishUK", CredentialsUtils.getProperty("password"));
		myAccountPage = signInPage.returnMyAccountPage();
		myOrdersPage = myAccountPage.returnMyOrdersPageOrderStatusMiddleNav();
		logger.info("Finishing order status test...");
	}

	@AfterMethod
	public void tearDown() {
		homePage.quit();
		homePageUK.quit();
		homePageDK.quit();
		signInPage.quit();
		myAccountPage.quit();
		myOrdersPage.quit();
		KillChrome kill = new KillChrome();
		kill.killChrome();
	}
}
