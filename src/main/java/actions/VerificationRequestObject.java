package actions;

import java.time.LocalDate;

public class VerificationRequestObject {

  public final String productCode;
  public final String productScheme;
  public final String batchId;
  public final LocalDate expiryDate;
  public final String packSerialNumber;
  public final String productName;

  public VerificationRequestObject(String productCode, String productScheme, String batchId, LocalDate expiryDate,
      String packSerialNumber, String productName) {
    this.productCode = productCode;
    this.productScheme = productScheme;
    this.batchId = batchId;
    this.expiryDate = expiryDate;
    this.packSerialNumber = packSerialNumber;
    this.productName = productName;
  }
}
