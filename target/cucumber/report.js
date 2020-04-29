$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/java/features/SimpleLogin.feature");
formatter.feature({
  "name": "Simple Login",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Simple Login Test",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@UnitTest"
    }
  ]
});
formatter.step({
  "name": "User is on landing page \"https://admin-demo.nopcommerce.com/login\"",
  "keyword": "Given "
});
formatter.match({
  "location": "SimpleLogin.user_is_on_landing_page(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User is logging in with valid username \"admin@yourstore.com\" and password \"admin\"",
  "keyword": "When "
});
formatter.match({
  "location": "SimpleLogin.user_is_logging_in_with_valid_username_and_password(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User can able to login and view dashboard page",
  "keyword": "Then "
});
formatter.match({
  "location": "SimpleLogin.user_can_able_to_login_and_view_dashboard_page()"
});
formatter.result({
  "status": "passed"
});
});