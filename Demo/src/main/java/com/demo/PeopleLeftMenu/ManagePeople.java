package com.demo.PeopleLeftMenu;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demo.Base.base;
import com.demo.actiondriver.Action;

public class ManagePeople extends base{

	@FindBy(id="//p[contains(text(),'People')]")
	WebElement People;
	
	@FindBy(id="//a[contains(text(),'Manage Payer')]")
	WebElement ManagePayer;
	
	@FindBy(id="//input[@id='btnAddEditPayer']")
	WebElement AddPayer;
	
//	@FindBy(id="//a[contains(text(),'Manage Recipient')]")
	WebElement ManageRecipient;
	

	@FindBy(id="//a[contains(text(),'Copy Recipient')]")
	WebElement CopyRecipient;
	
		public ManagePeople() {
			PageFactory.initElements(driver, this);
		}
		public void ClickOnPeople() throws Throwable {
			Action action=new Action();
			action.click(driver, People);
		}
		public void ClickOnManagePayer() throws Throwable {
			Action action=new Action();
			action.click(driver, ManagePayer);
		}
		public void ClickOnAddPayer() throws Throwable {
			Action action=new Action();
			action.click(driver, AddPayer);
		}
		public void clickOnManageRecipient() throws Throwable {
			Action action=new Action();
			action.click(driver, ManageRecipient);
		}
		public void clickOnCopyRecipient() throws Throwable {
			Action action=new Action();
			action.click(driver, CopyRecipient);
		}

}







