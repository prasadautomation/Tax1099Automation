package Object_repo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class EventsRepo {
	
	@FindBy(how = How.ID, using = "header_products")
	public static WebElement products;

	@FindBy(how=How.ID,using="header_products")
	public static WebElement productsicon;
	
@FindBy(how=How.ID,using= "header_switchProducts_events")
public static WebElement eventsproduct;
@FindBy(how=How.ID,using="viewEvents_create")
public static WebElement eventcreatebutton;
@FindBy(how=How.ID,using="event_name")
public static WebElement eventname;
@FindBy(how=How.ID,using="event_from_date")
public static WebElement eventfromdate;
@FindBy(how=How.ID,using="event_from_time")
public static WebElement eventfromtime;
@FindBy(how=How.ID,using="event_to_date")
public static WebElement eventtodate;
@FindBy(how=How.ID,using="event_location")
public static WebElement eventlocation;


@FindBy(how=How.ID,using="event_to_time")
public static WebElement eventtotime;
@FindBy(how=How.ID,using="addEvent_form_add")
public static WebElement eventadd;
@FindBy(how=How.ID,using="contact_phone")
public static WebElement contactphone;
@FindBy(how=How.ID,using="addEvent_createPopup_save")
public static WebElement eventadd_confirm;
@FindBy(how=How.ID,using="addEvent_form_cancel")
public static WebElement button_cancelevent;
@FindBy(how=How.ID,using="addEvent_form_reset")
public static WebElement reset_eventcreation;
@FindBy(how=How.ID,using="addEvent_form_update")
public static WebElement eventeditupdate;
@FindBy(how=How.ID,using="addEvent_form_cancel")
public static WebElement editeventcancel;
@FindBy(how=How.ID,using="addEvent_form_reset")
public static WebElement editeventreset;
@FindBy(how=How.ID,using="addEvents_banner_moreActions")
public static WebElement banneractionsbutton;
@FindBy(how=How.ID,using="viewEvents_banner_changeTheme")
public static WebElement changebannermenu;
@FindBy(how=How.ID,using="addEvents_custom_banner")
public static WebElement browsecustombanner;
@FindBy(how=How.ID,using="addEvent_bannerThemePopup_save")
public static WebElement savecustomebanner;
@FindBy(how=How.ID,using="defualt_banner_tab")
public static WebElement dafaultbannertab;
@FindBy(how=How.ID,using="addEvent_bannerThemePopup_reset")
public static WebElement resetcustombanner;
@FindBy(how=How.ID,using="addEvent_bannerThemePopup_cancel")
public static WebElement cancelcustombanner;
@FindBy(how=How.ID,using="header_event_participants")
public static WebElement particpantsmenu;
@FindBy(how=How.ID,using="viewParticipants_add")
public static WebElement addparticipantsbutton;
@FindBy(how=How.ID,using="first_name")
public static WebElement firstname_participant;
@FindBy(how=How.ID,using="phone_number")
public static WebElement phonenumber_participant;
@FindBy(how=How.ID,using="email")
public static WebElement email_participant;
@FindBy(how=How.ID,using="viewParticipants_form_add")
public static WebElement add_participant;
@FindBy(how=How.ID,using="viewParticipants_addPrompt_add")
public static WebElement addparticipantprompt;



	
	
	
}


