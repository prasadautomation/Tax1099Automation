Feature: On-Location 


    @Checkoutcancel 
    Scenario: Visitor checkout cancel by admin
    
        Given Sign in with credentials
        And Go to Onlocation menu
        When Select checked in record
        And Do checkout the visitor
        And Cancel the checkout
      Then Checked out cancelled successfully
      
      @Checkout
     Scenario: Checkout by admin 
     
      Given Sign in with credentials
        And Go to Onlocation menu
        When Select checked in record
       And Do checkout the visitor
       And conirm the checkout
       Then Visitor checked out successfully  
       
       @Extendtimecancel
     Scenario: Cancel extend checked in time   
       Given Sign in with credentials
        And Go to Onlocation menu
        When Do extend cancel for checked in record
        Then Extend time cancelled
        
        @Extendtime
         Scenario: Extend checked in time   
       Given Sign in with credentials
        And Go to Onlocation menu
        When Do extend for checked in record
       
        Then Checked in time extended successfully
        
        
        
        