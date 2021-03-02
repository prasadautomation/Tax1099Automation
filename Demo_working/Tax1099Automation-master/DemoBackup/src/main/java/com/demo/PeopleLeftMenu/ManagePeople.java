package com.demo.PeopleLeftMenu;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demo.Base.base;
import com.demo.actiondriver.Action;

public class ManagePeople extends base{

	@FindBy(xpath="//p[contains(text(),'People')]")
	WebElement People;
	
	@FindBy(xpath="//a[contains(text(),'Manage Payer')]")
	WebElement ManagePayer;
	
	@FindBy(xpath="//input[@id='btnAddEditPayer']")
	WebElement AddPayer;
	
//	@FindBy(id="//a[contains(text(),'Manage Recipient')]")
	WebElement ManageRecipient;
	

	@FindBy(xpath="//a[contains(text(),'Copy Recipient')]")
	WebElement CopyRecipient;
	
		public ManagePeople() {
			PageFactory.initElements(getDriver(), this);
		}
		public void ClickOnPeople() throws Throwable {
			Action action=new Action();
			action.click(getDriver(), People);
		}
		public void ClickOnManagePayer() throws Throwable {
			Action action=new Action();
			action.click(getDriver(), ManagePayer);
		}
		public void ClickOnAddPayer() throws Throwable {
			Action action=new Action();
			action.click(getDriver(), AddPayer);
		}
		public void clickOnManageRecipient() throws Throwable {
			Action action=new Action();
			action.click(getDriver(), ManageRecipient);
		}
		public void clickOnCopyRecipient() throws Throwable {
			Action action=new Action();
			action.click(getDriver(), CopyRecipient);
		}

}







