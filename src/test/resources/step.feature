Feature: Create Loan for a client

  Scenario Outline: Creating a loan for a client
    Given user logged in to the website
    When user navigate to the Clients menu and select "<Client Menu>"
    And user open the create client and fills the details "<Legal Form>" , "<first name>","<Mobile>","<Gender>","<Client Type>","<family first name>","<Relationship>","<AddressType>","<street>"
    And user activates the client 
    And user creates new client and fills the form "<Product>" , "<Loan_Account_Type>" ,"<Repayment mode>"
    And user fill in mandatory values on the "Terms" page:
      | Principal                   |                                          15000 |
      | Loan Term                   |                                             42 |
      | Number of repayments        |                                             21 |
      | Repaid every Month          |                                              2 |
      | Repaid every day 1          | first                                          |
      | Repaid every day 2          | SUNDAY                                         |
      | Nominal interest rate       | 8                                              |
      | Amortization                | Equal installments                             |
      | Interest calculation period | Same as repayment period                       |
      | Broken Period Interest      | BPI collected in addition to first installment |
      | Repayment strategy          | Early Repayment Strategy                       |
    And user navigate through lenders "<lenders_name>" and charges page
    And user review the loan summary "<loan_status>"
    Then the loan should be created successfully  "<loan_status1>"

    Examples: 
      | Client Menu | Legal Form | first name | Mobile     | Gender    | Client Type | family first name | Relationship | AddressType | street |  Product       | AccountType | Repayment mode |  lenders_name | loan_status                    | loan_status1 |
      | Client      | PERSON     | Manikandan | 6111111807 | number:51 | Merchant    | selvam            | Father       | Current     | amd    |  Personal loan | number:207  | Cash/Cheque    |    saa        | Submitted and pending approval | Approved     |
