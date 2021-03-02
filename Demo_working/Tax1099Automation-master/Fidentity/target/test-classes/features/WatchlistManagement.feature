Feature: Watchlist management

@Createwatchlist
Scenario: Create watch list
  Given Launch the fidentity portal
  When Sign in with credentials
  When Navigate to Watchlist management 
  When Click on create watchlist button
  When Enter required details and save
  Then Watchlist will be created successfully
    
@Editwatchlist   
Scenario: Edit watch list
  Given Launch the fidentity portal
  When Sign in with credentials
  When Navigate to Watchlist management 
  When Select one of the watchlist record
  When Clik on edit menuitem 
  When Edit details and save
  Then Watchlist details edited successfully
  ##here skipping edit color once color palette automation done can apply here
  
@Deletewatchlist   
Scenario: Delete watch list
  Given Launch the fidentity portal
  When Sign in with credentials
  When Navigate to Watchlist management 
  When Select one of the watchlist record
  When Clik on delete menuitem  
  When Delete watchlist and confirm
  Then Watchlist details deleted successfully
  
@Addvisitortowatchlist
Scenario: Add visitor to watch list
  Given Launch the fidentity portal
  When Sign in with credentials
  When Navigate to onlocation
  When Click on add watchlist 
  When Select watch list type and save
  Then Added visitor towatch list successfully

@updatewatchlistinassistedkiosk
 Scenario: Update watchlist by assisted kiosk for onlocation visitors
 Given Launch the fidentity portal
  When Sign in with credentials
  When navigate to kiosk management
  When create assisted kisok 
  When login to the assisted kiosk for onlocation 
  When Navigate to onlocation visitors
  When select one visitor record
  When update watchlist and save
  Then Watchlist updated successfully
  
 @restrictwatchlistvisitorcheckin
 Scenario: Restrict watchlist visitor checkin
  Given Launch the fidentity portal
  When Sign in with credentials
  When navigate to kiosk management
  When create assisted kisok 
  When login to the assisted kiosk for onlocation 
  When Navigate to onlocation visitors
  When select one visitor record
  When update watchlist and save
  When goto admin portal  
  When create gatepass with watchlist visitor details
  When login wathclist visitor through assisted kiosk
  When Restrict login for watchlist visitor 
  When Restricted successfully
 
 