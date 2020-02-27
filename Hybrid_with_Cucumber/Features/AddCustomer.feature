Feature: Add Customer

Background: Below are common steps for every scenario
	Given User launch chrome browser
	When User open URL "https://admin-demo.nopcommerce.com/login"
	And User Enters Email as "admin@yourstore.com" and Password as "admin"
	And Click on Login
	Then User can View Dashboard
@sanity
Scenario: Add a New Customer
	
	When User Click on Customers menu
	And Click on Customers menu Item
	And Click on Add New Button
	Then User can view Add new Customer Page
	When User Enter Customers Info 
	And Click on Save Button
	Then User can View confirmation message "The new customer has been added successfully."
	And Close Browser
@smoke
Scenario: Search Customer by Email Id
	When User Click on Customers menu
	And Click on Customers menu Item
	And Enter Customer Emamil
	When Click on Search Button
	Then User Should Found Email in the Search Table
	And Close Browser
@regression
	Scenario: Search Customer by Name
	When User Click on Customers menu
	And Click on Customers menu Item
	And Enter Customer FirstName
	And Enter Customer LastName
	When Click on Search Button
	Then User Should Found Name in the Search Table
	And Close Browser
	
	