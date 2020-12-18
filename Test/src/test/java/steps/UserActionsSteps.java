package steps;

import Fidentity_pages.UserActions;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class UserActionsSteps {
	
	@Given("^Navigate to actiavte employee$")
	public void navigate_to_actiavte_employee() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		UserActions useractions=new UserActions();
		useractions.userActions_nav();
	}

	@When("^Deactivate employee$")
	public void deactivate_employee() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		UserActions useractions=new UserActions();
		useractions.deactiavte_emp();
	}

	@Then("^Employee deactivated successfully$")
	public void employee_deactivated_successfully() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
	}
	@Given("^Navigate to deactivate employee$")
	public void navigate_to_deactivate_employee() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		UserActions useractions=new UserActions();
		useractions.userActions_nav();
	}

	@When("^Activate employee$")
	public void activate_employee() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		UserActions useractions=new UserActions();
		useractions.activate_emp();
	}

	@Then("^Employee activated successfully$")
	public void employee_activated_successfully() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@When("^Click on the status change button$")
	public void click_on_the_status_change_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		UserActions useractions=new UserActions();
		useractions.status_change();
	}

	@When("^Cancel the confirmation$")
	public void cancel_the_confirmation() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		UserActions useractions=new UserActions();
		useractions.cancel_status_change();
	}

	@Then("^Employee status change cancelled successefully$")
	public void employee_status_change_cancelled_successefully() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
	}
	@Given("^Navigate to reset password$")
	public void navigate_to_reset_password() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		UserActions useractions=new UserActions();
		useractions.userActions_nav();
	}

	@When("^Click on Change password icon$")
	public void click_on_Change_password_icon() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		UserActions useractions=new UserActions();
		useractions.click_change_password();
		
	}

	@When("^Enter the new password$")
	public void enter_the_new_password() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
	}

	@Then("^New password will be updated successfully$")
	public void new_password_will_be_updated_successfully() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   
	}
	@When("^Enter the password$")
	public void enter_the_password() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		UserActions useractions=new UserActions();
		useractions.enter_password();
	}

	@When("^cancel the password confirmation$")
	public void cancel_the_password_confirmation() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		UserActions useractions=new UserActions();
		useractions.cancel_confirmation();
	}

	@Then("^Cancelled the password change successfully$")
	public void cancelled_the_password_change_successfully() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
	}
	
	@Given("^Navigate to Delete employee$")
	public void navigate_to_Delete_employee() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		UserActions useractions=new UserActions();
		useractions.userActions_nav();
	}

	@When("^Click on delete$")
	public void click_on_delete() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		UserActions useractions=new UserActions();
		useractions.delete_action();
	}

	@When("^Confirm the deletion of emplyee$")
	public void confirm_the_deletion_of_emplyee() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		UserActions useractions=new UserActions();
		useractions.confirm_deletion();
	}

	@Then("^Employee deleted successfully$")
	public void employee_deleted_successfully() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
	}
	
	@When("^Cancel the deletion of User$")
	public void cancel_the_deletion_of_User() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		UserActions useractions=new UserActions(); 
		useractions.cancel_confirmation();
	}

	@Then("^User deletion cancelled successfully$")
	public void user_deletion_cancelled_successfully() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
	}
	@Given("^Navigate to Change of employee type$")
	public void navigate_to_Change_of_employee_type() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		UserActions useractions=new UserActions();
		useractions.userActions_nav();
	}

	@When("^Click on change account type$")
	public void click_on_change_account_type() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		UserActions useractions=new UserActions();
		useractions.user_account_type();
	}

	@When("^Select account type$")
	public void select_account_type() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
	}

	@When("^Confirm account type change$")
	public void confirm_account_type_change() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		UserActions useractions=new UserActions();
		useractions.confirm_account_change();
	}

	@Then("^Account type changed successfully$")
	public void account_type_changed_successfully() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   
	}
	
	@Given("^Navigate to logout icon$")
	public void navigate_to_logout_icon() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		UserActions useractions=new UserActions();
		useractions.logout_nav();
	}

	@Given("^Click on logout icon$")
	public void click_on_logout_icon() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	  
	}

	@When("^Confirm the logout$")
	public void confirm_the_logout() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		UserActions useractions=new UserActions();
		useractions.confirm_logout();
	}

	@Then("^User logged out successfully$")
	public void user_logged_out_successfully() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
	}

	@When("^Cancel the logout$")
	public void cancel_the_logout() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		UserActions useractions=new UserActions();
		useractions.Cancel_logout();
	}

	@Then("^User logout cancelled successfully$")
	public void user_logout_cancelled_successfully() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   
	}
	

}
