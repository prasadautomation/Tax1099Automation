package com.demo.ImportExcelSpreahsheet;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demo.Base.base;
import com.demo.actiondriver.Action;

public class ImportFormsPage extends base {

	@FindBy(xpath = "//div[@id='MISC']")
	WebElement ImportMISC;

	@FindBy(xpath = "//div[@id='NEC']")
	WebElement ImportNEC;

	@FindBy(xpath = "//div[@id='A']")
	WebElement ImportA;

	@FindBy(xpath = "//div[@id='B']")
	WebElement ImportB;

	@FindBy(xpath = "//div[@id='C']")
	WebElement ImportC;

	@FindBy(xpath = "//div[@id='DIV']")
	WebElement ImportDIV;

	@FindBy(xpath = "//div[@id='G']")
	WebElement ImportG;

	@FindBy(xpath = "//div[@id='INT']")
	WebElement ImportINT;

	@FindBy(xpath = "//div[@id='K']")
	WebElement ImportK;

	@FindBy(xpath = "//div[@id='OID']")
	WebElement ImportOID;

	@FindBy(xpath = "//div[@id='PATR']")
	WebElement ImportPATR;

	@FindBy(xpath = "//div[@id='R']")
	WebElement ImportR;

	@FindBy(xpath = "//div[@id='S']")
	WebElement ImportS;

	@FindBy(xpath = "//div[@id='F3921']")
	WebElement Import3921;

	@FindBy(xpath = "//div[@id='F3922']")
	WebElement Import3922;

	@FindBy(xpath = "//div[@id='F5498']")
	WebElement Import5498;

	@FindBy(xpath = "//div[@id='Form1097BTC']")
	WebElement ImportBTC;

	@FindBy(xpath = "")
	WebElement ImportW2G;

	@FindBy(xpath = "//div[@id='F1042S']")
	WebElement Import1098;

	@FindBy(xpath = "//div[@id='1098-C']")
	WebElement Import1098C;

	@FindBy(xpath = "//div[@id='1098-T']")
	WebElement Import1098T;

	@FindBy(xpath = "//div[@id='1042S']")
	WebElement Import1042S;

	@FindBy(xpath = "//div[@id='1095B']")
	WebElement Import1095B;

	@FindBy(xpath = "//div[@id='1095C']")
	WebElement Import1095C;

	@FindBy(xpath = "//div[@id='Formw2']")
	WebElement ImportW2;

	@FindBy(xpath = "//div[@id='Form8809']")
	WebElement Import8809;

	@FindBy(xpath = "//div[@id='Formw2GU']")
	WebElement ImportW2GU;

	@FindBy(xpath = "//div[@id='Formw2VI']")
	WebElement ImportW2VI;

	@FindBy(xpath = "//div[@id='Formw2c']")
	WebElement ImportW2C;

	@FindBy(xpath = "//div[@id='ImportForm941']")
	WebElement Import941;

	public ImportFormsPage() {
		PageFactory.initElements(driver, this);
	}

	public void MISCIMPORT() throws Throwable {
			Action action=new Action();
			action.click(driver, ImportMISC);
	}

	public void NECIMPORT() throws Throwable {
		Action action = new Action();
		action.click(driver, ImportNEC);
	}

	public void AIMPORT() throws Throwable {
		Action action = new Action();
		action.click(driver, ImportA);
	}

	public void BIMPORT() throws Throwable {
		Action action = new Action();
		action.click(driver, ImportB);
	}

	public void CIMPORT() throws Throwable {
		Action action = new Action();
		action.click(driver, ImportC);

	}

	public void DIVIMPORT() throws Throwable {
		Action action = new Action();
		action.click(driver, ImportDIV);

	}

	public void GIMPORT() throws Throwable {
		Action action = new Action();
		action.click(driver, ImportG);

	}

	public void INTIMPORT() throws Throwable {
		Action action = new Action();
		action.click(driver, ImportINT);

	}

	public void KIMPORT() throws Throwable {
		Action action = new Action();
		action.click(driver, ImportK);

	}

	public void OIDIMPORT() throws Throwable {
		Action action = new Action();
		action.click(driver, ImportOID);

	}

	public void PATRIMPORT() throws Throwable {
		Action action = new Action();
		action.click(driver, ImportPATR);

	}

}
