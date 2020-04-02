package entities.product;

public class Product {
    private ProductCode productCode;
    private ProductState state;
    private String name;

    public Product(ProductState state, ProductCode productCode, String name) {
        this.state = state;
        this.productCode = productCode;
        this.name = name;
    }

    public ProductCode getProductCode() {
        return productCode;
    }

    public String getName() {
        return name;
    }

    public ProductState getState() {
        return state;
    }
}
