package com.ariat.Tests.Categories.Countries.Navigation.MenCategory.TopNav;

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
import com.ariat.Pages.Categories.MenCategories.MenAccessoriesPage;
import com.ariat.Pages.Categories.MenCategories.MenCategoryPage;
import com.ariat.Pages.Categories.MenCategories.MenClothingPage;
import com.ariat.Pages.Categories.MenCategories.MenFeaturedPage;
import com.ariat.Pages.Categories.MenCategories.MenFootwearPage;
import com.ariat.Pages.Categories.MenCategories.MenAccessoriesSubcategories.MenAccessoriesBagsPage;
import com.ariat.Pages.Categories.MenCategories.MenAccessoriesSubcategories.MenAccessoriesGlovesPage;
import com.ariat.Pages.Categories.MenCategories.MenAccessoriesSubcategories.MenAccessoriesHeadwearPage;
import com.ariat.Pages.Categories.MenCategories.MenAccessoriesSubcategories.MenAccessoriesSocksPage;
import com.ariat.Pages.Categories.MenCategories.MenClothingSubcategories.MenClothingBreechesPage;
import com.ariat.Pages.Categories.MenCategories.MenClothingSubcategories.MenClothingOuterwearPage;
import com.ariat.Pages.Categories.MenCategories.MenClothingSubcategories.MenClothingSweatTshirtAndWoodiesPage;
import com.ariat.Pages.Categories.MenCategories.MenClothingSubcategories.MenClothingTopsAndTshirtsPage;
import com.ariat.Pages.Categories.MenCategories.MenFeaturedSubcategories.MenFeaturedTeamCollectionPage;
import com.ariat.Pages.Categories.MenCategories.MenFeaturedSubcategories.MenFeaturedVentTekPage;
import com.ariat.Pages.Categories.MenCategories.MenFootwearSubcategories.MenFootwearCasualShoesPage;
import com.ariat.Pages.Categories.MenCategories.MenFootwearSubcategories.MenFootwearCountryPage;
import com.ariat.Pages.Categories.MenCategories.MenFootwearSubcategories.MenFootwearRidingPage;
import com.ariat.Pages.Categories.MenCategories.MenFootwearSubcategories.MenFootwearWesternPage;
import com.ariat.Pages.Categories.MenCategories.MenFootwearSubcategories.MenFootwearWorkPage;


/**
 * Test pages redirection from Men Category to all its sub-categories tree Denmark test
 * structure
 * 
 * @author aila.bogasieru@ariat.com
 *
 */

public class MenCategoriesAndSubcategoriesTopNavDETest extends BaseTest {

	private Environments environment;
	private EUCountries euCountry;
	private HomePage homePage;
	private HomePageUK homePageUK;
	private HomePageDE homePageDE;
	private MenCategoryPage menCategoryPage;
	private MenFootwearPage menFootwearPage;
	private MenFootwearWesternPage menFootwearWesterenPage;
	private MenClothingPage menClothingPage;
	private MenAccessoriesPage menAccessoriesPage;
	private MenFeaturedPage menFeaturedPage;
	private MenFootwearRidingPage menFootwearRidingPage;
	private MenFootwearWorkPage menFootwearWorkPage;
	private MenFootwearCountryPage menFootwearCountryPage;
	private MenFootwearCasualShoesPage menFootwearCasualShoesPage;
	private MenClothingOuterwearPage menClothingOuterwearPage;
	private MenClothingBreechesPage menClothingBreechesPage;
    private MenClothingSweatTshirtAndWoodiesPage menClothingSweatTshirtAndWoodiesPage;
	private MenClothingTopsAndTshirtsPage menClothingTopsAndTshirtsPage;
	private MenAccessoriesBagsPage menAccessoriesBagsPage;
	private MenAccessoriesGlovesPage menAccessoriesGlovesPage;
	private MenAccessoriesHeadwearPage menAccessoriesHeadwearPage;

	private MenAccessoriesSocksPage menAccessoriesSocksPage;
	private MenFeaturedTeamCollectionPage menFeaturedTeamCollectionPage;
	private MenFeaturedVentTekPage menFeaturedVentTekPage;
	
	@BeforeTest
	public void setSeleniumUP() {
		SetSelenium setPath = new SetSelenium();
		setPath.setSelenium();
	}


	@Test(priority = 0)
	public void topnNavMenFootwearCategories() {
		logger.info("Starting navigate Men Footwear sub-categories test...");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
		homePageDE = (HomePageDE) homePage.chooseEULocation(euCountry.DE, euCountry.DE.getCurrencyISO());
		menCategoryPage = homePageDE.returnMenCategoryPage();
		menCategoryPage.menCategoryDE();
		menFootwearPage = menCategoryPage.returnMenFootwearPageDE();
		menCategoryPage.menCategoryDE();
		menFootwearRidingPage = menFootwearPage.returnMenFootwearRidingCategoryPage();
		menCategoryPage.menCategoryDE();
		menFootwearWesterenPage = menFootwearPage.returnMenFootwearWesternCategoryPage();
		menCategoryPage.menCategoryDE();
		menFootwearCountryPage = menFootwearPage.returnMenFootwearCountryCategoryPage();
		menCategoryPage.menCategoryDE();
		menFootwearCasualShoesPage = menFootwearPage.returnMenFootwearCasualShoesCategoryPage();
		menCategoryPage.menCategoryDE();
		menFootwearWorkPage = menFootwearPage.returnMenFootwearWorkCategoryPage();
		logger.info("Finishing navigate Men Footwear sub-categories test.");
	}

