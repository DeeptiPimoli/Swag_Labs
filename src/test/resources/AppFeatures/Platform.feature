#Author: deepti.pimoli@capgemini.com

Feature: View Platform in Saucelabs

    Background: Common Background Steps1
		  Given user should be on About Home Page
			When user clicks Platform options
			Then user should be able to view various Platform options
			
		Scenario: Viewing various Platform
			And user clicks on Overview link
			Then user should be on Overview page
		  And user should go back to About Home page
	    And user clicks Platform options
			And user clicks on Mobile Testing link
			Then user should be on Mobile Testing page
	    And user should go back to About Home page
	    And user clicks Platform options
			And user clicks on Cross-browser Testing link
			Then user should be on Cross-browser Testing page
	    And user should go back to About Home page
	    And user clicks Platform options
			And user clicks on API Testing link
			Then user should be on API Testing page
	    And user should go back to About Home page
	    And user clicks Platform options
			And user clicks on Low-code Testing link
			Then user should be on Low-code Testing page
	    And user should go back to About Home page
	    And user clicks Platform options
			And user clicks on Visual Testing link
			Then user should be on Visual Testing page
			And user clicks on End-To-End Testing link
			Then user should be on End-To-End Testing page
	    And user should go back to About Home page
	    And user clicks Platform options
			And user clicks on Supported Integration link
			Then user should be on Supported Integration page
	    And user should go back to About home page
	    And user clicks Platform options
			And user clicks on Browsers & devices link
			Then user should be on Browsers & devices page
	    And user should go back to About Home page
	    And user clicks Platform options
			And user clicks on Sauce Performance link
			Then user should be on Sauce Performance page
	    And user should go back to About Home page
	    And user clicks Platform options
			And user clicks on Sauce Insights link
			Then user should be on Sauce Insights page
	    And user should go back to About Home page
	    And user clicks Platform options
			And user clicks on Extended Debugging link
			Then user should be on Extended Debugging page
	    And user should go back to About Home page
	    And user clicks Platform options
			And user clicks on Selenium link
			Then user should be on Selenium page
	    And user should go back to About Home page
	    And user clicks Platform options
			And user clicks on Espresso link
			Then user should be on Espresso page
	    And user Closes the browser
	    
		
		
		