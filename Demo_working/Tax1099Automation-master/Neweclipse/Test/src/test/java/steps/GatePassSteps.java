package steps;



import org.junit.runner.RunWith;

import Fidentity_pages.Gatepass;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
public class GatePassSteps {

	
	@When("^Go to vistor pass menu$")
	public void go_to_vistor_pass_menu() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Gatepass gatepass=new Gatepass();
		gatepass.visitorPassMenu();
	}

	@When("^fill required fields and save$")
	public void fill_required_fields_and_save() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   
		Gatepass gatepass2=new Gatepass();
		gatepass2.gatepassFields();
	}

	@Then("^Gate pass will be created successfully$")
	public void gate_pass_will_be_created_successfully() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	  
	}
	@When("^Unused gate passed more than one$")
	public void Unused_gate_passed_more_than_one () throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		Gatepass unusedpasses=new Gatepass();
		unusedpasses.Unused_gatepass();
	}
	
	@Then("^Resend first gate pass$")
	public void Resend_first_gate_pass() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions

		Gatepass resendpass=new Gatepass();
		resendpass.resend_gatepass();
	}
	
	@Then("^Delete gate pass$")
	public void Delete_gate_pass() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions


		Gatepass deletepass=new Gatepass();
		deletepass.delete_gatepass();
	}
	
	}

