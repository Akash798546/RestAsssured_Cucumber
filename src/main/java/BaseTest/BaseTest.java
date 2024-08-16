package BaseTest;

import java.io.FileNotFoundException;
import java.io.PrintStream;

import Payload.Payload;
import ch.qos.logback.core.recovery.ResilientSyslogOutputStream;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class BaseTest extends Payload{
    protected static	RequestSpecification req;
	protected static Response res;
	static PrintStream log;

	

	public static RequestSpecification setRequest() throws FileNotFoundException
	{
		if(req==null) {
		log = new PrintStream("log.txt");
		RestAssured.baseURI = "https://reqres.in/";
		req = RestAssured.given();
		req.filter(RequestLoggingFilter.logRequestTo(log)).filter(ResponseLoggingFilter.logResponseTo(log));
		return req;
		}
		return req;
	}
	
	public static void  printResponse(Response res)
	{
		
		 String s= res.getBody().asPrettyString();
		 System.out.println("The Response body is :"+s);
	
	}
	
	public static void verifyStatusCode(Response resp,int n)
	{
		int code=resp.getStatusCode();
		System.out.println("The Status Code is :"+code);
		Assert.assertEquals(code, n);
		
	}
	
	public static void getSpecificData(Response res,String msg,String path)
	{
		String str=res.body().jsonPath().getString(path);
		System.out.println(msg+str);
	}
	public static void getAllHeaders(Response res)
	{
		Headers allhead=res.headers();
		for(Header head:allhead)
		{
			System.out.println(head.getName()+" : "+head.getValue() 	);
		}
	}
	
	public static void getSpecificHeader(Response res,String hd)
	{
		String hdr=res.header(hd);
		System.out.println("The "+hd+" is :"+hdr);
	}
	
	public static void setPayload(RequestSpecification req,String Key,String value)
	{
		req.body(Payload.jsonPayloadForPost(req, Key, value));
	}

	}
