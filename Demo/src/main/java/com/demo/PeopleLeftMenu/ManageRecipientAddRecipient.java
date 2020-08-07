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
	WebElement BusinessTypeRadibutton;

	@FindBy(id = "rblPayeeTypeIndividual")
	WebElement IndividualTypeRadibutton;

	@FindBy(id = "PayeeFedaralID")
	WebElement EIN;

	@FindBy(id = "PayeeFedaralID")
	WebElement SSN;

	@FindBy(id = "chkRecipientTaxIDIsPresent")
	WebElement TINnotProvided;

	@FindBy(id = "PayeeLastName")
	WebElement BusinessName;

	@FindBy(id = "PayeeFirstName")
	WebElement FirstName;

	@FindBy(id = "PayeeMiddleName")
	WebElement MiddleName;

	@FindBy(id = "PayeeLastName")
	WebElement LastName;

	@FindBy(id = "AttentionTo")
	WebElement AttentionTo;

	@FindBy(id = "PayeeAddress")
	WebElement Address;

	@FindBy(id = "PayeeChkUSPS")
	WebElement Checkheretovalidateaddress;;

	@FindBy(id = "PayeeSuffix")
	WebElement Suffix;

	@FindBy(id = "PayeeAddress2")
	WebElement Line2;

	@FindBy(id = "PayeeCity")
	WebElement City;

	@FindBy(id = "PayeeState")
	WebElement State;

	@FindBy(id = "PayeeZIP")
	WebElement Zipcode;

	@FindBy(id = "PayeeCountry")
	WebElement Country;

	@FindBy(id = "chkIsForeignAddress")
	WebElement CheckheretoForeignAddress;

	@FindBy(id = "PayeePhNo")
	WebElement phone;

	@FindBy(id = "PayeeEmail")
	WebElement Email;

	@FindBy(xpath = "/html/body/div[16]/div[3]/div/button[1]")
	WebElement Add;

	@FindBy(xpath = "/html/body/div[16]/div[3]/div/button[2]")
	WebElement Cancel;

	@FindBy(xpath = "/html/body/div[16]/div[1]/button/span[1]")
	WebElement Close;

	@FindBy(id = "chkPayeeMaskSSN")
	WebElement MarkSSN;

	public ManageRecipientAddRecipient() {
		PageFactory.initElements(driver, this);
	}

	public void AddRecipient(
			String W9,
			String W8,
			String Type,
			String EINTIN,
			String SSNTIN,
			String TINnotProvidedcheckbox,
			String BN,
			String FN,
			String MN,
			String LN,
			String AttentionTofield,
			String Address1,
			String Checkheretovalidateaddresscheckbox,
			String Suffixdropdown,
			String Line2field,
			String Cityfield,
			String Statedropdown,
			String Zipcodefield,
			String Countrydropdown,
			String CheckheretoForeignAddresscheckbox,
			String phonefield,
			String Emailfield,
			String MarkSSNcheckbox) throws Throwable {
		
	
	if(Type.equalsIgnoreCase("Business")) {
		action.click(driver, BusinessTypeRadibutton);
	} else {
		action.click(driver, IndividualTypeRadibutton);
	}
	
	action.type(EIN,EINTIN);
	action.type(SSN,SSNTIN );
	
	/*action.type(passWord, pswd);
	action.selectByValue(days, day);
	action.selectByValue(months, month);
	action.selectByValue(years, year);
	action.type(companyName, comPany);
	action.type(address, addr);
	action.type(city, cityString);
	action.selectByVisibleText(stateName, state);
	action.type(postCode, zip);
	action.selectByVisibleText(countryName, country);
	action.type(mobile, mobilePhone);
}*/
	
}

}

