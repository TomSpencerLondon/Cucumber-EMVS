Feature: verify Pack exists
  verifies that Pack exists

  Background:
    Given Product exists in system
      | productCode    | productSchema | productName | productState |
      | 12345678901231 | GTIN          | Ibuprofen   | active       |
      | 12345678901232 | GTIN          | Ibuprofen   | withdrawn    |
    And Packs exists in system
      | productCode    | productSchema | batchID | serialNumber | state |
      | 12345678901231 | GTIN          | 123     | 456          | active    |
      | 12345678901231 | GTIN          | 123     | 457          | supplied  |
    And Batch exists with pack in system
      | productCode    | productSchema | batchState | batchID | expiryDate |
      | 12345678901231 | GTIN          | active     | 123     | 02/02/2020 |

  Scenario: If Pack active when Dispenser verify it returns Pack state
    When Dispenser asks for verification
      | productCode    | productSchema | batchID | expiryDate | packSerialNumber |
      | 12345678901231 | GTIN          | 123     | 02/02/2020 | 456              |
    Then NBS responds with Pack state "active"

  Scenario: If Pack supplied when Dispenser verify it returns Pack state
    When Dispenser asks for verification
      | productCode    | productSchema | batchID | expiryDate | packSerialNumber |
      | 12345678901231 | GTIN          | 123     | 02/02/2020 | 457              |
    Then NBS responds with Pack state "supplied"