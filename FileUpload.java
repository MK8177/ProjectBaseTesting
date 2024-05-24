package APITesting;

import static io.restassured.RestAssured.given;

import java.io.File;
import org.testng.annotations.Test;
public class FileUpload {

	
	//@Test
	public void fileUpload() {
		
		     File f= new File("C:\\Users\\ADMIN\\OneDrive\\Desktop\\APITestUpload.txt");
		

		        given()
			   .multiPart("file", f)
				
				.when()
				.post("http://httpbin.org/post")
				
				.then()
				.statusCode(200).log().all();
		}
	
	@Test
	
	public void image() {
		
		 File f= new File("C:\\Users\\ADMIN\\OneDrive\\Desktop\\image.png");
			

	        given()
		   .multiPart("file", f)
			
			.when()
			.post("https://petstore.swagger.io/v2/pet/1/uploadImage")
			
			.then()
			.statusCode(200).log().all();
		
	}
	
	
	
	
	
	
	
}
