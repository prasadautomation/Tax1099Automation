Feature: Package delivery

@CreatepackageKiosk
Scenario: Create package Kiosk
  Given Launch the fidentity portal
  When Sign in with credentials
  When Navigate to Package delivery module
 # When Goto Kiosk management for create package kiosk
  When Click on create kiosk
  When Enter required details and create
  Then Package kiosk will be created successfully   
  Then Login to Package kiosk    


# @Receivepackagebykiosk
## Scenario:Receive package by package kiosk

@Createstorelocation
 Scenario: Create store location
Given Launch the fidentity portal
  When Sign in with credentials
  When Navigate to Package delivery module
  When Goto Store location menu 
  When Click on Create store location
  When Enter required details for create location 
  When Click on Create and confirm to create store location
  Then Store location created successfully 
  
@Createstorelocationvalidations
 Scenario: Create store location validations
Given Launch the fidentity portal
  When Sign in with credentials
  When Navigate to Package delivery module
  When Goto Store location menu 
  When Click on Create store location  
  When Check validations of create location  
  Then Validations checked successfully
  
@Deletestorewithnopendingpackages
Scenario: Delete store location with no pending packages
Given Launch the fidentity portal
  When Sign in with credentials
  When Navigate to Package delivery module
  When Goto Store location menu 
  When Select store which has no pending pickups and delete 
 Then Required store location deleted successfully
  
@Transferpackagesanddeletestore
Scenario: Delete store with pending packages
Given Launch the fidentity portal
  When Sign in with credentials
  When Navigate to Package delivery module
  When Goto Store location menu 
  When Select store and click on delete
  When If store has non picked packages transfer packages and delete
 Then Required store location deleted successfully 
 
 @Editstorelocation
 Scenario: Edit store location
 Given Launch the fidentity portal
  When Sign in with credentials
  When Navigate to Package delivery module
  When Goto Store location menu 
  When Select store and click on edit
  When Edit required fields and save
  Then Store location details edited successfully 

@receivepackagebyassistedkiosk
 Scenario: Receive package by assisted kiosk
 Given Launch the fidentity portal
  When Sign in with credentials
  When navigate to kiosk management
  When create assisted kisok 
  When login to the assisted kiosk
  When Navigate to package delivery
  When Click on recieve package
  When Enter required details and save
  Then Package received successfully
  
  
@Pickuppackagefrompwa
Scenario: Pick up package from package delivery kiosk
 Given Launch the fidentity portal
  When Sign in with credentials
  When navigate to kiosk management
  When create assisted kisok 
  When login to the assisted kiosk
  When Navigate to package delivery
  When Select non pickedup delivery to pickup 
  When Enter pickup code and confirm
  #pickup code will be sent to employee
  Then Package picked up successfully
  
@Editpackagekiosk
Scenario: Edit package kiosk

Given Launch the fidentity portal
  When Sign in with credentials
  When Navigate to Package delivery module
  When Goto kiosk management menu 
  When Click on Edit option for one kiosk
  When Edit details of kiosk and save
  Then Package kiosk edited successfully
  
@Editpackagekioskvalidations
Scenario: Edit package kiosk validations

Given Launch the fidentity portal
  When Sign in with credentials
  When Navigate to Package delivery module
  When Goto kiosk management menu 
  When Click on Edit option for one kiosk
  When Check validations for pwa edit 
  Then Pwa edit validations checked succcessfully
 
@CancelEditpackagekiosk
Scenario: Cancel edit package kiosk

Given Launch the fidentity portal
  When Sign in with credentials
  When Navigate to Package delivery module
  When Goto kiosk management menu 
  When Click on Edit option for one kiosk
  When Click on cancel button on edit modal  
  Then Pwa edit kiosk cancelled succcessfully  
  
 @Dettachpackagekiosk
Scenario: Dettach package kiosk

Given Launch the fidentity portal
  When Sign in with credentials
  When Navigate to Package delivery module
  When Goto kiosk management menu 
  When Click on Dettach icon of any kiosk 
  When Confirm dettach kiosk
  Then Pwa kiosk dettached succcessfully  

 @Canceldettachpackagekiosk
Scenario: Cancel dettach package kiosk

Given Launch the fidentity portal
  When Sign in with credentials
  When Navigate to Package delivery module
  When Goto kiosk management menu 
  When Click on Dettach icon of any kiosk 
  When Cancel dettach kiosk 
  Then Pwa kiosk dettached succcessfully

 @Deleteinactivepackagekiosksynccode
Scenario: Delete inactive package kiosk synccode

Given Launch the fidentity portal
  When Sign in with credentials
  When Navigate to Package delivery module
  When Goto kiosk management menu 
  When Click on delete icon of non-active package kiosk 
  When Confirm deletion of package kiosk
  Then Non-active package kiosks deleted successfully
  
 @Canceleleteinactivepackagekiosksynccode
Scenario: Cancel delete inactive package kiosk synccode

Given Launch the fidentity portal
  When Sign in with credentials
  When Navigate to Package delivery module
  When Goto kiosk management menu 
  When Click on delete icon of non-active package kiosk 
  When Cancel deletion of package kiosk
  Then Non-active package kiosks deleted successfully    

  
  
   
 
