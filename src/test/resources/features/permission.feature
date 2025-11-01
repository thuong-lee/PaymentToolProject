@Permission @Smoke
Feature: Permission and Role Management

  @Permission_001 @Medium
  Scenario: Verify admin can view all menus after login
    Given User is on Login page
    When User logs in with valid admin credentials
    Then The following menus should be visible:
      | Menu Name              |
      | Role and Permission    |
      | User Management        |
      | Device Group           |
      | Error Report           |
      | Device Management      |
      | Accounts Management    |
      | Deposit Management     |
      | Invoice Management     |
      | Bank Management        |
      | Setting                |
      | Change Status History  |
      | Version Management     |

  @Permission_002 @Low
  Scenario: Verify normal user can only view allowed menus after login
    Given User is on Login page
    When User logs in with valid user credentials
    Then The following menus should be visible:
      | Menu Name           |
      | Device Management   |
      | Deposit Management  |
      | Invoice Management  |
      | Change Password     |
    And The following menus should not be visible:
      | Menu Name              |
      | Role and Permission    |
      | User Management        |
      | Version Management     |
      | Accounts Management    |

  @Permission_003 @High
  Scenario: Verify user cannot access admin-only menu via direct URL
    Given User is on Login page
    When User logs in with valid user credentials
    And User navigates directly to "Role and Permission" page URL
    Then User should see access denied message "You do not have permission to access this page"
    And User should remain on current page or be redirected to "Home"