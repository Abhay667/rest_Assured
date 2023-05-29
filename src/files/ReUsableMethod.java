package files;

import io.restassured.path.json.JsonPath;
//we are parsing Response that is coming from rahul shetty.com
public class ReUsableMethod {
public static JsonPath RawToJson( String Response){ // getting string 
	
	
	JsonPath js = new JsonPath(Response); // parsing json and storing the response in js object
	
	return js; //returning  object
}
	
}
