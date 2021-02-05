package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import Fidentity_pages.Login;
import Fidentity_pages.Sign_in;
import Fidentity_pages.BillingManagement;

public class stepDefinition {

	@Given("^Sign in with credentials")
	public void Sign_in_with_credentials() throws Throwable {

		Login login2 = new Login();
		login2.LaunchBrowser();

		Sign_in signin = new Sign_in();
		signin.loginwith_credentials();

	}

	@Given("^Goto location managementpf$")
	public void goto_location_managementpf() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@When("^Edit location detailspf$")
	public void edit_location_detailspf() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	  
	}

	@Then("^Location details will be edited successfullypf$")
	public void location_details_will_be_edited_successfullypf() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   
	}
	@Given("^Navigate to manage Subscription")
	public void Navigate_to_manage_Subscription() throws Throwable {

		BillingManagement myorg=new BillingManagement();
		myorg.nav_billing();
	}
	
	@When("^Choose current plan$")
	public void choose_current_plan() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		BillingManagement myorg = new BillingManagement();
		myorg.billingMgmt_sameplan();
	}

	@When("^Enter required details and submit$")
	public void enter_required_details_and_submit() throws Throwable {
		// Write code here that turns the phrase above into concrete actions

	}
	
	
	
	@When("^Check the customer is in trail period$")
	public void Check_the_customer_is_in_trail_period() throws Throwable {
		// Write code here that turns the phrase above into concrete actions

	}
	@When("^Choose statndard monthly plan$")
	public void Choose_statndard_monthly_plan () throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		BillingManagement myorg = new BillingManagement();
		myorg.choose_stdmonthly_plan();
	}

	
	@When("^Choose statndard Yearly plan$")
	public void Choose_statndard_Yearly_plan () throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		BillingManagement myorg = new BillingManagement();
		myorg.choose_stdyearly_plan();
	}
	@When("^Choose premium Yearly plan$")
	public void Choose_premium_Yearly_plan () throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		BillingManagement myorg = new BillingManagement();
		myorg.choose_premium_yearly_plan();
	} 
	@When("^Click on update subscription$")
	public void click_on_update_subscription() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		//myOrganization myorg = new myOrganization();
		//myorg.choose_plan();
		
	}
	@When("^Choose any plan$")
	public void choose_any_plan() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		BillingManagement myorg = new BillingManagement();
		myorg.choose_plan();
	}

	@When("^Check account mandatory details$")
	public void check_account_mandatory_details() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		BillingManagement myorg = new BillingManagement();
		myorg.check_mandatory();
	}

	@When("^Check card details validations$")
	public void check_card_details_validations() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   
	}

	@Then("^Account details checked successfully$")
	public void account_details_checked_successfully() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   
	}

	@Then("^Same plan updated successfully$")
	public void Same_plan_updated_successfully() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("\n"+"Continue with same plan(Premium monthly) testing completed");
	}
	@Then("^Standard monthly Plan updated successfully$")
	public void Standard_monthly_Plan_updated_successfully() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("\n"+"Schedule standard monthly plan testing completed");
	}
	@Then("^Standard yearly Plan updated successfully$")
	public void Standard_yearly_Plan_updated_successfully() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("\n"+"Schedule standard yearly plan testing completed");
	}
	@Then("^Premium yearly Plan updated successfully$")
	public void Premium_yearly_Plan_updated_successfully() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("\n"+"Schedule premium yearly plan testing completed");
	}

	@When("^Choose upgrade plan$")
	public void choose_upgrade_plan() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		BillingManagement myorg = new BillingManagement();
		myorg.check_plan();
		myorg.upgrade_plan();
	    
	}

	@When("^Choose downgrade plan$")
	public void Choose_downgrade_plan() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		BillingManagement myorg = new BillingManagement();
		myorg.check_plan();
		myorg.downgrade_plan();
	}

	@When("^Choose basic plan$")
	public void Choose_basic_plan() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		BillingManagement myorg = new BillingManagement();
		myorg.check_plan();
		myorg.trailtobasic();
		
	}
	@Then("^Plan will be upgraded successfully$")
	public void plan_will_be_upgraded_successfully() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   
	}
	
}
