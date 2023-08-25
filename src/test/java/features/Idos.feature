Feature: Test scenario for given information of the trip between Prague and Brno

  Background: Initialize the browser
    Given Open the page "https://www.idos.cz/" and search destination from "Praha" to "Brno"

    Scenario: Verify correct date and time
      When Verify list of trips