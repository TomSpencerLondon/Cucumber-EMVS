package entities;

public class Product {
  private final String productScheme;
  private final String productCode;
  private final String productName;

  public Product(String productScheme, String productCode, String productName) {
    this.productScheme = productScheme;
    this.productCode = productCode;
    this.productName = productName;
  }
}
