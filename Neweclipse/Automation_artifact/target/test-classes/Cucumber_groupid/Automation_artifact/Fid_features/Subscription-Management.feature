# language: en
Feature: Subscription Management


    @FID-285 
    Scenario: Active subscription
        
        Given User logged in to application
        And Logged in usertype is Admin or Global Admin
        When Subscription To be Expiry date is less than 14 days
        Then A notification is needs to be displayed "Your Subscription is about to expires by To be Expired Date"
        And with call of Action to Renew the Subscription

  