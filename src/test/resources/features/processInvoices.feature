Feature: Processing Invoices
  As a admin user
  I want to continue processing the invoices stuck by auto

  @Medium
  Scenario: Change status failed from Processing to invalid status
    Given User is logged in with username "admin", password "admin", and otp "000000"
    And User is on Invoice Management page
    And Prepare invoice "invoice id"
    When Filter invoice id
    And Click Invoice History icon
    Then The following status change options are invisible:
      | Status Target        | Expected Behavior               |
      | In Queue             | Change Status icon is invisible |
      | Processing           | Change Status icon is invisible |
      | In Review            | Change Status icon is invisible |
      | Completed            | Complete button is invisible    |
      | Cancelled            | Cancel button is invisible      |
      | Cancelled (Reset)    | Reset Owner button is invisible |

  @High
  Scenario: Change status successfully from Processing to Need Review
    When Filter invoice id
    And Click Emergency icon
    Then Show toast "Update successfully"
    And Reload Invoice page
    And Ticket status = Need Review (reason: Unknown transaction)
    And Status on Refund = Pending