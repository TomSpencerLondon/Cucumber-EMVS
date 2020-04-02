package actions;

import entities.product.Product;
import entities.product.ProductCode;

import java.time.LocalDate;

public class VerificationRequestObject {

  public final ProductCode productCode;
  public final String batchId;
  public final LocalDate expiryDate;
  public final String packSerialNumber;
  public final String productName;

  public VerificationRequestObject(ProductCode productCode, String batchId, LocalDate expiryDate,
                                   String packSerialNumber, String productName) {
    this.productCode = productCode;
    this.batchId = batchId;
    this.expiryDate = expiryDate;
    this.packSerialNumber = packSerialNumber;
    this.productName = productName;
  }

}
