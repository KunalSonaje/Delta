package com.bravo.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bravo.keywords.Keyword;

public class WatchesSearchResultPage {
	@FindBy(css="[class=\"product-discountedPrice\"]:nth-child(1) ")
	public List<WebElement>prices;
    private By price=By.cssSelector("[class=\"product-discountedPrice\"]:nth-child(1) ");
    
    public WatchesSearchResultPage() {
    	
    	PageFactory.initElements(Keyword.getDriver(), this);
  	}
    public List<WebElement> getPrices() {
    	Keyword keyword=new Keyword();
		keyword.getTexts(prices);
		keyword.getTexts(prices);
    	return prices;
	}
    public void verifyprices() {
     //List<WebElement>Price=getPrices();
	}
}
