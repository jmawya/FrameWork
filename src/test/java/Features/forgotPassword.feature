Feature: Forgate password
  Scenario: Ensure Student change their password if they forgote their password.
    Given student at talentTEK Homepage
    And student click on forgote password link
    And student enter their email
    And student click on Send Password Reset button



    And student at change password page
    And student choose a new password
    And student confirm new password
    When they click on change button
    Then Student successfully change their password