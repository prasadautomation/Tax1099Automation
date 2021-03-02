/**
 * 
 */
package com.demo.FormsLeftmenu;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demo.Base.base;
import com.demo.actiondriver.Action;


/**
 * @author Prasad
 *
 */
public class FormsLeftMenu extends base{
	
	@FindBy(xpath="//p[contains(text(),'Forms')]")
	WebElement Forms;
	
	@FindBy(xpath="//a[contains(text(),'New Form')]")
	WebElement NewForm;
	
	public FormsLeftMenu() {
		PageFactory.initElements(getDriver(), this);
	}
	public void ClickOnForms() throws Throwable {
		Action action=new Action();
		action.click(getDriver(), Forms);
	}
	public NewForm ClickOnNewForm() throws Throwable {
		Action action=new Action();
		action.click(getDriver(), NewForm);
		return new NewForm();
	}
}















