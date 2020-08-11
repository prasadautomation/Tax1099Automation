package com.demo.PeopleLeftMenu;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demo.actiondriver.Action;
import com.demo.Base.base;

public class ManageRecipientAddRecipient extends base {


	Action action= new Action();
	
	@FindBy(id = "isW9Request")
	WebElement W9RequestCheckBox;

	@FindBy(id = "IsW8Requested")
	WebElement W8RequestCheckBox;

	@FindBy(id = "rblPayeeType")
	WebElement BusinessRadiobutton;

	@FindBy(id = "rblPayeeTypeIndividual")
	WebElement IndividualRadiobutton;

	@FindBy(id = "PayeeFedaralID")
	WebElement EINTIN;

	@FindBy(id = "PayeeFedaralID")
	WebElement SSNTIN;

	@FindBy(id = "chkRecipientTaxIDIsPresent")
	WebElement TINnotProvidedCheckbox;

	@FindBy(id = "PayeeLastName")
	WebElement BusinessName;

	@FindBy(id = "PayeeFirstName")
	WebElement FirstName;

	@FindBy(id = "PayeeMiddleName")
	WebElement MiddleName;

	@FindBy(id = "PayeeLastName")
	WebElement LastName;

	@FindBy(id = "AttentionTo")
	WebElement AttentionTofield;

	@FindBy(id = "PayeeAddress")
	WebElement AddressLine1;

	@FindBy(id = "PayeeChkUSPS")
	WebElement Checkheretovalidateaddresscheckbox;;

	@FindBy(id = "PayeeSuffix")
	WebElement Suffixdropdown;

	@FindBy(id = "PayeeAddress2")
	WebElement Line2field;

	@FindBy(id = "PayeeCity")
	WebElement Cityfield;

	@FindBy(id = "PayeeState")
	WebElement Statedropdown;

	@FindBy(id = "PayeeZIP")
	WebElement Zipcodefield;

	@FindBy(id = "PayeeCountry")
	WebElement Countryfield;

	@FindBy(id = "chkIsForeignAddress")
	WebElement CheckheretoForeignAddresscheckbox;

	@FindBy(id = "PayeePhNo")
	WebElement phonefield;

	@FindBy(id = "PayeeEmail")
	WebElement Emailfield;

	@FindBy(xpath = "/html/body/div[16]/div[3]/div/button[1]")
	WebElement Addbutton;

	@FindBy(xpath = "/html/body/div[16]/div[3]/div/button[2]")
	WebElement Cancelbutton;

	@FindBy(xpath = "/html/body/div[16]/div[1]/button/span[1]")
	WebElement Closeicon;

	@FindBy(id = "chkPayeeMaskSSN")
	WebElement MarkSSN;

	public ManageRecipientAddRecipient() {
		PageFactory.initElements(getDriver(), this);
	}

	public void AddRecipientEIN(
			String Type,
			String EIN,
			String TINnotProvidedcheckbox,
			String BN,
			String AttentionTofield,
			String Address1,
			String Checkheretovalidateaddresscheckbox,
			String Suffixdropdown,
			String Line2,
			String City,
			String State,
			String Zipcode,
			String Country,
			String CheckheretoForeignAddresscheckbox,
			String Phone,
			String Email) throws Throwable {
	if(Type.equalsIgnoreCase("Type")) 
	{
		action.click(getDriver(), BusinessRadiobutton);
		action.type(EINTIN,EIN );
		action.type(BusinessName, BN);
		action.type(AddressLine1,Address1);
		action.type(Line2field, Line2);
		action.type(Cityfield,City );
		action.selectByVisibleText(State, Statedropdown);
		action.type(Zipcodefield, Zipcode);
		action.selectByVisibleText(Country, Countryfield);
		action.type(phonefield, Phone);
		action.type(Emailfield,Email );
		action.click(getDriver(), Addbutton);	
	} 
	else 
	{
		action.click(getDriver(), BusinessRadiobutton);
		action.type(EINTIN,EIN );
		action.type(BusinessName, BN);
		action.type(AddressLine1,Address1);
		action.type(Line2field, Line2);
		action.type(Cityfield,City );
		action.selectByVisibleText(State, Statedropdown);
		action.type(Zipcodefield, Zipcode);
		action.selectByVisibleText(Country, Countryfield);
		action.type(phonefield, Phone);
		action.type(Emailfield,Email );
		action.click(getDriver(), Addbutton);	}
	
	}
	
	
	

}

