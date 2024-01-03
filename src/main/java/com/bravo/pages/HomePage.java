package com.bravo.pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bravo.keywords.Keyword;

public class HomePage {
	//WebElements
	/*
	 * findby=only for webelement or List<webelement>
	 * he works as equal findelment & findelements
	 */
	
	Logger LOG=Logger.getLogger(HomePage.class);
	
	@FindBy(css="[class=\"desktop-searchBar\"]:nth-child(1)")
	public WebElement searchComponent;
    
	@FindBy(css="span.sprites-search")
	public WebElement searchMagnifier;
	public HomePage() {
		PageFactory.initElements(Keyword.getDriver(), this);
	}
	//Actios:what you actuall perform on searchbox
	
	public void enterProductToSearch(CharSequence... ProductName) {
		searchComponent.sendKeys(ProductName);
        LOG.info("Entered product: " +ProductName+" to search");
	}
	
	public void clickonSearchMagnifier() {
		searchMagnifier.click();
	}
	

}
