Feature: search for stay
  Scenario: verify user is able to search properties for stay
    Given user opened the application
    Then verify user is on the home screen
    When user clicks on stays menu
    And user enters stay location "stay.location"
    And user clicks on date field
    And user selects the check-in date "check-in.date"
    And user selects the check-out date "check-out.date"
    And user clicks on done button
    And user clicks on search button
    Then verify list of properties are displayed on the screen