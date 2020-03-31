package com.ariat.Tests.Addresses.Countries.DeleteAddress;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ariat.Enums.EUCountries;
import com.ariat.Enums.Environments;
import com.ariat.Pages.HomePagesCountries.HomePage;
import com.ariat.Pages.HomePagesCountries.HomePageBE;
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
 * Delete address test Belgium
 * 
 * @author aila.bogasieru@ariat.com
 *
 */


public class DeleteAddressBETest extends BaseTest {

	private HomePage homePage;
	private HomePageBE homePageBE;
	private HomePageUK homePageUK;
	private SignInPage signInPage;
	private MyAccountPage myAccountPage;
	private AddAddressesPage addAddressPage;
	private AddressesPage addressesPage;
	private Environments environment;
	private EUCountries euCountry;

	public static final String ADDRESS = GenerateRandomDataUtils.generateRandomString(5);
	public static final String CITY = GenerateRandomDataUtils.generateRandomString(5);
	public static final String POST_CODE = GenerateRandomDataUtils.generateRandomNumber(5);
	public static final String PHONE = GenerateRandomDataUtils.generateRandomNumber(7);
	public static final String ADDRESS_ID = GenerateRandomDataUtils.generateRandomAlphaNumeric(5);

	@BeforeTest
	public void setSeleniumUP() {
		SetSelenium setPath = new SetSelenium();
		setPath.setSelenium();
	}

	@Test(priority=0)
	public void addAddressBETest() {
		logger.info("Starting add address Sweden test");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
		homePageBE = (HomePageBE) homePage.chooseEULocation(euCountry.BE, euCountry.BE.getCurrencyISO());
		signInPage = homePageBE.returnSignInPage();
		signInPage.setLoginDetails(CredentialsUtils.getProperty("email"), "EnglishUK", CredentialsUtils.getProperty("password"));
		myAccountPage = signInPage.returnMyAccountPage();
		addAddressPage = myAccountPage.returnAddAddressesPageMiddleNav();
		addAddressPage.setDetailsAddress("A", "B", "Basarabia Blvd, No 62", CITY, "Belgium", POST_CODE, PHONE, ADDRESS_ID);
		addressesPage = addAddressPage.returnAddressesPageWithoutScroll();
		addressesPage.checkAddress(ADDRESS_ID);
		logger.info("Finishing add address Sweden test");
	}

	@Test(priority = 0)
	public void deleteAddressTestBE() {
		logger.info("Starting deleting address Belgium test");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
		homePageBE = (HomePageBE) homePage.chooseEULocation(euCountry.BE, euCountry.BE.getCurrencyISO());
		signInPage = homePageBE.returnSignInPage();
		signInPage.setLoginDetails(CredentialsUtils.getProperty("email"), "EnglishUK", CredentialsUtils.getProperty("password"));
		myAccountPage = signInPage.returnMyAccountPage();
		addressesPage = myAccountPage.returnAddressesPageMiddleNav();
		addressesPage.deleteAddressCreatedNo(ADDRESS_ID);
		addressesPage.deleteAddressCreatedYes(ADDRESS_ID);
		addressesPage.checkAddress(ADDRESS_ID);
		logger.info("Finishing deleting address Belgium test");
	}

	@AfterTest
	public void tearDown() {
		homePage.quit();
		homePageBE.quit();
		homePageUK.quit();
		signInPage.quit();
		myAccountPage.quit();
		addressesPage.quit();
		addAddressPage.quit();
		KillChrome kill = new KillChrome();
		kill.killChrome();
	}
}