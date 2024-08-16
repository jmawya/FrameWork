Feature: Sign up
Background: Given student at talentTEK Homepage
  And student clicks on Create New Account button from login page
  And student enter their valid firstname
  And student enter their valid lastname


  Scenario: Student create an account in talentek Training center
    And student enter their valid email address for sign up
    And student enter their valid password for singUp
    And student click on Confirm password
    And student select month from birth date combo box
    And student select day from birth date combo box
    And student select year from birth date combo box
    And student click on female radio button from gender text box
    And student agree to the Terms & Condition
    When student clicks on Create New Account button
    Then student should be able to get an student Id


  Scenario: Student should not be able to create an account in talentek Training center
    And student enter existing email address for sign up
    And student enter their valid password for singUp
    And student click on Confirm password
    And student select month from birth date combo box
    And student select day from birth date combo box
    And student select year from birth date combo box
    And student click on female radio button from gender text box
    And student agree to the Terms & Condition
    When student clicks on Create New Account button
    Then student should not be able to successfully sign up with existing email
  @signup @regression @dataProvider
  Scenario Outline:  Ensure user able to sign up with different month input

    And student validate if they can select different month as "<month>"


    Examples:
      |month |
      |Jan   |
      |Feb   |
      |Mar   |
      |Apr   |
      |May   |
      |Jun   |


Scenario Outline: Student able to create account with different day
  And student validate if they can select different day as "<day>"
  Examples:
    | day |
    |  03 |
    | 02  |
    | 03  |
    | 05  |
    | 06   |

  Scenario Outline: Student able to create account with different year
    And student validate if they can select different year as "<year>"
    Examples:
      | year|
      |2023 |
      |2009 |
      |1995 |
      |1980 |
      |2005 |