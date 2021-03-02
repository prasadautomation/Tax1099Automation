package Object_repo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class WatchlistRepo {

	
	@FindBy(how=How.ID,using="settings_discover")
	public static WebElement settingsicon;
	@FindBy(how=How.ID,using="header_watchlistManagement")
	public static WebElement watchlistmenu;
	@FindBy(how=How.ID,using="watchlistManagement_createWatchlist")
	public static WebElement createwatchlistbutton;
	@FindBy(how=How.ID,using="watchlist_name")
	public static WebElement watchlistname;
	@FindBy(how=How.ID,using="watchlist_description")
	public static WebElement watchlistdescription;
	@FindBy(how=How.ID,using="watchlistManagement_watchListDropdown")
	public static WebElement watchlistactions;
	@FindBy(how=How.ID,using="watchlistManagement_watchListDropdown_edit")
	public static WebElement watchlisteditmenu;
	@FindBy(how=How.ID,using="watchlist_edit_name")
	public static WebElement watchlisteditname;
	@FindBy(how=How.ID,using="watchlist_edit_description")
	public static WebElement watchlisteditdescription;
	@FindBy(how=How.ID,using="watchlistManagement_editWatchlistModel_save")
	public static WebElement watchlisteditsavebutton;
	@FindBy(how=How.ID,using="watchlistManagement_watchListDropdown_delete")
	public static WebElement watchlistdeetemenu;
	@FindBy(how=How.ID,using="delete_watchlist_model")
	public static WebElement watchlistdeletemodal;
	@FindBy(how=How.ID,using="watchlistManagement_deleteWatchlistModel_yes")
	public static WebElement watchlistdeleteconfirm;
	@FindBy(how=How.ID,using="header_products")
	public static WebElement productsmenu;
	@FindBy(how=How.ID,using="header_switchProducts_vms")
	public static WebElement vmsmodule;
	@FindBy(how=How.ID,using="header_visitors")
	public static WebElement visitorsmenuicon;
	@FindBy(how=How.ID,using="header_onLocation")
	public static WebElement onlocationmenu;
	@FindBy(how=How.ID,using="update_watch_list_for_visitor")
	public static WebElement updatevisitor;
	@FindBy(how=How.ID,using="header_visitorPass")
	public static WebElement visitorpass;
	@FindBy(how=How.ID,using="gatepass_createVisitorPass")
	public static WebElement createvisitorpass;
	@FindBy(how=How.ID,using="invite_email")
	public static WebElement inviteemail;
	@FindBy(how=How.ID,using="invite_name")
	public static WebElement invitename;
	@FindBy(how=How.ID,using="invite_date")
	public static WebElement invitedate;
	@FindBy(how=How.ID,using="invite_time")
	public static WebElement invitetime;
	
	
	
	
	
	
}
