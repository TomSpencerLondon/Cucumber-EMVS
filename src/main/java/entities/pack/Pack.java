package entities.pack;

public class Pack {

  public final String serialNumber;
  private PackState state;

  public Pack(String serialNumber, PackState state) {
    this.serialNumber = serialNumber;
    this.state = state;
  }

  public PackState getState() {
    return state;
  }
}
