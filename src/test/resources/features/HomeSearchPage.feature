#Author: mashastrohanova@gmail.com

@BAT
Feature: Home Search
	I want to search homes by using filters
	
Scenario: When I change beds filter, only homes that satisfy search criteria are displayed
	Given I am on the start page
	And I navigate to "HOME SEARCH" page
	When I set "bed" filter to be "4 +"
	Then I should see homes which have "4" and more bedrooms