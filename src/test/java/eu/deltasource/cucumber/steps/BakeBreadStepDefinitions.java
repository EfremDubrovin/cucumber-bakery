package eu.deltasource.cucumber.steps;

import eu.deltasource.cucumber.bread.BakeryApplication;
import eu.deltasource.cucumber.bread.Bakery;
import eu.deltasource.cucumber.bread.Bread;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@CucumberContextConfiguration
@ContextConfiguration(classes = {BakeryApplication.class})
@SpringBootTest(webEnvironment = NONE)
public class BakeBreadStepDefinitions {

	@Autowired
	private Bakery bakery;

	private Bread bread;

	@Given("we have made bread dough")
	public void weHaveMadeBreadDough() {
		bread = new Bread();
	}

	@When("we bake the dough")
	public void weBakeTheDough() {
		bakery.bake(bread);
	}

	@Then("the bread is baked")
	public void theBreadIsBaked() {
		assertThat(bread.isBaked(), equalTo(true));
	}
}
