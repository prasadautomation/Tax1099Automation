package com.demo.Importforms;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demo.Base.base;
import com.demo.ExcelImportMatchFieldPages.MISCExcelImportMatchFieldsPage;
import com.demo.actiondriver.Action;

public class MISCImportPage extends base{

	@FindBy(xpath="//a[contains(text(),'Single Filing')]")
	WebElement SingleFiling;
	

	@FindBy(xpath="//a[@class='current']")
	WebElement ImportBulkData;
	

	@FindBy(xpath="//a[@id='tab2']")
	WebElement Paste;
	

	@FindBy(xpath="//li[@class='r-tabs-tab r-tabs-state-active']")
	WebElement Upload;
	

	@FindBy(xpath="//input[@id='files']")
	WebElement SelectFiles;
	
	@FindBy(xpath="//span[contains(text(),'CSV')]")
	WebElement CSV;
	
	@FindBy(xpath="//span[contains(text(),'Excel')]")
	WebElement Excel;
	
	@FindBy(xpath="//input[@id='IsCorrected']")
	WebElement Checkiffilingforcorrected;

	@FindBy(xpath="//input[@id='Save']")
	WebElement SavedInfo;

	@FindBy(xpath="//input[@id='Next']")
	WebElement Next;

	@FindBy(xpath="//span[@class='k-file-name']")
	WebElement filename;

	@FindBy(xpath="//span[@class='k-upload-pct']")
	WebElement percentage;
	
	@FindBy(xpath="//strong[@class='k-upload-status k-upload-status-total']")
	WebElement Done;
	
	@FindBy(xpath="//span[@class='k-icon k-i-close k-i-x']")
	WebElement closefile;

	@FindBy(xpath="//marquee[contains(text(),'System will auto populate Payer tax id in Box 17 (')]")
	WebElement Note;
	
	public MISCImportPage() {
		PageFactory.initElements(driver, this);
	}	
    public String GetCurrentURL() {
	String MISCImportPageURL=driver.getCurrentUrl();
	return  MISCImportPageURL;
    }

    public MISCExcelImportMatchFieldsPage clickNext() throws Throwable {
    	Action action = new Action();
		action.click(driver, Next);
		return new MISCExcelImportMatchFieldsPage();
		
	}
	
}


















