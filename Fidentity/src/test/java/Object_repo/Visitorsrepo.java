package Object_repo;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class Visitorsrepo {
	
	@FindBy(how=How.ID,using="header_visitors")
	public static WebElement visitorsicon;
	@FindBy(how=How.ID,using="header_visitorPass")
	public static WebElement visitorpass;
	@FindBy(how=How.ID,using="gatepass_createVisitorPass")
	public static WebElement createvisitorbutton;
	@FindBy(how=How.ID,using="generate_gatepss_form")
	public static WebElement visitorpassform;
	//@FindBy(how=How.XPATH,using="//form[@id='generate_gatepss_form']//div//div//div//div//input")
	//public static WebElement workflowdropdown;
	@FindBy(how=How.ID,using="checkin_type")
	public static  WebElement  chososecheckintype; 
	@FindBy(how=How.ID,using="invite_email")
	public static  WebElement  visitioremail; 
	@FindBy(how=How.ID,using="invite_name")
	public static  WebElement  visitiorname; 
	@FindBy(how=How.ID,using="invite_phone")
	public static  WebElement  visitorphone; 
	@FindBy(how=How.ID,using="invite_date")
	public static  WebElement  invitedate;
	@FindBy(how=How.ID,using="invite_time")
	public static  WebElement  invitetime;
	@FindBy(how=How.ID,using="gatepass_createVisitorModal_create")
	public static  WebElement  createvisitorpass;
	@FindBy(how=How.ID,using="gatepass_createVisitorModal_reset")
	public static  WebElement  resetpass;
	@FindBy(how=How.ID,using="gatepass_createVisitorModal_cancel")
	public static  WebElement  cancelvisitorpass;
	@FindBy(how=How.ID,using="gatepass_filterByStatus")
	public static  WebElement  statusfilter;
	@FindBy(how=How.ID,using="gatepass_deletePass_yes")
	public static  WebElement  deletepassconfirm;
	@FindBy(how=How.ID,using="gatepass_resendPass_yes")
	public static  WebElement  resendpassconfirm;
	
	
	
	

}
