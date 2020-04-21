Feature: Hear Shout

# Location data not passed to API
  # /shouts POST & GET
  Scenario: In range shout is heard
    Given Sean is at 0, 0
    And Lucy is at 900, 0
    When Sean shouts
    Then Lucy should hear Sean


# Location data passed to API. Need two examples -> 2 versions of API: heard / Not heard from Sean
  # /shouts POST & GET
  # /location POST
  Scenario: Out of range shout is not heard
    Given Sean is at 0, 0
    And Lucy is at 1200, 0
    When Sean shouts
    Then Lucy should not hear Sean


# Location data optionally passed with shout. Still only need 2 examples - POST should accept shouts with/without location
  # /shouts POST (optional location) & GET
  # /location POST
  Scenario: Range calculated using specified location of business shout
    Given Sean is at 99999, 99999
    And Lucy is at 900, 0
    When Sean shouts from 0, 0
    Then Lucy should hear Sean

