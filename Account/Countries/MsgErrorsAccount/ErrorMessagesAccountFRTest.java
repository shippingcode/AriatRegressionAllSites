package com.ariat.Tests.Account.Countries.MsgErrorsAccount;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ariat.Enums.EUCountries;
import com.ariat.Enums.Environments;
import com.ariat.Pages.HomePagesCountries.HomePage;
import com.ariat.Pages.HomePagesCountries.HomePageFR;
import com.ariat.Pages.HomePagesCountries.HomePageUK;
import com.ariat.Pages.Main.CreateAccountPage;
import com.ariat.Pages.Main.MyAccountPage;
import com.ariat.Tests.Base.BaseTest;
import com.ariat.Pages.Header.SignInPage;
import com.ariat.Utils.CredentialsUtils;
import com.ariat.Utils.GenerateRandomDataUtils;
import com.ariat.Utils.KillChrome;
import com.ariat.Utils.SetSelenium;


/**
 * Negative tests for France account
 * 
 * @author aila.bogasieru@ariat.com
 *
 */

public class ErrorMessagesAccountFRTest extends BaseTest {

	private Environments environment;
	private EUCountries euCountry;
	private CreateAccountPage createAccountPage;
	private HomePage homePage;
	private HomePageFR homePageFR;
	private HomePageUK homePageUK;
	private SignInPage signInPage;
	private MyAccountPage myAccountPage;

	public static final String FIRST_NAME = GenerateRandomDataUtils.generateRandomNumber(7);
	public static final String LAST_NAME = GenerateRandomDataUtils.generateRandomNumber(7);
	public static final String BIRTH_MONTH = "Mars";
	public static final String BIRTH_DAY = "02";

	public static final String EMAIL = GenerateRandomDataUtils.generateRandomAlphaNumeric(7);
	
	public static final String PASSWORD = GenerateRandomDataUtils.generateRandomNumber(3);

	public static final String ORDER_NO = GenerateRandomDataUtils.generateRandomAlphaNumeric(4);
	public static final String BILLING_ZIP_CODE = GenerateRandomDataUtils.generateRandomString(3);

	public static final String ERROR_MESSAGE = "D�sol�, ce num�ro de commande ou code postal ne correspond pas � celui que nous avons dans nos dossiers. V�rifiez-le puis r�essayez.";
	public static final String INVALID_EMAIL_MSG = "L'adresse courriel n'est pas valide.";
	public static final String INVALID_PASS_MSG = "(8 - 255 characters)";
	public static final String MISMATCH_PASS_MSG = "D�sol�, ceci ne correspond pas aux infos que nous avons dans nos dossiers. V�rifiez l'orthographe puis r�essayez.";

	@BeforeTest
	public void setSeleniumUP() {
		SetSelenium setPath = new SetSelenium();
		setPath.setSelenium();
	}

/*	@Test(priority = 0)
	public void errorsAccountTest() {
		logger.info("Starting error message in creating new account test");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
		homePageFR = (HomePageFR) homePage.chooseEULocation(euCountry.FR, euCountry.FR.getCurrencyISO());
		signInPage = homePageFR.returnSignInPage();
		createAccountPage = signInPage.returnCreateAccountPage();
		createAccountPage.firstName(FIRST_NAME);
		createAccountPage.lastName(LAST_NAME);
		createAccountPage.selectBirthMonth(BIRTH_MONTH);
		createAccountPage.selectBirthDay(BIRTH_DAY);
		//createAccountPage.GenderFemale();
		createAccountPage.enterEmail(EMAIL);
		createAccountPage.assertWrongEmailCreateAccount(INVALID_EMAIL_MSG);
		createAccountPage.clearEmail();
		createAccountPage.enterEmail("aila.bogasieru@ariat.com");
		createAccountPage.confirmEmail(EMAIL);
		createAccountPage.assertWrongConfirmEmailCreateAccount(INVALID_EMAIL_MSG);
		createAccountPage.clearEmail();
		createAccountPage.enterEmail("aila.bogasieru@ariat.com");
		createAccountPage.enterPassword(PASSWORD);
		createAccountPage.confirmPassword(PASSWORD);
		createAccountPage.createAccountClick();
		createAccountPage.assertWrongPassCreateAccount(INVALID_PASS_MSG, INVALID_PASS_MSG);
		logger.info("Finishing error messages in creating new account test...");
	}*/

	@Test(priority = 1)
	public void returningCustomerWrongPasswordTest() {
		logger.info("Starting returning customer wrong password test...");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
		homePageFR = (HomePageFR) homePage.chooseEULocation(euCountry.FR, euCountry.FR.getCurrencyISO());
		signInPage = homePageFR.returnSignInPage();
		signInPage.setLoginDetails(CredentialsUtils.getProperty("email_US"), "Francais", CredentialsUtils.getProperty("wrong_password"));
		signInPage.loginClick();
		signInPage.assertWrongPasswordMessage(MISMATCH_PASS_MSG);
		logger.info("Finishing returning customer wrong password test...");
	}
	
	@Test(priority = 2)
	public void returningCustomerWrongEmailTest() {
		logger.info("Starting returning customer wrong email test...");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
		homePageFR = (HomePageFR) homePage.chooseEULocation(euCountry.FR, euCountry.FR.getCurrencyISO());
		signInPage = homePageFR.returnSignInPage();
		signInPage.setLoginDetails(CredentialsUtils.getProperty("wrong_email"), "Francais", CredentialsUtils.getProperty("ok_password"));
		signInPage.loginClick();
		signInPage.assertWrongEmailMessage(MISMATCH_PASS_MSG);
		logger.info("Finishing returning customer wrong email test...");
	}

	@Test(priority = 3)
	public void checkInvalidOrderTest() {
		logger.info("Starting checking invalid order test...");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
		homePageFR = (HomePageFR) homePage.chooseEULocation(euCountry.FR, euCountry.FR.getCurrencyISO());
		signInPage = homePageFR.returnSignInPage();
		signInPage.checkOrder(ORDER_NO, CredentialsUtils.getProperty("email_US"), BILLING_ZIP_CODE);
		signInPage.checkStatusClick();
		signInPage.assertErrorMessageInexistingOrderNo(ERROR_MESSAGE);
		logger.info("Finishing checking invalid order test...");
	}

	@AfterTest
	public void tearDown() {
		homePage.quit();
		homePageUK.quit();
		homePageFR.quit();
		signInPage.quit();
		createAccountPage.quit();
		KillChrome kill = new KillChrome();
		kill.killChrome();
	}
}
