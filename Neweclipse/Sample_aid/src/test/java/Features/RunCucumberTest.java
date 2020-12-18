package Features;



import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.junit.Cucumber;

@CucumberOptions(   
		//features = "E:\\eclipse-workspace\\Fidentity\\src\\test\\java\\features\\UserActions.feature",tags="@ChangeAccountType",
			//features =  "E:\\eclipse-workspace\\Fidentity\\src\\test\\java\\features\\Addemployee.feature",tags=" @AddEmployee",
			 features = "E:/eclipse-workspace/Sample_aid/src/test/java/Features/GoogleSearch.feature",tags="@Searchtest",
			glue= "steps", 
			monochrome=true,dryRun = false)
 
public class RunCucumberTest {
 
}
