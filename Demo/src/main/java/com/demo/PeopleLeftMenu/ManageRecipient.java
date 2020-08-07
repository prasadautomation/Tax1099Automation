/**
 * 
 */
package com.demo.PeopleLeftMenu;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demo.Base.base;
import com.demo.actiondriver.Action;
import com.demo.Base.base;

/**
 * @author Prasad
 *
 */
public class ManageRecipient extends base{


	Action action= new Action();
	
	@FindBy(id="ddlPayer_chosen")
	WebElement SelectPayer;
	
	@FindBy(xpath="//*[@id=\"import_drop_zone\"]/div[1]/a")
	WebElement ClickHere;
	
	@FindBy(id="upload")
	WebElement SelectFiles;
	
	@FindBy(id="Next")
	WebElement Bulkupload;
	
	@FindBy(id="btnAddPayee")
	WebElement AddRecipient;
	
	@FindBy(id="btnExportToExcel")
	WebElement ExportToExcel;
	
	public ManageRecipient() {
		PageFactory.initElements(driver, this);
	}
	public String ManageRecipientPageTitle() {
	String ManageRecipientPageTitle = driver.getTitle();	
	return ManageRecipientPageTitle;
	}
	
	public void clickOnAddRecipient() throws Throwable {
		Action action=new Action();
		action.click(driver, AddRecipient);
	}
	public void SelectPayer() {
		
	}
}



























