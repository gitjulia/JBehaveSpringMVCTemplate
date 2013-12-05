Scenario:  trader should be not alerted below recipient and should be alerted above recipient
 
Given a feedback of symbol <symbol> and a recipient of <recipient>
When the feedback is traded at <price>
Then the alert status should be <status>

Examples:
|symbol|recipient|price|status|
|STK1|5|4|OFF|
|STK1|5|14|ON|
