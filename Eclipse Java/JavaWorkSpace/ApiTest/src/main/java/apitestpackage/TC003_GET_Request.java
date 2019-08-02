package apitestpackage;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC003_GET_Request {
	@Test
	public void getinfo(){
		//Specify base URI
		RestAssured.baseURI="https://maps.googleapis.com";

		//Request object
		RequestSpecification httprequest=RestAssured.given();
		//Response object
		Response response=httprequest.request(Method.GET,"/maps/api/place/nearbysearch/xml?location=-33.8670522,151.1957362&radius=1500&type=supermarket&key="
				+ "AIzaSyBjGCE3VpLU4lgTqSTDmHmJ2HoELb4Jy1s");

		//Print response in console window
		String responsebody=response.getBody().asString();
		System.out.println("Response body is :"+responsebody);
	    
		//Validating header
		String contenttype=response.header("Content-Type");//Capturing details of content type header
		System.out.println("Content type is :"+contenttype);
		Assert.assertEquals(contenttype, "application/xml; charset=UTF-8");
		
		String contentcoding=response.header("Content-Encoding");//Capturing details of content coding header
		System.out.println("Content Encode  is :"+contentcoding);
		Assert.assertEquals(contentcoding, "gzip");
		
		
		
		
		

		
		
		
	}
	
	

}
