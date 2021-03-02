package com.demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.demo.Base.base;
import com.demo.actiondriver.Action;


public class LoginPage extends base{
	
	@FindBy(id="logoimgUrl")
	WebElement Tax1099Logo;
	
	@FindBy(id="txtLoginEmail")
	WebElement UserName;
	
	@FindBy(id="txtLoginPassword")
	WebElement Password;
	
	@FindBy(id="btnLogin")
	WebElement LoginButton;
	
	@FindBy(xpath ="//*[@id=\"main-content1\"]/div[3]/div/a/img") 
	WebElement RightSideBNoticeImage;
	
	@FindBy(xpath="//*[@id=\"login-form\"]/div[5]/a")
	WebElement Forgotpassword;
	
	@FindBy(id="//*[@id=\"login-form\"]/div[6]/div/div[3]/a")
	WebElement SignUp;
	
	public LoginPage() {
		PageFactory.initElements(getDriver(), this);
	}
	public String getTax1099Title() {
	String Tax1099title = getDriver().getTitle();	
	return Tax1099title;
	}
	
	public boolean validateLogo() throws Throwable {
			return Action.isDisplayed(getDriver(), Tax1099Logo);
	}
	
	
	public boolean validateBNoticeImage() throws Throwable {
			return Action.isDisplayed(getDriver(),RightSideBNoticeImage);
	}
	public Db login(String Useremail,String Passwd) throws Throwable {
		Action.type(UserName, Useremail);
		Action.type(Password, Passwd);
		WebDriverWait wait = new WebDriverWait(getDriver(), 40);
		  wait.until(ExpectedConditions.elementToBeClickable(LoginButton));
		 Action.implicitWait(getDriver(), 10);
		Action.click(getDriver(), LoginButton);
		return new Db();
		
	}
	
	public forgotpassword forgotpasswd() throws Throwable {
		Action.click(getDriver(), Forgotpassword);
		return new forgotpassword();
	}

	public SignUpPage SignUp() throws Throwable {
		Action.click(getDriver(), SignUp);
		return new SignUpPage();
	
	
}
}
	
	
	
	
	
















