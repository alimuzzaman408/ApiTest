package apitestpackage;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC002_POST_Request {
	@Test
	 void registrationSuccesful(){
		
	//Specify base URI	
	RestAssured.baseURI="http://restapi.demoqa.com/customer";
	
	//Request object
	RequestSpecification httprequest=RestAssured.given();
	
	
	//Request payload sending along with post request
	JSONObject requestparams=new JSONObject();
	requestparams.put("FirstNme", "Jhon");
	requestparams.put("LastName", "Kevin");
	requestparams.put("UserName", "a5555");
	requestparams.put("Password", "b1234");
	requestparams.put("Email", "Jhon@yahoo.com");
	
	httprequest.header("Content-Type","application/json");//Adding header
	httprequest.body(requestparams.toJSONString());//Attach above data to the request
	
	//Response object
	Response response=httprequest.request(Method.POST,"/register");
	//print console in the response
	String responsebody=response.getBody().asString();
	System.out.println("Response body is :"+responsebody);
	//Status code verification
	int statuscode=response.getStatusCode();
	System.out.println("Status code :"+statuscode);
	Assert.assertEquals(statuscode, 201);
	
	//validate response
	String successful=response.jsonPath().get("SuccessCode");
	Assert.assertEquals(successful, "OPERATION_SUCCESS");
	
	}
	
	
	
	
	
//http://restapi.demoqa.com/customer

}
