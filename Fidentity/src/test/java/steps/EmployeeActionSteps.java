package steps;

import Fidentity_pages.EmployeeActions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class EmployeeActionSteps {
	
	@Given("^Navigate to employee actions$")
	public void navigate_to_employee_actions() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		EmployeeActions empactions=new EmployeeActions();
		empactions.employee_Actions_nav();
		
	}

	
	@When("^confirm the delete action$")
	public void confirm_the_delete_action() throws Throwable {
		EmployeeActions empactions=new EmployeeActions();
		empactions.confirm_deletion();
	}
	
	@When("^Validate editable fields$")
	public void validate_editable_fields() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		EmployeeActions empactions=new EmployeeActions();
		empactions.fields_validation();
	}

	@When("^Click on delete employee$")
	public void click_on_delete_employee() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		EmployeeActions empactions=new EmployeeActions();
		empactions.delete_emp();
	}
	


	@Then("^Delete employee done successfully$")
	public void delete_employee_done_successfully() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   
	}
	@Given("^Navigate to edit employee$")
	public void navigate_to_edit_employee() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		EmployeeActions empactions=new EmployeeActions();
		empactions.employee_Actions_nav();
		
	}

	@When("^Validate edit employee mandatory fields$")
	public void Validate_edit_employee_mandatory_fields() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		  // Write code here that turns the phrase above into concrete actions
				EmployeeActions empactions=new EmployeeActions();
				empactions.edit_emp_validations();
				
	}
	@Then("^Employee details successfully edited$")
	public void employee_details_successfully_edited() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
	}
	@Given("^Navigate to Delete employee$")
	public void navigate_to_Delete_employee() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		EmployeeActions empactions=new EmployeeActions();
		empactions.employee_Actions_nav();
	}

	@When("^Cancel the delete employee action$")
	public void cancel_the_delete_employee_action() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		EmployeeActions empactions=new EmployeeActions();
		empactions.cancel_deletion();
	}

	@Then("^Cancelled delete employee action successfully$")
	public void cancelled_delete_employee_action_successfully() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
	}
	
	@When("^Click on deactivate employee$")
	public void click_on_deactivate_employee() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		EmployeeActions empactions=new EmployeeActions();
		empactions.deactivate_employee();
	}

	@When("^Confirm the deactivation$")
	public void confirm_the_deactivation() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		EmployeeActions empactions=new EmployeeActions();
		empactions.confim_statuschange();
	}
	
	@When("^Cancel the deactivation$")
	public void Cancel_the_deactivation() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		EmployeeActions empactions=new EmployeeActions();
		empactions.Cancel_statuschange();
	}

	@Then("^Employee deactivation done successfully$")
	public void employee_deactivation_done_successfully() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   
	}
	
	@Then("^Cancel deactivation of employee done successfully$")
	public void cancel_deactivation_of_employee_done_successfully() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	  
	}

}
