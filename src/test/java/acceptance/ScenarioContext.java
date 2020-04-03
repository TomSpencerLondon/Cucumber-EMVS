package acceptance;

import actions.update_pack_state.UpdateStatePackResponseObject;
import actions.VerificationResponseObject;
import entities.batch.Batch;
import entities.batch.BatchPackRepository;
import entities.batch.BatchState;
import entities.batch.InMemoryBatchPackRepository;
import entities.pack.Pack;
import entities.pack.PackState;
import entities.product.*;

import java.time.LocalDate;
import java.util.Collections;

public class ScenarioContext {

  public static final int yearAppender = 1;
  public static VerificationResponseObject verificationResponseObject;
  public static BatchPackRepository batchPackRepository = new InMemoryBatchPackRepository();
  protected static ProductRepository productRepository = new InMemoryProductRepository();
  protected static UpdateStatePackResponseObject updatePackStateResponseObject;

  public static void createProduct(String productState, String productScheme, String productCode, String productName) {
    ProductCode code = new ProductCode(productCode, productScheme);
    productRepository.save(new Product(ProductState.fromString(productState), code, productName));
  }

  public static void createBatch(String batchState, String batchID, String productScheme, String productCode, String packSerialNumber,
                                 String packState) {
    batchPackRepository.save(new Batch(BatchState.fromString(batchState), batchID, new ProductCode(productCode, productScheme), Collections.singletonList(
            new Pack(packSerialNumber, PackState.fromString(packState))),
        oneYearFromNow()));
  }

  private static LocalDate oneYearFromNow() {
    return LocalDate.of(LocalDate.now().getYear() + yearAppender, 1, 1);
  }

  public static void captureResponse(VerificationResponseObject response) {
    verificationResponseObject = response;
  }

  public static void captureUpdatePackStateResponse(UpdateStatePackResponseObject response){
    updatePackStateResponseObject = response;
  }
}
