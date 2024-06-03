Feature: Test scenario for choosing a book with specific year and verifying an author

  Background: Open the OpenLibrary main page
    Given  User goes to the OpenLibrary page "https://openlibrary.org"

    Scenario: Verify author from API matches author on book page
      And User sets website in 'English'
      When User searches using Title option for book 'The Hobbit'
      And User choose book published in 1937
      And Get author from API for book
      Then Author from API matches author on book page