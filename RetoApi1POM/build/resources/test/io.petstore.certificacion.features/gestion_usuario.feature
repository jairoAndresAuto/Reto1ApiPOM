#languaje:en
  ## Author:jairo andres garcia - jairo_garcia82122@elpoli.edu.co

Feature: As aproduct owner
  I want to post a new user
  To verify if it is created

  Background:
    Given the user verify internet connection

  @case1
  Scenario: Post user successfully
    When the user creates a new client
    Then verify status code 200

  @case2
  Scenario: Get user by UserName
    When the user by query username
    Then verify nombre apellido y email

  @case3
  Scenario: Update user by UserName
    When the user queries by username and submit request with changes in name
    Then verify uptade successfully

  @case4
  Scenario: Delete user
    When user enter username you want to delete
    Then verify delete successfully