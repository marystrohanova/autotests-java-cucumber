import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
  plugin = {"pretty", 
		    "html:target/cucumber", 
		    "html:target/cucumber-html-report", 
		    "json:target/cucumber.json"},
		    
  monochrome = true,  
  features = "classpath:features",
  tags = {"@BAT"},
//  features="src/test/resources/features/HomeSearchPage.feature",

  snippets = SnippetType.CAMELCASE
)
public class RunTest {

}
