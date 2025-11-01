@Login
Feature: Login Feature

  @Login_001 @High @Smoke
  Scenario: Login successfully with valid username, password, OTP
    Given User is on Login page
    When Input username "admin"
    And Input password "admin"
    And Click Send OTP button
    And Input OTP "000000"
    And Click Login button
    Then Display success toast "Login Successfully"
    And Navigate to Home page "AUTO PAYMENT TOOL"
    And Display correct username "admin"

  @Login_002 @Medium
  Scenario: Login fail due to empty username
    Given User is on Login page
    When Input username ""
    And Input password "admin"
    And Input OTP "000000"
    And Click Login button
    Then Display error message below username "Please Enter Username!"

  @Login_003 @Medium @Smoke
  Scenario: Login fail due to wrong username
    Given User is on Login page
    When Input username "adminn"
    And Input password "admin"
    And Input OTP "000000"
    And Click Login button
    Then Display error toast "User not existed"

  @Login_004 @Medium
  Scenario: Login fail due to empty password
    Given User is on Login page
    When Input username "admin"
    And Input password ""
    And Input OTP "000000"
    And Click Login button
    Then Display error message below password "Please Enter Password!"

  @Login_005 @High @Smoke
  Scenario: Login fail due to wrong password
    Given User is on Login page
    When Input username "admin"
    And Input password "adminn"
    And Input OTP "000000"
    And Click Login button
    Then Display error toast "Username or password invalid"

  @Login_006 @Medium
  Scenario: Login fail due to empty OTP
    Given User is on Login page
    When Input username "admin"
    And Input password "admin"
    And Input OTP ""
    And Click Login button
    Then Display error message below OTP "Please Enter Your OTP!"

  @Login_007 @High @Smoke
  Scenario: Login fail due to wrong OTP
    Given User is on Login page
    When Input username "elfyth_admin"
    And Input password "123123"
    And Input OTP "000000"
    And Click Login button
    Then Display error toast "Authentication OTP Failed"

#  @Login_008 @Medium
#  Scenario: Login fail due to expired OTP
#    Given User is on Login page
#    And Expired time is 60 seconds
#    When Input username "elfyth_admin"
#    And Input password "123123"
#    And Input OTP "expired_otp"
#    And Click Login button
#    Then Display error toast "Authentication OTP Failed"

  #  @Login_009 @Medium
#  Scenario: Login fail due to used OTP
#    Given User is on Login page
#    When Input username "elfyth_admin"
#    And Input password "123123"
#    And Input OTP "used_otp"
#    And Click Login button
#    Then Display error toast "Authentication OTP Failed"

   #  @Login_010 @Medium
#  Scenario: Login fail due to OTP is belong another user
#    Given User is on Login page
#    When Input username "elfyth_admin"
#    And Input password "123123"
#    And Input OTP "other_otp"
#    And Click Login button
#    Then Display error toast "Authentication OTP Failed"

  @Login_011 @High
  Scenario: Get OTP successfully with valid username, password
    Given User is on Login page
    When Input username "elfyth_admin"
    And Input password "123123"
    And Click Send OTP button
    Then Display success toast "Send OTP Successfully!"
    And Send OTP to user's telegram ID

  @Login_012 @Low
  Scenario: Get OTP fail due to empty username
    Given User is on Login page
    When Input username ""
    And Input password "admin"
    And Click Send OTP button
    Then Display error toast "Input Invalid"

  @Login_013 @Low
  Scenario: Get OTP fail due to wrong username
    Given User is on Login page
    When Input username "adminn"
    And Input password "admin"
    And Click Send OTP button
    Then Display error toast "User not existed"

  @Login_014 @Low
  Scenario: Get OTP fail due to empty password
    Given User is on Login page
    When Input username "admin"
    And Input password ""
    And Click Send OTP button
    Then Display error toast "Input Invalid"

  @Login_015 @Medium
  Scenario: Get OTP fail due to wrong password
    Given User is on Login page
    When Input username "admin"
    And Input password "adminn"
    And Click Send OTP button
    Then Display error toast "Username or password invalid"