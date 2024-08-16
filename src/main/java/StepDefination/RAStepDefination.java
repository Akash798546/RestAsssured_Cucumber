package StepDefination;

import java.io.FileNotFoundException;
import java.io.PrintStream;

import org.json.simple.JSONObject;

import BaseTest.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class RAStepDefination extends BaseTest{

	RequestSpecification request;
	Response response;
	PrintStream log;
	BaseTest base=new BaseTest();

	@Given("user have the base URL")
	public void user_have_the_base_url() throws FileNotFoundException {
		request=BaseTest.setRequest();
		}

	@Then("i want the response")
	public void i_want_the_response() throws FileNotFoundException {
		

		response = request.request(Method.GET, "/api/unknown");
		BaseTest.getSpecificData(response,"The All Ids Are : ","data.id");
		
	}

	@Then("status code verify")
	public void status_code_verify() {

		BaseTest.verifyStatusCode(response, 200);
	}

	@Then("user got response data")
	public void user_got_response_data() {
		BaseTest.printResponse(response);
		BaseTest.getSpecificHeader(response, "Content-Type");
	}
	
	@Then("get all Headers")
	public void get_all_Headers()
	{
		BaseTest.getAllHeaders(response);
	}
	
	@Given("Register payload with {string} and {string}")
	public void register_payload_with_and(String string1, String string2) throws FileNotFoundException {
	   
		request=BaseTest.setRequest();
//	    JSONObject js=new JSONObject();
//	    js.put("name", string1);
//	    js.put("job", string2);
//	    req.body(js.toJSONString());
		BaseTest.setPayload(request,"name",string1);
		BaseTest.setPayload(request,"job",string2);
	   
	}
	@Then("user set request as post")
	public void user_set_request_as_post() {
		
		response=req.post("/api/users");
	}
	
	@Then("verify status code")
	public void verify_status_code() {

		BaseTest.verifyStatusCode(response, 201);
	}
	
//	@Then("user got response")
//	public void user_got_response() {
//
//		BaseTest.printResponse(response);
//	}



}
