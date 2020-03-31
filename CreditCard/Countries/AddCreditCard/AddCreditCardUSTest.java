package com.ariat.Tests.CreditCard.Countries.AddCreditCard;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ariat.Enums.EUCountries;
import com.ariat.Enums.Environments;
import com.ariat.Enums.ListOfCreditCards;
import com.ariat.Pages.HomePagesCountries.HomePage;
import com.ariat.Pages.HomePagesCountries.HomePageUK;
import com.ariat.Pages.HomePagesCountries.HomePageUS;
import com.ariat.Pages.Main.AddACreditCardPage;
import com.ariat.Pages.Main.LogoutPage;
import com.ariat.Pages.Main.MyAccountPage;
import com.ariat.Pages.Main.PaymentInformationPage;
import com.ariat.Tests.Base.BaseTest;
import com.ariat.Utils.CredentialsUtils;
import com.ariat.Utils.KillChrome;
import com.ariat.Utils.SetSelenium;
import com.ariat.Pages.Header.SignInPage;


/**
 * Tests for Add Credit card United States
 * @author aila.bogasieru@ariat.com
 *
 */


public class AddCreditCardUSTest extends BaseTest{
	
	private HomePage homePage;
	private HomePageUS homePageUS;
	private HomePageUK homePageUK;
	private SignInPage signInPage;
	private MyAccountPage myAccountPage;
	private AddACreditCardPage addACreditCardPage;
	private LogoutPage logoutPage;
	private PaymentInformationPage paymentInfoPage;
	private Environments environment;
	private EUCountries euCountry;
	private ListOfCreditCards typeCard;
	

	private static final String CARD_ID = "XX";
	private static final String CARD_OWNER = "Aila B";
	private static final String YEAR = "2023";
	private static final String MONTH = "January";
	
	@BeforeTest
	public void setSeleniumUP() {
		SetSelenium setPath = new SetSelenium();
		setPath.setSelenium();
	}


	@Test(priority = 0)
	public void addCreditCardUSTest() {
		String expirationDate = "MONTH/YEAR";
		logger.info("Starting add a credit card US test");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
		homePageUS = (HomePageUS) homePage.chooseEULocation(euCountry.USA, euCountry.USA.getCurrencyISO());
		signInPage = homePageUS.returnSignInPage();
		signInPage.setLoginDetails(CredentialsUtils.getProperty("email_US"), "EnglishUK", CredentialsUtils.getProperty("password"));
		myAccountPage = signInPage.returnMyAccountPage();
		addACreditCardPage = myAccountPage.returnAddACreditCardMiddleNav();
		addACreditCardPage.setDetailsCreditCardUS(CARD_ID, CARD_OWNER, typeCard.VISA.getNumber(), typeCard.VISA.getCvs(), MONTH, YEAR);
		paymentInfoPage = addACreditCardPage.returnPaymentInformationPage();
		paymentInfoPage.checkCreditCard(CARD_OWNER, typeCard.VISA.getName(), expirationDate);
		logoutPage = myAccountPage.returnLogoutFromMyAccountPageTopNav();
		logoutPage.logout();
		logger.info("Finishing add a credit card US test");
  } 
	
	@Test(priority = 1)
	public void addCreditCardFromPaymentInfoUSTest() {
		logger.info("Starting add credit card from Payment Info US test");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
		homePageUS = (HomePageUS) homePage.chooseEULocation(euCountry.USA, euCountry.USA.getCurrencyISO());
		signInPage = homePageUS.returnSignInPage();
		signInPage.setLoginDetails(CredentialsUtils.getProperty("email_US"), "EnglishUK", CredentialsUtils.getProperty("password"));
		myAccountPage = signInPage.returnMyAccountPage();
		paymentInfoPage = myAccountPage.returnPaymentInformationPageLeftNav();
		addACreditCardPage = paymentInfoPage.returnAddACreditCardPage();
		addACreditCardPage.setDetailsCreditCardUS(CARD_ID, CARD_OWNER, typeCard.MASTER_CARD.getNumber(), typeCard.MASTER_CARD.getCvs(), MONTH, YEAR);
		addACreditCardPage.applyCardCreation();
		logoutPage = myAccountPage.returnLogoutFromMyAccountPageTopNav();
		logoutPage.logout();
		logger.info("Finishing add credit card from Payment info US test");
		
  }
	@AfterTest
	public void tearDown() {
		homePage.quit();
		homePageUS.quit();
		homePageUK.quit();
		signInPage.quit();
		myAccountPage.quit();
		paymentInfoPage.quit();
		addACreditCardPage.quit();
		logoutPage.quit();
		KillChrome kill = new KillChrome();
		kill.killChrome();
	}
}