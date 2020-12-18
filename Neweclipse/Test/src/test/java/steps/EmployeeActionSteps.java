package steps;

import Fidentity_pages.EmployeeActions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class EmployeeActionSteps {
	
	@Given("^Navigate to edit employee$")
	public void navigate_to_edit_employee() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		EmployeeActions empactions=new EmployeeActions();
		empactions.employee_Actions_nav();
		
	}

	@When("^Validate mandatory fields$")
	public void Validate_mandatory_fields() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		  // Write code here that turns the phrase above into concrete actions
				EmployeeActions empactions=new EmployeeActions();
				empactions.edit_emp_validations();
				
	}
	@When("^Update edited details$")
	public void update_edited_details() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@When("^Edit required fields$")
	public void Edit_required_fields() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		EmployeeActions empactions=new EmployeeActions();
		empactions.emp_details();
	}
	
	@Then("^Employee details successfully edited$")
	public void employee_details_successfully_edited() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
	}
	@Then("^Mandatory fileds successfully Checked")
	public void Mandatory_fileds_successfully_Checked  () throws Throwable { 
	    // Write code here that turns the phrase above into concrete actions
	    
	}
	
	@Given("^Navigate to Delete employee$")
	public void navigate_to_Delete_employee() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		EmployeeActions empactions=new EmployeeActions();
		empactions.employee_Actions_nav();
	}

	
	
	
	@When("^Validate editable fields$")
	public void validate_editable_fields() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		EmployeeActions empactions=new EmployeeActions();
		empactions.fields_validation();
	}

	@Then("^Editable fields validate successfully$")
	public void editable_fields_validate_successfully() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   
	}
	 

}
