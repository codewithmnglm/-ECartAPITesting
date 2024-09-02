package payload;

public class DataInputs {
	public  int id=8;
	public  String addProduct() {
		
		return " {\r\n"
				+ "        \"productId\": "+id+",\r\n"
				+ "        \"productName\": \"Acer\",\r\n"
				+ "        \"category\": \"Laptop\",\r\n"
				+ "        \"price\": 5000,\r\n"
				+ "        \"spec\": [\r\n"
				+ "            \"12GBGB\",\r\n"
				+ "            \"265GB\",\r\n"
				+ "            \"White\"\r\n"
				+ "        ]\r\n"
				+ "    }";
	}
	
public  String updateProduct() {
		
		return " {\r\n"
				+ "        \"productId\": "+id+",\r\n"
				+ "        \"productName\": \"Sony\",\r\n"
				+ "        \"category\": \"Laptop\",\r\n"
				+ "        \"price\": 5000,\r\n"
				+ "        \"spec\": [\r\n"
				+ "            \"12GBGB\",\r\n"
				+ "            \"265GB\",\r\n"
				+ "            \"White\"\r\n"
				+ "        ]\r\n"
				+ "    }";
	}

}
