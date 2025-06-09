Feature: Login Feature

  Scenario: Login successfully with valid username, password, OTP
    Given the user is on the login screen
    When input the username "admin"
    And  input the password "admin"
    And input the OTP "111111"
    And click on the login button
    Then the user should see the success popup with content "Login Successfully"
    And the user should see the homepage

  Scenario: Login fail due to wrong username
    Given the user is on the login screen
    When input the username "adminn"
    And  input the password "admin"
    And input the OTP "111111"
    And click on the login button
    Then the user should see the error popup with content "User not existed"

  Scenario: Login fail due to wrong password
    Given the user is on the login screen
    When input the username "admin"
    And  input the password "adminn"
    And input the OTP "111111"
    And click on the login button
    Then the user should see the error popup with content "Username or password invalid"

#  Scenario: Login fail due to expired OTP
#    Given the user is on the login screen
#    When input the username "admin"
#    And  input the password "admin"
#    And wait for OTP to expire
#    And input the OTP "111111"
#    Then the user should see the error popup with content ""

#  Scenario: Login fail due to wrong OTP
#    Given the user is on the login screen
#    When input the username "admin"
#    And  input the password "admin"
#    And input the OTP "000000"
#    And click on the login button
#    Then the user should see the error popup with content ""

#  Scenario: Login successfully with new valid OTP
#    Given the user is on the login screen
#    When input the username "admin"
#    And  input the password "admin"
#    And click on the send OTP button
#    And input the new OTP
#    Then the user should see the success popup with content "Login Successfully"
#    And the user should see the homepage

   #  Scenario: Login fail due to using the old OTP
#    Given the user is on the login screen
#    When input the username "admin"
#    And  input the password "admin"
#    And click on the send OTP button
#    And input the old OTP
#    Then the user should see the error popup with content ""

  Scenario: Verify show password icon functionality
    Given the user is on the login screen
    When the user enters the username "admin"
    And the user enters the password "password"
    And the click on the show password icon
    Then the user should see the password "password"

  Scenario: Verify show password icon functionality
    Given the user is on the login screen
    When the user enters the username "admin"
    And the user enters the password "password"
    And the click on the show password icon
    Then the user should see the password "password"


  Scenario: Receive OTP with invalid username
    Given the user is on the login screen
    When input the username "adminn"
    And  input the password "admin"
    And click on the send OTP button
    Then the user should see the error popup with content "User not existed"

  Scenario: Receive OTP with invalid username
    Given the user is on the login screen
    When input the username "admin"
    And  input the password "adminn"
    And click on the send OTP button
    Then the user should see the error popup with content "Username or password invalid"