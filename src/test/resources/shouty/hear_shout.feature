Feature: Hear Shout for Subscribers to the Broadcast

  Focusing on subscriber hearing shouts.

  Rules:
    Subscribers should be in range of each other

  Assumptions:
    Lucy is a subscriber for bakery
    Sean is a subscriber wanting to promote his bakery on Shouty
    Lucy is already within range

  Todo:
    Implement Broadcast
    Implement range/proximity algorithm
    Implement subscription functionality
    Anti-spam - need to figure this out soon!
    Implement categories

Scenario: Shout to a subscriber within range
  Given Lucy is within range of Sean
  When Sean shouts "Fresh banana bread. Mmmm. Cheap!"
  Then Lucy should hear the shout
