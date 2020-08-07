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
	WebElement Address;

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
	WebElement phone;
	
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
	
	public void AddPayer(
			String Type,
			String EIN,
			String SSN,
			String FirstName,
			String MiddleName,
			String LastName,
			String BusinessName,
			String Address,
			String Suffix,
			String Line2,
			String PayerCity,
			String State,
			String Zipcode,
			String Country,
			String CheckheretoForeignAddress,
			String phone,
			String Email,
			String WithholdingORTaxStateId,
			String LastFiling,
			String ClientID
			
			) {
		 driver.findElement(By.xpath("//input[@value='"+Type+"']")).click();  
		
	}
	
	
}









