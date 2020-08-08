package com.demo.ImportformSelection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demo.Base.base;
import com.demo.Importforms.AImportPage;
import com.demo.Importforms.BImportPage;
import com.demo.Importforms.BTC1097ImportPage;
import com.demo.Importforms.CImportPage;
import com.demo.Importforms.DIVImportPage;
import com.demo.Importforms.GImportPage;
import com.demo.Importforms.INTImportPage;
import com.demo.Importforms.KImportPage;
import com.demo.Importforms.MISCImportPage;
import com.demo.Importforms.NECImportPage;
import com.demo.Importforms.OIDImportPage;
import com.demo.Importforms.PATRImportPage;
import com.demo.Importforms.RImportPage;
import com.demo.Importforms.SImportPage;
import com.demo.Importforms.W2CImportPage;
import com.demo.Importforms.W2GImportPage;
import com.demo.Importforms.W2GUImportPage;
import com.demo.Importforms.W2ImportPage;
import com.demo.Importforms.W2VIImportPage;
import com.demo.Importforms.form1042SImportPage;
import com.demo.Importforms.form1095BImportPage;
import com.demo.Importforms.form1095CImportPage;
import com.demo.Importforms.form1098CImportPage;
import com.demo.Importforms.form1098ImportPage;
import com.demo.Importforms.form1098TImportPage;
import com.demo.Importforms.form3921ImportPage;
import com.demo.Importforms.form3922ImportPage;
import com.demo.Importforms.form5498ImportPage;
import com.demo.Importforms.form8809ImportPage;
import com.demo.Importforms.form941ImportPage;
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
	WebElement ImportBTC1097;

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

	public MISCImportPage MISCIMPORT() throws Throwable {
		Action action = new Action();
		action.click(driver, ImportMISC);
		return new MISCImportPage();
	}

	public NECImportPage NECIMPORT() throws Throwable {
		Action action = new Action();
		action.click(driver, ImportNEC);
		return new NECImportPage();
	}

	public AImportPage AIMPORT() throws Throwable {
		Action action = new Action();
		action.click(driver, ImportA);
		return new AImportPage();
	}

	public BImportPage BIMPORT() throws Throwable {
		Action action = new Action();
		action.click(driver, ImportB);
		return new BImportPage();
	}

	public CImportPage CIMPORT() throws Throwable {
		Action action = new Action();
		action.click(driver, ImportC);
		return new CImportPage();

	}

	public DIVImportPage DIVIMPORT() throws Throwable {
		Action action = new Action();
		action.click(driver, ImportDIV);
		return new DIVImportPage();
	}

	public GImportPage GIMPORT() throws Throwable {
		Action action = new Action();
		action.click(driver, ImportG);
		return new GImportPage();
	}

	public INTImportPage INTIMPORT() throws Throwable {
		Action action = new Action();
		action.click(driver, ImportINT);
		return new INTImportPage();
	}

	public KImportPage KIMPORT() throws Throwable {
		Action action = new Action();
		action.click(driver, ImportK);
		return new KImportPage();
	}

	public OIDImportPage OIDIMPORT() throws Throwable {
		Action action = new Action();
		action.click(driver, ImportOID);
		return new OIDImportPage();
	}

	public PATRImportPage PATRIMPORT() throws Throwable {
		Action action = new Action();
		action.click(driver, ImportPATR);
		return new PATRImportPage();
	}

	public RImportPage RIMPORT()throws Throwable{
		Action action = new Action();
		action.click(driver, ImportR);
		return new RImportPage();
	}

	public SImportPage SIMPORT()throws Throwable{
		Action action = new Action();
		action.click(driver, ImportS);
		return new SImportPage();
	}

	public form3921ImportPage form3921IMPORT()throws Throwable{
		Action action = new Action();
		action.click(driver, Import3921);
		return new form3921ImportPage();
	}

	public form3922ImportPage form3922IMPORT()throws Throwable{
		Action action = new Action();
		action.click(driver,Import3922 );
		return new form3922ImportPage();
	}

	public form5498ImportPage form5498IMPORT()throws Throwable{
		Action action = new Action();
		action.click(driver, Import5498);
		return new form5498ImportPage();
	}

	public BTC1097ImportPage BTC1097()throws Throwable{
		Action action = new Action();
		action.click(driver, ImportBTC1097);
		return new BTC1097ImportPage();
	}

	public W2GImportPage W2G()throws Throwable{
		Action action = new Action();
		action.click(driver, ImportW2G);
		return new W2GImportPage();
	}
	public form1098ImportPage form1098()throws Throwable{
		Action action = new Action();
		action.click(driver,Import1098 );
		return new form1098ImportPage();
	}
	
	public form1098CImportPage form1098C()throws Throwable{
		Action action = new Action();
		action.click(driver, Import1098C);
		return new form1098CImportPage();
	}
	
	public form1098TImportPage form1098T()throws Throwable{
		Action action = new Action();
		action.click(driver,Import1098T );
		return new form1098TImportPage();
	}
	
	public form1042SImportPage form1042S()throws Throwable{
		Action action = new Action();
		action.click(driver, Import1042S);
		return new form1042SImportPage();
	}
	
	public form1095BImportPage form1095B()throws Throwable{
		Action action = new Action();
		action.click(driver, Import1095B);
		return new form1095BImportPage()
;	}
	
	public form1095CImportPage form1095C()throws Throwable{
		Action action = new Action();
		action.click(driver, Import1095C);
		return new form1095CImportPage();
	}
	
	public W2ImportPage W2()throws Throwable{
		Action action = new Action();
		action.click(driver, ImportW2);
		return new W2ImportPage();
	}
	
	public form8809ImportPage form8809()throws Throwable{
		Action action = new Action();
		action.click(driver, Import8809);
		return new form8809ImportPage();
	}
	
	public W2GUImportPage W2GU()throws Throwable{
		Action action = new Action();
		action.click(driver, ImportW2GU);
		return new W2GUImportPage();
	}

	
	public W2VIImportPage W2VI()throws Throwable{
		Action action = new Action();
		action.click(driver,ImportW2VI );
		return new W2VIImportPage();
	}

	
	public W2CImportPage W2C()throws Throwable{
		Action action = new Action();
		action.click(driver, ImportW2C);
		return new W2CImportPage();
	}

	
	public form941ImportPage form941()throws Throwable{
		Action action = new Action();
		action.click(driver, Import941);
		return new form941ImportPage();
	}

	
	
}	


















