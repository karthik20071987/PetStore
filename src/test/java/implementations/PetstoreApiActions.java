package implementations;

import java.io.IOException;

import org.junit.Assert;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import models.PetData;
import utils.ApiSpecBuilder;

public class PetstoreApiActions extends ApiSpecBuilder{
	
	private static Response response;
	
	
	public static void getPetsByStatus(String status) throws IOException {
    	
    	response = RestAssured.given().spec(requestSpecification()).when().get("/pet/findByStatus?status={status}",status);    	
    }
	
	public static boolean isStatusCodeProper() {
		
		int actualResponseCode = response.getStatusCode();
		if(actualResponseCode==200) {
			return true;
		}
		else {
			return false;
		}
	}

	public static void addNewPet(PetData pet) throws IOException {
		response = RestAssured.given().log().all().spec(requestSpecification()).when().body(pet).when().post("/pet").then().extract().response();			
	}

	public static void updatePetStatus(PetData pet, String status) throws IOException {
		pet.setStatus(status);
		response = RestAssured.given().log().all().spec(requestSpecification()).when().body(pet).when().put("/pet").then().extract().response();
	}

	public static void checkPetStatus(String status) {
		
		Assert.assertTrue(getJsonPath(response, "status").equalsIgnoreCase(status));
	}

	public static void deletePet() throws IOException {
		String petId = getJsonPath(response, "id");
		response= RestAssured.given().log().all().spec(requestSpecification()).when().delete("/pet/{petid}",petId).then().extract().response();
	}

}
