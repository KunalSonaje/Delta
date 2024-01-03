package bravo;




import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.bravo.base.TestBase;
import com.bravo.keywords.Keyword;
import com.bravo.pages.HomePage;
import com.bravo.pages.SearchResultPage;



public class TestCases extends TestBase {
	@Test
	public void firstframecase() {
    Keyword key=new Keyword(); 
    key.openBrowser("Chrome");
    key.maximizeBrowser();
    key.openUrl("https://www.myntra.com");
    //key.clickOn("xpath","//button[@class=\"pum-close popmake-close\"]");
    key.enterText("xpath", "//input[@placeholder=\"Search for products, brands and more\"]", "levis",Keys.ENTER);
  //  key.hitkey(KeyEvent.VK_ENTER);
    key.scrollWindow(0, 600);
   // key.getWebElements(null, null);
    
   
	}
	@Test
	public void caseWithoutFramework() {
		 System.setProperty("webdriver.chrome.driver","C:\\Program Files\\Jars\\chromedriver.exe");
		 RemoteWebDriver driver=new ChromeDriver();
		 driver.get("https://www.myntra.com/");
		 driver.findElement(By.cssSelector("div.desktop-query>input[placeholder*='Search for']")).sendKeys("Levis",Keys.ENTER);
		 FluentWait<WebDriver> wait=new FluentWait<WebDriver>(driver);
		 wait.pollingEvery(Duration.ofMillis(500));
		 wait.withTimeout(Duration.ofSeconds(60));
		 wait.ignoring(NoSuchElementException.class);
		 wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector("h3.product-brand"), 1));
		 List<WebElement> productTitles=driver.findElements(By.cssSelector("h3.product-brand"));
		 
		 SoftAssert softly=new SoftAssert();
		 for (WebElement productTitle : productTitles) {
			String text=productTitle.getText();
			System.out.println("Checking: "+text);
			softly.assertTrue(text.contains("Levis"));
		}
		 softly.assertAll();
	}
	@Test
	public void usingPageObjectModel() {
		HomePage homepage=PageFactory.initElements(Keyword.getDriver(), HomePage.class);
		homepage.enterProductToSearch("levis",Keys.ENTER);
		SearchResultPage resultpage=new SearchResultPage();
		resultpage.verifyProductTitleContains("levis");
		
		
		

	}
	@Test
	public void usingPageObjectModel1() {
		HomePage homepage=PageFactory.initElements(Keyword.getDriver(), HomePage.class);
		
	 

	}
}
