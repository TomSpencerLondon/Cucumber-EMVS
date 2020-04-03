Feature: verify Pack exists
  verifies that Pack exists

  Background:
    Given Product exists in system
      | productCode    | productScheme | productName | productState |
      | 12345678901231 | GTIN          | Ibuprofen   | active       |
    And Batch exists with active pack in system
      | productCode    | productSchema | batchStatus | batchId | packSerialNumber | packStatus | expiryDate |
      | 12345678901231 | GTIN          | active      | 123     | 456              | active     | 02/02/2020 |
    # delete productName as not needed
  Scenario: If Pack exists when Dispenser verify it returns Pack state
    When Dispenser asks for verification
      | productCode | productScheme | batchID | expiryDate | packSerialNumber | productName |
      | 12345678901231 | GTIN       | 123     | 02/02/2020 | 456              | Ibuprofen   |
    Then NBS responds with Pack state "active"