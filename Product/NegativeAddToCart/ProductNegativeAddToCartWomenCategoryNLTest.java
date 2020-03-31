package com.ariat.Tests.Product.NegativeAddToCart;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.ariat.Enums.EUCountries;
import com.ariat.Enums.Environments;
import com.ariat.Pages.Categories.WomenCategories.WomenCategoryPage;
import com.ariat.Pages.Categories.WomenCategories.WomenFootwearCountry.WomenFootwearCountrySubcategories.WomenFootwearRidingPage;
import com.ariat.Pages.Categories.WomenCategories.WomenSubcategories.WomenFootwearPage;
import com.ariat.Pages.HomePagesCountries.HomePage;
import com.ariat.Pages.HomePagesCountries.HomePageNL;
import com.ariat.Pages.HomePagesCountries.HomePageUK;
import com.ariat.Pages.Main.MyBagPage;
import com.ariat.Pages.Products.HeritageProductPage;
import com.ariat.Tests.Base.BaseTest;
import com.ariat.Utils.KillChrome;
import com.ariat.Utils.SetSelenium;
/**
 * Product page - > Women Category -> Negative Add to cart test
 * 
 * @author aila.bogasieru@ariat.com
 *
 */

public class ProductNegativeAddToCartWomenCategoryNLTest extends BaseTest {

	private Environments environment;
	private EUCountries euCountry;
	private HomePage homePage;
	private HomePageUK homePageUK;
	private HomePageNL homePageNL;
	private WomenCategoryPage womenCategoryPage;
	private MyBagPage myBagPage;
	private com.ariat.Pages.Categories.WomenCategories.WomenFootwearCountry.WomenFootwearCountrySubcategories.WomenFootwearCasualShoesPage womenFootwearCasualShoesCategoryPage;
	private WomenFootwearPage womenFootwearPage;
	private WomenFootwearRidingPage womenFootwearRidingPage;
	private HeritageProductPage heritageProductPage;
		
	@BeforeTest
	public void setSeleniumUP() {
		SetSelenium setPath = new SetSelenium();
		setPath.setSelenium();
	}

  @Test(priority=0)
	public void productPageWomenCategoryAddToCartTest() {
		logger.info("Starting product page -> Women Category Gloves sub-category product glove negative add to cart test...");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
		homePageNL = (HomePageNL) homePage.chooseEULocation(euCountry.NL, euCountry.NL.getCurrencyISO());
		womenCategoryPage = homePageNL.returnWomenCategoryPage();
		womenFootwearPage = womenCategoryPage.returnWomenFootwearPage();
		womenFootwearRidingPage=womenFootwearPage.returnWomenFootwearRidingCategoryPage();
		heritageProductPage.selectAttributeCalf("Slim");
		myBagPage = heritageProductPage.returnMyBagPage();
		myBagPage.removeProduct();
		logger.info("Finishing product page -> Women Category Gloves sub-category product glove negative add to cart test.");
	}
	
	@AfterTest
	public void tearDown() {
		homePage.quit();
		homePageUK.quit();
		homePageNL.quit();
		womenCategoryPage.quit();
		myBagPage.quit();
		womenFootwearRidingPage.quit();
		heritageProductPage.quit();
		myBagPage.quit();
		KillChrome kill = new KillChrome();
		kill.killChrome();
	}
}
