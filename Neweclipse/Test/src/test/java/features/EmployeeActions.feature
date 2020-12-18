Feature:  Employe Actions


@EditEmployeevalidations
    Scenario: Mandatory fields vaildation
      
       Given Sign in with credentials
      And Navigate to edit employee                                                                                                                            
      When Validate mandatory fields     
      Then Mandatory fileds successfully Checked   
      #here we need to check mandatory fields 
      @EditEmployee
    Scenario: Edit Edit employee
      
       Given Sign in with credentials
      And Navigate to edit employee                                                                                                                            
      When Edit required fields 
      Then Employee details successfully edited
      
      @Validatefileds
      Scenario: Edit Edit employee
      
       Given Sign in with credentials
      And Navigate to edit employee                                                                                                                            
      When Validate editable fields
      Then Editable fields validate successfully
      
      