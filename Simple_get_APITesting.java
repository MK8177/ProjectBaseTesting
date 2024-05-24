package APITesting;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Simple_get_APITesting {

	@Test
	public void testCase1() {
		
		Response response =get("https://reqres.in/api/users?page=2");
		System.out.println("Response from the server::"+response.asString());
		System.out.println("Status code of the application::"+response.getStatusCode());
		Assert.assertEquals(200,response.getStatusCode());
		System.out.println("Response Body::"+response.getBody().asString());
		
	}
}
