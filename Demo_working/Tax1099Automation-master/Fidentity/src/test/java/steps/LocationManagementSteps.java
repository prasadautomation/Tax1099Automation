package steps;

import Fidentity_pages.Locationmgmt;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LocationManagementSteps {

	@Given("^Goto location management$")
	public void goto_location_management() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		Locationmgmt locnav = new Locationmgmt();
		locnav.locationNav();
	}

	@When("^Edit location details$")
	public void edit_location_details() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		Locationmgmt locedit = new Locationmgmt();
		locedit.edit_location();
	}

	@When("^Edit location validations$")
	public void Edit_location_validations() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		Locationmgmt locedit = new Locationmgmt();
		locedit.editLocation_vaidations();
	}

	@Then("^Location details will be edited successfully$")
	public void location_details_will_be_edited_successfully() throws Throwable {
		// Write code here that turns the phrase above into concrete actions

		Locationmgmt locedit = new Locationmgmt();
		locedit.update();
	}

	@Then("^Location Validations done successfully$")
	public void Location_Validations_done_successfully() throws Throwable {

		System.out.print("\n" + "Mandatory fileds validation done for edit location feature");
		// Write code here that turns the phrase above into concrete actions

	}

	@When("^check the number of locations$")
	public void check_the_number_of_locations() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		Locationmgmt locount = new Locationmgmt();
		locount.locations_count();
	}
	
	@Given("^Select Inactive location$")
	public void select_Inactive_location() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Locationmgmt locount = new Locationmgmt();
		locount.active_inactive_locations();
		
	}

	@Given("^Click on active icon$")
	public void click_on_active_icon() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@When("^Confirm the activation$")
	public void confirm_the_activation() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@Then("^Inactive location activated successfully$")
	public void inactive_location_activated_successfully() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	  
	}
	
	@When("^more than one active location available in list Click on Incative$")
	public void more_than_one_active_location_available_in_list_Click_on_Incative() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@When("^Click on cancel in inactive modal box$")
	public void click_on_cancel_in_inactive_modal_box() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Locationmgmt locedit = new Locationmgmt();
		locedit.cancelInactive();
		
	}

	@Then("^Cancelled inactive location tested successfully$")
	public void cancelled_inactive_location_tested_successfully() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   
	}

	@When("^more than one active location available in list inactiavte random location$")
	public void more_than_one_active_location_available_in_list_inactiavte_random_location() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		Locationmgmt locactive = new Locationmgmt();
		locactive.inactivelocations();

	}

	@Then("^Inactivated location tested successfully$")
	public void inactivated_location_tested_successfully() throws Throwable {
		// Write code here that turns the phrase above into concrete actions

	}
	
	@Given("^Click on Download reports icon$")
	public void click_on_Download_reports_icon() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Locationmgmt locactive = new Locationmgmt();
		locactive.reports_download();
	}

	@Given("^Select reports type$")
	public void select_reports_type() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Locationmgmt location=new Locationmgmt();
		location.select_reporttype();
	}

	@Given("^Select required dates$")
	public void select_required_dates() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Locationmgmt location=new Locationmgmt();
		location.dates_fromto();
	}
	
	@When("^Check validations to download reports$")
	public void check_validations_to_download_reports() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Locationmgmt location=new Locationmgmt();
		location.download_submit();
		System.out.print("\n"+"Select report type validation checked");
		location.download_validations();
	}

	@Then("^Succeefully checked validations$")
	public void succeefully_checked_validations() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   
	}

	@When("^Click on submit$")
	public void click_on_submit() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Locationmgmt location=new Locationmgmt();
		location.download_submit();
	}
	@When("^Click on Reset$")
	public void click_on_Reset() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Locationmgmt location=new Locationmgmt();
		location.reset_download();
	}

	@Then("^Reset done download reports successfully$")
	public void reset_done_download_reports_successfully() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   
	}
	

	@Then("^Reports downloaded successfully$")
	public void reports_downloaded_successfully() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   
	}
	

	@When("^more than one active location available in list delete location$")
	public void more_than_one_active_location_available_in_list_delete_location() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		Locationmgmt locactive = new Locationmgmt();

		locactive.delete_location();

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

	}

	@Given("^click on create location$")
	public void click_on_create_location() throws Throwable {
		//Locationmgmt location = new Locationmgmt();
	//	location.createlocationbutton();
		// Write code here that turns the phrase above into concrete actions

	}

	@When("^Enter required details for loaction$")
	public void enter_required_details_for_loaction() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		Locationmgmt location = new Locationmgmt();
		location.location_details();

	}

	@When("^Save the details$")
	public void save_the_details() throws Throwable {
		// Write code here that turns the phrase above into concrete actions

	}

	@Then("^location will be created successfully$")
	public void location_will_be_created_successfully() throws Throwable {
		// Write code here that turns the phrase above into concrete actions

	}

}
