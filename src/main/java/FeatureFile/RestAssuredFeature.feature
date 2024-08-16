
Feature: Rest Assured feature
 


  Scenario: Verify that user get all the data in list
    Given user have the base URL
    Then i want the response
    Then status code verify 
    Then user got response data
    Then get all Headers
    
    Scenario Outline: Verify that user is able to post multiple data
    Given Register payload with "<name>" and "<job>"
    Then user set request as post
    Then verify status code  
    Then user got response data
    Then get all Headers
    
    
    Examples:
    | name | job | 
    | akash  | testing  | 
    | Krishna  | QA  | 
    | Peter  | Java Developer  | 
    