package entities.batch;

import entities.pack.Pack;
import entities.product.ProductCode;

import java.time.LocalDate;
import java.util.List;

public class Batch {

    public final String id;
    private final LocalDate expiryDate;
    private BatchState state;
    public final ProductCode productCode;
    private List<Pack> packs;

    public Batch(BatchState state, String id, ProductCode productCode, List<Pack> packs, LocalDate expiryDate) {
        this.state = state;
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
