package com.demo.ExcelImportGridPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demo.Base.base;
import com.demo.FormsLeftmenu.SubmitForms;
import com.demo.actiondriver.Action;

public class MISCExcelImportGridPage extends base{

	@FindBy(xpath="//button[@class='multiselect dropdown-toggle btn btn-default']")
	WebElement PayerDropdown;
	
	@FindBy(xpath="//label[contains(text(),'Select all')]")
	WebElement PayerDropdownSelectAll;
	
	@FindBy(xpath="//div[@class='payer_txtfields']//span")
	WebElement Taxyear;
	
	@FindBy(xpath="//input[@id='selectAllCheckbox']")
	WebElement SelectAll;
	
	@FindBy(xpath="//select[@id='ddlBox']")
	WebElement ApplytoselectedRecipients;
	
	@FindBy(xpath="//input[@id='btnBack']")
	WebElement Back;
	
	@FindBy(xpath="//input[@id='btnbill']")
	WebElement Next;
	
	public MISCExcelImportGridPage() {
		PageFactory.initElements(getDriver(), this);
	}	
	public SubmitForms ClickNext() throws Throwable {
		Action action = new Action();
		action.click(getDriver(), Next);
		return new SubmitForms();
	}
}














