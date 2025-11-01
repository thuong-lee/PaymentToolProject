@Feature @ChangePassword @Logout
Feature: Change Password Function
  As a logged-in user
  I want to change my account password and log out my account
  So that I can secure my account and follow password policy

  @Logout_001 @High @Smoke
  Scenario: Logout successfully
    Given User is logged in with username "tinhadmin", password "123123", and otp "000000"
    When User clicks on account dropdown
    And User selects Logout option
    Then Navigate to Login page
    And Clear token from Local Storage

  @ChangePassword_001 @Medium
  Scenario: Change password fail due to new password less than 6 characters
    Given User is logged in with username "tinhadmin", password "123123", and otp "000000"
    When User clicks on account dropdown
    And User selects Change Password option
    And User inputs Current Password "123123"
    And User inputs New Password "12345"
    And User inputs Confirm New Password "12345"
    And User clicks Change Password button
    Then Display error message below New Password "Password must be at least 6 characters long."


  @ChangePassword_002 @Medium
  Scenario: Change password fail due to new password same as current password
    Given User is logged in with username "tinhadmin", password "123123", and otp "000000"
    When User clicks on account dropdown
    And User selects Change Password option
    And User inputs Current Password "123123"
    And User inputs New Password "123123"
    And User inputs Confirm New Password "123123"
    And User clicks Change Password button
    Then Display error message below Current Password "New password must be different from your current password."
    And Display error message below New Password "New password must be different from your current password."
    And Display error message below Confirm New Password "New password must be different from your current password."


  @ChangePassword_003 @High @Smoke
  Scenario: Change password fail due to incorrect current password
    Given User is logged in with username "tinhadmin", password "123123", and otp "000000"
    When User clicks on account dropdown
    And User selects Change Password option
    And User inputs Current Password "123321"
    And User inputs New Password "123456"
    And User inputs Confirm New Password "123456"
    And User clicks Change Password button
    Then Display error toast "Username or password invalid"
    And Display error message below Current Password "Current password is incorrect. Please try again."


  @ChangePassword_004 @Medium
  Scenario: Change password fail due to confirm password does not match
    Given User is logged in with username "tinhadmin", password "123123", and otp "000000"
    When User clicks on account dropdown
    And User selects Change Password option
    And User inputs Current Password "123123"
    And User inputs New Password "123456"
    And User inputs Confirm New Password "123457"
    And User clicks Change Password button
    Then Display error message below Confirm New Password "Confirm New Password do not match."


  @ChangePassword_005 @Medium
  Scenario: Change password fail due to new password contains space
    Given User is logged in with username "tinhadmin", password "123123", and otp "000000"
    When User clicks on account dropdown
    And User selects Change Password option
    And User inputs Current Password "123123"
    And User inputs New Password "   123"
    And User inputs Confirm New Password "   123"
    And User clicks Change Password button
    Then Display error message below New Password "Password must not have spaces."


  @ChangePassword_006 @Medium
  Scenario: Change password fail due to current password empty
    Given User is logged in with username "tinhadmin", password "123123", and otp "000000"
    When User clicks on account dropdown
    And User selects Change Password option
    And User inputs Current Password ""
    And User inputs New Password "123456"
    And User inputs Confirm New Password "123456"
    And User clicks Change Password button
    Then Display error message below Current Password "Please enter your current password."


  @ChangePassword_007 @Medium
  Scenario: Change password fail due to new password empty
    Given User is logged in with username "tinhadmin", password "123123", and otp "000000"
    When User clicks on account dropdown
    And User selects Change Password option
    And User inputs Current Password "123123"
    And User inputs New Password ""
    And User inputs Confirm New Password "123456"
    And User clicks Change Password button
    Then Display error message below New Password "Please enter a new password."


#  @ChangePassword_008 @Low
#  Scenario: Change password fail — new password too long (>255 characters)
#    Given User is logged in with username "tinhadmin", password "123123", and otp "000000"
#    When User clicks on account dropdown
#    And User selects Change Password option
#    And User inputs Current Password "123123"
#    And User inputs New Password "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789ABCDEFGH"
#    And User inputs Confirm New Password "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789ABCDEFGH"
#    And User clicks "Change Password" button
#    Then Display error toast "Username or password invalid"
#    And Display error message below Current Password "Current password is incorrect. Please try again."


  @ChangePassword_009 @High @Smoke
  Scenario: Change password successfully — new password exactly 6 characters
    Given User is logged in with username "tinhadmin", password "123123", and otp "000000"
    When User clicks on account dropdown
    And User selects Change Password option
    And User inputs Current Password "123123"
    And User inputs New Password "Â1234@"
    And User inputs Confirm New Password "Â1234@"
    And User clicks Change Password button
    Then Display change password success toast "Change password successfully!"
    And User logs out
    And User logs in again with username "tinhadmin", password "Â1234@", and otp "000000"
    Then Display Home page "AUTO PAYMENT TOOL"


  @ChangePassword_010 @Medium @Smoke
  Scenario: Change password again with new password — success
    Given User is logged in with username "tinhadmin", password "Â1234@", and otp "000000"
    When User clicks on account dropdown
    And User selects Change Password option
    And User inputs Current Password "Â1234@"
    And User inputs New Password "123123"
    And User inputs Confirm New Password "123123"
    And User clicks Change Password button
    Then Display change password success toast "Change password successfully!"
    And User logs out
    And User logs in again with username "tinhadmin", password "123123", and otp "000000"
    Then Display Home page "AUTO PAYMENT TOOL"