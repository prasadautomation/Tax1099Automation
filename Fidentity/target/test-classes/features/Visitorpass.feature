Feature: Generate visitor pass 


@Generatepass 
Scenario: Genearte visitor pass 
	Given Launch the fidentity portal 
	Given Sign in with credentials 
	When Navigate to create visitor pass 
	And Create visitor pass by enter required fields 
	Then Gate pass will be created successfully 
@Resetgeneratepass
	Scenario: Genearte visitor pass 
	Given Launch the fidentity portal 
	Given Sign in with credentials 
	When Navigate to create visitor pass 
	And Enter required fields for create visitor pass
	And Click on Reset button 
	Then Visitor pass fileds done reset successfully
	
	@Cancelgeneratepass
	Scenario: Cancel generate pass 
	Given Launch the fidentity portal 
	Given Sign in with credentials 
	When Navigate to create visitor pass 
	And Enter required fields for create visitor pass
	And Click on Cancel button  
	Then Visitorpass creation cancelled successfully
	
		@Checkvisitorpassmandatoryfields
			Scenario: Check visitorpass mandatory fields 
	Given Launch the fidentity portal 
	Given Sign in with credentials 
	When Navigate to create visitor pass 
	And Check mandatory fields to create visitor pass
	Then Check mandatory fields successfully
	
@Resendpass 
Scenario: Resend visitor pass 
	Given Launch the fidentity portal 
	Given Sign in with credentials 
	When Go to vistor pass menu 
	When Click on resend visitorpass 
	When Confirm resend visitor pass
	Then Visitorpass has been resend successfully  
	
@Deletepass 
Scenario: Delete visitorpass 
	Given Sign in with credentials 
	When Go to vistor pass menu 
	And Unused gate passed more than one 
	Then Delete gate pass 
       