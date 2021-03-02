package steps;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;


import Fidentity_pages.HomePage;


public class stepDefinition {
	

 
    @Given("^User logged in to application$")
    public void user_logged_in_to_application() throws Throwable {
   
    	HomePage login=new HomePage();
    	login.signIn();
    	login.openhomemage();
    	}
    
    	

    @When("^Subscription To be Expiry date is less than 14 days$")
    public void subscription_to_be_expiry_date_is_less_than_14_days() throws Throwable {
    	
    	
         
    }

    @Then("^A notification is needs to be displayed \"([^\"]*)\"$")
    public void a_notification_is_needs_to_be_displayed_something(String strArg1) throws Throwable {
         
    }

    @And("^Logged in usertype is Admin or Global Admin$")
    public void logged_in_usertype_is_admin_or_global_admin() throws Throwable {
         
    }

    @And("^with call of Action to Renew the Subscription$")
    public void with_call_of_action_to_renew_the_subscription() throws Throwable {
         
    }

}
    
