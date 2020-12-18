package steps;

import Fidentity_pages.profile;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Profile_Steps {
	@When("^Go to Profile$")
	public void go_to_Profile() throws Throwable {
		profile profile=new profile();
		profile.profileView();
	    // Write code here that turns the phrase above into concrete actions
	     
	}

	@When("^select my profile$")
	public void select_my_profile() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	     
	}

	@Then("^Profile details will be displayed$")
	public void profile_details_will_be_displayed() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	     
	}

	@When("^user click on edit profile$")
	public void user_click_on_edit_profile() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		profile profileedit=new profile();
		
		profileedit.profileEdit();
	}

	@When("^Enter required detials$")
	public void enter_required_detials() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		profile profilefields=new profile();
		profilefields.requiredfileds();
	}

	@When("^click on update the details$")
	public void click_on_update_the_details() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		profile update=new profile();
		update.update();
		
	     
	}

	@Then("^Profile details will be updated successfully$")
	public void profile_details_will_be_updated_successfully() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		profile compare=new profile();
		compare.compare();
	
	     
	}

	
}
