package entities.product;

import entities.product.Product;
import entities.product.ProductCode;
import entities.product.ProductRepository;

public class InMemoryProductRepository implements ProductRepository {
    public Product findByProductCode(ProductCode productCode) {
        throw new UnsupportedOperationException();
    }
}
