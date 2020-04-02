package entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Batch {

  private final String batchID;
  private final LocalDate expiryDate;
  private List<Pack> packs;

  public Batch(String batchID, String productScheme, String productCode, List<Pack> packs, LocalDate expiryDate) {
    this.packs = packs;
    this.batchID = batchID;
    this.expiryDate = expiryDate;
  }

  public String getId() {
    return batchID;
  }

  public LocalDate getExpiryDate() {
    return expiryDate;
  }

  public String getPackBySerialNumber(String serialNumber) {
    Optional<Pack> first = packs.stream().filter(p -> p.packSerialNumber.equals(serialNumber)).findFirst();
    if(first.isPresent()){
      return first.get().packSerialNumber;
    }
    throw new UnsupportedOperationException();
  }

}
