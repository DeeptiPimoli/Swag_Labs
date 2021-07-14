#Author: deepti.pimoli@capgemini.com
Feature: View Pricing
			
			@Pricing
		 Scenario Outline: Custom Enterprise Pricing
			Given user should be On About HomePage
			When user clicks Pricing options
			Then user should be able to view various Pricing
			And user clicks on Custom Enterprise Pricing link
			Then user should be on Custom Enterprise Pricing page
	    When user enter the FirstName as "<FirstName>"
	    And user enter the LastName as "<LastName>"
	    And user enter Company "<Company>"
	    And user enter Business Email as "<BusinessEmail>"
	    And user enter Phone number as "<PhNo>"
	    And user select Intrest "<Intrest>"
	    And user enter Comments "<Comments>"
	    And user click Privacy policy 
	    Then user click submit button
	    And user should get Thanks for submitting your request!
	    And user Closes The Browser
	    
	Examples: 
  
  | FirstName | LastName |  Company     |       BusinessEmail         |   PhNo     |      Intrest          | Comments  | 
  |  Deepti   |  Pimoli  | Capgemini    | deeptipimoli23@gmail.com    | 7204424260 | Cross-browser Testing | Intrested |  