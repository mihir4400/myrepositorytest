#Each feature contains one feature.
#Feature files use Gherkin Language - business language.
Feature: Test the login functionality for sdet university.

#A feature may have different specific scenario

Scenario: the user should be able to login with correct username and correct password. 
Given user is on the login page
When user enters the correct username and correct password
And user clicks the login button
Then user gets confirmation

Scenario Outline: user should be able to login
Given user is on the login page
When user enters email <username>
And user enters password <password>
And user clicks the login button
Then user gets confirmation

Examples:
| username | password |
| tim@testemail.com | trpass|
| sw@testemail.com | sw2password |
| jv@testemail.com | jv4password |	