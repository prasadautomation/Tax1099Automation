
package steps;

import Fidentity_pages.Integrations;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class IntegrationSteps {

	@When("^Go to Integrations$")
	public void go_to_Integrations() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Integrations integrationsnavigation=new Integrations();
		integrationsnavigation.integrationsnav();
	}

	@When("^Enable the Gsuite$")
	public void enable_the_Gsuite() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		Integrations integrationsg=new Integrations();
		integrationsg.gsuiteenable();
	   System.out.println("gsuite enabled");
	  
	}

	@Then("^Gsuite will be successfully enabled$")
	public void gsuite_will_be_successfully_enabled() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		 System.out.println("gsuite will be successfully enabled");
	}
	
	@When("^Enable the Active directory$")
	public void enable_the_Active_directory() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Integrations integrationsdir=new Integrations();
		integrationsdir.activeDirectory();
	}

	@Then("^Active directory will be successfully enabled$")
	public void active_directory_will_be_successfully_enabled() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   System.out.println("Successfullt enabled active directory");
	}

	@When("^Any integration is in active state$")
	public void any_integration_is_in_active_state() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Integrations integrationsactive=new Integrations();
		integrationsactive.activeIntegration();
	}

	@When("^activate other integartion$")
	public void activate_other_integartion() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@Then("^Dispay the message$")
	public void dispay_the_message() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	  
	}
	
	@When("^Goto employee list$")
	public void goto_employee_list() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Integrations intemplist=new Integrations();
		 intemplist.employeelist();
	}

	@Then("^Dispay last synced date$")
	public void dispay_last_synced_date() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	  
	}
}
