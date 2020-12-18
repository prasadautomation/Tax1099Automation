Feature:  Integrations

In order to test Integrations of user
 need to enable any integration those are Gsuite and Active directory 

@Test1
    Scenario: Enable Gsuite
       
       Given Launch the fidentity portal
      And  Sign in with credentials
       When Go to Integrations
       And Enable the Gsuite
       Then Gsuite will be successfully enabled
    
     @Test2  
         Scenario: Enable Active directory
              
       Given Launch the fidentity portal
       And  Sign in with credentials
       When Go to Integrations
       And Enable the Active directory
       Then Active directory will be successfully enabled
       
       @Test3       
       Scenario: At anypoint of time one integartion should be in active state
       
      Given Sign in with credentials
      
       When Go to Integrations
       And Any integration is in active state
       And activate other integartion
       Then Dispay the message 
       
         @Test4   
       Scenario: Check last synced date for gsuite
       
      Given Sign in with credentials
      When Go to Integrations
       And Enable the gsuite  
       And Goto employee list
       Then Dispay last synced date
        When Go to Integrations
       And Enable the Gsuite
       @Test5 
         Scenario: Check last synced date for Ac
       
      Given Sign in with credentials
     
       When Goto employee list
       Then Dispay last synced date
       