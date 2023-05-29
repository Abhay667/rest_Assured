import io.restassured.RestAssured; //for Rest_assured
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;// for given() method 
// Contains all static package of rest_assured
import static org.hamcrest.Matchers.*; // for equalTo("APP"))

import org.testng.Assert;

import files.ReUsableMethod;
import files.payload;
public class Basics {

	public static void main(String[] args) {
		
		
		RestAssured.baseURI="https://rahulshettyacademy.com"; //base URI or URL
		//*******************ADD PLACE*******************************************
	String Response =given() 
		.log().all()
		.queryParam("key", "qaclick123") 
		.header("Content-Type","application/json")
		.body(payload.AddPlace())
		.when() 
		.post("/maps/api/place/add/json")
	    .then()  
		//.log().all() 
		.assertThat()
		.statusCode(200)
		.body("scope", equalTo  ("APP"))
		.header("Server",equalTo("Apache/2.4.41 (Ubuntu)"))
		
		.extract().response().asString();   
		System.out.println(Response);
		JsonPath js = new JsonPath(Response); 
		 String place_id = js.getString("place_id"); 
	System.out.println(place_id);
	
	
	////////////////////////////////////////////////////////////////////////////////////////////
	//********************************UPDATE PLACE*************************************************
	// we have to update address
	// we are using place_id from above request, where it is actually generating place_id each time we send 
	// that request
	String updated_address="sim_city";
	
		String body ="{\r\n"
				+ "\"place_id\":\""+place_id+"\",\r\n"
				+ "\"address\":\""+ updated_address +"\",\r\n"
				+ "\"key\":\"qaclick123\"\r\n"
				+ "}";
		
		String update_response =given().log().all().queryParam("key", "qaclick123")
	.header("Content-Type","application/json") // sending resource 
	
	.body(body) // sending body to server 
	
	.when()
	     .put("/maps/api/place/update/json") // put request for 
	
	.then()
	     .assertThat().log().all()
	         .statusCode(200) 
	     .body("msg", equalTo  ("Address successfully updated")) //checking body response "msg"
	     .extract().response().asString(); // extracting body response 
		System.out.println(update_response);// checking response 
		
		
		//************************GET PLACE(specific place)********************************
		String get_response = given().log().all()
				.queryParam("key","qaclick123")
				.queryParam("place_id",place_id) // using place_id from ADD PLACE API
	.when()
		.get("maps/api/place/get/json")
	.then()
	  .assertThat().log().all()
	    .statusCode(200)
	    .extract().response().asString();
System.out.println(get_response); 
				   
//JsonPath js1 = new JsonPath(get_response);

JsonPath js1 = ReUsableMethod.RawToJson(get_response);// we are using user defined method to parse Response

String address = js1.getString("address"); // fetching address from response body
	System.out.println(address);
	
	Assert.assertEquals(address,updated_address); // assertion of TestNG
	// here 'updated_address' is the variable that we are providing(hardcoded)
	//here 'address' is the value we are getting from response body from server 
	}

}
