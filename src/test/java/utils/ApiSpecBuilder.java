package utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import models.CategoryData;
import models.PetData;
import models.TagData;

public class ApiSpecBuilder extends Base {
	
	public static RequestSpecification request;
	private static String logFileName = "log_"+getDate()+ "_" + getTime()+".txt";
	
    public static RequestSpecification requestSpecification() throws IOException
	{
		
		if(request==null)
		{
		PrintStream log = new PrintStream(new FileOutputStream(logFileName));
		request = new RequestSpecBuilder().setBaseUri("https://petstore.swagger.io/v2")
				 .addFilter(RequestLoggingFilter.logRequestTo(log))
				 .addFilter(ResponseLoggingFilter.logResponseTo(log))
				 .setContentType(ContentType.JSON)
				 .build();
		
		 return request;
		}
		return request;
		
	}
    
    public static PetData testPetData() {
    	PetData petData = new PetData();
    	CategoryData categoryData = new CategoryData();
    	TagData tagData = new TagData();
    	
    	petData.setId((Math.abs(new Random().nextInt())));
    	categoryData.setId(99);
    	categoryData.setName("TestNamePet");
    	petData.setCategory(categoryData);
    	petData.setName("Test_K");
    	
    	List<TagData> tag = new ArrayList<TagData>() {};
    	    	
    	tagData.setId(99);
    	tagData.setName("K_Test");
    	tag.add(tagData);
    	petData.setTags(tag);
    	petData.setStatus("available");
    	
    	List<String> photoUrl = new ArrayList<String>(){};
    	photoUrl.add("testphotourl_K");
    	petData.setPhotoUrls(photoUrl);
    	return petData;
    }
    
    String end = getDate()+ "_" + getTime();
    
    private  final static String getDate(  )   {
          DateFormat df = new SimpleDateFormat( "yyyy-MM-dd" ) ;
          //df.setTimeZone( TimeZone.getTimeZone( "PST" )  ) ;
          return ( df.format( new Date(  )  )  ) ;
      }
   private  final static String getTime(  )   {
          DateFormat df = new SimpleDateFormat( "hh-mm-ss" ) ;
          //df.setTimeZone ( TimeZone.getTimeZone ( "PST" )  ) ;
         // df.setTimeZone( TimeZone.getTimeZone( "Singapore" )  ) ;
           
           
          return ( df.format( new Date(  )  )  ) ;
      }

}
