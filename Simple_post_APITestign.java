package APITesting;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;
public class Simple_post_APITestign {
	
	int id;
	@Test(priority=1)
	public void createuser()
	{
		JSONObject data= new JSONObject();
		data.put("name", "Murli");
		data.put("job", "QA");
		
		id=given()
		.header("content-Type","application/json")
		.contentType(ContentType.JSON)
		.body(data.toJSONString())
		
       .when()
       .post("https://reqres.in/api/users")
       .jsonPath().getInt("id");
       
       
      // .then()
       //.statusCode(201)
       //.log().all();
	}
	
	@Test(priority=2)
	public void updateuser4()
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
	
	@Test(priority=3)
	public void deleteuser() {
		given()
		.when()
		.delete("https://reqres.in/api/users"+id)
		.then()
		.statusCode(204)
		.log().all();
		
		
	}
	
}
