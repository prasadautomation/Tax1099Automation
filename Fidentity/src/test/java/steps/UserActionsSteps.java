package steps;

	import Fidentity_pages.EmployeeActions;
import Fidentity_pages.UserActions;
import cucumber.api.java.en.Given;
	import cucumber.api.java.en.Then;
	import cucumber.api.java.en.When;

	public class UserActionsSteps {
		
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
		
		/*@When("^confirm the delete action$")
		public void confirm_the_delete_action() throws Throwable {
		    // Write code here that turns the phrase above into concrete actions
			//EmployeeActions empactions=new EmployeeActions();
			//empactions.confirm_deletion();
		}*/
		
		@Then("^Mandatory fileds successfully Checked")
		public void Mandatory_fileds_successfully_Checked  () throws Throwable { 
		    // Write code here that turns the phrase above into concrete actions
		    
		}
		
		@Then("^Editable fields validate successfully$")
		public void editable_fields_validate_successfully() throws Throwable {
		    // Write code here that turns the phrase above into concrete actions
		   
		}
		 




	

	@Then("^Employee deleted successfully$")
	public void employee_deleted_successfully() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
	}


	@Then("^User deletion cancelled successfully$")
	public void user_deletion_cancelled_successfully() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
	}



	@When("^Select account type$")
	public void select_account_type() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
	}



	@Then("^Account type changed successfully$")
	public void account_type_changed_successfully() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   
	}
	
	

	@Given("^Click on logout icon$")
	public void click_on_logout_icon() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	  
	}

	

	@Then("^User logged out successfully$")
	public void user_logged_out_successfully() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
	}


	@Then("^User logout cancelled successfully$")
	public void user_logout_cancelled_successfully() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   
	}
	
	@Given("^Navigate to actiavte employee$")
	public void navigate_to_actiavte_employee() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		UserActions user=new UserActions();
		user.userActions_nav();
	}

	@When("^Deactivate employee$")
	public void deactivate_employee() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		UserActions user=new UserActions();
		user.deactiavte_emp();
	}
	@Then("^Changerole and reset password became disabled$")
	public void Changerole_and_reset_password_became_disabled()throws Throwable{
		
		
		
		
	}
	
	@Then("^Employee deactivated successfully$")
	public void employee_deactivated_successfully() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   
	}

	@Given("^Navigate to deactiavte employee$")
	public void navigate_to_deactiavte_employee() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		UserActions user=new UserActions();
		user.userActions_nav();
	}

	@When("^Activate employee$")
	public void activate_employee() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		UserActions user=new UserActions();
		user.activate_emp();
	}

	@Then("^Employee activated successfully$")
	public void employee_activated_successfully() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
	}
	@Given("^Navigate to Delete$")
	public void navigate_to_Delete() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		UserActions user=new UserActions();
		user.userActions_nav();
	}

	@When("^Click on delete$")
	public void click_on_delete() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		UserActions user=new UserActions();
		user.delete_action();
		
	}

	@When("^Confirm the deletion of employee$")
	public void confirm_the_deletion_of_employee() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		UserActions user=new UserActions();
		user.confirm_deletion();
	}
	
	@When("^Cancel the deletion of employee$")
	public void cancel_the_deletion_of_employee() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		UserActions user=new UserActions();
		user.cancel_deletion();
		
	}

	@Then("^Employee deletion cancelled successfully$")
	public void employee_deletion_cancelled_successfully() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   
	}
	
	@Given("^Navigate to changerole$")
	public void navigate_to_changerole() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		UserActions user=new UserActions();
		user.userActions_nav();
	}

	@When("^Click on changerole icon$")
	public void click_on_changerole_icon() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		UserActions user=new UserActions();
		user.changeroleicon();
		user.changeoption();
	}

	@When("^Save changes$")
	public void save_changes() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		UserActions user=new UserActions();
		user.savechange();
	}

	@Then("^Employee role changed successfully$")
	public void employee_role_changed_successfully() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
	}
	
	@When("^Cancel the changes$")
	public void cancel_the_changes() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		UserActions user=new UserActions();
		user.cancel_change_role();
	}

	@Then("^Employee changerole cancelled successefully$")
	public void employee_changerole_cancelled_successefully() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   
	}
	
	@Given("^Navigate to mark event admin$")
	public void navigate_to_mark_event_admin() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		UserActions user=new UserActions();
		user.userActions_nav();
	}

	@When("^Click on event admin icon$")
	public void click_on_event_admin_icon() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		UserActions user=new UserActions();
		user.mark_eventadmin();
	}

	@When("^Grant changes$")
	public void grant_changes() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		UserActions user=new UserActions();
		user.grant_eventadmin();
	}

	@Then("^Employee marked as event admin successfully$")
	public void employee_marked_as_event_admin_successfully() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
	}
	
	@Given("^Navigate to revoke event admin$")
	public void navigate_to_revoke_event_admin() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		UserActions user=new UserActions();
		user.userActions_nav();
	}

	@When("^Click on revoke event admin icon$")
	public void click_on_revoke_event_admin_icon() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		UserActions user=new UserActions();
		user.revoke_eventadmin();
		
	}

	@When("^Revoke event admin$")
	public void revoke_event_admin() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   
	}

	@Then("^Event admin revoked successfully$")
	public void event_admin_revoked_successfully() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
	}


}
