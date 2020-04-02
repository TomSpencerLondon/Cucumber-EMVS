package org.example;

import entities.Batch;
import entities.Product;

import java.util.ArrayList;
import java.util.List;

public class ScenarioContext {
  static List<Product> products = new ArrayList<>();
  static List<Batch> batches = new ArrayList<>();

  public static void createProduct(String productScheme, String productCode, String productName) {
    products.add(new Product(productScheme, productCode, productName));
  }

  public static void createBatch(String batchID, String productScheme, String productCode) {
  }
}
