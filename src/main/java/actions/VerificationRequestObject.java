package actions;

import java.time.LocalDate;

public class VerificationRequestObject {

  private final String productCode;
  private final String productScheme;
  private final String batchId;
  private final LocalDate expiryDate;
  private final String packSerialNumber;

  public VerificationRequestObject(String productCode, String productScheme, String batchId, LocalDate expiryDate,
      String packSerialNumber) {
    this.productCode = productCode;
    this.productScheme = productScheme;
    this.batchId = batchId;
    this.expiryDate = expiryDate;
    this.packSerialNumber = packSerialNumber;
  }
}
