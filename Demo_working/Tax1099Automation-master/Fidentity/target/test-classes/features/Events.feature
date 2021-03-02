Feature: Events

@Createevent
Scenario: Create event
Given Sign in with credentials
Given Naviate to products 
Given Select events
When Click on create event                 
And Requierd details
And Save details and confirm
Then Event will be created successfully

@Cancelcreateevent
Scenario: Cancel create event
Given Sign in with credentials
Given Naviate to products 
Given Select events
When Click on create event                 
And Requierd details
And Click on cancel
Then Event will be cancelled successfully 

@Resetwhilecraeteevent
Scenario: Reset while craete event
Given Sign in with credentials
Given Naviate to products 
Given Select events
When Click on create event                 
And Requierd details
And Click on reset button
Then Done reset successfully 

@Editevent
Scenario: Edit event details
Given Sign in with credentials
Given Naviate to products 
Given Select events
When Choose not started event                 
And Click on edit
And Edit required details
And Save edited edvent details
Then Event details edited successfully

@Canceleditevent
Scenario: Cancel edit event
Given Sign in with credentials
Given Naviate to products 
Given Select events
When Choose not started event                 
And Click on edit
And Edit required details
And Cancel edit event details 
Then Cancelled edit event details successfully

@Reseteditevent
Scenario: Reset edit event
Given Sign in with credentials
Given Naviate to products 
Given Select events
When Choose not started event                 
And Click on edit
And Edit required details
And Reset edit event details  
Then Reset edit event details successfully

@changebannercustom
Scenario: Change banner
Given Sign in with credentials
Given Naviate to products 
Given Select events
When Choose not started event for change banner                  
And Click on edit
And Click on change banner opiton 
And Select custom banner and save 
Then Custom banner changed successfully

@changebannerdefault
Scenario: Change banner
Given Sign in with credentials
Given Naviate to products 
Given Select events
When Choose not started event for change banner                  
And Click on edit
And Click on change banner opiton 
And Select default banner and save  
Then Default banner changed successfully 

@Resetbannerchange
Scenario: Reset banner change
Given Sign in with credentials
Given Naviate to products 
Given Select events
When Choose not started event for change banner                  
And Click on edit
And Click on change banner opiton 
And Select custom banner and reset   
Then Reset banner Successfully

@Cancelbannerchange
Scenario: Cancel banner change
Given Sign in with credentials
Given Naviate to products 
Given Select events
When Choose not started event for change banner                  
And Click on edit
And Click on change banner opiton 
And Select custom banner and cancel    
Then Cancel banner Successfully

@Vieweventanalytics
Scenario: View event analytics
Given Sign in with credentials
Given Naviate to products 
Given Select events 
When Click on active event for view anaytics  
Then Event analytics page should be displayed 
##check stopped event and not started event

@Startevent
Scenario: Start event
Given Sign in with credentials
Given Naviate to products 
Given Select events
When Choose not started event to start  
And Click on start
And Check date validations
Then Event will be started successfully
## based on time zone event can start
@Stopevent
Scenario: Start event
Given Sign in with credentials
Given Naviate to products 
Given Select events
When Click on active event to stop  
And Stop that event
Then Event stopped successfully


@Addparticipant
Scenario: Start event
Given Sign in with credentials
Given Naviate to products 
Given Select events
When Click on active event
And select participantsmenu 
And Click on add
And Enter required details and add
Then Participant added successfully





@sampleprogram
Scenario: sample program
Given sample program
When sample when
Then test