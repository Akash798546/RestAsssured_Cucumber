package Payload;

import org.json.simple.JSONObject;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Payload {

	static JSONObject js=new JSONObject();
	
	public static String jsonPayloadForPost(RequestSpecification req,String key,String string1)
	{
    js.put(key, string1);
   
   String st=js.toJSONString();
return st;
   
	}
	
}
