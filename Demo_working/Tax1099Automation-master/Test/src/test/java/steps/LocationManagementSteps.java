package steps;

import Fidentity_pages.Locationmgmt;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LocationManagementSteps {

	@Given("^Goto location management$")
	public void goto_location_management() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Locationmgmt locnav=new Locationmgmt(); 
		locnav.locationNav();	
	}

	@When("^Edit location details$")
	public void edit_location_details() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Locationmgmt locedit=new Locationmgmt(); 
		locedit.edit_location();	
	}

	@When("^Edit location validations$")
	public void Edit_location_validations() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Locationmgmt locedit=new Locationmgmt(); 
		locedit.editLocation_vaidations();
	}
	
	@Then("^Location details will be edited successfully$")
	public void location_details_will_be_edited_successfully() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		Locationmgmt locedit=new Locationmgmt(); 
		locedit.update();	
	}
	
	
	
	@Then("^Location Validations done successfully$")
	public void Location_Validations_done_successfully() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
	}
	  
	@When("^number of locations$")
	public void check_the_number_of_locations() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Locationmgmt locount=new Locationmgmt(); 
		locount.locations_count();
	}

	@When("^more than one active location available in list inactiavte location$")
	public void more_than_one_active_location_available_in_list_inactiavte_location() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Locationmgmt locactive=new Locationmgmt(); 
		locactive.active_locations();
		
	}
	@When("^more than one active location available in list delete location$")
	public void more_than_one_active_location_available_in_list_delete_location() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Locationmgmt locdel=new Locationmgmt(); 
		locdel.delete_location();
		
	}

	@Then("^Edit the location$")
	public void Edit_the_location() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
	}

	@When("^there is one location available$")
	public void there_is_one_location_available() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@Then("^location cannot be editable$")
	public void location_cannot_be_editable() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@When("^Delete the location$")
	public void delete_the_location() throws Throwable {
		
		
		
		
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	
}
