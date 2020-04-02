package domain;

import entities.batch.Batch;
import entities.batch.BatchPackRepository;
import entities.product.ProductCode;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class PackServiceTest {
    @Mock private BatchPackRepository batchPackRepository;
    @Mock private Batch batch;

    @Test
    void should_retrieve_batch_by_batch_id_and_product_code() {
        PackService packService = new PackService(batchPackRepository);
        ProductCode productCode = new ProductCode("12345678901231", "GTIN");
        String batchId = "123";
        given(batchPackRepository.findByBatchIdAndProductCode(batchId, productCode)).willReturn(batch);

        Batch actualBatch = packService.retrieve(batchId, productCode);
        assertEquals(batch, actualBatch);
    }
}