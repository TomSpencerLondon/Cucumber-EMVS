package entities;

public class ProductAggregate {

  private Product product;
  private Batch batch;

  public ProductAggregate(Product product, Batch batch) {
    this.product = product;
    this.batch = batch;
  }

  public Product getProduct() {
    return product;
  }

  public Batch getBatch() {
    return batch;
  }

}
