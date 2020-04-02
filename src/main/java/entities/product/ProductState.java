package entities.product;

public enum ProductState {
    ACTIVE("active");

    public final String value;

    ProductState(String value) {
        this.value = value;
    }
}
