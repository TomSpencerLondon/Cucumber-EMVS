package domain;

import entities.product.ProductState;

public enum BatchState {
    ACTIVE("active");

    public final String value;

    BatchState(String value) {
        this.value = value;
    }

    public static BatchState fromString(String value) {
        return BatchState.valueOf(value.toUpperCase());
    }
}
