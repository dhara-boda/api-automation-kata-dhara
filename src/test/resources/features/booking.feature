@booking
Feature: Booking API
  Background:
    Given the booking service is available

  @create @smoke
  Scenario: Create booking
    When Create booking
    Then Verify status 200
    And Verify payload

  @get @regression
  Scenario: Get all bookings
    Given Get all bookings
    Then Verify status 200

  @delete @regression
  Scenario: Delete booking
    Given Create booking
    When I delete the booking
    Then the booking should not be retrievable

  @create @invalid
  Scenario: Create booking with missing required fields
    When I create a booking with missing firstname
    Then Verify status 400

  @create @invalid
  Scenario: Create booking with invalid data types
    When I create a booking with invalid totalprice type
    Then Verify status 400

  @create @invalid
  Scenario: Create booking with invalid booking dates
    When I create a booking with checkout before checkin
    Then Verify status 400

  @delete @negative
  Scenario: Delete non-existent booking
#    Given I attempt to delete booking id 99999
    When I delete the booking
    Then Verify status 404