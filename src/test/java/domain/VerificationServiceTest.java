package domain;

import actions.VerificationRequestObject;
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
        ProductCode productCode = new ProductCode("12345678901231", "GTIN");
        String batchId = "123";
        String packSerial = "456";
        VerificationRequestObject requestObject = new VerificationRequestObject(productCode, batchId,
                LocalDate.of(2020, 1, 1), packSerial, "Ibuprofen");

        given(productService.retrieve(productCode)).willReturn(product);
        given(product.getProductCode()).willReturn(productCode);
        given(packService.retrieve(batchId, productCode)).willReturn(batch);
        given(batch.getPackBySerial(packSerial)).willReturn(pack);
        given(pack.getState()).willReturn(PackState.ACTIVE);

        VerificationService verificationService = new VerificationService(productService, packService);
        PackState state = verificationService.verify(requestObject);

        assertEquals(PackState.ACTIVE, state);
    }
}