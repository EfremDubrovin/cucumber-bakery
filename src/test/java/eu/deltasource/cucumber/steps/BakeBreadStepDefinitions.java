package eu.deltasource.cucumber.steps;

import eu.deltasource.cucumber.bread.BakeryApplication;
import eu.deltasource.cucumber.bread.Bakery;
import eu.deltasource.cucumber.bread.Bread;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.jupiter.api.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@CucumberContextConfiguration
@ContextConfiguration(classes = {BakeryApplication.class})
@SpringBootTest(webEnvironment = NONE)
//@DirtiesContext - forbidden annotation
public class BakeBreadStepDefinitions {

	@Autowired
	private Bakery bakery;

	private Bread bread;

	@Before
	@Tag("cleaning")
	public void cleanUp() {
		// todo: do something here ;)
		// bakery.cleanBakery();
	}

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

	@When("we bake the dough for (.*) minutes")
	public void weBakeTheDoughForBakeDurationMinutes(int duration) {
		bakery.bake(bread, duration);
	}
}
