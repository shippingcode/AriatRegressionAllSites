package com.ariat.Tests.Categories.Countries.Navigation.MenCategory.LeftNav;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ariat.Enums.EUCountries;
import com.ariat.Enums.Environments;
import com.ariat.Pages.HomePagesCountries.HomePage;
import com.ariat.Pages.HomePagesCountries.HomePageDE;
import com.ariat.Pages.HomePagesCountries.HomePageUK;
import com.ariat.Tests.Base.BaseTest;
import com.ariat.Utils.KillChrome;
import com.ariat.Utils.SetSelenium;
import com.ariat.Pages.Categories.MenCategories.MenCategoryPage;
import com.ariat.Pages.Categories.MenCategories.MenFashionSneakersPage;
import com.ariat.Pages.Categories.MenCategories.MenFootwearPage;
import com.ariat.Pages.Categories.MenCategories.MenRidingPage;
import com.ariat.Pages.Categories.MenCategories.MenFootwearCountry.MenFootwearCountrySubcategories.MenFootwearCountryOutdoorPage;
import com.ariat.Pages.Categories.MenCategories.MenFootwearCountry.MenFootwearCountrySubcategories.MenFootwearCountryRubberPage;
import com.ariat.Pages.Categories.MenCategories.MenFootwearCountry.MenFootwearCountrySubcategories.MenFootwearCountryToolBootsPage;
import com.ariat.Pages.Categories.MenCategories.MenFootwearCountry.MenFootwearCountrySubcategories.MenFootwearCountryWalkingPage;
import com.ariat.Pages.Categories.MenCategories.MenFootwearRiding.MenFootwearRidingCategories.MenFootwearAllWeatherRidingPage;
import com.ariat.Pages.Categories.MenCategories.MenFootwearRiding.MenFootwearRidingCategories.MenFootwearRidingBarnyardPage;
import com.ariat.Pages.Categories.MenCategories.MenFootwearRiding.MenFootwearRidingCategories.MenFootwearRidingEndurancePage;
import com.ariat.Pages.Categories.MenCategories.MenFootwearRiding.MenFootwearRidingCategories.MenFootwearRidingHalfChapsPage;
import com.ariat.Pages.Categories.MenCategories.MenFootwearRiding.MenFootwearRidingCategories.MenFootwearRidingPaddockPage;
import com.ariat.Pages.Categories.MenCategories.MenFootwearRiding.MenFootwearRidingCategories.MenFootwearRidingToolBootsPage;
import com.ariat.Pages.Categories.MenCategories.MenFootwearSubcategories.MenFootwearCasualShoesPage;
import com.ariat.Pages.Categories.MenCategories.MenFootwearSubcategories.MenFootwearCountryPage;
import com.ariat.Pages.Categories.MenCategories.MenFootwearSubcategories.MenFootwearWesternPage;
import com.ariat.Pages.Categories.MenCategories.MenFootwearSubcategories.MenFootwearWorkPage;
import com.ariat.Pages.Categories.MenCategories.MenFootwearSubcategories.MenFootwearWesternCategories.MenFootwearWesternFashionPage;
import com.ariat.Pages.Categories.MenCategories.MenFootwearSubcategories.MenFootwearWesternCategories.MenFootwearWesternPerformancePage;
import com.ariat.Pages.Categories.MenCategories.MenSubcategories.MenFootwearWorkCategories.MenFootwearWorkLaceUpPage;
import com.ariat.Pages.Categories.MenCategories.MenSubcategories.MenFootwearWorkCategories.MenFootwearWorkPullOnPage;


/**
 * Left navigation for Men category Deutschland test
 * 
 * @author aila.bogasieru@ariat.com
 *
 */

public class MenFootwearSubcategoriesLeftNavDETest extends BaseTest {

