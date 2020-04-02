package domain;

import actions.VerificationRequestObject;
import entities.batch.Batch;
import entities.pack.Pack;
import entities.pack.PackState;
import entities.product.Product;

public class VerificationService {

  private final ProductService productService;
  private final PackService packService;

  public VerificationService(ProductService productService, PackService packService) {
    this.productService = productService;
    this.packService = packService;
  }

  public PackState verify(VerificationRequestObject requestObject) {
    Product product = productService.retrieve(requestObject.productCode);
    Batch batch = packService.retrieve(requestObject.batchId, product.getProductCode());
    Pack pack = batch.getPackBySerial(requestObject.packSerialNumber);
    return pack.getState();
  }
}
