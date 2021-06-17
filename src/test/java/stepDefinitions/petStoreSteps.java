package stepDefinitions;

import java.io.IOException;

import org.junit.Assert;

import implementations.PetstoreApiActions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class petStoreSteps {
	
	PetstoreApiActions petstoreapiActions = new PetstoreApiActions();
	
	@Given("User search for {string} pets")
	public void i_search_for_pets(String status) throws IOException {
		PetstoreApiActions.getPetsByStatus(status);		
	}

	@Then("Pets are displayed")
	public void pets_are_shown() {
		Assert.assertTrue(PetstoreApiActions.isStatusCodeProper());
	}

	@Given("User adds a pet")
	public void user_adds_a_pet() throws IOException {
		PetstoreApiActions.addNewPet(petstoreapiActions.testPetData());
	}

	@Then("Pet is added to the store")
	public void pet_is_added_to_the_store() {
		Assert.assertTrue(PetstoreApiActions.isStatusCodeProper());
	}
	
	@When("User updates the status to {string}")
	public void user_updates_the_status_to(String status) throws IOException {
		PetstoreApiActions.updatePetStatus(petstoreapiActions.testPetData(),status);
	}
	
	@Then("Status is updated to {string}")
	public void status_is_updated_to(String status) {
		PetstoreApiActions.checkPetStatus(status);		
	}
	
	@When("User deletes the pet")
	public void user_deletes_the_pet() throws IOException {
		PetstoreApiActions.deletePet();
	}
	
	@Then("The pet is deleted")
	public void the_pet_is_deleted() {
		Assert.assertTrue(PetstoreApiActions.isStatusCodeProper());
	}
	
}
