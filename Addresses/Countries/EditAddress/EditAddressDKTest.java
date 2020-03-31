package com.ariat.Tests.Addresses.Countries.EditAddress;


import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import com.ariat.Enums.EUCountries;
import com.ariat.Enums.Environments;
import com.ariat.Pages.HomePagesCountries.HomePage;
import com.ariat.Pages.HomePagesCountries.HomePageDK;
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
 * Edit address test Denmark
 * 
 * @author aila.bogasieru@ariat.com
 *
 */

public class EditAddressDKTest extends BaseTest {

	private HomePage homePage;
	private HomePageDK homePageDK;
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
	public void editAddressDKTest() {
		logger.info("Starting edit address Denmark test");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
		homePageDK = (HomePageDK) homePage.chooseEULocation(euCountry.DK, euCountry.DK.getCurrencyISO());
		signInPage = homePageDK.returnSignInPage();
		signInPage.setLoginDetails(CredentialsUtils.getProperty("email"), "EnglishUK", CredentialsUtils.getProperty("password"));
		myAccountPage = signInPage.returnMyAccountPage();
		addressesPage= myAccountPage.returnAddressesPageMiddleNav();
		addressesPage.editAddressCreated("B1TGL");
		addAddressPage = addressesPage.returnAddressesEdit();
		addAddressPage.clearAddressId();
		addAddressPage.setDetailsAddress(null, null, null, null, null, null, null, "B1TGL1");
		//addAddressPage.enterAddressId("B1TGL1");
		addressesPage = addAddressPage.returnAddressesSaveFromEditPage();
		addressesPage.checkAddress("B1TGL1");
		logger.info("Finishing edit address Denmark test");
	}
	
	@AfterTest
	public void tearDown() {
		homePage.quit();
		homePageDK.quit();
		homePageUK.quit();
		signInPage.quit();
		myAccountPage.quit();
		addAddressPage.quit();
		addressesPage.quit();
		KillChrome kill = new KillChrome();
		kill.killChrome();

	}
}