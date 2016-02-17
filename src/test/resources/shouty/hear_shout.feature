Feature: Hear Shout
  
  A description goes here...

  Scenario: Getting started
    Given a shopping list:
      | item      | amount |
      | apples    | 3      |
      | cucumbers | 99     |
      | steak     | 5      |
    When I go shopping
    Then I should have the following items in my cupboard:
      | item      | amount |
      | apples    | 3      |
      | cucumbers | 99     |
      | steak     | 5      |
