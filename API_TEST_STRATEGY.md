# API Test Strategy – Booking API Kata

## Purpose

This document explains the **test approach, scope, and rationale** behind the API test framework created for this kata.  
It is intended to support **technical discussions during interviews** and to clarify the reasoning behind test and design decisions.

## Scope

### In Scope

- Booking API
- Create, Update, and Delete booking positive negative scenarios 
- Data validation of booking responses
- Configuration-driven execution

### Out of Scope (by Design)

- Full authentication flows
- Performance and load testing
- Exhaustive negative testing

> The focus is on demonstrating **how tests are selected**, not achieving full coverage.

---

## Tools & Design Choices

- **Java + Rest-Assured** for readable and maintainable API tests
- **Cucumber (BDD)** to clearly express test intent
- **Property and configuration files** to avoid hardcoding and support multiple environments
- **Client-based design** to separate API interaction from test logic

This structure reflects **common enterprise testing practices** and supports long-term maintainability.

## Test Scenarios & Rationale

### Create Booking (Scenario Outline)

- Validates the **core business capability**
- Uses external Json file and gson library to demonstrate data-driven testing
- Verifies booking creation and returned booking details


### Delete Booking

- Validates booking removal
- Ensures deleted bookings cannot be retrieved

### Negative Scenarios

- Some invalid cases are intentionally commented out
- This demonstrates awareness of negative testing while keeping the kata focused and concise

---

## Assertions Strategy

Assertions focus on:

- HTTP status codes
- Key business-relevant fields
- Consistency across create, update, and delete operations

Over-assertion is deliberately avoided to keep tests **stable, meaningful, and maintainable**.

---

## Git & Delivery Approach

- Incremental commits showing the evolution of the framework
- Clear separation between setup, test logic, and documentation

This mirrors **real-world development practices** in collaborative teams.

## Summary

This framework demonstrates:

- Practical API testing skills
- Clean and maintainable design
- Thoughtful test selection and prioritization

The emphasis is on **clarity, reasoning, and structure**, rather than test volume.
