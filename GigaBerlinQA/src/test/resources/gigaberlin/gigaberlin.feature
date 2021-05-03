@giga-berlin
  Feature: Giga Berlin
    In order to see the location of Giga Berlin
    I have to run multiple searches on different web pages

  Background:
    Given I am on the Google page

    Scenario: Giga Berlin location
      When I search for wikipedia.org on Google page
      Then I see the Google search result page

      When I click on the upper wikipedia link
      Then I see the Wikipedia page

      # I have a couple of questions for this part
      When I search for Giga Berlin on the Wikipedia page
      Then I see the Giga Berlin page
      Then I see Coordinates of the location
      Then I see Logistics data
      Then I see Site concerns data

      When I click on the mini map on the Giga Berlin page
      Then I see the Google Map page with Giga Berlin location
