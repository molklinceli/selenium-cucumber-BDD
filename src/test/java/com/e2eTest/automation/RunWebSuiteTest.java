package com.e2eTest.automation;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = {"src/spec/features"},
    plugin = {"pretty", "json:target/cucumber.json"}, // juste JSON
    tags = ("@login"),
    monochrome = true,
    snippets = CAMELCASE
)
public class RunWebSuiteTest {
}
