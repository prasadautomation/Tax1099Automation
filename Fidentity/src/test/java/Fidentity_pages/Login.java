package Fidentity_pages;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.ResourceBundle;
// import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

//import org.openqa.selenium.chrome.ChromeDriver;

import Common.Fid_base;

public class Login extends Fid_base {
	// @Parameters({"browser"})
	private String BROWSER = System.getProperty("browser");

	public static final Logger log = LogManager.getLogger(Login.class);
	// FileInputStream fi = new FileInputStream("");
	// ResourceBundle bundle = ResourceBundle.getBundle("paths.properties");

	@org.junit.Test
	public void LaunchBrowser() {

		/*
		 * if (BROWSER.equalsIgnoreCase("chrome")) {
		 * System.setProperty("webdriver.chrome.driver",
		 * "E:\\chromedriver_win32\\chromedriver.exe");
		 * 
		 * driver = new ChromeDriver(); } else if (BROWSER.equalsIgnoreCase("firefox"))
		 * {
		 * 
		 * System.setProperty("webdriver.gecko.driver", "E:\\geckodriver.exe");
		 * 
		 * driver = new FirefoxDriver(); }else if (BROWSER.equalsIgnoreCase("ie")) {
		 * System.setProperty("webdriver.ie.driver", "E:\\IEDriverServer.exe");
		 * 
		 * driver = new InternetExplorerDriver(); } else {
		 */
		// File currentDir = new File("");
		// log.info(currentDir.getAbsolutePath());
		// log.info(bundle.getString("chromepath"));

		// ChromeOptions options = new ChromeOptions();
		// options.setPageLoadStrategy(PageLoadStrategy.EAGER);
		// Properties.getProperty("chromepath");
		//ConfigFileReader();
	//	System.setProperty("webdriver.chrome.driver", configFileReader("chromepath"));
		System.setProperty("webdriver.chrome.driver", "E:\\chromedriver_win32\\chromedriver.exe");
		
		
		driver = new ChromeDriver();
		// }
	}

	@Test
	public void Launchtestportal() throws InterruptedException {

		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
		// driver.get("https://test-onboard.fidentity.com/signup.php");
		// driver.get("https://test-onboard.fidentity.com/signup.php?currency=usd");
		driver.get("https://test-onboard.fidentity.com/signup.php?currency=gbp");

		// driver.get("https://test-stest.fidentity.com/");
		Thread.sleep(5000);
	}

	@Test
	public void LaunchPortal() {

		driver.get("https://www.fidentity.com/");

	}

	@Test
	public void LaunchSignInPortal() {

		driver.get("https://test-stest.fidentity.com/login");
	}

	@Test
	public void SignIn() throws InterruptedException {

		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("sridevi3377@srtest.com");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[contains(text(),'Next')]")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// System.out.print("email successfull ");

		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("India@01");

		driver.findElement(By.xpath("//form[@id='password_form']//child::button[contains(text(),'Login')]")).click();

	}

	public void User() {

		// driver.get("<li ng-show='session_data.login_type == 'admin' ||
		// session_data.login_type == 'employee'' >");

		// String
		// user=driver.findElement(By.xpath("//li[contains(@ng-show='session_data.login_type')]")).getText();

		String user = driver.findElement(By.xpath("//title[@class='ng-binding']")).getText();

		System.out.print("User is admin:----" + user);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}
}

/*
 * 
 * implicit wait explict wait
 * 
 * 
 * Implicit wait
 * 
 * driver.manage.
 * 
 */
