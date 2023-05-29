import static io.restassured.RestAssured.*;

import files.ReUsableMethod;
import io.restassured.path.json.JsonPath;
public class oAuth_ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String url="https://rahulshettyacademy.com/getCourse.php?state=hhfgfhru&code=4%2F0AbUR2VOM3qCXW9R9Vobr72qiiKQVOqJgySKXUQRfUbzEym0LE43vdd6hKEVyGTR-_a4fZA&scope=email+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email+openid&authuser=1&prompt=none";
		String partial_code=url.split("code=")[1];
		String actual_code= partial_code.split("&scope")[0];
		System.out.println(actual_code);
	 String access_token =given().urlEncodingEnabled(false) // so it will take special characters (%) 
			 // getting access token
			 
		   .queryParams("code",actual_code) // passing code 
	      .queryParams("client_id","692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
	      .queryParams("client_secret","erZOWM9g3UtwNRj340YYaK_W")
	      .queryParams("redirect_uri","https://rahulshettyacademy.com/getCourse.php")
	      .queryParams("grant_type","authorization_code")
	      .when().log().all()
	      .post("https://www.googleapis.com/oauth2/v4/token").asString();
	 JsonPath  js = ReUsableMethod.RawToJson(access_token); // parsing access token
		 String Access_token =js.getString("access_token"); // fetching access token
		
		
		 
		
		 String response =given().queryParam("access_token",Access_token) //using this access token to fetch actual response
		.when().log().all()
		.get("https://rahulshettyacademy.com/getCourse.php").asString();// shortcut to get response without any assertions 
		 System.out.println(response);
	}

}
