package steps;

import Fidentity_pages.Onlocation;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Onlocation_steps {
	
	@Given("^Navigate to Onlocation menu$")
	public void Navigate_to_Onlocation_menu() throws Throwable {
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
	
	@When("^Click on check out icon$")
	public void Click_on_check_out_icon() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Onlocation checkedin=new Onlocation();
	checkedin.checked_out();
		
				
	}
	@When("^Click on Add watch list icon of selected visitor$")
	public void click_on_Add_watch_list_icon_of_selected_visitor() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Onlocation checkedin=new Onlocation();
		checkedin.add_watchlist();
	}
	

	@When("^Select watch list from dropdown$")
	public void Select_watch_list_from_dropdown() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Onlocation checkedin=new Onlocation();
		checkedin.select_watchlist();
	}

	@When("^Confirm add wathlist of visitor$")
	public void confirm_add_wathlist_of_visitor() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@Then("^Added watch list successfully$")
	public void added_watch_list_successfully() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   
	}
	@When("^Confirm the check out of visitor$")
	public void confirm_the_check_out_of_visitor() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   
		Onlocation checkedin=new Onlocation();
		checkedin.confirm_checkout();
	}
	@When("^Cancel the check out of visitor$")
	public void cancel_the_check_out_of_visitor() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Onlocation checkedin=new Onlocation();
		checkedin.cancel_checkout();
	}

	@Then("^Checkout cancel done successfully$")
	public void checkout_cancel_done_successfully() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@Then("^Checked out done successfully$")
	public void checked_out_done_successfully() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
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
		 System.out.print("\n"+"Tested cancellation of extend time successfully");
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
