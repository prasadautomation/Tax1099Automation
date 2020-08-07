package com.demo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demo.Base.base;

public class Db extends base{
	
		@FindBy(xpath="//input[@id='filter-TIN']")
		WebElement TypeTINorPartofnameorclientID;
	
		@FindBy(xpath="//select[@id='filter-status']")
		WebElement Allstatuses;
		
		@FindBy(xpath="//select[@id='filter-year']")
		WebElement TaxYearsList;
		
		@FindBy(xpath="//input[@id='filter-Ref']")
		WebElement TypeReferenceNumber;
		
		@FindBy(xpath="//a[@class='btn btn-primary btn-medium']")
		WebElement StartNewFiling;
		
		@FindBy(xpath="//a[@class='menu_item js-log-out']//img")
		WebElement Logout;
		
		@FindBy(xpath="//a[@id='header-settings']//img")
		WebElement Settings;
		
		@FindBy(xpath="//div[@class='col-md-12 top_bar']//div[3]")
		WebElement PlusIcon;
		
		public Db() {
			PageFactory.initElements(driver, this);
		}	
	    public String GetCurrentURL() {
		String DashboardPageURL=driver.getCurrentUrl();
		return  DashboardPageURL;
	}

}
