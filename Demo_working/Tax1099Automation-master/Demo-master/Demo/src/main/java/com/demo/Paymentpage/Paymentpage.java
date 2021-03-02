package com.demo.Paymentpage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demo.Base.base;
import com.demo.FormsLeftmenu.ManageForms;
import com.demo.actiondriver.Action;

import freemarker.core.ReturnInstruction.Return;

public class Paymentpage extends base{

	//e-Filing Fee Summary
	@FindBy(xpath="//label[@id='SubmittedFormsCount']")
	WebElement FormCount;
	
	@FindBy(xpath="//label[@id='FilingFee']")
	WebElement eflingFee;
	
	@FindBy(xpath="//label[@id='TinMatchFee']")
	WebElement TINMatchFee;
	
	@FindBy(xpath="//label[@id='MailingFee']")
	WebElement USPSMailingFee;
	
	@FindBy(xpath="//label[@id='StateFilingFee']")
	WebElement StateFilingFee;
	
	//Filing Fee Information
	
	@FindBy(xpath="//label[@id='TotalFilingFee']")
	WebElement TotalFilingFee;
	
	@FindBy(xpath="//label[@id='PrepayBalance']")
	WebElement PrepayBalanceafterthisSubmission;

	@FindBy(xpath="//label[@id='AmountToBePaid']")
	WebElement TotalAmounttobePaid;
	
	//Saved Details
	@FindBy(xpath="//input[@id='SavedCard']")
	WebElement SavedCardRadioButton;
	
	@FindBy(xpath="//label[contains(text(),'Prasad XXXXXXXXXXXX4242')]")
	WebElement SavedCardText;
	
	@FindBy(xpath="//input[@id='63']")
	WebElement SavedCardDelete;
	
	//Enter your card information
	@FindBy(xpath="//input[@id='CardHolderName']")
	WebElement NameonCard;
	
	@FindBy(xpath="//input[@id='CreditCardNumber']")
	WebElement CardNumber;
	
	//Expiration
	@FindBy(xpath="//select[@id='ExpiryMonth']")
	WebElement Month;
	
	@FindBy(xpath="//select[@id='ExpiryYear']")
	WebElement Year;
	
	@FindBy(xpath="//input[@id='CvvNumber']")
	WebElement CVV;
	
	//Enter your Billing Address
	
	@FindBy(xpath="//input[@id='Address']")
	WebElement SaveCardDetailsForFuturePayments;
	
	@FindBy(xpath="//input[@id='City']")
	WebElement City;
	
	@FindBy(xpath="//select[@id='ddlAddressStateUS']")
	WebElement State;
	
	@FindBy(xpath="//input[@id='ZIP']")
	WebElement Zipcode;
	
	@FindBy(xpath="//select[@id='ddlCountry']")
	WebElement Country;
	
	@FindBy(xpath="//input[@id='Emailid']")
	WebElement Email;
	
	@FindBy(xpath="//input[@id='Coupon']")
	WebElement Coupon;
	
	@FindBy(xpath="//input[@id='btnGetDiscount']")
	WebElement Apply;
	
	@FindBy(xpath="//input[@id='btnPay']")
	WebElement PayandSubmitToefile;
	
	@FindBy(xpath="//input[@id='btnBack']")
	WebElement Cancel;
	

	public Paymentpage() {
		PageFactory.initElements(getDriver(), this);
	}	
	public ManageForms PayandSubmit() throws Throwable {
	
		Action action=new Action();
		action.click(getDriver(), PayandSubmitToefile);
		return new ManageForms();
	}

	
}











