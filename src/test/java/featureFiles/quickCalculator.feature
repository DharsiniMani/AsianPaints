


Feature: Quick Calculator in Paint Budget Calculator
 Enter the valid values in Quick Calculator.
@QC
Scenario: Enter Quick Budget Calculator with valid credentials
Given open the Asian Paints Application in the Browser
And navigate to Paint Budget Calculator page
When valid value in carpet area textbox is entered
And click calculate now button
Then verify Recommended Product with description and estimated product cost are displayed
@QC
Scenario Outline: Enter Quick Calculator with invalid credentials
Given open the Asian Paints Application in the Browser
And navigate to Paint Budget Calculator page
When enter invalid value in "<Carpet>" "<Area>" Text box
And click calculate now button
Then verify error message is displayed

Examples:
|Carpet||Area|
|Carpet||asdx|
|Carpet||-123|
|Carpet||0.46783|
|Carpet||@&*|