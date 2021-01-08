$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("C:/Users/Sridevi/eclipse-workspace/Fidentity/src/test/java/features/Login.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "# language: en"
    }
  ],
  "line": 2,
  "name": "Login",
  "description": "",
  "id": "login",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 6,
  "name": "Active subscription",
  "description": "",
  "id": "login;active-subscription",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 5,
      "name": "@FID-285"
    }
  ]
});
formatter.step({
  "line": 8,
  "name": "User logged in to application",
  "keyword": "Given "
});
formatter.step({
  "line": 9,
  "name": "Logged in usertype is Admin or Global Admin",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "Subscription To be Expiry date is less than 14 days",
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "A notification is needs to be displayed \"Your Subscription is about to expires by To be Expired Date\"",
  "keyword": "Then "
});
formatter.step({
  "line": 12,
  "name": "with call of Action to Renew the Subscription",
  "keyword": "And "
});
formatter.match({
  "location": "stepDefinition.user_logged_in_to_application()"
});
formatter.result({
  "duration": 21453748000,
  "status": "passed"
});
formatter.match({
  "location": "stepDefinition.logged_in_usertype_is_admin_or_global_admin()"
});
formatter.result({
  "duration": 28100,
  "status": "passed"
});
formatter.match({
  "location": "stepDefinition.subscription_to_be_expiry_date_is_less_than_14_days()"
});
formatter.result({
  "duration": 19400,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Your Subscription is about to expires by To be Expired Date",
      "offset": 41
    }
  ],
  "location": "stepDefinition.a_notification_is_needs_to_be_displayed_something(String)"
});
formatter.result({
  "duration": 4181800,
  "status": "passed"
});
formatter.match({
  "location": "stepDefinition.with_call_of_action_to_renew_the_subscription()"
});
formatter.result({
  "duration": 24300,
  "status": "passed"
});
});