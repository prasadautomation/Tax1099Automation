package CucumberOptions;

 import java.util.concurrent.TimeUnit;


import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.CucumberOptions;

import cucumber.api.testng.AbstractTestNGCucumberTests;

// @RunWith(Cucumber.class) when we run with test runner we can use this 
@CucumberOptions(   
	//features = "E:\\eclipse-workspace\\Fidentity\\src\\test\\java\\features\\UserActions.feature",tags="@ChangeAccountType",
		//features =  "E:\\eclipse-workspace\\Fidentity\\src\\test\\java\\features\\Addemployee.feature",tags=" @AddEmployee",
		 features = "E:/eclipse-workspace/Test/src/test/java/features/EmployeeActions.feature",tags="@Validatefileds",
		glue= "steps", 
		monochrome=true,dryRun = false)

public class TestRunner extends AbstractTestNGCucumberTests{
	
	/*static WebDriver driver;
	 
	@BeforeClass
	public static void before() {   
		 String browserName=System.getenv("browserName");
	     
	    if (browserName
	            .equalsIgnoreCase("Chrome")) {
	    	System.setProperty("webdriver.chrome.driver","E:\\chromedriver_win32\\chromedriver.exe");
	        driver=new ChromeDriver(); 
	    } else if (browserName.equalsIgnoreCase("Firefox")) {
	    	System.setProperty("webdriver.gecko.driver","E:\\geckodriver.exe");
	    	 driver = new FirefoxDriver();
	    } else if (browserName
	            .equalsIgnoreCase("IE")) {
	        //Set IEDriver path and initiate IE
	    } else {
	    	System.out.print("Browser name not mentioned properly");
	        System.exit(0);
	    }
	           driver.manage().window().maximize();
	      driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);  
	 }*/
} 
// AbstractTestNGCucumberTests this is added when run with testng
