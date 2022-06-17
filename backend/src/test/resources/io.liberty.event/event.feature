Feature: Create Event
  Create an event using the event manager

  Scenario: Date of event is before today
    Given creation date is 12:00 am, May 1 2022
    When creation date is before today
    Then I should be told "Choose a valid time"