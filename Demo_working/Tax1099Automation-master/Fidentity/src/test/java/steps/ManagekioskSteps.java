package steps;

import Fidentity_pages.ManageKiosk;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ManagekioskSteps {
	
	@Given("^Go to kiosk management$")
	public void go_to_kiosk_management() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		ManageKiosk kiosk=new ManageKiosk();
		kiosk.nav_kiosk();
	   
	}

	@When("^Add kiosk$")
	public void add_kiosk() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		ManageKiosk kiosk=new ManageKiosk();
		kiosk.add_kiosk();
	}

	@Then("^Kiosk added successfully$")
	public void kiosk_added_successfully() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	  
	}
	
	@When("^Delete kiosk$")
	public void delete_kiosk() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		ManageKiosk kiosk=new ManageKiosk();
		kiosk.delete_kiosk();
	}

	@Then("^Kiosk delted successfully$")
	public void kiosk_delted_successfully() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   
	}
	@When("^Edit kiosk$")
	public void edit_kiosk() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		ManageKiosk kiosk=new ManageKiosk();
		kiosk.editKiosk();
	}

	@Then("^Kiosk edited successfully$")
	public void kiosk_edited_successfully() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   
	}
	
	@When("^Dettach kiosk$")
	public void dettach_kiosk() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		ManageKiosk kiosk=new ManageKiosk();
		kiosk.dettachKiosk();
	}

	@Then("^Kiosk dettached successfully$")
	public void kiosk_dettached_successfully() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   
	}
	
	@When("^Cancel the dettach kiosk$")
	public void cancel_the_dettach_kiosk() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   
	}

	@Then("^Cancellation of Kiosk dettached done successfully$")
	public void cancellation_of_Kiosk_dettached_done_successfully() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   
	}

}
