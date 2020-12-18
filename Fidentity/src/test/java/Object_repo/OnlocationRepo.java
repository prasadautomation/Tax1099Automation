package Object_repo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class OnlocationRepo {
	
	@FindBy(how=How.ID,using="header_products")
	public static WebElement productsicon;

	@FindBy(how=How.ID,using="header_switchProducts_vms")
	public static WebElement VMSmenu;
	
	@FindBy(how=How.ID,using="header_onLocation")
	public static WebElement ONlocationmenu;
	@FindBy(how=How.ID,using="checkoutModal")
	public static WebElement checkoutmodal;
	@FindBy(how=How.ID,using="locate_checkoutModal_yesCheckout_")
	public static WebElement confirmcheckout;
	@FindBy(how=How.ID,using="locate_checkoutModal_noCancel_")
	public static WebElement cancelcheckout;
	@FindBy(how=How.ID,using="watchlist_change_modal")
	public static WebElement watchlistchangemodal;
	@FindBy(how=How.ID,using="update_watch_list_for_visitor")
	public static WebElement updatewatchlistvisitor;
	
	
	
	
}
