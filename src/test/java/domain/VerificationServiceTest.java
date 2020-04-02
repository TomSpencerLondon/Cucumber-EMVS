package domain;

import actions.VerificationRequestObject;
import entities.Batch;
import entities.pack.Pack;
import entities.product.Product;
import entities.pack.PackState;
import entities.product.ProductState;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class VerificationServiceTest {
    @Mock private ProductService productService;
    @Mock private PackService packService;
    @Mock private Product product;
    @Mock private Batch batch;
    @Mock private Pack pack;

    @Test
    void should_retrieve_product_and_pack_and_return_pack_state() {
        String productCode = "12345678901231";
        String batchId = "123";
        String packSerial = "456";
        VerificationRequestObject requestObject = new VerificationRequestObject(productCode, "GTIN", batchId,
                LocalDate.of(2020, 1, 1), packSerial, "Ibuprofen");

        given(productService.retrieve(productCode)).willReturn(product);
        given(packService.retrieve(batchId)).willReturn(batch);
        given(batch.getPackBySerial(packSerial)).willReturn(pack);
        given(pack.getState()).willReturn(PackState.ACTIVE);

        VerificationService verificationService = new VerificationService(productService, packService);
        PackState state = verificationService.verify(requestObject);

        assertEquals(PackState.ACTIVE.value, state.value);
    }
}