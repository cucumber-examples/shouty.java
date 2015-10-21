Feature: View & Maintain UFS codes on Contract Details page
  
  * List of rules
  * Assumptions

  @GUI @middle_tier
  Scenario: Viewing contract when contract status changes
  	This scenario illustrates the whatever rule
  	<br>
  	The description can be arbitrarily long.
  	You can say as much as you want.
  	
    Given a contract in "completed" status
    And the contract has associated UFS codes
    When the contract status changes to a "not completed" status
    Then the same UFS codes should be displayed

  Scenario: another scenario for the same rule
    Given this
    When that
    Then something
