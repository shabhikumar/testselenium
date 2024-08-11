Feature: OrangeHRM Login

  Scenario: Logo presence on OrangeHRM home page
    Given I launch chrome browser
    When I open orange hrm home page
    And I enter username as "Admin" and password as "admin123"
    Then I verify login should be successful
    And close browser
