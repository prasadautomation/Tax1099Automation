Feature: Evacuation management

@Createfirstnotification
Scenario: Create new emergency notification

	Given Launch the fidentity portal 
	Given Sign in with credentials 
	And Goto Evacuation management
	When Create new notification with required details
	Then New evacuation notification created successfully 
	
##@Createnextnotification
##Scenario: Create new emergency notification

##	Given Launch the fidentity portal 
##	Given Sign in with credentials 
##	And Goto Evacuation management
##	When Click on create notification button
##	When Enter required details for create notification 
##	Then New evacuation notification created successfully 
	
@Importfromotherlocation
Scenario: Import from other location

	Given Launch the fidentity portal 
	Given Sign in with credentials 
	And Goto Evacuation management
	When Click on import notification
	When Select available location
	When Select needed notification and import notification
    Then imported evacuation notification added successfully
    # this test case verifies 
    # when there is no notifications available in other locations
    # when user try to import notification which is already available in currnt location
    
@Deletenotification
Scenario: Delete notification

	Given Launch the fidentity portal 
	Given Sign in with credentials 
	And Goto Evacuation management
	And Navigate to notifications list
	When Select one notification 
	When Click on delete menu
	When confirm the delete notification
    Then Notification will be deleted successfully
    # this test case includes when there is no notifications available in the list.

@Deletecancelnotification
Scenario: Delete cancel notification

	Given Launch the fidentity portal 
	Given Sign in with credentials 
	And Goto Evacuation management
	And Navigate to notifications list
	When Select one notification 
	When Click on delete menu
	When Cancel the delete confirmation 
    Then Notification deletion will be cancelled successfully           
    # this test case includes when there is no alerts available in the list.    
    
@Editalertnotification
Scenario: Edit alert notification

	Given Launch the fidentity portal 
	Given Sign in with credentials 
	And Goto Evacuation management
	And Navigate to notifications list
	When Select one notification 
	When Click on edit menu
	When Enter required fileds and save
    Then Notification will be edited successfully
    # this test case includes when there is no test cases available in the list.       
    
    
	