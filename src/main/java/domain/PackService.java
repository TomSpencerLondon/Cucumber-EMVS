package domain;

import entities.batch.Batch;
import entities.batch.BatchPackRepository;
import entities.product.ProductCode;

public class PackService {
    private BatchPackRepository batchPackRepository;

    public PackService(BatchPackRepository batchPackRepository) {
        this.batchPackRepository = batchPackRepository;
    }

    public Batch retrieve(String batchId, ProductCode productCode) {
        return batchPackRepository.findByBatchIdAndProductCode(batchId, productCode);
    }
}
