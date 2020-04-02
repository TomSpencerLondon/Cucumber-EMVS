package acceptance;

import actions.VerificationResponseObject;
import entities.batch.BatchState;
import entities.batch.Batch;
import entities.pack.Pack;
import entities.pack.PackState;
import entities.product.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

public class ScenarioContext {

  public static final int yearAppender = 1;
  static List<Batch> batches = new ArrayList<>();
  public static VerificationResponseObject verificationResponseObject;
  protected static ProductRepository productRepository = new InMemoryProductRepository();

  public static void createProduct(String productState, String productScheme, String productCode, String productName) {
    ProductCode code = new ProductCode(productScheme, productCode);
    productRepository.save(new Product(ProductState.fromString(productState), code, productName));
  }

  public static void createBatch(String batchState, String batchID, String productScheme, String productCode, String packSerialNumber,
                                 String packState) {
    batches.add(new Batch(BatchState.fromString(batchState), batchID, productScheme, productCode, Collections.singletonList(
            new Pack(packSerialNumber, PackState.fromString(packState))),
        oneYearFromNow()));
  }

  private static LocalDate oneYearFromNow() {
    return LocalDate.of(LocalDate.now().getYear() + yearAppender, 1, 1);
  }

  public static void captureResponse(VerificationResponseObject response) {
    verificationResponseObject = response;
  }
}
