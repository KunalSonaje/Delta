package bravo;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.bravo.base.TestBase;
import com.bravo.keywords.Keyword;
import com.bravo.pages.HomePage;
import com.bravo.pages.SearchResultPage;

public class TestCase2 extends TestBase {
	@Test
	public void verifyThePriceOfSmartWatch() {

		HomePage homepage = PageFactory.initElements(Keyword.getDriver(), HomePage.class);
		homepage.enterProductToSearch("smart watches men", Keys.ENTER);

		SearchResultPage resultpage = new SearchResultPage();
		resultpage.clickOnBrand();
		resultpage.clickOnPrice();
		List<String> wtitles = resultpage.getWatchTitles();
		SoftAssert softly = new SoftAssert();
		for (String wtitle : wtitles) {
			softly.assertTrue(wtitle.contains("Pebble"));
		}
		softly.assertAll();
	}

	@Test
	public void verifyProductAddInBag() {
		Keyword keyword = new Keyword();

		HomePage homepage = new HomePage();
		homepage.enterProductToSearch("safari bags", Keys.ENTER);

		SearchResultPage resultpage = new SearchResultPage();
		resultpage.clickOnBag();
		keyword.switchWindow();
		resultpage.clickOnAddToBag();

	}
    @Test
	public void verifyProductDetails() {
		Keyword keyword = new Keyword();

		HomePage homepage = new HomePage();
		homepage.enterProductToSearch("casio", Keys.ENTER);

		SearchResultPage resultpage = new SearchResultPage();
		resultpage.clickOnItem();
		keyword.switchWindow();
		keyword.scrollWindow(0, 1800);
		List<String> itemdetails = resultpage.getItemdetails();
		SoftAssert softly = new SoftAssert();
		for (String itemdetail : itemdetails) {
			
			System.out.println("Product Details: " + itemdetail);
			softly.assertTrue(itemdetail.contains("Analogue"));
		}
		softly.assertAll();
	}
	@Test
    public void verifyVillagePincodeForDelivary() {
    	Keyword keyword = new Keyword();
         
		HomePage homepage = new HomePage();
		homepage.enterProductToSearch("Allen Solly", Keys.ENTER);
		SearchResultPage resultpage=new SearchResultPage();
		resultpage.clickOnShirt();
		keyword.switchWindow();
		keyword.scrollWindow();		
		resultpage.enterPincodeToSearch("332309",Keys.ENTER);
    	

	}
	
	

}
