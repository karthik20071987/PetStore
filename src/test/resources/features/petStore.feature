Feature: This feature is to validate the basic API calls from petstore

@Sanity @Api
Scenario: Get pets by availability status from the petstore

Given User search for "available" pets
Then Pets are displayed