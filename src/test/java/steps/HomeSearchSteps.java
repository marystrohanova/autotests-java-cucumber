package steps;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import pages.HomePage;
import pages.HomeSearchPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HomeSearchSteps {
	HomePage homePage = new HomePage();
	HomeSearchPage homeSearchPage = new HomeSearchPage();
	
	@Given("^I navigate to \"([^\"]*)\" page$")
	public void navigateToPage(String menuName) throws Throwable {
		homePage.navigateTo(menuName);
		assertThat(homeSearchPage.loaded(), is(true));
	}
	
	@When("^I set \"([^\"]*)\" filter to be \"([^\"]*)\"$")
	public void iSetFilterToBe(String filterName, String filterValue) throws Throwable {
		homeSearchPage.setFilter(filterName, filterValue);
	}

	@Then("^I should see homes which have \"([^\"]*)\" and more bedrooms$")
	public void iShouldSeeHomesWhichHaveAndMoreBedrooms(int expectedBedCount) throws Throwable {
		assertThat(homeSearchPage.foundPropertiesBadsCountIs(expectedBedCount), is(true));
	}

	

	
}
