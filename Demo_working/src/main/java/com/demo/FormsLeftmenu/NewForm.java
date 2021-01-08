package com.demo.FormsLeftmenu;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demo.Base.base;
import com.demo.MISCformsLIST.MISCformTaxyear2020;
import com.demo.NECformsLIST.NECformTaxyear2020;
import com.demo.actiondriver.Action;

public class NewForm extends base{
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
		
		public NewForm() {
			PageFactory.initElements(getDriver(), this);
		}	
		public void ClickOnTaxYear2020() throws Throwable {
			Action action=new Action();
			action.click(getDriver(), TaxYear2020);
		}
		public MISCformTaxyear2020 ClickOn2020MISC() throws Throwable {
			Action action=new Action();
			action.click(getDriver(), TaxYear2020MISC);
			return new MISCformTaxyear2020();
		}
		public NECformTaxyear2020 ClickOn2020NEC() throws Throwable {
			Action action=new Action();
			action.click(getDriver(), TaxYear2020NEC);
			return new NECformTaxyear2020();
		}
		
		
	
}



