	private Environments environment;
	private EUCountries euCountry;
	private HomePageUK homePageUK;
	private HomePageDE homePageDE;
	private HomePage homePage;
	private MenCategoryPage menCategoryPage;
	private MenFootwearPage menFootwearPage;
	private MenRidingPage menRidingPage;
	private MenFootwearRidingToolBootsPage menFootwearRidingToolBootsPage;
	private MenFootwearRidingPaddockPage menFootwearRidingPaddockPage;
	private MenFootwearRidingHalfChapsPage menFootwearRidingHalfChapsPage;
	private MenFootwearAllWeatherRidingPage menFootwearAllWeatherRidingPage;
	private MenFootwearRidingEndurancePage menFootwearRidingEndurancePage;
	private MenFootwearRidingBarnyardPage menFootwearRidingBarnyardPage;

	private MenFootwearCountryPage menFootwearCountryPage;
	private MenFootwearCountryOutdoorPage menFootwearCountryOutdoorPage;
	private MenFootwearCountryRubberPage menFootwearCountryRubberPage;
	private MenFootwearCountryToolBootsPage menFootwearCountryToolBootsPage;
	private MenFootwearCountryWalkingPage menFootwearCountryWalkingPage;

	private MenFootwearWesternPage menFootwearWesternPage;
	private MenFootwearWesternPerformancePage menFootwearWesternPerformancePage;
	private MenFootwearWesternFashionPage menFootwearWesternFashionPage;

	private MenFootwearWorkPage menFootwearWorkPage;
	private MenFootwearWorkLaceUpPage menFootwearWorkLaceUpPage;
	private MenFootwearWorkPullOnPage menFootwearWorkPullOnPage;

	private MenFootwearCasualShoesPage menFootwearCasualShoesPage;
	private MenFashionSneakersPage menFootwearSneakersPage;
	
	@BeforeTest
	public void setSeleniumUP() {
		SetSelenium setPath = new SetSelenium();
		setPath.setSelenium();
	}

    
	@Test(priority = 0)
	public void leftNavigationMenFootwearRidingSubcategories() {
		logger.info("Starting left navigation Men Footwear Riding sub-categories test...");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
		homePageDE = (HomePageDE) homePage.chooseEULocation(euCountry.DE, euCountry.DE.getCurrencyISO());
		menCategoryPage = homePageDE.returnMenCategoryPage();
		menFootwearPage = menCategoryPage.returnMenFootwearPageDE();
		menRidingPage = menFootwearPage.returnMenRidingCategoryPageLeftNav();
		menFootwearRidingToolBootsPage = menRidingPage.returnMenFootwearRidingToolBootsPageLeftNav();
		menFootwearRidingPaddockPage = menRidingPage.returnMenFootwearRidingPaddockPageLeftNav();
		menFootwearRidingHalfChapsPage = menRidingPage.returnMenFootwearRidingHalfChapsCategoryPageLeftNav();
		menFootwearAllWeatherRidingPage = menRidingPage.returnMenFootwearAllWeatherRidingCategoryPageLeftNav();
		menFootwearRidingEndurancePage = menRidingPage.returnMenFootwearRidingEnduranceCategoryPageLeftNav();
		menFootwearRidingBarnyardPage = menRidingPage.returnMenFootwearRidingBarnyardCategoryPageLeftNav();
		logger.info("Finishing left navigation Men Footwear Riding sub-categories test.");
	}

	@Test(priority = 1)
	public void leftNavigationMenFootwearCountrySubcategories() {
		logger.info("Starting left navigation Men Footwear Country sub-categories test...");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
		homePageDE = (HomePageDE) homePage.chooseEULocation(euCountry.DE, euCountry.DE.getCurrencyISO());
		menCategoryPage = homePageDE.returnMenCategoryPage();
		menFootwearPage = menCategoryPage.returnMenFootwearPageDE();
		menFootwearCountryPage = menFootwearPage.returnMenFootwearCountryCategoryPageLeftNav();
		menFootwearCountryOutdoorPage = menFootwearCountryPage.returnMenFootwearCountryOutdoorCategoryPageLeftNav();
		menFootwearCountryRubberPage = menFootwearCountryPage.returnMenFootwearCountryRubberCategoryPageLeftNav();
		menFootwearCountryToolBootsPage = menFootwearCountryPage.returnMenFootwearCountryTallBootsCategoryPageLeftNav();
		menFootwearCountryWalkingPage = menFootwearCountryPage.returnMenFootwearCountryWalkingCategoryPageLeftNav();
		logger.info("Finishing left navigation Men Footwear Country sub-categories test.");
	}

