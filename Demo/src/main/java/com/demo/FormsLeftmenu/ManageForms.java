package com.demo.FormsLeftmenu;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demo.Base.base;

public class ManageForms extends base{
	
	@FindBy(xpath="//div[@id='panelbar-1']//div//div//p//span[@class='k-input'][contains(text(),'100')]")
	WebElement SelectPayer;
	
	@FindBy(xpath="//span[contains(text(),'2019')]")
	WebElement TaxYear;
	
	@FindBy(xpath="//input[@id='payeeNameSearch']")
	WebElement SearchRecipient;
	
	@FindBy(xpath="//input[@id='payeeNameSearch']")
	WebElement SelectAllCheckBox;

	public ManageForms() {
		PageFactory.initElements(driver, this);
	}	
	
}
