package steps;

import apis.api.ExchangeRateAPI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
//import cucumber.api.java.en.Given;
//import cucumber.api.java.en.Then;
//import cucumber.api.java.en.When;
import io.cucumber.java.en.When;

public class ExchangeRateSteps {
	
	ExchangeRateAPI exchangeRateAPI=new ExchangeRateAPI();
	@Given("^with the end point URL$")
	public void with_the_end_point_URL() throws Throwable {
		exchangeRateAPI.geturl();
	}

	@When("^request send with base code$")
	public void request_send_with_base_code() throws Throwable {
		exchangeRateAPI.getExchangeRates();
	}

	@Then("^verify the \"([^\"]*)\" in step$")
	public void verify_the_in_step(String status) throws Throwable {
		exchangeRateAPI.validateStatus(status);
	}

}
