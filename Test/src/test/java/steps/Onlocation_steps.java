package steps;

import Fidentity_pages.Onlocation;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Onlocation_steps {
	
	@Given("^Go to Onlocation menu$")
	public void go_to_Onlocation_menu() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Onlocation onlocation=new Onlocation();
		onlocation.onlocation_nav();
	}

	@When("^Do extend for checked in record$")
	public void Do_extend_for_checked_in_record() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Onlocation checkedin=new Onlocation();
		checkedin.select_checkedin();
		Onlocation extend=new Onlocation();
		extend.extend_Time();
		
		System.out.println("Extended time successfully");
				
	}
	
	@When("^Select checked in record$")
	public void Select_checked_in_record() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Onlocation checkedin=new Onlocation();
		checkedin.select_checkedin();
		
				
	}
	
	@When("^Do extend cancel for checked in record$")
	public void Do_extend_cancel_for_checked_in_record() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Onlocation checkedin=new Onlocation();
		checkedin.select_checkedin();
		Onlocation extendcancel=new Onlocation();
		extendcancel.extend_cancel();
				
	}
	 
	    
	@When("^Do checkout the visitor$")
	public void do_checkout_the_visitor() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Onlocation checkout=new Onlocation();
		checkout.checked_out();
	}
	
	@When("^Cancel the checkout$")
	public void Cancel_the_checkout() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Onlocation checkoutcancel=new Onlocation();
		checkoutcancel.cancel_checkout();
	}
	
	 
	 @When("^conirm the checkout$")
		public void conirm_the_checkout() throws Throwable {
		    // Write code here that turns the phrase above into concrete actions
		 Onlocation checkoutconfirm=new Onlocation();
		 checkoutconfirm.confirm_checkout();
		}
	
	 @Then("^Checked out cancelled successfully$")
		public void Checked_out_cancelled_successfully() throws Throwable {
		    // Write code here that turns the phrase above into concrete actions
		 Onlocation successfulcancel=new Onlocation();
		 successfulcancel.cancel_successful();
		 
		
		}

	@Then("^Visitor checked out successfully$")
	public void visitor_checked_out_successfully() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		 Onlocation successfulcheckout=new Onlocation();
		 successfulcheckout.checkout_successfully();
	}
	
	 @Then("^Extend time cancelled$")
		public void Extend_time_cancelled() throws Throwable {
		    // Write code here that turns the phrase above into concrete actions
		 System.out.print("Cancelled extended time successfully");
		}
	 
	 
	 @Then("^Checked in time extended successfully$")
		public void Checked_in_time_extended_successfully() throws Throwable {
		    // Write code here that turns the phrase above into concrete actions
			 Onlocation successfulcheckout=new Onlocation();
			 successfulcheckout.checkout_successfully();
		}
	 
	 
	 
	 @When("^Click on extend check_in time$")
		public void Click_on_extend_check_in_time() throws Throwable {
		    // Write code here that turns the phrase above into concrete actions
		 Onlocation checkoutconfirm=new Onlocation();
		 checkoutconfirm.confirm_checkout();
		}
	 
	 @When("^select time and click_on extend$")
		public void select_time_and_click_on_extend() throws Throwable {
		    // Write code here that turns the phrase above into concrete actions
		 Onlocation checkoutconfirm=new Onlocation();
		 checkoutconfirm.confirm_checkout();
		}
	 
    
	 
	 
}
