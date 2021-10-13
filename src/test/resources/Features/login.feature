Feature: To validate the login functionality of facebook application

  Scenario: To validate the login functionality of invalid credentials
    Given The user should be in facebook login page
    When The user has to fill username and password
    |prakash|1234|
    |manoj|5678|
    |kumar|4578|
    And The user has to click login button
    Then The user should navigate to invalid login page

 
