Feature:  Location management

In order to test Location management feature  
need to test create location

@EditLocation
    Scenario: Edit location
      
       Given Sign in with credentials
      And Goto location management                                                                                                                                 
      When Edit location details
      Then Location details will be edited successfully
      #here we need to check mandatory fields 
@EditLoactionValidations
 Scenario: Edit location mandatory fields validations
      
       Given Sign in with credentials
      And Goto location management                                                                                                                                 
      When Edit location validations 
      Then Location Validations done successfully
      
@InactiveLocation
         Scenario: Inactive location
      
       Given Sign in with credentials
      And Goto location management 
     And number of locations                                                                                                                                
      When more than one active location available in list inactiavte location
      Then Edit the location
      When there is one location available 
      Then location cannot be editable
       #we cannot delete when user is in trail period
       #scripted up to delete location alert because test case need to repeat many times  
 @DeleteLocation    
       Scenario: Delete location
      
       Given Sign in with credentials
      And Goto location management  
      And  number of locations                                                                                                                                           
      When more than one active location available in list delete location
      And Delete the location 
      Then Location details will be edited successfully