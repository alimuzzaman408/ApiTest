package apitestpackage;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC005_GET_REquest {
	@Test
	public void getWeatherDetails(){

		RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city";

		//Request object
		RequestSpecification httprequest=RestAssured.given();
		//Response object
		Response response=httprequest.request(Method.GET,"/Delhi");

		//Print response in console window
		String responsebody=response.getBody().asString();
		System.out.println("Response body is :"+responsebody);
		Assert.assertEquals(responsebody.contains("Delhi"),true);
	}
}
