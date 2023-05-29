package files;

import org.testng.annotations.Test;// for TestNg annotation

import static io.restassured.RestAssured.*;// because of given()
import io.restassured.RestAssured;         // because of RestAssured
import io.restassured.path.json.JsonPath; // because of parsing Json

public class DynamicJson {
@Test
public void addBook()
{
	RestAssured.baseURI=("http://216.10.245.166");        
	String response =given()
	 .header("Content-Type","application/json")          
	 .body(payload.AddBook("gdjdd","88889898"))         // calling parameterized   payload
	 
	 
	 //.body(payload.AddBook())                             // calling static payload
	 .when()
	 .post("/Library/Addbook.php")                     
	.then()
	 .log().all().assertThat().statusCode(200)    
	 .extract().response().asString();              // extracting response in 'response' variable
JsonPath  js = ReUsableMethod.RawToJson(response); 
String id=js.getString("ID");                          //extracting value of ID from response
System.out.println(id);
	
}
}
