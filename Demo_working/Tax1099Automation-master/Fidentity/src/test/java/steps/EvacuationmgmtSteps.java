package steps;

import Fidentity_pages.Evacuationmgmt;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class EvacuationmgmtSteps {

	@Given("^Goto Evacuation management$")
	public void goto_Evacuation_management() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		Evacuationmgmt evacuation = new Evacuationmgmt();
		evacuation.evacuation_nav();
	}

	@When("^Create new notification with required details$")
	public void create_new_notification_with_required_details() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		Evacuationmgmt evacuation = new Evacuationmgmt();
		evacuation.create_first_notification_button();
	 	evacuation.Required_details_Create_notification();
	}

	@Then("^New evacuation notification created successfully$")
	public void new_evacuation_notification_created_successfully() throws Throwable {
		// Write code here that turns the phrase above into concrete actions

	}

	@When("^Click on create notification button$")
	public void click_on_create_notification_button() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		Evacuationmgmt evacuation = new Evacuationmgmt();
		evacuation.create_next_notification_button();

	}

	@When("^Enter required details for create notification$")
	public void Enter_required_details_for_create_notification() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		Evacuationmgmt evacuation = new Evacuationmgmt();
		evacuation.Required_details_Create_notification();

	}

	@When("^Click on import notification$")
	public void click_on_import_notification() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		Evacuationmgmt evacuation = new Evacuationmgmt();
		//evacuation.create_first_notification_button();
		evacuation.import_evacuation_notification();

	}

	@When("^Select available location$")
	public void select_available_location() throws Throwable {
		// Write code here that turns the phrase above into concrete actions

		Evacuationmgmt evacuation = new Evacuationmgmt();
		evacuation.select_location_for_import_notification();

	}

	@When("^Select needed notification and import notification$")
	public void select_needed_notification_and_import_notification() throws Throwable {
		// Write code here that turns the phrase above into concrete actions

		Evacuationmgmt evacuation = new Evacuationmgmt();
		evacuation.select_notification();

	}

	@Then("^imported evacuation notification added successfully$")
	public void imported_evacuation_notification_added_successfully() throws Throwable {
		// Write code here that turns the phrase above into concrete actions

	}
	@Given("^Navigate to notifications list$")
	public void navigate_to_notifications_list() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		Evacuationmgmt evacuation = new Evacuationmgmt();
		evacuation.create_button();
		
	    
	}
	@When("^Select one notification$")
	public void select_one_notification() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		Evacuationmgmt evacuation = new Evacuationmgmt();
		evacuation.get_emergency_types();

	}

	@When("^Cancel the delete confirmation$")
	public void cancel_the_delete_confirmation() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		Evacuationmgmt evacuation = new Evacuationmgmt();
		evacuation.cancel_deletion();

	}

	@When("^Click on delete menu$")
	public void click_on_delete_menu() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		Evacuationmgmt evacuation = new Evacuationmgmt();
		evacuation.alert_menu();
		evacuation.delete_menu();
	}

	@When("^confirm the delete notification$")
	public void confirm_the_delete_notification() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		// Write code here that turns the phrase above into concrete actions
		Evacuationmgmt evacuation = new Evacuationmgmt();
		evacuation.delete_confirmation();
	}

	@Then("^Notification will be deleted successfully$")
	public void notification_will_be_deleted_successfully() throws Throwable {
		// Write code here that turns the phrase above into concrete actions

	}

	@Then("^Notification deletion will be cancelled successfully$")
	public void notification_deletion_will_be_cancelled_successfully() throws Throwable {
		// Write code here that turns the phrase above into concrete actions

	}

	@When("^Click on edit menu$")
	public void click_on_edit_menu() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		Evacuationmgmt evacuation = new Evacuationmgmt();
		evacuation.alert_menu();
		evacuation.edit_menu();
	}

	@When("^Enter required fileds and save$")
	public void enter_required_fileds_and_save() throws Throwable {
		// Write code here that turns the phrase above into concrete actions

		Evacuationmgmt evacuation = new Evacuationmgmt();
		evacuation.edit_alert_details();
	}

	@Then("^Notification will be edited successfully$")
	public void notification_will_be_edited_successfully() throws Throwable {
		// Write code here that turns the phrase above into concrete actions

	}

}
