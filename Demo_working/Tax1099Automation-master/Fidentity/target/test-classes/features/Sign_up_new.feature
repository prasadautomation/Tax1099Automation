Feature: Fidentity Signup


    # @FID-285 
    @Signup
    Scenario: Sign up to the fidentity portal
        
        Given Launch the fidentity portal for signup
        When Enter the required details and save
        And Login with otp and password 
        Then User signed up successfully
        
        @SignupFieldvalidations
        Scenario: Sign up flow fields to field validations
       Given Launch the fidentity portal for signup
        When Enter the required details with field validations 
        Then All the field validations done successfully 
        
        @SignupResumeProcess
        Scenario: User able to resume signup process
        Given Launch the fidentity portal for signup
        Given Complete few steps of signup flow 
        When Stop the checkin flow and exit from the portal
        When Open the portal and login with credentials
        Then User can able to resume signup flow 
        Then Signup flow will be completed 
             
