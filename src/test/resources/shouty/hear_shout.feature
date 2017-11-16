Feature: Hear Shout

  Shouts have a range of approximately 1000m

  Scenario Outline: only hear in range shouts
    Given Lucy is at 0, 0
    And Sean is at <Seans-location>
    When Sean shouts
    Then Lucy should hear <what-Lucy-hears>

    Examples: some examples
      | Seans-location | what-Lucy-hears |
      | 0, 900         | Sean            |
      | 800, 800       | nothing         |

  Scenario: Multiple shouters
    Given people are located at
      | name  | x   | y    |
      | Lucy  | 0   | 0    |
      | Sean  | 500 | 0    |
      | Oscar | 0   | 1100 |
    When Sean shouts
    When Oscar shouts
    Then Lucy should not hear Oscar
    But Lucy should hear Sean

  Scenario: Shouters should not hear their own shouts
    Given Lucy is at 0, 0
    When Lucy shouts
    Then Lucy should hear nothing
