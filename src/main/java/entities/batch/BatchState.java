package entities.batch;

public enum BatchState {
    ACTIVE("active"),
    EXPIRED("expired"),
    RECALLED("recalled");

    public final String value;

    BatchState(String value) {
        this.value = value;
    }

    public static BatchState fromString(String value) {
        return BatchState.valueOf(value.toUpperCase());
    }
}
