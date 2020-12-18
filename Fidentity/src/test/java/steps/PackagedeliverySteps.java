package steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import Fidentity_pages.Packagedelivery;
import Fidentity_pages.Pendingcheckins;
import Fidentity_pages.WatchlistManagement;

public class PackagedeliverySteps {
	
	private String String;

	@When("^Navigate to Package delivery module$")
	public void navigate_to_Package_delivery_module() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Packagedelivery packagedel= new Packagedelivery();
		packagedel.navigate_packagedelivery();
	}

	@When("^Goto Kiosk management for create package kiosk$")
	public void goto_Kiosk_management_for_create_package_kiosk() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@When("^Click on create kiosk$")
	public void click_on_create_kiosk() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Packagedelivery packagedel= new Packagedelivery();
		packagedel.createPackageKiosk();
	}

	@When("^Enter required details and create$")
	public void enter_required_details_and_create() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Packagedelivery packagedel= new Packagedelivery();
		packagedel.kiosk_details();
		
	}

	@Then("^Package kiosk will be created successfully$")
	public void package_kiosk_will_be_created_successfully() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@Then("^Login to Package kiosk$")
	public void login_to_Package_kiosk() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Packagedelivery packagedel= new Packagedelivery();
		packagedel.kiosk_login();
	}

	@When("^Goto Store location menu$")
	public void goto_Store_location_menu() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
		Packagedelivery packagedel= new Packagedelivery();
		packagedel.storelocationmenu();
	}

	@When("^Click on Create store location$")
	public void click_on_Create_store_location() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   
		Packagedelivery packagedel= new Packagedelivery();
		packagedel.createstore_button();
	}

	@When("^Enter required details for create location$")
	public void enter_required_details_for_create_location() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Packagedelivery packagedel= new Packagedelivery();
		packagedel.store_details();
	}
	@When("^Goto kiosk management menu$")
	public void goto_kiosk_management_menu() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Packagedelivery packagedel= new Packagedelivery();
		packagedel.navigate_kioskmgmt();
	}

	@When("^Click on Edit option for one kiosk$")
	public void click_on_Edit_option_for_one_kiosk() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Packagedelivery packagedel= new Packagedelivery();
		packagedel.select_edit();
		
	}

	@When("^Edit details of kiosk and save$")
	public void edit_details_of_kiosk_and_save() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Packagedelivery packagedel= new Packagedelivery();
		packagedel.edit_details();
		packagedel.pwa_update();
	}
	
	@When("^Check validations for pwa edit$")
	public void check_validations_for_pwa_edit() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Packagedelivery packagedel= new Packagedelivery();
		packagedel.pwa_editvalidations();
	}
	
	@When("^Click on cancel button on edit modal$")
	public void click_on_cancel_button_on_edit_modal() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Packagedelivery packagedel= new Packagedelivery();
		packagedel.packagekiosk_editcancel();
	}
	@Then("^Pwa edit kiosk cancelled succcessfully$")
	public void pwa_edit_kiosk_cancelled_succcessfully() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    System.out.print("\n"+"Pwa edit kiosk cancelled succcessfully");
	}

	@Then("^Pwa edit validations checked succcessfully$")
	public void pwa_edit_validations_checked_succcessfully() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
	}
	
	@When("^Click on Dettach icon of any kiosk$")
	public void click_on_Dettach_icon_of_any_kiosk() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Packagedelivery packagedel= new Packagedelivery();
		packagedel.dettach_packagekiosk();
	}

	@When("^Confirm dettach kiosk$")
	public void confirm_dettach_kiosk() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Packagedelivery packagedel= new Packagedelivery();
		packagedel.confirm_packagekioskdettach();
	}
	@When("^Cancel dettach kiosk$")
	public void cancel_dettach_kiosk() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Packagedelivery packagedel= new Packagedelivery();
		packagedel.cancel_packagekioskdettach();
	}
	
	@When("^Click on delete icon of non-active package kiosk$")
	public void click_on_delete_icon_of_non_active_package_kiosk() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Packagedelivery packagedel= new Packagedelivery();
		packagedel.delete_nonactivepackagekiosk();
	}

	@When("^Confirm deletion of package kiosk$")
	public void confirm_deletion_of_package_kiosk() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Packagedelivery packagedel= new Packagedelivery();
		packagedel.confirm_deletenonactivekiosk();
	}

	@Then("^Non-active package kiosks deleted successfully$")
	public void non_active_package_kiosks_deleted_successfully() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
	}
	
	@When("^Cancel deletion of package kiosk$")
	public void cancel_deletion_of_package_kiosk() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Packagedelivery packagedel= new Packagedelivery();
		packagedel.cancel_deletenonactivekiosk();
	}

	@Then("^Pwa kiosk dettached succcessfully$")
	public void pwa_kiosk_dettached_succcessfully() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	  
	}

	@Then("^Package kiosk edited successfully$")
	public void package_kiosk_edited_successfully() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   
	}

	@When("^Click on Create and confirm to create store location$")
	public void click_on_Create_and_confirm_to_create_store_location() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Packagedelivery packagedel= new Packagedelivery();
		packagedel.save_store();
	}

	@Then("^Store location created successfully$")
	public void store_location_created_successfully() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   
	}
	

