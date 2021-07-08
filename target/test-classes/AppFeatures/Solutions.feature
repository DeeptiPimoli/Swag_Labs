#Author: deepti.pimoli@capgemini.com

Feature: View Solutions
			
		Background: Common Background Steps
		  Given user should be on About home Page
			When user clicks Solutions options
			Then user should be able to view various solutions
			
		Scenario: Viewing various Solutions
			And user clicks on Enterprise link
			Then user should be on Enterprise page
		  And user should go back to About home page
	    And user clicks Solutions options
			And user clicks on Start-ups & SMB Teams link
			Then user should be on Start-ups & SMB Teams page
	    And user should go back to About home page
	    And user clicks Solutions options
	    And user clicks on Open Source Projects link
			Then user should be on Open Source Projects page
	    And user should go back to About home page
	    And user clicks Solutions options
			And user clicks on Continuous Testing link
			Then user should be on Continuous Testing page
			And user should go back to About home page
	    And user clicks Solutions options
			And user clicks on Automated Testing link
			Then user should be on Automated Testing page
			And user should go back to About home page
	    And user clicks Solutions options
			And user clicks on Live Testing link
			Then user should be on Live Testing page
	    And user Closes the browser