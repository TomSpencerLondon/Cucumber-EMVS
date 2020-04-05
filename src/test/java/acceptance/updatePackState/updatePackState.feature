Feature: update PackState
  updates state on existing Pack

  Background:
    Given Product exists in system
      | productCode    | productScheme | productName | productState |
      | 12345678901231 | GTIN          | Ibuprofen   | active       |
    And Batch exists with active pack in system
      | productCode    | productSchema | batchStatus | batchId | packSerialNumber | packStatus | expiryDate |
      | 12345678901231 | GTIN          | active      | 123     | 456              | active     | 02/02/2020 |
    # delete productName as not needed
  Scenario: Pack state can be updated to supplied
    When Dispenser changes current pack state
      | productCode    | productScheme | batchID | expiryDate | packSerialNumber | desiredState |
      | 12345678901231 | GTIN          | 123     | 02/02/2020 | 456              | supplied     |
    Then NBS responds with new Pack state "supplied"