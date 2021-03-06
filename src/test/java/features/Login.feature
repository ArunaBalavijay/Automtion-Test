Feature: Application Login

#Scenario Outline: Test Login
#	Given User is on landing page "<website>"
#	When User enters valid username "<username>" and password "<password>"
#	And Click login button
#	Then User logged in successfully
		
#		Examples:
#		| website | username | password |
#		| http://www.facebook.com/ | test@gmail.con | test |

@RegressionTest
Scenario: Login Test
	Given User is on landing page
	When User is logging in with valid username and password
	Then User can able to login