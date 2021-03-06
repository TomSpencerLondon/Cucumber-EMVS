package entities.product;

public enum ProductState {
    ACTIVE("active");

    public final String value;

    ProductState(String value) {
        this.value = value;
    }

    public static ProductState fromString(String value) {
        return ProductState.valueOf(value.toUpperCase());
    }
}
