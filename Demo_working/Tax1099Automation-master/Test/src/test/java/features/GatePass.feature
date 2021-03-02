Feature: Genearte visitor pass


    @Geneartepass
    Scenario: Genearte visitor pass
        Given Sign in with credentials
        When Go to vistor pass menu 
        And fill required fields and save
        Then Gate pass will be created successfully
        
  @Resendpass
        Scenario: Resend visitor pass
    Given Sign in with credentials
        When Go to vistor pass menu 
        And Unused gate passed more than one 
        Then Resend first gate pass
        
   @Deletepass
    Scenario: Delete visitorpass
    Given Sign in with credentials
        When Go to vistor pass menu 
        And Unused gate passed more than one 
        Then Delete gate pass