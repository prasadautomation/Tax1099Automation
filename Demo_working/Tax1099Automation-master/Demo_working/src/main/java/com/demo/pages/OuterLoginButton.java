/**
 * 
 */
package com.demo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demo.Base.base;
import com.demo.actiondriver.Action;


/**
 * @author Prasad
 *
 */
public class OuterLoginButton extends base{
	

	
	@FindBy(xpath = "//a[@href='/Account/Login']") 
	 WebElement OuterLoginButton;
	

	@FindBy(id = "logoimgUrl") 
	 WebElement OuterTax1099Logo;
	
	public OuterLoginButton() {
		PageFactory.initElements(getDriver(), this);
		
	}
	
	public String getTax1099Title() {
		String Tax1099title = getDriver().getTitle();	
		return Tax1099title;
		}
		
	public boolean validateLogo() throws Throwable {
			return Action.isDisplayed(getDriver(), OuterTax1099Logo);
		}

	public LoginPage clickonLogin() throws Throwable {
		Action.click(getDriver(), OuterLoginButton);
		Thread.sleep(80000);
		return new LoginPage();
	}
}


















