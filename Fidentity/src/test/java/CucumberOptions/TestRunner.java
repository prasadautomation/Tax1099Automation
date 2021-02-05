package CucumberOptions;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

import Common.Fid_base;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

//@RunWith(Cucumber.class)// when we run with test runner we can use this

@CucumberOptions(
		// features =EmployeeActions.feature
		// "E:\\eclipse-workspace\\Fidentity\\src\\test\\java\\features\\UserActions.feature",tags="@ChangeAccountType",
		// features =
		// "E:\\eclipse-workspace\\Fidentity\\s
		// rc\\test\\java\\features\\Addemployee.feature",tags="
		// @AddEmployee",
		plugin = { "pretty",
				"json:target/cucumber-report.xml" }, 
		features = "E:/eclipse-workspace/Fidentity/src/test/java/features/OnLocation.feature", 
				tags = "@Addvisitortowatchlist",
		// tags= "@Signupwithotp",
		// @Schedulesameplan",
		glue = "steps", monochrome = true

// ,dryRun = false
)

//parameter (name="browser" value="firefox")

//public class TestRunner 
//{}/* when run as testng 
public class TestRunner extends AbstractTestNGCucumberTests {

	@AfterMethod

	public void screenShot(ITestResult result) throws IOException {
		// Convert web driver object to TakeScreenshot

		Fid_base fidbase = new Fid_base();

		TakesScreenshot scrShot = ((TakesScreenshot) fidbase.driver);

		// Call getScreenshotAs method to create image file

		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

		// Move image file to new destination
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(10000);

		File DestFile = new File(
				"E:\\eclipse-workspace\\Fidentity\\test-output\\Faile dScreenshots\\failedimages" + randomInt + ".png");

		// Copy file at destination

		FileUtils.copyFile(SrcFile, DestFile);
		System.out.print("\n" + "ScreenShot method will execute  after every method ");

	}
}

// AbstractTestNGCucumberTests this is added when run with testng
