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

		//Login login2=new Login();
    //	login2.LaunchBrowser();
		
		//login2.Launchtestportal();

	}
	@Given("^Launch the fidentity portal for signup$")
	public void launch_the_fidentity_portal_for_signup() throws Throwable {

		Login login2=new Login();
    	login2.LaunchBrowser();
		
		login2.Launchtestportal();

	}

	@Given("^Sign in to the portal$")
	public void Sign_in_to_the_portal() throws Throwable {

		Login login2 = new Login();
		login2.LaunchBrowser();
		// login2.LaunchPortal(); for testing we are not using fidentity main page
		// because for testing it is not created so we are using directly the testing
		// onboard portal
		login2.Launchtestportal();

	}

	@When("^Enter the required details and save$")
	public void Enter_the_required_details_and_save() throws Throwable {

		signUp signup = new signUp();

		signup.requierd_fields(); 
		signup.organization_details();
		signup.location_details();
		signup.logo_upload();

	}

	@When("^Enter the required details with field validations$")
	public void enter_the_required_details_with_field_validations() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		signUp signup = new signUp();

		signup.field_validations();
		
	}

	@Then("^All the field validations done successfully$")
	public void all_the_field_validations_done_successfully() throws Throwable {
		// Write code here that turns the phrase above into concrete actions

	}

	@When("^Login with otp and password$")
	public void Login_with_otp_and_password() throws Throwable {
		//signUp signup = new signUp();

		//signup.otp_login();

	}

	@Then("^User signed up successfully$")
	public void user_signed_up_successfully() throws Throwable {

		System.out.println("Customer created successfully");

	}
	@Given("^Launch the login portal$")
	public void launch_the_login_portal() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Login login=new Login();
		login.LaunchBrowser();
		signUp signup=new signUp();
		signup.Login_page();
	   
	}

	@When("^Enter required details$")
	public void enter_required_details() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		signUp signup=new signUp();
		signup.login_required_fields();
	}

	@When("^click on forgot password$")
	public void click_on_forgot_password() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		signUp signup=new signUp();
		signup.click_forgot_password();
	}

	@When("^enter otp along with other fields$")
	public void enter_otp_along_with_other_fields() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	 signUp signup=new signUp();
	 signup.otp_login();
	 signup.newpasswords();

	}
	@When("^enter otp$")
	public void enter_otp() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	 signUp signup=new signUp();
	 signup.otp_login();

	}
	
	@When("^Check password validations$")
	public void Check_password_validations()throws Throwable{
		
		signUp signup=new signUp();
		signup.passwordvalidatipons();
		
		
	}
	@Given("^Complete few steps of signup flow$")
	public void complete_few_steps_of_signup_flow() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		signUp signup=new signUp();
		signup.signup_fewsteps();
	}

	@When("^Stop the checkin flow and exit from the portal$")
	public void stop_the_checkin_flow_and_exit_from_the_portal() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		signUp signup=new signUp();
		signup.windowclose();
	}

	@When("^Open the portal and login with credentials$")
	public void open_the_portal_and_login_with_credentials() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		signUp signup=new signUp();
		signup.resume_signup();
	}

	@Then("^User can able to resume signup flow$")
	public void user_can_able_to_resume_signup_flow() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   
	}

	@Then("^Signup flow will be completed$")
	public void signup_flow_will_be_completed() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   
	}
	

	@Then("^Forgot password done successfully$")
	public void forgot_password_done_successfully() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   
	}
}
