Feature: Add employee or admin 


@AddEmployeewithoutlogin 
Scenario: Adding employee 

	Given Sign in with credentials 
	And Navigate to add employee 
	When Enter required fields 
	And Click on add button 
	Then Employee will be added successfully 
	
@AddEmployeewithlogin 
Scenario: Adding employee with login 

	Given Sign in with credentials 
	And Navigate to add employee 
	When Enter required fields 
	And Select create login account 
	And Click on add button 
	Then Employee will be added successfully 
	
@AddEmployeewithadminaccess 
Scenario: Adding employee with admin admin access 
	Given Sign in with credentials 
	And Navigate to add employee 
	When Enter required fields 
	And Select create login account 
	And Select grant admin access 
	And Click on add button 
	Then Employee will be added successfully 
	
@Addingexistedemployeephone 
Scenario: Adding existed employee phone number should show error 
	Given Sign in with credentials 
	And Navigate to add employee 
	When Enter required fields with existed phone number 
	And Click on add for add employee 
	Then Phone number validation will be displayed 
	
@Addingexistedemployeeemail 
Scenario: Adding existed employee email should show error 
	Given Sign in with credentials 
	And Navigate to add employee 
	When Enter required fields with existed email 
	And Click on add for add employee 
	Then Phone number validation will be displayed 
	                                                
@AddemployeeRequiredfieldvalidation 
Scenario: AddemployeeRequiredfieldvalidation 
	Given Sign in with credentials 
	And Navigate to add employee 
	When Validate required fileds 
	Then Add employee requieredfiled validation done successfully 
        