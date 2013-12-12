Scenario: User can submit feedback
When I submit a feedback with my name, the recipient’s name and the feedback
Then I should see the feedback
And I should see the recipient’s name
And I should see my name

Scenario: User can view previous feedback
Given that I have already submitted a feedback
When I try to submit another feedback
Then I should see my previous feedback

Scenario: User can view a specific recipient's feedback
Given that there is feedback for a specific recipient
When I search for that recipient's feedback
Then I should see feedback only for that recipient