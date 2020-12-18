 package CucumberOptions;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(  
	    features = "src/test/java/Cucumber_groupid/Automation_artifact/Fid_features",
	    glue= {"steps"},
	   plugin= {"pretty"},
	  monochrome=true
	    )

public class TestRunner   {
	
	

}


