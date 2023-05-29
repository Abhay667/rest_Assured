package Sereialization;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;
public class SpecBuilder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
AddPlace APO =new AddPlace(); // AddPlace class object to access its methods
APO.setAccuracy(50);
APO.setAddress("29, side layout, cohen 09");
APO.setLanguage("French-IN");
APO.setPhone_number("(+91) 983 893 3937");
APO.setWebsite("http://google.com");
APO.setName("Frontline house");
// create an array list

List<String>  AL = new ArrayList<String>();
AL.add("shoe park");
AL.add("shop");

APO.setTypes(AL); 
Location loc =new Location();
loc.setLat(-38.383494); 
loc.setLng(33.427362); 
APO.setLocation(loc);   


RequestSpecification reqspec =    // return type must be RequestSpecification
   new RequestSpecBuilder()  // creating requestSpecBuilder object
                       .setBaseUri("https://rahulshettyacademy.com") //all common values
                       .addQueryParam("key","qaclick123" )          //all common values
                       .setContentType(ContentType.JSON).build();  //all common values


		
		 RequestSpecification res =given() // whole request is Stored in RSClass 's object
				 .spec(reqspec) // here you can check you need return type as RequestSpecification 
		               .body(APO); // this is entire request 
		 
		 
	ResponseSpecification resSpec =	
		 new ResponseSpecBuilder()	
		                   .expectStatusCode(200)
	                       .expectContentType(ContentType.JSON)
	                       .build();		 
		 
		 
		 
		Response resp =  res         // from that object you are accessing the when request 
		.when().post("/maps/api/place/add/json") //on that request you are submitting 
		
	

		
		
		.then().spec(resSpec)
		 .extract().response();
		
		String response_string = resp.asString();
		System.out.println(response_string);
				
	}

}
