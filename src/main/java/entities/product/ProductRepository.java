package entities.product;

public interface ProductRepository {
    Product findByProductCode(ProductCode productCode);
}
