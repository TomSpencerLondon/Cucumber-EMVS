package entities.product;

public interface ProductRepository {
    Product findByProductCode(ProductCode productCode);

    void save(Product product);
}
