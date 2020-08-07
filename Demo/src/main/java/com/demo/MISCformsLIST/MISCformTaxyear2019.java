/**
 * 
 */
package com.demo.MISCformsLIST;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demo.Base.base;
import com.demo.FormsLeftmenu.SubmitForms;
import com.demo.actiondriver.Action;

/**
 * @author Prasad
 *
 */
public class MISCformTaxyear2019 extends base{

	
	@FindBy(xpath="//*[@id=\"tabs1\"]/li[1]/a")
	WebElement SingleFiling;
	
	@FindBy(xpath="//*[@id=\"tabs1\"]/li[2]/a")
	WebElement ImportBulkData;
	
	@FindBy(xpath="//*[@id=\"ddlPayer_chosen\"]/a")
	WebElement ExistingPayers;
	
	@FindBy(id="btnAddEditPayer")
	WebElement AddPayer;
	
	@FindBy(id="btnEditPayer")
	WebElement EditPayer;
	
	@FindBy(xpath="//*[@id=\"ddlPayee_chosen\"]/a")
	WebElement ExistingRecipients;
	
	@FindBy(xpath="btnAddPayee")
	WebElement AddRecipient;
	
	@FindBy(xpath="btnEditPayee")
	WebElement EditRecipient;
	/*
	@FindBy(xpath="//*[@id=\"PayerModel_FedaralIDType\"]")
	WebElement PayerTINEINradio;
	
	@FindBy(xpath="//*[@id=\"PayerModel_FedaralIDType\"]")
	WebElement PayerTINSSNradio;*/

	@FindBy(xpath="//*[@id=\"PayerModel_PayerFedaralID\"]")
	WebElement PayerTINview;
	/*
	@FindBy(xpath="")
	WebElement RecipientTINEINradio;
	
	@FindBy(xpath="")
	WebElement RecipientTINSSNradio;
	*/
	
	@FindBy(xpath="//*[@id=\"PayeeModel_PayeeFedaralID\"]")
	WebElement RecipientTINview;
	
	@FindBy(xpath="btnEditTaxYear")
	WebElement ChangeTaxYear;
	
	@FindBy(xpath="ddlTaxYear")
	WebElement TaxYearDropdown;
	
	@FindBy(xpath="//*[@id=\"form_title\"]/div[1]/span[1]")
	WebElement OMBNumber;
	
	@FindBy(xpath="Correctedreturn")
	WebElement CorrectedCheckbox;
	
	//Boxes List
	@FindBy(id="Rents")
	WebElement Box1;
	
	@FindBy(id="Royalties")
	WebElement Box2;
	
	@FindBy(id="OtherIncome")
	WebElement Box3;
	
	@FindBy(id="FederalIncomeTaxWH")
	WebElement Box4;
	
	@FindBy(id="Fishing")
	WebElement Box5;
	
	@FindBy(id="Medical")
	WebElement Box6;
	
	@FindBy(id="Nonemployee")
	WebElement Box7;
	
	@FindBy(id="DividendsORInterest")
	WebElement Box8;
	
	@FindBy(id="DirectSales")
	WebElement Box9;
	
	@FindBy(id="Crop")
	WebElement Box10;
	
	@FindBy(id="ExcessGolden")
	WebElement Box13;
	
	@FindBy(id="GrossProceeds")
	WebElement Box14;
	
	@FindBy(id="AccountNumber")
	WebElement AccntNum;
	
	@FindBy(id="Fatca")
	WebElement Fatcacheckbox;
	
	@FindBy(id="SecondTINNotice")
	WebElement SecondTINNoticecheckbox;
	
	@FindBy(id="A409Deferals")
	WebElement Box15aSection409Adeferrals;
	
	@FindBy(id="A409Income")
	WebElement Box15bSection409Aincome;
	
	@FindBy(id="StateTaxWH1")
	WebElement Box16a;
	
	@FindBy(id="StateTaxWH2")
	WebElement Box16b;
	
	@FindBy(id="State1")
	WebElement Box17State1;
	
	@FindBy(id="State2")
	WebElement Box17State2;
	
	@FindBy(id="PayerStateNo1")
	WebElement Box17StateNum1;
	
	@FindBy(id="PayerStateNo2")
	WebElement Box17StateNum2;
	
	@FindBy(id="StateIncome1")
	WebElement Box18a;
	
	@FindBy(id="StateIncome1")
	WebElement Box18b;
	
	@FindBy(id="btnSaveContinue")
	WebElement SaveandContinue;
	
	@FindBy(id="btnSaveAddNewSame")
	WebElement SaveandAddNew1099MISC;
	
	@FindBy(id="btnSaveAddNewForm")
	WebElement SaveandAddNewform;
	
	@FindBy(xpath="//*[@id=\"form\"]/div[3]/div[6]/a/input")
	WebElement Cancel;
	
	@FindBy(id="btnSaveEditOther")
	WebElement SaveandEditNext1099MISC;
	
	public MISCformTaxyear2019() {
		PageFactory.initElements(driver, this);
	}	
	public SubmitForms CreateMISC2019Form(
			String Box1,
			String Box2,
			String Box3,
			String Box4,
			String Box5,
			String Box6,
			String Box7,
			String Box8,
			String Box9,
			String Box10,
			String Box13,
			String Box14,
			String Box15,
			String AccntNum,
			String Fatcacheckbox,
			String SecondTINNoticecheckbox,
			String Box15aSection409Adeferrals,
			String Box15bSection409Aincome,
			String Box16a,
			String Box16b,
			String Box17State1,
			String Box17State2,
			String Box18a,
			String Box18b) {
		
		return new SubmitForms();
	}
}












