package com.bravo.keywords;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Keyword  {
	
	private static final Logger LOG=LogManager.getLogger(Keyword.class);
	
	private static RemoteWebDriver driver = null;

	public static RemoteWebDriver getDriver() {
		return driver;

	}

	public void openBrowser(String browserName) {
		if (browserName.equalsIgnoreCase("Chrome")) {
			//System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Jars\\chromedriver.exe");
			ChromeOptions options=new ChromeOptions();
			options.addArguments("--disable-notifications");
			driver = new ChromeDriver(options);
			LOG.info("Opening Chrome browser");
		} else if (browserName.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
			LOG.info("Opening Firefox browser");
		} else if (browserName.isEmpty()) {
			driver = new ChromeDriver();
		}

	}

	public void openUrl(String url) {
		driver.get(url);
		LOG.info("Luanching Url");

	}

	public void closeBrowser() {
		driver.close();

	}

	public void quiteAllWindows() {
		driver.quit();

	}

	public WebElement getWebElement(String locatorType, String LocatorValue) {
		if (locatorType.equalsIgnoreCase("id")) {
			return driver.findElement(By.id(LocatorValue));
		} else if (locatorType.equalsIgnoreCase("css")) {
			return driver.findElement(By.cssSelector(LocatorValue));
		} else if (locatorType.equalsIgnoreCase("xpath")) {
			return driver.findElement(By.xpath(LocatorValue));
		} else if (locatorType.equalsIgnoreCase("name")) {
			return driver.findElement(By.name(LocatorValue));
		} else if (locatorType.equalsIgnoreCase("class")) {
			return driver.findElement(By.className(LocatorValue));
		} else if (locatorType.equalsIgnoreCase("tagname")) {
			return driver.findElement(By.tagName(LocatorValue));
		} else if (locatorType.equalsIgnoreCase("linketext")) {
			return driver.findElement(By.linkText(LocatorValue));
		} else if (locatorType.equalsIgnoreCase("partiallinktext")) {
			return driver.findElement(By.partialLinkText(LocatorValue));
		}
		return null;

	}

	public void clickOn(String locatorType, String LocatorValue) {
		getWebElement(locatorType, LocatorValue).click();

	}

	public void enterText(String locatorType, String LocatorValue, CharSequence... text) {
		getWebElement(locatorType, LocatorValue).sendKeys(text);

	}

	public void hitkey(int keycode) {
		try {
			Robot robo = new Robot();
			robo.keyPress(keycode);
			robo.keyRelease(keycode);
		} catch (AWTException e) {

			e.printStackTrace();
		}

	}

	
	public List<WebElement> getWebElements(String locatorType, String LocatorValue) {
		if (locatorType.equalsIgnoreCase("id")) {
			return driver.findElements(By.id(LocatorValue));
		} else if (locatorType.equalsIgnoreCase("css")) {
			return driver.findElements(By.cssSelector(LocatorValue));
		} else if (locatorType.equalsIgnoreCase("xpath")) {
			return driver.findElements(By.xpath(LocatorValue));
		} else if (locatorType.equalsIgnoreCase("name")) {
			return driver.findElements(By.name(LocatorValue));
		} else if (locatorType.equalsIgnoreCase("class")) {
			return driver.findElements(By.className(LocatorValue));
		} else if (locatorType.equalsIgnoreCase("tagname")) {
			return driver.findElements(By.tagName(LocatorValue));
		} else if (locatorType.equalsIgnoreCase("linketext")) {
			return driver.findElements(By.linkText(LocatorValue));
		} else if (locatorType.equalsIgnoreCase("partiallinktext")) {
			return driver.findElements(By.partialLinkText(LocatorValue));
		}
		return null;

	}
	public List<String> getTexts(String locatorType, String LocatorValue) {
		List<String> texts = new ArrayList<String>();
		
		List<WebElement> elements=new ArrayList<WebElement>();
        elements= getWebElements(locatorType, LocatorValue);
        for (WebElement element : elements) {
			texts.add(element.getText());
		}
		return texts;
	}

	public void maximizeBrowser() {
		driver.manage().window().maximize();
		
	}

	public List<String> getTexts(List<WebElement> items) {
		List<String>texts=new ArrayList<String>();
				for (WebElement item : items) {
					texts.add(item.getText());
				}
				return texts;
		
	}
	
	public void scrollWindow() {
		driver.executeScript("window.scrollBy(0,300)");

	}

	public void scrollWindow(int i, int j) {
		driver.executeScript("window.scrollBy(i,j)");
		
	}
	
	public void switchWindow() {
		Set<String> handles = driver.getWindowHandles();
		for (String handle : handles) {
			driver.switchTo().window(handle);
		}

	}
	
	
}
