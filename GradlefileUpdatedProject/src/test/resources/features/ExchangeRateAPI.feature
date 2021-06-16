#Author: Anwesha Dhal
@ExchangeRate
Feature: To verify the exchange rate of all countries
  User wants to see the exchange rate of all countries

  @getAllcountriesExchangeRate
  Scenario Outline: To get the exchange rate of all countries
    Given with the end point URL
    When request send with base code
    Then verify the "<status>" in step

    Examples: 
      | status |
      |    200 |
      
