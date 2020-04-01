Feature: verify Pack exists
  verifies that Pack exists

  Background:
    Given Product exists "GTIN" "12345678901231" "Ibuprofen"
    Given Batch exists "123" for product "GTIN" "12345678901231"

  Scenario: If Pack exists when Dispenser verify it returns Pack state
    Given Pack "456" exists for Batch "123"
    When Dispenser asks for verification
    Then NBS responds with Pack state