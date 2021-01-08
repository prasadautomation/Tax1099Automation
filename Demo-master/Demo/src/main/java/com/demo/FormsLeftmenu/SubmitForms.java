/**
 * 
 */
package com.demo.FormsLeftmenu;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demo.Base.base;
import com.demo.Paymentpage.Paymentpage;
import com.demo.actiondriver.Action;

/**
 * @author Prasad
 *
 */
public class SubmitForms extends base{
	
	@FindBy(id="btnPrepay")
	WebElement PrepayNow;
	
	@FindBy(xpath="//span[contains(text(),'Select form...')]")
	WebElement Formdropdown;
	
	@FindBy(xpath="//span[contains(text(),'Select Tax Year...')]")
	WebElement TaxYeardropdown;
	
	@FindBy(xpath="//span[contains(text(),'Select payer...')]")
	WebElement Payerdropdown;
	
	@FindBy(xpath="//span[contains(text(),'Regular')]")
	WebElement FormTypedropdown;
	
	@FindBy(xpath="//span[contains(text(),'NotSubmitted')]")
	WebElement FormStatusdropdown;
	
	@FindBy(xpath="//span[contains(text(),'1099-MISC')]")
	WebElement FormMISC;
	
	@FindBy(xpath="//span[contains(text(),'1099-A')]")
	WebElement FormA;
	
	@FindBy(xpath="//input[@id='selectall']")
	WebElement SelectAll;
	
	@FindBy(xpath="//input[@id='btnSubmit']")
	WebElement Next;
	
	public SubmitForms() {
		PageFactory.initElements(getDriver(), this);
	}	
	public void SelectFormMISC() throws Throwable {
		Action action=new Action();
		action.selectByValue(FormTypedropdown, "FormMISC");
	}
	public void SelectTaxYear() throws Throwable {
		Action action=new Action();
		action.selectByValue(TaxYeardropdown, "2020");
	}
	public void SelectPayer() throws Throwable {
		Action action=new Action();
		action.selectByValue(Payerdropdown, "100");
	}
	public void SelectFormType() throws Throwable {
		Action action=new Action();
		action.selectByValue(FormTypedropdown, "Regular");
	}
	public void SelectFormStatus() throws Throwable {
		Action action=new Action();
		action.selectByValue(FormStatusdropdown, "NotSubmitted");
	}
	public void SelectFormA() throws Throwable {
		Action action=new Action();
		action.selectByValue(FormTypedropdown, "A");
	}
	
	public void SelectAllcheckbox() throws Throwable  {
		Action action=new Action();
		action.click(getDriver(), SelectAll);
	}
	
	public void ClickNext() throws Throwable  {
		Action action=new Action();
		action.click(getDriver(), Next);
	}
	public Paymentpage MISCformNextfromSubmitpage() throws Throwable {
		SelectFormMISC();
		SelectTaxYear();
		SelectPayer();
		SelectFormType();
		SelectFormStatus();
		SelectAllcheckbox();
		return new Paymentpage();	
	}
	public Paymentpage AformNextfromSubmitpage() throws Throwable {
		SelectFormMISC();
		SelectTaxYear();
		SelectPayer();
		SelectFormType();
		SelectFormStatus();
		SelectAllcheckbox();
		return new Paymentpage();	
	}
	
	
	
	//span[contains(text(),'2020')]
	//span[contains(text(),'100')]
	
}