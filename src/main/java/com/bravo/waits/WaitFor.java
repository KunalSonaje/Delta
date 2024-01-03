package com.bravo.waits;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import com.bravo.keywords.Keyword;

public class WaitFor  {

	private static FluentWait<WebDriver> wait = null;
	static {
		wait = new FluentWait<WebDriver>(Keyword.getDriver());
		wait.pollingEvery(Duration.ofMillis(500));
		wait.withTimeout(Duration.ofSeconds(60));
		wait.ignoring(NoSuchElementException.class);
	}

	public static void numberOfElementsToBeMoreThan(String locatorType, String LocatorValue, int count) {
		By element = null;
		if (locatorType.equalsIgnoreCase("id")) {
			element = By.id(LocatorValue);
		} else if (locatorType.equalsIgnoreCase("css")) {
			element = By.cssSelector(LocatorValue);
		} else if (locatorType.equalsIgnoreCase("xpath")) {
			element = By.xpath(LocatorValue);
		} else if (locatorType.equalsIgnoreCase("name")) {
			element = By.name(LocatorValue);
		} else if (locatorType.equalsIgnoreCase("class")) {
			element = By.className(LocatorValue);
		} else if (locatorType.equalsIgnoreCase("tagname")) {
			element = By.tagName(LocatorValue);
		} else if (locatorType.equalsIgnoreCase("linketext")) {
			element = By.linkText(LocatorValue);
		} else if (locatorType.equalsIgnoreCase("partiallinktext")) {
			element = By.partialLinkText(LocatorValue);
		}
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(element, count));
	}
}
