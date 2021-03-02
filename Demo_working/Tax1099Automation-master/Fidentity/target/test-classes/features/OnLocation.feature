Feature: On-Location 

@Checkout 
Scenario: Checkout 
	Given Launch the fidentity portal 
	When Sign in with credentials 
	And Navigate to Onlocation menu 
	And Click on check out icon 
	And Confirm the check out of visitor 
	Then Checked out done successfully 
	## When Select checked in record
	##   And Do checkout the visitor
	##    And Cancel the checkout
@CancelCheckout 
Scenario: Cancel checkout of visitor 
	Given Launch the fidentity portal 
	When Sign in with credentials 
	And Navigate to Onlocation menu 
	And Click on check out icon 
	And Cancel the check out of visitor 
	Then Checkout cancel done successfully 

@Addvisitortowatchlist
Scenario: Add visitor to the watchlist
    Given Launch the fidentity portal 
	When Sign in with credentials  
	And Navigate to Onlocation menu 
	And Click on Add watch list icon of selected visitor
	And Select watch list from dropdown
	And Confirm add wathlist of visitor
	Then Added watch list successfully 
	
@Whennowatchlistavailablevalidation
Scenario: NO watchlist available validation 
    Given Launch the fidentity portal 
	When Sign in with credentials  
	And Navigate to Onlocation menu 
	And Click on Add watch list icon of selected visitor
	And Click on watch list dropdown and Save
	Then There are no watchlist available validation will be displayed 

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
	
	
	
        