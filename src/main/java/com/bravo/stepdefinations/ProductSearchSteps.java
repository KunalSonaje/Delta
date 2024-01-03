package com.bravo.stepdefinations;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import com.bravo.keywords.Keyword;
import com.bravo.pages.HomePage;
import com.bravo.pages.SearchResultPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductSearchSteps {

	@Given("Enter smart watches in search component")
	public void enterProductToSearch() {
		HomePage homepage = PageFactory.initElements(Keyword.getDriver(), HomePage.class);
		homepage.enterProductToSearch("smart watches men");

	}

	@When("hit enter key")
	public void pressEnterKey() {

		HomePage homepage = PageFactory.initElements(Keyword.getDriver(), HomePage.class);
		homepage.enterProductToSearch("smart watches men", Keys.ENTER);

	}

	@Then("User click on brand and price")
	public void clickOnBrandAndPrice() {
		SearchResultPage resultpage = new SearchResultPage();
		resultpage.clickOnBrand();
		resultpage.clickOnPrice();

	}

	@And("verify Price of watch as per selected range")
	public void verifyPrice() {
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

	@Given("Enter safari bags in search component")
	public void enterBagNameToSearch() {
		HomePage homepage = new HomePage();
		homepage.enterProductToSearch("safari bags");

	}

	@When("press enter key")
	public void pressEnterButton() {
		HomePage homepage = new HomePage();
		homepage.enterProductToSearch("safari bags", Keys.ENTER);

	}
	
	@Then("User click on bag")
	public void clickOnBag() {
		SearchResultPage resultpage = new SearchResultPage();
		resultpage.clickOnBag();

	}
	
	@And("click on add to bag button")
	public void addToBag() {
		SearchResultPage resultpage=new SearchResultPage();
		Keyword keyword=new Keyword();
		keyword.switchWindow();
		resultpage.clickOnAddToBag();
		

	}

}
