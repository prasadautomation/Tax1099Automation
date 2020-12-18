package steps;

import Fidentity_pages.Login;
import Fidentity_pages.Packagedelivery;
import Fidentity_pages.Sign_in;
import Fidentity_pages.WatchlistManagement;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class WatchlistmanagementSteps {
	
	@When("^Navigate to Watchlist management$")
	public void navigate_to_Watchlist_management() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		WatchlistManagement watchlist=new WatchlistManagement();
		watchlist.Navigation_watchlist();
	   
	}

	@When("^Click on create watchlist button$")
	public void click_on_create_watchlist_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		WatchlistManagement watchlist=new WatchlistManagement();
		watchlist.create_watchlist();
	}

	@Then("^Watchlist will be created successfully$")
	public void watchlist_will_be_created_successfully() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
	}
	@When("^Select one of the watchlist record$")
	public void select_one_of_the_watchlist_record() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		WatchlistManagement watchlist=new WatchlistManagement();
		watchlist.select_watchlist();
	}

	@When("^Clik on edit menuitem$")
	public void clik_on_edit_menuitem() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		WatchlistManagement watchlist=new WatchlistManagement();
		watchlist.menudropdown();
		watchlist.editmenu_item();
	}

	@When("^Edit details and save$")
	public void edit_details_and_save() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		WatchlistManagement watchlist=new WatchlistManagement();
		watchlist.edit_details();
		watchlist.edit_save();
	}

	@Then("^Watchlist details edited successfully$")
	public void watchlist_details_edited_successfully() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   
	}
	
	@When("^Clik on delete menuitem$")
	public void clik_on_delete_menuitem() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		WatchlistManagement watchlist=new WatchlistManagement();
		watchlist.menudropdown();
		watchlist.deletemenu_item();
	}
	
	@When("^Delete watchlist and confirm$")
	public void delete_watchlist_and_confirm() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		WatchlistManagement watchlist=new WatchlistManagement();
		watchlist.watchlist_delete_confirm();
	}
	@Then("^Watchlist details deleted successfully$")
	public void watchlist_details_deleted_successfully() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	  
	}
	
	@When("^Navigate to onlocation$")
	public void navigate_to_onlocation() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		WatchlistManagement watchlist=new WatchlistManagement();
		watchlist.onlocation_navigation();
	}

	@When("^Click on add watchlist$")
	public void click_on_add_watchlist() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		WatchlistManagement watchlist=new WatchlistManagement();
		watchlist.add_visitor_watchlist();
	}
	

	@When("^Select watch list type and save$")
	public void select_watch_list_type_and_save() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		WatchlistManagement watchlist=new WatchlistManagement();
		watchlist.select_watchlist_save();
	}

	@Then("^Added visitor towatch list successfully$")
	public void added_visitor_towatch_list_successfully() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
	}
	
	@When("^login to the assisted kiosk for onlocation$")
	public void login_to_the_assisted_kiosk_for_onlocation() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		WatchlistManagement watchlist=new WatchlistManagement();
		watchlist.Login_assisted_onlocation();
		
	}
	
	@When("^Navigate to onlocation visitors$")
	public void navigate_to_onlocation_visitors() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@When("^select one visitor record$")
	public void select_one_visitor_record() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		WatchlistManagement watchlist=new WatchlistManagement();
		watchlist.select_visitor_record();
	}

	@When("^update watchlist and save$")
	public void update_watchlist_and_save() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		WatchlistManagement watchlist=new WatchlistManagement();
		watchlist.update_watchlist();
	}

	@When("^goto admin portal$")
	public void goto_admin_portal() throws Throwable {
		
		
		
		
	}
	 
	@Then("^Watchlist updated successfully$")
	public void watchlist_updated_successfully() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   
	}
	
	@When("^create gatepass with watchlist visitor details$")
	public void create_gatepass_with_watchlist_visitor_details() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		WatchlistManagement watchlist=new WatchlistManagement();
		watchlist.verify_checkin();
		
	}

	@When("^login wathclist visitor through assisted kiosk$")
	public void login_wathclist_visitor_through_assisted_kiosk() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   
	}

	@When("^Restrict login for watchlist visitor$")
	public void restrict_login_for_watchlist_visitor() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   
	}

	@When("^Restricted successfully$")
	public void restricted_successfully() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   
	}

}
