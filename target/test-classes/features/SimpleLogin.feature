Feature: Simple Login

#Scenario Outline: Test Login
#	Given User is on landing page "<website>"
#	When User enters valid username "<username>" and password "<password>"
#	And Click login button
#	Then User logged in successfully
		
#		Examples:
#		| website | username | password |
#		| http://www.facebook.com/ | aruna.balavijay@gmail.con | Adhi$h310 |

@UnitTest
Scenario: Simple Login Test
	Given User is on landing page "https://admin-demo.nopcommerce.com/login"
	When User is logging in with valid username "admin@yourstore.com" and password "admin"
	Then User can able to login and view dashboard page