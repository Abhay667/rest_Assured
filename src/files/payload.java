package files;
// all payloads are here:-
public class payload {
	public static String AddPlace() // using static so need to create object
	{
		return"{\r\n"
				+ "  \"location\": {\r\n"
				+ "    \"lat\": -38.383494,\r\n"
				+ "    \"lng\": 33.427362\r\n"
				+ "  },\r\n"
				+ "  \"accuracy\": 50,\r\n"
				+ "  \"name\": \"Frontline house\",\r\n"
				+ "  \"phone_number\": \"(+91) 983 893 3937\",\r\n"
				+ "  \"address\": \"29, side layout, cohen 09\",\r\n"
				+ "  \"types\": [\r\n"
				+ "    \"shoe park\",\r\n"
				+ "    \"shop\"\r\n"
				+ "  ],\r\n"
				+ "  \"website\": \"http://google.com\",\r\n"
				+ "  \"language\": \"French-IN\"\r\n"
				+ "}\r\n"
				+ "";
	}
	
	// mock response :-
	public static String CoursePrice() // method which returns String 
	{
		return"{\r\n"
				+ "  \"dashboard\": {\r\n"
				+ "    \"purchaseAmount\": 910,\r\n"
				+ "    \"website\": \"rahulshettyacademy.com\"\r\n"
				+ "  },\r\n"
				+ "  \"courses\": [\r\n"
				+ "    {\r\n"
				+ "      \"title\": \"Selenium Python\",\r\n"
				+ "      \"price\": 50,\r\n"
				+ "      \"copies\": 6\r\n"
				+ "    },\r\n"
				+ "    {\r\n"
				+ "      \"title\": \"Cypress\",\r\n"
				+ "      \"price\": 40,\r\n"
				+ "      \"copies\": 4\r\n"
				+ "    },\r\n"
				+ "    {\r\n"
				+ "      \"title\": \"RPA\",\r\n"
				+ "      \"price\": 45,\r\n"
				+ "      \"copies\": 10\r\n"
				+ "    }\r\n"
				+ "  ]\r\n"
				+ "}";
	}
	public static String AddBook(String aisle, String isbn) {            
		 String payload ="\r\n" // storing in String
		+ "{\r\n"
		+ "\r\n"
		+ "\"name\":\"Learn something\",\r\n"             //dynamic payload
		+ "\"isbn\":\""+isbn+"\",\r\n"     //  "+var+ "->terminate the string, add +, add var 
		+ "\"aisle\":\""+aisle+"\",\r\n"  // then add + ,then terminate the string
		+ "\"author\":\"Johny foey\"\r\n"
		+ "}\r\n"
		+ "";
		 return payload; // returning that String
	}
	
	public static String AddBook() {            
		 String payload ="\r\n"
		 		+ "{\r\n"
		 		+ "\r\n"
		 		+ "\"name\":\"Leavrn something\",\r\n"    
		 		+ "\"isbn\":\"ghtyu\",\r\n"                       //static payload
		 		+ "\"aisle\":\"989898666\",\r\n"
		 		+ "\"author\":\"Johny foey\"\r\n"
		 		+ "}\r\n"
		 		+ "";
		 return payload; // returning that String
	}
	


}
