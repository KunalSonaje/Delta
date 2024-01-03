package com.bravo.stepdefinations;

import com.bravo.base.Config;
import com.bravo.keywords.Keyword;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
	
	@Before
	public void setUp() throws Exception {
		Keyword keyword=new Keyword();
		keyword.openBrowser(Config.geBrowserName());
		keyword.maximizeBrowser();
		keyword.openUrl(Config.getAppUrl("dev"));
		

	}
	@After
	public void teardown() {
		Keyword keyword=new Keyword();
		keyword.quiteAllWindows();
	}
	}


