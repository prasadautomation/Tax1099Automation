Feature:  Google search 

@Searchtest
    Scenario: Google search  test
      
       Given Launch the browser
      And Enter url                                                                                                                                
      When Search for test
      Then Test relaetd articles visible successfully
      #here we need to check mandatory fields 