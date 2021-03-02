Feature: User actions 


@DeactivateUser 
Scenario: Dactivate employee status 

	Given Sign in with credentials 
	And Navigate to actiavte employee 
	When Deactivate employee 
	Then Changerole and reset password became disabled 
	Then Employee deactivated successfully 
	
@Activateuser 
Scenario: Activate employee status 

	Given Sign in with credentials 
	And Navigate to deactiavte employee 
	When Activate employee 
	Then Changerole and reset password became disabled 
	Then Employee activated successfully 
	
@Cancelchangerole 
Scenario: Cancel the status action 
	Given Sign in with credentials 
	And Navigate to changerole 
	When Click on changerole icon 
	And Cancel the changes 
	Then Employee changerole cancelled successefully 
	
	
@ResetPassword 
Scenario: Reset login Password 
	Given Sign in with credentials 
	And Navigate to reset password 
	When Click on Change password icon 
	And Enter the new password 
	Then New password will be updated successfully 
	
@CancelResetpassword 
Scenario: Cancel reset password 
	Given Sign in with credentials 
	And Navigate to reset password 
	When Enter the password 
	And cancel the password confirmation 
	Then Cancelled the password change successfully 
	
	
	
	
@Deleteuser 
Scenario: Delete employee 
	Given Sign in with credentials 
	And Navigate to Delete 
	When Click on delete 
	And Confirm the deletion of employee 
	Then Employee deleted successfully 
	
@Canceldeleteuser 
Scenario: Delete employee 
	Given Sign in with credentials 
	And Navigate to Delete 
	When Click on delete 
	And Cancel the deletion of employee 
	Then Employee deletion cancelled successfully 
	
@Changerole 
Scenario: Change of user type 
	Given Sign in with credentials 
	And Navigate to changerole 
	When Click on changerole icon 
	And Select account type 
	And Save changes 
	Then Employee role changed successfully 
	
@UserLogout 
Scenario: User logout from current page 

	Given Sign in with credentials 
	And Navigate to logout icon 
	And Click on logout icon 
	When Confirm the logout 
	Then User logged out successfully 
	
@CancelUserLogout 
Scenario: Cancel user logout 

	Given Sign in with credentials 
	And Navigate to logout icon 
	And Click on logout icon 
	When Cancel the logout 
	Then User logout cancelled successfully 
	
@Markaseventadmin 
Scenario: Mark as event admin 
	Given Sign in with credentials 
	And Navigate to mark event admin 
	When Click on event admin icon 
	When Grant changes 
	Then Employee marked as event admin successfully 
	
@Revokeeventadmin 
Scenario: Revoke event admin 
	Given Sign in with credentials 
	And Navigate to revoke event admin 
	When Click on revoke event admin icon 
	When Revoke event admin 
	Then Event admin revoked successfully
	
	
	
	
	
	
        