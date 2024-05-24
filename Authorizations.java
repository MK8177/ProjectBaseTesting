package APITesting;
import static io.restassured.RestAssured.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
public class Authorizations {
	
	//@Test
	public void Basicauthorization() {
		
		given()
		.auth().basic("postman", "password")

		
		.when()
	     .get("https://postman-echo.com/basic-auth")
		.then()
		.statusCode(200);
		
	}   
	
	@Test
	public void digestauthication() {

       RequestSpecification requestspecification=RestAssured.given();
       requestspecification.baseUri("https://httpbin.org");
       requestspecification.basePath("/digest-auth/undefined/radical/password");
       
       Response  response=requestspecification.auth().digest("radical", "password").get();
       int status_code=response.statusCode();
       System.out.println("Response Status code:"+status_code);
      
       System.out.println("------------------------------------");
      
       String status_line=response.statusLine();
       System.out.println("Response Status Line:"+status_line);
      
	}

}
