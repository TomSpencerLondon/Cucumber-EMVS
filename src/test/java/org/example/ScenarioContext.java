package org.example;

import actions.VerificationResponseObject;
import entities.Batch;
import entities.Pack;
import entities.Product;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ScenarioContext {

  public static final int yearAppender = 1;
  static List<Product> products = new ArrayList<>();
  static List<Batch> batches = new ArrayList<>();
  public static VerificationResponseObject verificationResponseObject;

  public static void createProduct(String productScheme, String productCode, String productName) {
    products.add(new Product(productScheme, productCode, productName));
  }

  public static void createBatch(String batchID, String productScheme, String productCode, String packSerialNumber,
      String packState) {
    batches.add(new Batch(batchID, productScheme, productCode, Collections.singletonList(new Pack(packSerialNumber, packState)),
        oneYearFromNow()));
  }

  private static LocalDate oneYearFromNow() {
    return LocalDate.of(LocalDate.now().getYear() + yearAppender, 1, 1);
  }

  public static void captureResponse(VerificationResponseObject response) {
    verificationResponseObject = response;
  }
}
