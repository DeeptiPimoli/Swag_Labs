package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="C:/Users/Hp/Desktop/deepti/Sprint2/src/test/resources/AppFeatures/Pricing.feature",
				glue= {"stepDefinitions"},
				dryRun=false,
				monochrome=true) //AND


public class TestRunner
{

	//tags= {"not @Smoke"}
	//and->= {"@Sanity and @Regression"},{"@Sanity", "@Regression"}
	//or ->={"@Sanity and @Regression"},{"@Sanity,@Regression"}
	//not=>={not @Sanity} //false  //{"src/test/resources/AppFeatures/Pricing.feature"}
   // "C:/Users/Hp/Desktop/deepti/Sprint2/src/test/resources/AppFeatures/Pricing .feature"
}
