package org.testrunner;

import org.junit.AfterClass;

import org.junit.runner.RunWith;
import org.report.Reports;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\resources\\step.feature", glue = "org.stepdefinition", dryRun = false,

		plugin = { "json:target\\Reports\\cloudbankjsonreport.json", "html:target\\Reports\\cloudbankhtmlreport",
				"junit:target\\Reports\\cloudbankjunitreport.xml",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" }, publish = true

)
public class TestRunner {
	@AfterClass
	public static void reportName() {
		Reports.toGenerateReport("target\\Reports\\cloudbankjsonreport.json");
	}

}
