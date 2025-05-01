Feature: DemoBlaze Login

  @web
  Scenario: user can login with valid account
    Given user is on demoblaze homepage
    And user has click login button
    And Login modal is shown to user
    When user enter username "DemoAccount15" and password "DemoAccount15"
    And user click Login
    Then user will successfully login and directed to homepage

  @web
  Scenario: User fail login with invalid credentials
    Given user is on demoblaze homepage
    And user has click login button
    And Login modal is shown to user
    When user enter username "DemoAccount15" and password "wrongPassword"
    And user click Login
    Then user will see popup message indicating user enter invalid credentials

  @web
  Scenario: Login with nonexisting user
    Given user is on demoblaze homepage
    And user has click login button
    And Login modal is shown to user
    When user enter username "nonexistinguser" and password "nonexistinguser"
    And user click Login
    Then user will see a popup message indicating user does that exist