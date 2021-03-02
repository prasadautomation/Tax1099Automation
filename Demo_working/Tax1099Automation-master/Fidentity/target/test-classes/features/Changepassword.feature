Feature: Change password

@changepassword
    Scenario: Change password 
      
      Given Launch the fidentity portal
        When Sign in with credentials
      And Navigate to change password                                                                                                                             
      And Fill details
      And Click on update
      Then Password changed successfully 
      
@Changepasswordvalidations
      Scenario: Change password with validations
     Given Launch the fidentity portal
        When Sign in with credentials
      And Navigate to change password                                                                                                                             
      When Fill details with validations
      And Click on update
      Then Password validations checked successfully 