Feature: User actions


    @DeactivateUser
    Scenario: Dactivate employee status
    
        Given Sign in with credentials
        And Navigate to actiavte employee
        When Deactivate employee
        Then Employee deactivated successfully
        
        @Activateuser
        Scenario: Activate employee status
    
        Given Sign in with credentials
        And Navigate to deactivate employee
        When Activate employee
        Then Employee activated successfully 
        
        @Cancelthestatuschange
        Scenario: Cancel the status action
        Given Sign in with credentials
        And Navigate to deactivate employee
        When Click on the status change button
        And Cancel the confirmation
        Then Employee status change cancelled successefully
        
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
        And Navigate to Delete employee 
        When Click on delete
        And Confirm the deletion of emplyee
        Then Employee deleted successfully
        
        @Canceldeleteuser
        Scenario: Delete employee
        Given Sign in with credentials
        And Navigate to Delete employee 
        When Click on delete
        And Cancel the deletion of User
        Then User deletion cancelled successfully 
        
        @ChangeAccountType
        Scenario: Change of user type
        Given Sign in with credentials
        And Navigate to Change of employee type 
        When Click on change account type
        And Select account type
        And Confirm account type change
        Then Account type changed successfully
        
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
        
        
        
        