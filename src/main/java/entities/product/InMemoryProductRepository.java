package entities.product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class InMemoryProductRepository implements ProductRepository {
    private List<Product> products;

    public InMemoryProductRepository() {
        products = new ArrayList<>();
    }

    public Product findByProductCode(ProductCode productCode) {
        Optional<Product> product = products.stream().filter(byProductCode(productCode)).findAny();
        if (product.isPresent()) {
            return product.get();
        }

        throw new UnsupportedOperationException();
    }

    private Predicate<Product> byProductCode(ProductCode productCode) {
        return p -> p.getProductCode().isEquals(productCode);
    }

    public void save(Product product) {
        products.add(product);
    }
}
