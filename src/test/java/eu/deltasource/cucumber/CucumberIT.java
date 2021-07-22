package eu.deltasource.cucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
	plugin = {"pretty", "html:target/cucumber-report"},
	features = {"classpath:features"},
	snippets = CucumberOptions.SnippetType.CAMELCASE,
	glue = {"cucumber.api.spring", "eu.deltasource.cucumber.steps"}
)
class CucumberIT {
}
