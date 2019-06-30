Feature: Login flow
  I want to use this template for my feature file

  Scenario: Login with valid info
    Given I access page "http://demo.guru99.com/v4/"
    When I fill in username as "mngr205827"
    And I fill in password as "nEgYqyt"
    And I click on login button
    Then I can see homepage

  Scenario Outline: Login with invalid info
    Given I access page "http://demo.guru99.com/v4/"
    When I fill in username as "<username>"
    And I fill in password as "<password>"
    Then I can see alert message as "<notify>"

    Examples: 
      | username   | password | notify                     |
      |            | nEgYqyt  | User-ID must not be blank  |
      | mngr205827 |          | Password must not be blank |
      | ngr205827  |        1 | Password must not be blank |
