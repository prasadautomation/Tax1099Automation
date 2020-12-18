Feature: Fidentity SignIn


    @Signintotheportal
    Scenario: Sign up to the fidentity portal
        
        Given Launch the fidentity portal
        When Sign in with credentials
        Then User signed in successfully
        
          @ForgotPassword
        Scenario: Forgot password
        Given Launch the login portal 
        When Enter required details 
        And click on forgot password 
        And enter otp along with other fields
        Then Forgot password done successfully
        
        @Forgotpasswordvalidations
        Scenario: Forgot password validations
        Given Launch the login portal 
        When Enter required details 
        And click on forgot password 
        And enter otp 
        And Check password validations
        
        
        
        
