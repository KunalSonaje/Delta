package com.bravo.base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.bravo.keywords.Keyword;

public class TestBase {
	Keyword keyword=new Keyword(); 
	@BeforeMethod
	public void setUpMethod() throws Exception {
		Keyword keyword=new Keyword();
		keyword.openBrowser(Config.geBrowserName());
		keyword.maximizeBrowser();
		keyword.openUrl(Config.getAppUrl("dev"));
		

	}
	@AfterMethod
	public void teardown() {
		Keyword keyword=new Keyword();
		keyword.quiteAllWindows();
	}
}
