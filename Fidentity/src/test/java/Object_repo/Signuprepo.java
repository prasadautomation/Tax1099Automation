package Object_repo;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Signuprepo {

	@FindBy(how = How.ID, using = "full_name")
	public static WebElement personname;
	@FindBy(how = How.ID, using = "signin_email")
	public static WebElement personemail;
	@FindBy(how = How.ID, using = "password")
	public static WebElement signuppassword;
	
	@FindBy(how = How.ID, using = "signupPage_remindMe")
	public static WebElement newsignupbutton;
	@FindBy(how = How.ID, using = "subdomain")
	public static WebElement subdomain;
	@FindBy(how = How.ID, using = "organisation_name")
	public static WebElement organisationname;
	@FindBy(how = How.ID, using = "stepOne_nextButton")
	public static WebElement steponenextbutton;
	
@FindBy(how=How.ID,using="email_not_available")
public static WebElement existedemail;
@FindBy(how=How.ID,using="domain_available")
public static WebElement domainavailable;
@FindBy(how=How.ID,using="domain_not_available")
public static WebElement domainnotavailable;


	@FindBy(how = How.ID, using = "country-listbox")
	public static List<WebElement> countrylist;
	@FindBy(how = How.ID, using = "iti-item-in")
	public static WebElement india;
	@FindBy(how = How.ID, using = "person_phone")
	public static WebElement personphone;
	@FindBy(how = How.ID, using = "company_name")
	public static WebElement companyname;
	@FindBy(how = How.ID, using = "company_web_site")
	public static WebElement companywebsite;
	@FindBy(how = How.ID, using = "signupPage_startTrial")
	public static WebElement trailbutton;
	@FindBy(how = How.ID, using = "subdomain")
	public static WebElement subdomainname;
	@FindBy(how = How.ID, using = "domainSelection_checkAvailability")
	public static WebElement checksubdomainavailability;
	@FindBy(how = How.ID, using = "domainSelection_save")
	public static WebElement savedomain;
	@FindBy(how = How.ID, using = "branch_name")
	public static WebElement branchname;
	@FindBy(how = How.ID, using = "branch_location")
	public static WebElement branchlocation;
	@FindBy(how = How.ID, using = "address_line_2")
	public static WebElement addressline2;
	@FindBy(how = How.ID, using = "locality")
	public static WebElement city;
	@FindBy(how = How.ID, using = "administrative_area_level_1")
	public static WebElement state;
	@FindBy(how = How.ID, using = "country")
	public static WebElement country;
	@FindBy(how = How.ID, using = "postal_code")
	public static WebElement postalcode;
	@FindBy(how = How.ID, using = "utc_timezone")
	public static WebElement utctimezone;
	@FindBy(how = How.ID, using = "stepTwo_nextButton")
	public static WebElement steptwonextbutton;
	@FindBy(how = How.ID, using = "stepThree_doneButton")
	public static WebElement stepthreedonebutton;
	@FindBy(how = How.ID, using = "stepThree_skipButton")
	public static WebElement stepthreeskip;
	
	
	
	@FindBy(how = How.ID, using = "fileInput")
	public static WebElement logoupload;
	@FindBy(how = How.ID, using = "signup_button")
	public static WebElement signupbutton;
	@FindBy(how = How.ID, using = "otp")
	public static WebElement otp;
	@FindBy(how = How.ID, using = "password")
	public static WebElement password;
	@FindBy(how = How.ID, using = "cpassword")
	public static WebElement confirmpassword;
	@FindBy(how = How.ID, using = "login_cpasswordBlock_save")
	public static WebElement setpassword;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
