package com.demo.ExcelImportMatchFieldPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demo.Base.base;
import com.demo.ExcelImportGridPages.MISCExcelImportGridPage;
import com.demo.actiondriver.Action;

public class MISCExcelImportMatchFieldsPage extends base{

	//PAYER's Name, Street Address, City, State, Zip code, and Telephone no.
	@FindBy(xpath="//select[@id='ddlPayer']")
	WebElement PPayerType;
	
	@FindBy(xpath="//select[@id='ddlPayerFirstName']")
	WebElement PFirstName;
	
	@FindBy(xpath="//select[@id='ddlPayerMiddleName']")
	WebElement PMiddleName;
	
	@FindBy(xpath="//select[@id='ddlPayerName']")
	WebElement PLastName;
	
	@FindBy(xpath="//select[@id='ddlPayerSuffix']")
	WebElement PSuffix;
	
	@FindBy(xpath="//select[@id='ddlPayerAddress1']")
	WebElement PAddress1;
	
	@FindBy(xpath="//select[@id='ddlPayerZip']")
	WebElement PZipcodeorForeignPostalcode;
	
	@FindBy(xpath="//select[@id='ddlPayerAddress2']")
	WebElement PLine2;
	
	@FindBy(xpath="//select[@id='ddlPayerCountry']")
	WebElement PCountry;
	
	@FindBy(xpath="//select[@id='ddlPayerCity']")
	WebElement PCity;
	
	@FindBy(xpath="//select[@id='ddlPayerPhone']")
	WebElement PPhoneNumber;
	
	@FindBy(xpath="//select[@id='ddlPayerState']")
	WebElement PState;
	
	@FindBy(xpath="//select[@id='ddlPayerEmail']")
	WebElement PEmailAddress;
	
	@FindBy(xpath="//select[@id='ddlPayerEmail1']")
	WebElement PStateId;
	
	@FindBy(xpath="//select[@id='ddlPTinType']")
	WebElement PayerTINType;
	
	@FindBy(xpath="//select[@id='ddlPayerTIN']")
	WebElement PayerTIN;
	
	@FindBy(xpath="//select[@id='ddlRTinType']")
	WebElement RecipientTINType;
	
	@FindBy(xpath="//select[@id='ddlPayeeTIN']")
	WebElement RecipientTIN;
	
	//RECIPIENT's Name, Street Address, City, State, Zip Code, and Telephone no.
	
	@FindBy(xpath="//select[@id='ddlPayee']")
	WebElement RecipientType;
	
	@FindBy(xpath="//select[@id='ddlAttentionTo1']")
	WebElement AttentionTO;
	
	@FindBy(xpath="//select[@id='ddlPayeeFirstName']")
	WebElement RFirstName;
	
	@FindBy(xpath="//select[@id='ddlPayeeMiddleName']")
	WebElement RMiddleName;
	
	@FindBy(xpath="//select[@id='ddlPayeeName']")
	WebElement RLastName;
	
	@FindBy(xpath="//select[@id='ddlPayeeSuffix']")
	WebElement RSuffix;
	
	@FindBy(xpath="//select[@id='ddlPayeeAddress1']")
	WebElement RAddress1;
	
	@FindBy(xpath="//select[@id='ddlPayeeZip']")
	WebElement RZipcodeorForeignPostalcode;
	
	@FindBy(xpath="//select[@id='ddlPayeeAddress2']")
	WebElement RAddress2;
	
	@FindBy(xpath="//select[@id='ddlPayeeCountry']")
	WebElement RCountry;
	
	@FindBy(xpath="//select[@id='ddlPayeeCity']")
	WebElement RCity;
	
	@FindBy(xpath="//select[@id='ddlPayeePhone']")
	WebElement RPhoneNumber;
	
	@FindBy(xpath="//select[@id='ddlPayeeState']")
	WebElement RState;
	
	@FindBy(xpath="//select[@id='ddlPayeeEmail']")
	WebElement REmailAddress;
	//AccountNumber
	@FindBy(xpath="//select[@id='ddlPayeeAccNo']")
	WebElement AccountNumber;
	
	@FindBy(xpath="//select[@id='FATCAfilingrequirement']")
	WebElement FATCAfilingRequirement;
	
	@FindBy(xpath="//select[@id='ddlA409Deferals']")
	WebElement Section15a409Adeferals;
	
	@FindBy(xpath="//select[@id='ddlA409Income']")
	WebElement Section15b409Aincome;
	
	//16. State tax withheld
	@FindBy(xpath="//select[@id='ddlStateTaxWH1']")
	WebElement Statetaxwithheld16a;
	
	@FindBy(xpath="//select[@id='ddlStateTaxWH2']")
	WebElement Statetaxwithheld16b;
	
	//17. State / Payer's state no.
	@FindBy(xpath="//select[@id='ddlPayerStateNo1']")
	WebElement State17a;
	
	@FindBy(xpath="//select[@id='ddlPayerState2']")
	WebElement State17b;
	
	@FindBy(xpath="//select[@id='ddlPayerStateNo2']")
	WebElement StateNo17a;
	
	@FindBy(xpath="//select[@id='ddlPayerStateNo21']")
	WebElement StateNo17b;
	
	//18. State income
	@FindBy(xpath="//select[@id='ddlStateIncome1']")
	WebElement StateIncome18a;
	
	@FindBy(xpath="//select[@id='ddlStateIncome2']")
	WebElement StateIncome18b;
	
	//Box Amounts
	@FindBy(xpath="//select[@id='ddlRent']")
	WebElement Box1;
	
	@FindBy(xpath="//select[@id='ddlRoyalities']")
	WebElement Box2;
	
	@FindBy(xpath="//select[@id='ddlIncome']")
	WebElement Box3;
	
	@FindBy(xpath="//select[@id='ddlFederalTax']")
	WebElement Box4;
	
	@FindBy(xpath="//select[@id='ddlFishing']")
	WebElement Box5;
	
	@FindBy(xpath="//select[@id='ddlMedical']")
	WebElement Box6;
	
	@FindBy(xpath="//select[@id='ddlNonEmployee']")
	WebElement Box7;
	
	@FindBy(xpath="//select[@id='ddlSubstitute']")
	WebElement Box8;
	
	@FindBy(xpath="//select[@id='ddlDirectSales']")
	WebElement Box9;
	
	@FindBy(xpath="//select[@id='ddlCorp']")
	WebElement Box10;
	
	@FindBy(xpath="//select[@id='ddlExcess']")
	WebElement Box13;
	
	@FindBy(xpath="//select[@id='ddlGross']")
	WebElement Box14;
	
	@FindBy(xpath="//input[@id='btnEditTaxYear']")
	WebElement ChangeTaxYear;
	
	@FindBy(xpath="//select[@id='ddlTaxYear']")
	WebElement TaxYearDropdown;
	
	@FindBy(xpath="//span[@class='form_head_num']")
	WebElement OMBNumber;
	
	@FindBy(xpath="//input[@class='red_button_big']")
	WebElement Cancel;
	
	@FindBy(xpath="//input[@id='btnSaveAddNewForm']")
	WebElement Next;
	
	public MISCExcelImportMatchFieldsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public MISCExcelImportGridPage ClickNext() throws Throwable {
		Action action = new Action();
		action.click(driver, Next);
		return new MISCExcelImportGridPage();
	}
	
	public MISCExcelImportMatchFieldsPage ClickCancel() throws Throwable {
		Action action = new Action();
		action.click(driver, Cancel);
		return new MISCExcelImportMatchFieldsPage();
}



}



















