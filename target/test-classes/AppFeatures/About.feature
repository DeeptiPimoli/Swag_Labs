 #Author: deepti.pimoli@capgemini.com
Feature: View about SauceLabs
 
 @about
	Scenario: Viewing about page
	    Given The user is on SwagLabs home page
	    When user clicks on Hamburger menu
	    And user click on about option
	    Then user should be on About Page
	    And user closes the browser