	@Test(priority = 1)
	public void topNavMenClothingCategoriesTest() {
		logger.info("Starting navigate Men Clothing sub-categories test...");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
		homePageDE = (HomePageDE) homePage.chooseEULocation(euCountry.DE, euCountry.DE.getCurrencyISO());
		menCategoryPage = homePageDE.returnMenCategoryPage();
		menCategoryPage.menCategoryDE();
		menClothingPage = menCategoryPage.returnMenClothingCategoryPageDE();
		menCategoryPage.menCategoryDE();
		menClothingOuterwearPage = menClothingPage.returnMenClothingOuterwearCategoryPage();
		menCategoryPage.menCategoryDE();
		menClothingBreechesPage = menClothingPage.returnMenClothingBreechesCategoryPage();
		menCategoryPage.menCategoryDE();
		menClothingSweatTshirtAndWoodiesPage = menClothingPage.returnMenClothingSweatTshirtAndWoodiesCategoryPage();
		menCategoryPage.menCategoryDE();
		menClothingTopsAndTshirtsPage = menClothingPage.returnMenClothingTopsAndTshirtsCategoryPage();
		logger.info("Finishing navigate Men Clothing sub-categories test.");
	}

	@Test(priority = 2)
	public void topNavmenAccessoriesCategoriesTest() {
		logger.info("Starting navigate men Accessories sub-categories test...");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
		homePageDE = (HomePageDE) homePage.chooseEULocation(euCountry.DE, euCountry.DE.getCurrencyISO());
		menCategoryPage = homePageDE.returnMenCategoryPage();
		menCategoryPage.menCategoryDE();
		menAccessoriesPage = menCategoryPage.returnMenAccessoriesCategoryPage();
		menCategoryPage.menCategoryDE();
		menAccessoriesBagsPage = menAccessoriesPage.returnMenAccessoriesBagsCategoryPage();
		menCategoryPage.menCategoryDE();
		menAccessoriesGlovesPage = menAccessoriesPage.returnMenAccessoriesGlovesCategoryPage();
		menCategoryPage.menCategoryDE();
		menAccessoriesHeadwearPage = menAccessoriesPage.returnMenAccessoriesHeadwearCategoryPage();
		menCategoryPage.menCategoryDE();
		menAccessoriesSocksPage = menAccessoriesPage.returnMenAccessoriesSocksCategoryPage();
		logger.info("Finishing navigate men Accessories sub-categories test.");
	}

	@Test(priority = 3)
	public void topNavmenFeaturedCategoriesTest() {
		logger.info("Starting navigate Men Featured sub-categories test...");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
		homePageDE = (HomePageDE) homePage.chooseEULocation(euCountry.DE, euCountry.DE.getCurrencyISO());
		menCategoryPage = homePageDE.returnMenCategoryPage();
		menCategoryPage.menCategoryDE();
		menFeaturedPage = menCategoryPage.returnMenFeaturedCategoryPage();
		menCategoryPage.menCategoryDE();
		menFeaturedTeamCollectionPage = menFeaturedPage.returMenFeaturedTeamCollectionCategoryPage();
		menCategoryPage.menCategoryDE();
		menFeaturedVentTekPage = menFeaturedPage.returnMenFeaturedVentTekCategoryPage();
		logger.info("Finishing navigate Men Featured sub-categories test.");
	} 

	@AfterTest
	public void tearDown() {
		homePage.quit();
		homePageUK.quit();
		homePageDE.quit();
		menCategoryPage.quit();
		menFootwearPage.quit();
		menFootwearRidingPage.quit();
		menFootwearWesterenPage.quit();
		menFootwearCountryPage.quit();
		menFootwearCasualShoesPage.quit();
		menFootwearWorkPage.quit();
		
		menClothingPage.quit();
		menClothingOuterwearPage.quit();
		menClothingBreechesPage.quit();
		menClothingSweatTshirtAndWoodiesPage.quit();
		menClothingTopsAndTshirtsPage.quit();
		
		menAccessoriesPage.quit();
		menAccessoriesBagsPage.quit();
		menAccessoriesGlovesPage.quit();
		menAccessoriesHeadwearPage.quit();
		menAccessoriesSocksPage.quit();
		
		menFeaturedPage.quit();
		menFeaturedTeamCollectionPage.quit();
		menFeaturedVentTekPage.quit();
		KillChrome kill = new KillChrome();
		kill.killChrome();
	}
}
