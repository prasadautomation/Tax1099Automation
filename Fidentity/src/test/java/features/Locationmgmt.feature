Feature: Location management 

	In order to test Location management feature  
need to test create location

@EditLocation 
Scenario: Edit location 

	Given Launch the fidentity portal 
	Given Sign in with credentials 
	And Goto location management 
	When Edit location details 
	Then Location details will be edited successfully 
	#here we need to check mandatory fields 
@EditLoactionValidations 
Scenario: Edit location mandatory fields validations 

	Given Launch the fidentity portal 
	Given Sign in with credentials 
	And Goto location management 
	When Edit location validations 
	Then Location Validations done successfully 
	
@InactiveLocation 
Scenario: Inactive location 
	Given Launch the fidentity portal 
	Given Sign in with credentials 
	And Goto location management 
	And check the number of locations 
	When more than one active location available in list inactiavte random location 
	Then Inactivated location tested successfully 


@cancelinactiveLocation
Scenario: Cancel Inactive location
Given Launch the fidentity portal 
	Given Sign in with credentials 
	And Goto location management 
	And check the number of locations 
	When more than one active location available in list Click on Incative 
	When Click on cancel in inactive modal box
	Then Cancelled inactive location tested successfully  

@activateInactiveLocation
Scenario: Activate Inactive location
Given Launch the fidentity portal 
	Given Sign in with credentials 
	And Goto location management 
	And check the number of locations
	And Select Inactive location 
	And Click on active icon
	When Confirm the activation
	Then Inactive location activated successfully
	
	#we cannot delete when user is in trail period
	#scripted up to delete location alert because test case need to repeat many times  
	
	
@DeleteLocation 
Scenario: Delete location 

	Given Launch the fidentity portal 
	Given Sign in with credentials 
	And Goto location management 
	And check the number of locations 
	When more than one active location available in list delete location 
	And  Delete the location 
	Then Location details will be edited successfully 
	
@Createlocationinpaidplan 
Scenario: Create location in paid plan 

	Given  Launch the fidentity portal 
	Given  Sign in with credentials 
	And  Goto location management 
	Given  click on create location 
	When  Enter required details for loaction 
	When Save the details 
	Then location will be created successfully 
	
#@Createlocationwithinactivelicense
#Scenario: @Createlocationwithinactivelicense

@Downloadlocationreports
Scenario: Download location reports
	Given  Launch the fidentity portal 
	Given  Sign in with credentials 
	And  Goto location management 
	Given  Click on Download reports icon  
	And Select reports type 
	And Select required dates
	When Click on submit
	Then Reports downloaded successfully
	
@Downloadlocationreportsvalidations
Scenario: Download location reports validations 
	Given  Launch the fidentity portal 
	Given  Sign in with credentials 
	And  Goto location management 
	Given  Click on Download reports icon  
	When Check validations to download reports  
	Then Succeefully checked validations 
	# Check select type 
	# Check from and todates
	
@ResetDownloadlocationreports	
Scenario: Reset Download location reports
Given  Launch the fidentity portal 
	Given  Sign in with credentials 
	And  Goto location management 
	Given  Click on Download reports icon  
	And Select reports type 
	And Select required dates
	When Click on Reset
	Then Reset done download reports successfully
	