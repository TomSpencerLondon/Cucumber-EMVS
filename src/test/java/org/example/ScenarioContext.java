package org.example;

import actions.ProductAggregate;
import actions.VerificationResponseObject;
import entities.Batch;
import entities.Pack;
import entities.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ScenarioContext {
  static List<Product> products = new ArrayList<>();
  static List<Batch> batches = new ArrayList<>();
  public static VerificationResponseObject verificationResponseObject;

  public static void createProduct(String productScheme, String productCode, String productName) {
    products.add(new Product(productScheme, productCode, productName));
  }

  public static void createBatch(String batchID, String productScheme, String productCode, String packSerialNumber, String packState) {
    batches.add(new Batch(batchID, productScheme, productCode, Collections.singletonList(new Pack(packSerialNumber, packState))));
  }

  public static void captureResponse(VerificationResponseObject response) {
    verificationResponseObject = response;
  }
}
