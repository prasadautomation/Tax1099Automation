package Object_repo;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class Locationmgmtrepo {
	
	@FindBy(how = How.ID, using = "header_myOrganisation")
	public static WebElement myorg;
	//my organization menu
	@FindBy(how = How.ID, using = "header_locationManagement")
	public static WebElement locationmanagementmenu;
	//location menu
	@FindBy(how = How.ID, using = "viewLocation_grid_edit_0")
	public static WebElement editicon;
	//edit iocn
	@FindBy(how = How.ID, using = "location_name")
	public static WebElement Locationname;
	
	@FindBy(how = How.ID, using = "location_address")
	public static WebElement locationaddress;
	
	@FindBy(how = How.ID, using = "locality")
	public static WebElement City;
	
	@FindBy(how = How.ID, using = "administrative_area_level_1")
	public static WebElement State;
	
	@FindBy(how = How.ID, using = "country")
	public static WebElement Country;
	
	@FindBy(how = How.ID, using = "viewLocation_editModal_update")
	public static WebElement Updatebutton;
	@FindBy(how=How.ID,using="viewLocation_grid_activate_1")
	public static WebElement activeInactivelocation;
	@FindBy(how=How.ID,using="viewLocation_grid_deactivate_1")
	public static WebElement deactivatelocation;
	@FindBy(how=How.ID,using="viewLocation_deactivateModal_deactivate")
	public static WebElement confirmdeactivation;
	@FindBy(how=How.ID,using="viewLocation_deactivateModal_cancel")
	public static WebElement cancelconfirmdeactivation;
	@FindBy(how=How.ID,using="viewLocation_activateModal_activate")
	public static WebElement confirmactivateInactiveloc;
	
	@FindBy(how=How.ID,using="viewLocation_grid_delete_1")
	public static WebElement deletelocation;
	@FindBy(how=How.XPATH,using="//div[@id='delete_location_modal']//label//span")
	public static WebElement acceptdelete;
	@FindBy(how=How.ID,using="viewLocation_deleteModal_delete")
	public static WebElement confirmdeletion;
	@FindBy(how=How.ID,using="from_date")
	public static WebElement fromdate;
	@FindBy(how=How.ID,using="to_date")
	public static WebElement todate;
	@FindBy(how=How.ID,using="viewReport")
	public static WebElement viewreport;
	@FindBy(how=How.ID,using="downloadReports_reset")
	public static WebElement resetdownloadreports;
	
	
	@FindBys(@FindBy(how = How.XPATH, using = "//form[@id='location_filter_form']/following-sibling::div//div//table//tbody//tr"))
	public static List <WebElement> Locationrecord;
	
	@FindBys(@FindBy(how = How.XPATH, using = "//form[@id='location_filter_form']/following-sibling::div//table//tbody//tr//td[1]//span"))
	public static List<WebElement> namevalue;
	
	@FindBy(how = How.XPATH, using = "//form[@id='location_filter_form']/following-sibling::div//table//tbody//tr//td[9]//span")
	public static List<WebElement> Statusvalue;
	
	@FindBy(how=How.ID,using="viewLocation_createLocation")
	public static WebElement createlocationbutton;
	@FindBy(how=How.ID,using="add_location_form")
	public static WebElement addlocationform;
	@FindBy(how=How.NAME,using="branch_name")
	public static WebElement addlocationname;
	@FindBy(how=How.ID,using="location_address")
	public static WebElement addlocationaddress;
	@FindBy(how=How.ID,using="locality")
	public static WebElement addlocationcity;
	@FindBy(how=How.ID,using="administrative_area_level_1")
	public static WebElement addlocationstate;
	@FindBy(how=How.ID,using="country")
	public static WebElement addlocationcountry;
	@FindBy(how=How.ID,using="utc_timezone")
	public static WebElement utctimezone;
	@FindBy(how=How.ID,using="addLocation_form_add")
	public static WebElement addlocationbutton;
	//*** confirmation of add button does not id*****************/
	@FindBy(how=How.ID,using="addLocation_addPopup_add")
	public static WebElement addlocationconfirmation;
	
	//@FindBy(how=How.XPATH,using="//a[contains(text(),'No,Cancel')]")
	//public static WebElement addlocationcancel;
	//addLocation_addPopup_add ----------------addlocationconfirmation id 
	//addLocation_addPopup_cancel-----------------addlocationcancel id 
	@FindBy(how=How.ID,using="buy_location")
	public static WebElement buylocation;
	@FindBy(how=How.ID,using="changeQuantity_base_upQuantity")
	public static WebElement incrementbaselicense;
	@FindBy(how=How.ID,using="changeQuantity_pay")
	public static WebElement paybutton;
	@FindBy(how=How.ID,using="changeQuantity_paymentStatus_ok")
	public static WebElement paidinfo;
	@FindBy(how=How.ID,using="viewLocation_inactiveLocationsPrompt_useThis")
	public static WebElement confirminactivelicense;
	@FindBy(how=How.XPATH,using="//input[contains(@id,'check_button')]")
	public static WebElement selectinactivelocation; 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
