package com.ariat.Tests.MyAccount.Countries.TopRightNav;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ariat.Enums.EUCountries;
import com.ariat.Enums.Environments;
import com.ariat.Pages.HomePagesCountries.HomePage;
import com.ariat.Pages.HomePagesCountries.HomePageUK;
import com.ariat.Pages.HomePagesCountries.HomePageUS;
import com.ariat.Pages.Main.MyAccountPage;
import com.ariat.Tests.Base.BaseTest;
import com.ariat.Utils.CredentialsUtils;
import com.ariat.Utils.KillChrome;
import com.ariat.Utils.SetSelenium;
import com.ariat.Pages.Header.SignInPage;

/**
 * Include tests for My account left navigation United States
 * 
 * @author aila.bogasieru@ariat.com
 *
 */

public class MyAccountTopRightNavigationUSTest extends BaseTest {

	private Environments environment;
	private EUCountries euCountry;
	private HomePage homePage;
	private HomePageUS homePageUS;
	private HomePageUK homePageUK;
	private SignInPage signInPage;
	private MyAccountPage myAccountPage;

	@BeforeTest
	public void setSeleniumUP() {
		SetSelenium setPath = new SetSelenium();
		setPath.setSelenium();
	}
	
	@Test(priority = 0)
	public void myAccountAccessPersonalInfoUSTest() {
		logger.info("Starting personal info US test...");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
		homePageUS = (HomePageUS) homePage.chooseEULocation(euCountry.USA, euCountry.USA.getCurrencyISO());
		signInPage = homePageUS.returnSignInPage();
		signInPage.setLoginDetails(CredentialsUtils.getProperty("email"), "EnglishUS", CredentialsUtils.getProperty("password"));
		myAccountPage = signInPage.returnMyAccountPage();
		myAccountPage.returnPersonalInformationPageTopNav();
		myAccountPage.myAccountClick();
		myAccountPage.returnLogoutFromMyAccountPageTopNav();
		logger.info("Finishing personal info US test...");
	}

	@Test(priority = 1)
	public void myAccountAccessOrdersUSTest() {
		logger.info("Starting orders US test...");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
		homePageUS = (HomePageUS) homePage.chooseEULocation(euCountry.USA, euCountry.USA.getCurrencyISO());
		signInPage = homePageUS.returnSignInPage();
		signInPage.setLoginDetails(CredentialsUtils.getProperty("email"), "EnglishUS", CredentialsUtils.getProperty("password"));
		myAccountPage = signInPage.returnMyAccountPage();
		myAccountPage.returnMyOrdersPageTopNav();
		myAccountPage.myAccountClick();
		myAccountPage.returnLogoutFromMyAccountPageTopNav();
		logger.info("Finishing orders US test...");
	}

	@Test(priority = 2)
	public void myAccountAccessWishListUSTest() {
		logger.info("Starting wish list US test...");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
		homePageUS = (HomePageUS) homePage.chooseEULocation(euCountry.USA, euCountry.USA.getCurrencyISO());
		signInPage = homePageUS.returnSignInPage();
		signInPage.setLoginDetails(CredentialsUtils.getProperty("email"), "EnglishUS", CredentialsUtils.getProperty("password"));
		myAccountPage = signInPage.returnMyAccountPage();
		myAccountPage.returnWishListPageTopNav();
		myAccountPage.myAccountClick();
		myAccountPage.returnLogoutFromMyAccountPageTopNav();
		logger.info("Finishing wish list US test...");
	}

	@AfterTest
	public void tearDown() {
		homePage.quit();
		homePageUK.quit();
		homePageUS.quit();
		signInPage.quit();
		myAccountPage.quit();
		KillChrome kill = new KillChrome();
		kill.killChrome();
	}
}
