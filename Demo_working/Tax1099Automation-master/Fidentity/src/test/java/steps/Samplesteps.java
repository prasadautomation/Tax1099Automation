package steps;

import Fidentity_pages.Sampleforxray;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Samplesteps {
	
	@Given("^Launch browser$")
	public void launch_browser() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    Sampleforxray sample=new Sampleforxray();
	    sample.launchbrowser();
	}

	@Given("^Enter url$")
	public void enter_url() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		 Sampleforxray sample=new Sampleforxray();
		    sample.testurl();
	}

	@When("^select item from the list$")
	public void select_item_from_the_list() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Sampleforxray sample=new Sampleforxray();
		sample.selectitem();
	}

	@When("^add item to cart$")
	public void add_item_to_cart() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	
	
	@Then("^item will be added tp cart successfully$")
	public void item_will_be_added_tp_cart_successfully() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

}
