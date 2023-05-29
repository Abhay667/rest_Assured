import org.testng.Assert;

import files.payload;
import io.restassured.path.json.JsonPath;

public class CompexJsonParse {

	public static void main(String[] args) {
		
// sending mock response and pars it (class name.method name)
 JsonPath js_complex = new JsonPath(payload.CoursePrice());
		 
	int course_count =js_complex.getInt("courses.size()");
	//System.out.println(course_count);
	
//*****************************************
		
    int purchase_amount= js_complex.getInt("dashboard.purchaseAmount");
		//System.out.println(purchase_amount);
		
//*****************************************
	
	//String course_name =js_complex.getString("courses[0].title");
		//System.out.println(course_name);
//*****************************************
		//4. Print All course titles and their respective Prices
		//for( int i=0;i<course_count;i++) // course_count is a variable declared above 
		//{ 
			//carefully concatenate i you have to only use i variable, brackets and other things must be in
			//double quotes
			//extracting name of titles, here we are using .get() method
			// so we need to tell println() it is string because it accepts only string
			
			
			//String course_title=js_complex.get("courses["+i+"].title");
			// System.out.println(course_title);
		//here we are using .toString() for println() because it accepts string
			
		// here directly printing values by using .get() and .toString() method
			 //System.out.println(js_complex.get("courses["+i+"].price").toString());
			
		// here we are using .getInt() thats why we don't need to specify .toString() method
			 //System.out.println(js_complex.getInt("courses["+i+"].copies"));

	   //}// end of for loop
    
  //5. Print no of copies sold by RPA Course
		
//		for(int j=0;j<course_count;j++)
//		 {
//			String title_value=js_complex.get("courses["+j+"].title"); // each time we are extracting course title
//			//System.out.println(title_value);
//			if(title_value.equalsIgnoreCase("RPA"))// can not use ==, checking whether we get particular course
//			{
//				System.out.println(js_complex.getInt("courses["+j+"].copies")); //Printing its number of copies
//				break;
//			}
//			 
//		 }
		//end of for loop
    //6. Verify if Sum of all Course prices matches with Purchase Amount
    
		
	}

}
