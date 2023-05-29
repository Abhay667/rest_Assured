package pojo;
import static io.restassured.RestAssured.*;

import files.ReUsableMethod;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
public class oAuth_ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String url="https://rahulshettyacademy.com/getCourse.php?state=hhfgfhru&code=4%2F0AbUR2VP9FAL_oOxYgaF6A6s6fGwBlOUEa9OXHmhfgin-Bl1BOB1Nv0KIgHEhWzFWyc6ozA&scope=email+openid+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email&authuser=1&prompt=none";
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
		
		
		 
		
		 GetCourse gcob =given().queryParam("access_token",Access_token).expect().defaultParser(Parser.JSON)
				 // we are  telling that that Parse that in Json format because that what we needed for pojo classes
				 
		.when()
		//.get("https://rahulshettyacademy.com/getCourse.php").asString();
		.get("https://rahulshettyacademy.com/getCourse.php").as(GetCourse.class);
		 // we do not need response in String we need in the form of object so that we can access getter and setter methods
		 
		 
		 //System.out.println(gcob.getLinkedIn());
		 
		//getCourses(); // it means giving the object of another class (object of Courses class)
		//  so you can access Courses class methods
		//gcob.getCourses().getApi(); // it returns object of Api class 
		// so you can access all Api class methods
		// it is list of objects so specify at which number of object you need
		 // then specify the property name  
		//gcob.getCourses().getApi().get(1).getCourseTitle();
		 
		 System.out.println(gcob.getCourses().getApi().get(1).getCourseTitle());
		 int size =gcob.getCourses().getApi().size();
		 System.out.println(size);
		 for(int i=0;i<size;i++)
		 {
			if(gcob.getCourses().getApi().get(i).getCourseTitle().equals("SoapUI Webservices testing")) 
			{
				System.out.println(gcob.getCourses().getApi().get(i).getPrice());
			}
		 }
		 
		 
		 
		 
	}

}
