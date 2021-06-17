Feature: This feature is to perform pets management like update, add, delete.


@Api
Scenario: User Adds and updates the pet status
Given User adds a pet
Then Pet is added to the store
When User updates the status to "sold"
Then Status is updated to "sold"

@Api
Scenario: User Adds and deletes a pet
Given User adds a pet
Then Pet is added to the store
When User deletes the pet
Then The pet is deleted