Feature:  profile

In order to test profile of user
 need to view the profile details and edit details

    Scenario: Admin able to view profile details
        
      
      Given Launch the fidentity portal
      And  Sign in with credentials
       When Go to Profile
       And select my profile
     
       Then Profile details will be displayed
      

       Scenario: Edit the profile
 
     When user click on edit profile
    And Enter required detials
    And click on update the details
    Then Profile details will be updated successfully