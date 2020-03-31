package com.ariat.Tests.FooterTests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.ariat.Pages.Footer.ContactUsPage;
import com.ariat.Pages.HomePagesCountries.HomePage;
import com.ariat.Pages.HomePagesCountries.HomePageUK;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import com.ariat.Enums.EUCountries;
import com.ariat.Enums.Environments;
import com.ariat.Tests.Base.BaseTest;
import com.ariat.Utils.CredentialsUtils;
import com.ariat.Utils.SetSelenium;

/**
 * Test Contact Us page
 * 
 * @author aila.bogasieru@ariat.com
 *
 */

public class ContactUsFooterUKTest extends BaseTest {

	private Environments environment;
	private EUCountries euCountry;
	private HomePage homePage;
	private HomePageUK homePageUK;
	private ContactUsPage contactUsPage;
	
	public static final String FIRST_NAME = "Aila";
	public static final String LAST_NAME = "Bogasieru";
	public static final String PHONE = "0723456789";
	public static final String ORDER_NO = "10003202";
				
	@BeforeTest
	public void setSeleniumUP() {
		SetSelenium setPath = new SetSelenium();
		setPath.setSelenium();
	}

	@Test(priority = 0)
	public void contactUsFooterTest() {
		logger.info("Starting checking Contact Us page test...");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
		contactUsPage = homePageUK.returnContactUsPage();
		contactUsPage.enterFName(FIRST_NAME);
		contactUsPage.enterLName(LAST_NAME);
		contactUsPage.enterEmail(CredentialsUtils.getProperty("email"));
		contactUsPage.enterPhone(PHONE);
		contactUsPage.enterOrderNo(ORDER_NO);
		contactUsPage.selectQuestion("Sponsorship");
		contactUsPage.enterComment("this is my comment");
		contactUsPage.checkNotRobot();
		contactUsPage.submit();
		logger.info("Finishing checking Contact Us page test...");
	}
	
	@AfterTest
	public void tearDown() {
		homePage.quit();
		homePageUK.quit();
		contactUsPage.quit();
  }
}

