package com.ariat.Tests.FooterTests;

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
import com.ariat.Pages.Main.ProductRegistrationPage;
import com.ariat.Tests.Base.BaseTest;
import com.ariat.Utils.CredentialsUtils;
import com.ariat.Utils.SetSelenium;


/**
 * Product registration Unite States
 * 
 * @author aila.bogasieru@ariat.com
 *
 */


public class ProductRegistrationUSFooterTest extends BaseTest{
	 
	private HomePage homePage;
	private HomePageUK homePageUK;
	private HomePageUS homePageUS;
	private Environments environment;
	private ProductRegistrationPage productRegistrationPage;
	private MyAccountPage myAccountPage;
	private EUCountries euCountry;
	
	
	@BeforeTest
	public void setSeleniumUP() {
		SetSelenium setPath = new SetSelenium();
		setPath.setSelenium();
	}

	@Test(priority = 0)
	public void productRegistrationTest() {
		logger.info("Starting product registration test...");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
		homePageUS = (HomePageUS) homePage.chooseEULocation(euCountry.USA, euCountry.USA.getCurrencyISO());
		productRegistrationPage = homePageUS.returnProductRegistrationPage();
		productRegistrationPage.continue1();
		productRegistrationPage.enterEmail(CredentialsUtils.getProperty("email_US"));
		productRegistrationPage.continue2();
		productRegistrationPage.generateCode();
		productRegistrationPage.continue3();
		productRegistrationPage.selectCat("Women's", "Footwear", "Casual");
		productRegistrationPage.continue4();
		productRegistrationPage.collectInfoCustomer("A", "B", "Str", "Florida", "Florida", "345", "3643544");
		productRegistrationPage.continue5();
		productRegistrationPage.saveInfo();
		myAccountPage = productRegistrationPage.returnMyAccountPage();
	    logger.info("Product registration test");
	}
	
	@AfterTest
	public void tearDown() {
		homePage.quit();
		homePageUK.quit();
		homePageUS.quit();
		productRegistrationPage.quit();
		myAccountPage.quit();
	}
}
