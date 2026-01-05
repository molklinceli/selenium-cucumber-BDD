package com.e2eTest.automation;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;

import org.junit.runner.RunWith; 

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/spec/features"},
		plugin = {"pretty","html: target/report/cucumber-report.html", "json: target/report/cucumber.json"},
		//glue = {"src/test/java/com/e2eTest/automation/step_definitions"},
		tags = ("@login"),
		monochrome = true,
		snippets = CAMELCASE
		)


public class RunWebSuiteTest {

}
