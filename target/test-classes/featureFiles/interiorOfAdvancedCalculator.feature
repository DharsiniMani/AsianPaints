Feature: Interior of Advanced Calculator in Paint Budget Calculator
In the Advanced Calculator enter the valid values in Carpet Area Text box
@IAC
Scenario: Enter Advanced Calculator with valid credentials

Given open an Asian Paints Application in any Browser
And Navigate to Paint Budget Calculator page
And click the Advanced Calculator
When enter with valid values in all fields
And click the calculate now button
Then verify Recommended Product with description quantity required and estimated product cost are displayed

@IAC
Scenario Outline: Enter Interior of Advanced Calculator with invalid credentials

Given open an Asian Paints Application in any Browser
And Navigate to Paint Budget Calculator page
And click the Advanced Calculator
When enter with "<width>"  "<length>" "<height>" "<noOfWindows>" "<noOfDoors>" "<wallA>" "<wallB>""<wallC>" "<wallD>" "<ceiling>" "<paintProduct>""<textureProduct>""<wallPaperProduct>" invalid values in all fields
And click the calculate now button
Then verify the error message is displayed in the top of the box and respective fields

Examples:
|width  |length |height |noOfWindows |noOfDoors |wallA |wallB|wallC |wallD |ceiling |paintProduct|textureProduct|wallPaperProduct|
|qee|swq|ws|wqs|wqssa|paint|paint|paint|paint|yes|Apocolite|Premium|Economy|
|sW$35|sz$%5|sS@2|Fve@34|DGT$%|texture|wallpaper|texture|wallpaper|no|Royale|Premium|Premium|
