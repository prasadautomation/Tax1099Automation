Feature: Add employee or admin


    @AddEmployee
    Scenario: Adding employee
    
        Given Sign in with credentials
        And Navigate to add employee 
        When Enter required fields
        And Select employee checkbox and add 
        Then Employee will be added successfully 
        
       @AddAdmin
    Scenario: Adding admin
        Given Sign in with credentials
        And Navigate to add employee 
        When Enter required fields
        And Select admin checkbox and add 
        Then Admin will be added successfully
        
        @Addingexistedemployeephone
     Scenario: Adding existed employee should show error
        Given Sign in with credentials
        And Navigate to add employee
        When Enter existed employee phone number
        Then Error displayed for phone number
                
       @Addingexistedemployeeemail
       Scenario: Adding existed employee should show error
        Given Sign in with credentials
        And Navigate to add employee
        When Enter existed email id
        Then Error displayed for email 
        