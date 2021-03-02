Feature: Pending Checkins

@Acceptpendingcheckins
Scenario: Accept pending checkins
 Given Launch the fidentity portal
  When Sign in with credentials
  When navigate to kiosk management
  When create assisted kisok 
  When login to the assisted kiosk for onlocation 
  And Navigate to pending checkins
  And Click on one record
  And Click on accept
  And Enter details to accept record and confirm
  Then pending checkin will be checked-in successfully  

@Rejectpendingcheckins
Scenario: Reject pending checkins
 Given Launch the fidentity portal
  When Sign in with credentials
  When navigate to kiosk management
  When create assisted kisok 
  When login to the assisted kiosk for onlocation 
  And Navigate to pending checkins
  And Click on one record
  And Click on Reject 
  And Enter details to Reject record and confirm 
  Then pending checkin will be rejected successfully
  
## @Cancel