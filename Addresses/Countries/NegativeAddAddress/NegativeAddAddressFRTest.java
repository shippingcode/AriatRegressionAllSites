package com.ariat.Tests.Addresses.Countries.NegativeAddAddress;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.ariat.Enums.EUCountries;
import com.ariat.Enums.Environments;
import com.ariat.Pages.HomePagesCountries.HomePage;
import com.ariat.Pages.HomePagesCountries.HomePageFR;
import com.ariat.Pages.HomePagesCountries.HomePageUK;
import com.ariat.Pages.Main.AddAddressesPage;
import com.ariat.Pages.Main.AddressesPage;
import com.ariat.Pages.Main.MyAccountPage;
import com.ariat.Tests.Base.BaseTest;
import com.ariat.Pages.Header.SignInPage;
import com.ariat.Utils.CredentialsUtils;
import com.ariat.Utils.GenerateRandomDataUtils;
import com.ariat.Utils.KillChrome;
import com.ariat.Utils.SetSelenium;


/**
 * Adds negative address and checks the address was created for Belgium
 * 
 * @author aila.bogasieru@ariat.com
 *
 */

public class NegativeAddAddressFRTest extends BaseTest {

	private HomePage homePage;
	private HomePageUK homePageUK;
	private HomePageFR homePageFR;
	private SignInPage signInPage;
	private MyAccountPage myAccountPage;
	private AddAddressesPage addAddressPage;
	private AddressesPage addressesPage;
	private EUCountries euCountry;
	private Environments environment;

	public static final String ADDRESS = GenerateRandomDataUtils.generateRandomNumber(5);
	public static final String CITY = GenerateRandomDataUtils.generateRandomNumber(5);
	
	public static final String POST_CODE = GenerateRandomDataUtils.generateRandomString(5);
	public static final String PHONE = GenerateRandomDataUtils.generateRandomString(7);
	public static final String ADDRESS_ID = GenerateRandomDataUtils.generateRandomNumber(5);
	
	public static final String ADDRESSWILD = GenerateRandomDataUtils.generateRandomNumber(5);
	public static final String CITYWILD = GenerateRandomDataUtils.generateRandomNumber(5);
	
	public static final String POST_CODEWILD = GenerateRandomDataUtils.generateRandomString(5);
	public static final String PHONEWILD = GenerateRandomDataUtils.generateRandomString(7);
	public static final String ADDRESS_IDWILD = GenerateRandomDataUtils.generateRandomNumber(5);
	
	
	@BeforeTest
	public void setSeleniumUP() {
		SetSelenium setPath = new SetSelenium();
		setPath.setSelenium();
	}

	@Test(priority=0)
	public void negativeAddAddressNOTest() {
		logger.info("Starting add negative address NO test");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
		homePageFR = (HomePageFR) homePage.chooseEULocation(euCountry.FR, euCountry.FR.getCurrencyISO());
		signInPage = homePageFR.returnSignInPage();
		signInPage.setLoginDetails(CredentialsUtils.getProperty("email"), "Francais", CredentialsUtils.getProperty("password"));
		myAccountPage = signInPage.returnMyAccountPage();
		addAddressPage = myAccountPage.returnAddAddressesPageMiddleNav();
		addAddressPage.setDetailsAddress("444", "4444", ADDRESS, CITY, "Paris", POST_CODE, PHONE, ADDRESS_ID);
		addressesPage = addAddressPage.returnAddressesPage();
		logger.info("Finishing add negative address NO test");
	}
	
	@Test(priority=1)
	public void negativeAddAddressNOTestWildcards() {
		logger.info("Starting add negative address NO test");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
		homePageFR = (HomePageFR) homePage.chooseEULocation(euCountry.FR, euCountry.FR.getCurrencyISO());
		signInPage = homePageFR.returnSignInPage();
		signInPage.setLoginDetails(CredentialsUtils.getProperty("email"), "Francais", CredentialsUtils.getProperty("password"));
		myAccountPage = signInPage.returnMyAccountPage();
		addAddressPage = myAccountPage.returnAddAddressesPageMiddleNav();
		addAddressPage.setDetailsAddress("444", "4444", ADDRESSWILD, CITYWILD, "Paris", POST_CODEWILD, PHONEWILD, ADDRESS_IDWILD);
		addressesPage = addAddressPage.returnAddressesPage();
		logger.info("Finishing add negative address NO test");
	}
	
	@Test(priority=2)
	public void negativeAddAddressNOTestMissingValues() {
		logger.info("Starting add negative address NO test");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
		homePageFR = (HomePageFR) homePage.chooseEULocation(euCountry.FR, euCountry.FR.getCurrencyISO());
		signInPage = homePageFR.returnSignInPage();
		signInPage.setLoginDetails(CredentialsUtils.getProperty("email"), "Francais", CredentialsUtils.getProperty("password"));
		myAccountPage = signInPage.returnMyAccountPage();
		addAddressPage = myAccountPage.returnAddAddressesPageMiddleNav();
		addAddressPage.setDetailsAddress("444", "4444", ADDRESSWILD, CITYWILD, "Paris", null, null, null);
		addAddressPage.saveAddress();
		logger.info("Finishing add negative address NO test");
	}
	
	@AfterTest
	public void tearDown() {
		homePage.quit();
		homePageUK.quit();
		homePageFR.quit();
		signInPage.quit();
		addAddressPage.quit();
		addressesPage.quit();
		KillChrome kill = new KillChrome();
		kill.killChrome();
	}
}