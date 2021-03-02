package steps;

import org.junit.runner.RunWith;

import Fidentity_pages.Gatepass;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
public class GatePassSteps {

	@When("^Navigate to create visitor pass$")
	public void Navigate_to_create_visitor_pass() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		Gatepass gatepass = new Gatepass();
		gatepass.visitorPassMenu();
	}

	@When("^Create visitor pass by enter required fields$")
	public void create_visitor_pass_by_enter_required_fields() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		Gatepass gatepass2 = new Gatepass();
		gatepass2.gatepassFields();
		gatepass2.save_visitorpass();
	}

	@When("^fill required fields and save$")
	public void fill_required_fields_and_save() throws Throwable {
		// Write code here that turns the phrase above into concrete actions

		Gatepass gatepass2 = new Gatepass();
		gatepass2.gatepassFields();
	}

	@Then("^Gate pass will be created successfully$")
	public void gate_pass_will_be_created_successfully() throws Throwable {
		// Write code here that turns the phrase above into concrete actions

	}
	@When("^Enter required fields for create visitor pass$")
	public void enter_required_fields_for_create_visitor_pass() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Gatepass gatepass2 = new Gatepass();
		gatepass2.gatepassFields();
	}

	@When("^Click on Reset button$")
	public void click_on_Reset_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Gatepass gatepass2 = new Gatepass();
		gatepass2.reset_visitorpass();
	}

	@Then("^Visitor pass fileds done reset successfully$")
	public void visitor_pass_fileds_done_reset_successfully() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
	}
	@When("^Click on Cancel button$")
	public void click_on_Cancel_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Gatepass gatepass2 = new Gatepass();
		gatepass2.cancel_visitorpass();
	}

	@Then("^Visitorpass creation cancelled successfully$")
	public void visitorpass_creation_cancelled_successfully() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
	}
	@When("^Check mandatory fields to create visitor pass$")
	public void check_mandatory_fields_to_create_visitor_pass() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Gatepass gatepass2 = new Gatepass();
		gatepass2.check_mandatory();
	}

	@Then("^Check mandatory fields successfully$")
	public void check_mandatory_fields_successfully() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@When("^Unused gate passed more than one$")
	public void Unused_gate_passed_more_than_one() throws Throwable {
		// Write code here that turns the phrase above into concrete actions

		Gatepass unusedpasses = new Gatepass();
		unusedpasses.Unused_gatepass();
	}
	// When Navigate to create to Resend visitor pass

	@When("^Navigate to create to Resend visitor pass$")
	public void Navigate_to_create_to_Resend_visitor_pass() throws Throwable {
		// Write code here that turns the phrase above into concrete actions

		Gatepass unusedpasses = new Gatepass();
		unusedpasses.Unused_gatepass();
	}

	@Then("^Resend first gate pass$")
	public void Resend_first_gate_pass() throws Throwable {
		// Write code here that turns the phrase above into concrete actions

		Gatepass resendpass = new Gatepass();
		resendpass.resend_gatepass();
	}
	@When("^Go to vistor pass menu$")
	public void go_to_vistor_pass_menu() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Gatepass unusedpasses = new Gatepass();
		unusedpasses.nav_visitorpass();
	}
	@When("^Click on resend visitorpass$")
	public void click_on_resend_visitorpass() throws Throwable {
		
		Gatepass unusedpasses = new Gatepass();
		unusedpasses.resend_gatepass();
	    // Write code here that turns the phrase above into concrete actions
	   
	}

	@When("^Confirm resend visitor pass$")
	public void confirm_resend_visitor_pass() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
	}

	@Then("^Visitorpass has been resend successfully$")
	public void visitorpass_has_been_resend_successfully() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	  
	}


	@Then("^Delete gate pass$")
	public void Delete_gate_pass() throws Throwable {
		// Write code here that turns the phrase above into concrete actions

		Gatepass deletepass = new Gatepass();
		deletepass.delete_gatepass();
	}

}
