package APITesting;
import static io.restassured.RestAssured.given;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class QueryPathParameters {
	
	//@Test
	public void testqueryandpath() {
		
		//https://reqres.in/api/users?page=2&id=7
		given()
		.pathParam("mypath", "users")
		.queryParam("page",2)
		.queryParam("id", 7)
		
		.when()
		 .get("https://reqres.in/api/{mypath}")
		
		.then()
		 .statusCode(200)
		  .log().all();
	}
	
	@Test
	public void cookies() {
		
		Response res=given()
		
		.when()
		.get("https://www.google.com");
		// single cookie
		//String cookies_value=res.cookie("AEC");
		//System.out.println(cookies_value);
		
		//get all cookies 
		
		Map<String,String> cookies_values=res.cookies();
		
		//System.out.println(cookies_values.keySet());
		
		for(String k:cookies_values.keySet())
		{
			String values= res.cookie(k);
			System.out.print(k+"         "+ values);
		}
		
		
	}
	
	

}
