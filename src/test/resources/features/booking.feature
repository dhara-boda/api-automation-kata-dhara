Feature: Booking API
  Background:
    Given the booking service is available

  Scenario: Create booking
    When Create booking
    Then Verify status 200
    And Verify payload

  Scenario: Get all bookings
    Given Get all bookings
    Then Verify status 200

  Scenario: Delete booking
    Given Create booking
    When I delete the booking
    Then the booking should not be retrievable