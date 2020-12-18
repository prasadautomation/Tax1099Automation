Feature: Application Login


Scenario: Home page default login
Given user is on net banking land page
When user login into application with user name and password
Then home page is populated
And cards are displayed
