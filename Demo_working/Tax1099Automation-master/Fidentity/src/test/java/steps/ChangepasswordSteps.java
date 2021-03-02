package steps;

import Fidentity_pages.Changepassword;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ChangepasswordSteps {
	
	@Given("^Navigate to change password$")
	public void navigate_to_change_password() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Changepassword change=new Changepassword();
		change.Changepassword_nav();
	}
 
	@When("^Fill details$")
	public void fill_details() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Changepassword change=new Changepassword();
		change.details(); 
	}

	@When("^Click on update$")
	public void click_on_update() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Changepassword change=new Changepassword();
		change.update();
	}

	@Then("^Password changed successfully$")
	public void password_changed_successfully() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Changepassword change=new Changepassword();
		change.successful();
	}
	    @When("^Fill details with validations$")
		public void Fill_details_with_validations() throws Throwable {
		    // Write code here that turns the phrase above into concrete actions
			Changepassword change=new Changepassword();
			change.validations();
		}
	    	    @Then("^Password validations checked successfully$")
		public void Password_validations_checked_successfully() throws Throwable {
		    // Write code here that turns the phrase above into concrete actions
			Changepassword change=new Changepassword();
			change.successful();
		}
	    
	}



