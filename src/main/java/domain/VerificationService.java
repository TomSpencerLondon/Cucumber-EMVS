package domain;

import actions.VerificationRequestObject;
import entities.pack.PackState;

public class VerificationService {

  public VerificationService(ProductService productService, PackService packService) {


  }

  public PackState verify(VerificationRequestObject requestObject) {
    // product = productService.retrieve(product code)
    // check (and maybe return) product state
    //
    // batch packservice.retrieve(batch id)
    // check (and maybe return) batch state
    //
    // return batch.getpack(serial).state
    throw new UnsupportedOperationException("Implement me!");
  }
}
