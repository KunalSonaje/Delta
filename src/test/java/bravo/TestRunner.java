package bravo;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
/*
 * we can run execute all features file from this class at a time.
 * feature=path of resourse file & glue= path of stepdefinations
 * tags=if you write @regression at top of any in testcase then only tagged case will run
 * dry run= its shows the if any stepdefination miss or skipped then he find this defination
 *         and suggest add stepdefination.
 */
@CucumberOptions(features="src/main/resources/Features" , 
glue="com.bravo.stepdefinations",
tags="@Regression",
dryRun=true,
plugin= {
		"io.qameta.allure.cucumber7jvm.AllureCucumber7jvm"
		
})
public class TestRunner extends AbstractTestNGCucumberTests{

}
