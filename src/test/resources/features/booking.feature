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
