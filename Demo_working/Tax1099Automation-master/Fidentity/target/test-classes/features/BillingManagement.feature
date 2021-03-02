Feature: Subscription Management 
#Login with trail period account give details in sign in class

@CheckBillingOverview
Scenario: Check billing overview
Given Sign in with credentials 
And Navigate to Billing management 
When Click on overview menu
Then Billing overview will be displayed 

@CheckBillingdetails
Scenario: Check billing overview
Given Sign in with credentials 
And Navigate to Billing management 
When Click on Billing details  
Then Billing details will be displayed

@CheckBillHistory
Scenario: Check billing overview
Given Sign in with credentials 
And Navigate to Billing management 
When Click on Billing history  
Then Billing history will be displayed 

@BillingEstimate
Scenario: Check billing overview
Given Sign in with credentials 
And Navigate to Billing management 
When Click on Billing estimate  
Then Billing estimate will be displayed  

@Cancelsubscription
Scenario: Check billing overview
Given Sign in with credentials 
And Navigate to Billing management 
When Click on Manage subscription
When Click on Cancel subscription
When Confirm Canel    
Then Subscription cancelled successfully 

@Downgradeplan
Scenario: Downgrade plan
Given Sign in with credentials 
And Navigate to Billing management 
When Click on Manage subscription
When Select downgrade plan 
When Confirm the card details
Then Downgrade plan subscribed successfully

@Upgradeplan
Scenario: Downgrade plan
Given Sign in with credentials 
And Navigate to Billing management 
When Click on Manage subscription
When Select upgrade plan   
When Confirm the card details
Then Upgrade plan subscribed successfully

# Schedule same plan for trail customer
@Schedulesameplan
Scenario: Schedule same plan
Given Signup to the fidentity portal 
And Navigate to Billing management 
When Click on Manage subscription
When Select continue same plan 
When Submit the card details
When Update subscription adn confirm
Then Same plan will be scheduled for trail customer sucessfully

@Editcarddetails
Scenario: Edit card details
Given Sign in with credentials 
And Navigate to Billing management 
When Click on Billing details  
When Edit card details
Then Card details will be edited successfully





@Trailperiodone 
Scenario: Continue the same plan - premium monthly 
	Given Sign in with credentials 
	And Navigate to manage Subscription 
	When Choose current plan 
	And Enter required details and submit 
	And Click on update subscription 
	Then Same plan updated successfully 
	#Login with trail period account give details in sign in class
@Trailtostdmonthly 
Scenario: 
	Select different plan from trail - premium yearly/Std monthly/Std Yearly/Basic 
	Given Sign in with credentials 
	And Navigate to manage Subscription 
	When Choose statndard monthly plan 
	And Enter required details and submit 
	And Click on update subscription 
	Then Standard monthly Plan updated successfully 
	#Login with trail period account give details in sign in class
@Trailtostdannually 
Scenario: 
	Select different plan from trail - premium yearly/Std monthly/Std Yearly/Basic 
	Given Sign in with credentials 
	And Navigate to manage Subscription 
	When Choose statndard Yearly plan 
	And Enter required details and submit 
	And Click on update subscription 
	Then Standard yearly Plan updated successfully 
	
	#Login with trail period account give details in sign in class
@Trailtopremiumyearly 
Scenario: 
	Select different plan from trail - premium yearly/Std monthly/Std Yearly/Basic 
	Given Sign in with credentials 
	And Navigate to manage Subscription 
	When Choose premium Yearly plan 
	And Enter required details and submit 
	And Click on update subscription 
	Then Premium yearly Plan updated successfully 
	
	#Login with trail period account give details in sign in class as well as myOrganization-check plan method need to give domain url 
@carddetails_validations 
Scenario: Check mandatory details and their validations 
	Given Sign in with credentials 
	And Navigate to manage Subscription 
	When Choose any plan 
	And Check account mandatory details 
	And Check card details validations 
	Then Account details checked successfully 
	
	#Login with paid account give details in sign in class
@Upgradeplanold
Scenario: Check mandatory details and their validations 
	Given Sign in with credentials 
	And Navigate to manage Subscription 
	When Choose upgrade plan 
	And Enter required details and submit 
	Then Plan will be upgraded successfully 
@Downgradeplanold
Scenario: Check mandatory details and their validations 
	Given Sign in with credentials 
	And Navigate to manage Subscription 
	When Choose downgrade plan 
	And Enter required details and submit 
	Then Plan will be upgraded successfully 
	#Login with trail period account give details in sign in class as well as myOrganization-check plan method need to give domain url 	
@Downgradetrialtobasic 
Scenario: Check mandatory details and their validations 
	Given Sign in with credentials 
	And Navigate to manage Subscription 
	When Choose basic plan 
	And Enter required details and submit 
	Then Plan will be upgraded successfully	


	
	
	
	