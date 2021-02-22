Feature: Employe Actions 
@EditEmployeevalidations 
Scenario: Mandatory fields vaildation 
  Given Launch the fidentity portal
        When Sign in with credentials
	And Navigate to employee actions 
	When Validate edit employee mandatory fields 
	Then Mandatory fileds successfully Checked 
	#here we need to check mandatory fields 
	
@EditEmployee 
Scenario: Edit Edit employee 

	Given Launch the fidentity portal 
	Given Sign in with credentials 
	And Navigate to employee actions 
	When Edit required fields 
	Then Employee details successfully edited 
	
@Validatefileds 
Scenario: Edit employee field to field validation 

	Given Launch the fidentity portal 
	Given Sign in with credentials 
	And Navigate to employee actions 
	When Validate editable fields 
	Then Editable fields validate successfully 
	
@DeleteEmployee 
Scenario: Delete employee from list 

	Given Launch the fidentity portal 
	Given Sign in with credentials 
	And Navigate to employee actions 
	When Click on delete employee 
	And confirm the delete action 
	Then Delete employee done successfully 
	# Root user validation checked here
	
@CancelDeleteEmployeeAction 
Scenario: Delete employee from list 
	Given Launch the fidentity portal 
	Given Sign in with credentials 
	And Navigate to employee actions 
	When Click on delete employee 
	And Cancel the delete employee action 
	Then Cancelled delete employee action successfully 
	
@Deactivateemployee 
Scenario: Deactivate employee 
	Given Launch the fidentity portal 
	Given Sign in with credentials 
	And Navigate to employee actions 
	When Click on deactivate employee 
	And Confirm the deactivation 
	Then Employee deactivation done successfully 
	
@Canceldeactivation 
Scenario: Cancel deactivate employee 
	Given Launch the fidentity portal 
	Given Sign in with credentials 
	And Navigate to employee actions 
	When Click on deactivate employee 
	And Cancel the deactivation 
	Then Cancel deactivation of employee done successfully 
	
	
      