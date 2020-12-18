Feature: Subscription Management

    @FID-285 
    Scenario: Active subscription
        Given Sign in with credentials
        When User choose different plan from current plan
        Then A notification is needs to be displayed "Your Subscription is about to expires by To be Expired Date"
        And with call of Action to Renew the Subscription
  