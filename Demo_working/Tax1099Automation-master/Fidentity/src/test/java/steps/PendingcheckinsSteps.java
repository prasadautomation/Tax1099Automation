package steps;

import Fidentity_pages.Pendingcheckins;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PendingcheckinsSteps {
	
	@When("^Navigate to pending checkins$")
	public void navigate_to_pending_checkins() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Pendingcheckins pendingcheckins=new Pendingcheckins();
		pendingcheckins.navigate_pendingcheckins();
	}

	@When("^Click on one record$")
	public void click_on_one_record() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Pendingcheckins pendingcheckins=new Pendingcheckins();
		pendingcheckins.select_pendingcheckin();
	}

	@When("^Click on accept$")
	public void click_on_accept() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Pendingcheckins pendingcheckins=new Pendingcheckins();
		pendingcheckins.accept_button();
		
		Pendingcheckins pendingcheckin=new Pendingcheckins();
		pendingcheckin.get_employeelist();
	}
	
	@When("^Click on Reject$")
	public void click_on_Reject() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Pendingcheckins pendingcheckins=new Pendingcheckins();
		pendingcheckins.reject_button();
		
	}
	@When("^Enter details to Reject record and confirm$")
	public void enter_details_to_Reject_record_and_confirm() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Pendingcheckins pendingcheckins=new Pendingcheckins();
		pendingcheckins.reject_details();
		 
	}

	@When("^Enter details to accept record and confirm$")
	public void enter_details_to_accept_record_and_confirm() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Pendingcheckins pendingcheckins=new Pendingcheckins();
		pendingcheckins.accept_details();
		 
	}

	@Then("^pending checkin will be checked-in successfully$")
	public void pending_checkin_will_be_checked_in_successfully() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
	}
	@Then("^pending checkin will be rejected successfully$")
	public void pending_checkin_will_be_rejected_successfully() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
	}



}
