package com.demo.PeopleLeftMenu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demo.actiondriver.Action;

import com.demo.Base.base;
public class ManagePayerAddPayer extends base{
	

	Action action= new Action();
	
	@FindBy(id="rblPayerTypeBusiness")
	WebElement Business;	
	
	@FindBy(xpath="//input[@id='PayerFedaralID']")
	WebElement EIN;
	
	@FindBy(id="rblPayerTypeIndividual")
	WebElement Individual;
	
	@FindBy(id="PayerFedaralID")
	WebElement SSN;	
	
	@FindBy(id="PayerFirstName")
	WebElement FN;
	
	@FindBy(id="PayerMiddleName")
	WebElement MN;
	
	@FindBy(id="PayerLastName")
	WebElement LN;
	
	@FindBy(xpath="//*[@id='PayerLastName']")
	WebElement BusinessName;
	
	@FindBy(xpath="//input[@id='PayerAddress']")
	WebElement Address1;

	@FindBy(id="PayerSuffix")
	WebElement suffixdata;
	
	@FindBy(xpath="//input[@id='PayerAddress2']")
	WebElement Line2;
	
	@FindBy(xpath="//input[@id='PayerCity']")
	WebElement City;
	
	@FindBy(id="PayerState")
	WebElement State;
	
	@FindBy(xpath="//*[@id='PayerState']")
	WebElement State1;
	
	@FindBy(xpath="//input[@id='PayerZIP']")
	WebElement Zipcode;
	
	@FindBy(xpath="//select[@id='PayerCountry']")
	WebElement Country;
	
	@FindBy(xpath="//input[@id='PayerChkIsForeignAddress']")
	WebElement CheckheretoForeignAddress;
	
	@FindBy(xpath="//input[@id='PayerPhNo']")
	WebElement Phone;
	
	@FindBy(xpath="//input[@id='PayerEmail']")
	WebElement Email;
	
	@FindBy(xpath="//input[@id='Stateid']")
	WebElement WithholdingORTaxStateId;
	
	@FindBy(xpath="//input[@id='LastFiling']")
	WebElement LastFiling;
	
	@FindBy(xpath="//input[@id='PayerClientId']")
	WebElement ClientID;
	
	@FindBy(xpath="//button[contains(text(),'Add')]")
	WebElement Add;
	
	@FindBy(id="/html/body/div[13]/div[3]/div/button[2]")
	WebElement Cancel;
	
	@FindBy(id="/html/body/div[13]/div[1]/button/span[1]")
	WebElement Close;
	
	


	public ManagePayerAddPayer() {
		PageFactory.initElements(getDriver(), this);
	}
	public String ManagePayerAddPayerPageTitle() {
	String ManagePayerAddPayerPageTitle = getDriver().getTitle();	
	return ManagePayerAddPayerPageTitle;
	}
	
	
	public void AddPayerEIN(
			//String type,
			String einTIN,
			//String ssn,
			//String FirstName,
			//String MiddleName,
			//String LastName,
			String businessname,
			String address,
			String line2,
			String suffix,
			String city,
			String state,
			String zipcode,
			String country,
			//String checkheretoforeignaddress,
			String phone,
			String email,
			String withholdingortaxstateid,
			//String lastfiling,
			String clientid) throws Throwable {
			action.click(getDriver(), Business);
			Thread.sleep(1000);
			//getDriver().findElement(By.xpath("//input[@id='rblPayerTypeBusiness']")).click();
			action.type(EIN,einTIN);
			Thread.sleep(3000);
			action.type(BusinessName, businessname);
			Thread.sleep(1000);
			action.type(Address1, address);
			Thread.sleep(1000);
			action.selectByValue(suffixdata,suffix);
			Thread.sleep(1000);
			action.type(Line2, line2);
			Thread.sleep(1000);
			action.type(City,city );
//			Thread.sleep(2000);
//			action.selectByValue(State,state);
			Thread.sleep(3000);
			action.selectByVisibleText(state,State);
			Thread.sleep(6000);
			action.type(Zipcode, zipcode);
			Thread.sleep(1000);
			action.selectByVisibleText(country, Country);
			Thread.sleep(2000);
			action.type(Phone, phone);
			Thread.sleep(1000);
			//action.click(getDriver(), LastFiling);
			action.type(Email, email);
			Thread.sleep(1000);
			action.type(WithholdingORTaxStateId, withholdingortaxstateid);
			Thread.sleep(2000);
			action.type(ClientID, clientid);
	} 
		public ManagePayerAddPayer validateAddEINpayer() throws Throwable{
			Add.click();
			return new ManagePayerAddPayer();
	}
		/*
		 * if(type.equalsIgnoreCase("Business")) { action.click(getDriver(), Business);
		 * //getDriver().findElement(By.xpath("//input[@id='rblPayerTypeBusiness']")).
		 * click(); action.type(EIN,ein); action.type(Business, businessname);
		 * action.type(Address1, address); action.type(Line2, line2);
		 * action.type(City,city ); action.selectByVisibleText(state, State);
		 * action.type(Zipcode, zipcode); action.selectByVisibleText(country, Country);
		 * action.type(Phone, phone); action.type(Email, email);
		 * action.click(getDriver(), Add); } else { action.click(getDriver(),
		 * Individual); action.type(FN,FirstName); action.type(MN,MiddleName);
		 * action.type(LN,LastName); action.selectByVisibleText(suffix, Suffix);
		 * action.type(Address1, address); action.type(Line2, line2);
		 * action.type(City,city ); action.selectByVisibleText(state, State);
		 * action.type(Zipcode, zipcode); action.selectByVisibleText(country, Country);
		 * action.type(Phone, phone); action.type(Email, email);
		 * action.click(getDriver(), Add); }
		 * 
		 * // getDriver().findElement(By.xpath("//input[@value='"+Type+"']")).click();
		 */
	

}

