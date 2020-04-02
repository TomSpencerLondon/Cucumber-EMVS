package entities.pack;

public enum PackState {
  ACTIVE("active");

  public final String value;

  PackState(String value) {
    this.value = value;
  }

  public static PackState fromString(String value) {
    return PackState.valueOf(value.toUpperCase());
  }
}
