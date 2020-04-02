package acceptance;

import actions.VerificationResponseObject;
import domain.BatchState;
import entities.Batch;
import entities.pack.Pack;
import entities.pack.PackState;
import entities.product.Product;
import entities.product.ProductCode;
import entities.product.ProductState;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ScenarioContext {

  public static final int yearAppender = 1;
  static List<Product> products = new ArrayList<>();
  static List<Batch> batches = new ArrayList<>();
  public static VerificationResponseObject verificationResponseObject;

  public static void createProduct(String productState, String productScheme, String productCode, String productName) {
    ProductCode code = new ProductCode(productScheme, productCode);
    products.add(new Product(ProductState.fromString(productState), code, productName));
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
