Feature: Kiosk Management 

@Addkiosk 
Scenario: Add kiosk 

	Given Sign in with credentials 
	And Go to kiosk management 
	When Add kiosk
	Then Kiosk added successfully
	
@DeleteKiosk
Scenario: Delete kiosk 

	Given Sign in with credentials  
	And Go to kiosk management 
	When Delete kiosk
	Then Kiosk delted successfully	
	
@Editkiosk
Scenario: Delete kiosk 

	Given Sign in with credentials  
	And Go to kiosk management 
	When Edit kiosk
	Then Kiosk edited successfully	
		
@Dettachkiosk
Scenario: Dettach kiosk 

	Given Sign in with credentials  
	And Go to kiosk management 
	When Dettach kiosk
	Then Kiosk dettached successfully			
	#Attach kiosk is not possible in automation

@DettachkioskCancel
Scenario: Dettach kiosk 

	Given Sign in with credentials  
	And Go to kiosk management 
	When Cancel the dettach kiosk
	Then Cancellation of Kiosk dettached done successfully	
	
	
	
