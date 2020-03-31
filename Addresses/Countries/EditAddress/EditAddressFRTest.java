package com.ariat.Tests.Addresses.Countries.EditAddress;

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
 * Edit address test France
 * 
 * @author aila.bogasieru@ariat.com
 *
 */

public class EditAddressFRTest extends BaseTest {

	private HomePage homePage;
	private HomePageFR homePageFR;
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

	@Test
	public void editAddressFRTest() {
		logger.info("Starting edit address France test");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
		homePageFR = (HomePageFR) homePage.chooseEULocation(euCountry.FR, euCountry.FR.getCurrencyISO());
		signInPage = homePageFR.returnSignInPage();
		signInPage.setLoginDetails(CredentialsUtils.getProperty("email"), "Francais", CredentialsUtils.getProperty("password"));
		myAccountPage = signInPage.returnMyAccountPage();
		addressesPage= myAccountPage.returnAddressesPageMiddleNav();
		addressesPage.editAddressCreatedFR("B1TGL");
		addAddressPage = addressesPage.returnAddressesEdit();
		addAddressPage.clearAddressId();
		//addAddressPage.enterAddressId("B1TGL1");
		addAddressPage.setDetailsAddress(null, null, null, null, null, null, null, "B1TGL1");
		addressesPage = addAddressPage.returnAddressesSaveFromEditPageFR();
		addressesPage.checkAddressFR("B1TGL1");
		logger.info("Finishing edit address France test");
	}
	
	@AfterTest
	public void tearDown() {
		homePage.quit();
		homePageFR.quit();
		homePageUK.quit();
		signInPage.quit();
		myAccountPage.quit();
		addAddressPage.quit();
		addressesPage.quit();
		KillChrome kill = new KillChrome();
		kill.killChrome();
	}
}