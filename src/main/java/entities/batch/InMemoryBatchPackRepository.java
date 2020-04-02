package entities.batch;

import entities.product.ProductCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class InMemoryBatchPackRepository implements BatchPackRepository {
    private List<Batch> batches;

    public InMemoryBatchPackRepository() {
        batches = new ArrayList<>();
    }

    public Batch findByBatchIdAndProductCode(String batchId, ProductCode productCode) {
        Optional<Batch> batch = batches.stream().filter(byBatchIdAndProductCode(batchId, productCode)).findAny();
        if (batch.isPresent()) {
            return batch.get();
        }

        throw new UnsupportedOperationException();
    }

    private Predicate<Batch> byBatchIdAndProductCode(String batchId, ProductCode productCode) {
        return b -> b.id.equals(batchId) &&
                b.productCode.isEquals(productCode);
    }

    public void save(Batch batch) {
        batches.add(batch);
    }
}
