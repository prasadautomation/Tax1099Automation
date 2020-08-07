package com.demo.PeopleLeftMenu;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demo.Base.base;
import com.demo.actiondriver.Action;
import com.demo.Base.base;
public class ManagePayer extends base {

	Action action= new Action();
	
	@FindBy(id="btnAddEditPayer")
	WebElement AddPayer;
	
	@FindBy(id="btnDeletePayer")
	WebElement DeletePayer;
	
	@FindBy(id="btnAssignPayer")
	WebElement AssignPayertoUser;
	
	@FindBy(id="payerName")
	WebElement SearchPayer;
	

	@FindBy(id="upload")
	WebElement SelectFiles;
	
	@FindBy(xpath="//*[@id=\"import_drop_zone\"]/div[1]/a")
	WebElement ClickHere;
	
	@FindBy(id="Next")
	WebElement BulkUpload;
	
	public ManagePayer() {
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	
}
