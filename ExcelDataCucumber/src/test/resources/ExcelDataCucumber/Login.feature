#Author: khanh.tx@live.com

Feature: Check Login function with data read from Excel file

  Scenario Outline: Show message when provide invalid data which stored in excel file
    Given I am staying login page
    When I input data from excel file on <row>
    Then I should see the corresponding message from each <row>
    
    Examples: 
      | row  	| 
      | 1 		| 
      | 2 		| 
