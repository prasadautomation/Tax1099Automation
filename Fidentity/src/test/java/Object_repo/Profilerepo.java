package Object_repo;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class Profilerepo {
	@FindBy(how = How.ID, using = "header_myProfile")
	public static WebElement myprofilemenu;
	@FindBy(how = How.ID, using = "myProfile_editProfile")
	public static WebElement editprofile;
	@FindBy(how = How.ID, using = "myProfile_mouseOver_forEdit")
	public static WebElement mouseoverprofilepic;
	@FindBy(how = How.ID, using = "profileImageUpload")
	public static WebElement Uploadprofilepic;
	@FindBy(how = How.ID, using = "full_name")
	public static WebElement fullname;
	@FindBy(how = How.ID, using = "designation")
	public static WebElement designation;
	@FindBy(how = How.ID, using = "department")
	public static WebElement department;
	@FindBy(how = How.ID, using = "gender")
	public static WebElement genderdropdwn;
	//public static Select  gender;
	@FindBy(how = How.ID, using = "myProfile_update")
	public static WebElement  profileupdate;
	//public static WebDriver mouseoverprofilepic1
	@FindBys(@FindBy(how = How.XPATH, using = "//form[@id='location_filter_form']/following-sibling::div//table//tbody//tr//td[1]//span"))
	public static List<WebElement> namevalue;
	
	

}
