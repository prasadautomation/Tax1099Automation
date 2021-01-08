package com.demo.MISCformsLIST;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.demo.Base.base;
import com.demo.FormsLeftmenu.SubmitForms;
import com.demo.actiondriver.Action;

public class MISCformTaxyear2020 extends base{

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
	WebElement Box1misc;
	
	@FindBy(id="Royalties")
	WebElement Box2misc;
	
	@FindBy(id="OtherIncome")
	WebElement Box3misc;
	
	@FindBy(id="FederalIncomeTaxWH")
	WebElement Box4misc;
	
	@FindBy(id="Fishing")
	WebElement Box5misc;
	
	@FindBy(id="Medical")
	WebElement Box6misc;
	
	@FindBy(id="DirectSales")
	WebElement Box7misc;
	
	@FindBy(id="DividendsORInterest")
	WebElement Box8misc;
	
	@FindBy(id="Crop")
	WebElement Box9misc;
	
	@FindBy(id="GrossProceeds")
	WebElement Box10misc;
	
	@FindBy(id="A409Deferals")
	WebElement Box12misc;
	
	@FindBy(id="ExcessGolden")
	WebElement Box13misc;
	
	@FindBy(id="NonqualifiedDefCom")
	WebElement Box14misc;
	
	@FindBy(id="AccountNumber")
	WebElement AccntNummisc;
	
	@FindBy(id="Fatca")
	WebElement Fatcamisc;
	
	@FindBy(id="SecondTINNotice")
	WebElement SecondTINNoticemisc;
	
	@FindBy(xpath="//input[@id='StateTaxWH1']")
	WebElement StateTaxWH1smisc;
	
	@FindBy(xpath="//input[@id='StateTaxWH2']")
	WebElement StateTaxWH2misc;
	
	@FindBy(id="StateTaxWH1")
	WebElement Box16amisc;
	
	@FindBy(id="StateTaxWH2")
	WebElement Box16bmisc;
	
	@FindBy(id="State1")
	WebElement Box17State1misc;
	
	@FindBy(id="State2")
	WebElement Box17State2misc;
	
	@FindBy(id="PayerStateNo1")
	WebElement Box17StateNum1misc;
	
	@FindBy(id="PayerStateNo2")
	WebElement Box17StateNum2misc;
	
	@FindBy(id="StateIncome1")
	WebElement Box18amisc;
	
	@FindBy(id="StateIncome1")
	WebElement Box18bmisc;
	
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
	
	public MISCformTaxyear2020() {
		PageFactory.initElements(getDriver(), this);
	}	
	
	
	public SubmitForms CreateMISC2020Form(
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
			String Box12,
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
			String Box17StateNum1,
			String box17StateNum2,
			String Box18a,
			String Box18b) throws Throwable {
		
		Action action=new Action();
		action.click(getDriver(), SaveandContinue);
		return new SubmitForms();
	}


}



































