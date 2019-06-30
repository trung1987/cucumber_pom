Feature: Create Acc flow
  I want to use this template for my feature file

  Scenario: Create Acc
    Given I access page "http://demo.guru99.com/"
    When I fill in emaiID as random email
    And I click on login button
    Then I can see UserID and Passwrod

  Scenario: Login with valid info
    Given I access page "http://demo.guru99.com/v4/"
    When I fill in username as default username 
    And I fill in password as default password
    And I click on login button
    Then I can see homepage
