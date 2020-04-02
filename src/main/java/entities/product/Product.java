package entities.product;

public class Product {
  private String state;
  private final String scheme;
  private final String code;
  private final String name;

  public Product(String state, String scheme, String code, String name) {
    this.state = state;
    this.scheme = scheme;
    this.code = code;
    this.name = name;
  }

  public ProductState getState() {
    throw new UnsupportedOperationException();
  }
}
