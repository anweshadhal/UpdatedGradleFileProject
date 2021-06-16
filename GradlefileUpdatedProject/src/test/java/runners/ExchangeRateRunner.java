package runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;


@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
		features = "src/test/resources/features/ExchangeRateAPI.feature"
		,glue={"steps"},
		plugin={"pretty", "html:cucumberReport/cucumber-html-report","json:cucumberReport/cucumber-report.json"}
		
		//"json:reports/cucumber-report.json
		,tags="@getAllcountriesExchangeRate"
		//,tags={"@FixedDeposite"}
		//https://github.com/serenity-bdd/serenity-cucumber/issues/261
		
		)
public class ExchangeRateRunner {

}


///APIAutomationRestAssured/src/test/resources/ExchangeRateAPI.feature
//steps