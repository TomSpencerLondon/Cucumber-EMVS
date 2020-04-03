package domain;

import actions.update_pack_state.UpdatePackStateRequestObject;
import entities.batch.Batch;
import entities.pack.Pack;
import entities.pack.PackState;
import entities.product.Product;
import entities.product.ProductCode;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class UpdatePackStateServiceTest {
    @Mock private ProductService productService;
    @Mock private PackService packService;
    @Mock private PackStateTransitionValidator transitionService;
    @Mock private Product product;
    @Mock private Batch batch;
    private Pack pack;

    @Test
    void should_validate_product_batch_pack_and_update_pack_state() {
        ProductCode productCode = new ProductCode("12345678901231", "GTIN");
        String batchId = "123";
        String packSerial = "456";
        pack = new Pack("123", PackState.ACTIVE);
        UpdatePackStateRequestObject requestObject = new UpdatePackStateRequestObject(productCode, batchId,
                LocalDate.of(2020, 1, 1), packSerial, PackState.SUPPLIED);
        UpdatePackStateService updatePackStateService = new UpdatePackStateService(
                productService, packService, transitionService);

        given(productService.retrieve(productCode)).willReturn(product);
        given(product.getProductCode()).willReturn(productCode);
        given(packService.retrieve(batchId, productCode)).willReturn(batch);
        given(batch.getPackBySerial(packSerial)).willReturn(this.pack);

        given(transitionService.isTransitionAllowed(this.pack, PackState.SUPPLIED)).willReturn(true);


        PackState updatedPackState = updatePackStateService.update(requestObject);


        assertEquals(PackState.SUPPLIED, updatedPackState);
    }
}