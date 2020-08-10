package com.demo.NECformsLIST;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demo.Base.base;
import com.demo.FormsLeftmenu.SubmitForms;

public class NECformTaxyear2020 extends base{

	@FindBy(xpath="//a[@class='current']")
	WebElement Singlefiling;
	
	@FindBy(xpath="//a[contains(text(),'Import Bulk Data')]")
	WebElement ImportBulkData;
	
	@FindBy(xpath="//input[@id='Correctedreturn']")
	WebElement Corrected;
	
	@FindBy(xpath="//span[@class='form_head_num']")
	WebElement OMBno;
	
	@FindBy(xpath="//select[@id='ddlTaxYear']")
	WebElement SelectTaxYear;
	
	@FindBy(xpath="//input[@id='NonEmployeeComp']")
	WebElement Box1field;
	
	@FindBy(xpath="//input[@id='FederalTax']")
	WebElement Box4field;
	
	@FindBy(xpath="")
	WebElement Fatcacheckbox;
	
	@FindBy(xpath="")
	WebElement secondTINcheckbox;
	
	@FindBy(xpath="")
	WebElement AccountNumberfield;
	
	@FindBy(xpath="//input[@id='StateWithHeld1']")
	WebElement statetaxwithheldamount5a;
	
	@FindBy(xpath="//input[@id='StateWithHeld2']")
	WebElement statetaxwithheldamount5b;
	
	@FindBy(xpath="//select[@id='PayerStateName1']")
	WebElement payerstate1;
	
	@FindBy(xpath="//select[@id='PayerStateName2']")
	WebElement payerstate2;
	
	@FindBy(xpath="//input[@id='PayerStateId1']")
	WebElement payerstateid1;
	
	@FindBy(xpath="//input[@id='PayerStateId2']")
	WebElement payerstateid2;
	
	@FindBy(xpath="//input[@id='StateIncome1']")
	WebElement payerstateincome1;
	
	@FindBy(xpath="//input[@id='StateIncome2']")
	WebElement payerstateincome2;
	
	@FindBy(xpath="//input[@id='btnSaveContinue']")
	WebElement Saveandcontinue;
	
	@FindBy(xpath="//input[@id='btnSaveAddNewSame']")
	WebElement Saveandaddnew1099NEC;
	
	@FindBy(xpath="//input[@id='btnSaveAddNewForm']")
	WebElement SaveandAddnewform;
	
	@FindBy(xpath="//input[@class='red_button_big']")
	WebElement Cancel;
	
	public NECformTaxyear2020() {
		PageFactory.initElements(driver, this);
	}	
	public void CreateNEC2020Form() {
		String 
	}
	
}















