package com.bravo.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import com.bravo.keywords.Keyword;

public class SearchResultPage {

	@FindBy(xpath = "//h3[@class=\"product-brand\"]")
	public List<WebElement> productTitles;

	@FindBy(css = "[class=\"product-brand\"]")
	public List<WebElement> watchTitles;

	@FindBy(css = "[class=\"common-customCheckbox\"]:nth-child(1)")
	public WebElement price;

	@FindBy(css = "[class=\"common-customCheckbox vertical-filters-label\"]:nth-child(1)")
	public WebElement brand;
	
	@FindBy(css="[class=\"img-responsive\"]:nth-child(1)")
	public WebElement bag;
	
	@FindBy(css="[class=\"myntraweb-sprite pdp-whiteBag sprites-whiteBag pdp-flex pdp-center\"]")
	public WebElement addtobag;
	
	@FindBy(css="[class=\"img-responsive\"]:nth-child(1)")
	public WebElement item;
	
	@FindBy(css="[class=\"pdp-product-description-content\"]:nth-child(2)")
	public List<WebElement> itemdetails;
	
	@FindBy(css="[class=\"img-responsive\"]:nth-child(1)")
	public WebElement shirt;
	
	@FindBy(css="[placeholder=\"Enter pincode\"]")
	public WebElement pincode;
      
	
	
	
	
	
	
	
	
	
	
	public SearchResultPage() {
		PageFactory.initElements(Keyword.getDriver(), this);
	}

	public List<String> getProductTitles() {
		Keyword keyword = new Keyword();
		return keyword.getTexts(productTitles);

	}

	public void verifyProductTitleContains(String expectedText) {
		List<String> titles = getProductTitles();
		SoftAssert softly = new SoftAssert();
		for (String title : titles) {
			softly.assertTrue(title.contains(expectedText));
		}
		softly.assertAll();

	}

	public List<String> getWatchTitles() {
		Keyword keyword = new Keyword();

		return keyword.getTexts(watchTitles);

	}

	public void verifyWatchTitleContains(String expectedText) {
		List<String> wtitles = getWatchTitles();
		
	}
		

	public void clickOnPrice() {
		price.click();

	}

	

	public void clickOnBrand() {
        brand.click();
	}
	
	public void clickOnBag() {
        bag.click();
	}
	public void clickOnAddToBag() {
		addtobag.click();
		System.out.println("Selected Item Added Successfully");

	}
    public void clickOnItem() {
    	item.click();

	}
    public List<String> getItemdetails() {
    	Keyword keyword = new Keyword();
		return keyword.getTexts(itemdetails);
	}
    
    public void clickOnShirt() {
    	shirt.click();

	}
    
    public void enterPincodeToSearch(String string, Keys enter) {
    	pincode.sendKeys();
        
	}
	
}
