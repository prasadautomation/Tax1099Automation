package Object_repo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PackagedeliveryRepo {
	
	
	@FindBy(how=How.ID,using="settings_discover")
	public static WebElement settingsicon;
	
	
	
	@FindBy(how=How.ID,using="header_products")
	public static WebElement productsicon;
	@FindBy(how=How.ID,using="header_switchProducts_package")
	public static WebElement packageproduct;
	@FindBy(how=How.ID,using="header_unlicencedKiosk")
	public static WebElement unlicencedkiosk;
	@FindBy(how=How.ID,using="kioskManagePwa_createKiosk")
	public static WebElement createkioskbutton;
	@FindBy(how=How.ID,using="alias_name")
	public static WebElement aliasnametext;
	@FindBy(how=How.ID,using="kioskManagePwa_addModal_create")
	public static WebElement packagekioskcreate;
	
	@FindBy(how=How.ID,using="kioskManagePwa_editModal_update")
	public static WebElement pwaeditupdate;
	
	@FindBy(how=How.ID,using="kioskManagePwa_editModalPrompt_proceed")
	public static WebElement pwaeditupdateprompt;
	
	@FindBy(how=How.ID,using="edit_pwa_device_confirm_modal")
	public static WebElement pwaeditupdatepromptmodal;
	
	
	
	@FindBy(how=How.ID,using="kioskManagePwa_editModal_cancel")
	public static WebElement packagekioskeditcancelbutton;
	
	@FindBy(how=How.ID,using="detach_pwa_device_confirm_modal")
	public static WebElement confirmmodaldettachpackagekiosk;
	
	@FindBy(how=How.ID,using="kioskManagePwa_detachModal_proceed")
	public static WebElement kioskManagePwadetachModalproceed ;
	@FindBy(how=How.ID,using="kioskManagePwa_detachModal_cancel")
	public static WebElement kioskManagePwadetachModalcancel ;
	
	@FindBy(how=How.ID,using="delete_pwa_device_confirm_modal")
	public static WebElement deletepwadeviceconfirmmodal ;
	
	@FindBy(how=How.ID,using="kioskManagePwa_deleteModal_cancel")
	public static WebElement kioskManagePwadeleteModalcancel ;
	
	@FindBy(how=How.ID,using="kioskManagePwa_deleteModal_delete")
	public static WebElement kioskManagePwadeleteModaldelete ;
	
	@FindBy(how=How.ID,using="kioskManagePwa_addModalPrompt_proceed")
	public static WebElement kioskproceed;
	@FindBy(how=How.ID,using="customer_code")
	public static WebElement sessioncustomercode;
	@FindBy(how=How.ID,using="device_sync_code")
	public static WebElement synccode;
	@FindBy(how=How.ID,using="assistedLogin_next")
	public static WebElement assistedlogin;
	@FindBy(how=How.ID,using="header_storeLocations")
	public static WebElement storelocationmenu;
	@FindBy(how=How.ID,using="storeLocation_createStore")
	public static WebElement createstorebutton;
	@FindBy(how=How.ID,using="store_name")
	public static WebElement storename;
	@FindBy(how=How.ID,using="store_address")
	public static WebElement storeaddress;
	@FindBy(how=How.ID,using="storeLocation_createStore_save")
	public static WebElement savestore;
	@FindBy(how=How.ID,using="storeLocation_createStore_save")
	public static WebElement storeactionsdropdown;
	@FindBy(how=How.ID,using="storeLocation_storeDropdown_delete")
	public static WebElement storedeleteitem;
	@FindBy(how=How.ID,using="storeLocation_deleteStoreLocation_yes")
	public static WebElement storedeleteconfirm;
	@FindBy(how=How.ID,using="transfer_package_modal")
	public static WebElement transfermodal;
	@FindBy(how=How.ID,using="storeLocation_transferPackage_cancel")
	public static WebElement tranferpackagecancel;
	@FindBy(how=How.ID,using="storeLocation_transferPackage_storeDropdown")
	public static WebElement tranferpackoption;
	@FindBy(how=How.ID,using="to_store_id")
	public static WebElement storelistdropdown;
	@FindBy(how=How.ID,using="storeLocation_transferPackage_save")
	public static WebElement tranferanddeletebutton;
	@FindBy(how=How.ID,using="storeLocation_transferPackageInformation_ok")
	public static WebElement transferokinfo;
	@FindBy(how=How.ID,using="transfer_package_information_modal")
	public static WebElement transferinformodal;
	@FindBy(how=How.ID,using="storeLocation_storeDropdown_edit")
	public static WebElement editmenuitem;
	@FindBy(how=How.ID,using="edit_store_name")
	public static WebElement editstorename;
	@FindBy(how=How.ID,using="edit_store_address")
	public static WebElement editstoreaddress;
	@FindBy(how=How.ID,using="storeLocation_editStore_save")
	public static WebElement saveeditedbutton;
	@FindBy(how=How.ID,using="storeLocation_editStore_cancel")
	public static WebElement canceleditbutton;
	@FindBy(how=How.ID,using="storeLocation_createStore_cancel")
	public static WebElement cancelcreatestore;
	@FindBy(how=How.ID,using="header_myOrganisation")
	public static WebElement myorgicon;
	@FindBy(how=How.ID,using="header_kioskManagement")
	public static WebElement kioskmangementmenu;
	@FindBy(how=How.ID,using="header_licencedKiosk")
	public static WebElement licencedkioskmenu;
	@FindBy(how=How.ID,using="kioskManage_createKiosk")
	public static WebElement createlicencekioskbutton;
	@FindBy(how=How.ID,using="device_branch")
	public static WebElement devicebranchdropdown;
	@FindBy(how=How.ID,using="alias_name")
	public static WebElement devicealiasname;
	@FindBy(how=How.ID,using="kiosk_type")
	public static WebElement selectkiosktype;
	@FindBy(how=How.ID,using="kioskManage_addModal_create")
	public static WebElement savekioskbutton;
	@FindBy(how=How.ID,using="kioskManage_addModalPrompt_proceed")
	public static WebElement assistedkioskproceed;
	@FindBy(how=How.ID,using="assistedSidebar_visitors")
	public static WebElement assisitedkioskvisitormenu;
	@FindBy(how=How.ID,using="add_device_modal")
	public static WebElement createassistedmodal;
	@FindBy(how=How.ID,using="assistedSidebar_packageDelivery")
	public static WebElement assistedpackagesidemenu;
	@FindBy(how=How.ID,using="packageDelivery_receivePackage")
	public static WebElement receivepackagebutton;
	@FindBy(how=How.ID,using="delivered_to")
	public static WebElement packdeliveredemployee;
	@FindBy(how=How.ID,using="edit_pwa_device_modal")
	public static WebElement pwaeditmodal;
	
	
		
	
	

}
