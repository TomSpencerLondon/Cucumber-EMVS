package entities.batch;

import entities.pack.Pack;
import entities.product.ProductCode;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

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
        Optional<Pack> pack = packs.stream().filter(p ->
                p.serialNumber.equals(serial)
        ).findFirst();

        if (pack.isPresent()) {
            return pack.get();
        }
        throw new UnsupportedOperationException();
    }

}
