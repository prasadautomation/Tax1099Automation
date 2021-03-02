/**
 * 
 */
package com.tax1099.FormsLeftmenu;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tax1099.base.BaseClass;

/**
 * @author Prasad
 *
 */
public class Forms extends BaseClass{
	
	//TaxYears
	@FindBy(xpath="//*[@id=\"vtab\"]/ul/li[1]")
	WebElement TaxYear2020;
	
	@FindBy(xpath="//*[@id=\"vtab\"]/ul/li[2]")
	WebElement TaxYear2019;
	
	@FindBy(xpath="//*[@id=\"vtab\"]/ul/li[3]")
	WebElement TaxYear2018;
	
	@FindBy(xpath="//*[@id=\"vtab\"]/ul/li[4]")
	WebElement TaxYear2017;

	//TaxYear 2020 forms
	
	@FindBy(xpath="//*[@id=\"MISC2020\"]/h5")
	WebElement TaxYear2020MISC;
	
	@FindBy(xpath="")
	WebElement TaxYear2020NEC;
	
	@FindBy(xpath="")
	WebElement TaxYear2020941;
	
	@FindBy(xpath="")
	WebElement TaxYear2020941X;
	
	@FindBy(xpath="")
	WebElement TaxYear2020941PR;
	
	//TaxYear 2019 forms
	@FindBy(id="MISC")
	WebElement TaxYear2019MISC;
	
	@FindBy(id="A")
	WebElement TaxYear2019A;
	
	@FindBy(id="B")
	WebElement TaxYear2019B;
	
	public Forms() {
		PageFactory.initElements(getDriver(), this);
	}	
}