	@Test(priority = 2)
	public void leftNavigationMenFootwearWesternSubcategories() {
		logger.info("Starting left navigation Men Footwear Western sub-categories test...");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
		homePageDE = (HomePageDE) homePage.chooseEULocation(euCountry.DE, euCountry.DE.getCurrencyISO());
		menCategoryPage = homePageDE.returnMenCategoryPage();
		menFootwearPage = menCategoryPage.returnMenFootwearPageDE();
		menFootwearWesternPage = menFootwearPage.returnMenFootwearWesternCategoryPageLeftNav();
		menFootwearWesternPerformancePage = menFootwearWesternPage
				.returnMenFootwearWesternPerformanceCategoryPageLeftNav();
		menFootwearWesternFashionPage = menFootwearWesternPage.returnMenFootwearWesternFashionCategoryLeftNav();
		logger.info("Finishing left navigation Men Footwear Western sub-categories test.");
	}

	@Test(priority = 3)
	public void leftNavigationMenFootwearWorkSubcategories() {
		logger.info("Starting left navigation Men Footwear Work sub-categories test...");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
		homePageDE = (HomePageDE) homePage.chooseEULocation(euCountry.DE, euCountry.DE.getCurrencyISO());
		menCategoryPage = homePageDE.returnMenCategoryPage();
		menFootwearPage = menCategoryPage.returnMenFootwearPageDE();
		menFootwearWorkPage = menFootwearPage.returnMenFootwearWorkCategoryPageLeftNav();
		menFootwearWorkLaceUpPage = menFootwearWorkPage.returnMenFootwearWorkLaceUpCategoryPageLeftNav();
		menFootwearWorkPullOnPage = menFootwearWorkPage.returnMenFootwearWorkPullOnCategoryPageLeftNav();
		logger.info("Finishing left navigation Men Footwear Work sub-categories test.");
	}

	@Test(priority = 4)
	public void leftNavigationMenFootwearCasualShoesSubcategories() {
		logger.info("Starting left navigation Men Footwear Casual shoes sub-category test...");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
		homePageDE = (HomePageDE) homePage.chooseEULocation(euCountry.DE, euCountry.DE.getCurrencyISO());
		menCategoryPage = homePageDE.returnMenCategoryPage();
		menFootwearPage = menCategoryPage.returnMenFootwearPageDE();
		menFootwearCasualShoesPage = menFootwearPage.returnMenFootwearCasualShoesCategoryPageLeftNav();
		menFootwearSneakersPage = menFootwearCasualShoesPage.returnMenFashionSneakersCategoryPageLeftNav();
		logger.info("Finishing left navigation Men Footwear Casual shoes sub-category test.");
	}

	@AfterTest
	public void tearDown() {
		homePage.quit();
		homePageUK.quit();
		homePageDE.quit();
		menCategoryPage.quit();
		menFootwearPage.quit();

		menRidingPage.quit();
		menFootwearRidingToolBootsPage.quit();
		menFootwearRidingPaddockPage.quit();
		menFootwearRidingHalfChapsPage.quit();
		menFootwearAllWeatherRidingPage.quit();
		menFootwearRidingEndurancePage.quit();
		menFootwearRidingBarnyardPage.quit();

		menFootwearCountryPage.quit();
		menFootwearCountryOutdoorPage.quit();
		menFootwearCountryRubberPage.quit();
		menFootwearCountryToolBootsPage.quit();
		menFootwearCountryWalkingPage.quit();

		menFootwearWesternPage.quit();
		menFootwearWesternPerformancePage.quit();
		menFootwearWesternFashionPage.quit();

		menFootwearWorkPage.quit();
		menFootwearWorkLaceUpPage.quit();
		menFootwearWorkPullOnPage.quit();
		menFootwearCasualShoesPage.quit();
		menFootwearSneakersPage.quit();
		KillChrome kill = new KillChrome();
		kill.killChrome();
	}
}
