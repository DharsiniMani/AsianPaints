Feature: Exterior of Advanced Calculator in Paint Budget Calculator
In the Advanced Calculator enter the valid values in Carpet Area Text box
@EAC
Scenario: Enter Advanced Calculator with valid credentials of Exterior
Given open Asian Paints Application in the Browser
And navigate to the Paint Budget Calculator page
And click Advanced Calculator
And select Exterior in Select Space
When valid value in Carpet Area of AC Text box is entered
And click calculate now button of AC
Then verify that Recommended Product with description and estimated product cost are displayed
@EAC
Scenario Outline: Enter Advanced Calculator with invalid credentials of Exterior
Given open Asian Paints Application in the Browser
And navigate to the Paint Budget Calculator page
And click Advanced Calculator
And select Exterior in Select Space
When enter invalid value in "<C>" "<A>" Text box of AC
And click calculate now button of AC
Then verify that error message is displayed
Examples:
|C|A|
|Carpet|asdx|
|Carpet|-123|
|Carpet|0.46783|
|Carpet|@&|

