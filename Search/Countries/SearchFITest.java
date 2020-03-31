package com.ariat.Tests.Search.Countries;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ariat.Enums.EUCountries;
import com.ariat.Enums.Environments;
import com.ariat.Pages.HomePagesCountries.HomePage;
import com.ariat.Pages.HomePagesCountries.HomePageFI;
import com.ariat.Pages.HomePagesCountries.HomePageUK;
import com.ariat.Tests.Base.BaseTest;
import com.ariat.Utils.KillChrome;
import com.ariat.Utils.SetSelenium;

/**
 * Search product Finland test
 * 
 * @author aila.bogasieru@ariat.com
 *
 */

public class SearchFITest extends BaseTest {

	private HomePage homePage;
	private HomePageUK homePageUK;
	private HomePageFI homePageFI;
	private EUCountries euCountry;
	private Environments environment;
	private final String OPTION = "boots";
	private final String MESSAGE = "Product results for: ";

	@BeforeTest
	public void setSeleniumUP() {
		SetSelenium setPath = new SetSelenium();
		setPath.setSelenium();
	}

	@Test
	public void searchAddressTest() {
		logger.info("Starting search products Finland test");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
		homePageFI = (HomePageFI) homePage.chooseEULocation(euCountry.FI, euCountry.FI.getCurrencyISO());
		homePageFI.search(OPTION);
	    homePageFI.assertProductDisplayed(MESSAGE+OPTION);
		homePageFI.seeAllproducts();
		logger.info("Finishing search products Finland test");
	}
	
	@AfterTest
	public void tearDown() {
		homePage.quit();
		homePageUK.quit();
		homePageFI.quit();
		KillChrome kill = new KillChrome();
		kill.killChrome();
	}
}