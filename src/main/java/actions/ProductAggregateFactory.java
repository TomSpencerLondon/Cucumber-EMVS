package actions;

import entities.Batch;
import entities.Pack;
import entities.Product;
import entities.ProductAggregate;
import java.util.Collections;

public class ProductAggregateFactory {

  public ProductAggregate create(VerificationRequestObject requestObject) {
    Product product = new Product(requestObject.productScheme, requestObject.productCode, requestObject.productName);

    Batch batch = new Batch(requestObject.batchId, requestObject.productScheme, requestObject.productCode,
        Collections.singletonList(
            new Pack(requestObject.packSerialNumber)),
        requestObject.expiryDate);

    return new ProductAggregate(product, batch);

  }
}
