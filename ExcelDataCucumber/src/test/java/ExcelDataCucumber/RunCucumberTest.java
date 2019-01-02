package ExcelDataCucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features="src\\test\\resources\\ExcelDataCucumber\\Login.feature",
		plugin = {"pretty"}, monochrome=true)
public class RunCucumberTest {
}