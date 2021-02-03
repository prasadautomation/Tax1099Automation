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
		addempav.addemployee_button();
	   
	}

	@When("^Enter required fields$")
	public void enter_required_fields() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Addemployee addemp=new Addemployee();
		addemp.emp_fields();
		
	}
	
	@When("^Enter required fields with existed phone number$")
	public void Enter_required_fields_with_existed_phone_number() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Addemployee addemp=new Addemployee();
		//addemp.emp_fields();  
		addemp.empvalidation_existedphone();
		
	}
	
	@When("^Enter required fields with existed email$")
	public void Enter_required_fields_with_existed_email() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Addemployee addemp=new Addemployee();
		//addemp.emp_fields();  
		addemp.empvalidation_existedemail();
		
	}
	
	
	@When("^Click on add button$")
	public void Click_on_add_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	//	Addemployee emprole=new Addemployee();
	//	emprole.emprole();
		Addemployee emprole=new Addemployee();
		//	emprole.admin_role();
			emprole.addemployee_update();
			emprole.addemp_confirmation();
	}
	
	@When("^Click on add for add employee$")
	public void Click_on_add_for_add_employee() throws Throwable {
	 
		Addemployee emprole=new Addemployee();
		
			emprole.addemployee_update();
			emprole.addemp_confirmation();
	}
	
	
	
	@When("^Select create login account$")
	public void Select_create_login_account() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Addemployee emprole=new Addemployee();
	//	emprole.admin_role();
		emprole.emp_loginaccount();
	}
	@When("^Select grant admin access$")
	public void Select_grant_admin_access() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Addemployee emprole=new Addemployee();
	emprole.grant_adminaccess();
	}
	
	
	
	
	
	@When("^Select admin checkbox and add$")
	public void select_admin_checkbox_and_add() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Addemployee emprole=new Addemployee();
	//	emprole.admin_role();
		emprole.addemployee_update();
	}
	  
	
	@Then("^Employee will be added successfully$")
	public void employee_will_be_added_successfully() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Addemployee emprole=new Addemployee();
		//	emprole.admin_role();
			emprole.addemp_confirmation();
	}
	
	@Then("^Admin will be added successfully$")
	public void Admin_will_be_added_successfully() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   
	}
	
	@Then("^Phone number validation will be displayed$")
	public void Phone_number_validation_will_be_displayed() throws Throwable {
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
	
	@When("^Validate required fileds$")
	public void validate_required_fileds() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Addemployee emprole=new Addemployee();
		emprole.field_validation();
	}

	@Then("^Add employee requieredfiled validation done successfully$")
	public void add_employee_requieredfiled_validation_done_successfully() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   
	}

}
