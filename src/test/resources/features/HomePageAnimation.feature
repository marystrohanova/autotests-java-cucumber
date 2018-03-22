#Author: mashastrohanova@gmail.com

@BAT
Feature: Home Page Animation

Scenario: Page header gets dispayed when I access home page
	Given I am on the start page
	Then I should see name of agent displayed
	
Scenario: When I scrool down to 2nd section properties slider appears
	Given I am on the start page
	When I scroll to "Featured" section
	And I hover the cursor on the section
	Then I should see properties slider displayed
