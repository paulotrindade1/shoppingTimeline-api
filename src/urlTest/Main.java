package urlTest;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class Main {

	public static void main(String[] args) {
		Gson gson = new Gson();
		
		String jsonUrl = "{\r\n" + 
				"  \"events\": [\r\n" + 
				"    {\r\n" + 
				"      \"event\": \"comprou-produto\",\r\n" + 
				"      \"timestamp\": \"2016-09-22T13:57:32.2311892-03:00\",\r\n" + 
				"      \"custom_data\": [\r\n" + 
				"        {\r\n" + 
				"          \"key\": \"product_name\",\r\n" + 
				"          \"value\": \"Camisa Azul\"\r\n" + 
				"        },\r\n" + 
				"        {\r\n" + 
				"          \"key\": \"transaction_id\",\r\n" + 
				"          \"value\": \"3029384\"\r\n" + 
				"        },\r\n" + 
				"        {\r\n" + 
				"          \"key\": \"product_price\",\r\n" + 
				"          \"value\": 100\r\n" + 
				"        }\r\n" + 
				"      ]\r\n" + 
				"    },\r\n" + 
				"    {\r\n" + 
				"      \"event\": \"comprou\",\r\n" + 
				"      \"timestamp\": \"2016-09-22T13:57:31.2311892-03:00\",\r\n" + 
				"      \"revenue\": 250,\r\n" + 
				"      \"custom_data\": [\r\n" + 
				"        {\r\n" + 
				"          \"key\": \"store_name\",\r\n" + 
				"          \"value\": \"Patio Savassi\"\r\n" + 
				"        },\r\n" + 
				"        {\r\n" + 
				"          \"key\": \"transaction_id\",\r\n" + 
				"          \"value\": \"3029384\"\r\n" + 
				"        }\r\n" + 
				"      ]\r\n" + 
				"    },\r\n" + 
				"    {\r\n" + 
				"      \"event\": \"comprou-produto\",\r\n" + 
				"      \"timestamp\": \"2016-09-22T13:57:33.2311892-03:00\",\r\n" + 
				"      \"custom_data\": [\r\n" + 
				"        {\r\n" + 
				"          \"key\": \"product_price\",\r\n" + 
				"          \"value\": 150\r\n" + 
				"        },\r\n" + 
				"        {\r\n" + 
				"          \"key\": \"transaction_id\",\r\n" + 
				"          \"value\": \"3029384\"\r\n" + 
				"        },\r\n" + 
				"        {\r\n" + 
				"          \"key\": \"product_name\",\r\n" + 
				"          \"value\": \"Calça Rosa\"\r\n" + 
				"        }\r\n" + 
				"      ]\r\n" + 
				"    },\r\n" + 
				"    {\r\n" + 
				"      \"event\": \"comprou-produto\",\r\n" + 
				"      \"timestamp\": \"2016-10-02T11:37:35.2300892-03:00\",\r\n" + 
				"      \"custom_data\": [\r\n" + 
				"        {\r\n" + 
				"          \"key\": \"transaction_id\",\r\n" + 
				"          \"value\": \"3409340\"\r\n" + 
				"        },\r\n" + 
				"        {\r\n" + 
				"          \"key\": \"product_name\",\r\n" + 
				"          \"value\": \"Tenis Preto\"\r\n" + 
				"        },\r\n" + 
				"        {\r\n" + 
				"          \"key\": \"product_price\",\r\n" + 
				"          \"value\": 120\r\n" + 
				"        }\r\n" + 
				"      ]\r\n" + 
				"    },\r\n" + 
				"    {\r\n" + 
				"      \"event\": \"comprou\",\r\n" + 
				"      \"timestamp\": \"2016-10-02T11:37:31.2300892-03:00\",\r\n" + 
				"      \"revenue\": 120,\r\n" + 
				"      \"custom_data\": [\r\n" + 
				"        {\r\n" + 
				"          \"key\": \"transaction_id\",\r\n" + 
				"          \"value\": \"3409340\"\r\n" + 
				"        },\r\n" + 
				"        {\r\n" + 
				"          \"key\": \"store_name\",\r\n" + 
				"          \"value\": \"BH Shopping\"\r\n" + 
				"        }\r\n" + 
				"      ]\r\n" + 
				"    }\r\n" + 
				"  ]\r\n" + 
				"}";
		
		//Type EventListType = new TypeToken<ArrayList<Event>>(){}.getType();  
			
		Events events = gson.fromJson(jsonUrl, Events.class);
		
		List<Timeline> timeline = new ArrayList<Timeline>();
		
		Collections.sort(events.getEvents(), new MyComparator());
		
		System.out.println(gson.toJson(events));
		System.out.println(gson.toJson(timeline));
		
	}

}
