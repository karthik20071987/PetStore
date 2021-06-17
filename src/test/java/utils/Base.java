package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.json.JSONArray;
import org.json.JSONObject;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Base {
	
	public String globalProertiesPath;
	private static JSONArray responseArray;
	
	public String getGlobalValue(String key) throws IOException {
		setPropFilePath();
		
		Properties prop =new Properties();
		FileInputStream fis =new FileInputStream(globalProertiesPath);
		prop.load(fis);
		return prop.getProperty(key);
	}
	
	private void setPropFilePath() {
		
		if(System.getProperty("os.name").contains("Windows"))
			globalProertiesPath = System.getProperty("user.dir")+"\\src\\main\\java\\resources\\global.properties";
		else {
			globalProertiesPath = System.getProperty("user.dir")+"/src/main/java/resources/global.properties";
		}
		
	}
	
    private static JSONArray getJsonArray(Response response) {

		String responseString = response.asString();
		responseArray = new JSONArray(responseString);
		return responseArray;

	}
    
	public static String getJsonPath(Response response,String key)
	{
		String resp=response.asString();
		JsonPath   js = new JsonPath(resp);
		return js.get(key).toString();
	}

}
