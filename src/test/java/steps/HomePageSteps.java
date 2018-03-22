package steps;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import pages.HomePage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

public class HomePageSteps {
	HomePage homePage = new HomePage();
	
	@Given("^I am on the start page$")
	public void iAmOnTheStartPage() throws Throwable {
		homePage.open();
		assertThat(homePage.loaded(), is(true));
	}

	@Then("^I should see name of agent displayed$")
	public void iShouldSeeNameOfAgentDisplayed() throws Throwable {
		assertThat(homePage.getHeader(), is("YVONNE RICH"));

	}
	
	@When("^I scroll to \"([^\"]*)\" section$")
	public void iScrollToSection(String arg1) throws Throwable {
		homePage.scrollTo("featured");
	}
	
	@Then("^I should see properties slider displayed$")
	public void iShouldSeePropertiesSliderDisplayed() throws Throwable {
		assertThat(homePage.propsSliderDisplayed(), is(true));
	}
	
	@When("^I hover the cursor on the section$")
	public void hoverTheCursorOnTheSection() throws Throwable {
		homePage.hoverCursor();
	}
}
