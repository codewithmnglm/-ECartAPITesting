package resources;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Utils {
	public static RequestSpecification requestSpecification() {
		return new RequestSpecBuilder().setBaseUri("http://localhost:8080").setContentType(ContentType.JSON).build();
	}
	
	public JsonPath rowToJson(String response) {
		return new JsonPath(response);
	}
	



}
