package domain;

import entities.product.Product;
import entities.product.ProductCode;
import entities.product.ProductRepository;

public class ProductService {
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product retrieve(ProductCode productCode) {
        return productRepository.findByProductCode(productCode);
    }
}
