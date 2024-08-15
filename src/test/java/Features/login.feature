Feature: Login
  Background:
    Given student at talentTEK Homepage

  @login @regression @smoke @Test
  Scenario: Student should be able to successfully login with valid credentials
    And student enter their valid email address
    And student enter their valid password
    When student clicks on Login Button from login page
    Then student should be able to successfully login

  @login @regression @smoke
  Scenario: Student should be not bale to successfully login with invalid email address
    And student enter their invalid email address
    And student enter their valid password
    When student clicks on Login Button from login page
    Then student should not be able to successfully login

  @login @regression
  Scenario: Student should be not bale to successfully login with invalid password
    And student enter their valid email address
    And student enter their invalid password
    When student clicks on Login Button from login page
    Then student should see Incorrect email or password error message

  @login @regression
  Scenario: Student should be not bale to successfully login with invalid credentials
    And student enter their invalid email address
    And student enter their invalid password
    When student clicks on Login Button from login page
    Then student should not be able to successfully login

  @login @regression
  Scenario Outline: Ensure user able to login with different sets of credentials
    And student enter their valid email address "<emailValue>"
    And student enter their valid password "<passwordValue>"
    Examples:
      |emailValue      | passwordValue |
      |test1@gmail.com | asdf          |
      |test2@gmail.com | test232       |
      |test3@gmail.com | hasan1        |
