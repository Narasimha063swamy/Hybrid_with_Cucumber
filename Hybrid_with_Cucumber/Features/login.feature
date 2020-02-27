Feature: Login

Scenario: Successful Login with Valid Credentials
	Given User launch chrome browser
	When User open URL "https://admin-demo.nopcommerce.com/login"
	And User Enters Email as "admin@yourstore.com" and Password as "admin"
	And Click on Login
	Then Page Title should be "Dashboard"
	When User Click on Logout Link
	Then Page Title should be "Your store.Login"
	And Close Browser
	
Scenario Outline: Login Data Driven
	Given User launch chrome browser
	When User open URL "https://admin-demo.nopcommerce.com/login"
	And User Enters Email as "<UN>" and Password as "<PS>"
	And Click on Login
	Then Page Title should be "Dashboard"
	When User Click on Logout Link
	Then Page Title should be "Your store.Login"
	And Close Browser
	
	Examples:
	
		|UN|PS|
		|admin@yourstore.com|admin|
		|admin@yourstore.com|admin123|
	
