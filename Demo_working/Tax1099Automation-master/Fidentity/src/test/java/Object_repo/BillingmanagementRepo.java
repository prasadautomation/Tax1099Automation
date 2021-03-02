package Object_repo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class BillingmanagementRepo {
	
	@FindBy(how = How.ID, using = "header_myOrganisation")
	public static WebElement myorgicon;
	@FindBy(how = How.ID, using = "header_billingManagement")
	public static WebElement billingmenu;
	@FindBy(how = How.ID,using ="header_billingOverview")
	public static WebElement overview;
	@FindBy(how = How.ID,using ="header_billingDetails")
	public static WebElement billdetails;
	@FindBy(how = How.ID,using ="header_billingEstimate")
	public static WebElement billestimate;
	@FindBy(how = How.ID,using ="header_manageSubscription")
	public static WebElement managesubscription;
	@FindBy(how = How.ID,using ="manageSubscription_cancelSubscription")
	public static WebElement cancelsubscription;
	@FindBy(how = How.ID,using ="manageSubscription_cancelPrompt_no")
	public static WebElement notconfirmcancel;
	@FindBy(how = How.ID,using ="manageSubscription_chooseDifferentPlan")
	public static WebElement selectdifferentplan;
	@FindBy(how = How.ID,using ="choose-standard")
	public static WebElement choosestdbutton;
	@FindBy(how = How.ID,using ="choose-premium")
	public static WebElement choosepremiumplan;
	@FindBy(how = How.ID, using = "manageSubscription_continueSamePlan")
	public static WebElement chosesameplantrail;
	@FindBy(how = How.ID,using ="header_billingHistory")
	public static WebElement billhistory;
	@FindBy(how = How.ID,using ="changeSubscription_update")
	public static WebElement updatesubscription;
	@FindBy(how = How.ID,using ="changeSubscription_paymentStatus_ok")
	public static WebElement confirmchangesub;
	@FindBy(how = How.ID,using ="manageSubscription_reload")
	public static WebElement reloadbutton;
	@FindBy(how= How.ID,using="cardholdername")
	public static WebElement cardholdername;
	@FindBy(how = How.ID, using = "card-number")
	public static WebElement cardnumber;
	@FindBy(how = How.ID, using = "card-expiry")
	public static WebElement cardexpiry;
	
	@FindBy(how = How.ID, using = "agree_conditions")
	public static WebElement agreeconditions;
	@FindBy(how = How.ID, using = "cards_add_submit")
	public static WebElement submitcarddetails;
	@FindBy(how = How.ID, using = "billingDetails_card_submit")
	public static WebElement carddetailssubmit;
	@FindBy(how = How.ID, using = "billingDetails_card_edit")
	public static WebElement editcard;
	
	
	
	
	
	
}


