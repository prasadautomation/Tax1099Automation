package steps;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.junit.Cucumber;

import java.sql.ResultSet;

import org.junit.runner.RunWith;

import Fidentity_pages.DataBase_connection;
import Fidentity_pages.Login;
import Fidentity_pages.signUp;

@RunWith(Cucumber.class)
public class SignUp_steps {


    @Given("^Launch the fidentity portal$")
    public void launch_the_fidentity_portal() throws Throwable {
    	
    	
    	Login login2=new Login();
    	login2.LaunchBrowser();
 //login2.LaunchPortal(); for testing we are not using fidentity main page because for testing it is not created so we are using directly the testing onboard portal
    	login2.Launchtestportal();
    
    }
    @Given("^Sign in to the portal$")
    public void Sign_in_to_the_portal() throws Throwable {
    	
    	Login login2=new Login();
    	login2.LaunchBrowser();
 //login2.LaunchPortal(); for testing we are not using fidentity main page because for testing it is not created so we are using directly the testing onboard portal
    	login2.Launchtestportal();
    
    }

    @When("^Enter the required details for sign up$")
    public void enter_the_required_details_for_sign_up() throws Throwable {
        
    	
	signUp signup=new signUp();
    	
    	signup.requierd_fields();
        
    }

    @Then("^User signed up successfully$")
    public void user_signed_up_successfully() throws Throwable {
    	
    	System.out.println("Customer created successfully");
    	
    DataBase_connection db=new DataBase_connection();
		 db.dbconnection();
				
		ResultSet rs=db.stmt.executeQuery("SELECT customer_id,customer_code,email1 FROM test_checkon_central.customers order by id DESC LIMIT 1");
		System.out.print(rs);    
		
		while (rs.next()){
			String customer_id=rs.getString(1);
		System.out.println("Customer id:-"+customer_id);
		String OTP=rs.getString(2);
		System.out.println("OTP:-"+OTP);
		String username=rs.getString(3);
		System.out.println("User Name:-:-"+username);
		
        
    }}}






