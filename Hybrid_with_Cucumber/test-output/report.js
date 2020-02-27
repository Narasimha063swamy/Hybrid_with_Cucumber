$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:Features/AddCustomer.feature");
formatter.feature({
  "name": "Add Customer",
  "description": "",
  "keyword": "Feature"
});
formatter.background({
  "name": "Below are common steps for every scenario",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "User launch chrome browser",
  "keyword": "Given "
});
formatter.match({
  "location": "com.StepDefinitions.Steps.user_launch_chrome_browser()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User open URL \"https://admin-demo.nopcommerce.com/login\"",
  "keyword": "When "
});
formatter.match({
  "location": "com.StepDefinitions.Steps.user_open_URL(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User Enters Email as \"admin@yourstore.com\" and Password as \"admin\"",
  "keyword": "And "
});
formatter.match({
  "location": "com.StepDefinitions.Steps.user_Enters_Email_as_and_Password_as(java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Click on Login",
  "keyword": "And "
});
formatter.match({
  "location": "com.StepDefinitions.Steps.click_on_Login()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User can View Dashboard",
  "keyword": "Then "
});
formatter.match({
  "location": "com.StepDefinitions.Steps.user_can_View_Dashboard()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Add a New Customer",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@sanity"
    }
  ]
});
formatter.step({
  "name": "User Click on Customers menu",
  "keyword": "When "
});
formatter.match({
  "location": "com.StepDefinitions.Steps.user_Click_on_Customers_menu()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Click on Customers menu Item",
  "keyword": "And "
});
formatter.match({
  "location": "com.StepDefinitions.Steps.click_on_Customers_menu_Item()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Click on Add New Button",
  "keyword": "And "
});
formatter.match({
  "location": "com.StepDefinitions.Steps.click_on_Add_New_Button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User can view Add new Customer Page",
  "keyword": "Then "
});
formatter.match({
  "location": "com.StepDefinitions.Steps.user_can_view_Add_new_Customer_Page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User Enter Customers Info",
  "keyword": "When "
});
formatter.match({
  "location": "com.StepDefinitions.Steps.user_Enter_Customers_Info()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Click on Save Button",
  "keyword": "And "
});
formatter.match({
  "location": "com.StepDefinitions.Steps.click_on_Save_Button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User can View confirmation message \"The new customer has been added successfully.\"",
  "keyword": "Then "
});
formatter.match({
  "location": "com.StepDefinitions.Steps.user_can_View_confirmation_message(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Close Browser",
  "keyword": "And "
});
formatter.match({
  "location": "com.StepDefinitions.Steps.close_Browser()"
});
formatter.result({
  "status": "passed"
});
});