@When("^Select store actions$")
public void select_store_actions() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	Packagedelivery packagedel= new Packagedelivery();
	packagedel.store_actions_menu();
}
@When("^Select store which has no pending pickups and delete$")
public void select_store_which_has_no_pending_pickups_and_delete() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	Packagedelivery packagedel= new Packagedelivery();
	packagedel.select_store_from_list();
 
}
 
@When("^If store has non picked packages skip store for deletion$")
public void if_store_has_non_picked_packages_skip_store_for_deletion() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    
}

@When("^Confirm deletion$")
public void confirm_deletion() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    
}

@When("^Select store and click on delete$")
public void select_store_and_click_on_delete() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
   
}

@When("^If store has non picked packages transfer packages and delete$")
public void if_store_has_non_picked_packages_transfer_packages_and_delete() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	Packagedelivery packagedel= new Packagedelivery();
	packagedel.delete_store_with_packages();
}

@Then("^Required store location deleted successfully$")
public void required_store_location_deleted_successfully() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
   
}

@When("^Select store and click on edit$")
public void select_store_and_click_on_edit() throws Throwable {
	
	Packagedelivery packagedel= new Packagedelivery();
	packagedel.edit_store();
    // Write code here that turns the phrase above into concrete actions
    
}

@When("^Edit required fields and save$")
public void edit_required_fields_and_save() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    
}

@Then("^Store location details edited successfully$")
public void store_location_details_edited_successfully() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    
}

@When("^Check validations of create location$")
public void check_validations_of_create_location() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	Packagedelivery packagedel= new Packagedelivery();
	packagedel.createstore_validations();
}

@Then("^Validations checked successfully$")
public void validations_checked_successfully() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    
}

@When("^navigate to kiosk management$")
public void navigate_to_kiosk_management() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	Packagedelivery packagedel= new Packagedelivery();
	packagedel.navigate_kiosk_create();
	Pendingcheckins pendingcheckins=new Pendingcheckins();
	
	pendingcheckins.employee_list();
}
@When("^create assisted kisok$")
public void create_assisted_kisok() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	Packagedelivery packagedel= new Packagedelivery();
	packagedel.create_kiosk();

	packagedel.save_kiosk();
	packagedel.assistedkioskproceed();
	WatchlistManagement watchlist=new WatchlistManagement();
	watchlist.getadminwindowstring("");
	
}

@When("^login to the assisted kiosk$")
public void login_to_the_assisted_kiosk() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	Packagedelivery packagedel= new Packagedelivery();
	packagedel.Login_assisted();
	
}

@When("^Navigate to package delivery$")
public void navigate_to_package_delivery() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	Packagedelivery packagedel= new Packagedelivery();
	//packagedel.navigate_package_delivery();
	
}

@When("^Click on recieve package$")
public void click_on_recieve_package() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	Packagedelivery packagedel= new Packagedelivery();
	packagedel.receive_package();
}

@When("^Enter required details and save$")
public void enter_required_details_and_save() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	Packagedelivery packagedel= new Packagedelivery();
	packagedel.package_details();
	packagedel.packdetails_save();
	
}

@Then("^Package received successfully$")
public void package_received_successfully() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    
}

@When("^Select non pickedup delivery to pickup$")
public void select_non_pickedup_delivery_to_pickup() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	Packagedelivery packagedel= new Packagedelivery();
	packagedel.nonpicked_packages("", "");
	
}

@When("^Enter pickup code and confirm$")
public void enter_pickup_code_and_confirm() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    
}

@Then("^Package picked up successfully$")
public void package_picked_up_successfully() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
   
}

	
}
