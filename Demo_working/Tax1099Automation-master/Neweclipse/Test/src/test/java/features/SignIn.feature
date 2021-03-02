Feature: Fidentity SignIn


    @FID-285 
    Scenario: Sign up to the fidentity portal
        
        Given Launch the fidentity portal
        When Sign in with credentials
        Then User signed in successfully
        
