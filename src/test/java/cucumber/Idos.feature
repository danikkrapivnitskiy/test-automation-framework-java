Feature: Test scenario for given information of the trip between Prague and Brno

  Background: Initialize the browser
    Given Open the page "https://www.idos.cz/"

    Scenario: Verify correct date and time and give information about the trip
      When Search destination from 'Praha' to 'Brno'
      And Verify date and time
      Then Give information about the trip