package domain;

public enum BatchState {
    ACTIVE("active");

    public final String value;

    BatchState(String value) {
        this.value = value;
    }
}
