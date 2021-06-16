package apis.api;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.junit.Assert;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;

import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;

//import static net.serenitybdd.rest.SerenityRest.*;



public class ExchangeRateAPI {
	
	
//	public String projectLocation=System.getProperty("user.dir");
//	
//	File file = new File(projectLocation+"\\serenity.properties");
//	
//	FileInputStream fileInput = null;
//	Properties prop = new Properties();
	Response res;
//	public String url=null;
	
	public static final EnvironmentVariables variable = SystemEnvironmentVariables.createEnvironmentVariables();
	String url1;
	
	public void geturl()
	{
		url1=variable.getProperty("Exchange.rate.get");
		System.out.println("the URL1 is: "+url1);
	}
	
//	public void loadPropertyFile()
//	{
//		try {
//			fileInput = new FileInputStream(file);
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
//		
//		
//		//load properties file
//		try {
//			prop.load(fileInput);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

//	public void getEndPointURL() {
//		
//	loadPropertyFile();		
//	url=prop.getProperty("Exchange.rate.get");
//	System.out.println("The end point URL is: "+url);
//	}
//	

	public void getExchangeRates() {
		
		res=RestAssured.given().relaxedHTTPSValidation().header("Content-Type","application/json")
				.header("x-rapidapi-key","a540c3a679msh518d2e6ed2d580dp142bf8jsn40f8502f4d56")
				.header("x-rapidapi-host","exchangerate-api.p.rapidapi.com")
				.header("useQueryString","true")
				.when().get(url1);
		res.body().prettyPrint();
		String value=res.getBody().jsonPath().get("rates.AOA").toString();
		System.out.println("value is: "+value);
		System.out.println(res.getStatusCode());
	}

	public void validateStatus(String status) {
		String statuscode = String.valueOf(res.getStatusCode());
		Assert.assertTrue(status.equalsIgnoreCase(statuscode));
		
	}
	
}
