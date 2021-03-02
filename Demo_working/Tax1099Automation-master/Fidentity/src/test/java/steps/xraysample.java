package steps;

import Fidentity_pages.trailxray;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class xraysample {
	
	@Given("^launch the page$")
	public void launch_the_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    trailxray xray=new trailxray();
	    xray.fidentity_site();
	}

	@When("^enter the url$")
	public void enter_the_url() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@Then("^Fidentity page will be opened$")
	public void fidentity_page_will_be_opened() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
	}


}
