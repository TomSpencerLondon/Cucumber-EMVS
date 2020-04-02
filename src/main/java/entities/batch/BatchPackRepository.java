package entities.batch;

import entities.product.ProductCode;

public interface BatchPackRepository {
    Batch findByBatchIdAndProductCode(String batchId, ProductCode productCode);

    void save(Batch batch);
}
