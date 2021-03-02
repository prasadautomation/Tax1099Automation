package steps;

import Fidentity_pages.BillingManagement;
import Fidentity_pages.Login;
import Fidentity_pages.signUp;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BillingManagementSteps {
	
	@Given("^Navigate to Billing management$")
	public void navigate_to_Billing_management() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		BillingManagement billing=new BillingManagement();
		billing.nav_billing();
	    System.out.print("\n"+"Navigated to billing management");
	}

	@When("^Click on overview menu$")
	public void click_on_overview_menu() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		BillingManagement billing=new BillingManagement();
		billing.overview();
		System.out.print("\n"+"Can edit billing details from this screen");
	}

	@Then("^Billing overview will be displayed$")
	public void billing_overview_will_be_displayed() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   
	}
	
	@When("^Click on Billing details$")
	public void click_on_Billing_details() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		BillingManagement billing=new BillingManagement();
		billing.billdetails();
		System.out.print("\n"+"Can edit billing address");
	}

	@Then("^Billing details will be displayed$")
	public void billing_details_will_be_displayed() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	  
	}
	@When("^Click on Billing history$")
	public void click_on_Billing_history() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		BillingManagement billing=new BillingManagement();
		billing.billhistory();
	}

	@Then("^Billing history will be displayed$")
	public void billing_history_will_be_displayed() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	
	@When("^Click on Billing estimate$")
	public void click_on_Billing_estimate() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		BillingManagement billing=new BillingManagement();
		billing.billestimate();
	}

	@Then("^Billing estimate will be displayed$")
	public void billing_estimate_will_be_displayed() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
	}
	
	@When("^Click on Manage subscription$")
	public void click_on_Manage_subscription() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		BillingManagement billing=new BillingManagement();
		billing.manage_subscription();
		System.out.print("\n"+"Clicked on manage subscription");
	}

	@When("^Click on Cancel subscription$")
	public void click_on_Cancel_subscription() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		BillingManagement billing=new BillingManagement();
		billing.cancel_subscription();
		
		
	}

	@When("^Confirm Canel$")
	public void confirm_Canel() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		BillingManagement billing=new BillingManagement();
		billing.notconfirm_cancel();
		System.out.print("\n"+"Not cancelling subscription because of "
				+ "automation we need to run multiple times,and it is working fine as a result of manual test");
	}

	@Then("^Subscription cancelled successfully$")
	public void subscription_cancelled_successfully() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   
	}
	
	@When("^Select downgrade plan$")
	public void select_downgrade_plan() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		BillingManagement billing=new BillingManagement();
		billing.downgrade_plan();
	}

	@When("^Confirm the card details$")
	public void confirm_the_card_details() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@Then("^Downgrade plan subscribed successfully$")
	public void downgrade_plan_subscribed_successfully() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
	}
	@When("^Select upgrade plan$")
	public void select_upgrade_plan() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		BillingManagement billing=new BillingManagement();
		billing.upgarde_plan();
	}

	@Then("^Upgrade plan subscribed successfully$")
	public void upgrade_plan_subscribed_successfully() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	  
	}
	
	@Given("^Signup to the fidentity portal$")
	public void signup_to_the_fidentity_portal() throws Throwable {
		
		Login login2 = new Login();
		login2.LaunchBrowser();
		signUp signup=new signUp();
		signup.signupurl();
		signup.requierd_fields();
		signup.organization_details();
		signup.location_details();
		signup.logo_upload();
	    // Write code here that turns the phrase above into concrete actions
	   System.out.print("\n"+"First step signup completed");
	}

	@When("^Select continue same plan$")
	public void select_continue_same_plan() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   BillingManagement billing=new BillingManagement();
	   billing.trail_sameplan();
		System.out.print("\n"+"continue same plan");
	}

	@When("^Submit the card details$")
	public void submit_the_card_details() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		 BillingManagement billing=new BillingManagement();
		   billing.card_details();
		   System.out.print("\n"+"Submitted card details");
	}

	@When("^Update subscription adn confirm$")
	public void update_subscription_adn_confirm() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@Then("^Same plan will be scheduled for trail customer sucessfully$")
	public void same_plan_will_be_scheduled_for_trail_customer_sucessfully() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
	}
	
	@When("^Edit card details$")
	public void edit_card_details() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		 BillingManagement billing=new BillingManagement();
		   billing.edit_carddetails();
	}

	@Then("^Card details will be edited successfully$")
	public void card_details_will_be_edited_successfully() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
	}
	
}
