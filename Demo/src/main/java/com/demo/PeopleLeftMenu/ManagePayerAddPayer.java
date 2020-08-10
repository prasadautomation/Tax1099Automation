package com.demo.PeopleLeftMenu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demo.actiondriver.Action;
import com.demo.Base.base;
public class ManagePayerAddPayer extends base{
	

	Action action= new Action();
	
	@FindBy(id="rblPayerType")
	WebElement Business;	
	
	@FindBy(id="PayerFedaralID")
	WebElement EIN;
	
	@FindBy(id="rblPayerTypeIndividual")
	WebElement Individual;
	
	@FindBy(id="PayerFedaralID")
	WebElement SSN;	
	
	@FindBy(id="PayerFirstName")
	WebElement FirstName;
	
	@FindBy(id="PayerMiddleName")
	WebElement MiddleName;
	
	@FindBy(id="PayerLastName")
	WebElement LastName;
	
	@FindBy(id="PayerLastName")
	WebElement BusinessName;
	
	@FindBy(id="PayerAddress")
	WebElement Address1;

	@FindBy(id="PayerSuffix")
	WebElement Suffix;
	
	@FindBy(id="PayerAddress2")
	WebElement Line2;
	
	@FindBy(id="PayerCity")
	WebElement City;
	
	@FindBy(id="PayerState")
	WebElement State;
	
	@FindBy(id="PayerZIP")
	WebElement Zipcode;
	
	@FindBy(id="PayerCountry")
	WebElement Country;
	
	@FindBy(id="PayerChkIsForeignAddress")
	WebElement CheckheretoForeignAddress;
	
	@FindBy(id="PayerPhNo")
	WebElement Phone;
	
	@FindBy(id="PayerEmail")
	WebElement Email;
	
	@FindBy(id="Stateid")
	WebElement WithholdingORTaxStateId;
	
	@FindBy(id="LastFiling")
	WebElement LastFiling;
	
	@FindBy(id="PayerClientId")
	WebElement ClientID;
	
	@FindBy(id="/html/body/div[13]/div[3]/div/button[1]")
	WebElement Add;
	
	@FindBy(id="/html/body/div[13]/div[3]/div/button[2]")
	WebElement Cancel;
	
	@FindBy(id="/html/body/div[13]/div[1]/button/span[1]")
	WebElement Close;
	

	public ManagePayerAddPayer() {
		PageFactory.initElements(driver, this);
	}
	public String ManagePayerAddPayerPageTitle() {
	String ManagePayerAddPayerPageTitle = driver.getTitle();	
	return ManagePayerAddPayerPageTitle;
	}
	
	public void AddPayerEIN(
			String type,
			String ein,
			String businessname,
			String address,
			String suffix,
			String line2,
			String city,
			String state,
			String zipcode,
			String country,
			String checkheretoforeignaddress,
			String phone,
			String email,
			String withholdingortaxstateid,
			String lastfiling,
			String clientid) throws Throwable {
		if(type.equalsIgnoreCase("type")) 
		{
			action.click(driver, Business);
			action.type(EIN,ein );
			action.type(Business, businessname);
			action.type(Address1, address);
			action.type(Line2, line2);
			action.type(City,city );
			action.selectByVisibleText(state, State);
			action.type(Zipcode, zipcode);
			action.selectByVisibleText(country, Country);
			action.type(Phone, phone);
			action.type(Email, email);
			action.click(driver, Add);
		} 
		else 
		{
			action.click(driver, Individual);
			action.selectByVisibleText(suffix, Suffix);
			action.type(Address1, address);
			action.type(Line2, line2);
			action.type(City,city );
			action.selectByVisibleText(state, State);
			action.type(Zipcode, zipcode);
			action.selectByVisibleText(country, Country);
			action.type(Phone, phone);
			action.type(Email, email);
			action.click(driver, Add);
		}
		
		
		
		// driver.findElement(By.xpath("//input[@value='"+Type+"']")).click();  
		
	}
	public void AddPayerSSN(
			String type,
			String ssn,
			String firstname,
			String middlename,
			String lastName,
			String address,
			String suffix,
			String line2,
			String city,
			String state,
			String zipcode,
			String country,
			String checkheretoforeignaddress,
			String phone,
			String email,
			String withholdingortaxstateid,
			String lastfiling,
			String clientid
			
			)throws Throwable {
		if(type.equalsIgnoreCase("type")) 
		{
			action.click(driver, Business);
			action.type(SSN,ssn );
			action.type(FirstName, firstname);
			action.type(MiddleName, middlename);
			action.type(LastName, lastName);
			action.type(Address1, address);
			action.type(Line2, line2);
			action.type(City,city );
			action.selectByVisibleText(state, State);
			action.type(Zipcode, zipcode);
			action.selectByVisibleText(country, Country);
			action.type(Phone, phone);
			action.type(Email, email);
			action.click(driver, Add);
		} 
		else 
		{
			action.click(driver, Individual);
			action.type(SSN,ssn );
			action.type(FirstName, firstname);
			action.type(MiddleName, middlename);
			action.type(LastName, lastName);
			action.selectByVisibleText(suffix, Suffix);
			action.type(Address1, address);
			action.type(Line2, line2);
			action.type(City,city );
			action.selectByVisibleText(state, State);
			action.type(Zipcode, zipcode);
			action.selectByVisibleText(country, Country);
			action.type(Phone, phone);
			action.type(Email, email);
			action.click(driver, Add);
		}
		

}
}








