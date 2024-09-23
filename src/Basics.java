import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import files.payload;

public class Basics {

	public static void main(String[] args) {
		// Validate if add place API is working as expected 
		//given - All input details 
		//when - submit the API
		//then  - Validate the API
		
		RestAssured.baseURI="https://rahulshettyacademy.com/";
		given().log().all().queryParam("key", "qaclick123").header("Content-type", "application/json")
		.body(payload.AddPlace())
		.when().post("maps/api/place/add/json")
		.then().log().all().assertThat()
		.statusCode(200)
		.body("scope", equalTo("APP"))
		.header("server", "Apache/2.4.52 (Ubuntu)")
		;
		
		

	}

}
