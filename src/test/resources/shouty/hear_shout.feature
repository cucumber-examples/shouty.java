Feature: Hear Shout

  Shouts have a range of approximately 1000m
  
  Scenario Outline: only hear in-range shout
  	Given Lucy is at 0, 0
    And Sean is at <Seans-location>
  	When Sean shouts
  	Then Lucy should hear <what-Lucy-hears>
  	
  	Examples: where Sean is heard
  	  | Seans-location  | what-Lucy-hears |
  	  | 0, 900          | Sean			 |
  	
    Examples: where Sean is not heard
  	  | Seans-location  | what-Lucy-hears |
  	  | 800, 800        | nothing         |
    
  Scenario: Multiple shouters
  	Given people are located at
  	  | name  | x    | y   |
  	  | Lucy  | 0    | 0   |
  	  | Sean  | 0    | 500 |
  	  | Oscar | 1100 | 0   |
    When Sean shouts
	And Oscar shouts
	Then Lucy should not hear Oscar
	But Lucy should hear Sean
	
  Scenario: Shouter should not hear themselves
  	When Lucy shouts
  	Then Lucy should not hear Lucy
  	
  Scenario: Multiple shouts from one person
  	Given Lucy is at 0, 0
	And Sean is at 0, 500
	When Sean shouts
	And Sean shouts
	Then Lucy should hear 2 shouts from Sean
  	
  	