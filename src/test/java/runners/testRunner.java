package runners;

import commons.basedTest;
import cucumber.api.CucumberOptions;


@CucumberOptions(
		features = "src/test/java/features", //dua duong dan toi pack feature
		glue = "steps", //duong dan den pack step
		plugin = {  //tao report
		"pretty",
		"com.cucumber.listener.ExtentCucumberFormatter:my_report/Automation.html", //dang ky su dung extent report voi cucumber
		"html:my_report/cucumber-reports","pretty:my_report/cucumber-pretty.txt", "json:my_report/cucumber-3.json",
		"junit:my_report/cucumber-3.xml"}
		)

public class testRunner extends basedTest {

}
