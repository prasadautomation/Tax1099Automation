package steps;

import Fidentity_pages.Addemployee;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AddEmployeeSteps {

	@Given("^Navigate to add employee$")
	public void navigate_to_add_employee() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Addemployee addempav=new Addemployee();
		addempav.addemp_Nav();
	   
	}

	@When("^Enter required fields$")
	public void enter_required_fields() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Addemployee addemp=new Addemployee();
		addemp.emp_fields();
		
	}

	@When("^Select employee checkbox and add$")
	public void select_employee_checkbox_and_add() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Addemployee emprole=new Addemployee();
		emprole.emprole();
	}
	@When("^Select admin checkbox and add$")
	public void select_admin_checkbox_and_add() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Addemployee emprole=new Addemployee();
		emprole.admin_role();
	}
	
	@Then("^Employee will be added successfully$")
	public void employee_will_be_added_successfully() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   
	}
	
	@Then("^Admin will be added successfully$")
	public void Admin_will_be_added_successfully() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   
	}
	
	@When("^Enter existed employee phone number$")
	public void enter_existed_employee_phone_number() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Addemployee emprole=new Addemployee();
		emprole.existed_phone();
		emprole.emprole();
	}

	@Then("^Error displayed for phone number$")
	public void error_displayed_for_phone_number() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Addemployee emprole=new Addemployee();
		emprole.phone_error();
	}

	@When("^Enter existed email id$")
	public void enter_existed_email_id() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Addemployee emprole=new Addemployee();
		emprole.existed_email();
		emprole.emprole();
		
	}

	@Then("^Error displayed for email$")
	public void error_displayed_for_email() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Addemployee emprole=new Addemployee();
		emprole.email_error();
	}

}
