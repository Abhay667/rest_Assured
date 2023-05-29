package Sereialization;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;
public class Serialization {

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

APO.setTypes(AL); // passing list object
Location loc =new Location();// Creating Location object
loc.setLat(-38.383494); // using loc object to access there methods
loc.setLng(33.427362); // using loc object to access there methods


APO.setLocation(loc);        // sending location object in setter method

		String res =RestAssured.baseURI="https://rahulshettyacademy.com";
		given().log().all()
		.queryParam("key", "qaclick123").body(APO)  // passing 
		                                                          // now we are not going to give the entire body we have to serialize it.
		.when().post("/maps/api/place/add/json")
		.then().log().all()
		 .assertThat().statusCode(200)
		 .extract().response();
		System.out.println(res);
		
	}

}
