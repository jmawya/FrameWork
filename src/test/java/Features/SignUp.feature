Feature: Sign in

  Scenario: Student create an account in talentek Training center
    Given student at talentTEK SignUp page
    And student enter their valid firstname
    And student enter their valid lastname
    And student enter their valid email address for sign up
    And student enter their valid password for singUp
    And student click on Confirm password
    And student select month from birth date combo box
    And student select day from birth date combo box
    And student select year from birth date combo box
    And student click on female radio button from gender text box
    And student agree to the agree box
    When they click on create an account button
    Then student should be able to successfully sign up

  Scenario: Student should not be able to create an account in talentek Training center
    Given student at talentTEK SignUp page
    And student enter their valid firstname
    And student enter their valid lastname
    And student enter existing email address for sign up
    And student enter their valid password for singUp
    And student click on Confirm password
    And student select month from birth date combo box
    And student select day from birth date combo box
    And student select year from birth date combo box
    And student click on female radio button from gender text box
    And student agree to the agree box
    When they click on create an account button
    Then student should not be able to successfully sign up with existing email


