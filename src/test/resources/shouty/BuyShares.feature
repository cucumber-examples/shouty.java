Feature: People can buy shares over Shouty

  Scenario: Buy shares successfully
	Given "Sally" has an account
	When "Sally" shouts "Buy 500 shares"
	Then Shouty requests a confirmation to buy 500 shares at the market
	
  Scenario: Sell shares successfully
	Given "Sally" has an account
	When "Sally" shouts "Sell 500 shares"
	Then Shouty requests a confirmation to sell 500 shares at the market
	
  Scenario: Garbeled order
	Given "Sally" has an account
	When "Sally" shouts "Xyzzy 500 shares"
	Then Shouty says "I didn't understand that"