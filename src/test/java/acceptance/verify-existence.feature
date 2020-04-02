Feature: verify Pack exists
  verifies that Pack exists

  Background:
    Given "active" Product exists "GTIN" "12345678901231" "Ibuprofen"
    And "active" Batch exists "123" for product "GTIN" "12345678901231" with "active" Pack "456"

  Scenario: If Pack exists when Dispenser verify it returns Pack state
    When Dispenser asks for verification
    Then NBS responds with Pack state "active"