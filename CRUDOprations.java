package APITesting;
import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
public class CRUDOprations {
	int id;
	
	//@Test
	public void readuserData() {
		RequestSpecification requestSpec=RestAssured.given();
		requestSpec.baseUri("https://reqres.in/");
		requestSpec.basePath("/api/users?page=2");
	    Response res=requestSpec.get();
	    
	    res.prettyPrint();
	    Assert.assertEquals(res.statusCode(),200,"Check for status code");
	}
	
	@Test
	public void createuserData()
	{
		
		JSONObject data= new JSONObject();
		data.put("name", "Murlikrishna");
		data.put("job", "SoftwareTester");
		
		given()
		.header("content-Type","application/json")
		.contentType(ContentType.JSON)
		.body(data.toJSONString())
		
       .when()
       .post("https://reqres.in/api/users/"+id)
       
       
       
      .then()
       .statusCode(201)
       .log().all();
	 }

}
