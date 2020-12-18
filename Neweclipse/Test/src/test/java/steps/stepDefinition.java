package steps;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Fidentity_pages.Login;
import Fidentity_pages.Sign_in;
import Fidentity_pages.myOrganization;

public class stepDefinition {
	

 
    @Given("^Sign in with credentials")

    public void Sign_in_with_credentials() throws Throwable {
    	
    
  
    	Login login2=new Login();
    	login2.LaunchBrowser();
    	    
    	Sign_in signin=new Sign_in();
    	signin.loginwith_cedentials();
  
  //this for sign in with fidentity
    	
    	    	     	
    	
    	}
    
    	

    @When("^User choose different plan from current plan$")
    public void User_choose_different_plan_from_current_plan() throws Throwable {
    	
      	myOrganization myorg=new myOrganization();
    	myorg.billingMgmt(); 
         
    }

    @Then("^A notification is needs to be displayed \"([^\"]*)\"$")
    public void a_notification_is_needs_to_be_displayed_something(String strArg1) throws Throwable {
         
    }

   

    @And("^with call of Action to Renew the Subscription$")
    public void with_call_of_action_to_renew_the_subscription() throws Throwable {
         
    }
      
    @Then("^User signed in successfully$")
    public void user_signed_in_successfully() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
       System.out.println("User signed in successfully");

}}
    
