package steps;

import Fidentity_pages.Events;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class EventsSteps {
	@Given("^Naviate to products$")
	public void naviate_to_products() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    Events events=new Events();
	    events.navigation_products();
	}

	@Given("^Select events$")
	public void select_events() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    Events events=new Events();
	    events.select_eventsproduct();
	}

	@When("^Click on create event$")
	public void click_on_create_event() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    Events events=new Events();
	    events.creteevent_button();
	}

	@When("^Requierd details$")
	public void requierd_details() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Events events=new Events();
	    events.required_details();
	}

	@When("^Save details and confirm$")
	public void save_details_and_confirm() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Events events=new Events();
	    events.button_createevent();
	    events.confirm_createevent();
	}

	@Then("^Event will be created successfully$")
	public void event_will_be_created_successfully() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
	}
	@When("^Click on cancel$")
	public void click_on_cancel() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		  Events events=new Events();
		  events.cancel_createevent();
	}

	@Then("^Event will be cancelled successfully$")
	public void event_will_be_cancelled_successfully() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   
	}
	
	@When("^Click on reset button$")
	public void click_on_reset_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		  Events events=new Events();
		  events.reset_eventcreation();
	} 
	@Then("^Done reset successfully$")
	public void Done_reset_successfully() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   
	}
	@When("^Choose not started event$")
	public void choose_not_started_event() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Events events=new Events();
		  events.chose_event_edit();
		
	}
	@When("^Choose not started event to start$")
	public void choose_not_started_event_to_start() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Events events=new Events();
		  events.event_start();
		
	}
	
	@When("^Choose not started event for change banner$")
	public void choose_not_started_event_for_change_banner() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Events events=new Events();
		  events.choseevent_forbannerchange();
		
	}
	
	@When("^Click on start$")
	public void click_on_start() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@When("^Check date validations$")
	public void check_date_validations() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   
	}

	@Then("^Event will be started successfully$")
	public void event_will_be_started_successfully() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	  
	}
	
	
	

	@When("^Click on edit$")
	public void click_on_edit() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   
	}

	@When("^Edit required details$")
	public void edit_required_details() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   
	}

	@When("^Save edited edvent details$")
	public void save_edited_edvent_details() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Events events=new Events();
		  events.edit_save();
	}

	@Then("^Event details edited successfully$")
	public void event_details_edited_successfully() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   
	}
	@When("^Cancel edit event details$")
	public void cancel_edit_event_details() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Events events=new Events();
		  events.cancel_edit();
	}

	@Then("^Cancelled edit event details successfully$")
	public void cancelled_edit_event_details_successfully() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   
	}
 
	@When("^Reset edit event details$")
	public void Reset_edit_event_details() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Events events=new Events();
		  events.reset_editevent();
	}

	@Then("^Reset edit event details successfully$")
	public void Reset_edit_event_details_successfully() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   
	}
	@When("^Click on change banner opiton$")
	public void click_on_change_banner_opiton() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Events events=new Events();
		  events.change_banner();
	}

	@When("^Select custom banner and save$")
	public void select_custom_banner_and_save() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Events events=new Events();
		  events.custom_banner();
		  events.customebanner_save();
	}

	//Select default banner and save
	@When("^Select default banner and save$")
	public void select_default_banner_and_save() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Events events=new Events();
		  events.default_banner();
		  events.customebanner_save();
	}
	@When("^Select custom banner and reset$")
	public void select_custom_banner_and_reset() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Events events=new Events();
		 events.custom_banner();
		 events.custombanner_reset();
	}
	
	@Then("^Custom banner changed successfully$")
	public void custom_banner_changed_successfully() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Events events=new Events();
		 events.edit_save();
		
	}
	@When("^Select custom banner and cancel$")
	public void select_custom_banner_and_cancel() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Events events=new Events();
		 events.custom_banner();
		 events.custombanner_cancel();
	}
	@When("^Click on active event for view anaytics$")
	public void click_on_active_event_for_view_analytics() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Events events=new Events();
		 events.choseevent_analytics();
	}
	@When("^Click on active event$")
	public void click_on_active_event() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
	}
	
	@When("^Click on active event to stop$")
	public void click_on_active_event_to_stop() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Events events=new Events();
		 events.stop_activeaccount();
	}
	
	@When("^Stop that event$")
	public void stop_that_event() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@Then("^Event stopped successfully$")
	public void event_stopped_successfully() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   
	}

	@Then("^Event analytics page should be displayed$")
	public void event_analytics_page_should_be_displayed() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
	}
	
	@Then("^Cancel banner Successfully$")
	public void cancel_banner_successfully() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
	}
	@Then("^Reset banner Successfully$")
	public void reset_banner_successfully() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
	}
	
	@Then("^Default banner changed successfully$")
	public void default_banner_changed_successfully() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Events events=new Events();
		 events.edit_save();
	}
	

	@When("^select participantsmenu$")
	public void select_participantsmenu() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Events events=new Events();
		 events.participants_menuitem();
	}

	@When("^Click on add$")
	public void click_on_add() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Events events=new Events();
		 events.participants_addbutton();
	}

	@When("^Enter required details and add$")
	public void enter_required_details_and_add() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Events events=new Events();
		 events.participants_details();
		 events.add_participant();
		 events.add_participant_confirmation();
	}

	@Then("^Participant added successfully$")
	public void participant_added_successfully() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
	}
	
	
	
	
	@Given("^sample program$")
	public void sample_program() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    Events events=new Events();
	    events.sampleexcel();
	}

	@When("^sample when$")
	public void sample_when() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@Then("^test$")
	public void test() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
	}



}
