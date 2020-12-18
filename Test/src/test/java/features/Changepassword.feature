Feature: Change password

@changepassword
    Scenario: Change password 
      
      Given Sign in with credentials
      And Navigate to change password                                                                                                                             
      When Fill details
      And Click on update
      Then Password changed successfully 
      
@Changepasswordvalidations
      Scenario: Change password with validations
      
      Given Sign in with credentials
      And Navigate to change password                                                                                                                             
      When Fill details with validations
      And Click on update
      Then Password validations checked successfully 