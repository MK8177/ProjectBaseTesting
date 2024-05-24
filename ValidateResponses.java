package APITesting;
import static io.restassured.RestAssured.*;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ValidateResponses {
	
	//@Test
	public void singleuser()
	{
		
		RequestSpecification req=given();
	    Response response=req.get("https://reqres.in/api/users/2");
	    int actual_status_code=response.getStatusCode();
	    System.out.println("Actual status code::"+actual_status_code);
	   
	    
	    
	 }

	//@Test
	public void sample()

	{
		Response response=given()
				.contentType(ContentType.JSON)
	    .when()
	    .get("https://reqres.in/api/users/2");
		
		// validate status code 
	    int actual_status_code=response.getStatusCode();
	    System.out.println("Actual status code::"+actual_status_code);
	    Assert.assertEquals(actual_status_code, 200);
	    
	    // validate jsonpath
	    String path=response.jsonPath().get("support.text").toString();
	    System.out.println("Jsonpath="+path);
	    Assert.assertEquals(path, "To keep ReqRes free, contributions towards server costs are appreciated!");
	    
	    //validate header
	    String header=response.header(("content-Type")).toString();
	    System.out.println("Header="+header);
	    Assert.assertEquals(header, "application/json; charset=utf-8");
	}
	
	@Test
	public void Sample2()
	{
		Response res=given()
		.contentType(ContentType.JSON)
		
		.when()
		.get("https://reqres.in/api/users?page=2");
		JSONObject jo= new JSONObject(res.asString());
		for(int i=0; i<jo.getJSONArray("data").length(); i++)
		{
			String emailarray=jo.getJSONArray("data").getJSONObject(i).get("email").toString();
			System.out.println(emailarray);
		}
	}
}
