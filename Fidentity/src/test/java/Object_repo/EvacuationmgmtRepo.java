package Object_repo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class EvacuationmgmtRepo {

	@FindBy(how = How.ID, using = "settings_discover")
	public static WebElement settingsidemenu;
	@FindBy(how = How.ID, using = "header_emergencyEvacuation")
	public static WebElement evacuationmenu;
	
	@FindBy(how = How.ID, using = "header_evacuationManagement")
	public static WebElement evacuationcreate;
	@FindBy(how = How.ID, using = "ee_type")
	public static WebElement emergencytype;
	@FindBy(how = How.ID, using = "ee_notification")
	public static WebElement notificationdesc;
	@FindBy(how = How.ID, using = "evacuationManagement_createAlertModel_save")
	public static WebElement newevacuationsave;
	@FindBy(how = How.ID, using = "evacuationManagement_creatNewNotification")
	public static WebElement evacutionnextnotification;
	@FindBy(how = How.ID, using = "evacuationManagement_importFromOtherLocation")
	public static WebElement evacutionimportnotification;
	@FindBy(how = How.ID, using = "evacuationManagement_noAlerts_importFormOtherLocation")
	public static WebElement noalertsevacutionimportnotification;
	@FindBy(how = How.ID, using = "import_alert_model")
	public static WebElement importalertmodel;
	@FindBy(how = How.ID, using = "evacuationManagement_importAlertModel_dropdown")
	public static WebElement importalertmodeldropdown;
	@FindBy(how = How.XPATH, using = "//form[@id='import_evac_list']//table//tbody//tr//td//input")
	public static WebElement importnotificationcheckbox;
	@FindBy(how = How.ID, using = "evacuationManagement_importAlertModel_import")
	public static WebElement importbutton;
	@FindBy(how = How.ID, using = "evacuationManagement_alert_dropdown")
	public static WebElement alerteditdeletemenu;
	@FindBy(how = How.ID, using = "evacuationManagement_alert_delete")
	public static WebElement alertdelete;
	@FindBy(how = How.ID, using = "evacuationManagement_deleteAlertModel_yes")
	public static WebElement deleteconfirmation;
	@FindBy(how = How.ID, using = "evacuationManagement_deleteAlertModel_no")
	public static WebElement canceldeleteconfirmation;
	@FindBy(how = How.ID, using = "evacuationManagement_alert_edit")
	public static WebElement alertedit;
	@FindBy(how = How.ID, using = "evacuationManagement_editAlertModel_save")
	public static WebElement editedalertsave;
	
	
	
	
}
