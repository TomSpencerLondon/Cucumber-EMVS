package entities.batch;

import entities.pack.Pack;

import java.time.LocalDate;
import java.util.List;

public class Batch {

  private final String id;
  private final LocalDate expiryDate;
  private BatchState state;
  private final String productScheme;
  private final String productCode;
  private List<Pack> packs;

  public Batch(BatchState state, String id, String productScheme, String productCode, List<Pack> packs, LocalDate expiryDate) {
    this.state = state;
    this.productScheme = productScheme;
    this.productCode = productCode;
    this.packs = packs;
    this.id = id;
    this.expiryDate = expiryDate;
  }

  public BatchState getState() {
    return state;
  }

  public Pack getPackBySerial(String serial) {
    throw new UnsupportedOperationException();
  }
}
