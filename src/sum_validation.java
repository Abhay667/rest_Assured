import org.testng.Assert;
import org.testng.annotations.Test;

import files.payload;
import io.restassured.path.json.JsonPath;

public class sum_validation {
@Test


public void sum_validation()
//6. Verify if Sum of all Course prices matches with Purchase Amount
{
	JsonPath js_sum = new JsonPath(payload.CoursePrice()); // accessing static method (to get prarsed json) 
	int course_count =js_sum.getInt("courses.size()");// number of course
	
	int purchase_amount2 = js_sum.getInt("dashboard.purchaseAmount"); // extracting total_price from response 
	int total_amount=0;
	//System.out.println(purchase_amount2);
	for(int k=0;k<course_count;k++) 
	{
		int price=js_sum.getInt("courses["+k+"].price");// extracting every course price
		int copies =js_sum.getInt("courses["+k+"].copies"); // extracting number of copies 
		total_amount=total_amount+price*copies;
		
		//System.out.println(copies);
	}// end of for loop
	System.out.println(total_amount); // calculating total amount by calculation
	Assert.assertEquals(total_amount,purchase_amount2); // comparing both values by using assertions 
}
}
